package gov.bnm.scheduler.job;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.PolicyViewRowImpl;
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

public class PolicyOnDayPublishingJob implements Job {
  static Logger log = Logger.getLogger(PolicyOnDayPublishingJob.class);

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    EmailManager emailManager = new EmailManager();

    PropertyFileConfigManager propertyFileConfigManager =
      PropertyFileConfigManager.getInstance();
    Properties props =
      propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION +
                                              FileUtil.RH_PROP_FILE);
    RegBookAppModuleImpl service =
      (RegBookAppModuleImpl)Configuration.createRootApplicationModule(EmailUtils.APPMODULEDEF,
                                                                      EmailUtils.CONFIG);

    try {
      //      String[] receiverEmails =
      //        BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service, "", "", "",
      //                                                           "")).split(";");
      String[] receiverEmails =
      { props.getProperty("NotificationToInternalStakeholders") };


      ViewObject polVO2 = service.getPolicyView1();
      polVO2.setWhereClause(" DATEDIFF(dd, getdate(), NewIssuanceDate) =0 and isActive=1 and PublishedEmailFlag =0 ");
      polVO2.executeQuery();
      while (polVO2.hasNext()) {
        PolicyViewRowImpl row = (PolicyViewRowImpl)polVO2.next();
        //BNM
        EmailDataBean emailBean = new EmailDataBean();
        emailBean.setSenderEmail(props.getProperty("mail.from"));
        emailBean.setSenderName(props.getProperty("mail.from.name"));
        emailBean.setReceiverEmails(receiverEmails);
        emailBean.setTemplateId("PublishedNotificationBNM");
        Map<String, String> data = new HashMap<String, String>();
        data.put("<%title of the policy%>", row.getGuidelineTitle());
        data.put("<%issuance date%>",
                 DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
        String applicability =
          EmailUtils.getApplicability(service, row.getitemId(),
                                      row.getpartitionTypeId());
        data.put("<%Applicability%>", applicability);
        emailBean.setDataMap(data);
        emailManager.sendEmail(emailBean);
        //FI
        String organizationIds =
          EmailUtils.getOrganizationIds(service, row.getitemId(),
                                        row.getpartitionTypeId());
        String[] receiverEmailsExter =
          EmailUtils.getEmailIdsExternalCeoAdmin(service, organizationIds,
                                                 "").split(";");
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
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      Configuration.releaseRootApplicationModule(service, true);
    }
  }


}

