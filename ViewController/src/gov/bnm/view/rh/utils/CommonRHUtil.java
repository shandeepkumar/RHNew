package gov.bnm.view.rh.utils;


import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.rh.views.ExternaluserViewRowImpl;
import gov.bnm.rh.views.InternaluserViewRowImpl;
import gov.bnm.rh.views.ItemlistViewRowImpl;
import gov.bnm.rh.views.PolicyViewRowImpl;
import gov.bnm.rh.views.PolicyamendmentsViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;

import gov.view.common.validation.ValidatorUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewAttributeDefImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.log4j.Logger;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;


public class CommonRHUtil {
    static Logger log = Logger.getLogger(CommonRHUtil.class);

    public static final String APPMODULEDEF = "gov.bnm.rh.RegBookAppModule";
    public static final String CONFIG = "RegBookAppModuleLocal";
    public static Properties props;

    public static String alignHtml(String textInput) {
        log.info("Real text  :  " + textInput);
        String returnStr = "";
        Set<String> css = new HashSet<String>();
        try {
            Pattern textAlign =
                Pattern.compile("(?i)font-weight: bold;|font-weight:bold;|font-style: italic;|font-style:italic;|text-decoration: underline;|text-decoration:underline;");
            HtmlPolicyBuilder htmlPolicyBuilder = new HtmlPolicyBuilder();
            PolicyFactory policy =
                (htmlPolicyBuilder.allowElements("table", "tr", "td", "th",
                                                 "span", "p", "div", "ul",
                                                 "ol",
                                                 "li").disallowElements("h1",
                                                                        "h2",
                                                                        "h3",
                                                                        "h4").allowAttributes("border").onElements("table").allowAttributes("width").onElements("table").allowAttributes("style").matching(textAlign).onElements("span")).toFactory();
            //                .allowAttributes("style").matching(new AttributePolicy() {
            //                    public String apply(String elementName,
            //                                        String attributeName, String value) {
            //                        String returnVal = "";
            //                        if (value.equals("font-weight: bold;") ||
            //                            value.equals("font-weight:bold;")) {
            //                            returnVal = "font-weight: bold;";
            //                        } else if (value.equals("font-style: italic;") ||
            //                                   value.equals("font-style:italic;")) {
            //                            returnVal = "font-style: italic;";
            //                        } else if (value.equals("text-decoration: underline;") ||
            //                                   value.equals("text-decoration:underline;")) {
            //                            returnVal = "text-decoration: underline;";
            //                        }
            //                        return returnVal.trim();
            //                    }
            //                }).onElements("span")).toFactory();

            policy =
                    policy.and(Sanitizers.FORMATTING).and(Sanitizers.IMAGES).and(Sanitizers.LINKS);
            returnStr = policy.sanitize(textInput);
            log.info("Came out.. end .." + returnStr);
        } catch (Exception e) {
            log.error("Exception @alignHtml .. " + e);
        }
        return returnStr;
    }
    //    public static String alignFont(String textInput) {
    //
    //        String textType = textInput;
    //        StringBuffer sb = new StringBuffer();
    //        try {
    //
    //            log.info("Real text  :  " + textInput);
    //            props =
    //                    PropertyFileConfigManager.getInstance().getConfigFile(FileUtil.RH_LOCATION +
    //                                                                          FileUtil.RH_PROP_FILE);
    //
    //            String[] propPatternSplit =
    //                props.getProperty("richTextEditor.regex.pattern").split(",");
    //
    //            if (propPatternSplit.length == 0) {
    //                propPatternSplit[0] =
    //                        props.getProperty("richTextEditor.regex.pattern");
    //            }
    //
    //            for (int i = 0; i < propPatternSplit.length; i++) {
    //                sb = new StringBuffer();
    //                Pattern pattern =
    //                    Pattern.compile(BaseUtil.getStr(propPatternSplit[i]),
    //                                    Pattern.CASE_INSENSITIVE);
    //                Matcher m = pattern.matcher(textInput);
    //
    //                log.info("matcher  :  " + m);
    //                //StringBuffer sb = new StringBuffer();
    //                int count = 0;
    //                while (m.find()) {
    //                    count++;
    //                    log.info("Match number " + count);
    //                    log.info("start(): " + m.start());
    //                    log.info("end(): " + m.end());
    //
    //                    m.appendReplacement(sb,
    //                                        BaseUtil.getStr(props.getProperty("richTextEditor.regex.replace.pattern")));
    //
    //
    //                    log.info("inside while : " + sb);
    //                }
    //                m.appendTail(sb);
    //                log.info("inside while : " + sb);
    //                textInput = sb.toString();
    //
    //            }
    //            //sb = new StringBuffer(textInput);
    //            log.info("Came out.. end .." + sb);
    //
    //            //richText.setValue(sb);
    //            //AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
    //        } catch (Exception e) {
    //            log.error("Exception @alignFont .. " + e);
    //        }
    //        return String.valueOf(sb);
    //
    //    }


