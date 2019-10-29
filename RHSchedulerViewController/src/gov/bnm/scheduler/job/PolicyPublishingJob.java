package gov.bnm.scheduler.job;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.PolicyViewRowImpl;
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

public class PolicyPublishingJob implements Job {
  static Logger log = Logger.getLogger(PolicyPublishingJob.class);
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
      String[] receiverEmails = {props.getProperty("NotificationToRHManagementEmail")};
      ViewObject polVO = service.getPolicyView1();
      polVO.setWhereClause(" DATEDIFF(dd, getdate(), NewIssuanceDate) =1 and isActive=1 and PriorPublishEmailFlag=0 ");
      polVO.executeQuery();
      while (polVO.hasNext()) {
        PolicyViewRowImpl row = (PolicyViewRowImpl)polVO.next();
        EmailDataBean emailBean = new EmailDataBean();
        emailBean.setSenderEmail(props.getProperty("mail.from"));
        emailBean.setSenderName(props.getProperty("mail.from.name"));
        emailBean.setReceiverEmails(receiverEmails);
        emailBean.setTemplateId("PolicyPriorToIssuance");
        Map<String, String> data = new HashMap<String, String>();
        data.put("<%title of the policy%>", row.getGuidelineTitle());
        data.put("<%issuance date%>",DateUtils.convertDateWithFullMonth(row.getNewIssuanceDate()));
        data.put("<%summary%>", row.getSummary());
        String highlights = BaseUtil.getStr(row.getHighlights());
        if (!highlights.equals("")) {
          data.put("<%Latest Highlights%>",
                   "Highlights: " + row.getHighlights());
        }
        String polDepName = EmailUtils.getPolDepName(service, row.getitemId());
        String polAuthName = EmailUtils.getPolAuthName(service, row.getitemId());
        data.put("<%Department%>", polDepName);
        data.put("<%author%>", polAuthName);
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

