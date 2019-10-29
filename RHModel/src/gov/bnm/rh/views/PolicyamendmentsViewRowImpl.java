package gov.bnm.rh.views;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Mar 21 02:03:38 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicyamendmentsViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AmendmentID {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentID();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentID((String)value);
            }
        },
        AmendmentTitle {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentTitle();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentTitle((String)value);
            }
        },
        AmendmentEffectiveDate {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentEffectiveDate();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentEffectiveDate((String)value);
            }
        },
        AmendmentIssuanceDate {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentIssuanceDate();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentIssuanceDate((Timestamp)value);
            }
        },
        AmendmentHighlights {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentHighlights();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentHighlights((String)value);
            }
        },
        AmendmentAffectedChapters {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getAmendmentAffectedChapters();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setAmendmentAffectedChapters((String)value);
            }
        },
        version {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getversion();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setversion((Integer)value);
            }
        },
        CreatedDate {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        },
        LastUpdated {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getLastUpdated();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setLastUpdated((Timestamp)value);
            }
        },
        amendedById {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getamendedById();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setamendedById((String)value);
            }
        },
        amendedPolicyId {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getamendedPolicyId();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setamendedPolicyId((String)value);
            }
        },
        OriginPolicyId {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getOriginPolicyId();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setOriginPolicyId((String)value);
            }
        },
        ViewPolicyId {
            public Object get(PolicyamendmentsViewRowImpl obj) {
                return obj.getViewPolicyId();
            }

            public void put(PolicyamendmentsViewRowImpl obj, Object value) {
                obj.setViewPolicyId((String)value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicyamendmentsViewRowImpl object);

        public abstract void put(PolicyamendmentsViewRowImpl object,
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


    public static final int AMENDMENTID = AttributesEnum.AmendmentID.index();
    public static final int AMENDMENTTITLE =
        AttributesEnum.AmendmentTitle.index();
    public static final int AMENDMENTEFFECTIVEDATE =
        AttributesEnum.AmendmentEffectiveDate.index();
    public static final int AMENDMENTISSUANCEDATE =
        AttributesEnum.AmendmentIssuanceDate.index();
    public static final int AMENDMENTHIGHLIGHTS =
        AttributesEnum.AmendmentHighlights.index();
    public static final int AMENDMENTAFFECTEDCHAPTERS =
        AttributesEnum.AmendmentAffectedChapters.index();
    public static final int VERSION = AttributesEnum.version.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATED = AttributesEnum.LastUpdated.index();
    public static final int AMENDEDBYID = AttributesEnum.amendedById.index();
    public static final int AMENDEDPOLICYID =
        AttributesEnum.amendedPolicyId.index();
    public static final int ORIGINPOLICYID =
        AttributesEnum.OriginPolicyId.index();
    public static final int VIEWPOLICYID = AttributesEnum.ViewPolicyId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicyamendmentsViewRowImpl() {
    }

    /**
     * Gets Policyamendments entity object.
     * @return the Policyamendments
     */
    public EntityImpl getPolicyamendments() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for AmendmentID using the alias name AmendmentID.
     * @return the AmendmentID
     */
    public String getAmendmentID() {
        return (String)getAttributeInternal(AMENDMENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentID using the alias name AmendmentID.
     * @param value value to set the AmendmentID
     */
    public void setAmendmentID(String value) {
        setAttributeInternal(AMENDMENTID, value);
    }

    /**
     * Gets the attribute value for AmendmentTitle using the alias name AmendmentTitle.
     * @return the AmendmentTitle
     */
    public String getAmendmentTitle() {
        return (String)getAttributeInternal(AMENDMENTTITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentTitle using the alias name AmendmentTitle.
     * @param value value to set the AmendmentTitle
     */
    public void setAmendmentTitle(String value) {
        setAttributeInternal(AMENDMENTTITLE, value);
    }

    /**
     * Gets the attribute value for AmendmentEffectiveDate using the alias name AmendmentEffectiveDate.
     * @return the AmendmentEffectiveDate
     */
    public String getAmendmentEffectiveDate() {
        return (String)getAttributeInternal(AMENDMENTEFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentEffectiveDate using the alias name AmendmentEffectiveDate.
     * @param value value to set the AmendmentEffectiveDate
     */
    public void setAmendmentEffectiveDate(String value) {
        setAttributeInternal(AMENDMENTEFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for AmendmentIssuanceDate using the alias name AmendmentIssuanceDate.
     * @return the AmendmentIssuanceDate
     */
    public Timestamp getAmendmentIssuanceDate() {
        return (Timestamp)getAttributeInternal(AMENDMENTISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentIssuanceDate using the alias name AmendmentIssuanceDate.
     * @param value value to set the AmendmentIssuanceDate
     */
    public void setAmendmentIssuanceDate(Timestamp value) {
        setAttributeInternal(AMENDMENTISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for AmendmentHighlights using the alias name AmendmentHighlights.
     * @return the AmendmentHighlights
     */
    public String getAmendmentHighlights() {
        return (String)getAttributeInternal(AMENDMENTHIGHLIGHTS);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentHighlights using the alias name AmendmentHighlights.
     * @param value value to set the AmendmentHighlights
     */
    public void setAmendmentHighlights(String value) {
        setAttributeInternal(AMENDMENTHIGHLIGHTS, value);
    }

    /**
     * Gets the attribute value for AmendmentAffectedChapters using the alias name AmendmentAffectedChapters.
     * @return the AmendmentAffectedChapters
     */
    public String getAmendmentAffectedChapters() {
        return (String)getAttributeInternal(AMENDMENTAFFECTEDCHAPTERS);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentAffectedChapters using the alias name AmendmentAffectedChapters.
     * @param value value to set the AmendmentAffectedChapters
     */
    public void setAmendmentAffectedChapters(String value) {
        setAttributeInternal(AMENDMENTAFFECTEDCHAPTERS, value);
    }

    /**
     * Gets the attribute value for version using the alias name version.
     * @return the version
     */
    public Integer getversion() {
        return (Integer)getAttributeInternal(VERSION);
    }

    /**
     * Sets <code>value</code> as attribute value for version using the alias name version.
     * @param value value to set the version
     */
    public void setversion(Integer value) {
        setAttributeInternal(VERSION, value);
    }


    /**
     * Gets the attribute value for CreatedDate using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp)getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CreatedDate using the alias name CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdated using the alias name LastUpdated.
     * @return the LastUpdated
     */
    public Timestamp getLastUpdated() {
        return (Timestamp)getAttributeInternal(LASTUPDATED);
    }

    /**
     * Sets <code>value</code> as attribute value for LastUpdated using the alias name LastUpdated.
     * @param value value to set the LastUpdated
     */
    public void setLastUpdated(Timestamp value) {
        setAttributeInternal(LASTUPDATED, value);
    }

    /**
     * Gets the attribute value for amendedById using the alias name amendedById.
     * @return the amendedById
     */
    public String getamendedById() {
        return (String)getAttributeInternal(AMENDEDBYID);
    }

    /**
     * Sets <code>value</code> as attribute value for amendedById using the alias name amendedById.
     * @param value value to set the amendedById
     */
    public void setamendedById(String value) {
        setAttributeInternal(AMENDEDBYID, value);
    }


    /**
     * Gets the attribute value for OriginPolicyId using the alias name OriginPolicyId.
     * @return the OriginPolicyId
     */
    public String getOriginPolicyId() {
        return (String)getAttributeInternal(ORIGINPOLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for OriginPolicyId using the alias name OriginPolicyId.
     * @param value value to set the OriginPolicyId
     */
    public void setOriginPolicyId(String value) {
        setAttributeInternal(ORIGINPOLICYID, value);
    }

    /**
     * Gets the attribute value for ViewPolicyId using the alias name ViewPolicyId.
     * @return the ViewPolicyId
     */
    public String getViewPolicyId() {
        return (String)getAttributeInternal(VIEWPOLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for ViewPolicyId using the alias name ViewPolicyId.
     * @param value value to set the ViewPolicyId
     */
    public void setViewPolicyId(String value) {
        setAttributeInternal(VIEWPOLICYID, value);
    }

    /**
     * Gets the attribute value for amendedPolicyId using the alias name amendedPolicyId.
     * @return the amendedPolicyId
     */
    public String getamendedPolicyId() {
        return (String)getAttributeInternal(AMENDEDPOLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for amendedPolicyId using the alias name amendedPolicyId.
     * @param value value to set the amendedPolicyId
     */
    public void setamendedPolicyId(String value) {
        setAttributeInternal(AMENDEDPOLICYID, value);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].get(this);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}