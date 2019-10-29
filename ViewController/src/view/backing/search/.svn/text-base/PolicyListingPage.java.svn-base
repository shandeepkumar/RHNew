package view.backing.search;

import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;

import gov.bnm.view.rh.utils.FileUploadUtils;

import gov.view.common.configuration.Constants;

import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;


public class PolicyListingPage {


    private RichTable t1;
    private RichCommandButton cb1;
    private RichCommandLink cl1;

    public void onOpenPolFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        String rowKey = BaseUtil.getStr(comp.getAttributes().get("rowKey"));

        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachmentDownloadViewObj1Iterator");
        ViewObject vo = iterBindings.getViewObject();
        vo.setNamedWhereClauseParam("bindFileId", rowKey);
        vo.executeQuery();
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

    public String checkPolicyActiveOnlyView() {
        // Add event code here...


        return Constants.STATUS_SUCCESS;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
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
