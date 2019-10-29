package gov.bnm.rh.views;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 24 08:54:03 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ItemtypelistViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        typeId {
            public Object get(ItemtypelistViewRowImpl obj) {
                return obj.gettypeId();
            }

            public void put(ItemtypelistViewRowImpl obj, Object value) {
                obj.settypeId((String)value);
            }
        },
        Name {
            public Object get(ItemtypelistViewRowImpl obj) {
                return obj.getName();
            }

            public void put(ItemtypelistViewRowImpl obj, Object value) {
                obj.setName((String)value);
            }
        },
        Description {
            public Object get(ItemtypelistViewRowImpl obj) {
                return obj.getDescription();
            }

            public void put(ItemtypelistViewRowImpl obj, Object value) {
                obj.setDescription((String)value);
            }
        },
        itemid {
            public Object get(ItemtypelistViewRowImpl obj) {
                return obj.getitemid();
            }

            public void put(ItemtypelistViewRowImpl obj, Object value) {
                obj.setitemid((String)value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(ItemtypelistViewRowImpl object);

        public abstract void put(ItemtypelistViewRowImpl object, Object value);

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
    public static final int TYPEID = AttributesEnum.typeId.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int ITEMID = AttributesEnum.itemid.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ItemtypelistViewRowImpl() {
    }

    /**
     * Gets Itemtypelist entity object.
     * @return the Itemtypelist
     */
    public EntityImpl getItemtypelist() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for typeId using the alias name typeId.
     * @return the typeId
     */
    public String gettypeId() {
        return (String)getAttributeInternal(TYPEID);
    }

    /**
     * Sets <code>value</code> as attribute value for typeId using the alias name typeId.
     * @param value value to set the typeId
     */
    public void settypeId(String value) {
        setAttributeInternal(TYPEID, value);
    }

    /**
     * Gets the attribute value for Name using the alias name Name.
     * @return the Name
     */
    public String getName() {
        return (String)getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as attribute value for Name using the alias name Name.
     * @param value value to set the Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for Description using the alias name Description.
     * @return the Description
     */
    public String getDescription() {
        return (String)getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for Description using the alias name Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for itemid using the alias name itemid.
     * @return the itemid
     */
    public String getitemid() {
        return (String)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for itemid using the alias name itemid.
     * @param value value to set the itemid
     */
    public void setitemid(String value) {
        setAttributeInternal(ITEMID, value);
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