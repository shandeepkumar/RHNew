package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.EnquiryfaqForFaqManViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;

import gov.bnm.view.rh.utils.CommonRHUtil;

import gov.bnm.view.rh.utils.JSFUtils;

import gov.view.common.utils.UtilCommon;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichChooseDate;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class FaqsPage {
    static Logger log = Logger.getLogger(FaqsPage.class);

    private RichPanelGroupLayout pgl1;
    private RichSpacer s1;
    private RichTable t2;

    public void faqTableSelectionListener(SelectionEvent selectionEvent) {
        JSFUtils.invokeEL("#{bindings.EnquiryfaqForFaqManView1.collectionModel.makeCurrent}",
                          new Class[] { SelectionEvent.class },
                          new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow =
            (Row)JSFUtils.evaluateEL("#{bindings.EnquiryfaqForFaqManView1.currentRow}"); // get the current selected row
        try {
        
            String Abstract11 =
                BaseUtil.getStr(selectedRow.getAttribute("Abstract11"));
                        log.info("abstract1 before::"+Abstract11);
//            this.getRte1().setValue(UtilCommon.decryptSpecialChar(Abstract11));
                selectedRow.setAttribute("Abstract11",
                                         UtilCommon.decryptSpecialChar(Abstract11));
                        log.info("abstract1 after::"+selectedRow.getAttribute("Abstract11"));
        } catch (Exception e) {
            log.info("Exception @notOperationTableSelectionListener .. " + e);
        }
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }


    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }


    public String doPublishFaq() {
        doFaqCommit(Constants.RECORD_STATUS_ACTIVE);
        return null;
    }

    public String doArchiveFaq() {
        doFaqCommit(Constants.RECORD_STATUS_ARCHIVE);
        return null;
    }

    public String doFaqUpdate() {
        doFaqCommit("UPDATE");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("updateSts",
                                                                    "N");
        return null;
    }

    public String getUpdateStatus() {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("updateSts",
                                                                    "Y");
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt2());
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte1());
        return null;
    }

    public String doCancel() {

        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("updateSts",
                                                                    "N");
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getIt2());
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRte1());
        return null;
    }

    private void doFaqCommit(String recordStatus) {
        DCIteratorBinding enquiryfaqForFaqManView1Iterator =
            ADFUtils.findIterator("EnquiryfaqForFaqManView1Iterator");
        
        
        //EnquiryfaqForFaqManViewRowImpl faqRowImpl =(EnquiryfaqForFaqManViewRowImpl)enquiryfaqForFaqManView1Iterator.getViewObject().getCurrentRow();
        if (!recordStatus.equals("UPDATE")) {
            ViewObject vo = enquiryfaqForFaqManView1Iterator.getViewObject();
            EnquiryfaqForFaqManViewRowImpl rr = null;
            int i = 0;
            int j = 0;
            boolean flag = false;
            long rowc = vo.getEstimatedRowCount();
            for (int f = 1; f <= rowc; f++) {
                if (i == 0) {
                    rr = (EnquiryfaqForFaqManViewRowImpl)vo.first();
                } else {
                    rr = (EnquiryfaqForFaqManViewRowImpl)vo.next();
                }
                i++;
                flag = false;
                if (rr.getMark() != null) {
                    flag = (Boolean)rr.getMark();
                    if (flag) {
                        rr.setfaqStatus(recordStatus);
                    }
                }
            }
            //faqRowImpl.setfaqStatus(recordStatus);
        } else {
            EnquiryfaqForFaqManViewRowImpl faqRowImpl =
                (EnquiryfaqForFaqManViewRowImpl)enquiryfaqForFaqManView1Iterator.getViewObject().getCurrentRow();
            faqRowImpl.setAbstract11(CommonRHUtil.alignHtml(faqRowImpl.getAbstract11()));
        }
        //    faqRowImpl.setupdatedBy("login username");
        commitAction();

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


    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }


}
