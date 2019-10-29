package gov.bnm.view.rh.common;

import gov.bnm.rh.views.PolicyIssuringDepartPartitionViewRowImpl;
import gov.bnm.rh.views.PolicyRelavantActPartitionViewRowImpl;
import gov.bnm.rh.views.PolicybnmuserspartitionViewRowImpl;
import gov.bnm.rh.views.Policybusinesssectorpartition1ViewRowImpl;
import gov.bnm.rh.views.PolicycategoriespartitionViewRowImpl;
import gov.bnm.rh.views.PolicydepartmentpartitionViewRowImpl;
import gov.bnm.rh.views.PolicyinstitutiontypepartitionViewRowImpl;
import gov.bnm.rh.views.PolicyorganizationpartitionViewRowImpl;
import gov.bnm.rh.views.PolicysectorcategoryViewRowImpl;
import gov.bnm.rh.views.SuperseededpoliciesViewRowImpl;
import gov.bnm.view.rh.backingBeans.PolicyPublishing;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;


import gov.bnm.view.rh.utils.DateUtils;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class ShuttleInfo implements IShuttleInfo {
    
    static Logger log = Logger.getLogger(ShuttleInfo.class);

    public String addDepPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT1().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding depIteratorBind =
            ADFUtils.findIterator("DepartmentView1Iterator1");
        RowSetIterator rsiSelectedRows = depIteratorBind.getRowSetIterator();
        DCIteratorBinding polDepIteratorBindings =
            ADFUtils.findIterator("PolicydepartmentpartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polDepIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("departmentId")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("ID"));
            if (!polDepList.contains(id)) {
                PolicydepartmentpartitionViewRowImpl polDepImpl =
                    (PolicydepartmentpartitionViewRowImpl)polDepIteratorBindings.getViewObject().createRow();
                polDepImpl.setdepartmentId(id);
                polDepImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeDepPolInfo(IShuttleBean depPolBean) {
        RowKeySet rowKeySet = depPolBean.getT2().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)depPolBean.getT2().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addAuthPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT3().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding authIteratorBind =
            ADFUtils.findIterator("InternaluserView1Iterator");
        RowSetIterator rsiSelectedRows = authIteratorBind.getRowSetIterator();
        DCIteratorBinding polAuthIteratorBindings =
            ADFUtils.findIterator("PolicybnmuserspartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));

        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polAuthIteratorBindings.getAllRowsInRange();
        log.info("existingRow" + existingRow);
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("ID")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("ID"));
            if (!polDepList.contains(id)) {
                PolicybnmuserspartitionViewRowImpl polCatImpl =
                    (PolicybnmuserspartitionViewRowImpl)polAuthIteratorBindings.getViewObject().createRow();
                polCatImpl.setID(id);
                polCatImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeAuthPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rowKeySet = shuttleBean.getT4().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)shuttleBean.getT4().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addSecPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT5().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding secIteratorBind =
            ADFUtils.findIterator("SectorsView1Iterator");
        RowSetIterator rsiSelectedRows = secIteratorBind.getRowSetIterator();
        DCIteratorBinding polSecIteratorBindings =
            ADFUtils.findIterator("Policybusinesssectorpartition1View1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));

        List<BigDecimal> polDepList = new ArrayList<BigDecimal>();
        Row[] existingRow = polSecIteratorBindings.getAllRowsInRange();
        log.info("existingRow" + existingRow);
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getBigDecimal(row.getAttribute("ID")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            BigDecimal id =
                BaseUtil.getBigDecimal(myRow.getAttribute("SectorID"));
            if (!polDepList.contains(id)) {
                Policybusinesssectorpartition1ViewRowImpl polCatImpl =
                    (Policybusinesssectorpartition1ViewRowImpl)polSecIteratorBindings.getViewObject().createRow();
                polCatImpl.setID(id);
                polCatImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeSecPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rowKeySet = shuttleBean.getT6().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)shuttleBean.getT6().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addInstPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT7().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding instIteratorBind =
            ADFUtils.findIterator("InstitutiontypeView1Iterator");
        RowSetIterator rsiSelectedRows = instIteratorBind.getRowSetIterator();
        DCIteratorBinding polInstIteratorBindings =
            ADFUtils.findIterator("PolicyinstitutiontypepartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polInstIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("id")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("id"));
            if (!polDepList.contains(id)) {
                PolicyinstitutiontypepartitionViewRowImpl polInstImpl =
                    (PolicyinstitutiontypepartitionViewRowImpl)polInstIteratorBindings.getViewObject().createRow();
                polInstImpl.setid(id);
                polInstImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeInstPolInfo(IShuttleBean depPolBean) {
        RowKeySet rowKeySet = depPolBean.getT8().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)depPolBean.getT8().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addOrgPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT9().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding orgIteratorBind =
            ADFUtils.findIterator("OrganizationView1Iterator");
        RowSetIterator rsiSelectedRows = orgIteratorBind.getRowSetIterator();
        DCIteratorBinding polOrgIteratorBindings =
            ADFUtils.findIterator("PolicyorganizationpartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polOrgIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("id")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("id"));
            if (!polDepList.contains(id)) {
                PolicyorganizationpartitionViewRowImpl polOrgImpl =
                    (PolicyorganizationpartitionViewRowImpl)polOrgIteratorBindings.getViewObject().createRow();
                polOrgImpl.setid(id);
                polOrgImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeOrgPolInfo(IShuttleBean depPolBean) {
        RowKeySet rowKeySet = depPolBean.getT10().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)depPolBean.getT10().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addSusPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rksSelectedRows = shuttleBean.getT11().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding susIteratorBind =
            ADFUtils.findIterator("PolicyArchiveOnly1Iterator");
        RowSetIterator rsiSelectedRows = susIteratorBind.getRowSetIterator();
        DCIteratorBinding polSusIteratorBindings =
            ADFUtils.findIterator("SuperseededpoliciesView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polSusIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("itemIdSup")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("itemId"));
            if (!polDepList.contains(id)) {
                SuperseededpoliciesViewRowImpl polOrgImpl =
                    (SuperseededpoliciesViewRowImpl)polSusIteratorBindings.getViewObject().createRow();
                polOrgImpl.setitemIdSup(id);
                polOrgImpl.setitemIdNew(itemid);
            }
        }
        return null;
    }

    public String removeSusPolInfo(IShuttleBean depPolBean) {
        RowKeySet rowKeySet = depPolBean.getT12().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)depPolBean.getT12().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    public String addCatPolInfo(IShuttleBean shuttleBean) {
        
        RowKeySet rksSelectedRows = shuttleBean.getT13().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding catIteratorBind =
            ADFUtils.findIterator("CategoriesView1Iterator");
        RowSetIterator rsiSelectedRows = catIteratorBind.getRowSetIterator();
        DCIteratorBinding polCatIteratorBindings =
            ADFUtils.findIterator("PolicycategoriespartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));

        List<BigDecimal> polDepList = new ArrayList<BigDecimal>();
        Row[] existingRow = polCatIteratorBindings.getAllRowsInRange();
        log.info("existingRow" + existingRow);
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getBigDecimal(row.getAttribute("CategoryID")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            BigDecimal id =
                BaseUtil.getBigDecimal(myRow.getAttribute("CategoryID"));
            if (!polDepList.contains(id)) {
                PolicycategoriespartitionViewRowImpl polCatImpl =
                    (PolicycategoriespartitionViewRowImpl)polCatIteratorBindings.getViewObject().createRow();
                polCatImpl.setCategoryID(id);
                polCatImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeCatPolInfo(IShuttleBean shuttleBean) {
        RowKeySet rowKeySet = shuttleBean.getT14().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)shuttleBean.getT14().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }

    // Relavant Act Start
    public String addRelavantActInfo(IShuttleBean shuttleBean) {
        
        RowKeySet rksSelectedRows = shuttleBean.getT15().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding depIteratorBind =
            ADFUtils.findIterator("RelavantActView1Iterator");
        RowSetIterator rsiSelectedRows = depIteratorBind.getRowSetIterator();
        DCIteratorBinding polDepIteratorBindings =
            ADFUtils.findIterator("PolicyRelavantActPartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polDepIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("relavantId")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("id"));
            if (!polDepList.contains(id)) {
                PolicyRelavantActPartitionViewRowImpl polDepImpl =
                    (PolicyRelavantActPartitionViewRowImpl)polDepIteratorBindings.getViewObject().createRow();
                polDepImpl.setrelavantId(id);
                polDepImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeRelavantActInfo(IShuttleBean shuttleBean) {
        
        RowKeySet rowKeySet = shuttleBean.getT3().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)shuttleBean.getT3().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData =
                (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }
    // Relavant Act End

    // Issuring Department Start
    public String addIssuringDepartmentInfo(ShuttleBean shuttleBean) {
        
        RowKeySet rksSelectedRows = shuttleBean.getT4().getSelectedRowKeys();
        Iterator itrSelectedRows = rksSelectedRows.iterator();
        DCIteratorBinding depIteratorBind = ADFUtils.findIterator("IssuringDepartmentView1Iterator");
        RowSetIterator rsiSelectedRows = depIteratorBind.getRowSetIterator();
        DCIteratorBinding polDepIteratorBindings =
            ADFUtils.findIterator("PolicyIssuringDepartPartitionView1Iterator");
        DCIteratorBinding itemIteratorBind =
            ADFUtils.findIterator("ItemlistView1Iterator1");
        Row itemRow = itemIteratorBind.getCurrentRow();
        String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
        log.info("itemid" + itemid);
        List<String> polDepList = new ArrayList<String>();
        Row[] existingRow = polDepIteratorBindings.getAllRowsInRange();
        for (int i = 0; i < existingRow.length; i++) {
            Row row = existingRow[i];
            polDepList.add(BaseUtil.getStr(row.getAttribute("issuringDepartId")));
        }
        while (itrSelectedRows.hasNext()) {
            Key key = (Key)((List)itrSelectedRows.next()).get(0);
            log.info("key" + key);
            Row myRow = rsiSelectedRows.getRow(key);
            String id = BaseUtil.getStr(myRow.getAttribute("id"));
            if (!polDepList.contains(id)) {
                PolicyIssuringDepartPartitionViewRowImpl polDepImpl = (PolicyIssuringDepartPartitionViewRowImpl)polDepIteratorBindings.getViewObject().createRow();
                polDepImpl.setissuringDepartId(id);
                polDepImpl.setitemId(itemid);
            }
        }
        return null;
    }

    public String removeIssuringDepartmentInfo(ShuttleBean depPolBean) {
        
        RowKeySet rowKeySet = depPolBean.getT13().getSelectedRowKeys();
        CollectionModel cm = (CollectionModel)depPolBean.getT13().getValue();
        for (Object facesTreeRow : rowKeySet) {
            cm.setRowKey(facesTreeRow);
            JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)cm.getRowData();
            if (rowData != null)
                rowData.getRow().remove();
        }
        return null;
    }
    // Issuring Department End
}
