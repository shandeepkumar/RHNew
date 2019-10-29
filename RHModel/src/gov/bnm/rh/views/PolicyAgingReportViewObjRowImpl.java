package gov.bnm.rh.views;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri May 09 03:58:43 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicyAgingReportViewObjRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        itemId {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getitemId();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setitemId((String)value);
            }
        }
        ,
        RefNum {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getRefNum();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setRefNum((String)value);
            }
        }
        ,
        GuidelineTitle {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getGuidelineTitle();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setGuidelineTitle((String)value);
            }
        }
        ,
        NewIssuanceDate {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getNewIssuanceDate();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setNewIssuanceDate((Timestamp)value);
            }
        }
        ,
        monthDiff {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getmonthDiff();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setmonthDiff((Integer)value);
            }
        }
        ,
        DueInYear {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getDueInYear();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setDueInYear((Integer)value);
            }
        }
        ,
        DueInMonth {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getDueInMonth();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setDueInMonth((Integer)value);
            }
        }
        ,
        ageYear {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getageYear();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setageYear((Integer)value);
            }
        }
        ,
        ageMonth {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getageMonth();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setageMonth((Integer)value);
            }
        }
        ,
        daysDiff {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getdaysDiff();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setdaysDiff((Integer)value);
            }
        }
        ,
        FirstIssuanceDate {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getFirstIssuanceDate();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setFirstIssuanceDate((Timestamp)value);
            }
        }
        ,
        EffectiveDate {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getEffectiveDate();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setEffectiveDate((String)value);
            }
        }
        ,
        Sectors {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getSectors();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setSectors((String)value);
            }
        }
        ,
        CategoryName {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getCategoryName();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setCategoryName((String)value);
            }
        }
        ,
        DepartName {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getDepartName();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setDepartName((String)value);
            }
        }
        ,
        DocType {
            public Object get(PolicyAgingReportViewObjRowImpl obj) {
                return obj.getDocType();
            }

            public void put(PolicyAgingReportViewObjRowImpl obj,
                            Object value) {
                obj.setDocType((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicyAgingReportViewObjRowImpl object);

        public abstract void put(PolicyAgingReportViewObjRowImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int REFNUM = AttributesEnum.RefNum.index();
    public static final int GUIDELINETITLE = AttributesEnum.GuidelineTitle.index();
    public static final int NEWISSUANCEDATE = AttributesEnum.NewIssuanceDate.index();
    public static final int MONTHDIFF = AttributesEnum.monthDiff.index();
    public static final int DUEINYEAR = AttributesEnum.DueInYear.index();
    public static final int DUEINMONTH = AttributesEnum.DueInMonth.index();
    public static final int AGEYEAR = AttributesEnum.ageYear.index();
    public static final int AGEMONTH = AttributesEnum.ageMonth.index();
    public static final int DAYSDIFF = AttributesEnum.daysDiff.index();
    public static final int FIRSTISSUANCEDATE = AttributesEnum.FirstIssuanceDate.index();
    public static final int EFFECTIVEDATE = AttributesEnum.EffectiveDate.index();
    public static final int SECTORS = AttributesEnum.Sectors.index();
    public static final int CATEGORYNAME = AttributesEnum.CategoryName.index();
    public static final int DEPARTNAME = AttributesEnum.DepartName.index();
    public static final int DOCTYPE = AttributesEnum.DocType.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicyAgingReportViewObjRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute itemId.
     * @return the itemId
     */
    public String getitemId() {
        return (String)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute itemId.
     * @param value value to set the  itemId
     */
    public void setitemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RefNum.
     * @return the RefNum
     */
    public String getRefNum() {
        return (String)getAttributeInternal(REFNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RefNum.
     * @param value value to set the  RefNum
     */
    public void setRefNum(String value) {
        setAttributeInternal(REFNUM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute GuidelineTitle.
     * @return the GuidelineTitle
     */
    public String getGuidelineTitle() {
        return (String)getAttributeInternal(GUIDELINETITLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute GuidelineTitle.
     * @param value value to set the  GuidelineTitle
     */
    public void setGuidelineTitle(String value) {
        setAttributeInternal(GUIDELINETITLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute NewIssuanceDate.
     * @return the NewIssuanceDate
     */
    public Timestamp getNewIssuanceDate() {
        return (Timestamp)getAttributeInternal(NEWISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute NewIssuanceDate.
     * @param value value to set the  NewIssuanceDate
     */
    public void setNewIssuanceDate(Timestamp value) {
        setAttributeInternal(NEWISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute monthDiff.
     * @return the monthDiff
     */
    public Integer getmonthDiff() {
        return (Integer)getAttributeInternal(MONTHDIFF);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute monthDiff.
     * @param value value to set the  monthDiff
     */
    public void setmonthDiff(Integer value) {
        setAttributeInternal(MONTHDIFF, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DueInYear.
     * @return the DueInYear
     */
    public Integer getDueInYear() {
        return (Integer)getAttributeInternal(DUEINYEAR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DueInYear.
     * @param value value to set the  DueInYear
     */
    public void setDueInYear(Integer value) {
        setAttributeInternal(DUEINYEAR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DueInMonth.
     * @return the DueInMonth
     */
    public Integer getDueInMonth() {
        return (Integer)getAttributeInternal(DUEINMONTH);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DueInMonth.
     * @param value value to set the  DueInMonth
     */
    public void setDueInMonth(Integer value) {
        setAttributeInternal(DUEINMONTH, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ageYear.
     * @return the ageYear
     */
    public Integer getageYear() {
        return (Integer)getAttributeInternal(AGEYEAR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ageYear.
     * @param value value to set the  ageYear
     */
    public void setageYear(Integer value) {
        setAttributeInternal(AGEYEAR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ageMonth.
     * @return the ageMonth
     */
    public Integer getageMonth() {
        return (Integer)getAttributeInternal(AGEMONTH);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ageMonth.
     * @param value value to set the  ageMonth
     */
    public void setageMonth(Integer value) {
        setAttributeInternal(AGEMONTH, value);
    }

    /**
     * Gets the attribute value for the calculated attribute daysDiff.
     * @return the daysDiff
     */
    public Integer getdaysDiff() {
        return (Integer)getAttributeInternal(DAYSDIFF);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute daysDiff.
     * @param value value to set the  daysDiff
     */
    public void setdaysDiff(Integer value) {
        setAttributeInternal(DAYSDIFF, value);
    }

    /**
     * Gets the attribute value for the calculated attribute FirstIssuanceDate.
     * @return the FirstIssuanceDate
     */
    public Timestamp getFirstIssuanceDate() {
        return (Timestamp)getAttributeInternal(FIRSTISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute FirstIssuanceDate.
     * @param value value to set the  FirstIssuanceDate
     */
    public void setFirstIssuanceDate(Timestamp value) {
        setAttributeInternal(FIRSTISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EffectiveDate.
     * @return the EffectiveDate
     */
    public String getEffectiveDate() {
        return (String)getAttributeInternal(EFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EffectiveDate.
     * @param value value to set the  EffectiveDate
     */
    public void setEffectiveDate(String value) {
        setAttributeInternal(EFFECTIVEDATE, value);
    }


    /**
     * Gets the attribute value for the calculated attribute Sectors.
     * @return the Sectors
     */
    public String getSectors() {
        return (String) getAttributeInternal(SECTORS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Sectors.
     * @param value value to set the  Sectors
     */
    public void setSectors(String value) {
        setAttributeInternal(SECTORS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CategoryName.
     * @return the CategoryName
     */
    public String getCategoryName() {
        return (String) getAttributeInternal(CATEGORYNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CategoryName.
     * @param value value to set the  CategoryName
     */
    public void setCategoryName(String value) {
        setAttributeInternal(CATEGORYNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DepartName.
     * @return the DepartName
     */
    public String getDepartName() {
        return (String) getAttributeInternal(DEPARTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DepartName.
     * @param value value to set the  DepartName
     */
    public void setDepartName(String value) {
        setAttributeInternal(DEPARTNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DocType.
     * @return the DocType
     */
    public String getDocType() {
        return (String) getAttributeInternal(DOCTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DocType.
     * @param value value to set the  DocType
     */
    public void setDocType(String value) {
        setAttributeInternal(DOCTYPE, value);
    }


    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
