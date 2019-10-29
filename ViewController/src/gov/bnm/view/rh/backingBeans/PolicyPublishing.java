package gov.bnm.view.rh.backingBeans;


import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.property.PropertyFileConfigManager;
import gov.bnm.rh.views.AttachedfileSupportDocViewObjRowImpl;
import gov.bnm.rh.views.AuditTrailsViewRowImpl;
import gov.bnm.rh.views.CategoriesViewRowImpl;
import gov.bnm.rh.views.EnquiryfaqForFaqViewRowImpl;
import gov.bnm.rh.views.PolicyViewRowImpl;
import gov.bnm.rh.views.PolicycategoriespartitionViewRowImpl;
import gov.bnm.rh.views.searchfn.CategoryChildLevel2ViewObjRowImpl;
import gov.bnm.rh.views.searchfn.CategoryChildLevel3ViewObjRowImpl;
import gov.bnm.rh.views.searchfn.CategoryParentLevelViewObjRowImpl;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;
import gov.bnm.view.rh.utils.PopUpUtils;


import gov.bnm.view.rh.utils.RandomGuidUtil;

import gov.view.common.validation.ValidatorUtil;

import java.io.OutputStream;

import java.math.BigDecimal;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.UploadedFile;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

import oracle.adf.view.rich.component.rich.data.RichTree;

import org.owasp.html.AttributePolicy;
import org.owasp.html.CssSchema;
import org.owasp.html.HtmlPolicyBuilder;

public class PolicyPublishing {

    static Logger log = Logger.getLogger(PolicyPublishing.class);
    RHSession rhSession =
        (RHSession)JSFUtils.resolveExpression("#{rhSession}");

    private RichPopup p1;
    private RichPopup p2;
    private RichPopup p3;
    private RichPopup p4;
    private RichPanelStretchLayout ps15;
    private RichPanelStretchLayout ps16;
    private RichPanelStretchLayout ps17;
    private RichInputFile if1;
    private UploadedFile polDocUploadedFile;
    private UploadedFile polOthUploadedFile;
    private RichTable t16;
    private RichCommandButton cb17;
    private RichInputFile if2;
    private RichTable t17;
    private RichSelectOneRadio sor1;
    private RichInputText it2;
    private RichInputText it1;
    private RichInputDate id1;
    private RichInputText it5;
    private RichSelectOneChoice soc3;
    private RichPopup p5;
    private String amendmentAction;
    private boolean whatsNewStatus = false;
    private RichTextEditor rte1;
    private RichPopup p6;
    private boolean isDataSaved = false;
    private boolean isFaqSaved = false;
    private boolean partitionTypeAction;
    private RichInputText it3;
    private RichTextEditor rte4;
    private RichPopup p7;
    private UploadedFile suppDocUploadedFile;
    private RichTable t25;
    private RichInputText it4;
    private RichSelectOneChoice soc1;
    private RichInputFile if3;
    private RichTreeTable tt1;
    private RichTree tr1;
    private RichTable t26;
    private RichSelectOneChoice soc4;

    private boolean checkBox;
    private RichSelectOneRadio sor3;
    private RichSelectOneChoice soc5;
    private RichTextEditor rte3;
    private RichTextEditor rte2;
    private RichInputText it6;
    private RichSelectOneChoice soc6;
    private RichSelectOneChoice soc2;
    private RichSelectOneRadio sor2;

    private Properties props;
    private RichCommandImageLink cil4;
    private RichCommandImageLink cil3;
    private RichCommandImageLink cil1;
    private RichPopup p8;
    private RichCommandImageLink cil17;
    private RichCommandImageLink cil16;
    
    private RichPopup p9;
    private RichCommandImageLink cil2;
    private RichCommandImageLink cil7;
    private RichTable t6;
    private RichTable t4;

    public void resetValue() {
        rhSession.setUniqueItems(null);
    }

    public String doSubmit() {
        rhSession.setUniqueItems(null);
        String returnVal = submitAction(Constants.RECORD_STATUS_PENDING);
        return returnVal;
    }

    public String doDraft() {
        rhSession.setUniqueItems(null);
        submitAction(Constants.RECORD_STATUS_DRAFT);
        return null;
    }

    public void alignFont(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        log.info("align font .. " + valueChangeEvent.getNewValue());
        log.info("componet id  :  " + valueChangeEvent.getComponent().getId());

        String textType = valueChangeEvent.getNewValue().toString();

        try {
            props =
                    PropertyFileConfigManager.getInstance().getConfigFile(FileUtil.RH_LOCATION +
                                                                          FileUtil.RH_PROP_FILE);

            //            Pattern pattern =
            //                Pattern.compile(BaseUtil.getStr(props.getProperty("richTextEditor.regex.pattern")),
            //                                Pattern.CASE_INSENSITIVE);
            //            Matcher m = pattern.matcher(textType);
            //
            //            StringBuffer sb = new StringBuffer();
            //            int count = 0;
            //            while (m.find()) {
            //                count++;
            //                log.info("Match number " + count);
            //                log.info("start(): " + m.start());
            //                log.info("end(): " + m.end());
            //                m.appendReplacement(sb,
            //                                    BaseUtil.getStr(props.getProperty("richTextEditor.regex.replace.pattern")));
            //            }
            //            m.appendTail(sb);
            PolicyFactory policy =
                (new HtmlPolicyBuilder().allowElements("table", "tr", "td",
                                                       "th").allowAttributes("style").globally()).toFactory();
            policy =
                    policy.and(Sanitizers.FORMATTING).and(Sanitizers.BLOCKS).and(Sanitizers.IMAGES).and(Sanitizers.LINKS);

            String sb = policy.sanitize(textType);
            log.info("Came out.. end .." + sb);

            this.getRte1().setValue(sb);
            AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
        } catch (Exception e) {
            log.error("Exception @alignFont .. " + e);
        }

    }

