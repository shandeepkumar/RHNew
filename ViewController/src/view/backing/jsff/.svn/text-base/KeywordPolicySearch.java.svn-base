package view.backing.jsff;

import bnm.universal.search.Usearch;

import com.verity.search.Documents;

import gov.bnm.email.bean.EmailDataBean;
import gov.bnm.rh.RegBookAppModuleImpl;
import gov.bnm.view.rh.common.PageNavigation;
import gov.bnm.view.rh.constant.Constants;

import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;
import gov.bnm.view.rh.utils.RandomGuidUtil;

import gov.view.common.utils.DateUtil;
import gov.view.common.validation.ValidatorBaseUtil;
import gov.view.common.validation.ValidatorUtil;

import java.io.OutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Properties;

import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectManyChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectManyListbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.component.UIXIterator;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import view.backing.search.KeywordPolicySearchObj;

public class KeywordPolicySearch extends PageNavigation {

    static Logger log = Logger.getLogger(KeywordPolicySearch.class);

    RHSession rhSession =
        (RHSession)JSFUtils.resolveExpression("#{rhSession}");

    private String searchKeyword;
    private List<SelectItem> advanceSearchSelectItem;
    private List<KeywordPolicySearchObj> keywordPolicySearchObjList;
    private List<String> advanceSearchSelectedValues;
    private String searchResult;
    private int listSize;

    private RichPanelStretchLayout psl1;
    private RichInputText it1;
    private RichPanelGroupLayout pgl1;
    private RichPanelFormLayout pfl1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichCommandButton cb1;
    private RichPanelFormLayout pfl2;
    private UIXIterator i1;
    private RichOutputText ot2;
    private RichPanelLabelAndMessage plam1;
    private RichPanelLabelAndMessage plam2;
    private RichPanelLabelAndMessage plam3;
    private RichPanelLabelAndMessage plam4;
    private RichSelectManyChoice smc1;
    private RichOutputLabel ol1;
    private RichOutputText ot3;
    private RichPanelGroupLayout pgl5;
    private RichCommandButton cb4;
    private RichCommandLink cl2;

    public String loadAdvanceSearchSelectItem() {

        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);

        try {
            String fldSearchKey = BaseUtil.getStr(rhSession.getFldSearchKey());
            log.info("rhSession getFldSearchKey::" + fldSearchKey);
            List<String> advanceSearchSelectedValues =
                service.getAllSectorsInList();

            List<SelectItem> advanceSearchSelectItem =
                new ArrayList<SelectItem>();

            for (int i = 0; i < advanceSearchSelectedValues.size(); i++) {
                advanceSearchSelectItem.add(new SelectItem(advanceSearchSelectedValues.get(i),
                                                           advanceSearchSelectedValues.get(i)));
            }

            this.setAdvanceSearchSelectedValues(advanceSearchSelectedValues);
            this.setAdvanceSearchSelectItem(advanceSearchSelectItem);
            if (fldSearchKey != null && !fldSearchKey.equals("") &&
                !fldSearchKey.equals("null")) {
                log.info("in side if fldSearchKey::" + fldSearchKey.length());
                //wildcard added for search word as per request on 24-02-2016
                if (!"*".equals(fldSearchKey)) {
                    fldSearchKey = "*" + fldSearchKey + "*";
                }
                //this.getIt1().setValue(fldSearchKey);
                String advanceSearchKeywords = this.getAdvanceSearchValue();
                this.searchKeyword(fldSearchKey, advanceSearchKeywords,
                                   this.getDocStartCount(),
                                   this.getDocCount());
                log.info("done if fldSearchKey::" + fldSearchKey);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }

        //        SelectItem selItem1 = new SelectItem("FSA", "FSA");
        //        SelectItem selItem2 = new SelectItem("IFSA", "IFSA");
        //        SelectItem selItem3 = new SelectItem("BAFIA", "BAFIA");
        //        SelectItem selItem4 = new SelectItem("IBA", "IBA");
        //        SelectItem selItem5 = new SelectItem("IA", "IA");
        //        SelectItem selItem6 = new SelectItem("TA", "TA");
        //        SelectItem selItem7 = new SelectItem("DFIA", "DFIA");
        //        SelectItem selItem8 = new SelectItem("MSBA", "MSBA");
        //        SelectItem selItem9 = new SelectItem("PSA", "PSA");
        //
        //        List<SelectItem> advanceSearchSelectItem = new ArrayList<SelectItem>();
        //        advanceSearchSelectItem.add(selItem1);
        //        advanceSearchSelectItem.add(selItem2);
        //        advanceSearchSelectItem.add(selItem3);
        //        advanceSearchSelectItem.add(selItem4);
        //        advanceSearchSelectItem.add(selItem5);
        //        advanceSearchSelectItem.add(selItem6);
        //        advanceSearchSelectItem.add(selItem7);
        //        advanceSearchSelectItem.add(selItem8);
        //        advanceSearchSelectItem.add(selItem9);

        //        List<String> advanceSearchSelectedValues = new ArrayList<String>();
        //        advanceSearchSelectedValues.add(selItem1.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem2.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem3.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem4.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem5.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem6.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem7.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem8.getValue().toString());
        //        advanceSearchSelectedValues.add(selItem9.getValue().toString());


        return "success";
    }

