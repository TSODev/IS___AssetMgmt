package fr.tsodev.bundle.Utils.DataRX;

import com.bmc.arsys.rx.services.record.domain.FieldInstance;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thierry on 23/03/2017.
 */
public class ProductCatalogRecordInstance  extends RecordInstance {
    public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String JSON_TIME_FORMAT = "HH:mm:ss";
    public static final String JSON_DATE_FORMAT = "yyyy-MM-dd";
    public static final String AR_TIME_FORMAT = "hh:mm:ss a";
    public static final String JSON_IF_UNMODIFIED_SINCE_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";


    public static final String name = "fr.tsodev.assetmgmt:Product%20Catalog";
    public static final String bundlename = "fr.tsodev.assetmgmt";

    public ProductCatalogRecordInstance() {
        this.setRecordDefinitionName(name);
    }

    public ProductCatalogRecordInstance(RecordInstance recordInstance) {
        super(recordInstance);
        this.setRecordDefinitionName(name);
    }

    public RecordInstance getRecordInstance() {
        RecordInstance recordInstance = new RecordInstance(this);
        return recordInstance;
    }

    public static int Display_ID = 1;
    public void setDisplay_ID(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Display_ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDisplay_ID(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Display_ID) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Display_ID).getValue();
    }


    public static int Created_By = 2;
    public void setCreated_By(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Created_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getCreated_By(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Created_By) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Created_By).getValue();
    }


    public static int Created_Date = 3;
    public void setCreated_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Created_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getCreated_Date() throws ParseException {

        if(this.getFieldInstance(ProductCatalogRecordInstance.Created_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(ProductCatalogRecordInstance.Created_Date).getValue());
        return date;
    }


    public static int Assignee = 4;
    public void setAssignee(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Assignee,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getAssignee(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Assignee) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Assignee).getValue();
    }


    public static int Modified_By = 5;
    public void setModified_By(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Modified_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getModified_By(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Modified_By) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Modified_By).getValue();
    }


    public static int Modified_Date = 6;
    public void setModified_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Modified_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getModified_Date() throws ParseException{

        if(this.getFieldInstance(ProductCatalogRecordInstance.Modified_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(ProductCatalogRecordInstance.Modified_Date).getValue());
        return date;
    }


    public static int Status = 7;

    public static enum StatusOption {
        Proposed (0),
        Enabled (10),
        Offline (20),
        Obsolete (30),
        Archive (40),
        Delete (50);


        int id;

        StatusOption(int id){
            this.id = id;
        }

        public int getValue(){
            return id;
        }
        public static StatusOption convertFromInt(int id){
            StatusOption[] options = StatusOption.values();
            for(int i = 0; i < options.length; i++)
            {				if(options[i].getValue() == id)
                return options[i];
            }
            return null;
        }
    }

    public void setStatus(StatusOption value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Status,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public StatusOption getStatus(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Status) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(ProductCatalogRecordInstance.Status).getValue());

        return StatusOption.convertFromInt(id);
    }

    public static int Description = 8;
    public void setDescription(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Description,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDescription(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Description) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Description).getValue();
    }


    public static int Notifier_Listening = 16;

    public static enum Notifier_ListeningOption {
        Not_Listening (0),
        Listening (1);


        int id;

        Notifier_ListeningOption(int id){
            this.id = id;
        }

        public int getValue(){
            return id;
        }
        public static Notifier_ListeningOption convertFromInt(int id){
            Notifier_ListeningOption[] options = Notifier_ListeningOption.values();
            for(int i = 0; i < options.length; i++)
            {				if(options[i].getValue() == id)
                return options[i];
            }
            return null;
        }
    }

    public void setNotifier_Listening(Notifier_ListeningOption value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Notifier_Listening,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public Notifier_ListeningOption getNotifier_Listening(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Notifier_Listening) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(ProductCatalogRecordInstance.Notifier_Listening).getValue());

        return Notifier_ListeningOption.convertFromInt(id);
    }

    public static int GUID = 179;
    public void setGUID(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.GUID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getGUID(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.GUID) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.GUID).getValue();
    }


    public static int ID = 379;
    public void setID(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getID(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.ID) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.ID).getValue();
    }

    public static int ExternalInstanceId = 536870913;
    public void setExternalInstanceId(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.ExternalInstanceId, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getExternalInstanceId() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.ExternalInstanceId) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.ExternalInstanceId).getValue();
    }

    public static int Product_Categorization_1 = 536870914;
    public void setProduct_Categorization_1(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Product_Categorization_1, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getProduct_Categorization_1() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_1) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_1).getValue();
    }
    public static int Product_Categorization_2 = 536870915;
    public void setProduct_Categorization_2(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Product_Categorization_2, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getProduct_Categorization_2() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_2) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_2).getValue();
    }

    public static int Product_Categorization_3 = 536870916;
    public void setProduct_Categorization_3(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Product_Categorization_3, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getProduct_Categorization_3() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_3) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Product_Categorization_3).getValue();
    }

    public static int Product_name = 536870918;
    public void setProduct_name(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Product_name, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getProduct_name() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Product_name) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Product_name).getValue();
    }

    public static int Categorization_Schema = 536870917;
    public void setCategorization_Schema(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Categorization_Schema, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getCategorization_Schema() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Categorization_Schema) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Categorization_Schema).getValue();
    }

    public static int Manufacturer = 536870919;
    public void setManufacturer(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Manufacturer, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getManufacturer() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Manufacturer) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Manufacturer).getValue();
    }

    public static int Asset_Class = 536870920;

    public static enum Asset_ClassOption {
        Hardware (0),
        Software (10),
        Service (20);


        int id;

        Asset_ClassOption(int id){
            this.id = id;
        }

        public int getValue(){
            return id;
        }
        public static Asset_ClassOption convertFromInt(int id){
            Asset_ClassOption[] options = Asset_ClassOption.values();
            for(int i = 0; i < options.length; i++)
            {				if(options[i].getValue() == id)
                return options[i];
            }
            return null;
        }
    }

    public void setAssetClass(Asset_ClassOption value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Status,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public Asset_ClassOption getAssetClass(){

        if(this.getFieldInstance(ProductCatalogRecordInstance.Asset_Class) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(ProductCatalogRecordInstance.Asset_Class).getValue());

        return Asset_ClassOption.convertFromInt(id);
    }
    
    
    public static int Origin = 536870921;

    public static enum OriginOption {
        Custom (0),
        Third_Party (10);


        int id;

        OriginOption(int id){
            this.id = id;
        }

        public int getValue(){
            return id;
        }
        public static OriginOption convertFromInt(int id){
            OriginOption[] options = OriginOption.values();
            for(int i = 0; i < options.length; i++)
            {				if(options[i].getValue() == id)
                return options[i];
            }
            return null;
        }
    }

    public static int Vendor_Name = 536870922;
    public void setVendor_Name(String value){
        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Vendor_Name, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getVendor_Name() {
        if(this.getFieldInstance(ProductCatalogRecordInstance.Vendor_Name) == null){
            return null;
        }
        return this.getFieldInstance(ProductCatalogRecordInstance.Vendor_Name).getValue();
    }

//    public static int Per_Unit_Quantity = 536870923;
//    public void setPer_Unit_Quantity(Integer value){
//        FieldInstance fieldInstance = new FieldInstance(ProductCatalogRecordInstance.Per_Unit_Quantity, value);
//        this.putFieldInstance(fieldInstance);
//    }
//
//    public Integer getPer_Unit_Quantity() {
//        if(this.getFieldInstance(ProductCatalogRecordInstance.Per_Unit_Quantity) == null){
//            return null;
//        }
//        return this.getFieldInstance(ProductCatalogRecordInstance.Per_Unit_Quantity).getValue();
//    }
//    

    public String createProductCatalogRecordInstance(String InstanceId){
        this.setExternalInstanceId(InstanceId);
        this.setDescription("Added by Service");
        this.setStatus(StatusOption.Enabled);

        return this.getGUID();

    }
}
