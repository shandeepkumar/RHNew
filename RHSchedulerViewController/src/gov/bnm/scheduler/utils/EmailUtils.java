package gov.bnm.scheduler.utils;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.adapter.EmailManager;
import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.ExternaluserViewRowImpl;
import gov.bnm.rh.views.InternaluserViewRowImpl;

import gov.bnm.rh.views.PolicybnmuserspartitionViewRowImpl;
import gov.bnm.rh.views.Policybusinesssectorpartition1ViewRowImpl;
import gov.bnm.rh.views.PolicydepartmentpartitionViewRowImpl;
import gov.bnm.rh.views.PolicyinstitutiontypepartitionViewRowImpl;
import gov.bnm.rh.views.PolicyorganizationpartitionViewRowImpl;
import gov.bnm.rh.views.RequestlistViewRowImpl;

import gov.bnm.scheduler.job.EnquiryJob;

import java.util.HashMap;
import java.util.Map;

import java.util.Properties;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import org.apache.log4j.Logger;

public class EmailUtils {
  static Logger log = Logger.getLogger(EmailUtils.class);
  public static final String APPMODULEDEF = "gov.bnm.rh.RegBookAppModule";
  public static final String CONFIG = "RegBookAppModuleLocal";
 
  public static String getEmailIdsInternalUser(RegBookAppModuleImpl service,
                                                String itemId, String userType,
                                                String userId, String sql) {
    log.info("getEmailIdsInternalUser In");
    String emails = "";
    try {
      ViewObject vo = service.getInternaluserView1();
      if (userType.equals("ADMIN")) {
        vo.setWhereClause(" ID IN (SELECT USERID FROM [dbo].[INTERNALUSER_USERGROUP] WHERE GROUPID ='" +
                          Constants.USER_ROLE_TYPE_ID_RH_ADMIN + "' ) " +
                          sql);
      } else if (itemId != null && !itemId.equals("")) {
        String depIds = getDepInString(service, itemId);
        vo.setWhereClause(" ID IN (SELECT USERID FROM [dbo].[INTERNALUSER_USERGROUP] WHERE GROUPID ='" +
                          Constants.USER_ROLE_TYPE_ID_RH_DEP_DIRECTOR +
                          "' ) and DEPTID in " + depIds + "  " + sql);
      } else if (userId != null && !userId.equals("")) {
        vo.setWhereClause(" USERID='" + userId + "'");
      }else{
        vo.setWhereClause(" ID not IN (SELECT USERID FROM [dbo].[INTERNALUSER_USERGROUP] WHERE GROUPID ='" +
                          Constants.USER_ROLE_TYPE_ID_RH_ADMIN + "' ) " +
                          sql);
      }
      vo.executeQuery();

      while (vo.hasNext()) {
        InternaluserViewRowImpl rowUser = (InternaluserViewRowImpl)vo.next();
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

  public static String getEmailIdsExternalUser(RegBookAppModuleImpl service,
                                                String userId, String sql) {
    log.info("getEmailIdsExternalUser In");
    //RegBookAppModuleImpl service = (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF , CommonRHUtil.CONFIG);
    String emails = "";
    try {
      ViewObject vo = service.getExternaluserView1();
      vo.setWhereClause("  USERID ='" + userId + "' " + sql);
      vo.executeQuery();

      while (vo.hasNext()) {
        ExternaluserViewRowImpl rowUser = (ExternaluserViewRowImpl)vo.next();
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

  public static Map<String, Object> getExternalUserDetails(RegBookAppModuleImpl service,
                                                            String userId,
                                                            String sql) {
    log.info("getExternalUserDetails In");
    Map<String, Object> returnMap = new HashMap<String, Object>();
    try {
      ViewObject vo = service.getExternaluserView1();
      vo.setWhereClause("  USERID ='" + userId + "' " + sql);
      vo.executeQuery();

      while (vo.hasNext()) {
        ExternaluserViewRowImpl rowUser = (ExternaluserViewRowImpl)vo.next();
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

  public static Map<String, Object> getInternalUserDetails(RegBookAppModuleImpl service,
                                                            String userId,
                                                            String sql) {
    log.info("getInternalUserDetails In");
    Map<String, Object> returnMap = new HashMap<String, Object>();
    try {
      ViewObject vo = service.getInternaluserView1();
      vo.setWhereClause("  USERID ='" + userId + "' " + sql);
      vo.executeQuery();

      while (vo.hasNext()) {
        InternaluserViewRowImpl rowUser = (InternaluserViewRowImpl)vo.next();
        returnMap.put("name", rowUser.getFULLNAME());
        returnMap.put("depName", rowUser.getDepName());
      }

    } catch (Exception e) {
      log.error(e.getMessage());
      return returnMap;
    }

    log.info("getInternalUserDetails Out");
    return returnMap;
  }
  public static String getDepInString(RegBookAppModuleImpl service,
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
          "'" + BaseUtil.getStr(row.getAttribute("departmentId")) + "',";
    }
    returnVal += ")";
    returnVal = returnVal.replace(",)", ")");
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
                                     String itemId,int partitionTypeId) {
    String returnVal = "";
    if(partitionTypeId == 1){
      ViewObject VO = service.getPolicybusinesssectorpartition1View1();
      VO.setNamedWhereClauseParam("bindItemId", itemId);
      VO.executeQuery();
      while (VO.hasNext()) {
        Policybusinesssectorpartition1ViewRowImpl row =
          (Policybusinesssectorpartition1ViewRowImpl)VO.next();
        returnVal += BaseUtil.getStr(row.getSectorName()) + ",";
      }
    }else if(partitionTypeId == 2){
      ViewObject VO = service.getPolicyinstitutiontypepartitionView1();
      VO.setNamedWhereClauseParam("bindItemId", itemId);
      VO.executeQuery();
      while (VO.hasNext()) {
        PolicyinstitutiontypepartitionViewRowImpl row =
          (PolicyinstitutiontypepartitionViewRowImpl)VO.next();
        returnVal += BaseUtil.getStr(row.getInstitutiontypeName()) + ",";
      }
    }else if(partitionTypeId == 3){
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
  public static String getOrganizationIds(RegBookAppModuleImpl service,
                                          String itemId, int partitionTypeId) {
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
        institutiontypeIds += "'" + BaseUtil.getStr(row.getid()) + "',";
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
        returnVal += "'" + BaseUtil.getStr(row.getAttribute("id")) + "',";
      }
    }
    returnVal = returnVal + ")";
    returnVal = returnVal.replace(",)", ")");
    return returnVal;
  }
  public static String getEmailIdsExternalCeoAdmin(RegBookAppModuleImpl service,
                                                    String organizationIds,
                                                    String sql) {
    log.info("getEmailIdsExternalUser In");
    String emails = "";
    try {
      ViewObject vo = service.getExternaluserView1();
      vo.setWhereClause("  ORGID  IN " + organizationIds +
                        " AND USERID IN (SELECT USERID FROM [dbo].[USER_USERGROUP] WHERE GROUPID IN ('" +
                        Constants.USER_ROLE_TYPE_ID_RH_FIADMIN + "', '" +
                        Constants.USER_ROLE_TYPE_ID_RH_CEO + "'))" + sql);
      vo.executeQuery();

      while (vo.hasNext()) {
        ExternaluserViewRowImpl rowUser = (ExternaluserViewRowImpl)vo.next();
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
}
