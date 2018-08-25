package fr.tsodev.bundle.Utils.DataRX;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bmc.arsys.rx.services.record.domain.FieldInstance;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;


public class AssetRecordInstance extends RecordInstance {

	
    public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String JSON_TIME_FORMAT = "HH:mm:ss";
    public static final String JSON_DATE_FORMAT = "yyyy-MM-dd";
    public static final String AR_TIME_FORMAT = "hh:mm:ss a";
    public static final String JSON_IF_UNMODIFIED_SINCE_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";


    public static final String name = "fr.tsodev.assetmgmt:Asset";
    public static final String bundlename = "fr.tsodev.assetmgmt";

    public AssetRecordInstance() {
        this.setRecordDefinitionName(name);
    }

    public AssetRecordInstance(RecordInstance recordInstance) {
        super(recordInstance);
        this.setRecordDefinitionName(name);
    }

    public RecordInstance getRecordInstance() {
        RecordInstance recordInstance = new RecordInstance(this);
        return recordInstance;
    }

    public static int Display_ID = 1;
    public void setDisplay_ID(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Display_ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDisplay_ID(){

        if(this.getFieldInstance(AssetRecordInstance.Display_ID) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Display_ID).getValue();
    }


    public static int Created_By = 2;
    public void setCreated_By(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Created_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getCreated_By(){

        if(this.getFieldInstance(AssetRecordInstance.Created_By) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Created_By).getValue();
    }


    public static int Created_Date = 3;
    public void setCreated_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Created_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getCreated_Date() throws ParseException {

        if(this.getFieldInstance(AssetRecordInstance.Created_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(AssetRecordInstance.Created_Date).getValue());
        return date;
    }


    public static int Assignee = 4;
    public void setAssignee(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Assignee,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getAssignee(){

        if(this.getFieldInstance(AssetRecordInstance.Assignee) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Assignee).getValue();
    }


    public static int Modified_By = 5;
    public void setModified_By(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Modified_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getModified_By(){

        if(this.getFieldInstance(AssetRecordInstance.Modified_By) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Modified_By).getValue();
    }


    public static int Modified_Date = 6;
    public void setModified_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Modified_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getModified_Date() throws ParseException{

        if(this.getFieldInstance(AssetRecordInstance.Modified_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(AssetRecordInstance.Modified_Date).getValue());
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
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Status,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public StatusOption getStatus(){

        if(this.getFieldInstance(AssetRecordInstance.Status) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(AssetRecordInstance.Status).getValue());

        return StatusOption.convertFromInt(id);
    }

    public static int Description = 8;
    public void setDescription(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Description,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDescription(){

        if(this.getFieldInstance(AssetRecordInstance.Description) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Description).getValue();
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
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Notifier_Listening,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public Notifier_ListeningOption getNotifier_Listening(){

        if(this.getFieldInstance(AssetRecordInstance.Notifier_Listening) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(AssetRecordInstance.Notifier_Listening).getValue());

        return Notifier_ListeningOption.convertFromInt(id);
    }

    public static int GUID = 179;
    public void setGUID(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.GUID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getGUID(){

        if(this.getFieldInstance(AssetRecordInstance.GUID) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.GUID).getValue();
    }


    public static int ID = 379;
    public void setID(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getID(){

        if(this.getFieldInstance(AssetRecordInstance.ID) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.ID).getValue();
    }

    public static int ExternalInstanceId = 536870913;
    public void setExternalInstanceId(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.ExternalInstanceId, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getExternalInstanceId() {
        if(this.getFieldInstance(AssetRecordInstance.ExternalInstanceId) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.ExternalInstanceId).getValue();
    }

    public static int Name = 536870914;
    public void setName(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Name, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getName() {
        if(this.getFieldInstance(AssetRecordInstance.Name) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Name).getValue();
    }

    public static int Category = 536870915;
    public void setCategory(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Category, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getCategory() {
        if(this.getFieldInstance(AssetRecordInstance.Category) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Category).getValue();
    }

    public static int Type = 536870916;
    public void setType(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Type, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getType() {
        if(this.getFieldInstance(AssetRecordInstance.Type) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Type).getValue();
    }

    public static int Item = 536870917;
    public void setItem(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Item, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getItem() {
        if(this.getFieldInstance(AssetRecordInstance.Item) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Item).getValue();
    }

    
    public static int Region = 536870918;
    public void setRegion(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Region, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getRegion() {
        if(this.getFieldInstance(AssetRecordInstance.Region) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Region).getValue();
    }

    public static int Site = 536870919;
    public void setSite(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Site, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getSite() {
        if(this.getFieldInstance(AssetRecordInstance.Site) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Site).getValue();
    }

    public static int Building = 536870920;
    public void setBuilding(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Building, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getBuilding() {
        if(this.getFieldInstance(AssetRecordInstance.Building) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Building).getValue();
    }

    public static int Floor = 536870922;
    public void setFloor(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Floor, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getFloor() {
        if(this.getFieldInstance(AssetRecordInstance.Floor) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Floor).getValue();
    }

    public static int Room = 536870921;
    public void setRoom(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Room, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getRoom() {
        if(this.getFieldInstance(AssetRecordInstance.Room) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Room).getValue();
    }

    public static int ModelNumber = 536870923;
    public void setModelNumber(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.ModelNumber, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getModelNumber() {
        if(this.getFieldInstance(AssetRecordInstance.ModelNumber) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.ModelNumber).getValue();
    }

    public static int Manufacturer = 536870924;
    public void setManufacturer(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.Manufacturer, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getManufacturer() {
        if(this.getFieldInstance(AssetRecordInstance.Manufacturer) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.Floor).getValue();
    }

    public static int TagNumber = 536870925;
    public void setTagNumber(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.TagNumber, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getTagNumber() {
        if(this.getFieldInstance(AssetRecordInstance.TagNumber) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.TagNumber).getValue();
    }

    public static int ExternalReconciliationID = 536870926;
    public void setExternalReconciliationID(String value){
        FieldInstance fieldInstance = new FieldInstance(AssetRecordInstance.ExternalReconciliationID, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getExternalReconciliationID() {
        if(this.getFieldInstance(AssetRecordInstance.ExternalReconciliationID) == null){
            return null;
        }
        return this.getFieldInstance(AssetRecordInstance.ExternalReconciliationID).getValue();
    }

     

}
