package gov.bnm.view.rh.backingBeans;

import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.BaseUtil;

import gov.bnm.view.rh.utils.JSFUtils;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.component.UIXIterator;

public class WhatsNewPolicyListingPage {
    static Logger log = Logger.getLogger(WhatsNewPolicyListingPage.class);

    RHSession rhSession =
        (RHSession)JSFUtils.resolveExpression("#{rhSession}");
    private RichPanelBox pb1;
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichTable t1;
    private UIXIterator policyTableIterator;
    private int paging = Integer.parseInt(rhSession.getPolicyListingRecord());
    private int recordFrom;
    private int recordTo;
    private int totalRows;
    private int totalPages;

    public void firstActionListener(ActionEvent actionEvent) {
        this.getPolicyTableIterator().setFirst(0);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("currentRowNumber",
                                                                    0);
    }

    public void previousActionListener(ActionEvent actionEvent) {
        int rowCount = this.getPolicyTableIterator().getFirst() - paging;
        this.getPolicyTableIterator().setFirst(rowCount);
        log.info("rowCount::" + rowCount);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("currentRowNumber",
                                                                    rowCount);
    }

    public void nextActionListener(ActionEvent actionEvent) {
        int rowCount = this.getPolicyTableIterator().getFirst() + paging;
        this.getPolicyTableIterator().setFirst(rowCount);
        log.info("rowCount::" + rowCount);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("currentRowNumber",
                                                                    rowCount);
    }

    public void lastActionListener(ActionEvent actionEvent) {
        int rowFactor = this.getPolicyTableIterator().getRowCount() / paging;
        int rowCount = rowFactor * paging;
        if (rowCount == this.getPolicyTableIterator().getRowCount()) {
            rowCount -= paging;
        }
        this.getPolicyTableIterator().setFirst(rowCount);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("currentRowNumber",
                                                                    rowCount);
    }

    public boolean isBeforeDisabled() {
        return this.getPolicyTableIterator().getFirst() == 0;
    }

    public boolean isAfterDisabled() {
        return this.getPolicyTableIterator().getFirst() >=
            this.getPolicyTableIterator().getRowCount() - paging;
    }

    public int getCurrentPageNumber() {
        int currentRow = this.getPolicyTableIterator().getFirst();
        this.setRecordFrom(currentRow + 1);
        this.getToRecordCal(currentRow);

        int currentPageNumber = (currentRow / paging) + 1;
        return currentPageNumber;
    }

    public void getToRecordCal(int fromRecord) {
        int rowCount = fromRecord + paging;
        this.setTotalRows(this.getPolicyTableIterator().getRowCount());
        this.setTotalPages((this.getTotalRows() / paging) + 1);
        if (rowCount > this.getTotalRows()) {
            rowCount = this.getTotalRows();
        }
        this.setRecordTo(rowCount);
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
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

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setPolicyTableIterator(UIXIterator policyTableIterator) {
        this.policyTableIterator = policyTableIterator;
    }

    public UIXIterator getPolicyTableIterator() {
        int currentRowNumber =
            BaseUtil.getInt(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("currentRowNumber"));

        if (currentRowNumber != 0 && policyTableIterator != null) {
            if (policyTableIterator.getFirst() != currentRowNumber) {
                policyTableIterator.setFirst(currentRowNumber);
            }
        }
        return policyTableIterator;
    }

    public void setRecordFrom(int recordFrom) {
        this.recordFrom = recordFrom;
    }

    public int getRecordFrom() {
        return recordFrom;
    }

    public void setRecordTo(int recordTo) {
        this.recordTo = recordTo;
    }

    public int getRecordTo() {
        return recordTo;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
