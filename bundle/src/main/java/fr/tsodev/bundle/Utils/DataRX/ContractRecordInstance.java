package fr.tsodev.bundle.Utils.DataRX;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bmc.arsys.rx.services.record.domain.FieldInstance;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;


public class ContractRecordInstance extends RecordInstance {

    public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String JSON_TIME_FORMAT = "HH:mm:ss";
    public static final String JSON_DATE_FORMAT = "yyyy-MM-dd";
    public static final String AR_TIME_FORMAT = "hh:mm:ss a";
    public static final String JSON_IF_UNMODIFIED_SINCE_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";


    public static final String name = "fr.tsodev.assetmgmt:Contract";
    public static final String bundlename = "fr.tsodev.assetmgmt";

    public ContractRecordInstance() {
        this.setRecordDefinitionName(name);
    }

    public ContractRecordInstance(RecordInstance recordInstance) {
        super(recordInstance);
        this.setRecordDefinitionName(name);
    }

    public RecordInstance getRecordInstance() {
        RecordInstance recordInstance = new RecordInstance(this);
        return recordInstance;
    }

    public static int Display_ID = 1;
    public void setDisplay_ID(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Display_ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDisplay_ID(){

        if(this.getFieldInstance(ContractRecordInstance.Display_ID) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Display_ID).getValue();
    }


    public static int Created_By = 2;
    public void setCreated_By(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Created_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getCreated_By(){

        if(this.getFieldInstance(ContractRecordInstance.Created_By) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Created_By).getValue();
    }


    public static int Created_Date = 3;
    public void setCreated_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Created_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getCreated_Date() throws ParseException {

        if(this.getFieldInstance(ContractRecordInstance.Created_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(ContractRecordInstance.Created_Date).getValue());
        return date;
    }


    public static int Assignee = 4;
    public void setAssignee(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Assignee,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getAssignee(){

        if(this.getFieldInstance(ContractRecordInstance.Assignee) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Assignee).getValue();
    }


    public static int Modified_By = 5;
    public void setModified_By(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Modified_By,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getModified_By(){

        if(this.getFieldInstance(ContractRecordInstance.Modified_By) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Modified_By).getValue();
    }


    public static int Modified_Date = 6;
    public void setModified_Date(Date value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Modified_Date,new SimpleDateFormat(JSON_DATE_TIME_FORMAT).format(value));
        this.putFieldInstance(fieldInstance);
    }

    public Date getModified_Date() throws ParseException{

        if(this.getFieldInstance(ContractRecordInstance.Modified_Date) == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(JSON_DATE_TIME_FORMAT);
        Date date = format.parse( this.getFieldInstance(ContractRecordInstance.Modified_Date).getValue());
        return date;
    }


    public static int Status = 7;

    public static enum StatusOption {
        New (0),
        Assigned (1),
        Fixed (2),
        Rejected (3),
        Closed (4);



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
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Status,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public StatusOption getStatus(){

        if(this.getFieldInstance(ContractRecordInstance.Status) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(ContractRecordInstance.Status).getValue());

        return StatusOption.convertFromInt(id);
    }

    public static int Description = 8;
    public void setDescription(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Description,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getDescription(){

        if(this.getFieldInstance(ContractRecordInstance.Description) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Description).getValue();
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
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Notifier_Listening,"" + value.id);
        this.putFieldInstance(fieldInstance);
    }

    public Notifier_ListeningOption getNotifier_Listening(){

        if(this.getFieldInstance(ContractRecordInstance.Notifier_Listening) == null){
            return null;
        }
        int id = Integer.parseInt(this.getFieldInstance(ContractRecordInstance.Notifier_Listening).getValue());

        return Notifier_ListeningOption.convertFromInt(id);
    }

    public static int GUID = 179;
    public void setGUID(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.GUID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getGUID(){

        if(this.getFieldInstance(ContractRecordInstance.GUID) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.GUID).getValue();
    }


    public static int ID = 379;
    public void setID(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.ID,value);
        this.putFieldInstance(fieldInstance);
    }

    public String getID(){

        if(this.getFieldInstance(ContractRecordInstance.ID) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.ID).getValue();
    }

    public static int ExternalInstanceId = 536870913;
    public void setExternalInstanceId(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.ExternalInstanceId, value);
        this.putFieldInstance(fieldInstance);
    }

    public String getExternalInstanceId() {
        if(this.getFieldInstance(ContractRecordInstance.ExternalInstanceId) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.ExternalInstanceId).getValue();
    }

    public static int Name = 536870915;
    public void setName(String value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Name, value);
        this.putFieldInstance(fieldInstance);
    }
    public String getName() {
        if(this.getFieldInstance(ContractRecordInstance.Name) == null){
            return null;
        }
        return this.getFieldInstance(ContractRecordInstance.Name).getValue();
    }
  
    public static int Quantity = 536870914;
    
    public void setQuantity(Integer value){
        FieldInstance fieldInstance = new FieldInstance(ContractRecordInstance.Quantity,"" + value);
        this.putFieldInstance(fieldInstance);
    }
    public int getQuantity() {
    	if(this.getFieldInstance(ContractRecordInstance.Quantity)== null  ) {
    		return 0;
    	}
    	return Integer.parseInt(this.getFieldInstance(ContractRecordInstance.Quantity).getValue());
    }
	
}
