package gov.bnm.view.rh.servlet;

//import com.plumtree.remote.portlet.IPortletContext;
//
//import com.plumtree.remote.portlet.NotGatewayedException;
//import com.plumtree.remote.portlet.PortletContextFactory;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.property.PropertyFileConfigManager;

import gov.bnm.view.rh.constant.Constants;

import gov.bnm.view.rh.utils.JSFUtils;

import gov.view.common.validation.ValidatorUtil;

import java.io.IOException;
import java.io.PrintWriter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Properties;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.context.FacesContextFactory;

import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;

import javax.security.auth.login.FailedLoginException;

import javax.security.auth.login.LoginException;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

import org.apache.log4j.Logger;

import weblogic.security.URLCallbackHandler;

import weblogic.servlet.security.ServletAuthentication;

public class PageRedirectServlet extends HttpServlet {

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(PageRedirectServlet.class);
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {

        PropertyFileConfigManager propertyFileConfigManager =
            PropertyFileConfigManager.getInstance();
        Properties props =
            propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION +
                                                    FileUtil.RH_PROP_FILE);
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        String fldTokenId = "";
        String fldPolicyId = "";
        String fldUserId = "";
        String fldUserAction = "";
        String fldPageType = "";
        String enquiryFAQId = "";
        String requestId = "";
        String fldSearchKey = "";
        String webServerPath = "";

//        IPortletContext portletContext = null;
//        try {
//            portletContext =
//                    PortletContextFactory.createPortletContext(request,
//                                                               response);
//            fldUserId = portletContext.getUser().getUserName();
//            log.info("host url : " +
//                     portletContext.getRequest().getHostPageURI());
//            String hostUrl =
//                portletContext.getRequest().getHostPageURI().toString();
//            webServerPath = hostUrl.substring(0, hostUrl.indexOf("/portal"));
//            log.info("Web server pathe : " + webServerPath);
//        } catch (NotGatewayedException e) {
//            log.info("No Gate way : " + e);
//        } catch (Exception e) {
//            log.info("Any other exception .. " + e);
//        }

        if (ValidatorUtil.isNull(fldUserId)) {
            fldUserId = request.getParameter("fldUserId");
        }

        log.info("Came inside to page redirect servelt .. ");
        fldUserAction = request.getParameter("fldUserAction");
        fldPageType = request.getParameter("fldPageType");
        log.info("print user id  :  " + fldUserId);
        log.info("print user id  :  " + fldUserId.contains("\\"));
        if (!fldUserId.contains("\\")) {
            fldUserId = "\\" + fldUserId;
        }

        log.info("print user id  :  " + fldUserId);
        String[] userid = fldUserId.split("\\\\");
        log.info(" userid 0 ::" + userid[0]);
        log.info(" userid 1::" + userid[1]);
        fldUserId = userid[1];
        log.info(" Context path :  " + request.getContextPath());

//        String webServerPath = props.getProperty("rh.webServer.address");
        webServerPath = webServerPath.concat(request.getContextPath());

        log.info("Web Server path Result :  " + webServerPath);

        if (Constants.RH_EMAIL_PAGE.equalsIgnoreCase(fldPageType)) {
            String emailUrlRequestId = null;
            log.info("fldUserAction::" + fldUserAction);
            if (Constants.USER_ACTION_POLICY_ENQUIRY_RESPONSE.equalsIgnoreCase(fldUserAction)) {
                enquiryFAQId = request.getParameter("enquiryFAQId");
                log.info("enquiryFAQId::" + enquiryFAQId);
            } else if (Constants.USER_ACTION_SUPPORT_DOC_REQUEST_DECISION.equalsIgnoreCase(fldUserAction)) {
                requestId = request.getParameter("requestId");
                log.info("requestId::" + requestId);
            } else {
                fldPolicyId = request.getParameter("fldPolicyId");
                log.info("fldPolicyId::" + fldPolicyId);
            }
        } else if (Constants.RH_SEARCH_PAGE.equalsIgnoreCase(fldPageType)) {
            fldSearchKey = request.getParameter("fldSearchKey");
            log.info("fldSearchKey::" + fldSearchKey);
        }


        String authen = Constants.STATUS_FAILURE;
        log.info("  check authen  ... " +
                 ADFContext.getCurrent().getSecurityContext().isAuthenticated());

        if (ADFContext.getCurrent().getSecurityContext().isAuthenticated()) {
            authen = Constants.STATUS_SUCCESS;
        } else {
            //authen = this.doLogin(fldUserId, "abcd12#$", request);
        }

        response.sendRedirect(webServerPath +
                              "/faces/adf.task-flow?adf.tfId=btf_RHMain&adf.tfDoc=/WEB-INF/PageFlows/taskFlow/btf_RHMain.xml&fldTokenId=" +
                              fldTokenId + "&fldPolicyId=" + fldPolicyId +
                              "&fldUserid=" + fldUserId + "&fldUserAction=" +
                              fldUserAction + "&enquiryFAQId=" + enquiryFAQId +
                              "&fldSearchKey=" + fldSearchKey + "&requestId=" +
                              requestId + "&authen=" + authen);

