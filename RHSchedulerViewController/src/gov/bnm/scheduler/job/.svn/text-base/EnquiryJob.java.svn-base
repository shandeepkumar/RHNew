package gov.bnm.scheduler.job;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqPendingViewObjRowImpl;
import gov.bnm.scheduler.utils.BaseUtil;
import gov.bnm.scheduler.utils.DateUtils;
import gov.bnm.scheduler.utils.EmailUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EnquiryJob implements Job {
  static Logger log = Logger.getLogger(EnquiryJob.class);
  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    EmailManager emailManager = new EmailManager();

    PropertyFileConfigManager propertyFileConfigManager =
      PropertyFileConfigManager.getInstance();
    RegBookAppModuleImpl service =
      (RegBookAppModuleImpl)Configuration.createRootApplicationModule(EmailUtils.APPMODULEDEF,
                                                                      EmailUtils.CONFIG);

    try {
      EmailDataBean emailBean = new EmailDataBean();
      Properties props =
        propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION +
                                                FileUtil.RH_PROP_FILE);
      String reminder =BaseUtil.getStr(props.getProperty("rh.Reminder.Enquiry"));
      emailBean.setSenderEmail(props.getProperty("mail.from"));
      emailBean.setSenderName(props.getProperty("mail.from.name"));
      String webServerAddress =
        BaseUtil.getStr(props.getProperty("rh.webServer.address")) +"/"+
        BaseUtil.getStr(props.getProperty("rh.contextPath"));
      ViewObject vo = service.getEnquiryfaqForEnqPendingViewObj1();
      vo.setWhereClause(" DATEDIFF(dd, createDate,getdate()) ="+reminder);
      vo.executeQuery();
      String[] receiverEmails =
        BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service, "",
                                                           "ADMIN", "",
                                                           "")).split(";");
      while (vo.hasNext()) {
        EnquiryfaqForEnqPendingViewObjRowImpl enqRow =
          (EnquiryfaqForEnqPendingViewObjRowImpl)vo.next();
        String isInternalExternal =
          BaseUtil.getStr(enqRow.getisInternalExternal());
        String nameOfEnquirer = "";
        String depName = "";
        //TO
        
//        String[] receiverEmails =
//          BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service,
//                                                             BaseUtil.getStr(enqRow.getitemId()),
//                                                             "Director", "",
//                                                             "")).split(";");
//        emailBean.setReceiverEmails(receiverEmails);
        //CC
       
//        emailBean.setCcReceiverEmails(ccReceiverEmails);
        //CR on 12/03/2015 send only admin
        emailBean.setReceiverEmails(receiverEmails);
        emailBean.setTemplateId("ResponseReminderEnquiry");
        if("IN".equals(isInternalExternal)){
        Map<String, Object> userMap =
          EmailUtils.getInternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()),
                                 "");
          nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
          depName = BaseUtil.getStr(userMap.get("depName"));
        }else{
          Map<String, Object> userMap =
          EmailUtils.getExternalUserDetails(service, BaseUtil.getStr(enqRow.getcreatedBy()), "");
          nameOfEnquirer = BaseUtil.getStr(userMap.get("name"));
          depName = BaseUtil.getStr(userMap.get("orgName"));
        }
        Map<String, String> data = new HashMap<String, String>();
        data.put("<%policy title%>", BaseUtil.getStr(enqRow.getPolicyTitle()));
        data.put("<%name of enquirer%>", nameOfEnquirer);
        data.put("<%name of supervised institution or department %>", depName);
        data.put("<%Question%>", BaseUtil.getStr(enqRow.getTitle()));
        data.put("<%date of enquiry%>",DateUtils.convertDateStr(enqRow.getcreateDate()));
        data.put("<%URL%>",
                 props.getProperty("rh.email.webServer.address") + "PolicyEnquiryResponse?enquiryFAQId=" +
                 BaseUtil.getStr(enqRow.getEnquiryFAQId()) );
//                 "&fldUserAction=ENQRES");
        emailBean.setDataMap(data);
        emailManager.sendEmail(emailBean);
      }

    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      Configuration.releaseRootApplicationModule(service, true);
    }
  }
}