    //    public String alignFont(String textInput) {
    //        String textType = textInput;
    //        //        StringBuffer sb = new StringBuffer();
    //        String sb = "";
    //        try {
    //
    //            log.info("Real text  :  " + textInput);
    //            PolicyFactory policy =
    //                (new HtmlPolicyBuilder().allowElements("table", "tr", "td",
    //                                                       "th",
    //                                                       "span").disallowElements("h1",
    //                                                                                "h2",
    //                                                                                "h3",
    //                                                                                "h4").allowAttributes("style").matching(new AttributePolicy() {
    //                    public String apply(String elementName,
    //                                        String attributeName, String value) {
    //                        String returnVal = "";
    //                        if (value.equals("font-weight: bold;")) {
    //                            returnVal = "font-weight: bold;";
    //                        } else if (value.equals("font-style: italic;")) {
    //                            returnVal = "font-style: italic;";
    //                        } else if (value.equals("text-decoration: underline;")) {
    //                            returnVal = "text-decoration: underline;";
    //                        }
    //                        return returnVal.trim();
    //                    }
    //                }).onElements("span")).toFactory();
    //
    //            policy =
    //                    policy.and(Sanitizers.FORMATTING).and(Sanitizers.BLOCKS).and(Sanitizers.IMAGES).and(Sanitizers.LINKS);
    //            sb = policy.sanitize(textInput);
    //            //            props =
    //            //                    PropertyFileConfigManager.getInstance().getConfigFile(FileUtil.RH_LOCATION +
    //            //                                                                          FileUtil.RH_PROP_FILE);
    //            //
    //            //            String[] propPatternSplit =
    //            //                props.getProperty("richTextEditor.regex.pattern").split(",");
    //            //            String[] propReplaceSplit =
    //            //                BaseUtil.getStr(props.getProperty("richTextEditor.regex.replace.pattern")).split(",");
    //            //            if (propPatternSplit.length == 0) {
    //            //                propPatternSplit[0] =
    //            //                        props.getProperty("richTextEditor.regex.pattern");
    //            //            }
    //            //
    //            //            for (int i = 0; i < propPatternSplit.length; i++) {
    //            //                sb = new StringBuffer();
    //            //                Pattern pattern =
    //            //                    Pattern.compile(BaseUtil.getStr(propPatternSplit[i]),
    //            //                                    Pattern.CASE_INSENSITIVE);
    //            //                Matcher m = pattern.matcher(textInput);
    //            //
    //            //                log.info("matcher  :  " + m);
    //            //                //StringBuffer sb = new StringBuffer();
    //            //                int count = 0;
    //            //                while (m.find()) {
    //            //                    count++;
    //            //                    log.info("Match number " + count);
    //            //                    log.info("start(): " + m.start());
    //            //                    log.info("end(): " + m.end());
    //            //
    //            //                    m.appendReplacement(sb, propReplaceSplit[i]);
    //            //
    //            //
    //            //                    log.info("inside while : " + sb);
    //            //                }
    //            //                m.appendTail(sb);
    //            //                log.info("inside while : " + sb);
    //            //                textInput = sb.toString();
    //            //
    //            //            }
    //            //sb = new StringBuffer(textInput);
    //            log.info("Came out.. ag .." + sb);
    //
    //            sb = policy.sanitize(sb);
    //            log.info("Came out.. end .." + sb);
    //            //richText.setValue(sb);
    //            //AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
    //        } catch (Exception e) {
    //            log.error("Exception @alignFont .. " + e);
    //        }
    //        //        return String.valueOf(sb);
    //        return sb;
    //
    //    }

    public void auditTrailSave(String itemId, String actionTaken) {
        
        DCIteratorBinding auditDCIterator = ADFUtils.findIterator("AuditTrailsView1Iterator");
        ViewObject auditVO = auditDCIterator.getViewObject();
        AuditTrailsViewRowImpl auditRowImpl = (AuditTrailsViewRowImpl) auditVO.createRow();
        
        auditRowImpl.setauditId(itemId);
        auditRowImpl.setusrId(rhSession.getFldUserid());
        auditRowImpl.setdocumentId(itemId);
        auditRowImpl.setactionTaken(actionTaken);
        auditRowImpl.setactionDate(DateUtils.getCurrentTimestamp());
        auditRowImpl.setnotes("Test publish policy");
        
        auditVO.insertRow(auditRowImpl);

        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
    }


