package fr.tsodev.bundle.Utils.DataRX;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bmc.arsys.rx.services.record.domain.FieldInstance;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;

public class InventoryLocationRecordInstance extends RecordInstance {

    public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String JSON_TIME_FORMAT = "HH:mm:ss";
    public static final String JSON_DATE_FORMAT = "yyyy-MM-dd";
    public static final String AR_TIME_FORMAT = "hh:mm:ss a";
    public static final String JSON_IF_UNMODIFIED_SINCE_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";


    public static final String name = "fr.tsodev.assetmgmt:Inventory%20Location";
    public static final String bundlename = "fr.tsodev.assetmgmt";

    public InventoryLocationRecordInstance() {
        this.setRecordDefinitionName(name);
    }

    public InventoryLocationRecordInstance(RecordInstance recordInstance) {
        super(recordInstance);
        this.setRecordDefinitionName(name);
    }

    public RecordInstance getRecordInstance() {
        RecordInstance recordInstance = new RecordInstance(this);
        return recordInstance;
    }

    public static int Display_ID = 1;
    public void setDisplay_ID(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Display_ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDisplay_ID(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Display_ID) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Display_ID).getValue();
    }


    public static int Created_By = 2;
    public void setCreated_By(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Created_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getCreated_By(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Created_By) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Created_By).getValue();
    }


    public static int Created_Date = 3;
    public void setCreated_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Created_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getCreated_Date() throws ParseException {

        if(this.getFieldInstance(InventoryLocationRecordInstance.Created_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(InventoryLocationRecordInstance.Created_Date).getValue());
        return date;
    }


    public static int Assignee = 4;
    public void setAssignee(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Assignee,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getAssignee(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Assignee) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Assignee).getValue();
    }


    public static int Modified_By = 5;
    public void setModified_By(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Modified_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getModified_By(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Modified_By) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Modified_By).getValue();
    }


    public static int Modified_Date = 6;
    public void setModified_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Modified_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getModified_Date() throws ParseException{

        if(this.getFieldInstance(InventoryLocationRecordInstance.Modified_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(InventoryLocationRecordInstance.Modified_Date).getValue());
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
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Status,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public StatusOption getStatus(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Status) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(InventoryLocationRecordInstance.Status).getValue());

        return StatusOption.convertFromInt(id);
    }

    public static int Description = 8;
    public void setDescription(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Description,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDescription(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Description) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Description).getValue();
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
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Notifier_Listening,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public Notifier_ListeningOption getNotifier_Listening(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.Notifier_Listening) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(InventoryLocationRecordInstance.Notifier_Listening).getValue());

        return Notifier_ListeningOption.convertFromInt(id);
    }

    public static int GUID = 179;
    public void setGUID(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.GUID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getGUID(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.GUID) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.GUID).getValue();
    }


    public static int ID = 379;
    public void setID(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getID(){

        if(this.getFieldInstance(InventoryLocationRecordInstance.ID) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.ID).getValue();
    }

    public static int ExternalInstanceId = 536870913;
    public void setExternalInstanceId(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.ExternalInstanceId, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getExternalInstanceId() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.ExternalInstanceId) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.ExternalInstanceId).getValue();
    }

    public static int Name = 536870914;
    public void setName(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Name, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getName() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Name) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Name).getValue();
    }

    public static int Company = 536870915;
    public void setCompany(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Company, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getCompany() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Company) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Company).getValue();
    }

    public static int Region = 536870916;
    public void setRegion(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Region, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getRegion() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Region) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Region).getValue();
    }

    public static int Site = 536870917;
    public void setSite(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Site, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getSite() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Site) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Site).getValue();
    }

    public static int Building = 536870918;
    public void setBuilding(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Building, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getBuilding() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Building) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Building).getValue();
    }

    public static int Floor = 536870919;
    public void setFloor(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Floor, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getFloor() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Floor) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Floor).getValue();
    }

    public static int Room = 536870920;
    public void setRoom(String value){
        FieldInstance fieldInstance = new FieldInstance(InventoryLocationRecordInstance.Room, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getRoom() {
        if(this.getFieldInstance(InventoryLocationRecordInstance.Room) == null){
            return null;
        }
        return this.getFieldInstance(InventoryLocationRecordInstance.Room).getValue();
    }

    
	
}