    public void chooseCount(ValueChangeEvent valueChangeEvent) {
        log.info("count value " + valueChangeEvent.getNewValue().toString());
        this.setDocCount(Integer.parseInt(valueChangeEvent.getNewValue().toString()));
        this.buttonSearch();

    }

    public void buttonSearch() {

        String advanceSearchKeywords = this.getAdvanceSearchValue();

        log.info("Advance search result : " + advanceSearchKeywords);

        if (ValidatorUtil.isNotNull(this.getIt1())) {
            log.info(" If condition It1 :  DocStart Count  :  " +
                     this.getDocStartCount() + "  Doc Count :  " +
                     this.getDocCount() + " Text field : " +
                     this.getIt1().getValue());

            if (ValidatorUtil.isNotNull(this.getIt1().getValue())) {
                log.info("before calling to search keyword .. method  ");
                //wildcard added for search word as per request on 24-02-2016
                String searchVal = BaseUtil.getStr(this.getIt1().getValue());
                if (!"*".equals(searchVal)) {
                    searchVal = "*" + searchVal + "*";
                }
                this.searchKeyword(searchVal, advanceSearchKeywords,
                                   this.getDocStartCount(),
                                   this.getDocCount());
            } else {
                ADFUtils.showErrorMessage("Search Key is mandatory.");

                //this.searchKeyword("*", advanceSearchKeywords,
                //                                   this.getDocStartCount(),
                //                                   this.getDocCount());
            }
        }
        this.setTotalCount(1);

        log.info("DocStart Count  :  " + this.getDocStartCount() +
                 "  Doc Count :  " + this.getDocCount() + "  Total Count  :" +
                 this.getTotalCount());

    }

    public boolean validateFields() {
        boolean status = true;
        if (this.getIt1().getValue() == null) {
            ADFUtils.showErrorMessage("Search Key is mandatory.");
            status = false;
        }
        return false;
    }