    public String submitAction(String recordStatus) {
        boolean proceed = true;
        if (!recordStatus.equalsIgnoreCase(Constants.RECORD_STATUS_DRAFT)) {
            proceed = validateFields();
        }
        try {
            if (proceed) {
                String formType =
                    BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("formType"));
                log.info("form type : "+formType);
                String amendmentValue =
                    BaseUtil.getStr(this.getSor1().getValue());
                boolean whatsNew = false;
                if(ValidatorUtil.isNotNull(this.getSor3().getValue())){
                    whatsNew =
                        new Boolean(this.getSor3().getValue().toString());    
                }

                DCBindingContainer dcContainer =
                    ADFUtils.getDCBindingContainer();
                DCIteratorBinding itemlistDCIterator =
                    dcContainer.findIteratorBinding("ItemlistView1Iterator1");
                Row itemlistRowImpl = itemlistDCIterator.getCurrentRow();
                DCIteratorBinding policyIterator =
                    dcContainer.findIteratorBinding("PolicyView3Iterator");
                PolicyViewRowImpl rowPolicy =
                    (PolicyViewRowImpl)policyIterator.getCurrentRow();
                itemlistRowImpl.setAttribute("Name",
                                             BaseUtil.getStr(BaseUtil.getStr(rowPolicy.getGuidelineTitle())));
                rowPolicy.setRefNum(BaseUtil.getStr(itemlistRowImpl.getAttribute("Reference")));

                rowPolicy.setEffectiveDate(CommonRHUtil.alignHtml(rowPolicy.getEffectiveDate()));
                rowPolicy.setSummary(CommonRHUtil.alignHtml(rowPolicy.getSummary()));
                rowPolicy.setHighlights(CommonRHUtil.alignHtml(rowPolicy.getHighlights()));
                rowPolicy.setPriorPublishEmailFlag(false);
                rowPolicy.setPublishedEmailFlag(false);
                rowPolicy.setisAmendmentRecord(false);
                if (whatsNew) {
                    int whatsNewMonths =
                        BaseUtil.getInt(this.getSoc5().getValue());
                    rowPolicy.setWhatsNewMonths(BaseUtil.getBigDecimal(whatsNewMonths));
                }
                rowPolicy.setDisplayInWhatsNew(whatsNew);
                if (formType.equals("PP")) {
                    rowPolicy.setFirstIssuanceDate(rowPolicy.getNewIssuanceDate());
                    rowPolicy.setCreatedDate(DateUtils.getCurrentTimestamp());
                    rowPolicy.setLastUpdated(DateUtils.getCurrentTimestamp());
                    rowPolicy.setcreatedBy(rhSession.getFldUserid());
                    rowPolicy.setisActive(false);
                }
                if (amendmentValue.equals("Y")) {
                    rowPolicy.setisAmendmentRecord(true);
                    boolean status = CommonRHUtil.doInsertAmendment(rowPolicy);
                    if (status) {
                        setIsDataSaved(true);
                        ADFUtils.showInfoMessage(Constants.DATA_AMENDED_SUCCESSFULLY);
                        //EmailUtils.sendMailPolicyPublishRequestForApproval(rowPolicy);
                        return "submit";
                    } else {
                        setIsDataSaved(false);
                        ADFUtils.showInfoMessage("The document Amendment Not Saved ");
                        return null;
                    }
                } else {
                    //rowPolicy.setLastUpdated(DateUtils.getCurrentTimestamp());
                    rowPolicy.setupdatedBy(rhSession.getFldUserid());
                    if (!BaseUtil.getStr(rowPolicy.getRecordStatus()).equals(Constants.RECORD_STATUS_ACTIVE)) {
                        rowPolicy.setRecordStatus(recordStatus);
                        rowPolicy.setisActive(false);
                    } else if (BaseUtil.getStr(rowPolicy.getRecordStatus()).equals(Constants.RECORD_STATUS_ACTIVE) &&
                               formType.equals("PP")) {
                        rowPolicy.setRecordStatus(recordStatus);
                        rowPolicy.setisActive(false);
                    }
                    
                    auditTrailSave(rowPolicy.getitemId(), "Publish");
                    
                    BindingContainer bindings = ADFUtils.getBindingContainer();
                    OperationBinding operationBinding =
                        bindings.getOperationBinding("Commit");
                    Object result = operationBinding.execute();
                    if (!operationBinding.getErrors().isEmpty()) {
                        setIsDataSaved(false);
                        log.error("Save::" + operationBinding.getErrors());
                        ADFUtils.showInfoMessage(" Data Not Saved ");
                    } else {
                        setIsDataSaved(true);
                        if (Constants.RECORD_STATUS_ACTIVE.equals(BaseUtil.getStr(rowPolicy.getRecordStatus()))) {
                            ADFUtils.showInfoMessage(Constants.POLICY_UPDATED);
                            return "submit";
                        } else if (Constants.RECORD_STATUS_DRAFT.equals(BaseUtil.getStr(rowPolicy.getRecordStatus()))) {
                            setIsDataSaved(false);
                            ADFUtils.showInfoMessage(Constants.DATA_DRAFT_SUCCESSFULLY);
                            return null;
                        } else {
                            ADFUtils.showInfoMessage(Constants.POLICY_SUBMIT);
                            EmailUtils.sendMailPolicyPublishRequestForApproval(rowPolicy);
                            return "submit";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("submitAction on error::" + e.getMessage());
        }
        return null;
    }
    
    // Relavant Act Start    
    public String hidePopupP8() {
        PopUpUtils.showOrHidePopup(getP8(), false);
        JSFUtils.setFocus(this.getCil16());
        return null;
    }

    public String showPopupP8() {
        PopUpUtils.showOrHidePopup(getP8(), true);
        JSFUtils.setFocus(this.getCil17());
        return null;
    }
    
    public void setP8(RichPopup p8) {
        this.p8 = p8;
    }

    public RichPopup getP8() {
        return p8;
    }
    
    public void setCil16(RichCommandImageLink cil16) {
        this.cil16 = cil16;
    }

    public RichCommandImageLink getCil16() {
        return cil16;
    } 
    
    public void setCil17(RichCommandImageLink cil17) {
        this.cil17 = cil17;
    }

    public RichCommandImageLink getCil17() {
        return cil17;
    } 
    // Relavant Act End
    
    // Issuring Department Start
    public void setP9(RichPopup p9) {
        this.p9 = p9;
    }

    public RichPopup getP9() {
        return p9;
    }
    
    public String hidePopupP9() {
        PopUpUtils.showOrHidePopup(getP9(), false);
        JSFUtils.setFocus(this.getCil2());
        return null;
    }

    public String showPopupP9() {
        PopUpUtils.showOrHidePopup(getP9(), true);
        JSFUtils.setFocus(this.getCil7());
        return null;
    }
    
    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    } 
    
    public void setCil7(RichCommandImageLink cil7) {
        this.cil7 = cil7;
    }

    public RichCommandImageLink getCil7() {
        return cil7;
    } 
    
    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }
    
    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }
    // Issuring Department End

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public String hidePopupP1() {
        PopUpUtils.showOrHidePopup(getP1(), false);
        JSFUtils.setFocus(this.getCil3());
        return null;
    }

    public String hidePopupP2() {
        PopUpUtils.showOrHidePopup(getP2(), false);
        JSFUtils.setFocus(this.getCil1());
        return null;
    }

    public String showPopupP1() {
        PopUpUtils.showOrHidePopup(getP1(), true);
        return null;
    }

