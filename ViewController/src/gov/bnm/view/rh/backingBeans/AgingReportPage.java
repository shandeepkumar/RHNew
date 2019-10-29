package gov.bnm.view.rh.backingBeans;


import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.JSFUtils;

import javax.faces.component.UISelectItems;

import javax.faces.component.html.HtmlPanelGrid;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;

public class AgingReportPage {

    static Logger log = Logger.getLogger(AgingReportPage.class);
    private RichPanelStretchLayout psl1;
    private RichTable t1;
    private RichInputDate id1;
    private RichInputDate id2;
    private RichPanelGroupLayout pgl1;
    private RichPanelFormLayout pfl1;
    private RichInputDate id3;
    private RichInputDate id4;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichCommandButton cb1;
    private RichCommandLink cl1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichSelectOneRadio sor1;
    private RichSelectItem si5;
    private RichSelectItem si6;
    private RichSelectItem si7;
    private RichOutputText ot1;
    private RichPanelGroupLayout pgl3;
    private RichPanelGroupLayout pgl4;
    private RichPanelFormLayout pfl2;
    private HtmlPanelGrid pg1;

    private RichPanelGroupLayout pgl2;
    private RichInputDate id5;
    private RichSelectOneChoice soc5;
    private UISelectItems si8;
    private RichTable t2;

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }
    
    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }
    
    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
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

    public void setCl1(RichCommandLink cl1) {
        this.cl1 = cl1;
    }

    public RichCommandLink getCl1() {
        return cl1;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }
    
    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
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

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSi5(RichSelectItem si5) {
        this.si5 = si5;
    }

    public RichSelectItem getSi5() {
        return si5;
    }

    public void setSi6(RichSelectItem si6) {
        this.si6 = si6;
    }

    public RichSelectItem getSi6() {
        return si6;
    }

    public void setSi7(RichSelectItem si7) {
        this.si7 = si7;
    }

    public RichSelectItem getSi7() {
        return si7;
    }
    
    public void setSi8(UISelectItems si8) {
        this.si8 = si8;
    }

    public UISelectItems getSi8() {
        return si8;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setPg1(HtmlPanelGrid pg1) {
        this.pg1 = pg1;
    }

    public HtmlPanelGrid getPg1() {
        return pg1;
    }
    
    public String doSearch() {
        
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        String policyDuration = rhSession.getPolicyDuration();

        // Issurance Date
        String fromDateIssuranceDate = DateUtils.convertJSFDateTime(this.getId1().getValue());
        String toDateIssuranceDate = DateUtils.convertJSFDateTime(this.getId3().getValue());
        
        // New Effective Date
        String fromDateEffectiveDate = DateUtils.convertJSFDateTime(this.getId4().getValue());
        String toDateEffectiveDate = DateUtils.convertJSFDateTime(this.getId5().getValue());
        
        // Department
        JSFUtils.setExpressionValue("#{bindings.varDepartmentId1.inputValue}", this.getSoc2().getValue());
        String departmentId = BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.varDepartmentId1.attributeValue}"));
        
        // DepartmentType
        JSFUtils.setExpressionValue("#{bindings.varDocTypeId11.inputValue}", this.getSoc5().getValue());
        String doctypeId = BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.varDocTypeId11.attributeValue}"));
        
        // Category
        JSFUtils.setExpressionValue("#{bindings.varCategoryId1.inputValue}", this.getSoc3().getValue());
        String categoryId = BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.varCategoryId1.attributeValue}"));

        // Sector
        JSFUtils.setExpressionValue("#{bindings.varSectorId1.inputValue}", this.getSoc4().getValue());
        String sectorId = BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.varSectorId1.attributeValue}"));
        
        // Publishing in BNM Website
        String publishedWebsite = BaseUtil.getStr(this.getSor1().getValue());
        
        // Status
        String status = BaseUtil.getStr(this.getSoc1().getValue());
        
        // Search Items Adding Section
        String itemIds = CommonRHUtil.policyAgingReportSearch(
                                            fromDateIssuranceDate, 
                                            toDateIssuranceDate, 
                                            fromDateEffectiveDate,
                                            toDateEffectiveDate,
                                            departmentId,
                                            doctypeId,
                                            categoryId, 
                                            sectorId, 
                                            status,
                                            publishedWebsite);
        
        if (!itemIds.equals("()") && !itemIds.equals("")) {
            
            DCIteratorBinding parIterator = ADFUtils.findIterator("PolicyAgingReportViewObj1Iterator");
            ViewObject vo = parIterator.getViewObject();
            vo.setNamedWhereClauseParam("bindPolicyAge", policyDuration);
            vo.setNamedWhereClauseParam("bindPolicyAge1", policyDuration);
            vo.setNamedWhereClauseParam("bindItemId", "");
            vo.setWhereClause(" itemId in" + itemIds);
            vo.executeQuery();
        } 
        else {
            
            DCIteratorBinding parIterator = ADFUtils.findIterator("PolicyAgingReportViewObj1Iterator");
            ViewObject vo = parIterator.getViewObject();
            vo.setNamedWhereClauseParam("bindPolicyAge", policyDuration);
            vo.setNamedWhereClauseParam("bindPolicyAge1", policyDuration);
            vo.setNamedWhereClauseParam("bindItemId", "");
            vo.setWhereClause(" itemId in ('XYZ123ABC')");
            vo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT1());
        return null;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }
}