    public static String getAmendmentOriginPolicyId(String policyId) {
        String originPolicyId = "";
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObject amendmentVO = service.getPolicyamendmentsView1();
            amendmentVO.setWhereClause("amendedPolicyId ='" + policyId + "'");
            amendmentVO.executeQuery();
            if (amendmentVO.getEstimatedRowCount() > 0) {
                Row amendRow = amendmentVO.first();
                originPolicyId =
                        BaseUtil.getStr(amendRow.getAttribute("OriginPolicyId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return originPolicyId;
    }

    public static int getAmendmentVersion(String policyId) {
        int version = 0;
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObject amendmentVO = service.getPolicyamendmentsView1();
            amendmentVO.setWhereClause("OriginPolicyId ='" + policyId + "'");
            amendmentVO.executeQuery();
            version = BaseUtil.getInt(amendmentVO.getEstimatedRowCount()) + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return version;
    }

    public static boolean doArchivePolicy(String itemId) {
        boolean status = true;
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObjectImpl policyVO = service.getPolicyView1();
            policyVO.setWhereClause("itemId ='" + itemId + "'");
            policyVO.executeQuery();
            log.info("policyVO::" + policyVO.getEstimatedRangePageCount());
            PolicyViewRowImpl oldPolicyView =
                (PolicyViewRowImpl)policyVO.first();
            oldPolicyView.setisActive(false);
            oldPolicyView.setRecordStatus(Constants.RECORD_STATUS_ARCHIVE);
            service.getDBTransaction().commit();
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return status;
    }
    
    public static boolean doActivePolicy(String itemId) {
        boolean status = true;
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObjectImpl policyVO = service.getPolicyView1();
            policyVO.setWhereClause("itemId ='" + itemId + "'");
            policyVO.executeQuery();
            log.info("policyVO::" + policyVO.getEstimatedRangePageCount());
            PolicyViewRowImpl oldPolicyView =
                (PolicyViewRowImpl)policyVO.first();
            oldPolicyView.setisActive(true);
            oldPolicyView.setRecordStatus(Constants.RECORD_STATUS_ACTIVE);
            service.getDBTransaction().commit();
        } 
        catch (Exception e) {
            status = false;
            e.printStackTrace();
        } 
        finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return status;
    }

    public static boolean doInsertAmendment(PolicyViewRowImpl rowPolicy) {
        boolean status = true;
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            Map<String, String> emailMap = new HashMap<String, String>();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            String newPolicyId = RandomGuidUtil.fnGuidWithTimestamp();
            String oldPolicyId = BaseUtil.getStr(rowPolicy.getpolicyId());
            DCIteratorBinding itemlistDCIterator =
                ADFUtils.findIterator("ItemlistView1Iterator1");
            Row itemlistRowImpl = itemlistDCIterator.getCurrentRow();

            ViewObjectImpl itemlistVO = service.getItemlistView1();
            ItemlistViewRowImpl itemtypelistRow =
                (ItemlistViewRowImpl)itemlistVO.createRow();
            itemtypelistRow.setitemid(newPolicyId);
            itemtypelistRow.setName(rowPolicy.getGuidelineTitle());
            itemtypelistRow.setReference(BaseUtil.getStr(itemlistRowImpl.getAttribute("Reference")));
            itemtypelistRow.setcreateDate(DateUtils.getCurrentTimestamp());
            itemlistVO.insertRow(itemtypelistRow);

            log.info("newPolicyId::" + newPolicyId);
            //get old record from Policy table update recoed status
            ViewObjectImpl policyVO = service.getPolicyView1();
            policyVO.setWhereClause("itemId ='" + oldPolicyId + "'");
            policyVO.executeQuery();
            log.info("policyVO::" + policyVO.getEstimatedRangePageCount());
            PolicyViewRowImpl oldPolicyView =
                (PolicyViewRowImpl)policyVO.first();
            oldPolicyView.setRecordStatus(Constants.RECORD_STATUS_AMENDHIS);
            log.info("old date::" + oldPolicyView.getitemId());

            //create new record Policy table
            ViewObjectImpl policyVO3 = service.getPolicyView3();
            Row policyNewRow = policyVO3.createRow();

            ViewAttributeDefImpl[] attrDefs =
                policyVO3.getViewAttributeDefImpls();
            log.info("attrDefs::" + attrDefs.length);
            for (ViewAttributeDefImpl attrDef : attrDefs) {
                String columnName = attrDef.getName();
                byte attrKind = attrDef.getAttributeKind();
                //String columnNameForQuery = attrDef.getColumnNameForQuery();
                if (attrKind != AttributeDef.ATTR_ASSOCIATED_ROW &&
                    attrKind != AttributeDef.ATTR_ASSOCIATED_ROWITERATOR) {
                    if (!"IssuanceStr".equals(columnName)) {
                        if (columnName.equals("itemId") ||
                            columnName.equals("policyId")) {
                            policyNewRow.setAttribute(columnName, newPolicyId);
                        } else {
                            policyNewRow.setAttribute(columnName,
                                                      BaseUtil.getStr(rowPolicy.getAttribute(columnName)));
                        }
                    }
                }
            }
            policyNewRow.setAttribute("CreatedDate",
                                      DateUtils.getCurrentTimestamp());
            policyNewRow.setAttribute("createdBy", rhSession.getFldUserid());
            policyNewRow.setAttribute("RecordStatus",
                                      Constants.RECORD_STATUS_PENDING);
            policyNewRow.setAttribute("isActive", "0");
            policyNewRow.setAttribute("PublishedEmailFlag", "0");
            policyNewRow.setAttribute("PriorPublishEmailFlag", "0");
            policyNewRow.setAttribute("LastUpdated",
                                      DateUtils.getCurrentTimestamp());
            log.info("GuidelineTitle" +
                     policyNewRow.getAttribute("GuidelineTitle"));
            log.info("approverId" + policyNewRow.getAttribute("approverId"));
            emailMap.put("createdBy", rhSession.getFldUserid());
            emailMap.put("policyId", newPolicyId);
            emailMap.put("guidelineTitle",
                         BaseUtil.getStr(policyNewRow.getAttribute("GuidelineTitle")));
            emailMap.put("approverId",
                         BaseUtil.getStr(policyNewRow.getAttribute("approverId")));
            policyVO3.insertRow(policyNewRow);
            //insert Policyamendments table
            PolicyamendmentsViewRowImpl amendmentRow =
                (PolicyamendmentsViewRowImpl)service.getPolicyamendmentsView1().createRow();
            String originPolicyId = getAmendmentOriginPolicyId(oldPolicyId);
            if (originPolicyId.equals("")) {
                originPolicyId = oldPolicyId;
            }
            amendmentRow.setAmendmentID(RandomGuidUtil.fnGuidWithDate());
            amendmentRow.setAmendmentTitle(BaseUtil.getStr(rowPolicy.getGuidelineTitle()));
            //            amendmentRow.setAmendmentEffectiveDate(BaseUtil.getStr(rowPolicy.getEffectiveDate()));
            amendmentRow.setAmendmentIssuanceDate(rowPolicy.getNewIssuanceDate());
            amendmentRow.setAmendmentHighlights(BaseUtil.getStr(rowPolicy.getSummary()));
            amendmentRow.setversion(getAmendmentVersion(originPolicyId));
            amendmentRow.setCreatedDate(DateUtils.getCurrentTimestamp());
            amendmentRow.setOriginPolicyId(originPolicyId);
            amendmentRow.setamendedPolicyId(newPolicyId);
            amendmentRow.setViewPolicyId(oldPolicyId);
            service.getPolicyamendmentsView1().insertRow(amendmentRow);
            service.getDBTransaction().commit();
            //insert Policydepartmentpartition table
            status =
                    getInsertTableRows("PolicydepartmentpartitionView1Iterator",
                                       newPolicyId,
                                       "PolicydepartmentpartitionView1");
            if (status) {
                status =
                        getInsertTableRows("AttachedfileView2_1Iterator", newPolicyId,
                                           "AttachedfileView2");
            }

            int partitionTypeId = rowPolicy.getpartitionTypeId();
            if (partitionTypeId == Constants.PARTITION_TYPE_SECTOR) {
                if (status) {
                    status =
                            getInsertTableRows("Policybusinesssectorpartition1View1Iterator",
                                               newPolicyId,
                                               "Policybusinesssectorpartition1View1");
                }
            } else if (partitionTypeId == Constants.PARTITION_TYPE_INDUSTRY) {
                if (status) {
                    status =
                            getInsertTableRows("PolicyinstitutiontypepartitionView1Iterator",
                                               newPolicyId,
                                               "PolicyinstitutiontypepartitionView1");
                }
            } else if (partitionTypeId ==
                       Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
                if (status) {
                    status =
                            getInsertTableRows("PolicyorganizationpartitionView1Iterator",
                                               newPolicyId,
                                               "PolicyorganizationpartitionView1");
                }
            }
            //

            if (status) {
                status =
                        getInsertTableRows("SuperseededpoliciesView1Iterator", newPolicyId,
                                           "SuperseededpoliciesView1");
            }
            if (status) {
                status =
                        getInsertTableRows("PolicybnmuserspartitionView1Iterator",
                                           newPolicyId,
                                           "PolicybnmuserspartitionView1");
            }
            if (status) {
                status =
                        getInsertTableRows("PolicycategoriespartitionView1Iterator",
                                           newPolicyId,
                                           "PolicycategoriespartitionView1");
            }
            if (status) {
                status =
                        getInsertTableRows("AttachedfileEx1View1Iterator", newPolicyId,
                                           "AttachedfileEx1View1");
            }
            if (status) {
                status =
                        getInsertTableRows("EnquiryfaqForFaqView1Iterator", newPolicyId,
                                           "EnquiryfaqForFaqView1");
            }
            if (status) {
                status =
                        getInsertTableRows("AttachedfileSupportDocViewObj1Iterator",
                                           newPolicyId,
                                           "AttachedfileSupportDocViewObj1");
            }
            if (status) {
                EmailUtils.sendMailPolicyPublishRequestForApproval(emailMap);
            }
        } catch (Exception e) {
            status = false;
            log.error("doInsertAmendment ::" + e.getMessage());
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return status;
    }

    public static boolean getInsertTableRows(String iteratorName,
                                             String newPolicyId,
                                             String viewObjectName) {
        boolean returnVal = true;
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {

            DCIteratorBinding iteratorBindings =
                ADFUtils.findIterator(iteratorName);
            Row[] existingRow = iteratorBindings.getAllRowsInRange();
            ViewObjectImpl vo =
                (ViewObjectImpl)service.findViewObject(viewObjectName);
            ViewAttributeDefImpl[] attrDefs = vo.getViewAttributeDefImpls();
            for (int i = 0; i < existingRow.length; i++) {
                Row row = existingRow[i];
                Row insertRow = vo.createRow();
                for (ViewAttributeDefImpl attrDef : attrDefs) {
                    String columnName = attrDef.getName();
                    byte attrKind = attrDef.getAttributeKind();
                    byte updateableFlag = attrDef.getUpdateableFlag();

                    if (attrKind != AttributeDef.ATTR_ASSOCIATED_ROW &&
                        attrKind != AttributeDef.ATTR_ASSOCIATED_ROWITERATOR &&
                        updateableFlag != AttributeDef.READONLY) {
                        if ("itemId".equals(columnName) ||
                            "policyId".equals(columnName) ||
                            "itemIdNew".equals(columnName)) {
                            insertRow.setAttribute(columnName, newPolicyId);
                        } else if ("fileId".equals(columnName) ||
                                   "EnquiryFAQId".equals(columnName)) {
                            insertRow.setAttribute(columnName,
                                                   RandomGuidUtil.fnGuidWithDate() +
                                                   i);
                        } else {
                            insertRow.setAttribute(columnName,
                                                   BaseUtil.getStr(row.getAttribute(columnName)));
                        }
                    }
                }
                vo.insertRow(insertRow);
            }
            service.getDBTransaction().commit();
        } catch (Exception e) {
            returnVal = false;
            log.error("getInsertTableRows::iteratorName:" + iteratorName +
                      " :viewObjectName::" + viewObjectName + " Msg::" +
                      e.getMessage());
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return returnVal;
    }

    public static Row getRow(ViewObjectImpl vo, Row dataRow, Row returnRow,
                             String newPolicyId) {
        ViewAttributeDefImpl[] attrDefs = vo.getViewAttributeDefImpls();
        int count = 0;
        log.info("inse getRow");
        for (ViewAttributeDefImpl attrDef : attrDefs) {

            byte attrKind = attrDefs[count].getAttributeKind();
            //checks attribute kind for each element in an array of AttributeDefs
            // if (attrKind != AttributeDef.ATTR_ASSOCIATED_ROW && attrKind != AttributeDef.ATTR_ASSOCIATED_ROWITERATOR) {
            String columnName = attrDef.getName();

            //log.info("columnName::"+columnName);
            String columnNameForQuery = attrDef.getColumnNameForQuery();
            if (columnNameForQuery.equals(columnName)) {
                if (columnName.equals("itemId") ||
                    columnName.equals("policyId")) {
                    log.info("if::" + columnName);
                    returnRow.setAttribute(columnName, newPolicyId);
                } else {
                    log.info("else::" + columnName);
                    returnRow.setAttribute(columnName,
                                           BaseUtil.getStr(dataRow.getAttribute(columnName)));
                }
            }
        }
        return returnRow;
    }

    public static String policyAgingReportSearch(String fromDateIssuranceDate,
                                                 String toDateIssuranceDate,
                                                 String fromDateEffectiveDate,
                                                 String toDateEffectiveDate,
                                                 String departmentId,
                                                 String doctypeId,
                                                 String categoryId,
                                                 String sectorId,
                                                 String status,
                                                 String publishedWebsite) {
        String returnVal = "";
        RegBookAppModuleImpl service = (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF, CONFIG);
        
        try {
        
            boolean sqlReddy = false;
            String sqlStr = " SELECT DISTINCT itemId FROM [dbo].[Policy]  ";
            if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                !fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                !status.equals("") && !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "RecordStatus = '" + status + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            } 
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                     !fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                     !status.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "RecordStatus = '" + status + "' ";
                sqlReddy = true;
            }
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                     !fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                     !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            }
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                     !status.equals("") && !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "RecordStatus = '" + status + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            }
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                     !status.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "RecordStatus = '" + status + "' ";
                sqlReddy = true;
            }
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("") && 
                     !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            }
            else if (!fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                     !status.equals("") && !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "RecordStatus = '" + status + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            }
            else if (!fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                     !status.equals("")) {
                sqlStr += "WHERE NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "RecordStatus = '" + status + "' ";
                sqlReddy = true;
            }
            else if (!fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("") &&
                     !publishedWebsite.equals("")) {
                sqlStr += "WHERE NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' AND " +
                          "PublishToBNM = '" + publishedWebsite + "' ";
                sqlReddy = true;
            }
            else if (!fromDateIssuranceDate.equals("") && !toDateIssuranceDate.equals("")) {
                sqlStr += "WHERE NewIssuanceDate BETWEEN '" + fromDateIssuranceDate + "' " + "AND '" + toDateIssuranceDate + "' ";
                sqlReddy = true;
            }
            else if (!fromDateEffectiveDate.equals("") && !toDateEffectiveDate.equals("")) {
                sqlStr += "WHERE NewEffectiveDate BETWEEN '" + fromDateEffectiveDate + "' " + "AND '" + toDateEffectiveDate + "' ";
                sqlReddy = true;
            }
            else if (!status.equals("")) {
                sqlStr += "WHERE RecordStatus ='" + status + "'";
                sqlReddy = true;
            } 
            else if (!publishedWebsite.equals("")) {
                sqlStr += "WHERE  RecordStatus IN ('ACTIVE','ARCHIVE') AND PublishToBNM='" + publishedWebsite + "' ";
                sqlReddy = true;
            }

            if (sqlReddy) {
                ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr);
                returnVal = getAllInString(vo);
                vo.remove();
            }

            // Sector Search Query
            if (!sectorId.equals("")) {
                String sqlStr1 = "SELECT DISTINCT itemId FROM [dbo].[PolicyBusinessSectorPartition1] " + "WHERE ID =" + sectorId;
                if (!returnVal.equals("")) {
                    sqlStr1 += " AND itemId IN " + returnVal;
                }
                if (!returnVal.equals("()")) {
                    ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr1);
                    returnVal = getAllInString(vo);
                    vo.remove();
                }
            }
            
            // Category Search Query
            if (!categoryId.equals("")) {
                String sqlStr1 = "SELECT DISTINCT itemId FROM PolicyCategoriesPartition " +
                                 "WHERE CategoryID =" + categoryId;
                if (!returnVal.equals("")) {
                    sqlStr1 += " AND itemId IN " + returnVal;
                }
                if (!returnVal.equals("()")) {
                    ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr1);
                    returnVal = getAllInString(vo);
                    vo.remove();
                }
            }
            
            // Document Type Query
            if (!doctypeId.equals("")) {
                String sqlStr1 = "SELECT DISTINCT itemId FROM Policy " +
                                 "WHERE DocCategory =" + doctypeId;
                if (!returnVal.equals("")) {
                    sqlStr1 += " AND itemId IN " + returnVal;
                }
                if (!returnVal.equals("()")) {
                    ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr1);
                    returnVal = getAllInString(vo);
                    vo.remove();
                }
            }
            
            // Department Id Search Query
            RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
            String userDepId = BaseUtil.getStr(rhSession.getFldDepartmentId());
            if (!userDepId.equals("ADMIN")) {
                String sqlStr1 = "SELECT DISTINCT itemId FROM [dbo].[PolicyDepartmentPartition] " +
                                 " WHERE departmentId ='" + userDepId + "' ";
                if (!returnVal.equals("")) {
                    sqlStr1 += " AND itemId IN " + returnVal;
                }
                if (!returnVal.equals("()")) {
                    ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr1);
                    returnVal = getAllInString(vo);
                    vo.remove();
                }
            } 
            else {
                if (!departmentId.equals("")) {
                    String sqlStr1 = "SELECT DISTINCT itemId FROM [dbo].[PolicyDepartmentPartition] " +
                                     " WHERE departmentId ='" + departmentId + "' ";
                    if (!returnVal.equals("")) {
                        sqlStr1 += " AND itemId IN " + returnVal;
                    }
                    if (!returnVal.equals("()")) {
                        ViewObject vo = service.createViewObjectFromQueryStmt("QueryVo", sqlStr1);
                        returnVal = getAllInString(vo);
                        vo.remove();
                    }
                }
            }
        } 
        catch (Exception e) {
            returnVal = "";
            e.printStackTrace();
        } 
        finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return returnVal;
    }

    private static String getAllInString(ViewObject vo) {
        String returnVal = "(";
        vo.executeQuery();
        log.info("executeQuery::");
        while (vo.hasNext()) {
            Row row = vo.next();
            // DO what do you want in Row
            returnVal += "'" + row.getAttribute("itemId") + "',";
        }
        returnVal += ")";
        returnVal = returnVal.replace(",)", ")");
        return returnVal;
    }

    public static Map<String, String> getUserDetails(String userId) {
        Map<String, String> userMap = new HashMap<String, String>();
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        String userType = null;
        try {
            ViewObject vo = service.getExternaluserView1();
            vo.setWhereClause(" EMAIL='" + userId + "' ");
            vo.executeQuery();
            String exterUserId = "";
            while (vo.hasNext()) {
                ExternaluserViewRowImpl row =
                    (ExternaluserViewRowImpl)vo.next();
                userMap.put("userId", row.getEMAIL());
                userMap.put("fullName", row.getFULLNAME());
                userMap.put("depName", row.getDEPARTMENT());
                userMap.put("designation", row.getDESIGNATION());
                userMap.put("isInternalExternal",
                            Constants.IS_INTERNAL_OR_EXTERNAL_EX);
                userMap.put("depId", "");
                userMap.put("orgId", row.getORGID());
                userType = "FI";
                exterUserId = row.getUSERID();
            }
            if (!exterUserId.equals("")) {
                ViewObject exterGroupVO = service.getUserUsergroupView1();
                exterGroupVO.setWhereClause(" USERID='" + exterUserId + "' ");
                exterGroupVO.executeQuery();
                while (exterGroupVO.hasNext()) {
                    Row rowGroup = exterGroupVO.next();
                    userMap.put("fldUserType",
                                BaseUtil.getStr(rowGroup.getAttribute("GROUPID")));
                }
            }

            if (ValidatorUtil.isNull(userType)) {
                vo = service.getInternaluserView1();
                vo.setWhereClause(" USERID='" + userId + "' ");
                vo.executeQuery();
                String id = "";
                while (vo.hasNext()) {
                    InternaluserViewRowImpl row =
                        (InternaluserViewRowImpl)vo.next();
                    userMap.put("userId", row.getUSERID());
                    userMap.put("fullName", row.getFULLNAME());
                    id = BaseUtil.getStr(row.getID());
                    userMap.put("designation", row.getDESIGNATION());
                    userMap.put("isInternalExternal",
                                Constants.IS_INTERNAL_OR_EXTERNAL_IN);
                    userMap.put("depId", row.getDEPTID());
                    if (ValidatorUtil.isNotNull(row.getDepName())) {
                        userMap.put("depName", row.getDepName());
                    }
                    userMap.put("orgId", "");
                    userType = "BNM";
                }
                if (!id.equals("")) {
                    ViewObject interGroupVO =
                        service.getInternaluserUsergroupView1();
                    interGroupVO.setWhereClause(" USERID='" + id + "' ");
                    interGroupVO.executeQuery();
                    while (interGroupVO.hasNext()) {
                        Row rowGroup = interGroupVO.next();
                        userMap.put("fldUserType",
                                    BaseUtil.getStr(rowGroup.getAttribute("GROUPID")));
                    }
                }
            }

            log.info("User Type print in CommonRh Util  :  " + userType);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return userMap;
    }

    public static boolean getDepInString() {

        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        log.info("print department Id :  " + rhSession.getFldDepartmentId());
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            if (!Constants.USER_ROLE_TYPE_ID_RH_ADMIN.equals(rhSession.getFldUserType())) {
                ViewObject depVO = service.getPolicydepartmentpartitionView1();

                depVO.setNamedWhereClauseParam("bindItemId",
                                               rhSession.getFldPolicyId());
                depVO.setWhereClause("departmentId='" +
                                     rhSession.getFldDepartmentId() + "'");

                depVO.executeQuery();

                log.info("executeQuery::" + depVO.getEstimatedRowCount());
                while (depVO.hasNext()) {
                    Row row = depVO.next();
                    rhSession.setFldUserAction("ISSDP");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return false;
    }

    /**
     * @deprecated
     *
     * Change for this method below CR Dec 6 th 2017 by shankar
     * isAuthorisedToViewPolicyMultiOrgInst
     * @return
     */
    public static boolean isAuthorisedToViewPolicy() {
        int partitionTypeId = 0;
        String sector = "";
        String instType = "";
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        log.info("print department Id :  " + rhSession.getFldDepartmentId());
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObject polVO = service.getPolicyView1();
            polVO.setWhereClause("itemId='" + rhSession.getFldPolicyId() +
                                 "'");
            polVO.executeQuery();

            log.info("PolicyViewRowImpl executeQuery::" +
                     polVO.getEstimatedRowCount());
            while (polVO.hasNext()) {
                PolicyViewRowImpl row = (PolicyViewRowImpl)polVO.next();
                partitionTypeId = row.getpartitionTypeId();
                log.info("partitionTypeId::" + partitionTypeId);
            }

            ViewObjectImpl voOrg = service.getOrganizationView1();
            voOrg.setWhereClause("id=" + rhSession.getFldOrgId());
            voOrg.executeQuery();
            Row row = voOrg.first();
            if (row != null) {
                sector = row.getAttribute("Sectorid").toString();
                instType = row.getAttribute("INSTTYPE").toString();
            }
            if (partitionTypeId == Constants.PARTITION_TYPE_SECTOR) {
                ViewObjectImpl voSector =
                    service.getPolicybusinesssectorpartition1View1();
                voSector.setNamedWhereClauseParam("bindItemId",
                                                  rhSession.getFldPolicyId());
                voSector.setWhereClause("ID =" + sector);
                voSector.executeQuery();
                if (voSector.getEstimatedRowCount() > 0) {
                    return true;
                }
            } else if (partitionTypeId == Constants.PARTITION_TYPE_INDUSTRY) {
                ViewObjectImpl voInstType =
                    service.getPolicyinstitutiontypepartitionView1();
                voInstType.setNamedWhereClauseParam("bindItemId",
                                                    rhSession.getFldPolicyId());
                voInstType.setWhereClause("id ='" + instType + "'");
                voInstType.executeQuery();
                if (voInstType.getEstimatedRowCount() > 0) {
                    return true;
                }
            } else if (partitionTypeId ==
                       Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
                ViewObjectImpl voOrgPart =
                    service.getPolicyorganizationpartitionView1();
                voOrgPart.setNamedWhereClauseParam("bindItemId",
                                                   rhSession.getFldPolicyId());
                voOrgPart.setWhereClause("id ='" + rhSession.getFldOrgId() +
                                         "'");
                voOrgPart.executeQuery();
                if (voOrgPart.getEstimatedRowCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return false;
    }


    /**
     *      * Add this method for avoid the below isAuthorisedToViewPolicy.
     * Change for this method below CR Dec 6 th 2017 by shankar
     * isAuthorisedToViewPolicyMultiOrgInst
     * @return
     */
    public static boolean isAuthorisedToViewPolicyMultiOrgInst() {
        int partitionTypeId = 0;
        String sector = "";
        String instType = "";
        String instTypeId = null;
        String sectorId = null;

        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        log.info("print department Id :  " + rhSession.getFldDepartmentId());
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);
        try {
            ViewObject polVO = service.getPolicyView1();
            polVO.setWhereClause("itemId='" + rhSession.getFldPolicyId() +
                                 "'");
            polVO.executeQuery();

            log.info("PolicyViewRowImpl executeQuery::" +
                     polVO.getEstimatedRowCount());
            while (polVO.hasNext()) {
                PolicyViewRowImpl row = (PolicyViewRowImpl)polVO.next();
                partitionTypeId = row.getpartitionTypeId();
                log.info("partitionTypeId::" + partitionTypeId);
            }

            log.info("userId : " + rhSession.getFldUserid());


            ViewObjectImpl voExOrg =
                service.getExternaluserorganizationView1();
            voExOrg.setWhereClause("USERID='" + rhSession.getFldUserid() +
                                   "'");
            voExOrg.executeQuery();

            //String orgId = getAllInString(voExOrg, "ORGID");
            String orgId =
                "(".concat(getAllInString(voExOrg, "ORGID").concat(")"));
            orgId = orgId.replace(",)", ")");


            ViewObjectImpl voOrgInst =
                service.getOrganizationinstitutiontypeMultiView1();
            voExOrg.setWhereClause("ORGID IN " + orgId);
            voExOrg.executeQuery();

            //String orgId = getAllInString(voExOrg, "ORGID");
            instTypeId =
                    "(".concat(getAllInString(voOrgInst, "INSTTYPEID").concat(")"));
            instTypeId = instTypeId.replace(",)", ")");


            ViewObjectImpl voOrg = service.getOrganizationView1();
            voOrg.setWhereClause("id IN " + orgId);
            voOrg.executeQuery();

            Row row = voOrg.first();
            if (row != null) {
                sectorId =
                        "(".concat(getAllInString(voOrg, "Sectorid").concat(")"));
                sectorId = sectorId.replace(",)", ")");
                //sector = row.getAttribute("Sectorid").toString();
                //instType = row.getAttribute("INSTTYPE").toString();
            }


            //            ViewObjectImpl voOrg = service.getOrganizationView1();
            //            voOrg.setWhereClause("id=" + rhSession.getFldOrgId());
            //            voOrg.executeQuery();
            //            Row row = voOrg.first();
            //            if (row != null) {
            //                sector = row.getAttribute("Sectorid").toString();
            //                instType = row.getAttribute("INSTTYPE").toString();
            //            }
            if (partitionTypeId == Constants.PARTITION_TYPE_SECTOR) {
                ViewObjectImpl voSector =
                    service.getPolicybusinesssectorpartition1View1();
                voSector.setNamedWhereClauseParam("bindItemId",
                                                  rhSession.getFldPolicyId());
                voSector.setWhereClause("ID IN " + sectorId);
                voSector.executeQuery();
                if (voSector.getEstimatedRowCount() > 0) {
                    return true;
                }
            } else if (partitionTypeId == Constants.PARTITION_TYPE_INDUSTRY) {
                ViewObjectImpl voInstType =
                    service.getPolicyinstitutiontypepartitionView1();
                voInstType.setNamedWhereClauseParam("bindItemId",
                                                    rhSession.getFldPolicyId());
                voInstType.setWhereClause("id IN " + instTypeId);
                voInstType.executeQuery();
                if (voInstType.getEstimatedRowCount() > 0) {
                    return true;
                }
            } else if (partitionTypeId ==
                       Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
                ViewObjectImpl voOrgPart =
                    service.getPolicyorganizationpartitionView1();
                voOrgPart.setNamedWhereClauseParam("bindItemId",
                                                   rhSession.getFldPolicyId());
                voOrgPart.setWhereClause("id IN " + orgId );
                voOrgPart.executeQuery();
                if (voOrgPart.getEstimatedRowCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        return false;
    }

    private static String getAllInString(ViewObject vo, String attributeType) {
        String returnVal = "";
        vo.executeQuery();
        log.info("executeQuery::");
        while (vo.hasNext()) {
            Row row = vo.next();
            // DO what do you want in Row
            returnVal += "'" + row.getAttribute(attributeType) + "',";
        }
        //returnVal += ")";
        //returnVal = returnVal.replace(",)", ")");
        return returnVal;
    }


    public static String checkTokenSecurity(String userId, String tokenId,
                                            String fiId, String fiType,
                                            String function, Object objAppId) {
        log.info("tokenId:::::::: " + tokenId);
        log.info("userId:::::::: " + userId);
        String userTask = "", userType = "";
        String moduleCode = "";
        log.info("moduleCode:::::::: " + moduleCode);
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(APPMODULEDEF,
                                                                            CONFIG);

        try {
            ViewObject tokenVO = service.getTbladftokenView1();
            tokenVO.setWhereClause("fldUserid='" + userId +
                                   "' AND fldToken='" + tokenId +
                                   "' AND fldFiid='" + fiId +
                                   "' AND fldFitype='" + fiType + "'");
            tokenVO.executeQuery();
            log.info("details query:::: " + tokenVO.getWhereClause());
            if (tokenVO.hasNext()) {
                log.info("valid user with key");
                Row row = tokenVO.first();
                row.remove();
                service.getDBTransaction().commit();
                log.info("valid user with key 222222222");
                //check external/bnm user
                //                ViewObject userVO = service.getViewPrivilegeUsers1();
                //                userVO.setWhereClause("fldUserid='"+userId+"' AND fldIndustryId = '"+fiId+"' AND fldIndustryType='"+fiType+"'");
                //                userVO.executeQuery();
                //                log.info("valid user with key 33333333:: " + userVO.getWhereClause());
                //                if (userVO.hasNext()) {
                //                    log.info("is external user");
                //                    //check external user
                //                    ViewPrivilegeUsersRowImpl extRow = (ViewPrivilegeUsersRowImpl)userVO.first();
                //                    if (extRow.getfldDataEntryOfficer()!=null&&extRow.getfldDataEntryOfficer().equals(HelperUtil.BOOLEAN_TRUE)) {
                //                        log.info("is DO");
                //                        userTask = "DO";
                //                    }
                //
                //                    if (extRow.getfldVerificationOfficer()!=null&&extRow.getfldVerificationOfficer().equals(HelperUtil.BOOLEAN_TRUE)) {
                //                        log.info("is VO");
                //                        userTask = "VO";
                //                    }
                //                    userType = "FIUser";
                //                } else {
                //                    log.info("check bnm user exists?");
                //                    //check bnm user
                //                    ViewObject usComVO = service.getViewFicUsCom1();
                //                    usComVO.setWhereClause("USERID='"+userId+"' AND FITYPE='"+fiType+"' AND FIID='"+fiId+"' AND MODULE_CODE='"+moduleCode+"'");
                //                    usComVO.executeQuery();
                //
                //                    ViewObject bnmVO = service.getEOFicUsersView1();
                //                    bnmVO.setWhereClause("USERID='"+userId+"'");
                //                    bnmVO.executeQuery();
                //
                //                    if (usComVO.hasNext()&&bnmVO.hasNext()) {
                //                        log.info("has BNM user");
                //                        EOFicUsersViewRowImpl bnmRow = (EOFicUsersViewRowImpl)bnmVO.first();
                //                        log.info("user level:::: " + bnmRow.getUSERLEVEL());
                //                        if (bnmRow.getUSERLEVEL()!=null) {
                //                            userType = "BNM-" + bnmRow.getUSERLEVEL();
                //                            userTask = bnmRow.getUSERLEVEL();
                //                        }
                //                        userType = "BNMUser";
                //                    } else {
                //                        userType = "invalid";
                //                    }
                //                    usComVO.remove();
                //                    bnmVO.remove();
                //                }
                //                userVO.remove();

                if (userType.equals("invalid")) {
                    return "invalid";
                } else {
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldUserType",
                                                                                userType);
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldUserTask",
                                                                                userTask);
                    return "valid";
                }
            } else {
                return "invalid";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "invalid";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
    }
}
