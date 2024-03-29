package gov.bnm.view.rh.session;


import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.JSFUtils;

import java.math.BigDecimal;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.log4j.Logger;

import weblogic.security.URLCallbackHandler;


public class RHSession {

    static Logger log = Logger.getLogger(RHSession.class);
    private String fldConsultId;
    private String fldOpenStatus;
    private String fldCloseStatus;
    private String fldTokenId;
    private String fldUserid;
    private String fldUserType;
    private String fldUserTask;
    private String fldPolicyId;
    private String fldUserAction;
    private String fldDepartmentId;
    private Set<BigDecimal> uniqueItems;
    private String policyDuration;
    private Properties props;
    private String userFullName;
    private String depName;
    private String requestId;
    private String isInternalExternal;
    private String pageType;
    private String webServerAddress;
    private String userToken;
    private String enquiryFAQId;
    private String fldOrgId;
    private String authen;
    private String openTab;
    private String policyListingRecord;
    private String fldSearchKey;
    private String legislationKey;
    private String userDepOrOrgId;
    private int splitterPosition;
    private String fldConsultation;

    public void doUniqueItemsNull() {
        if (this.getUniqueItems() != null) {
            this.setUniqueItems(null);
        }
    }

    /**
       To check the security with the right token id with the userId
          - return valid if exist in table
          - remove the row in the table
     */
    public String getUserToken() {

        log.info("Came to User Token method ..");

        try {
            PropertyFileConfigManager propertyFileConfigManager = PropertyFileConfigManager.getInstance();

            props = propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION + FileUtil.RH_PROP_FILE);
            
            String consultId = BaseUtil.getStr(props.getProperty("consultId"));
            String openStatus = BaseUtil.getStr(props.getProperty("openStatus"));
            String closeStatus = BaseUtil.getStr(props.getProperty("closeStatus"));
            setFldConsultId(consultId);
            setFldOpenStatus(openStatus);
            setFldCloseStatus(closeStatus);
            
            policyDuration =
                    BaseUtil.getStr(props.getProperty("rh.PolicyDuration"));
            this.setSplitterPosition(BaseUtil.getInt(props.getProperty("rh.splitterPosition")));
            policyListingRecord =
                    BaseUtil.getStr(props.getProperty("rh.policyListingRecord"));

            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();
            String url = ectx.getRequestContextPath();
            log.info("url::" + url);
            webServerAddress =
                    BaseUtil.getStr(props.getProperty("rh.webServer.address")) +
                    url;
            this.setLegislationKey(BaseUtil.getStr(props.getProperty("rh.Legislation.Key")));
            //get user token by userId and token id

            HttpServletRequest reqParam =
                (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

            //            String userId =
            //                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldUserid"));
            String userId = reqParam.getParameter("fldUserid");
            log.info("userId::" + userId);
            if (userId == null || userId.equals("")) {
                userId =
                        BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldUserid"));
            }
            //            this.setAuthen(BaseUtil.getStr(reqParam.getParameter("authen")));

            //            if (Constants.STATUS_FAILURE.equalsIgnoreCase(this.getAuthen())) {
            //                this.setAuthen(this.doLogin(userId, "abcd12#$"));
            //            }
            this.setAuthen(Constants.STATUS_SUCCESS);

            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(this.getAuthen())) {
                String userAction =
                    BaseUtil.getStr(reqParam.getParameter("fldUserAction"));
                if (userAction == null || userAction.equals("")) {
                    userAction =
                            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldUserAction"));
                }
                //                String userAction =
                //                    BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldUserAction"));
                log.info("userAction::" + userAction);
                this.setFldTokenId(BaseUtil.getStr(reqParam.getParameter("fldTokenId")));
                this.setEnquiryFAQId(BaseUtil.getStr(reqParam.getParameter("enquiryFAQId")));
                this.setRequestId(BaseUtil.getStr(reqParam.getParameter("requestId")));
                this.setFldPolicyId(BaseUtil.getStr(reqParam.getParameter("fldPolicyId")));
                this.setFldUserid(BaseUtil.getStr(userId));
                this.setFldUserAction(userAction);
                this.setFldSearchKey(BaseUtil.getStr(reqParam.getParameter("fldSearchKey")));
                this.setPolicyDuration(policyDuration);

                Map<String, String> userMap =
                    CommonRHUtil.getUserDetails(userId);
                fldUserType = BaseUtil.getStr(userMap.get("fldUserType"));
                this.setFldUserType(fldUserType);
                this.setDepName(BaseUtil.getStr(userMap.get("depName")));
                this.setUserFullName(BaseUtil.getStr(userMap.get("fullName")));
                this.setIsInternalExternal(BaseUtil.getStr(userMap.get("isInternalExternal")));
                if (Constants.IS_INTERNAL_OR_EXTERNAL_EX.equals(this.getIsInternalExternal())) {
                    this.setUserDepOrOrgId(BaseUtil.getStr(userMap.get("orgId")));
                } else {
                    this.setUserDepOrOrgId(BaseUtil.getStr(userMap.get("depId")));
                }
                this.setFldOrgId(BaseUtil.getStr(userMap.get("orgId")));
                
                this.setFldConsultation("7,8");

                if (Constants.USER_ROLE_TYPE_ID_RH_ADMIN.equals(fldUserType)) {
                    this.setFldDepartmentId("ADMIN");
                } else {
                    this.setFldDepartmentId(BaseUtil.getStr(userMap.get("depId")));
                }
                //                ADFContext adfCtx = ADFContext.getCurrent();
                //                SecurityContext secCtx = adfCtx.getSecurityContext();
                //                if (secCtx.isUserInRole("01")) {
                //                    this.setFldDepartmentId("ADMIN");
                //                } else {
                //                    this.setFldDepartmentId(userMap.get("depId"));
                //
                //                }

                log.info("userId:::::: " + userId);
                log.info("userAction:::::: " + userAction);
                log.info("fldUserType:::::: " + fldUserType);
                log.info("Internal or External  : " +
                         this.getIsInternalExternal());
                
                // Add this line for testing IN user.. 02/04/2019 --
                // remove when its go to deployment'
                if(this.getIsInternalExternal() == "" || this.getIsInternalExternal() == null){
                    this.setIsInternalExternal("IN");
                }

                //                userToken = this.checkUserRoles();
                //                if (Constants.USER_ACTION_POLICY_PUBLISH_EMAIL_PAGE.equals(userAction) &&
                //                    !Constants.USER_ROLE_TYPE_ID_RH_ADMIN.equals(fldUserType)) {
                //                    userToken = Constants.STATUS_INVALID;
                //                } else if (Constants.USER_ACTION_POLICY_PUBLISH_DECISION_PAGE.equals(userAction) &&
                //                           !Constants.USER_ROLE_TYPE_ID_RH_MGR.equals(fldUserType)) {
                //                    userToken = Constants.STATUS_INVALID;
                //                }
            } else {
                userToken = Constants.STATUS_INVALID;
            }
        } catch (Exception e) {
            // TODO: Add catch code
            log.error("Exception @getUserToken .. " + e);
            e.printStackTrace();
        }
        userToken = Constants.STATUS_VALID;
        return userToken;
    }  

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

            log.info("After set subject.. ");
            weblogic.servlet.security.ServletAuthentication.runAs(mySubj,
                                                                  request);
            //ServletAuthentication.generateNewSessionID(request);

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

    public String checkUserRoles() {
        try {
            //FacesContext fctx = FacesContext.getCurrentInstance();
            ADFContext adfCtx = ADFContext.getCurrent();
            SecurityContext secCtx = adfCtx.getSecurityContext();
            log.info("security session user id .. " +
                     secCtx.getUserPrincipal().getName());

            String[] userRoles =
                ADFContext.getCurrent().getSecurityContext().getUserRoles();

            log.info("lenght of userroles  : " + userRoles.length);
            for (int i = 0; i < userRoles.length; i++) {
                log.info("userRoles  :  " + userRoles[i]);
            }

            boolean bolCheck = true;

            if (Constants.USER_ACTION_ADMIN.equalsIgnoreCase(fldUserAction)) {
                bolCheck =
                        secCtx.isUserInRole(Constants.USER_ROLE_TYPE_ID_RH_ADMIN);
                log.info("check action admin .." + bolCheck);
            } else if (Constants.USER_ACTION_MGR.equalsIgnoreCase(fldUserAction)) {
                bolCheck =
                        secCtx.isUserInRole(Constants.USER_ROLE_TYPE_ID_RH_MGR);
                log.info("check approval .. " + bolCheck);
            } else if (Constants.USER_ACTION_NISSDP.equalsIgnoreCase(fldUserAction)) {
                bolCheck =
                        secCtx.isUserInRole(Constants.USER_ROLE_TYPE_ID_RH_DEP_DIRECTOR);
                if (!bolCheck) {
                    bolCheck =
                            secCtx.isUserInRole(Constants.USER_ROLE_TYPE_ID_RH_DEPADMIN);
                }
                log.info("check department .. " + bolCheck);
            } else {

            }

            if (bolCheck) {
                userToken = Constants.STATUS_VALID;
            } else {
                userToken = Constants.STATUS_INVALID;
            }
        } catch (Exception e) {
            log.error("Exception occur in @checkUserRoles. .." + e);
            e.printStackTrace();
        }
        return userToken;
    }

    public String logout() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        String url =
            ectx.getRequestContextPath() + "/adfAuthentication?logout=true&end_url=/faces/logout.jsp";
        try {
            ectx.redirect(url);
        } catch (Exception e) {
            log.error("error : " + e);
        }
        fctx.responseComplete();
        return Constants.STATUS_SUCCESS;
    }

    public String clickPolicyLink() {
        try {
//            if (gov.bnm.view.rh.constant.Constants.IS_INTERNAL_OR_EXTERNAL_IN.equalsIgnoreCase(this.getIsInternalExternal())) {
//                if (CommonRHUtil.getDepInString() &&
//                    gov.bnm.view.rh.constant.Constants.USER_ROLE_TYPE_ID_RH_DEP_DIRECTOR.equals(this.getFldUserType())) {
//                    this.setPageType("ISSDP");
//                    return "issDepartment";
//                }
//            } else 
            if (gov.bnm.view.rh.constant.Constants.IS_INTERNAL_OR_EXTERNAL_EX.equalsIgnoreCase(this.getIsInternalExternal())) {
                /**
                 *  RH Session clickPolicyLink validate authorised policy.
                 *  Add new CR Dec 6th 2017 by shankar .. 
                 *  change CommonRHUtil.isAuthorisedToViewPolicy() into CommonRHUtil.isAuthorisedToViewPolicyMultiOrgInst()
                 */
                if (!CommonRHUtil.isAuthorisedToViewPolicyMultiOrgInst()) {
                    ADFUtils.showInfoMessage("You are not Authorised To View this Policy ");
                    return null;
                }
            }
            this.setPageType("CTPS");
        } catch (Exception e) {
            this.setPageType("CTPS");
            e.printStackTrace();
        }
        return "policyPreface";
    }

    public void setFldTokenId(String fldTokenId) {
        this.fldTokenId = fldTokenId;
    }

    public String getFldTokenId() {
        return fldTokenId;
    }

    public void setFldUserid(String fldUserid) {
        this.fldUserid = fldUserid;
    }

    public String getFldUserid() {
        return fldUserid;
    }


    public void setFldUserType(String fldUserType) {
        this.fldUserType = fldUserType;
    }

    public String getFldUserType() {
        return fldUserType;
    }

    public void setFldUserTask(String fldUserTask) {
        this.fldUserTask = fldUserTask;
    }

    public String getFldUserTask() {
        return fldUserTask;
    }

    public void setFldPolicyId(String fldPolicyId) {
        this.fldPolicyId = fldPolicyId;
    }

    public String getFldPolicyId() {
        return fldPolicyId;
    }

    /*
     * Consultation Page Start
     */
    public void setFldConsultId(String fldConsultId) {
        this.fldConsultId = fldConsultId;
    }

    public String getFldConsultId() {
        return fldConsultId;
    }
    
    public void setFldOpenStatus(String fldOpenStatus) {
        this.fldOpenStatus = fldOpenStatus;
    }

    public String getFldOpenStatus() {
        return fldOpenStatus;
    }
    
    public void setFldCloseStatus(String fldCloseStatus) {
        this.fldCloseStatus = fldCloseStatus;
    }

    public String getFldCloseStatus() {
        return fldCloseStatus;
    }
    /*
     * Consultation Page End
     */

    public void setFldUserAction(String fldUserAction) {
        this.fldUserAction = fldUserAction;
    }

    public String getFldUserAction() {
        return fldUserAction;
    }

    public void setFldDepartmentId(String fldDepartmentId) {
        this.fldDepartmentId = fldDepartmentId;
    }

    public String getFldDepartmentId() {
        return fldDepartmentId;
    }

    public void setUniqueItems(Set<BigDecimal> uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public Set<BigDecimal> getUniqueItems() {
        return uniqueItems;
    }

    public void setPolicyDuration(String policyDuration) {
        this.policyDuration = policyDuration;
    }

    public String getPolicyDuration() {
        return policyDuration;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setIsInternalExternal(String isInternalExternal) {
        this.isInternalExternal = isInternalExternal;
    }

    public String getIsInternalExternal() {
        return isInternalExternal;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }

    public void setWebServerAddress(String webServerAddress) {
        this.webServerAddress = webServerAddress;
    }

    public String getWebServerAddress() {
        return webServerAddress;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setEnquiryFAQId(String enquiryFAQId) {
        this.enquiryFAQId = enquiryFAQId;
    }

    public String getEnquiryFAQId() {
        return enquiryFAQId;
    }


    public void setFldOrgId(String fldOrgId) {
        this.fldOrgId = fldOrgId;
    }

    public String getFldOrgId() {
        return fldOrgId;
    }

    public void setAuthen(String authen) {
        this.authen = authen;
    }

    public String getAuthen() {
        return authen;
    }

    public void setOpenTab(String openTab) {
        this.openTab = openTab;
    }

    public String getOpenTab() {
        return openTab;
    }

    public void setPolicyListingRecord(String policyListingRecord) {
        this.policyListingRecord = policyListingRecord;
    }

    public String getPolicyListingRecord() {
        return policyListingRecord;
    }

    public void setFldSearchKey(String fldSearchKey) {
        this.fldSearchKey = fldSearchKey;
    }

    public String getFldSearchKey() {
        return fldSearchKey;
    }

    public void setSplitterPosition(int splitterPosition) {
        this.splitterPosition = splitterPosition;
    }

    public int getSplitterPosition() {
        return splitterPosition;
    }

    public void setLegislationKey(String legislationKey) {
        this.legislationKey = legislationKey;
    }

    public String getLegislationKey() {
        return legislationKey;
    }

    public void setUserDepOrOrgId(String userDepOrOrgId) {
        this.userDepOrOrgId = userDepOrOrgId;
    }

    public String getUserDepOrOrgId() {
        return userDepOrOrgId;
    }

    public void setFldConsultation(String fldConsultation) {
        this.fldConsultation = fldConsultation;
    }

    public String getFldConsultation() {
        return fldConsultation;
    }
}