    public String showPopupP2() {
        try {
            List<String> categoryIdList = null;
            List<Integer> categoryListIndex = new ArrayList<Integer>();
            DCIteratorBinding dcIter =
                ADFUtils.getDcIteratorBinding("CategoriesView7Iterator");

            ViewObject vo = dcIter.getViewObject();
            vo.setWhereClause("ParentNodeID = 0");
            vo.executeQuery();

            DCIteratorBinding dcIterPolicy =
                ADFUtils.getDcIteratorBinding("PolicycategoriespartitionView1Iterator");

            categoryIdList = new ArrayList<String>();
            for (int i = 0; i < dcIterPolicy.getAllRowsInRange().length; i++) {
                categoryIdList.add(String.valueOf(dcIterPolicy.getRowAtRangeIndex(i).getAttribute("CategoryID")));
            }

            if (vo != null) {
                log.info("Row Count :  " + vo.getRowCount());
                while (vo.hasNext()) {
                    CategoriesViewRowImpl rowSet =
                        (CategoriesViewRowImpl)vo.next();
                    RowIterator parentLevel =
                        rowSet.getCategoryParentLevelViewObj();
                    if (categoryIdList.contains(String.valueOf(rowSet.getCategoryID()))) {
                        rowSet.setisCheckCategory(true);
                        categoryIdList.remove(rowSet.getCategoryID());
                    } else {
                        rowSet.setisCheckCategory(false);
                    }

                    while (parentLevel.hasNext()) {
                        CategoryParentLevelViewObjRowImpl parentLevelRow =
                            (CategoryParentLevelViewObjRowImpl)parentLevel.next();
                        RowIterator childLevel2 =
                            parentLevelRow.getCategoryChildLevel2ViewObj();


                        if (categoryIdList.contains(String.valueOf(parentLevelRow.getCategoryID()))) {
                            parentLevelRow.setisCheckCategory(true);
                            categoryIdList.remove(parentLevelRow.getCategoryID());
                        } else {
                            parentLevelRow.setisCheckCategory(false);
                        }


                        if (childLevel2 != null) {
                            while (childLevel2.hasNext()) {

                                CategoryChildLevel2ViewObjRowImpl childLevel2Row =
                                    (CategoryChildLevel2ViewObjRowImpl)childLevel2.next();

                                RowIterator childLevel3 =
                                    childLevel2Row.getCategoryChildLevel3ViewObj();


                                if (categoryIdList.contains(String.valueOf(childLevel2Row.getCategoryID()))) {
                                    childLevel2Row.setisCheckCategory(true);
                                    categoryIdList.remove(childLevel2Row.getCategoryID());
                                } else {
                                    childLevel2Row.setisCheckCategory(false);
                                }


                                if (childLevel3 != null) {
                                    while (childLevel3.hasNext()) {

                                        CategoryChildLevel3ViewObjRowImpl childLevel3Row =
                                            (CategoryChildLevel3ViewObjRowImpl)childLevel3.next();


                                        if (categoryIdList.contains(String.valueOf(childLevel3Row.getCategoryID()))) {
                                            childLevel3Row.setisCheckCategory(true);
                                            categoryIdList.remove(childLevel3Row.getCategoryID());
                                        } else {
                                            childLevel3Row.setisCheckCategory(false);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.info("Exception @showPopupP2 .. " + e);
        } finally {
        }
        PopUpUtils.showOrHidePopup(getP2(), true);
        return null;
    }


    public void checkBoxValueChange(ValueChangeEvent valueChangeEvent) {
        //    log.info("old value : " + valueChangeEvent.getOldValue() +
        //             "   New Value  :  " + valueChangeEvent.getNewValue());


        BigDecimal categoryId = null;
        String checkStatus = null;


        RichTree treeTable = this.getTr1();
        //get all selected row keys
        RowKeySet rks = treeTable.getSelectedRowKeys();
        Iterator keys = rks.iterator();
        //if the treeTable is configured to support single selection or
        //multiple selection doesn't matter as the routine below works with
        //all cases
        while (keys.hasNext()) {
            //the treeTable path is defined as a List of keys
            List key = (List)keys.next();
            //set the treeTable current row to the row defined by the key
            treeTable.setRowKey(key);
            //Using ADF, a treeTable row is represented by the
            //JUCtrlHierNodeBinding class, which is an ADF Faces binding
            //object that wraps the row of the ADF model
            JUCtrlHierNodeBinding node =
                (JUCtrlHierNodeBinding)treeTable.getRowData();
            //The row in the model, when using ADF BC, is of type
            //oracle.jbo.Row
            if (ValidatorUtil.isNotNull(node)) {
                Row rw = node.getRow();

                if (rw instanceof CategoriesViewRowImpl) {

                    CategoriesViewRowImpl categoryViewRowImpl =
                        (CategoriesViewRowImpl)rw;

                    if (((Boolean)valueChangeEvent.getOldValue()) != null) {
                        Boolean check =
                            (Boolean)valueChangeEvent.getNewValue();

                        if (check == true) {
                            checkStatus = "true";
                            categoryViewRowImpl.setisCheckCategory(true);
                        } else {
                            checkStatus = "false";
                            categoryViewRowImpl.setisCheckCategory(false);
                        }
                    }
                    categoryId = categoryViewRowImpl.getCategoryID();

                }

                if (rw instanceof CategoryParentLevelViewObjRowImpl) {

                    CategoryParentLevelViewObjRowImpl categoryParentLevelViewObjRowImpl =
                        (CategoryParentLevelViewObjRowImpl)rw;

                    if (((Boolean)valueChangeEvent.getOldValue()) != null) {
                        Boolean check =
                            (Boolean)valueChangeEvent.getNewValue();

                        if (check == true) {
                            checkStatus = "true";
                            categoryParentLevelViewObjRowImpl.setisCheckCategory(true);
                        } else {
                            checkStatus = "false";
                            categoryParentLevelViewObjRowImpl.setisCheckCategory(false);
                        }
                    }
                    categoryId =
                            categoryParentLevelViewObjRowImpl.getCategoryID();

                }


                if (rw instanceof CategoryChildLevel2ViewObjRowImpl) {

                    CategoryChildLevel2ViewObjRowImpl categoryChildLevel2ViewObjRowImpl =
                        (CategoryChildLevel2ViewObjRowImpl)rw;

                    if (((Boolean)valueChangeEvent.getOldValue()) != null) {
                        Boolean check =
                            (Boolean)valueChangeEvent.getNewValue();

                        if (check == true) {
                            checkStatus = "true";
                            categoryChildLevel2ViewObjRowImpl.setisCheckCategory(true);
                        } else {
                            checkStatus = "false";
                            categoryChildLevel2ViewObjRowImpl.setisCheckCategory(false);
                        }
                    }

                    categoryId =
                            categoryChildLevel2ViewObjRowImpl.getCategoryID();

                }

                if (rw instanceof CategoryChildLevel3ViewObjRowImpl) {

                    CategoryChildLevel3ViewObjRowImpl categoryChildLevel3ViewObjRowImpl =
                        (CategoryChildLevel3ViewObjRowImpl)rw;

                    if (((Boolean)valueChangeEvent.getOldValue()) != null) {
                        Boolean check =
                            (Boolean)valueChangeEvent.getNewValue();

                        if (check == true) {
                            checkStatus = "true";
                            categoryChildLevel3ViewObjRowImpl.setisCheckCategory(true);
                        } else {
                            checkStatus = "false";
                            categoryChildLevel3ViewObjRowImpl.setisCheckCategory(false);
                        }
                    }

                    categoryId =
                            categoryChildLevel3ViewObjRowImpl.getCategoryID();

                }
            }

            if (ValidatorUtil.isNotNull(checkStatus)) {
                if ("true".equalsIgnoreCase(checkStatus)) {

                    if (rhSession.getUniqueItems() == null) {
                        rhSession.setUniqueItems(new HashSet<BigDecimal>());
                        rhSession.getUniqueItems().add(categoryId);
                    } else {
                        rhSession.getUniqueItems().add(categoryId);
                    }
                    log.info(" value  :  " + rhSession.getUniqueItems());
                } else if ("false".equalsIgnoreCase(checkStatus)) {
                    if (rhSession.getUniqueItems() != null) {
                        if (rhSession.getUniqueItems().contains(categoryId)) {
                            rhSession.getUniqueItems().remove(categoryId);
                            log.info("romve con : " + categoryId);
                        }

                    }
                }
            }
        }
    }

    public void addCategories() {
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        if (rhSession.getUniqueItems() != null) {
            removePolicyCategoriesPartition();
            Iterator<BigDecimal> iter = rhSession.getUniqueItems().iterator();
            while (iter.hasNext()) {
                this.insertPolicyCategoriesPartition(itemid, iter.next());
            }
        }
        JSFUtils.setFocus(this.getCil1());
    }

    public void insertPolicyCategoriesPartition(String itemid,
                                                BigDecimal categoryId) {
        DCIteratorBinding dcIter =
            ADFUtils.getDcIteratorBinding("PolicycategoriespartitionView1Iterator");
        RowIterator rowIter = dcIter.getRowSetIterator();

        PolicycategoriespartitionViewRowImpl policyCateRowImpl =
            (PolicycategoriespartitionViewRowImpl)rowIter.createRow();

        policyCateRowImpl.setCategoryID(categoryId);
        policyCateRowImpl.setitemId(itemid);

    }

    public void removePolicyCategoriesPartition() {
        DCIteratorBinding dcIter =
            ADFUtils.getDcIteratorBinding("PolicycategoriespartitionView1Iterator");
        RowIterator rowIter = dcIter.getRowSetIterator();

        List rowKey =
            ADFUtils.keyListForIterator("PolicycategoriespartitionView1Iterator");

        for (int i = 0; i < rowKey.size(); i++) {
            oracle.jbo.Key key = (oracle.jbo.Key)rowKey.get(i);
            Object[] keyObj = key.getKeyValues();
            dcIter.getRowSetIterator().getRow(key).remove();
        }
    }

    public void onPrintPriview(ActionEvent actionEvent) {
        String rtlval =
            CommonRHUtil.alignHtml(BaseUtil.getStr(this.getRte1().getValue()));
        log.debug(rtlval);
        this.getRte1().setValue(rtlval);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte1());
        log.debug("done::" + this.getRte1().getValue());

    }

    public void itemSelectionEvent(SelectionEvent selectionEvent) {
        // Add event code here...
        this.displaySelectedItemFromTree();
    }

    public String displaySelectedItemFromTree() {

        String categoryId = null;
        RichTree treeTable = this.getTr1();
        //get all selected row keys
        RowKeySet rks = treeTable.getSelectedRowKeys();
        Iterator keys = rks.iterator();
        //if the treeTable is configured to support single selection or
        //multiple selection doesn't matter as the routine below works with
        //all cases
        while (keys.hasNext()) {
            //the treeTable path is defined as a List of keys
            List key = (List)keys.next();
            //set the treeTable current row to the row defined by the key
            treeTable.setRowKey(key);
            //Using ADF, a treeTable row is represented by the
            //JUCtrlHierNodeBinding class, which is an ADF Faces binding
            //object that wraps the row of the ADF model
            JUCtrlHierNodeBinding node =
                (JUCtrlHierNodeBinding)treeTable.getRowData();
            //The row in the model, when using ADF BC, is of type
            //oracle.jbo.Row
            if (ValidatorUtil.isNotNull(node)) {
                Row rw = node.getRow();
                if (rw instanceof CategoriesViewRowImpl) {

                    CategoriesViewRowImpl categoriesViewRowImpl =
                        (CategoriesViewRowImpl)rw;
                    log.info("Category Parent Level Id  :  " +
                             categoriesViewRowImpl.getCategoryID());

                    categoryId =
                            String.valueOf(categoriesViewRowImpl.getCategoryID());


                } else if (rw instanceof CategoryParentLevelViewObjRowImpl) {

                    CategoryParentLevelViewObjRowImpl categoriesLevelViewRowImpl =
                        (CategoryParentLevelViewObjRowImpl)rw;

                    log.info(" categoriesLevelViewRowImpl   :  " +
                             categoriesLevelViewRowImpl);


                    categoryId =
                            String.valueOf(categoriesLevelViewRowImpl.getCategoryID());

                } else if (rw instanceof CategoryChildLevel2ViewObjRowImpl) {
                } else if (rw instanceof CategoryChildLevel3ViewObjRowImpl) {
                }
            } else {

            }
            //Lets read and print from the row ..
        }
        return categoryId;
    }

    public void policyPartitioning(ValueChangeEvent valueChange) {
        int oldPolicyPartitionValue =
            BaseUtil.getInt(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("partitionValue"));
        log.info("partitionValue :  " + oldPolicyPartitionValue);

        if (oldPolicyPartitionValue == Constants.PARTITION_TYPE_SECTOR) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs15());
        } else if (oldPolicyPartitionValue ==
                   Constants.PARTITION_TYPE_INDUSTRY) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs16());
        } else if (oldPolicyPartitionValue ==
                   Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs17());
        }
        JSFUtils.setExpressionValue("#{bindings.partitionTypeId.inputValue}",
                                    valueChange.getNewValue());
        int value =
            BaseUtil.getInt(JSFUtils.resolveExpression("#{bindings.partitionTypeId.attributeValue}"));
        log.info("New value :  " + value);
        // ADFUtils.findControlBinding("partitionTypeId").setInputValue(value);
        //setPartitionTypeId(value);
        if (value == Constants.PARTITION_TYPE_SECTOR) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs15());
        } else if (value == Constants.PARTITION_TYPE_INDUSTRY) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs16());
        } else if (value == Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPs17());
        }
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("partitionValue",
                                                                    value);
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public String hidePopupP3() {
        isPartitionTypeAction();
        PopUpUtils.showOrHidePopup(getP3(), false);
        JSFUtils.setFocus(this.getSor3());
        return null;
    }

    public String showPopupP3() {
        String partitionValue = BaseUtil.getStr(this.getSoc3().getValue());
        log.info("partitionValue::" + partitionValue);
        if (!partitionValue.equals("")) {
            JSFUtils.setExpressionValue("#{bindings.partitionTypeId.inputValue}",
                                        partitionValue);
            String value =
                BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.partitionTypeId.attributeValue}"));
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("partitionValue",
                                                                        value);
        }
        PopUpUtils.showOrHidePopup(getP3(), true);
        return null;
    }


    public void setPs15(RichPanelStretchLayout ps15) {
        this.ps15 = ps15;
    }

    public RichPanelStretchLayout getPs15() {
        return ps15;
    }

    public void setPs16(RichPanelStretchLayout ps16) {
        this.ps16 = ps16;
    }

    public RichPanelStretchLayout getPs16() {
        return ps16;
    }

    public void setPs17(RichPanelStretchLayout ps17) {
        this.ps17 = ps17;
    }

    public RichPanelStretchLayout getPs17() {
        return ps17;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setPolDocUploadedFile(UploadedFile polDocUploadedFile) {
        String filename = BaseUtil.getStr(polDocUploadedFile.getFilename());
        boolean fileUploadStatus = false;
        if (!filename.equals("") &&
            FileUploadUtils.checkFileExtensionForDoc(filename)) {
            fileUploadStatus =
                    FileUploadUtils.setUploadedFile(polDocUploadedFile,
                                                    "AttachedfileView2_1Iterator",
                                                    "ItemlistView1Iterator1",
                                                    Constants.ATTACHMENT_TYPE_DOCUMENT_DOC);
        } else if (!filename.equals("") &&
                   FileUploadUtils.checkFileExtensionForPdf(filename)) {
            fileUploadStatus =
                    FileUploadUtils.setUploadedFile(polDocUploadedFile,
                                                    "AttachedfileView2_1Iterator",
                                                    "ItemlistView1Iterator1",
                                                    Constants.ATTACHMENT_TYPE_DOCUMENT_PDF);
        } else {
            ADFUtils.showErrorMessage(Constants.INVALID_FILE_FORMAT);
        }
        //// added below line for testing
        fileUploadStatus = true;
        if (fileUploadStatus) {
            ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
        } else {
            ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
        }
    }

    public UploadedFile getPolDocUploadedFile() {
        return polDocUploadedFile;
    }

    public void onDeletePolDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        log.info("bindings:" + bindings);
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();

        Key rowKey = (Key)comp.getAttributes().get("rowKeyDelete");
        log.info("delete rowKey:::::: " + rowKey);

        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileView2_1Iterator");
        FileUploadUtils.removeFromTable(iterBindings, rowKey);

        FileUploadUtils.partialTableRefresh(rowKey, getT16());
    }

    public void onOpenPolDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileView2_1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT16());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb17().getClientId(FacesContext.getCurrentInstance()));
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setT16(RichTable t16) {
        this.t16 = t16;
    }

    public RichTable getT16() {
        return t16;
    }

    public void setCb17(RichCommandButton cb17) {
        this.cb17 = cb17;
    }

    public RichCommandButton getCb17() {
        return cb17;
    }

    public void setIf2(RichInputFile if2) {
        this.if2 = if2;
    }

    public RichInputFile getIf2() {
        return if2;
    }

    public void setPolOthUploadedFile(UploadedFile polOthUploadedFile) {
        String filename = BaseUtil.getStr(polOthUploadedFile.getFilename());
        boolean fileUploadStatus = false;
        if (!filename.equals("") &&
            FileUploadUtils.checkFileExtension(filename)) {
            fileUploadStatus =
                    FileUploadUtils.setUploadedFile(polOthUploadedFile,
                                                    "AttachedfileEx1View1Iterator",
                                                    "ItemlistView1Iterator1",
                                                    Constants.ATTACHMENT_TYPE_OTHER);
        } else {
            ADFUtils.showErrorMessage(Constants.INVALID_FILE_FORMAT);
        }
        if (fileUploadStatus) {
            ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
        } else {
            ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
        }
    }

    public void onDeletePolOthFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        log.info("bindings:" + bindings);
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();

        Key rowKey = (Key)comp.getAttributes().get("rowKeyDelete");
        log.info("delete rowKey:::::: " + rowKey);

        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileEx1View1Iterator");
        FileUploadUtils.removeFromTable(iterBindings, rowKey);

        FileUploadUtils.partialTableRefresh(rowKey, getT17());
    }

    public void onOpenPolOthFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileEx1View1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT17());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb17().getClientId(FacesContext.getCurrentInstance()));
    }

    public UploadedFile getPolOthUploadedFile() {
        return polOthUploadedFile;
    }

    public void setT17(RichTable t17) {
        this.t17 = t17;
    }

    public RichTable getT17() {
        return t17;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public String hidePopupP4() {
        PopUpUtils.showOrHidePopup(getP4(), false);
        JSFUtils.setFocus(this.getSor2());
        return null;
    }

    public String showPopupP4() {
        PopUpUtils.showOrHidePopup(getP4(), true);
        return null;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public boolean validateFields() {
        boolean status = true;
        if (this.getIt1().getValue() == null) {
            ADFUtils.showErrorMessage("Reference No is mandatory.");
            status = false;
        }
        if (this.getIt2().getValue() == null) {
            ADFUtils.showErrorMessage("Title is mandatory.");
            status = false;
        }
        if (this.getRte1().getValue() == null) {
            ADFUtils.showErrorMessage("Effective Date is mandatory.");
            status = false;
        }
        if (this.getId1().getValue() == null) {
            ADFUtils.showErrorMessage("New Issuance Date is mandatory.");
            status = false;
        }
        if (this.getIt5().getValue() == null) {
            ADFUtils.showErrorMessage("Keywords are mandatory.");
            status = false;
        } else {
            String[] keywords =
                BaseUtil.getStr(this.getIt5().getValue()).split(",");
            if (keywords.length < 3) {
                ADFUtils.showErrorMessage("At least 3 keywords are required. Example:- key1,key2,key3");
                status = false;
            }
        }

        DCIteratorBinding policydepartmentpartitionView1Iterator =
            ADFUtils.findIterator("PolicydepartmentpartitionView1Iterator");

        if (policydepartmentpartitionView1Iterator.getEstimatedRowCount() ==
            0) {
            ADFUtils.showErrorMessage("Issuing Deparments is mandatory.");
            status = false;
        }
        DCIteratorBinding policybnmuserspartitionView1Iterator =
            ADFUtils.findIterator("PolicybnmuserspartitionView1Iterator");

        if (policybnmuserspartitionView1Iterator.getEstimatedRowCount() == 0) {
            ADFUtils.showErrorMessage("Authors is mandatory.");
            status = false;
        }
        if (this.getRte3().getValue() == null) {
            ADFUtils.showErrorMessage("Summary is mandatory.");
            status = false;
        }
        //        if (this.getRte2().getValue() == null) {
        //            ADFUtils.showErrorMessage("Highlights is mandatory.");
        //            status = false;
        //        }
        DCIteratorBinding policycategoriespartitionView1Iterator =
            ADFUtils.findIterator("PolicycategoriespartitionView1Iterator");

        if (policycategoriespartitionView1Iterator.getEstimatedRowCount() ==
            0) {
            ADFUtils.showErrorMessage("Category Of Policy is mandatory.");
            status = false;
        }
        DCIteratorBinding polSecIte =
            ADFUtils.findIterator("Policybusinesssectorpartition1View1Iterator");
        DCIteratorBinding polInstIte =
            ADFUtils.findIterator("PolicyinstitutiontypepartitionView1Iterator");
        DCIteratorBinding polOrgIte =
            ADFUtils.findIterator("PolicyorganizationpartitionView1Iterator");
        if (polSecIte.getEstimatedRowCount() == 0 &&
            polInstIte.getEstimatedRowCount() == 0 &&
            polOrgIte.getEstimatedRowCount() == 0) {
            ADFUtils.showErrorMessage("Policy Partitioning is mandatory.");
            status = false;
        }
        if (this.getSor3().getValue() == null) {
            ADFUtils.showErrorMessage("Display in What's New? is mandatory.");
            status = false;
        }
        if (this.getIt6().getValue() == null) {
            ADFUtils.showErrorMessage("Section in Charge is mandatory.");
            status = false;
        }
        if (BaseUtil.getInt(this.getSoc6().getValue()) == 0) {
            ADFUtils.showErrorMessage("Document Category is mandatory.");
            status = false;
        }
        if (BaseUtil.getInt(this.getSoc2().getValue()) == 0) {
            ADFUtils.showErrorMessage("Classification is mandatory.");
            status = false;
        }
        if (this.getSor2().getValue() == null) {
            ADFUtils.showErrorMessage("Publish To BNM is mandatory.");
            status = false;
        }
        if (BaseUtil.getInt(this.getSoc4().getValue()) == 0) {
            ADFUtils.showErrorMessage("Approver is mandatory.");
            status = false;
        }

        DCIteratorBinding polDocIte =
            ADFUtils.findIterator("AttachedfileView2_1Iterator");
        //// shandeep kumar edit ===> 0 default...
        if (polDocIte.getEstimatedRowCount() == 1) {
            ADFUtils.showErrorMessage("Policy Document is mandatory.");
            status = false;
        } else {
            boolean isPdf = false;
            Row[] polRows = polDocIte.getAllRowsInRange();
            for (int i = 0; i < polRows.length; i++) {
                Row row = polRows[i];
                String filenameOrig =
                    BaseUtil.getStr(row.getAttribute("filenameOrig"));
                if (filenameOrig != null &&
                    FileUploadUtils.checkFileExtensionForPdf(filenameOrig)) {
                    isPdf = true;
                }
            }
            if (!isPdf) {
                // ADFUtils.showErrorMessage("Policy Document is mandatory.");
                status = true;
            }
        }
        return status;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public String hidePopupP5() {
        PopUpUtils.showOrHidePopup(getP5(), false);
        return null;
    }

    public String showPopupP5() {
        PopUpUtils.showOrHidePopup(getP5(), true);
        return null;
    }

    public void amendmentAction(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        setAmendmentAction(BaseUtil.getStr(valueChangeEvent.getNewValue()));
        log.info("valueChangeEvent.getNewValue()::" +
                 valueChangeEvent.getNewValue());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT16());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT17());
    }

    public void whatsNewAction(ValueChangeEvent valueChangeEvent) {
        //    JSFUtils.setExpressionValue("#{bindings.DisplayInWhatsNew.inputValue}",
        //                                valueChangeEvent.getNewValue());
        ////    String value =
        //      BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.DisplayInWhatsNew.attributeValue}"));
        //    this.setWhatsNewStatus(new Boolean(valueChangeEvent.getNewValue().toString()));
        log.info("valueChangeEvent.getNewValue()::" +
                 valueChangeEvent.getNewValue());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSoc5());
    }

    public void setAmendmentAction(String amendmentAction) {
        this.amendmentAction = amendmentAction;
    }

    public String getAmendmentAction() {
        amendmentAction = BaseUtil.getStr(this.getSor1().getValue());
        String formType =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("formType"));
        if (formType.equals("PP")) {
            amendmentAction = "Y";
        }
        return amendmentAction;
    }

    public void setRte1(RichTextEditor rte1) {
        this.rte1 = rte1;
    }

    public RichTextEditor getRte1() {
        return rte1;
    }

    public void setP6(RichPopup p6) {
        this.p6 = p6;
    }

    public RichPopup getP6() {
        return p6;
    }

    public String hidePopupP6() {
        PopUpUtils.showOrHidePopup(getP6(), false);
        JSFUtils.setFocus(this.getSoc4());
        return null;
    }

    public String showPopupP6() {
        PopUpUtils.showOrHidePopup(getP6(), true);
        return null;
    }
    //  public void doReset(DialogEvent dialogEvent){
    //    if(dialogEvent.getOutcome() == dialogEvent.getOutcome().ok){
    //      BindingContainer bindings = ADFUtils.getBindingContainer();
    //      OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
    //      Object result = operationBinding.execute();
    //    }
    //  }

    public String doReset() {
        hidePopupP6();
        rhSession.setUniqueItems(null);
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        return "newPage";
    }

    public void setIsDataSaved(boolean isDataSaved) {
        this.isDataSaved = isDataSaved;
    }

    public boolean isIsDataSaved() {
        return isDataSaved;
    }

    public void setPartitionTypeAction(boolean partitionTypeAction) {
        this.partitionTypeAction = partitionTypeAction;
    }

    public boolean isPartitionTypeAction() {
        partitionTypeAction = false;
        JSFUtils.setExpressionValue("#{bindings.partitionTypeId.inputValue}",
                                    BaseUtil.getStr(this.getSoc3().getValue()));
        int partitionTypeId =
            BaseUtil.getInt(JSFUtils.resolveExpression("#{bindings.partitionTypeId.attributeValue}"));

        if (partitionTypeId == Constants.PARTITION_TYPE_SECTOR) {
            DCIteratorBinding policybusinesssectorpartition1View1Iterator =
                ADFUtils.findIterator("Policybusinesssectorpartition1View1Iterator");
            if (policybusinesssectorpartition1View1Iterator.getEstimatedRowCount() >
                0) {
                partitionTypeAction = true;
            }
        } else if (partitionTypeId == Constants.PARTITION_TYPE_INDUSTRY) {
            DCIteratorBinding policyinstitutiontypepartitionView1Iterator =
                ADFUtils.findIterator("PolicyinstitutiontypepartitionView1Iterator");
            if (policyinstitutiontypepartitionView1Iterator.getEstimatedRowCount() >
                0) {
                partitionTypeAction = true;
            }
        } else if (partitionTypeId ==
                   Constants.PARTITION_TYPE_FINANCIAL_INSTITUTION) {
            DCIteratorBinding policyorganizationpartitionView1Iterator =
                ADFUtils.findIterator("PolicyorganizationpartitionView1Iterator");
            if (policyorganizationpartitionView1Iterator.getEstimatedRowCount() >
                0) {
                partitionTypeAction = true;
            }
        }
        return partitionTypeAction;
    }

    public String submitFaq() {
        doFaqInsert(Constants.RECORD_STATUS_ACTIVE);
        return null;
    }

    public String draftFaq() {
        doFaqInsert(Constants.RECORD_STATUS_DRAFT);
        return null;
    }

    private void doFaqInsert(String recordStatus) {

        DCIteratorBinding policyIterator =
            ADFUtils.findIterator("PolicyView3Iterator");
        PolicyViewRowImpl rowPolicy =
            (PolicyViewRowImpl)policyIterator.getCurrentRow();
        String itemId = BaseUtil.getStr(rowPolicy.getitemId());
        log.info("getIt1::" + this.getIt3().getValue());
        log.info("getRte1::" + this.getRte4().getValue());
        DCIteratorBinding enquiryfaqForFaqView1Iterator =
            ADFUtils.findIterator("EnquiryfaqForFaqView1Iterator");
        ViewObject policydepartmentVO =
            enquiryfaqForFaqView1Iterator.getViewObject();
        EnquiryfaqForFaqViewRowImpl faqRowImpl =
            (EnquiryfaqForFaqViewRowImpl)policydepartmentVO.createRow();
        faqRowImpl.setEnquiryFAQId(RandomGuidUtil.fnGuidWithDate());
        faqRowImpl.setTitle(BaseUtil.getStr(this.getIt3().getValue()));
        faqRowImpl.setitemId(itemId);
        faqRowImpl.setAbstract11(CommonRHUtil.alignHtml(BaseUtil.getStr(this.getRte4().getValue())));
        faqRowImpl.setEnquiryOrFaq(Constants.RECORD_TYPE_FAQ);
        faqRowImpl.setfaqStatus(recordStatus);

        faqRowImpl.setCurrentItemtype(Constants.RECORD_TYPE_FAQ);
        faqRowImpl.setOriginalItemtype(Constants.RECORD_TYPE_FAQ);
        policydepartmentVO.insertRow(faqRowImpl);
        this.getIt3().setValue("");
        this.getRte4().setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt3());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte4());
        setIsFaqSaved(true);
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setRte4(RichTextEditor rte4) {
        this.rte4 = rte4;
    }

    public RichTextEditor getRte4() {
        return rte4;
    }

    public void setIsFaqSaved(boolean isFaqSaved) {
        this.isFaqSaved = isFaqSaved;
    }

    public boolean isIsFaqSaved() {
        return isFaqSaved;
    }

    public void setP7(RichPopup p7) {
        this.p7 = p7;
    }

    public RichPopup getP7() {
        return p7;
    }

    public void suppDocAction(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        UploadedFile suppDocUploadedFile =
            (UploadedFile)valueChangeEvent.getNewValue();
        this.setSuppDocUploadedFile(suppDocUploadedFile);
    }

    public void setSuppDocUploadedFile(UploadedFile suppDocUploadedFile) {
        this.suppDocUploadedFile = suppDocUploadedFile;
    }

    public UploadedFile getSuppDocUploadedFile() {
        return suppDocUploadedFile;
    }

    public void onOpenSuppDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileSupportDocViewObj1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT25());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        log.info("filenameStore::" + currentRow.getAttribute("filenameStore"));
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb17().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setT25(RichTable t25) {
        this.t25 = t25;
    }

    public RichTable getT25() {
        return t25;
    }

    public String hidePopupP7() {
        PopUpUtils.showOrHidePopup(getP7(), false);
        JSFUtils.setFocus(this.getSoc4());
        return null;
    }

    public String showPopupP7() {
        PopUpUtils.showOrHidePopup(getP7(), true);
        return null;
    }

    public String doDeleteSuppDoc() {
        DCIteratorBinding policyView1Iterator =
            ADFUtils.findIterator("AttachedfileSupportDocViewObj1Iterator");
        Row row = policyView1Iterator.getViewObject().getCurrentRow();
        FileUploadUtils.removePhysicalFile(BaseUtil.getStr(row.getAttribute("filenameStore")));
        row.remove();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT25());
        return null;
    }

    public String submitSuppdoc() {

        log.info("getIt4::" + this.getIt4().getValue());
        log.info("getSoc1::" + this.getSoc1().getValue());
        suppDocUploadedFile = this.getSuppDocUploadedFile();
        String fileName = BaseUtil.getStr(suppDocUploadedFile.getFilename());
        if (!fileName.equals("")) {
            DCIteratorBinding policyIterator =
                ADFUtils.findIterator("PolicyView3Iterator");
            PolicyViewRowImpl rowPolicy =
                (PolicyViewRowImpl)policyIterator.getCurrentRow();
            String itemId = BaseUtil.getStr(rowPolicy.getitemId());
            String fileId = RandomGuidUtil.fnGuidWithTimestamp();
            boolean fileUploadStatus =
                FileUploadUtils.setUploadedFile(suppDocUploadedFile, fileId);
            if (fileUploadStatus) {
                JSFUtils.setExpressionValue("#{bindings.ClassificationView1.inputValue}",
                                            this.getSoc1().getValue());
                String classificationValue =
                    BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.ClassificationView1.attributeValue}"));
                log.info("classificationValue :  " + classificationValue);
                Properties props = rhSession.getProps();

                DCIteratorBinding attachedfileSupportDocViewObj1Iterator =
                    ADFUtils.findIterator("AttachedfileSupportDocViewObj1Iterator");
                ViewObject attachVO =
                    attachedfileSupportDocViewObj1Iterator.getViewObject();
                AttachedfileSupportDocViewObjRowImpl attRowImpl =
                    (AttachedfileSupportDocViewObjRowImpl)attachVO.createRow();
                attRowImpl.setfileId(fileId);
                attRowImpl.setfilenameOrig(fileName);
                attRowImpl.setfilenameStore(fileId + "_" + fileName);
                attRowImpl.setdocumentName(BaseUtil.getStr(this.getIt4().getValue()));
                attRowImpl.setisSupportDocument(true);
                if (classificationValue.equalsIgnoreCase(Constants.SUPPORT_DOC_TYPE_SULIT)) {
                    attRowImpl.setisRequiredAccess(true);
                } else {
                    attRowImpl.setisRequiredAccess(false);
                }
                attRowImpl.settype(classificationValue);
                attRowImpl.setfilePath(props.getProperty("ftp.server"));
                attRowImpl.setitemId(itemId);
                attRowImpl.setAttribute("orderDate",
                                        DateUtils.getCurrentTimestamp());
                attachVO.insertRow(attRowImpl);
                this.getIt4().setValue("");
                this.getSoc1().setValue("");
                this.getIf3().setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt4());
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSoc1());

                ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
            } else {
                ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
            }
        }
        return null;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setIf3(RichInputFile if3) {
        this.if3 = if3;
    }

    public RichInputFile getIf3() {
        return if3;
    }

    public void setTt1(RichTreeTable tt1) {
        this.tt1 = tt1;
    }

    public RichTreeTable getTt1() {
        return tt1;
    }

    public void setT26(RichTable t26) {
        this.t26 = t26;
    }

    public RichTable getT26() {
        return t26;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSor3(RichSelectOneRadio sor3) {
        this.sor3 = sor3;
    }

    public RichSelectOneRadio getSor3() {
        return sor3;
    }

    public void setWhatsNewStatus(boolean whatsNewStatus) {
        this.whatsNewStatus = whatsNewStatus;
    }

    public boolean isWhatsNewStatus() {
        return whatsNewStatus;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setRte3(RichTextEditor rte3) {
        this.rte3 = rte3;
    }

    public RichTextEditor getRte3() {
        return rte3;
    }

    public void setRte2(RichTextEditor rte2) {
        this.rte2 = rte2;
    }

    public RichTextEditor getRte2() {
        return rte2;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setSoc6(RichSelectOneChoice soc6) {
        this.soc6 = soc6;
    }

    public RichSelectOneChoice getSoc6() {
        return soc6;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSor2(RichSelectOneRadio sor2) {
        this.sor2 = sor2;
    }

    public RichSelectOneRadio getSor2() {
        return sor2;
    }


    public void setTr1(RichTree tr1) {
        this.tr1 = tr1;
    }

    public RichTree getTr1() {
        return tr1;
    }

    public void setCil4(RichCommandImageLink cil4) {
        this.cil4 = cil4;
    }

    public RichCommandImageLink getCil4() {
        return cil4;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }
}
