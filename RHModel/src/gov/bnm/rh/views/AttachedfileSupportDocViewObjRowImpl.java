package gov.bnm.rh.views;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 09 03:48:01 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AttachedfileSupportDocViewObjRowImpl extends ViewRowImpl {


    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        fileId,
        filePath,
        filenameOrig,
        filenameStore,
        itemId,
        type,
        documentName,
        isRequiredAccess,
        isSupportDocument,
        orderDate;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

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


    public static final int FILEID = AttributesEnum.fileId.index();
    public static final int FILEPATH = AttributesEnum.filePath.index();
    public static final int FILENAMEORIG = AttributesEnum.filenameOrig.index();
    public static final int FILENAMESTORE = AttributesEnum.filenameStore.index();
    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int TYPE = AttributesEnum.type.index();
    public static final int DOCUMENTNAME = AttributesEnum.documentName.index();
    public static final int ISREQUIREDACCESS = AttributesEnum.isRequiredAccess.index();
    public static final int ISSUPPORTDOCUMENT = AttributesEnum.isSupportDocument.index();
    public static final int ORDERDATE = AttributesEnum.orderDate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public AttachedfileSupportDocViewObjRowImpl() {
    }

    /**
     * Gets Attachedfile2 entity object.
     * @return the Attachedfile2
     */
    public EntityImpl getAttachedfile2() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for documentName using the alias name documentName.
     * @return the documentName
     */
    public String getdocumentName() {
        return (String)getAttributeInternal(DOCUMENTNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for documentName using the alias name documentName.
     * @param value value to set the documentName
     */
    public void setdocumentName(String value) {
        setAttributeInternal(DOCUMENTNAME, value);
    }

    /**
     * Gets the attribute value for fileId using the alias name fileId.
     * @return the fileId
     */
    public String getfileId() {
        return (String)getAttributeInternal(FILEID);
    }

    /**
     * Sets <code>value</code> as attribute value for fileId using the alias name fileId.
     * @param value value to set the fileId
     */
    public void setfileId(String value) {
        setAttributeInternal(FILEID, value);
    }

    /**
     * Gets the attribute value for filePath using the alias name filePath.
     * @return the filePath
     */
    public String getfilePath() {
        return (String)getAttributeInternal(FILEPATH);
    }

    /**
     * Sets <code>value</code> as attribute value for filePath using the alias name filePath.
     * @param value value to set the filePath
     */
    public void setfilePath(String value) {
        setAttributeInternal(FILEPATH, value);
    }

    /**
     * Gets the attribute value for filenameOrig using the alias name filenameOrig.
     * @return the filenameOrig
     */
    public String getfilenameOrig() {
        return (String)getAttributeInternal(FILENAMEORIG);
    }

    /**
     * Sets <code>value</code> as attribute value for filenameOrig using the alias name filenameOrig.
     * @param value value to set the filenameOrig
     */
    public void setfilenameOrig(String value) {
        setAttributeInternal(FILENAMEORIG, value);
    }

    /**
     * Gets the attribute value for filenameStore using the alias name filenameStore.
     * @return the filenameStore
     */
    public String getfilenameStore() {
        return (String)getAttributeInternal(FILENAMESTORE);
    }

    /**
     * Sets <code>value</code> as attribute value for filenameStore using the alias name filenameStore.
     * @param value value to set the filenameStore
     */
    public void setfilenameStore(String value) {
        setAttributeInternal(FILENAMESTORE, value);
    }

    /**
     * Gets the attribute value for isRequiredAccess using the alias name isRequiredAccess.
     * @return the isRequiredAccess
     */
    public Boolean getisRequiredAccess() {
        return (Boolean)getAttributeInternal(ISREQUIREDACCESS);
    }

    /**
     * Sets <code>value</code> as attribute value for isRequiredAccess using the alias name isRequiredAccess.
     * @param value value to set the isRequiredAccess
     */
    public void setisRequiredAccess(Boolean value) {
        setAttributeInternal(ISREQUIREDACCESS, value);
    }

    /**
     * Gets the attribute value for isSupportDocument using the alias name isSupportDocument.
     * @return the isSupportDocument
     */
    public Boolean getisSupportDocument() {
        return (Boolean)getAttributeInternal(ISSUPPORTDOCUMENT);
    }

    /**
     * Sets <code>value</code> as attribute value for isSupportDocument using the alias name isSupportDocument.
     * @param value value to set the isSupportDocument
     */
    public void setisSupportDocument(Boolean value) {
        setAttributeInternal(ISSUPPORTDOCUMENT, value);
    }


  /**
   * Gets the attribute value for the calculated attribute orderDate.
   * @return the orderDate
   */
  public Timestamp getorderDate() {
    return (Timestamp) getAttributeInternal(ORDERDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute orderDate.
   * @param value value to set the  orderDate
   */
  public void setorderDate(Timestamp value) {
    setAttributeInternal(ORDERDATE, value);
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
     * Gets the attribute value for type using the alias name type.
     * @return the type
     */
    public String gettype() {
        return (String)getAttributeInternal(TYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for type using the alias name type.
     * @param value value to set the type
     */
    public void settype(String value) {
        setAttributeInternal(TYPE, value);
    }


}