        /*
        FacesContext ctx = getFacesContext(request, response);
        String authen = gov.bnm.view.rh.constant.Constants.STATUS_FAILURE;
        log.info("Before check user authenticated .. ");

        if (ADFContext.getCurrent().getSecurityContext().isAuthenticated()) {
            log.info("Already authenticated User id :  " +
                     ADFContext.getCurrent().getSecurityContext().getUserName() +
                     "   current user id :  " + fldUserId);
            if (ADFContext.getCurrent().getSecurityContext().getUserName().equals(fldUserId)) {
                authen = gov.bnm.view.rh.constant.Constants.STATUS_SUCCESS;
            } else {
                try {
                    HttpSession session =
                        (HttpSession)ctx.getExternalContext().getSession(false);
                    session.invalidate();
                    //request.getSession(false);
                    authen = this.doLogin(fldUserId, "abcd12#$");
                } catch (Exception e) {
                    // TODO: Add catch code
                    log.error("destroy session failed .. ");
                }
            }

        } else {
            authen = this.doLogin(fldUserId, "abcd12#$");
        }


        String loginUrl =
            webServerPath + "/faces/adf.task-flow?adf.tfId=btf_RHMain&adf.tfDoc=/WEB-INF/PageFlows/taskFlow/btf_RHMain.xml&fldTokenId=" +
            fldTokenId + "&fldPolicyId=" + fldPolicyId + "&fldUserid=" +
            fldUserId + "&fldUserAction=" + fldUserAction + "&enquiryFAQId=" +
            enquiryFAQId + "&requestId=" + requestId + "&authen=" + authen;

        ctx.getExternalContext().getResponse();
        response.sendRedirect(loginUrl);

        */

    }

    /**
     * Login security configuration method start
     *
     * */
    public String doLogin(String _username, String _password) {
        String un = _username;
        byte[] pw = _password.getBytes();
        //        _password =
        //                "c6c01a52fa18ba0f998008ece3a30373640b838397963d890789d2efa93d8120";
        //        String pw = _password;
        /*String securePassword = null;
        try {
            String salt = getSalt();
            securePassword =
                    SHAExample.get_SHA_256_SecurePassword(_password, salt);
            log.info(securePassword);
            pw = "abcd12#$".getBytes();
        } catch (NoSuchAlgorithmException e) {
            log.error("hash convertion error .. ");
        }
*/

        FacesContext ctx = JSFUtils.getFacesContext();
        //FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request =
            (HttpServletRequest)ctx.getExternalContext().getRequest();
        try {
            CallbackHandler handler = new URLCallbackHandler(un, pw);
            Subject mySubj =
                weblogic.security.services.Authentication.login(handler);


            weblogic.servlet.security.ServletAuthentication.runAs(mySubj,
                                                                  request);
            ServletAuthentication.generateNewSessionID(request);

            ADFContext adfCtx = ADFContext.getCurrent();
            SecurityContext secCtx = adfCtx.getSecurityContext();
            log.info("Login Authen success ");

            return gov.bnm.view.rh.constant.Constants.STATUS_SUCCESS;
        } catch (FailedLoginException fle) {
            //            FacesMessage msg =
            //                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect Username or Password",
            //                                 "An incorrect Username or Password" +
            //                                 " was specified");
            //            ctx.addMessage(null, msg);
            log.error("authen .. failed " + fle);
            return gov.bnm.view.rh.constant.Constants.STATUS_FAILURE;
            //setPassword(null);
        } catch (LoginException le) {
            //reportUnexpectedLoginError("LoginException", le);
            log.error("authen .. failed " + le);
            return gov.bnm.view.rh.constant.Constants.STATUS_FAILURE;
        } catch (Exception e) {
            log.error("authen .. failed " + e);
            return gov.bnm.view.rh.constant.Constants.STATUS_FAILURE;
        }
        //return Constants.STATUS_SUCCESS;
    }


    /**
     *
     * security salt secureRandom.
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    // security end.....


    /**
     *
     * There have been several posts asking how to get a Faces Context from outside of JSF such as in a servlet. There are many reasons for doing this such as:
       1. Getting to a managed bean in session scope
       2. Getting or setting the current view id
       3. Generating additional content to be displayed in a faces component
       4. Performing authentication and session management
       5. Various other reasons you can come up with...
     *
     * @param request
     * @param response
     * @return
     */
    protected FacesContext getFacesContext(HttpServletRequest request,
                                           HttpServletResponse response) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {

            FacesContextFactory contextFactory =
                (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            LifecycleFactory lifecycleFactory =
                (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
            Lifecycle lifecycle =
                lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

            facesContext =
                    contextFactory.getFacesContext(request.getSession().getServletContext(),
                                                   request, response,
                                                   lifecycle);

            // Set using our inner class
            InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);

            // set a new viewRoot, otherwise context.getViewRoot returns null
            UIViewRoot view =
                facesContext.getApplication().getViewHandler().createView(facesContext,
                                                                          "");
            facesContext.setViewRoot(view);
        }
        return facesContext;
    }

    public void removeFacesContext() {
        InnerFacesContext.setFacesContextAsCurrentInstance(null);
    }

    protected Application getApplication(FacesContext facesContext) {
        return facesContext.getApplication();
    }

    protected Object getManagedBean(String beanName,
                                    FacesContext facesContext) {
        return getApplication(facesContext).getVariableResolver().resolveVariable(facesContext,
                                                                                  beanName);
    }

    protected void log(FacesContext facesContext, String message) {
        facesContext.getExternalContext().log(message);
    }

    private abstract static class InnerFacesContext extends FacesContext {
        protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
            FacesContext.setCurrentInstance(facesContext);
        }
    }

    // end facecontext configuration for servlet...


    private void sendForward(String forwardUrl) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            ctx.getExternalContext().redirect(forwardUrl);
        } catch (IOException ie) {
            reportUnexpectedLoginError("IOException", ie);
        }
        ctx.responseComplete();
    }

    private void reportUnexpectedLoginError(String errType, Exception e) {
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unexpected error during login",
                             "Unexpected error during login (" + errType +
                             "please consult logs for detail");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().renderResponse();
    }
}
