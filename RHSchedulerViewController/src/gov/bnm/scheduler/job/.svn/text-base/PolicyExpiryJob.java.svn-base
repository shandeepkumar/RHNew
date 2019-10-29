package gov.bnm.scheduler.job;


import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;

import gov.bnm.rh.RegBookAppModuleImpl;

import gov.bnm.rh.views.PolicyAgingEmailViewObjRowImpl;

import gov.bnm.rh.views.PolicyViewRowImpl;

import gov.bnm.scheduler.utils.BaseUtil;
import gov.bnm.scheduler.utils.DateUtils;
import gov.bnm.scheduler.utils.EmailUtils;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PolicyExpiryJob implements Job {

  static Logger log = Logger.getLogger(PolicyExpiryJob.class);

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    EmailManager emailManager = new EmailManager();

    PropertyFileConfigManager propertyFileConfigManager =
      PropertyFileConfigManager.getInstance();
    RegBookAppModuleImpl service =
      (RegBookAppModuleImpl)Configuration.createRootApplicationModule(EmailUtils.APPMODULEDEF,
                                                                      EmailUtils.CONFIG);

    try {
      List<PolicyAgingEmailViewObjRowImpl> goingExpireList =
        new ArrayList<PolicyAgingEmailViewObjRowImpl>();
      List<PolicyAgingEmailViewObjRowImpl> expiredList =
        new ArrayList<PolicyAgingEmailViewObjRowImpl>();
      List<PolicyAgingEmailViewObjRowImpl> oneDayToExpiredList =
        new ArrayList<PolicyAgingEmailViewObjRowImpl>();
      log.info("scheduler started::");
      log.info("scheduler started:service:" + service.getPolicyArchiveOnly1());
      Properties props =
        propertyFileConfigManager.getConfigFile(FileUtil.RH_LOCATION +
                                                FileUtil.RH_PROP_FILE);
      //            String webServerAddress =
      //                BaseUtil.getStr(props.getProperty("rh.webServer.address")) +
      //                "/" + BaseUtil.getStr(props.getProperty("rh.contextPath"));
      int policyDuration =
        BaseUtil.getInt(props.getProperty("rh.PolicyDuration"));
      String legislationKey =
        BaseUtil.getStr(props.getProperty("rh.Legislation.Key"));
      ViewObject voAge = service.getPolicyAgingEmailViewObj1();
      voAge.setNamedWhereClauseParam("bindPolicyAge", policyDuration);
      voAge.setNamedWhereClauseParam("bindPolicyAge1", policyDuration);
      voAge.setNamedWhereClauseParam("bindDocCategory", legislationKey);
      voAge.setNamedWhereClauseParam("bindPolicyAge2", policyDuration);
      voAge.executeQuery();
      log.info(" count::" + voAge.getEstimatedRowCount());
      while (voAge.hasNext()) {
        PolicyAgingEmailViewObjRowImpl rowAge =
          (PolicyAgingEmailViewObjRowImpl)voAge.next();
        log.info(" rowAge.getdaysDiff()::" + rowAge.getdaysDiff());
        if (rowAge.getdaysDiff() == 182 || rowAge.getdaysDiff() == 365) {
          goingExpireList.add(rowAge);
        } else if (rowAge.getdaysDiff() == 1) {
          oneDayToExpiredList.add(rowAge);
        } else if (rowAge.getdaysDiff() < 0 ) {
          expiredList.add(rowAge);
        }
      }
      if (expiredList.size() > 0) {
        for (PolicyAgingEmailViewObjRowImpl polAge : expiredList) {
          String itemId = polAge.getitemId();
          ViewObject polVO = service.getPolicyView1();
          polVO.setWhereClause(" itemId='" + itemId + "'");
          log.info("itemId::" + itemId);
          polVO.executeQuery();
          while (polVO.hasNext()) {
            PolicyViewRowImpl rowpol = (PolicyViewRowImpl)polVO.next();
            rowpol.setRecordStatus("ARCHIVE");
            rowpol.setisActive(false);

          }

          log.info("After while loop execute... ");
          service.getDBTransaction().commit();
        }
      }
      if (oneDayToExpiredList.size() > 0) {
        for (PolicyAgingEmailViewObjRowImpl polAge : oneDayToExpiredList) {
          EmailDataBean emailBean = new EmailDataBean();
          //From Email Id
          emailBean.setSenderEmail(props.getProperty("mail.from"));
          emailBean.setSenderName(props.getProperty("mail.from.name"));
          String[] ccReceiverEmails =
            BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service, "",
                                                               "ADMIN", "",
                                                               "")).split(";");
          //cc Email Id
          emailBean.setCcReceiverEmails(ccReceiverEmails);
          String itemId = polAge.getitemId();
          String[] receiverEmails =
            BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service,
                                                               BaseUtil.getStr(itemId),
                                                               "Director", "",
                                                               "")).split(";");
          //to Email Id
          emailBean.setReceiverEmails(receiverEmails);

          emailBean.setTemplateId("notificationOfPolicyExpiryArchive");
          Map<String, String> data = new HashMap<String, String>();
          data.put("<%Policy Name%>", polAge.getGuidelineTitle());
          data.put("<%date%>", DateUtils.convertDateFullMonth(1));
          //              data.put("<%PolicyId%>", polAge.getitemId());
          //              data.put("<%URL%>",
          //                       props.getProperty("rh.email.webServer.address") + "&fldPolicyId=" +
          //                       BaseUtil.getStr(polAge.getitemId()) +
          //                       "&fldUserAction=PACP");
          emailBean.setDataMap(data);
          emailManager.sendEmail(emailBean);
        }
      }
      if (goingExpireList.size() > 0) {

        for (PolicyAgingEmailViewObjRowImpl polAge : goingExpireList) {
          //to get RH Admin
          //List<String> receiverEmailsList = new ArrayList<String>();
          EmailDataBean emailBean = new EmailDataBean();
          //From Email Id
          emailBean.setSenderEmail(props.getProperty("mail.from"));
          emailBean.setSenderName(props.getProperty("mail.from.name"));
          String[] ccReceiverEmails =
            BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service, "",
                                                               "ADMIN", "",
                                                               "")).split(";");
          //cc Email Id
          emailBean.setCcReceiverEmails(ccReceiverEmails);
          String itemId = polAge.getitemId();
          String[] receiverEmails =
            BaseUtil.getStr(EmailUtils.getEmailIdsInternalUser(service,
                                                               BaseUtil.getStr(itemId),
                                                               "Director", "",
                                                               "")).split(";");
          //to Email Id
          emailBean.setReceiverEmails(receiverEmails);

          emailBean.setTemplateId("notificationOfPolicyExpiry");
          Map<String, String> data = new HashMap<String, String>();
          data.put("<%Policy Name%>", polAge.getGuidelineTitle());
          data.put("<%date%>",
                   DateUtils.convertDateWithFullMonth(polAge.getNewIssuanceDate(),policyDuration));
          data.put("<%PolicyId%>", polAge.getitemId());
          data.put("<%URL%>",
                   props.getProperty("rh.email.webServer.address") + "policyAgingConfirmation?fldPolicyId=" +
                   BaseUtil.getStr(polAge.getitemId()) );
//                   "&fldUserAction=PACP");
          emailBean.setDataMap(data);
          emailManager.sendEmail(emailBean);
        }
      }

    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      Configuration.releaseRootApplicationModule(service, true);
    }

    log.info("sendMailNotificationOfAnnual Out");

  }

}