    public String close() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExtendedRenderKitService service =
            Service.getRenderKitService(facesContext,
                                        ExtendedRenderKitService.class);
        service.addScript(facesContext,
                          "parent.window.open('', '_self', ''); ");
        return "success";
    }

    public void clickPreviousNext(ActionEvent actionEvent) {
        if (!this.getButtonId().equalsIgnoreCase(actionEvent.getComponent().getId())) {
            if ("cb3".equalsIgnoreCase(actionEvent.getComponent().getId())) {
                //this.setTotalCount(this.getTotalCount() + this.getDocCount());
                this.setButtonId(actionEvent.getComponent().getId());
            } else {
                //this.setTotalCount(this.getTotalCount() - this.getDocCount());
                this.setButtonId(actionEvent.getComponent().getId());
            }
        }

        if (ValidatorUtil.isNotNull(this.getIt1())) {
            String advanceSearchKeywords = this.getAdvanceSearchValue();
            //wildcard added for search word as per request on 24-02-2016
            String searchVal = BaseUtil.getStr(this.getIt1().getValue());
            if (!"*".equals(searchVal)) {
                searchVal = "*" + searchVal + "*";
            }
            if ("cb2".equalsIgnoreCase(actionEvent.getComponent().getId())) {
                if (ValidatorUtil.isNotNull(this.getIt1().getValue())) {
                    this.searchKeyword(searchVal, advanceSearchKeywords,
                                       (this.getTotalCount() -
                                        this.getDocCount()),
                                       this.getDocCount());
                } else {
                    this.searchKeyword("*", advanceSearchKeywords,
                                       (this.getTotalCount() -
                                        this.getDocCount()),
                                       this.getDocCount());
                }
                this.setTotalCount(this.getTotalCount() - this.getDocCount());
            } else {
                if (ValidatorUtil.isNotNull(this.getIt1().getValue())) {
                    this.searchKeyword(searchVal, advanceSearchKeywords,
                                       (this.getTotalCount() +
                                        this.getDocCount()),
                                       this.getDocCount());
                } else {
                    this.searchKeyword("*", advanceSearchKeywords,
                                       (this.getTotalCount() +
                                        this.getDocCount()),
                                       this.getDocCount());
                }
                this.setTotalCount(this.getTotalCount() + this.getDocCount());
            }
        }

        log.info("DocStart Count  :  " + this.getDocStartCount() +
                 "  Doc Count :  " + this.getDocCount() + "  Total Count  :" +
                 this.getTotalCount());

    }

    public void clickKeywordLink() {
        this.getIt1().setValue(this.getSearchKeyword());
        this.buttonSearch();
    }

    public String getAdvanceSearchValue() {
        String advanceSearchKeywords = "";
        if (ValidatorUtil.isNotNull(advanceSearchSelectedValues) &&
            (ValidatorUtil.isNotNull(advanceSearchSelectItem))) {
            log.info("advance search value not null ...  came inside looop");
            if (advanceSearchSelectedValues.size() !=
                advanceSearchSelectItem.size()) {
                for (int i = 0; i < advanceSearchSelectedValues.size(); i++) {
                    if (i == 0) {
                        advanceSearchKeywords =
                                advanceSearchSelectedValues.get(i);
                    } else if (i == (advanceSearchSelectedValues.size() - 1)) {
                        advanceSearchKeywords =
                                advanceSearchKeywords.concat(",").concat(advanceSearchSelectedValues.get(i));
                    } else {
                        advanceSearchKeywords =
                                advanceSearchKeywords.concat(",").concat(advanceSearchSelectedValues.get(i));
                    }
                }
                advanceSearchKeywords =
                        "(".concat(advanceSearchKeywords).concat(")").concat("<IN> K2_APPLICABILITY");
                log.info("Advance search keywords : " + advanceSearchKeywords);
            }
        }

        return advanceSearchKeywords;
    }

    public void searchKeyword(String query, String advanceQuery, int docStart,
                              int docCount) {
        /**
         * query - Search keyword value from textfield .
         * advancequery - Select choose in list box.
         * connection1 - connection hot code or get from property 'RHNew||'
         * username - optional
         * sortspec - sort spec is nothing but sorting column name as below
         * 'K2_TITLE|K2_APPLICABILITY|K2_HIGHLIGHTS|K2_NEWISSUANCEDATE|VdkPBSummary|VdkVgwKey|K2_SUMMARY|K2_ITEMID|K2_KEYWORDS|repoName'
         * docsstart - ex.. can give start collect value. like start from 6 ... 10
         * docscount - document count of record to fetch.
         *
         *
         * getTotalDocsFound() - no. of document's it search.
         * getCount - Total no. of result search.
         *
         * */
        RegBookAppModuleImpl service =
            (RegBookAppModuleImpl)Configuration.createRootApplicationModule(CommonRHUtil.APPMODULEDEF,
                                                                            CommonRHUtil.CONFIG);
        try {
            log.info("Inside the search keyword .. ");
            StringBuilder sbColl = new StringBuilder();
            Properties props = rhSession.getProps();
            String collection =
                BaseUtil.getStr(props.getProperty("search.engine.collection"));
            log.info("SEARCH_ENGINE_COLLECTION from Properties:-" +
                     collection);
            // sbColl.append(Constants.SEARCH_ENGINE_COLLECTION);
            sbColl.append(collection);
            String usrName = rhSession.getFldUserid();
            String sortSpec = "";


            if (ValidatorUtil.isNull(keywordPolicySearchObjList)) {
                keywordPolicySearchObjList =
                        new ArrayList<KeywordPolicySearchObj>();
            } else {
                keywordPolicySearchObjList.clear();
            }

            //this.loadTestValue(docStart, docCount);

            /*
         * need to open comment at time of deployment in uat or prod.
         *
         **/
            //loadTestValue(0, 10);
            log.info("Before calling to k2Server Usearch ..");
            Documents docu = null;
            try {
                Usearch us = new Usearch();

                docu =
us.UniSearch(query, advanceQuery, sbColl, usrName, sortSpec, docStart,
             docCount);

                log.info("Count total :  " + us.getTotalDocsFound() +
                         " tot :  " + us.getTotalDocsSearched());

                this.setFetchTotalCount(us.getTotalDocsFound());
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
                log.error("Exception happend on USearch .. ");
            }


            if (keywordPolicySearchObjList.size() == 0) {
                log.info("length of docu search : " + docu.size());
                for (int pos = 1; pos <= docu.size(); pos++) {
                    KeywordPolicySearchObj keywordSearchObj =
                        new KeywordPolicySearchObj();
                    log.info("K2_GUIDELINETITLE : " +
                             docu.At(pos).field("K2_GUIDELINETITLE"));
                    log.info("K2_TITLE : " + docu.At(pos).field("K2_TITLE"));
                    keywordSearchObj.setVdkvgwkey(docu.At(pos).field("VdkVgwKey"));
                    keywordSearchObj.setStrTitle(docu.At(pos).field("K2_GUIDELINETITLE"));
                    keywordSearchObj.setDynamicSummary(docu.At(pos).field("VdkPBSummary"));
                    keywordSearchObj.setK2_Summary(docu.At(pos).field("K2_SUMMARY"));
                    //update by rama to replace # with ,
                    String K2_APPLICABILITY =
                        BaseUtil.getStr(docu.At(pos).field("K2_APPLICABILITY")).replaceAll("#",
                                                                                           ",");
                    keywordSearchObj.setK2_Applicability(K2_APPLICABILITY);
                    // update done
                    String policyId =
                        BaseUtil.getStr(docu.At(pos).field("K2_ITEMID"));
                    keywordSearchObj.setK2_itemId(policyId);
                    keywordSearchObj.setK2_NewIssuanceDate(docu.At(pos).field("K2_NEWISSUANCEDATE"));
                    keywordSearchObj.setK2_keywords(docu.At(pos).field("K2_KEYWORDS"));

                    keywordSearchObj.setK2_IssuanceDateFormatted(DateUtil.toUtilDate(keywordSearchObj.getK2_NewIssuanceDate(),
                                                                                     "yyyy/MM/dd hh:mm:ss"));

                    log.info("Issuance date formate : " +
                             keywordSearchObj.getK2_IssuanceDateFormatted());
                    if (ValidatorUtil.isNotNull(policyId)) {
                        log.info("policyId " + policyId);
                        String fileId =
                            service.callFuncPolicyAttachment(policyId);
                        log.info("fileId " + fileId);
                        keywordSearchObj.setFileId(fileId);

                    }

                    if (ValidatorUtil.isNotNull(keywordSearchObj.getK2_keywords())) {
                        keywordSearchObj.setK2_KeywordsArray(keywordSearchObj.getK2_keywords().split(","));
                        keywordSearchObj.setArrayLength(keywordSearchObj.getK2_KeywordsArray().length);
                    }
                    keywordPolicySearchObjList.add(keywordSearchObj);
                }

                log.info("size of keywordPolicySearchObjList :  " +
                         keywordPolicySearchObjList.size());

                if (keywordPolicySearchObjList.size() == 0) {
                    this.setSearchResult("No Record Found");
                } else {
                    this.setSearchResult("Record Found");
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            log.error("Exception @searchKeyword .. " + e);
        } finally {
            Configuration.releaseRootApplicationModule(service, true);
        }
        //*/
    }

    public void onOpenPolFileSelected(ActionEvent actionEvent) {
        boolean isDownload = true;
        if (Constants.IS_INTERNAL_OR_EXTERNAL_EX.equalsIgnoreCase(rhSession.getIsInternalExternal())) {
            /**
             *  key poliy search validate authorised policy.
             *  Add new CR Dec 6th 2017 by shankar .. 
             *  change CommonRHUtil.isAuthorisedToViewPolicy() into CommonRHUtil.isAuthorisedToViewPolicyMultiOrgInst()
             */
            if (!CommonRHUtil.isAuthorisedToViewPolicyMultiOrgInst()) {
                isDownload = false;
                ADFUtils.showInfoMessage("You are not Authorised To View this Policy ");
            }
        }
        if (isDownload) {
            BindingContainer bindings = ADFUtils.getBindingContainer();
            RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
            String rowKey =
                BaseUtil.getStr(comp.getAttributes().get("rowKey"));

            log.info("rowKey::" + rowKey);
            DCIteratorBinding iterBindings =
                (DCIteratorBinding)bindings.get("AttachmentDownloadViewObj1Iterator");
            ViewObject vo = iterBindings.getViewObject();
            vo.setNamedWhereClauseParam("bindFileId", rowKey);
            vo.executeQuery();
            log.info("getEstimatedRowCount::" + vo.getEstimatedRowCount());
            Row currentRow = vo.first();
            //file name and Download buttion getter
            FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                            BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                            getCb4().getClientId(FacesContext.getCurrentInstance()));
        }
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTestValue(int valueStart, int countValue) {
        int count = valueStart + countValue;
        if (keywordPolicySearchObjList.size() == 0) {
            for (int pos = valueStart; pos < count; pos++) {

                KeywordPolicySearchObj keywordSearchObj =
                    new KeywordPolicySearchObj();

                keywordSearchObj.setVdkvgwkey("VdkVgwKey" + pos);
                keywordSearchObj.setStrTitle("K2_TITLE" + pos);
                keywordSearchObj.setDynamicSummary("VdkPBSummary" + pos);
                keywordSearchObj.setK2_Summary("K2_SUMMARY" + pos);
                keywordSearchObj.setK2_Applicability("K2_APPLICABILITY" + pos);
                keywordSearchObj.setK2_itemId("K2_ITEMID" + pos);
                keywordSearchObj.setK2_IssuingDepartment(DateUtil.getTodayDateTime().toString());
                keywordSearchObj.setK2_keywords("K2_KEYWORDS" + pos);

                keywordPolicySearchObjList.add(keywordSearchObj);

            }
            log.info("keywordPolicySearchObjList  : " +
                     keywordPolicySearchObjList.size());
        }
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setKeywordPolicySearchObjList(List<KeywordPolicySearchObj> keywordPolicySearchObjList) {
        this.keywordPolicySearchObjList = keywordPolicySearchObjList;
    }

    public List<KeywordPolicySearchObj> getKeywordPolicySearchObjList() {
        return keywordPolicySearchObjList;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setI1(UIXIterator i1) {
        this.i1 = i1;
    }

    public UIXIterator getI1() {
        return i1;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setPlam4(RichPanelLabelAndMessage plam4) {
        this.plam4 = plam4;
    }

    public RichPanelLabelAndMessage getPlam4() {
        return plam4;
    }

    public void setOl1(RichOutputLabel ol1) {
        this.ol1 = ol1;
    }

    public RichOutputLabel getOl1() {
        return ol1;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setAdvanceSearchSelectedValues(List<String> advanceSearchSelectedValues) {
        this.advanceSearchSelectedValues = advanceSearchSelectedValues;
    }

    public List<String> getAdvanceSearchSelectedValues() {
        return advanceSearchSelectedValues;
    }

    public void setSmc1(RichSelectManyChoice smc1) {
        this.smc1 = smc1;
    }

    public RichSelectManyChoice getSmc1() {
        return smc1;
    }

    public void setAdvanceSearchSelectItem(List<SelectItem> advanceSearchSelectItem) {
        this.advanceSearchSelectItem = advanceSearchSelectItem;
    }

    public List<SelectItem> getAdvanceSearchSelectItem() {
        return advanceSearchSelectItem;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getListSize() {
        if (ValidatorUtil.isNotNull(keywordPolicySearchObjList)) {
            listSize = this.keywordPolicySearchObjList.size();
        } else {
            listSize = 0;
        }
        return listSize;
    }

    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setCl2(RichCommandLink cl2) {
        this.cl2 = cl2;
    }

    public RichCommandLink getCl2() {
        return cl2;
    }
}
