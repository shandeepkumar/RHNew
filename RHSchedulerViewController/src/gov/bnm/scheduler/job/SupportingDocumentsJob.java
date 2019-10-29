package gov.bnm.scheduler.job;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.RequestlistViewRowImpl;
import gov.bnm.scheduler.utils.BaseUtil;
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

public class SupportingDocumentsJob implements Job {
  static Logger log = Logger.getLogger(SupportingDocumentsJob.class);
  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    EmailManager emailManager = new EmailManager();

    PropertyFileConfigManager propertyFileConfigManager =
      PropertyFileConfigManager.getInstance();
    RegBookAppModuleImpl service =
      (RegBookAppModuleImpl)Configuration.createRootApplicationModule(EmailUtils.APPMODULEDEF,
                                                                      EmailUtils.CONFIG);
    Properties props =
      propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION +
                                              FileUtil.RH_PROP_FILE);
    String reminder =BaseUtil.getStr(props.getProperty("rh.Reminder.SupportingDocuments"));
      String webServerAddress =
        BaseUtil.getStr(props.getProperty("rh.webServer.address")) +"/"+
        BaseUtil.getStr(props.getProperty("rh.contextPath"));
    try {
      EmailDataBean emailBean = new EmailDataBean();
      emailBean.setSenderEmail(props.getProperty("mail.from"));
      emailBean.setSenderName(props.getProperty("mail.from.name"));
      ViewObject vo = service.getRequestlistView1();
      vo.setWhereClause(" status ='PENDING' AND DATEDIFF(dd, createDate,getdate()) = "+reminder);
      vo.executeQuery();
      String[] ccReceiverEmails =
        BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service, "",
                                                           "ADMIN", "",
                                                           "")).split(";");
      while (vo.hasNext()) {
        RequestlistViewRowImpl reqRow = (RequestlistViewRowImpl)vo.next();
        //TO
        String[] receiverEmails =
          BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service,
                                                             BaseUtil.getStr(reqRow.getitemId()),
                                                             "Director", "",
                                                             "")).split(";");
        emailBean.setReceiverEmails(receiverEmails);
        //CC        
        emailBean.setCcReceiverEmails(ccReceiverEmails);
        emailBean.setTemplateId("RequestForAccessSuppDocs");
        Map<String, String> data = new HashMap<String, String>();
        data.put("<%supporting doc name%>",
                 BaseUtil.getStr(reqRow.gettypeOfReqName()));
        data.put("<%policy document title%>",
                 BaseUtil.getStr(reqRow.getGuidelineTitle()));
        data.put("<%Requester Name%>", reqRow.getRequestorName());
        data.put("<%Requester Designation%>",
                 BaseUtil.getStr(reqRow.getDesignationName()));
        data.put("<%Requester Department%>",
                 reqRow.getRequestorDepartmentName());
        data.put("<%Reason for request%>",
                 BaseUtil.getStr(reqRow.getreasonForRequest()));
          data.put("<%URL%>",
                   props.getProperty("rh.email.webServer.address") + "SupportingDocumentsRequestDecision?requestId=" +
                   BaseUtil.getStr(reqRow.getrequestId()) );
//                   "&fldUserAction=SDRD");
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

