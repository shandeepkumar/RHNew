package gov.bnm.rh.views;

import java.math.BigDecimal;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 20 10:00:31 SGT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SectorDistinctRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SectorName {
            public Object get(SectorDistinctRowImpl obj) {
                return obj.getSectorName();
            }

            public void put(SectorDistinctRowImpl obj, Object value) {
                obj.setSectorName((String)value);
            }
        }
        ,
        SectorID {
            public Object get(SectorDistinctRowImpl obj) {
                return obj.getSectorID();
            }

            public void put(SectorDistinctRowImpl obj, Object value) {
                obj.setSectorID((BigDecimal)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SectorDistinctRowImpl object);

        public abstract void put(SectorDistinctRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int SECTORNAME = AttributesEnum.SectorName.index();
    public static final int SECTORID = AttributesEnum.SectorID.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SectorDistinctRowImpl() {
    }

    /**
     * Gets Sectors entity object.
     * @return the Sectors
     */
    public EntityImpl getSectors() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for the calculated attribute SectorName.
     * @return the SectorName
     */
    public String getSectorName() {
        return (String) getAttributeInternal(SECTORNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SectorName.
     * @param value value to set the  SectorName
     */
    public void setSectorName(String value) {
        setAttributeInternal(SECTORNAME, value);
    }


    /**
     * Gets the attribute value for the calculated attribute SectorID.
     * @return the SectorID
     */
    public BigDecimal getSectorID() {
        return (BigDecimal) getAttributeInternal(SECTORID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SectorID.
     * @param value value to set the  SectorID
     */
    public void setSectorID(BigDecimal value) {
        setAttributeInternal(SECTORID, value);
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
