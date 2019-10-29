package gov.bnm.view.rh.backingBeans;


import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;

import gov.bnm.view.rh.utils.FileUploadUtils;

import java.io.OutputStream;

import java.util.Map;

import java.util.Set;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;

public class WhatsNewPage {

    static Logger log = Logger.getLogger(WhatsNewPage.class);
    private RichPanelStretchLayout psl1;
    private RichTable t1;
    private RichInputDate id1;
    private RichOutputText ot5;
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichInputDate id2;
    private RichInputText it1;
    private RichImage i1;
    private RichCommandButton cb1;
    private RichCommandLink cl1;

    public void onOpenPolFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        String rowKey = BaseUtil.getStr(comp.getAttributes().get("rowKey"));

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
                                        getCb1().getClientId(FacesContext.getCurrentInstance()));
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void customTableQueryListener(QueryEvent queryEvent) {
        // Add event code here...


        // pre-processing code here

        boolean invokeQuery = true;
        /*
        * Method called by the Query Listener. This method checks if
        * the DepartmentId parameter contains a valid number and puts
        * the DepartmentName into the expected case
        */
        FilterableQueryDescriptor fqd =
            (FilterableQueryDescriptor)queryEvent.getDescriptor();
        Map map = fqd.getFilterCriteria();

        //
        //        Set keys = map.keySet();
        //
        //        while (keys.iterator().hasNext()) {
        //            String key = (String)keys.iterator().next();
        //            String value = (String)map.get(key);
        //
        //
        //            log.info(" key value :  " + key + "  vlaue  : " + map.get(key));
        //        }

        //        // ensure DepartmentId contains a Number
        //        String departmentId = (String)map.get("DepartmentId");
        //
        //        {
        //            if (departmentId != null && departmentId.length() > 0) {
        //
        //                try {
        //                    // try to parse String to integer
        //                    Long.parseLong(departmentId);
        //                } catch (Exception ex) {
        //                    // not a string
        //                    log.error("Not a string");
        //                    // add some error message here
        //                    // unset selection
        //                    map.remove("DepartmentId");
        //                    invokeQuery = false;
        //                }
        //            }

        log.info("query event component : " + queryEvent.getComponent());
        log.info("query event phase : " + queryEvent.getPhaseId());
        log.info("query event source : " + queryEvent.getSource());
        log.info("query event descripter : " + queryEvent.getDescriptor());
    }


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

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
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

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setI1(RichImage i1) {
        this.i1 = i1;
    }

    public RichImage getI1() {
        return i1;
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
}
