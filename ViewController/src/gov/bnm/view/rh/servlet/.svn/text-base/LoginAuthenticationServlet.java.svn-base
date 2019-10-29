package gov.bnm.view.rh.servlet;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.view.rh.common.ShuttleInfo;
import gov.bnm.view.rh.utils.BaseUtil;

import gov.bnm.view.rh.utils.JSFUtils;

import gov.view.common.configuration.Constants;

//import gov.view.common.security.SHAExample;

import java.io.IOException;
import java.io.PrintWriter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;

public class LoginAuthenticationServlet extends HttpServlet {
    static Logger log = Logger.getLogger(LoginAuthenticationServlet.class);
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final long serialVersionUID = -8639564854606811963L;

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


        String un = BaseUtil.getStr(request.getParameter("fldUserid"));
        byte[] pwd = "abcd12#$".getBytes();

        log.info("servlet run .. ");
        String webServerPath = props.getProperty("rh.webServer.address");
        webServerPath = webServerPath.concat(request.getContextPath());


        String fldTokenId =
            BaseUtil.getStr(request.getParameter("fldTokenId"));
        String fldPolicyId =
            BaseUtil.getStr(request.getParameter("fldPolicyId"));
        String fldUserId = BaseUtil.getStr(request.getParameter("fldUserid"));
        String fldUserAction =
            BaseUtil.getStr(request.getParameter("fldUserAction"));
        String enquiryFAQId =
            BaseUtil.getStr(request.getParameter("enquiryFAQId"));
        String requestId = BaseUtil.getStr(request.getParameter("requestId"));

        FacesContext ctx = FacesContext.getCurrentInstance();

        Subject mySubject;
        String loginUrl;

        try {

            String authen = gov.bnm.view.rh.constant.Constants.STATUS_FAILURE;
            log.info("  check authen  ... " +
                     ADFContext.getCurrent().getSecurityContext().isAuthenticated());

            if (ADFContext.getCurrent().getSecurityContext().isAuthenticated()) {
                authen = gov.bnm.view.rh.constant.Constants.STATUS_SUCCESS;
            } else {
                authen = this.doLogin(un, "abcd12#$");
            }


            loginUrl =
                    webServerPath + "/faces/adf.task-flow?adf.tfId=btf_RHMain&adf.tfDoc=/WEB-INF/PageFlows/taskFlow/btf_RHMain.xml&fldTokenId=" +
                    fldTokenId + "&fldPolicyId=" + fldPolicyId +
                    "&fldUserid=" + fldUserId + "&fldUserAction=" +
                    fldUserAction + "&enquiryFAQId=" + enquiryFAQId +
                    "&requestId=" + requestId + "&authen=" + authen;

            ctx.getExternalContext().getResponse();
            request.getRequestDispatcher(loginUrl);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public String doLogin(String _username, String _password) {
        String un = _username;
        byte[] pw = _password.getBytes();
        //        _password =
        //                "c6c01a52fa18ba0f998008ece3a30373640b838397963d890789d2efa93d8120";
        //        String pw = _password;
        String securePassword = null;
        try {
            String salt = getSalt();
//            securePassword =
//                    SHAExample.get_SHA_256_SecurePassword(_password, salt);
//            log.info(securePassword);
            pw =
 "c6c01a52fa18ba0f998008ece3a30373640b838397963d890789d2efa93d8120".getBytes();
        } catch (NoSuchAlgorithmException e) {
            log.error("hash convertion error .. ");
        }

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
            log.info(secCtx.getUserPrincipal().getName());
            log.info("authen .. success ");

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

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
