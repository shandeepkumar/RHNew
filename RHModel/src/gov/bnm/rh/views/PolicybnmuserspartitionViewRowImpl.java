package gov.bnm.rh.views;

import oracle.jbo.Row;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 26 02:13:32 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicybnmuserspartitionViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ID {
            public Object get(PolicybnmuserspartitionViewRowImpl obj) {
                return obj.getID();
            }

            public void put(PolicybnmuserspartitionViewRowImpl obj,
                            Object value) {
                obj.setID((String)value);
            }
        },
        itemId {
            public Object get(PolicybnmuserspartitionViewRowImpl obj) {
                return obj.getitemId();
            }

            public void put(PolicybnmuserspartitionViewRowImpl obj,
                            Object value) {
                obj.setitemId((String)value);
            }
        },
        userName {
            public Object get(PolicybnmuserspartitionViewRowImpl obj) {
                return obj.getuserName();
            }

            public void put(PolicybnmuserspartitionViewRowImpl obj,
                            Object value) {
                obj.setuserName((String)value);
            }
        },
        InternaluserView {
            public Object get(PolicybnmuserspartitionViewRowImpl obj) {
                return obj.getInternaluserView();
            }

            public void put(PolicybnmuserspartitionViewRowImpl obj,
                            Object value) {
                obj.setAttributeInternal(index(), value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicybnmuserspartitionViewRowImpl object);

        public abstract void put(PolicybnmuserspartitionViewRowImpl object,
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


    public static final int ID = AttributesEnum.ID.index();
    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int USERNAME = AttributesEnum.userName.index();
    public static final int INTERNALUSERVIEW =
        AttributesEnum.InternaluserView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicybnmuserspartitionViewRowImpl() {
    }

    /**
     * Gets Policybnmuserspartition entity object.
     * @return the Policybnmuserspartition
     */
    public EntityImpl getPolicybnmuserspartition() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for ID using the alias name ID.
     * @return the ID
     */
    public String getID() {
        return (String)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name ID.
     * @param value value to set the ID
     */
    public void setID(String value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for itemId using the alias name itemId.
     * @return the itemId
     */
    public String getitemId() {
        return (String)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for itemId using the alias name itemId.
     * @param value value to set the itemId
     */
    public void setitemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute userName.
     * @return the userName
     */
    public String getuserName() {
        return (String)getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute userName.
     * @param value value to set the  userName
     */
    public void setuserName(String value) {
        setAttributeInternal(USERNAME, value);
    }


    /**
     * Gets the associated <code>Row</code> using master-detail link InternaluserView.
     */
    public Row getInternaluserView() {
        return (Row)getAttributeInternal(INTERNALUSERVIEW);
    }

    /**
     * Sets the master-detail link InternaluserView between this object and <code>value</code>.
     */
    public void setInternaluserView(Row value) {
        setAttributeInternal(INTERNALUSERVIEW, value);
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
