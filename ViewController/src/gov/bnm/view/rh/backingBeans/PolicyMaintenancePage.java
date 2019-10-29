package gov.bnm.view.rh.backingBeans;


import gov.bnm.rh.views.AttachedfileSupportDocViewObjRowImpl;
import gov.bnm.rh.views.AuditTrailsViewRowImpl;
import gov.bnm.rh.views.CategoriesViewRowImpl;
import gov.bnm.rh.views.EnquiryfaqForFaqViewRowImpl;
import gov.bnm.rh.views.PolicyActiveOnlyViewObjRowImpl;
import gov.bnm.rh.views.PolicycategoriespartitionViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;
import gov.bnm.view.rh.utils.RandomGuidUtil;

import gov.view.common.utils.UtilCommon;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.RegionContext;
import oracle.adf.model.RegionController;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.component.UIXIterator;
import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class PolicyMaintenancePage implements RegionController {

    static Logger log = Logger.getLogger(PolicyMaintenancePage.class);
    private RichOutputText ot1;
    private RichPanelStretchLayout psl1;
    private RichShowDetailItem sdi1;
    private RichShowDetailItem sdi2;
    private RichPanelTabbed pt2;
    private RichShowDetailItem sdi3;
    private RichShowDetailItem sdi4;
    private RichShowDetailItem sdi5;

    private RichPanelFormLayout pfl1;
    private RichOutputText ot4;
    private RichOutputText ot5;
    private RichOutputText ot6;
    private RichOutputText ot7;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot8;
    private RichPanelLabelAndMessage plam6;
    private RichOutputText ot9;
    private RichOutputText ot11;
    private RichOutputText ot12;
    private RichOutputText ot16;
    private RichOutputText ot17;
    private RichOutputText ot18;
    private RichOutputText ot19;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichOutputText ot22;
    private RichPanelLabelAndMessage panelLabelAndMessage1;
    private RichOutputText outputText1;
    private RichOutputText ot26;
    private RichOutputText ot27;
    private RichOutputText ot28;
    private RichOutputText ot29;
    private RichOutputText ot30;
    private RichOutputText ot31;
    private RichOutputText ot32;
    private RichTable t1;
    private RichPanelStretchLayout psl2;
    private RichOutputText ot25;
    private RichOutputText ot33;
    private RichPanelGroupLayout pgl4;
    private RichOutputText ot34;
    private RichOutputText ot35;
    private RichOutputText ot36;
    private RichCommandButton cb3;
    private RichInputText it1;
    private RichPanelGroupLayout pgl5;
    private RichCommandButton cb4;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private String faqAction = "N";
    private RichSpacer s1;
    private RichCommandButton cb7;
    private RichPopup p1;
    private RichDialog d1;
    private RichOutputText ot38;
    private RichOutputFormatted of1;
    private RichTextEditor rte1;
    private RichOutputFormatted of2;
    private RichInputText it2;
    private RichOutputFormatted of3;
    private RichOutputFormatted of4;
    private RichSpacer s3;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl3;
    private RichPanelStretchLayout psl3;
    private RichInputDate id1;
    private RichPanelGroupLayout pgl1;
    private RichInputDate id2;
    private RichPanelFormLayout pfl4;
    private RichSpacer s19;
    private RichOutputText ot43;
    private RichOutputText ot44;
    private RichOutputFormatted of5;
    private RichCommandLink cl6;
    private RichPanelStretchLayout psl4;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichInputFile if1;
    private RichPanelGroupLayout pgl7;
    private RichCommandButton cb8;
    private RichCommandButton cb9;
    private boolean suppDocAction = false;
    private UploadedFile suppDocUploadedFile;
    private RichCommandButton cb10;
    private RichPanelGroupLayout pgl8;
    private RichCommandButton cb11;
    private RichPopup p2;
    private RichCommandButton cb12;
    private RichPanelFormLayout pfl5;
    private RichInputDate id3;
    private RichSelectOneChoice soc2;
    private RichSelectOneRadio sor1;
    private UISelectItems si2;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichCommandButton cb13;
    private RichInputDate id4;
    private UIXGroup g1;
    private RichPanelGroupLayout pgl10;
    private RichSpacer s12;
    private RichCommandLink cl8;
    private RichCommandLink cl9;
    private RichSelectOneChoice soc5;
    RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
    private RichOutputText ot63;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot65;
    private RichOutputText ot66;
    private RichPanelGroupLayout pgl11;
    private RichSpacer s111;
    private RichPanelGroupLayout pgl12;
    private RichCommandButton cb14;
    private RichSpacer s36;
    private RichSpacer s30;
    private RichPopup p3;
    private RichDialog d3;
    private RichOutputText ot58;
    private RichCommandButton cb15;
    private RichPanelGroupLayout pgl3;
    private RichPanelGroupLayout pgl6;
    private RichSpacer s39;
    private RichOutputText ot51;
    private RichSpacer s40;
    private RichOutputText ot52;
    private UIXIterator i2;
    private RichOutputText ot53;
    private RichSpacer s4;
    private RichOutputText ot54;
    private RichOutputText ot55;
    private RichOutputText ot56;
    private RichOutputFormatted of6;
    private RichSpacer s5;
    private RichOutputText ot57;
    private RichOutputFormatted of7;
    private RichSpacer s6;
    private RichOutputText ot59;
    private RichOutputFormatted of8;
    private RichSpacer s7;
    private RichOutputText ot60;
    private UIXIterator i6;
    private RichOutputText ot13;
    private UIXIterator i7;
    private RichOutputText ot14;
    private UIXIterator i8;
    private RichOutputText ot15;
    private RichSpacer s9;
    private RichOutputText ot61;
    private RichOutputText ot62;
    private RichSpacer s33;
    private RichOutputText ot67;
    private UIXIterator i9;
    private RichOutputText ot10;
    private RichSpacer s8;
    private RichOutputText ot68;
    private RichTable t2;
    private RichOutputText ot69;
    private UIXIterator i10;
    private RichOutputText ot20;
    private RichSpacer s10;
    private RichOutputText ot70;
    private UIXIterator i5;
    private RichCommandLink cl5;
    private RichSpacer s11;
    private RichOutputText ot71;
    private RichTable t3;
    private RichCommandLink cl12;
    private RichSpacer s35;
    private RichCommandLink cl11;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot72;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot73;
    private RichPanelFormLayout pfl6;
    private RichCommandButton cb16;
    private RichOutputText ot74;
    private RichOutputText ot75;
    private RichSpacer s13;
    private UIXIterator i1;
    private RichOutputText ot76;
    private RichOutputFormatted of9;
    private RichSpacer s14;
    private RichCommandButton cb17;
    private RichInputText it3;
    private RichSpacer s15;
    private RichTextEditor rte2;
    private RichSpacer s16;
    private RichOutputText ot77;
    private RichPanelFormLayout pfl7;
    private RichOutputText ot41;
    private RichOutputText ot42;
    private RichTable t4;
    private RichSpacer s20;
    private RichOutputText ot45;
    private RichOutputText ot78;
    private RichSpacer s21;
    private RichOutputText ot46;
    private RichOutputFormatted of10;
    private RichOutputText ot79;
    private RichOutputText ot47;
    private RichOutputText ot48;
    private RichSpacer s22;
    private RichOutputText ot49;
    private RichDialog d2;
    private RichOutputText ot50;
    private RichCommandButton cb18;
    private RichTable t5;
    private RichSpacer s23;
    private RichPanelGroupLayout pgl15;
    private RichCommandButton cb19;
    private RichSpacer s24;
    private RichCommandButton cb20;
    private RichSpacer s28;
    private RichPanelFormLayout pfl8;
    private RichPanelGroupLayout pgl16;
    private RichCommandButton cb21;
    private RichSpacer s25;
    private RichCommandButton cb22;
    private RichInputText it4;
    private RichSpacer s26;
    private RichSpacer s27;
    private RichInputFile if2;
    private RichSpacer s29;
    private RichOutputText ot80;
    private RichOutputText ot81;
    private RichOutputText ot82;
    private RichOutputText ot83;
    private RichSpacer s34;
    private RichOutputText ot64;
    private UIXIterator i4;
    private RichCommandLink cl10;
    private RichSpacer s2;
    private RichOutputText ot84;
    private RichTable t6;
    private boolean viewEnqStatus = false;
    private RichCommandButton Cb23;
    private RichSpacer S30;
    private RichPopup p4;
    private RichSpacer s31;
    private RichSpacer s32;
    private RichTable t7;
    private UIXIterator i12;
    private UIXIterator i13;

    public PolicyMaintenancePage() {
        super();
    }

    @Override
    public boolean refreshRegion(RegionContext regionContext) {
        log.info("refreshRegion::");
        int refreshFlag = regionContext.getRefreshFlag();
        FacesContext fctx = FacesContext.getCurrentInstance();
        //check internal request parameter
        Map requestMap = fctx.getExternalContext().getRequestMap();
        PhaseId currentPhase =
            (PhaseId)requestMap.get("oracle.adfinternal.view.faces.lifecycle.CURRENT_PHASE_ID");
        if (currentPhase.getOrdinal() ==
            PhaseId.RENDER_RESPONSE.getOrdinal()) // write custom logic of correct lifecycle phase.
        {
            String itemId =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
            log.info("on itemId::" + itemId);
            Object showPrintableBehavior =
                requestMap.get("oracle.adfinternal.view.faces.el.PrintablePage");
            if (showPrintableBehavior != null) {
                if (Boolean.TRUE == showPrintableBehavior) {
                    ExtendedRenderKitService erks = null;
                    erks =
Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                    //invoke JavaScript from the server
                    erks.addScript(fctx, "window.print();");
                    erks.addScript(fctx, "window.close();");

                }
            }
            regionContext.getRegionBinding().refresh(refreshFlag);
        }

        return false;
    }

    @Override
    public boolean validateRegion(RegionContext regionContext) {
        regionContext.getRegionBinding().validate();
        return false;
    }

    @Override
    public boolean isRegionViewable(RegionContext regionContext) {
        return regionContext.getRegionBinding().isViewable();
    }

    @Override
    public String getName() {
        return null;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }


    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }


    public void setSdi2(RichShowDetailItem sdi2) {
        this.sdi2 = sdi2;
    }

    public RichShowDetailItem getSdi2() {
        return sdi2;
    }


    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setSdi3(RichShowDetailItem sdi3) {
        this.sdi3 = sdi3;
    }

    public RichShowDetailItem getSdi3() {
        return sdi3;
    }

    public void setSdi4(RichShowDetailItem sdi4) {
        this.sdi4 = sdi4;
    }

    public RichShowDetailItem getSdi4() {
        return sdi4;
    }

    public void setSdi5(RichShowDetailItem sdi5) {
        this.sdi5 = sdi5;
    }

    public RichShowDetailItem getSdi5() {
        return sdi5;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }


    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }

    public void setPlam6(RichPanelLabelAndMessage plam6) {
        this.plam6 = plam6;
    }

    public RichPanelLabelAndMessage getPlam6() {
        return plam6;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setOt12(RichOutputText ot12) {
        this.ot12 = ot12;
    }

    public RichOutputText getOt12() {
        return ot12;
    }


    public void onloadPage(ClientEvent event) {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        log.info("on event itemId::" + itemId);
        if (!itemId.equals("")) {
            getPolicyOtherDetails();
        }
    }

    public String getPolicyOtherDetails() {
        String itemId = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        log.info("itemId::" + itemId);
        // Department Owner
        DCIteratorBinding policydepartmentpartitionView1Iterator = ADFUtils.findIterator("PolicydepartmentpartitionView1Iterator");
        ViewObject policydepartmentVO = policydepartmentpartitionView1Iterator.getViewObject();
        policydepartmentVO.setNamedWhereClauseParam("bindItemId", itemId);
        policydepartmentVO.executeQuery();
        
        // Relavant Act                                                                     
        DCIteratorBinding PolicyRelavantActPartitionView1Iterator = ADFUtils.findIterator("PolicyRelavantActPartitionView1Iterator");
        ViewObject policyRelavantActVO = PolicyRelavantActPartitionView1Iterator.getViewObject();
        policyRelavantActVO.setNamedWhereClauseParam("bindItemId", itemId);
        policyRelavantActVO.executeQuery();
        
        // Issuring Department
        DCIteratorBinding PolicyIssuringDepartPartitionView1Iterator = ADFUtils.findIterator("PolicyIssuringDepartPartitionView1Iterator");
        ViewObject policyIssuringDepartmentVO = PolicyIssuringDepartPartitionView1Iterator.getViewObject();
        policyIssuringDepartmentVO.setNamedWhereClauseParam("bindItemId", itemId);
        policyIssuringDepartmentVO.executeQuery();

        DCIteratorBinding policybusinesssectorpartition1View1Iterator = ADFUtils.findIterator("Policybusinesssectorpartition1View1Iterator");
        ViewObject policybusinesssectorVO = policybusinesssectorpartition1View1Iterator.getViewObject();
        policybusinesssectorVO.setNamedWhereClauseParam("bindItemId", itemId);
        policybusinesssectorVO.executeQuery();

        DCIteratorBinding policyinstitutiontypepartitionView1Iterator = ADFUtils.findIterator("PolicyinstitutiontypepartitionView1Iterator");
        ViewObject institutiontypeVO = policyinstitutiontypepartitionView1Iterator.getViewObject();
        institutiontypeVO.setNamedWhereClauseParam("bindItemId", itemId);
        institutiontypeVO.executeQuery();

        DCIteratorBinding policyorganizationpartitionView1Iterator = ADFUtils.findIterator("PolicyorganizationpartitionView1Iterator");
        ViewObject organizationtVO = policyorganizationpartitionView1Iterator.getViewObject();
        organizationtVO.setNamedWhereClauseParam("bindItemId", itemId);
        organizationtVO.executeQuery();

        DCIteratorBinding PolicycategoriespartitionView1Iterator = ADFUtils.findIterator("PolicycategoriespartitionView1Iterator");
        ViewObject categoryVO = PolicycategoriespartitionView1Iterator.getViewObject();
        categoryVO.setNamedWhereClauseParam("bindItemId", itemId);
        categoryVO.executeQuery();
        log.info("categoryVO::" + categoryVO.getEstimatedRowCount());
        if (rhSession.getUniqueItems() != null) {
            rhSession.setUniqueItems(null);
        }
        if (categoryVO.getEstimatedRowCount() > 0) {

            for (int i = 0; i < categoryVO.getAllRowsInRange().length; i++) {
                BigDecimal categoryId = BaseUtil.getBigDecimal(categoryVO.getRowAtRangeIndex(i).getAttribute("CategoryID"));
                if (rhSession.getUniqueItems() == null) {
                    rhSession.setUniqueItems(new HashSet<BigDecimal>());
                    rhSession.getUniqueItems().add(categoryId);
                } 
                else {
                    rhSession.getUniqueItems().add(categoryId);
                }
            }
        }
        DCIteratorBinding superseededpoliciesView1Iterator = ADFUtils.findIterator("SuperseededpoliciesView1Iterator");
        ViewObject superseededVO = superseededpoliciesView1Iterator.getViewObject();
        superseededVO.setNamedWhereClauseParam("bindItemId", itemId);
        superseededVO.executeQuery();
        
        DCIteratorBinding attachedfileView1Iterator = ADFUtils.findIterator("AttachedFileOnlyPdfViewObj1Iterator");
        ViewObject polPdfVO = attachedfileView1Iterator.getViewObject();
        polPdfVO.setNamedWhereClauseParam("bindItemId", itemId);
        polPdfVO.executeQuery();
        
        DCIteratorBinding attachedfileView2_1Iterator = ADFUtils.findIterator("AttachedfileView2_1Iterator");
        ViewObject poldocVO = attachedfileView2_1Iterator.getViewObject();
        poldocVO.setNamedWhereClauseParam("bindItemId", itemId);
        poldocVO.executeQuery();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT3());
        DCIteratorBinding attachedfileEx1View1Iterator = ADFUtils.findIterator("AttachedfileEx1View1Iterator");
        ViewObject otherDocVO = attachedfileEx1View1Iterator.getViewObject();
        otherDocVO.setNamedWhereClauseParam("bindItemId", itemId);
        otherDocVO.setNamedWhereClauseParam("bindType", Constants.ATTACHMENT_TYPE_OTHER);
        otherDocVO.executeQuery();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT2());
        String originPolicyId = BaseUtil.getStr(CommonRHUtil.getAmendmentOriginPolicyId(itemId));
        if (originPolicyId.equals("")) {
            originPolicyId = itemId;
        }
        DCIteratorBinding policyamendmentsView1Iterator = ADFUtils.findIterator("PolicyamendmentHistoryViewObj1Iterator");
        ViewObject amendmentVO = policyamendmentsView1Iterator.getViewObject();
        amendmentVO.setNamedWhereClauseParam("bindOriginPolicyId", originPolicyId);
        amendmentVO.executeQuery();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT6());
        DCIteratorBinding enquiryfaqForFaqView1Iterator = ADFUtils.findIterator("EnquiryfaqForFaqView1Iterator");
        ViewObject enquiryfaqForFaqVO = enquiryfaqForFaqView1Iterator.getViewObject();
        enquiryfaqForFaqVO.setNamedWhereClauseParam("bindItemId", itemId);
        enquiryfaqForFaqVO.executeQuery();
        
        DCIteratorBinding enquiryfaqForEnqIterator = ADFUtils.findIterator("EnquiryfaqForEnqPolicyViewObj1Iterator");
        ViewObject enquiryfaqForFnqVO = enquiryfaqForEnqIterator.getViewObject();
        enquiryfaqForFnqVO.setNamedWhereClauseParam("bindItemId", itemId);
        enquiryfaqForFnqVO.executeQuery();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT4());
        DCIteratorBinding suppDocViewObj1Iterator = ADFUtils.findIterator("AttachedfileSupportDocViewObj1Iterator");
        ViewObject suppDocVO = suppDocViewObj1Iterator.getViewObject();
        suppDocVO.setNamedWhereClauseParam("bindItemId", itemId);
        suppDocVO.executeQuery();
        
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab", "Pre");
        return null;
    }

    public void prefaceOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("prefaceOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Pre");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void faqOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Faq");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void enqOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Enq");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void suppOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Supp");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void amentOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Ament");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void setOt16(RichOutputText ot16) {
        this.ot16 = ot16;
    }

    public RichOutputText getOt16() {
        return ot16;
    }

    public void setOt17(RichOutputText ot17) {
        this.ot17 = ot17;
    }

    public RichOutputText getOt17() {
        return ot17;
    }

    public void setOt18(RichOutputText ot18) {
        this.ot18 = ot18;
    }

    public RichOutputText getOt18() {
        return ot18;
    }

    public void setOt19(RichOutputText ot19) {
        this.ot19 = ot19;
    }

    public RichOutputText getOt19() {
        return ot19;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onOpenPolOthFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileEx1View1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT2());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb1().getClientId(FacesContext.getCurrentInstance()));
    }

    public void onOpenPolDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileView2_1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT3());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb1().getClientId(FacesContext.getCurrentInstance()));
    }

    public void onOpenPolPrefaceFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedFileOnlyPdfViewObj1Iterator");
        // FileUploadUtils.partialTableRefresh(rowKey, getT8());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);
        // Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb1().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setOt22(RichOutputText ot22) {
        this.ot22 = ot22;
    }

    public RichOutputText getOt22() {
        return ot22;
    }


    public void setPanelLabelAndMessage1(RichPanelLabelAndMessage panelLabelAndMessage1) {
        this.panelLabelAndMessage1 = panelLabelAndMessage1;
    }

    public RichPanelLabelAndMessage getPanelLabelAndMessage1() {
        return panelLabelAndMessage1;
    }

    public void setOutputText1(RichOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public RichOutputText getOutputText1() {
        return outputText1;
    }

    public void setOt26(RichOutputText ot26) {
        this.ot26 = ot26;
    }

    public RichOutputText getOt26() {
        return ot26;
    }

    public void setOt27(RichOutputText ot27) {
        this.ot27 = ot27;
    }

    public RichOutputText getOt27() {
        return ot27;
    }

    public void setOt28(RichOutputText ot28) {
        this.ot28 = ot28;
    }

    public RichOutputText getOt28() {
        return ot28;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setOt29(RichOutputText ot29) {
        this.ot29 = ot29;
    }

    public RichOutputText getOt29() {
        return ot29;
    }

    public void setOt30(RichOutputText ot30) {
        this.ot30 = ot30;
    }

    public RichOutputText getOt30() {
        return ot30;
    }

    public void setOt31(RichOutputText ot31) {
        this.ot31 = ot31;
    }

    public RichOutputText getOt31() {
        return ot31;
    }

    public void setOt32(RichOutputText ot32) {
        this.ot32 = ot32;
    }

    public RichOutputText getOt32() {
        return ot32;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public String gotoViewPolicy() {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("oldItemId",
                                                                    itemId);
        String openTabVal =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTabVal"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTabVal",
                                                                    openTabVal);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("sup",
                                                                    "N");
        String viewPolicyId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("ViewPolicyId"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("itemId",
                                                                    viewPolicyId);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("formType",
                                                                    "PV");
        return "filterByPolicyId";
    }

    public String gotoSuperseededViewPolicy() {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        String openTabVal =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTabVal"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTabVal",
                                                                    openTabVal);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("oldItemId",
                                                                    itemId);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("formType",
                                                                    "PV");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("sup",
                                                                    "Y");
        String viewPolicyId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemIdSup"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("itemId",
                                                                    viewPolicyId);
        return "filterByPolicyId";
    }
    
    // AuditTrailSavingCommit
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
        commitAction();
    }

    // Amend Policy
    public String gotoAmendmentPolicy() {
        
        String itemId = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        
        if (itemId != null && !itemId.equals("")) {
        
            String recordStatus = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("RecordStatus"));
            String newIssuanceDate = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("NewIssuanceDate"));
            System.out.println("newIssuanceDate:" + newIssuanceDate);

            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("sup", "N");
            if (Constants.RECORD_STATUS_ACTIVE.equals(recordStatus)) {
            
                int result = DateUtils.getIssuanceDateBalanceDays(newIssuanceDate);
                if (result < 2) {
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("formType", "PA");
                    auditTrailSave(itemId, "Amend");
                } 
                else {
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("formType", "PP");
                }
            } 
            else {
                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("formType", "PP");
            }
            return "filterByPolicyId";
        } 
        else {
            ADFUtils.showErrorMessage("Please Click on Policy Title ");
            return null;
        }
    }

    // Archive Policy
    public void doArchivePolicy(DialogEvent dialogEvent) {
        
        String itemId = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        
        log.info("dialogEvent::" + dialogEvent.getOutcome());
        if (dialogEvent.getOutcome() == dialogEvent.getOutcome().yes) {
            boolean status = CommonRHUtil.doArchivePolicy(itemId);
            if (status) {
                
                DCIteratorBinding policyView1Iterator = ADFUtils.findIterator("PolicyView1Iterator");
                ViewObject vo = policyView1Iterator.getViewObject();
                vo.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT1());
                auditTrailSave(itemId, "Archive");
            }
        }
    }
    
    // Active Policy 
    public void doActivePolicy(DialogEvent dialogEvent) {
        
        String itemId = BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        
        log.info("dialogEvent::" + dialogEvent.getOutcome());
        if (dialogEvent.getOutcome() == dialogEvent.getOutcome().yes) {
            boolean status = CommonRHUtil.doActivePolicy(itemId);
            if (status) {
                DCIteratorBinding policyView1Iterator = ADFUtils.findIterator("PolicyView1Iterator");
                ViewObject vo = policyView1Iterator.getViewObject();
                vo.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT1());
                auditTrailSave(itemId, "Re-activate");
            }
        }
    }

    public void setPsl2(RichPanelStretchLayout psl2) {
        this.psl2 = psl2;
    }

    public RichPanelStretchLayout getPsl2() {
        return psl2;
    }

    public void setOt25(RichOutputText ot25) {
        this.ot25 = ot25;
    }

    public RichOutputText getOt25() {
        return ot25;
    }

    public void setOt33(RichOutputText ot33) {
        this.ot33 = ot33;
    }

    public RichOutputText getOt33() {
        return ot33;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setOt34(RichOutputText ot34) {
        this.ot34 = ot34;
    }

    public RichOutputText getOt34() {
        return ot34;
    }

    public void setOt35(RichOutputText ot35) {
        this.ot35 = ot35;
    }

    public RichOutputText getOt35() {
        return ot35;
    }

    public void setOt36(RichOutputText ot36) {
        this.ot36 = ot36;
    }

    public RichOutputText getOt36() {
        return ot36;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
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

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public String actionAddFaq() {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        if (!itemId.equals("")) {
            setFaqAction("Y");
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPfl6());
            JSFUtils.setFocus(this.getRte2());
        }
        return null;
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
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        log.info("getIt3::" + this.getIt3().getValue());
        log.info("getRte2::" + this.getRte2().getValue());
        DCIteratorBinding enquiryfaqForFaqView1Iterator =
            ADFUtils.findIterator("EnquiryfaqForFaqView1Iterator");
        ViewObject policydepartmentVO =
            enquiryfaqForFaqView1Iterator.getViewObject();
        EnquiryfaqForFaqViewRowImpl faqRowImpl =
            (EnquiryfaqForFaqViewRowImpl)policydepartmentVO.createRow();

        String alignFormat =
            CommonRHUtil.alignHtml(BaseUtil.getStr(this.getRte2().getValue()));
        faqRowImpl.setEnquiryFAQId(RandomGuidUtil.fnGuidWithDate());
        faqRowImpl.setTitle(BaseUtil.getStr(this.getIt3().getValue()));
        faqRowImpl.setitemId(itemId);
        faqRowImpl.setAbstract11(alignFormat);
        faqRowImpl.setOrigTitle(BaseUtil.getStr(this.getIt3().getValue()));
        faqRowImpl.setOrigAbstract(alignFormat);
        faqRowImpl.setEnquiryOrFaq(Constants.RECORD_TYPE_FAQ);
        faqRowImpl.setfaqStatus(recordStatus);
        faqRowImpl.setCurrentItemtype(Constants.RECORD_TYPE_FAQ);
        faqRowImpl.setOriginalItemtype(Constants.RECORD_TYPE_FAQ);
        faqRowImpl.setcreateDate(DateUtils.getCurrentTimestamp());
        faqRowImpl.setupdateDate(DateUtils.getCurrentTimestamp());
        faqRowImpl.setcreatedBy(rhSession.getFldUserid());
        policydepartmentVO.insertRow(faqRowImpl);
        commitAction();
        this.getIt3().setValue("");
        this.getRte2().setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt3());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte2());
    }

    private String commitAction() {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            ADFUtils.showInfoMessage(Constants.ERROR_MESSAGE_CONTACT);
            log.error(" ... " + operationBinding.getErrors());
        } else {
            ADFUtils.showInfoMessage(Constants.DATA_SAVE_SUCCESSFULLY);
        }
        return null;
    }

    public void onOpenEnqQueFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqQueView1Iterator");

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb10().getClientId(FacesContext.getCurrentInstance()));
        setViewEnqStatus(true);
    }

    public void enquiryTableSelectionListener(SelectionEvent selectionEvent) {
        JSFUtils.invokeEL("#{bindings.EnquiryfaqForEnqPolicyViewObj1.collectionModel.makeCurrent}",
                          new Class[] { SelectionEvent.class },
                          new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow =
            (Row)JSFUtils.evaluateEL("#{bindings.EnquiryfaqForEnqPolicyViewObj1.currentRow}"); // get the current selected row
        try {
            String abstract11 =
                BaseUtil.getStr(selectedRow.getAttribute("Abstract11"));
            this.getOt46().setValue(UtilCommon.decryptSpecialChar(abstract11));
            this.getOt78().setValue(selectedRow.getAttribute("Title"));
            String fldEnquiryFAQId =
                BaseUtil.getStr(selectedRow.getAttribute("EnquiryFAQId"));
            DCIteratorBinding attQueIter =
                ADFUtils.findIterator("AttachedfileForEnqQueView1Iterator");
            ViewObject attQueVO = attQueIter.getViewObject();
            attQueVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attQueVO.executeQuery();
            DCIteratorBinding attAnsIter =
                ADFUtils.findIterator("AttachedfileForEnqAnsView1Iterator");
            ViewObject attAnsVO = attAnsIter.getViewObject();
            attAnsVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attAnsVO.executeQuery();
            setViewEnqStatus(true);
        } catch (Exception e) {
            log.info("Exception @notOperationTableSelectionListener .. " + e);
        }
    }

    public void onOpenEnqAnsFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqAnsView1Iterator");

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb10().getClientId(FacesContext.getCurrentInstance()));
        setViewEnqStatus(true);
    }


    public void setFaqAction(String faqAction) {
        this.faqAction = faqAction;
    }

    public String getFaqAction() {
        return faqAction;
    }


    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }


    public void setOt38(RichOutputText ot38) {
        this.ot38 = ot38;
    }

    public RichOutputText getOt38() {
        return ot38;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setRte1(RichTextEditor rte1) {
        this.rte1 = rte1;
    }

    public RichTextEditor getRte1() {
        return rte1;
    }

    public void setOf2(RichOutputFormatted of2) {
        this.of2 = of2;
    }

    public RichOutputFormatted getOf2() {
        return of2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }


    public void setOf3(RichOutputFormatted of3) {
        this.of3 = of3;
    }

    public RichOutputFormatted getOf3() {
        return of3;
    }

    public void setOf4(RichOutputFormatted of4) {
        this.of4 = of4;
    }

    public RichOutputFormatted getOf4() {
        return of4;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setPsl3(RichPanelStretchLayout psl3) {
        this.psl3 = psl3;
    }

    public RichPanelStretchLayout getPsl3() {
        return psl3;
    }


    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }


    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setS19(RichSpacer s19) {
        this.s19 = s19;
    }

    public RichSpacer getS19() {
        return s19;
    }

    public void setOt43(RichOutputText ot43) {
        this.ot43 = ot43;
    }

    public RichOutputText getOt43() {
        return ot43;
    }

    public void setOt44(RichOutputText ot44) {
        this.ot44 = ot44;
    }

    public RichOutputText getOt44() {
        return ot44;
    }

    public void setOf5(RichOutputFormatted of5) {
        this.of5 = of5;
    }

    public RichOutputFormatted getOf5() {
        return of5;
    }

    public void makeCurrent(SelectionEvent selectionEvent) {
        // Add event code here...
    }

    public void setCl6(RichCommandLink cl6) {
        this.cl6 = cl6;
    }

    public RichCommandLink getCl6() {
        return cl6;
    }

    public void setPsl4(RichPanelStretchLayout psl4) {
        this.psl4 = psl4;
    }

    public RichPanelStretchLayout getPsl4() {
        return psl4;
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

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setPgl7(RichPanelGroupLayout pgl7) {
        this.pgl7 = pgl7;
    }

    public RichPanelGroupLayout getPgl7() {
        return pgl7;
    }

    public void setCb8(RichCommandButton cb8) {
        this.cb8 = cb8;
    }

    public RichCommandButton getCb8() {
        return cb8;
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public String actionAddSupportDoc() {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        if (!itemId.equals("")) {
            setSuppDocAction(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPfl8());
            JSFUtils.setFocus(this.getIf2());
        }
        return null;
    }

    public String actionCancelSupportDoc() {
        setSuppDocAction(false);
        this.getIt4().setValue("");
        this.getSoc2().setValue("");
        this.getIf2().setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIf2());
        return null;
    }

    public String submitSuppdoc() {
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        log.info("getIt4::" + this.getIt4().getValue());
        log.info("getSoc2::" + this.getSoc2().getValue());
        suppDocUploadedFile = this.getSuppDocUploadedFile();
        String fileName = BaseUtil.getStr(suppDocUploadedFile.getFilename());
        if (!fileName.equals("")) {
            String fileId = RandomGuidUtil.fnGuidWithTimestamp();
            boolean fileUploadStatus =
                FileUploadUtils.setUploadedFile(suppDocUploadedFile, fileId);
            if (fileUploadStatus) {
                JSFUtils.setExpressionValue("#{bindings.ClassificationView1.inputValue}",
                                            this.getSoc2().getValue());
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
                attRowImpl.setAttribute("orderDate",
                                        DateUtils.getCurrentTimestamp());
                attRowImpl.setitemId(itemId);
                attachVO.insertRow(attRowImpl);
                commitAction();
                this.getIt4().setValue("");
                this.getSoc2().setValue("");
                this.getIf2().setValue(null);
                setSuppDocAction(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt4());
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSoc2());
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIf2());
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCb21());
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCb22());

                ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
            } else {
                ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
            }
        }
        return null;
    }

    public void setSuppDocAction(boolean suppDocAction) {
        this.suppDocAction = suppDocAction;
    }

    public boolean isSuppDocAction() {
        return suppDocAction;
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

    public void setCb10(RichCommandButton cb10) {
        this.cb10 = cb10;
    }

    public RichCommandButton getCb10() {
        return cb10;
    }

    public void setPgl8(RichPanelGroupLayout pgl8) {
        this.pgl8 = pgl8;
    }

    public RichPanelGroupLayout getPgl8() {
        return pgl8;
    }

    public void setCb11(RichCommandButton cb11) {
        this.cb11 = cb11;
    }

    public RichCommandButton getCb11() {
        return cb11;
    }

    public void doDeleteSuppDoc(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome() == dialogEvent.getOutcome().yes) {
            DCIteratorBinding policyView1Iterator =
                ADFUtils.findIterator("AttachedfileSupportDocViewObj1Iterator");
            Row row = policyView1Iterator.getViewObject().getCurrentRow();
            FileUploadUtils.removePhysicalFile(BaseUtil.getStr(row.getAttribute("filenameStore")));
            row.remove();
            commitAction();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT5());
        }
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void onOpenSuppDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileSupportDocViewObj1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT5());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        log.info("filenameStore::" + currentRow.getAttribute("filenameStore"));
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb18().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setCb12(RichCommandButton cb12) {
        this.cb12 = cb12;
    }

    public RichCommandButton getCb12() {
        return cb12;
    }


    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }


    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSi4(UISelectItems si4) {
        this.si4 = si4;
    }

    public UISelectItems getSi4() {
        return si4;
    }

    public void setCb13(RichCommandButton cb13) {
        this.cb13 = cb13;
    }

    public RichCommandButton getCb13() {
        return cb13;
    }


    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPgl10(RichPanelGroupLayout pgl10) {
        this.pgl10 = pgl10;
    }

    public RichPanelGroupLayout getPgl10() {
        return pgl10;
    }

    public void setS12(RichSpacer s12) {
        this.s12 = s12;
    }

    public RichSpacer getS12() {
        return s12;
    }

    public void setCl8(RichCommandLink cl8) {
        this.cl8 = cl8;
    }

    public RichCommandLink getCl8() {
        return cl8;
    }

    public String showDetailItemForFAQ() {
        this.getSdi2().setDisclosed(true);
        this.getSdi1().setDisclosed(false);
        String itemId =
            BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemId"));
        if (!itemId.equals("")) {
            setFaqAction("Y");
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt3());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte2());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCb7());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCb13());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCb16());
        }

        return null;
    }

    public String showDetailItemForEnq() {
        this.getSdi3().setDisclosed(true);
        this.getSdi1().setDisclosed(false);
        return null;
    }

    public void setCl9(RichCommandLink cl9) {
        this.cl9 = cl9;
    }

    public RichCommandLink getCl9() {
        return cl9;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setOt63(RichOutputText ot63) {
        this.ot63 = ot63;
    }

    public RichOutputText getOt63() {
        return ot63;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt65(RichOutputText ot65) {
        this.ot65 = ot65;
    }

    public RichOutputText getOt65() {
        return ot65;
    }

    public void setOt66(RichOutputText ot66) {
        this.ot66 = ot66;
    }

    public RichOutputText getOt66() {
        return ot66;
    }

    public void setPgl11(RichPanelGroupLayout pgl11) {
        this.pgl11 = pgl11;
    }

    public RichPanelGroupLayout getPgl11() {
        return pgl11;
    }


    public void setS111(RichSpacer s111) {
        this.s111 = s111;
    }

    public RichSpacer getS111() {
        return s111;
    }

    public void setPgl12(RichPanelGroupLayout pgl12) {
        this.pgl12 = pgl12;
    }

    public RichPanelGroupLayout getPgl12() {
        return pgl12;
    }

    public void setCb14(RichCommandButton cb14) {
        this.cb14 = cb14;
    }

    public RichCommandButton getCb14() {
        return cb14;
    }

    public void setS36(RichSpacer s36) {
        this.s36 = s36;
    }

    public RichSpacer getS36() {
        return s36;
    }
    
    public void setS30(RichSpacer S30) {
        this.S30 = S30;
    }

    public RichSpacer getS30() {
        return S30;
    }
    
    public void setS31(RichSpacer s31) {
        this.s31 = s31;
    }

    public RichSpacer getS31() {
        return s31;
    }
    
    public void setS32(RichSpacer s32) {
        this.s32 = s32;
    }

    public RichSpacer getS32() {
        return s32;
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }
    
    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setD3(RichDialog d3) {
        this.d3 = d3;
    }

    public RichDialog getD3() {
        return d3;
    }

    public void setOt58(RichOutputText ot58) {
        this.ot58 = ot58;
    }

    public RichOutputText getOt58() {
        return ot58;
    }

    public void setCb15(RichCommandButton cb15) {
        this.cb15 = cb15;
    }

    public RichCommandButton getCb15() {
        return cb15;
    }


    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setPgl6(RichPanelGroupLayout pgl6) {
        this.pgl6 = pgl6;
    }

    public RichPanelGroupLayout getPgl6() {
        return pgl6;
    }


    public void setS39(RichSpacer s39) {
        this.s39 = s39;
    }

    public RichSpacer getS39() {
        return s39;
    }

    public void setOt51(RichOutputText ot51) {
        this.ot51 = ot51;
    }

    public RichOutputText getOt51() {
        return ot51;
    }

    public void setS40(RichSpacer s40) {
        this.s40 = s40;
    }

    public RichSpacer getS40() {
        return s40;
    }

    public void setOt52(RichOutputText ot52) {
        this.ot52 = ot52;
    }

    public RichOutputText getOt52() {
        return ot52;
    }

    public void setI2(UIXIterator i2) {
        this.i2 = i2;
    }

    public UIXIterator getI2() {
        return i2;
    }

    public void setOt53(RichOutputText ot53) {
        this.ot53 = ot53;
    }

    public RichOutputText getOt53() {
        return ot53;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setOt54(RichOutputText ot54) {
        this.ot54 = ot54;
    }

    public RichOutputText getOt54() {
        return ot54;
    }

    public void setOt55(RichOutputText ot55) {
        this.ot55 = ot55;
    }

    public RichOutputText getOt55() {
        return ot55;
    }

    public void setOt56(RichOutputText ot56) {
        this.ot56 = ot56;
    }

    public RichOutputText getOt56() {
        return ot56;
    }

    public void setOf6(RichOutputFormatted of6) {
        this.of6 = of6;
    }

    public RichOutputFormatted getOf6() {
        return of6;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setOt57(RichOutputText ot57) {
        this.ot57 = ot57;
    }

    public RichOutputText getOt57() {
        return ot57;
    }

    public void setOf7(RichOutputFormatted of7) {
        this.of7 = of7;
    }

    public RichOutputFormatted getOf7() {
        return of7;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setOt59(RichOutputText ot59) {
        this.ot59 = ot59;
    }

    public RichOutputText getOt59() {
        return ot59;
    }

    public void setOf8(RichOutputFormatted of8) {
        this.of8 = of8;
    }

    public RichOutputFormatted getOf8() {
        return of8;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setOt60(RichOutputText ot60) {
        this.ot60 = ot60;
    }

    public RichOutputText getOt60() {
        return ot60;
    }

    public void setI6(UIXIterator i6) {
        this.i6 = i6;
    }

    public UIXIterator getI6() {
        return i6;
    }

    public void setOt13(RichOutputText ot13) {
        this.ot13 = ot13;
    }

    public RichOutputText getOt13() {
        return ot13;
    }

    public void setI7(UIXIterator i7) {
        this.i7 = i7;
    }

    public UIXIterator getI7() {
        return i7;
    }

    public void setOt14(RichOutputText ot14) {
        this.ot14 = ot14;
    }

    public RichOutputText getOt14() {
        return ot14;
    }

    public void setI8(UIXIterator i8) {
        this.i8 = i8;
    }

    public UIXIterator getI8() {
        return i8;
    }

    public void setOt15(RichOutputText ot15) {
        this.ot15 = ot15;
    }

    public RichOutputText getOt15() {
        return ot15;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void setOt61(RichOutputText ot61) {
        this.ot61 = ot61;
    }

    public RichOutputText getOt61() {
        return ot61;
    }

    public void setOt62(RichOutputText ot62) {
        this.ot62 = ot62;
    }

    public RichOutputText getOt62() {
        return ot62;
    }

    public void setS33(RichSpacer s33) {
        this.s33 = s33;
    }

    public RichSpacer getS33() {
        return s33;
    }

    public void setOt67(RichOutputText ot67) {
        this.ot67 = ot67;
    }

    public RichOutputText getOt67() {
        return ot67;
    }

    public void setI9(UIXIterator i9) {
        this.i9 = i9;
    }

    public UIXIterator getI9() {
        return i9;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void setOt68(RichOutputText ot68) {
        this.ot68 = ot68;
    }

    public RichOutputText getOt68() {
        return ot68;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setOt69(RichOutputText ot69) {
        this.ot69 = ot69;
    }

    public RichOutputText getOt69() {
        return ot69;
    }

    public void setI10(UIXIterator i10) {
        this.i10 = i10;
    }

    public UIXIterator getI10() {
        return i10;
    }

    public void setOt20(RichOutputText ot20) {
        this.ot20 = ot20;
    }

    public RichOutputText getOt20() {
        return ot20;
    }

    public void setS10(RichSpacer s10) {
        this.s10 = s10;
    }

    public RichSpacer getS10() {
        return s10;
    }

    public void setOt70(RichOutputText ot70) {
        this.ot70 = ot70;
    }

    public RichOutputText getOt70() {
        return ot70;
    }

    public void setI5(UIXIterator i5) {
        this.i5 = i5;
    }

    public UIXIterator getI5() {
        return i5;
    }
    
    public void setI12(UIXIterator i12) {
        this.i12 = i12;
    }

    public UIXIterator getI12() {
        return i12;
    }
    
    public void setI13(UIXIterator i13) {
        this.i13 = i13;
    }

    public UIXIterator getI13() {
        return i13;
    }

    public void setCl5(RichCommandLink cl5) {
        this.cl5 = cl5;
    }

    public RichCommandLink getCl5() {
        return cl5;
    }

    public void setS11(RichSpacer s11) {
        this.s11 = s11;
    }

    public RichSpacer getS11() {
        return s11;
    }

    public void setOt71(RichOutputText ot71) {
        this.ot71 = ot71;
    }

    public RichOutputText getOt71() {
        return ot71;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setCl12(RichCommandLink cl12) {
        this.cl12 = cl12;
    }

    public RichCommandLink getCl12() {
        return cl12;
    }

    public void setS35(RichSpacer s35) {
        this.s35 = s35;
    }

    public RichSpacer getS35() {
        return s35;
    }

    public void setCl11(RichCommandLink cl11) {
        this.cl11 = cl11;
    }

    public RichCommandLink getCl11() {
        return cl11;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt72(RichOutputText ot72) {
        this.ot72 = ot72;
    }

    public RichOutputText getOt72() {
        return ot72;
    }


    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt73(RichOutputText ot73) {
        this.ot73 = ot73;
    }

    public RichOutputText getOt73() {
        return ot73;
    }


    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setCb16(RichCommandButton cb16) {
        this.cb16 = cb16;
    }

    public RichCommandButton getCb16() {
        return cb16;
    }

    public void setOt74(RichOutputText ot74) {
        this.ot74 = ot74;
    }

    public RichOutputText getOt74() {
        return ot74;
    }

    public void setOt75(RichOutputText ot75) {
        this.ot75 = ot75;
    }

    public RichOutputText getOt75() {
        return ot75;
    }

    public void setS13(RichSpacer s13) {
        this.s13 = s13;
    }

    public RichSpacer getS13() {
        return s13;
    }

    public void setI1(UIXIterator i1) {
        this.i1 = i1;
    }

    public UIXIterator getI1() {
        return i1;
    }

    public void setOt76(RichOutputText ot76) {
        this.ot76 = ot76;
    }

    public RichOutputText getOt76() {
        return ot76;
    }

    public void setOf9(RichOutputFormatted of9) {
        this.of9 = of9;
    }

    public RichOutputFormatted getOf9() {
        return of9;
    }

    public void setS14(RichSpacer s14) {
        this.s14 = s14;
    }

    public RichSpacer getS14() {
        return s14;
    }

    public void setCb17(RichCommandButton cb17) {
        this.cb17 = cb17;
    }

    public RichCommandButton getCb17() {
        return cb17;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setS15(RichSpacer s15) {
        this.s15 = s15;
    }

    public RichSpacer getS15() {
        return s15;
    }

    public void setRte2(RichTextEditor rte2) {
        this.rte2 = rte2;
    }

    public RichTextEditor getRte2() {
        return rte2;
    }

    public void setS16(RichSpacer s16) {
        this.s16 = s16;
    }

    public RichSpacer getS16() {
        return s16;
    }

    public void setOt77(RichOutputText ot77) {
        this.ot77 = ot77;
    }

    public RichOutputText getOt77() {
        return ot77;
    }


    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
    }

    public void setOt41(RichOutputText ot41) {
        this.ot41 = ot41;
    }

    public RichOutputText getOt41() {
        return ot41;
    }

    public void setOt42(RichOutputText ot42) {
        this.ot42 = ot42;
    }

    public RichOutputText getOt42() {
        return ot42;
    }


    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }


    public void setS20(RichSpacer s20) {
        this.s20 = s20;
    }

    public RichSpacer getS20() {
        return s20;
    }

    public void setOt45(RichOutputText ot45) {
        this.ot45 = ot45;
    }

    public RichOutputText getOt45() {
        return ot45;
    }

    public void setOt78(RichOutputText ot78) {
        this.ot78 = ot78;
    }

    public RichOutputText getOt78() {
        return ot78;
    }

    public void setS21(RichSpacer s21) {
        this.s21 = s21;
    }

    public RichSpacer getS21() {
        return s21;
    }

    public void setOt46(RichOutputText ot46) {
        this.ot46 = ot46;
    }

    public RichOutputText getOt46() {
        return ot46;
    }

    public void setOf10(RichOutputFormatted of10) {
        this.of10 = of10;
    }

    public RichOutputFormatted getOf10() {
        return of10;
    }

    public void setOt79(RichOutputText ot79) {
        this.ot79 = ot79;
    }

    public RichOutputText getOt79() {
        return ot79;
    }


    public void setOt47(RichOutputText ot47) {
        this.ot47 = ot47;
    }

    public RichOutputText getOt47() {
        return ot47;
    }

    public void setOt48(RichOutputText ot48) {
        this.ot48 = ot48;
    }

    public RichOutputText getOt48() {
        return ot48;
    }

    public void setS22(RichSpacer s22) {
        this.s22 = s22;
    }

    public RichSpacer getS22() {
        return s22;
    }

    public void setOt49(RichOutputText ot49) {
        this.ot49 = ot49;
    }

    public RichOutputText getOt49() {
        return ot49;
    }


    public void setD2(RichDialog d2) {
        this.d2 = d2;
    }

    public RichDialog getD2() {
        return d2;
    }

    public void setOt50(RichOutputText ot50) {
        this.ot50 = ot50;
    }

    public RichOutputText getOt50() {
        return ot50;
    }

    public void setCb18(RichCommandButton cb18) {
        this.cb18 = cb18;
    }

    public RichCommandButton getCb18() {
        return cb18;
    }

    public void setT5(RichTable t5) {
        this.t5 = t5;
    }

    public RichTable getT5() {
        return t5;
    }

    public void setS23(RichSpacer s23) {
        this.s23 = s23;
    }

    public RichSpacer getS23() {
        return s23;
    }

    public void setPgl15(RichPanelGroupLayout pgl15) {
        this.pgl15 = pgl15;
    }

    public RichPanelGroupLayout getPgl15() {
        return pgl15;
    }

    public void setCb19(RichCommandButton cb19) {
        this.cb19 = cb19;
    }

    public RichCommandButton getCb19() {
        return cb19;
    }

    public void setS24(RichSpacer s24) {
        this.s24 = s24;
    }

    public RichSpacer getS24() {
        return s24;
    }

    public void setCb20(RichCommandButton cb20) {
        this.cb20 = cb20;
    }

    public RichCommandButton getCb20() {
        return cb20;
    }

    public void setS28(RichSpacer s28) {
        this.s28 = s28;
    }

    public RichSpacer getS28() {
        return s28;
    }

    public void setPfl8(RichPanelFormLayout pfl8) {
        this.pfl8 = pfl8;
    }

    public RichPanelFormLayout getPfl8() {
        return pfl8;
    }

    public void setPgl16(RichPanelGroupLayout pgl16) {
        this.pgl16 = pgl16;
    }

    public RichPanelGroupLayout getPgl16() {
        return pgl16;
    }

    public void setCb21(RichCommandButton cb21) {
        this.cb21 = cb21;
    }

    public RichCommandButton getCb21() {
        return cb21;
    }

    public void setS25(RichSpacer s25) {
        this.s25 = s25;
    }

    public RichSpacer getS25() {
        return s25;
    }

    public void setCb22(RichCommandButton cb22) {
        this.cb22 = cb22;
    }

    public RichCommandButton getCb22() {
        return cb22;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setS26(RichSpacer s26) {
        this.s26 = s26;
    }

    public RichSpacer getS26() {
        return s26;
    }


    public void setS27(RichSpacer s27) {
        this.s27 = s27;
    }

    public RichSpacer getS27() {
        return s27;
    }

    public void setIf2(RichInputFile if2) {
        this.if2 = if2;
    }

    public RichInputFile getIf2() {
        return if2;
    }

    public void setS29(RichSpacer s29) {
        this.s29 = s29;
    }

    public RichSpacer getS29() {
        return s29;
    }

    public void setOt80(RichOutputText ot80) {
        this.ot80 = ot80;
    }

    public RichOutputText getOt80() {
        return ot80;
    }


    public void setOt81(RichOutputText ot81) {
        this.ot81 = ot81;
    }

    public RichOutputText getOt81() {
        return ot81;
    }

    public void setOt82(RichOutputText ot82) {
        this.ot82 = ot82;
    }

    public RichOutputText getOt82() {
        return ot82;
    }

    public void setOt83(RichOutputText ot83) {
        this.ot83 = ot83;
    }

    public RichOutputText getOt83() {
        return ot83;
    }

    public void setS34(RichSpacer s34) {
        this.s34 = s34;
    }

    public RichSpacer getS34() {
        return s34;
    }

    public void setOt64(RichOutputText ot64) {
        this.ot64 = ot64;
    }

    public RichOutputText getOt64() {
        return ot64;
    }

    public void setI4(UIXIterator i4) {
        this.i4 = i4;
    }

    public UIXIterator getI4() {
        return i4;
    }

    public void setCl10(RichCommandLink cl10) {
        this.cl10 = cl10;
    }

    public RichCommandLink getCl10() {
        return cl10;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setOt84(RichOutputText ot84) {
        this.ot84 = ot84;
    }

    public RichOutputText getOt84() {
        return ot84;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void setViewEnqStatus(boolean viewEnqStatus) {
        this.viewEnqStatus = viewEnqStatus;
    }

    public boolean isViewEnqStatus() {
        return viewEnqStatus;
    }

    public void setCb23(RichCommandButton Cb23) {
        this.Cb23 = Cb23;
    }

    public RichCommandButton getCb23() {
        return Cb23;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }
}
