package gov.bnm.view.rh.utils;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.rh.RegBookAppModuleImpl;

import gov.bnm.rh.views.EnquiryfaqForEnqPendingViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqPolicyViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqViewObjRowImpl;
import gov.bnm.rh.views.ExternaluserViewRowImpl;
import gov.bnm.rh.views.InternaluserViewRowImpl;

import gov.bnm.rh.views.PolicyPendingViewObjRowImpl;
import gov.bnm.rh.views.PolicyViewRowImpl;
import gov.bnm.rh.views.PolicybnmuserspartitionViewRowImpl;
import gov.bnm.rh.views.Policybusinesssectorpartition1ViewRowImpl;
import gov.bnm.rh.views.PolicydepartmentpartitionViewRowImpl;
import gov.bnm.rh.views.PolicyinstitutiontypepartitionViewRowImpl;
import gov.bnm.rh.views.PolicyorganizationpartitionViewRowImpl;
import gov.bnm.rh.views.RequestlistViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.net.SocketException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Properties;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

public class EmailUtils {

    static Logger log = Logger.getLogger(EmailUtils.class);


    public static String sendMailRequestForAccessSuppDocs(RequestlistViewRowImpl reqRow) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));

            //TO
            String[] receiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service,
                                                        BaseUtil.getStr(reqRow.getitemId()),
                                                        "Director", "",
                                                        "")).split(";");
            emailBean.setReceiverEmails(receiverEmails);
            //CC
            String[] ccReceiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service,
                                                        BaseUtil.getStr(reqRow.getitemId()),
                                                        "ADMIN", "",
                                                        "")).split(";");
            emailBean.setCcReceiverEmails(ccReceiverEmails);

            emailBean.setTemplateId("RequestForAccessSuppDocs");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%supporting doc name%>",
                     BaseUtil.getStr(reqRow.gettypeOfReqName()));
            data.put("<%policy document title%>",
                     BaseUtil.getStr(reqRow.getGuidelineTitle()));
            data.put("<%Requester Name%>", rhSession.getUserFullName());
            data.put("<%Requester Designation%>",
                     BaseUtil.getStr(reqRow.getDesignation()));
            data.put("<%Requester Department%>", rhSession.getDepName());
            data.put("<%Reason for request%>",
                     BaseUtil.getStr(reqRow.getreasonForRequest()));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "SupportingDocumentsRequestDecision" + "?requestId=" +
                     BaseUtil.getStr(reqRow.getrequestId()));
            //                     "&fldUserAction=SDRD");
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailResponseForAccessSuppDocs(RequestlistViewRowImpl reqRow) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            //TO
            String[] receiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service, "", "",
                                                        BaseUtil.getStr(reqRow.getrequestorId()),
                                                        "")).split(";");
            emailBean.setReceiverEmails(receiverEmails);

            String status = BaseUtil.getStr(reqRow.getstatus());
            if (status.equals(Constants.RECORD_STATUS_APPROVED)) {
                emailBean.setTemplateId("ApprovalForAccessSuppDocs");
            } else if (status.equals(Constants.RECORD_STATUS_REJECTED)) {
                emailBean.setTemplateId("RejectionForAccessSuppDocs");
            }

            Map<String, String> data = new HashMap<String, String>();
            data.put("<%supporting doc name%>",
                     BaseUtil.getStr(reqRow.gettypeOfReqName()));
            data.put("<%policy document title%>",
                     BaseUtil.getStr(reqRow.getGuidelineTitle()));
            data.put("<%Requester Name%>",
                     BaseUtil.getStr(reqRow.getRequestorName()));
            data.put("<%rejection reason%>",
                     BaseUtil.getStr(reqRow.getreasonForRejection()));
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailSubmitEnquiry(EnquiryfaqForEnqPolicyViewObjRowImpl enqRow) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            //cr on 12/03/2015  Auto acknowledgement feature for enquirer
            EmailDataBean emailAckBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            emailAckBean.setSenderEmail(props.getProperty("mail.from"));
            emailAckBean.setSenderName(props.getProperty("mail.from.name"));
            String isInternalExternal =
                BaseUtil.getStr(enqRow.getisInternalExternal());
            String nameOfEnquirer = "";
            String depName = "";
            String enquiryFAQId = BaseUtil.getStr(enqRow.getEnquiryFAQId());
            //TO
            if (isInternalExternal.equals(Constants.IS_INTERNAL_OR_EXTERNAL_IN)) {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsInternalUser(service, "", "",
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                String receiverEmail = receiverEmails[0];
                emailBean.setSenderEmail(receiverEmail);
                //CR on 12/03/2015 Auto acknowledgement feature for enquirer
                emailAckBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getInternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
                depName = BaseUtil.getStr(userMap.get("depName"));
            } else {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsExternalUser(service,
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                String receiverEmail = receiverEmails[0];
                emailBean.setSenderEmail(receiverEmail);
                //CR on 12/03/2015 Auto acknowledgement feature for enquirer
                emailAckBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getExternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
                depName = BaseUtil.getStr(userMap.get("orgName"));


            }
            //TO
            //      String[] receiverEmails =
            //        BaseUtil.getStr(getEmailIdsInternalUser(service,
            //                                                BaseUtil.getStr(enqRow.getitemId()),
            //                                                "Director", "",
            //                                                "")).split(";");
            //      emailBean.setReceiverEmails(receiverEmails);
            //CC
            String[] receiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service,
                                                        BaseUtil.getStr(enqRow.getitemId()),
                                                        "ADMIN", "",
                                                        "")).split(";");
            //CR on 12/03/2015  send only admin
            //      emailBean.setCcReceiverEmails(ccReceiverEmails);
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setTemplateId("SubmitEnquiry");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%policy title%>",
                     BaseUtil.getStr(enqRow.getPolicyTitle()));
            data.put("<%name of enquirer%>", nameOfEnquirer);
            data.put("<%name of supervised institution or department %>",
                     depName);
            data.put("<%Question%>", BaseUtil.getStr(enqRow.getTitle()));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "PolicyEnquiryResponse" + "?enquiryFAQId=" +
                     BaseUtil.getStr(enqRow.getEnquiryFAQId()));
            //                     "&fldUserAction=ENQRES");
            emailBean.setDataMap(data);
            emailBean.setAttachments(getAttachments("AttachedfileForEnqQueView1Iterator",
                                                    enquiryFAQId));
            emailManager.sendEmail(emailBean);

            //CR on 12/03/2015 Auto acknowledgement feature for enquirer
            emailAckBean.setTemplateId("EnquiryAcknowledgement");
            Map<String, String> ackData = new HashMap<String, String>();
            ackData.put("<%policy title%>",
                        BaseUtil.getStr(enqRow.getPolicyTitle()));
            ackData.put("<%name of enquirer%>", nameOfEnquirer);
            ackData.put("<%Question%>", BaseUtil.getStr(enqRow.getTitle()));
            emailAckBean.setDataMap(ackData);
            emailManager.sendEmail(emailAckBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailResponseForEnquiry(EnquiryfaqForEnqViewObjRowImpl enqRow) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            String isInternalExternal =
                BaseUtil.getStr(enqRow.getisInternalExternal());
            String nameOfEnquirer = "";
            //TO
            if (isInternalExternal.equals(Constants.IS_INTERNAL_OR_EXTERNAL_IN)) {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsInternalUser(service, "", "",
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                emailBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getInternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
            } else {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsExternalUser(service,
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                emailBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getExternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
            }
            //BCC
            //      String[] bccEmails =
            //        BaseUtil.getStr(getEmailIdsInternalUser(service, BaseUtil.getStr(enqRow.getitemId()),
            //                                                "Director", "",
            //                                                "")).split(";");
            //BCC
            String[] bccReceiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service,
                                                        BaseUtil.getStr(enqRow.getitemId()),
                                                        "ADMIN", "",
                                                        "")).split(";");
            //      String[] bccReceiverEmails =
            //        (String[])ArrayUtils.addAll(bccEmails, bccEmails2);
            //CR on 16-12-2014 send only admin
            emailBean.setBccReceiverEmails(bccReceiverEmails);
            emailBean.setTemplateId("ResponseForEnquiry");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%policy title%>",
                     BaseUtil.getStr(enqRow.getPolicyTitle()));
            data.put("<%name of enquirer%>", nameOfEnquirer);
            data.put("<%Answer%>", BaseUtil.getStr(enqRow.getAbstract11()));
            data.put("<%Question%>", BaseUtil.getStr(enqRow.getTitle()));
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailResponseForEnquiry(EnquiryfaqForEnqPendingViewObjRowImpl enqRow) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            String isInternalExternal =
                BaseUtil.getStr(enqRow.getisInternalExternal());
            String nameOfEnquirer = "";
            //TO
            if (isInternalExternal.equals(Constants.IS_INTERNAL_OR_EXTERNAL_IN)) {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsInternalUser(service, "", "",
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                emailBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getInternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
            } else {
                String[] receiverEmails =
                    BaseUtil.getStr(getEmailIdsExternalUser(service,
                                                            BaseUtil.getStr(enqRow.getcreatedBy()),
                                                            "")).split(";");
                emailBean.setReceiverEmails(receiverEmails);
                Map<String, Object> userMap =
                    getExternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                           "");
                nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
            }
            //BCC
            //      String[] bccEmails =
            //        BaseUtil.getStr(getEmailIdsInternalUser(service, BaseUtil.getStr(enqRow.getitemId()),
            //                                                "Director", "",
            //                                                "")).split(";");
            //BCC
            String[] bccReceiverEmails =
                BaseUtil.getStr(getEmailIdsInternalUser(service,
                                                        BaseUtil.getStr(enqRow.getitemId()),
                                                        "ADMIN", "",
                                                        "")).split(";");
            //      String[] bccReceiverEmails =
            //        (String[])ArrayUtils.addAll(bccEmails, bccEmails2);
            //CR on 16-12-2014 send only admin
            emailBean.setBccReceiverEmails(bccReceiverEmails);
            emailBean.setTemplateId("ResponseForEnquiry");
            emailBean.setAttachments(getAttachments("AttachedfileForEnqAnsView1Iterator",
                                                    enqRow.getEnquiryFAQId()));
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%policy title%>",
                     BaseUtil.getStr(enqRow.getPolicyTitle()));
            data.put("<%name of enquirer%>", nameOfEnquirer);
            data.put("<%Answer%>", BaseUtil.getStr(enqRow.getAbstract11()));
            data.put("<%Question%>", BaseUtil.getStr(enqRow.getTitle()));
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyPriorIssuance(PolicyViewRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String[] receiverEmails =
            { props.getProperty("NotificationToRHManagementEmail") };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setTemplateId("PolicyPriorToIssuance");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%title of the policy%>", row.getGuidelineTitle());
            data.put("<%issuance date%>",
                     DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            data.put("<%summary%>", row.getSummary());
            String highlights = BaseUtil.getStr(row.getHighlights());
            if (!highlights.equals("")) {
                data.put("<%Latest Highlights%>",
                         "Highlights: " + row.getHighlights());
            }
            String polDepName = getPolDepName(service, row.getitemId());
            String polAuthName = getPolAuthName(service, row.getitemId());
            data.put("<%Department%>", polDepName);
            data.put("<%author%>", polAuthName);
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyPriorIssuancePen(PolicyPendingViewObjRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String[] receiverEmails =
            { props.getProperty("NotificationToRHManagementEmail") };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setTemplateId("PolicyPriorToIssuance");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%title of the policy%>", row.getGuidelineTitle());
            data.put("<%issuance date%>",
                     DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            data.put("<%summary%>", row.getSummary());
            String highlights = BaseUtil.getStr(row.getHighlights());
            if (!highlights.equals("")) {
                data.put("<%Latest Highlights%>",
                         "Highlights: " + row.getHighlights());
            }
            String polDepName = getPolDepName(service, row.getitemId());
            String polAuthName = getPolAuthName(service, row.getitemId());
            data.put("<%Department%>", polDepName);
            data.put("<%author%>", polAuthName);
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyOnIssuance(PolicyViewRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String[] receiverEmails =
            { props.getProperty("NotificationToInternalStakeholders") };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setTemplateId("PublishedNotificationBNM");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%title of the policy%>", row.getGuidelineTitle());
            data.put("<%issuance date%>",
                     DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            String applicability =
                getApplicability(service, row.getitemId(), row.getpartitionTypeId());
            data.put("<%Applicability%>", applicability);
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
            String organizationIds =
                getOrganizationIds(service, row.getitemId(),
                                   row.getpartitionTypeId());
            String[] receiverEmailsExter =
                getEmailIdsExternalCeoAdmin(service, organizationIds,
                                            "").split(";");
            //FI
            EmailDataBean emailBeanFI = new EmailDataBean();
            emailBeanFI.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBeanFI.setReceiverEmails(receiverEmailsExter);
            emailBeanFI.setTemplateId("PublishedNotificationFI");
            Map<String, String> dataFI = new HashMap<String, String>();
            dataFI.put("<%title of the policy%>", row.getGuidelineTitle());
            dataFI.put("<%issuance date%>",
                       DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            emailBeanFI.setDataMap(dataFI);
            emailManager.sendEmail(emailBeanFI);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyOnIssuancePen(PolicyPendingViewObjRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String[] receiverEmails =
            { props.getProperty("NotificationToInternalStakeholders") };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setTemplateId("PublishedNotificationBNM");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%title of the policy%>", row.getGuidelineTitle());
            data.put("<%issuance date%>",
                     DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            String applicability =
                getApplicability(service, row.getitemId(), row.getpartitionTypeId());
            data.put("<%Applicability%>", applicability);
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);
            String organizationIds =
                getOrganizationIds(service, row.getitemId(),
                                   row.getpartitionTypeId());
            String[] receiverEmailsExter =
                getEmailIdsExternalCeoAdmin(service, organizationIds,
                                            "").split(";");
            //FI
            EmailDataBean emailBeanFI = new EmailDataBean();
            emailBeanFI.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBeanFI.setReceiverEmails(receiverEmailsExter);
            emailBeanFI.setTemplateId("PublishedNotificationFI");
            Map<String, String> dataFI = new HashMap<String, String>();
            dataFI.put("<%title of the policy%>", row.getGuidelineTitle());
            dataFI.put("<%issuance date%>",
                       DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
            emailBeanFI.setDataMap(dataFI);
            emailManager.sendEmail(emailBeanFI);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyPublishRejection(PolicyViewRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String adminId = "";
            if (row.getupdatedBy() != null && !row.getupdatedBy().equals("")) {
                adminId = BaseUtil.getStr(row.getupdatedBy());
            } else {
                adminId = BaseUtil.getStr(row.getcreatedBy());
            }

            Map<String, Object> adminDetails =
                getInternalUserDetails(service, adminId, "");
            Map<String, Object> approverDetails =
                getInternalUserDetails(service,
                                       BaseUtil.getStr(row.getapproverId()),
                                       "");

            String[] receiverEmails =
            { BaseUtil.getStr(adminDetails.get("emailId")) };
            String[] ccReceiverEmails =
            { BaseUtil.getStr(approverDetails.get("emailId")) };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setCcReceiverEmails(ccReceiverEmails);
            emailBean.setTemplateId("RejectionForPolicyPublish");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%Policy Title%>",
                     BaseUtil.getStr(row.getGuidelineTitle()));
            data.put("<%rejection reason%>",
                     BaseUtil.getStr(row.getReasonForRejection()));
            data.put("<%RH Admin%>",
                     BaseUtil.getStr(adminDetails.get("name")));
            data.put("<%Name of approver%>",
                     BaseUtil.getStr(approverDetails.get("name")));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "PolicyPublishEmail" + "?fldPolicyId=" +
                     BaseUtil.getStr(row.getitemId()));
            //                     "&fldUserAction=PPRP");
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);

        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyPublishRejectionPen(PolicyPendingViewObjRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String adminId = "";
            if (row.getupdatedBy() != null && !row.getupdatedBy().equals("")) {
                adminId = BaseUtil.getStr(row.getupdatedBy());
            } else {
                adminId = BaseUtil.getStr(row.getcreatedBy());
            }

            Map<String, Object> adminDetails =
                getInternalUserDetails(service, adminId, "");
            Map<String, Object> approverDetails =
                getInternalUserDetails(service,
                                       BaseUtil.getStr(row.getapproverId()),
                                       "");

            String[] receiverEmails =
            { BaseUtil.getStr(adminDetails.get("emailId")) };
            String[] ccReceiverEmails =
            { BaseUtil.getStr(approverDetails.get("emailId")) };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setCcReceiverEmails(ccReceiverEmails);
            emailBean.setTemplateId("RejectionForPolicyPublish");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%Policy Title%>",
                     BaseUtil.getStr(row.getGuidelineTitle()));
            data.put("<%rejection reason%>",
                     BaseUtil.getStr(row.getReasonForRejection()));
            data.put("<%RH Admin%>",
                     BaseUtil.getStr(adminDetails.get("name")));
            data.put("<%Name of approver%>",
                     BaseUtil.getStr(approverDetails.get("name")));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "PolicyPublishEmail" + "?fldPolicyId=" +
                     BaseUtil.getStr(row.getitemId()));
            //                     "&fldUserAction=PPRP");
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);

        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }

    public static String sendMailPolicyPublishRequestForApproval(PolicyViewRowImpl row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String adminId = "";
            if (row.getupdatedBy() != null && !row.getupdatedBy().equals("")) {
                adminId = BaseUtil.getStr(row.getupdatedBy());
            } else {
                adminId = BaseUtil.getStr(row.getcreatedBy());
            }

            Map<String, Object> adminDetails =
                getInternalUserDetails(service, adminId, "");
            Map<String, Object> approverDetails =
                getInternalUserDetails(service,
                                       BaseUtil.getStr(row.getapproverId()),
                                       "");

            String[] ccReceiverEmails =
            { BaseUtil.getStr(adminDetails.get("emailId")) };
            String[] receiverEmails =
            { BaseUtil.getStr(approverDetails.get("emailId")) };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setCcReceiverEmails(ccReceiverEmails);
            emailBean.setTemplateId("RequestForPolicyPublish");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%Policy Title%>",
                     BaseUtil.getStr(row.getGuidelineTitle()));
            data.put("<%RH Admin%>",
                     BaseUtil.getStr(adminDetails.get("name")));
            data.put("<%Name of approver%>",
                     BaseUtil.getStr(approverDetails.get("name")));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "PolicyPublishDecision" + "?fldPolicyId=" +
                     BaseUtil.getStr(row.getitemId()));
            //                     "&fldUserAction=PPDEC");
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);

        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }
    public static String sendMailPolicyPublishRequestForApproval(Map<String,String> row) {
        EmailManager emailManager = new EmailManager();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            EmailDataBean emailBean = new EmailDataBean();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String adminId = BaseUtil.getStr(row.get("createdBy"));

            Map<String, Object> adminDetails =
                getInternalUserDetails(service, adminId, "");
            Map<String, Object> approverDetails =
                getInternalUserDetails(service,
                                       BaseUtil.getStr(row.get("approverId")),
                                       "");

            String[] ccReceiverEmails =
            { BaseUtil.getStr(adminDetails.get("emailId")) };
            String[] receiverEmails =
            { BaseUtil.getStr(approverDetails.get("emailId")) };
            emailBean.setSenderEmail(props.getProperty("mail.from"));
            emailBean.setSenderName(props.getProperty("mail.from.name"));
            emailBean.setReceiverEmails(receiverEmails);
            emailBean.setCcReceiverEmails(ccReceiverEmails);
            emailBean.setTemplateId("RequestForPolicyPublish");
            Map<String, String> data = new HashMap<String, String>();
            data.put("<%Policy Title%>",
                     BaseUtil.getStr(row.get("guidelineTitle")));
            data.put("<%RH Admin%>",
                     BaseUtil.getStr(adminDetails.get("name")));
            data.put("<%Name of approver%>",
                     BaseUtil.getStr(approverDetails.get("name")));
            data.put("<%URL%>",
                     props.getProperty("rh.email.webServer.address") +
                     "&fldPolicyId=" + BaseUtil.getStr(row.get("policyId")) +
                     "&fldUserAction=PPDEC");
            emailBean.setDataMap(data);
            emailManager.sendEmail(emailBean);

        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return "";
    }
    public static String getPolAuthName(RegBookAppModuleImpl service,
                                        String itemId) {
        String returnVal = "";
        ViewObject polAuthVO = service.getPolicybnmuserspartitionView1();
        polAuthVO.setNamedWhereClauseParam("bindItemId", itemId);
        polAuthVO.executeQuery();
        while (polAuthVO.hasNext()) {
            PolicybnmuserspartitionViewRowImpl row =
                (PolicybnmuserspartitionViewRowImpl)polAuthVO.next();
            returnVal += BaseUtil.getStr(row.getuserName()) + ",";
        }
        returnVal = returnVal + "remove)";
        returnVal = returnVal.replace(",remove)", "");
        return returnVal;
    }

    public static String getPolDepName(RegBookAppModuleImpl service,
                                       String itemId) {
        String returnVal = "";
        ViewObject polDepVO = service.getPolicydepartmentpartitionView1();
        polDepVO.setNamedWhereClauseParam("bindItemId", itemId);
        polDepVO.executeQuery();
        while (polDepVO.hasNext()) {
            PolicydepartmentpartitionViewRowImpl row =
                (PolicydepartmentpartitionViewRowImpl)polDepVO.next();
            returnVal += BaseUtil.getStr(row.getDepartmentName()) + ",";
        }
        returnVal = returnVal + "remove)";
        returnVal = returnVal.replace(",remove)", "");
        return returnVal;
    }

    public static String getApplicability(RegBookAppModuleImpl service,
                                          String itemId, int partitionTypeId) {
        String returnVal = "";
        if (partitionTypeId == 1) {
            ViewObject VO = service.getPolicybusinesssectorpartition1View1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();
            while (VO.hasNext()) {
                Policybusinesssectorpartition1ViewRowImpl row =
                    (Policybusinesssectorpartition1ViewRowImpl)VO.next();
                returnVal += BaseUtil.getStr(row.getSectorName()) + ",";
            }
        } else if (partitionTypeId == 2) {
            ViewObject VO = service.getPolicyinstitutiontypepartitionView1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();
            while (VO.hasNext()) {
                PolicyinstitutiontypepartitionViewRowImpl row =
                    (PolicyinstitutiontypepartitionViewRowImpl)VO.next();
                returnVal +=
                        BaseUtil.getStr(row.getInstitutiontypeName()) + ",";
            }
        } else if (partitionTypeId == 3) {
            ViewObject VO = service.getPolicyorganizationpartitionView1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();
            while (VO.hasNext()) {
                PolicyorganizationpartitionViewRowImpl row =
                    (PolicyorganizationpartitionViewRowImpl)VO.next();
                returnVal += BaseUtil.getStr(row.getOrgName()) + ",";
            }
        }
        returnVal = returnVal + "remove)";
        returnVal = returnVal.replace(",remove)", "");
        return returnVal;
    }

    public static String getOrganizationIds(RegBookAppModuleImpl service,
                                            String itemId,
                                            int partitionTypeId) {
        String returnVal = "(";
        String sectorIds = "(";
        String institutiontypeIds = "(";
        if (partitionTypeId == 1) {
            ViewObject VO = service.getPolicybusinesssectorpartition1View1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();

            while (VO.hasNext()) {
                Policybusinesssectorpartition1ViewRowImpl row =
                    (Policybusinesssectorpartition1ViewRowImpl)VO.next();
                sectorIds += row.getID() + ",";
            }
        } else if (partitionTypeId == 2) {
            ViewObject VO = service.getPolicyinstitutiontypepartitionView1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();
            while (VO.hasNext()) {
                PolicyinstitutiontypepartitionViewRowImpl row =
                    (PolicyinstitutiontypepartitionViewRowImpl)VO.next();
                institutiontypeIds +=
                        "'" + BaseUtil.getStr(row.getid()) + "',";
            }
        } else if (partitionTypeId == 3) {
            ViewObject VO = service.getPolicyorganizationpartitionView1();
            VO.setNamedWhereClauseParam("bindItemId", itemId);
            VO.executeQuery();
            while (VO.hasNext()) {
                PolicyorganizationpartitionViewRowImpl row =
                    (PolicyorganizationpartitionViewRowImpl)VO.next();
                returnVal += "'" + BaseUtil.getStr(row.getid()) + "',";
            }
        }
        if (partitionTypeId != 3) {
            ViewObject orgVO = service.getOrganizationView1();
            if (partitionTypeId == 1) {
                sectorIds = sectorIds + ")";
                sectorIds = sectorIds.replace(",)", ")");
                orgVO.setWhereClause(" Sectorid IN " + sectorIds);
            } else {
                institutiontypeIds = institutiontypeIds + ")";
                institutiontypeIds = institutiontypeIds.replace(",)", ")");
                orgVO.setWhereClause(" INSTTYPE IN" + institutiontypeIds);
            }
            orgVO.executeQuery();
            while (orgVO.hasNext()) {
                Row row = orgVO.next();
                returnVal +=
                        "'" + BaseUtil.getStr(row.getAttribute("id")) + "',";
            }
        }
        returnVal = returnVal + ")";
        returnVal = returnVal.replace(",)", ")");
        return returnVal;
    }

    private static String getDepInString(RegBookAppModuleImpl service,
                                         String itemId) {
        String returnVal = "(";
        ViewObject depVO = service.getPolicydepartmentpartitionView1();
        depVO.setNamedWhereClauseParam("bindItemId", itemId);
        depVO.executeQuery();
        log.info("executeQuery::" + depVO.getEstimatedRowCount());
        while (depVO.hasNext()) {
            Row row = depVO.next();
            // DO what do you want in Row
            returnVal +=
                    "'" + BaseUtil.getStr(row.getAttribute("departmentId")) +
                    "',";
        }
        returnVal += ")";
        returnVal = returnVal.replace(",)", ")");
        return returnVal;
    }

    private static String getEmailIdsInternalUser(RegBookAppModuleImpl service,
                                                  String itemId,
                                                  String userType,
                                                  String userId, String sql) {
        log.info("getEmailIdsInternalUser In");
        String emails = "";
        try {
            ViewObject vo = service.getInternaluserView1();
            if (userType.equals("ADMIN")) {
                vo.setWhereClause(" ID IN (SELECT USERID FROM [dbo].[INTERNALUSER_USERGROUP] WHERE GROUPID ='" +
                                  Constants.USER_ROLE_TYPE_ID_RH_ADMIN +
                                  "' ) " + sql);
            } else if (itemId != null && !itemId.equals("")) {
                String depIds = getDepInString(service, itemId);
                vo.setWhereClause(" ID IN (SELECT USERID FROM [dbo].[INTERNALUSER_USERGROUP] WHERE GROUPID ='" +
                                  Constants.USER_ROLE_TYPE_ID_RH_DEP_DIRECTOR +
                                  "' ) and DEPTID in " + depIds + "  " + sql);
            } else if (userId != null && !userId.equals("")) {
                vo.setWhereClause(" USERID='" + userId + "'");
            }
            vo.executeQuery();

            while (vo.hasNext()) {
                InternaluserViewRowImpl rowUser =
                    (InternaluserViewRowImpl)vo.next();
                log.info("getEMAILADDRESS::" + rowUser.getEMAIL());
                emails += BaseUtil.getStr(rowUser.getEMAIL()) + ";";
            }
            log.info("emails::" + emails);

        } catch (Exception e) {
            log.error(e.getMessage());
            return emails;
        }

        log.info("getEmailIdsInternalUser Out");
        return emails;
    }

    private static String getEmailIdsExternalUser(RegBookAppModuleImpl service,
                                                  String userId, String sql) {
        log.info("getEmailIdsExternalUser In");
        //RegBookAppModuleImpl service = (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF , CommonRHUtil.CONFIG);
        String emails = "";
        try {
            ViewObject vo = service.getExternaluserView1();
            vo.setWhereClause("  EMAIL ='" + userId + "' " + sql);
            vo.executeQuery();

            while (vo.hasNext()) {
                ExternaluserViewRowImpl rowUser =
                    (ExternaluserViewRowImpl)vo.next();
                log.info("getEMAILADDRESS::" + rowUser.getCOMMEMAIL());
                emails += BaseUtil.getStr(rowUser.getCOMMEMAIL()) + ";";
            }
            log.info("emails::" + emails);

        } catch (Exception e) {
            log.error(e.getMessage());
            return emails;
        }

        log.info("getEmailIdsExternalUser Out");
        return emails;
    }

    private static String getEmailIdsExternalCeoAdmin(RegBookAppModuleImpl service,
                                                      String organizationIds,
                                                      String sql) {
        log.info("getEmailIdsExternalUser In");
        String emails = "";
        try {
            ViewObject vo = service.getExternaluserView1();
            vo.setWhereClause("  ORGID  IN " + organizationIds +
                              " AND USERID IN (SELECT USERID FROM [dbo].[USER_USERGROUP] WHERE GROUPID IN ('" +
                              Constants.USER_ROLE_TYPE_ID_RH_FIADMIN + "', '" +
                              Constants.USER_ROLE_TYPE_ID_RH_CEO + "'))" +
                              sql);
            vo.executeQuery();

            while (vo.hasNext()) {
                ExternaluserViewRowImpl rowUser =
                    (ExternaluserViewRowImpl)vo.next();
                log.info("getEMAILADDRESS::" + rowUser.getCOMMEMAIL());
                emails += BaseUtil.getStr(rowUser.getCOMMEMAIL()) + ";";
            }
            log.info("emails::" + emails);

        } catch (Exception e) {
            log.error(e.getMessage());
            return emails;
        }

        log.info("getEmailIdsExternalUser Out");
        return emails;
    }

    private static Map<String, Object> getExternalUserDetails(RegBookAppModuleImpl service,
                                                              String userId,
                                                              String sql) {
        log.info("getExternalUserDetails In");
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            ViewObject vo = service.getExternaluserView1();
            vo.setWhereClause("  EMAIL ='" + userId + "' " + sql);
            vo.executeQuery();

            while (vo.hasNext()) {
                ExternaluserViewRowImpl rowUser =
                    (ExternaluserViewRowImpl)vo.next();
                returnMap.put("name", rowUser.getFULLNAME());
                returnMap.put("orgName", rowUser.getOrganizationName());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return returnMap;
        }

        log.info("getExternalUserDetails Out");
        return returnMap;
    }

    private static Map<String, Object> getInternalUserDetails(RegBookAppModuleImpl service,
                                                              String userId,
                                                              String sql) {
        log.info("getInternalUserDetails In");
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            ViewObject vo = service.getInternaluserView1();
            vo.setWhereClause("  USERID ='" + userId + "' " + sql);
            vo.executeQuery();

            while (vo.hasNext()) {
                InternaluserViewRowImpl rowUser =
                    (InternaluserViewRowImpl)vo.next();
                returnMap.put("name", rowUser.getFULLNAME());
                returnMap.put("depName", rowUser.getDepName());
                returnMap.put("emailId", rowUser.getEMAIL());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return returnMap;
        }

        log.info("getInternalUserDetails Out");
        return returnMap;
    }

    private static List<File> getAttachments(String attachmentIteratorName,
                                             String enquiryFAQId) {
        List<File> returnList = new ArrayList<File>();
        if (enquiryFAQId != null && !enquiryFAQId.equals("")) {
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();
            String emailTemplateLocation =
                BaseUtil.getStr(props.getProperty("email_template_location"));
            ViewObject vo =
                ADFUtils.findIterator(attachmentIteratorName).getViewObject();
            vo.setNamedWhereClauseParam("bindEnqId", enquiryFAQId);
            vo.executeQuery();
            log.info("getEstimatedRowCount:-" + vo.getEstimatedRowCount());
            if (vo.getEstimatedRowCount() > 0) {
                log.info("getEstimatedRowCount:-" + vo.getEstimatedRowCount());
                Row row = vo.first();
                String filenameOrig =
                    BaseUtil.getStr(row.getAttribute("filenameOrig"));
                String filenameStore =
                    BaseUtil.getStr(row.getAttribute("filenameStore"));
                addAttachments(returnList, filenameOrig, filenameStore,
                               emailTemplateLocation);
                while (vo.hasNext()) {
                    log.info("getEstimatedRowCount:-" +
                             vo.getEstimatedRowCount());
                    row = vo.next();
                    filenameOrig =
                            BaseUtil.getStr(row.getAttribute("filenameOrig"));
                    filenameStore =
                            BaseUtil.getStr(row.getAttribute("filenameStore"));
                    addAttachments(returnList, filenameOrig, filenameStore,
                                   emailTemplateLocation);

                }
            }
        }
        return returnList;
    }

    private static void addAttachments(List<File> returnList,
                                       String filenameOrig,
                                       String filenameStore,
                                       String emailTemplateLocation) {
        log.info("filenameOrig:-" + filenameOrig);
        log.info("filenameStore:-" + filenameStore);
        //emailTemplateLocation + "temp\\" + filenameOrig
        File downloadFile1 = new File(filenameOrig);
        OutputStream outputStream1;
        try {
            outputStream1 =
                    new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success =
                FTPUtil.getInstance().downloadFile(filenameStore, outputStream1,
                                                   null);
            outputStream1.close();

            if (success) {
                returnList.add(downloadFile1);
                System.out.println("File #1 has been downloaded successfully.");
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (SocketException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
