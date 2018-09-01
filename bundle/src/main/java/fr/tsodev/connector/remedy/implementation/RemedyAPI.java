package fr.tsodev.connector.remedy.implementation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import java.net.URI;

import fr.tsodev.bundle.Utils.DataREM.ProductCatalogRemedy;
import fr.tsodev.bundle.Utils.DataREM.ProductCatalogRemedyResponse;
import fr.tsodev.bundle.Utils.DataREM.ASTComputerSystemRemedy;
import fr.tsodev.bundle.Utils.DataREM.ASTComputerSystemRemedyResponse;
import fr.tsodev.bundle.Utils.DataREM.ContractBaseRemedy;
import fr.tsodev.bundle.Utils.DataREM.ContractBaseRemedyResponse;
import fr.tsodev.bundle.Utils.DataREM.GenericContractRemedy;
import fr.tsodev.bundle.Utils.DataREM.GenericContractRemedyResponse;
import fr.tsodev.bundle.Utils.DataREM.InventoryLocationRemedy;
import fr.tsodev.bundle.Utils.DataREM.InventoryLocationRemedyResponse;
import fr.tsodev.integration.impl.AssetManagementException;
import fr.tsodev.integration.impl.AssetManagementSettings;
import fr.tsodev.integration.impl.AssetManagementException.AssetManagementMessage;

// ToDo : Important : Need to encode character before sending them to external system through Rest API.

public class  RemedyAPI {

    private static String connect(String URL, String UserName, String Password){

        Form form = new Form();
            form.param("username", UserName);
            form.param("password", Password);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI(URL));
        Response response = target
                                .path("/api/jwt/login")
                                .request()
                                .accept(MediaType.TEXT_PLAIN)
                                .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Response.class);

		if (response.getStatus() == 200) {
			return response.readEntity(String.class);
		} else {
//			throw (new RxServicesException(100001, "User Not Authenticated"));
			throw (new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_AUTHENTICATION_ERROR," User Not Authenticated") );
//			return null;
		}

    }

    public static ProductCatalogRemedy createProductCatalogEntry(
                                                    String AssetClass,
                                                    String ProductName,
                                                    String Manufacturer,
                                                    String Cat1,
                                                    String Cat2,
                                                    String Cat3){
    	    
        String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());


			ProductCatalogRemedyResponse pcr = null;
 	    	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
	        // Product Name is unique .
	    	String query = new StringBuilder().append("'Product Name'= \"")
					.append(ProductName)
					.append("\"")
					.toString();
      
	        String body = new StringBuilder().append("{\"values\": ")
					.append("{")
					.append("\"Product Categorization Tier 1\": \"")
					.append(Cat1)
					.append("\",")
					.append("\"Product Categorization Tier 2\": \"")
					.append(Cat2)
					.append("\",")
					.append("\"Product Categorization Tier 3\": \"")
					.append(Cat3)
					.append("\",")
					.append("\"Product Name\": \"")
					.append(ProductName)
					.append("\",")
					.append("\"Manufacturer\": \"")
					.append(Manufacturer)
					.append("\",")
					.append("\"Asset Class\": \"")
					.append(AssetClass)
					.append("\",")
					.append("\"Product Type\": \"Configuration Item\"")
					.append("}")
					.append("}")
					.toString();

	        Client client = ClientBuilder.newClient();
	        WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
	        Response response = target
                .path("/api/arsys/v1/entry/PCT:Product%20Catalog")
                .request()
                .header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
        		.post(Entity.json(body)); 
        
	        //Retrieve the record 
	        // Case 201 - Will read the new record
	        // Case 500 - Need to check if Error due to duplicate - Read the existing one
        
	        if (response.getStatus() == 201 || response.getStatus() == 500) {
		        
		    	String res = target
		    			.path("/api/arsys/v1/entry/PCT:Product%20Catalog")
		    	        .queryParam("q", query)
		    			.request()
		    			.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
		    	        .accept(MediaType.APPLICATION_JSON)
		    	        .get(String.class);
		    	
				try{
					pcr = mapper.readValue(res, ProductCatalogRemedyResponse.class);
		
				}
				catch (JsonParseException e) { e.printStackTrace();}
				catch (JsonMappingException e) { e.printStackTrace(); }
				catch (IOException e) { e.printStackTrace(); }
		    	
		    	return pcr.getEntries(0).getValues();
		    	
    	    }
    	    else
    	    {
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record"));
//    	    	return null;
    	    }

    }

    public static InventoryLocationRemedy createInventoryLocationEntry(
            String Name,
            String Company,
            String Region,
            String Site,
            String Building,
            String Room,
            String Floor){

    		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    		InventoryLocationRemedyResponse pcr = null;
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    		String query = "'Name'= \"" + Name + "\" AND "
    				+ "'Company'= \"" + Company + "\" AND "
    				+ "'Region'= \"" + Region + "\" AND "
    				+ "'Site'= \"" + Site + "\" AND "
    				+ "'Building'= \"" + Building + "\" AND "
    				+ "'Room'= \"" + Room + "\" AND"
    				+ "'Floor'= \"" + Floor +"\"";

    		String body = "{\"values\": "
    				+ "{"
    				+ "\"Short Description\": \"" + Name + "\","
    				+ "\"Class Id\": \"BMC_INVENTORYSTORAGE\","
    				+ "\"Data Set Id\": \"BMC.ASSET\","
    				+ "\"Name\": \"" + Name + "\","
    				+ "\"Company\": \"" + Company + "\","
    				+ "\"Region\": \"" + Region + "\","
    				+ "\"Site\": \"" + Site + "\","
    				+ "\"Building\": \"" + Building + "\","
    				+ "\"Room\": \"" + Room + "\","
    				+ "\"Floor\": \"" + Floor + "\""
    				+ "}"
    				+ "}";

    		Client client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
    		Response response = target
    				.path("/api/arsys/v1/entry/AST:InventoryStorage")
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.post(Entity.json(body)); 

    		//Retrieve the record 
    		// Case 201 - Will read the new record
    		// Case 500 - Need to check if Error due to duplicate - Read the existing one

    		if (response.getStatus() == 201 || response.getStatus() == 204) {

    			String res = target
    					.path("/api/arsys/v1/entry/AST:InventoryStorage")
    					.queryParam("q", query)
    					.request()
    					.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    					.accept(MediaType.APPLICATION_JSON)
    					.get(String.class);

    			try{
    				pcr = mapper.readValue(res, InventoryLocationRemedyResponse.class);

    			}
    			catch (JsonParseException e) { e.printStackTrace();}
    			catch (JsonMappingException e) { e.printStackTrace(); }
    			catch (IOException e) { e.printStackTrace(); }

    			return pcr.getEntries(0).getValues();

    		}
    		else
    		{
    			String error = response.readEntity(String.class);
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record" + error));
//    			return null;
    		}
    }

    
    public static ContractBaseRemedy createContractBaseEntry(
            String ID,
            String Description){

    		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    		ContractBaseRemedyResponse pcr = null;
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    		String query = "'Contract ID+'= \"" + ID + "\" AND "
    				+ "'Description'= \"" + Description + "\"";

    		String body = "{\"values\": "
    				+ "{"
    				+ "\"Contract ID+\": \"" + ID + "\","
    				+ "\"Description\": \"" + Description + "\""
    				+ "}"
    				+ "}";

    		Client client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
    		Response response = target
    				.path("/api/arsys/v1/entry/CTR:ContractBase")
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.post(Entity.json(body)); 

    		//Retrieve the record 
    		// Case 201 - Will read the new record
    		// Case 500 - Need to check if Error due to duplicate - Read the existing one

    		if (response.getStatus() == 201 || response.getStatus() == 204) {

    			String res = target
    					.path("/api/arsys/v1/entry/CTR:ContractBase")
    					.queryParam("q", query)
    					.request()
    					.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    					.accept(MediaType.APPLICATION_JSON)
    					.get(String.class);

    			try{
    				pcr = mapper.readValue(res, ContractBaseRemedyResponse.class);

    			}
    			catch (JsonParseException e) { e.printStackTrace();}
    			catch (JsonMappingException e) { e.printStackTrace(); }
    			catch (IOException e) { e.printStackTrace(); }

    			return pcr.getEntries(0).getValues();

    		}
    		else
    		{
    			String error = response.readEntity(String.class);
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record" + error));
//    			return null;
    		}
    }

    
    public static GenericContractRemedy createGenericContractEntry(
            String ID,
            String Description){

    		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    		GenericContractRemedyResponse pcr = null;
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    		String query = "'Contract ID+'= \"" + ID + "\" AND "
    				+ "'Description'= \"" + Description + "\"";

    		String body = "{\"values\": "
    				+ "{"
    				+ "\"Contract ID+\": \"" + ID + "\","
    				+ "\"Description\": \"" + Description + "\","
    				+ "\"Company\": \"Calbro Services\","
    	    		+ "\"Supplier Name+\": \"BMC\","
    	    		+ "\"Assigned Support Company\": \"Calbro Services\","
    	    		+ "\"Assigned Support Organization\": \"IT Support\","
    	    		+ "\"Cost Center\": \"225276-B\","
    	       		+ "\"Type\": \"Fixed\","
    	    		+ "\"Expiration Date\": \"2020\","
    	    		+ "\"Notification Date\": \"2020\","
    	    		+ "\"Notification Group+\": \"Asset Management\""
    				+ "}"
    				+ "}";
    		
    		
    		Client client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
    		Response response = target
    				.path("/api/arsys/v1/entry/CTR:GenericContract")
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.post(Entity.json(body)); 

    		//Retrieve the record 
    		// Case 201 - Will read the new record
    		// Case 500 - Need to check if Error due to duplicate - Read the existing one

    		if (response.getStatus() == 201 || response.getStatus() == 204) {

    			String res = target
    					.path("/api/arsys/v1/entry/CTR:GenericContract")
    					.queryParam("q", query)
    					.request()
    					.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    					.accept(MediaType.APPLICATION_JSON)
    					.get(String.class);

    			try{
    				pcr = mapper.readValue(res, GenericContractRemedyResponse.class);

    			}
    			catch (JsonParseException e) { e.printStackTrace();}
    			catch (JsonMappingException e) { e.printStackTrace(); }
    			catch (IOException e) { e.printStackTrace(); }

    			return pcr.getEntries(0).getValues();

    		}
    		else
    		{
    			String error = response.readEntity(String.class);
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record" + error));

    		}
    }

 
    
    public static GenericContractRemedy createMasterContractEntry(
            String ID,
            String Description){

    		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    		GenericContractRemedyResponse pcr = null;
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    		String query = "'Contract ID+'= \"" + ID + "\" AND "
    				+ "'Description'= \"" + Description + "\"";

    		String body = "{\"values\": "
    				+ "{"
    				+ "\"Contract ID+\": \"" + ID + "\","
    				+ "\"Description\": \"" + Description + "\","
    				+ "\"Company\": \"Calbro Services\","
    	    		+ "\"Supplier Name+\": \"BMC\","
    	    		+ "\"Assigned Support Company\": \"Calbro Services\","
    	    		+ "\"Assigned Support Organization\": \"IT Support\","
    	    		+ "\"Cost Center\": \"225276-B\","
    	       		+ "\"Type\": \"Fixed\","
    	    		+ "\"Expiration Date\": \"2020\","
    	    		+ "\"Notification Date\": \"2020\","
    	    		+ "\"Notification Group+\": \"Asset Management\""
    				+ "}"
    				+ "}";
    		
    		
    		Client client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
    		Response response = target
    				.path("/api/arsys/v1/entry/CTR:MasterContract")
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.post(Entity.json(body)); 

    		//Retrieve the record 
    		// Case 201 - Will read the new record
    		// Case 500 - Need to check if Error due to duplicate - Read the existing one

    		if (response.getStatus() == 201 || response.getStatus() == 204) {

    			String res = target
    					.path("/api/arsys/v1/entry/CTR:MasterContract")
    					.queryParam("q", query)
    					.request()
    					.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    					.accept(MediaType.APPLICATION_JSON)
    					.get(String.class);

    			try{
    				pcr = mapper.readValue(res, GenericContractRemedyResponse.class);

    			}
    			catch (JsonParseException e) { e.printStackTrace();}
    			catch (JsonMappingException e) { e.printStackTrace(); }
    			catch (IOException e) { e.printStackTrace(); }

    			return pcr.getEntries(0).getValues();

    		}
    		else
    		{
    			String error = response.readEntity(String.class);
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record" + error));
    		}
    }


    
    public static String relateAssetToContract(
    													String ContractID,
    													String AssetRecID) {
    	
		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

		String pcr = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String body = "{\"values\": "
				+ "{"
				+ "\"Parent_Form_Name\": \"AST:ComputerSystem\","
				+ "\"Parent_Instance_ID\": \"" + AssetRecID + "\","
				+ "\"Parent_Relationship_Type\": \"Contract\","
				+ "\"Child_Form_Name\": \"CTR:MasterContract\","				
				+ "\"Child_Instance_ID\": \"" + ContractID + "\","
				+ "\"Child_Relationship_Type\": \"Contract\","
				+ "\"Child_ID\": \"" + ContractID + "\","
        		+ "\"Association Type01\": \"Attached to\","  
        		+ "\"Short Description\": \"IS generated relationship\""  
				+ "}"
				+ "}";

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
		Response response = target
				.path("/api/arsys/v1/entry/CTR:Contract_Relationship")
				.request()
				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
				.post(Entity.json(body)); 

    	if (response.getStatus() != 201) {
    		return "Error : " + response.getEntity();
    	} else {
    		return "OK";
    	}
    	
    }
    

    public static ASTComputerSystemRemedy createAsset(
            												String Name,
            												String Description,
            												String Category,
            												String Type,
            												String Item,
            												String Manufacturer,
            												String Model,
            												String Region,
            												String Site,
            												String Building,
            												String Room,
            												String Floor,
            												String TagNumber
    		){

    		String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    		ASTComputerSystemRemedyResponse pcr = null;
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    		String query = "'Name'= \"" + Name + "\"";

    		String body = "{\"values\": "
    				+ "{"
    				+ "\"Name\": \"" + Name + "\","
    				+ "\"Short Description\": \"" + Description + "\","
    				+ "\"Category\": \"" + Category + "\","
     				+ "\"Type\": \"" + Type + "\"," 
    				+ "\"Item\": \"" + Item + "\","
//    				+ "\"Manufacturer Name\": \"" + Manufacturer + "\","
//    				+ "\"Model Number\": \"" + Model + "\","
    				+ "\"Region\": \"" + Region + "\","
    				+ "\"Site\": \"" + Site + "\","
    				+ "\"Building\": \"" + Building + "\","
    				+ "\"Room\": \"" + Room + "\","
    				+ "\"Floor\": \"" + Floor + "\","  
    				+ "\"Tag Number\": \"" + TagNumber + "\","  
    				+ "\"Company\": \"Calbro Services\","
    				+ "\"AssetLifecycleStatus\": \"Ordered\","
	        		+ "\"Data Set Id\": \"BMC.ASSET\""   				
    				+ "}"
    				+ "}";

    		Client client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));
    		Response response = target
    				.path("/api/arsys/v1/entry/AST:ComputerSystem")
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.post(Entity.json(body)); 

    		//Retrieve the record 
    		// Case 201 - Will read the new record
    		// Case 500 - Need to check if Error due to duplicate - Read the existing one

    		if (response.getStatus() == 201 || response.getStatus() == 204) {

    			String res = target
    					.path("/api/arsys/v1/entry/AST:ComputerSystem")
    					.queryParam("q", query)
    					.request()
    					.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    					.accept(MediaType.APPLICATION_JSON)
    					.get(String.class);

    			try{
    				pcr = mapper.readValue(res, ASTComputerSystemRemedyResponse.class);

    			}
    			catch (JsonParseException e) { e.printStackTrace();}
    			catch (JsonMappingException e) { e.printStackTrace(); }
    			catch (IOException e) { e.printStackTrace(); }

    			return pcr.getEntries(0).getValues();

    		}
    		else
    		{
    			String error = response.readEntity(String.class);
				throw( new AssetManagementException(AssetManagementMessage.EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD, "Error retrieving external record" + error));
    		}
    }

    
    public static ASTComputerSystemRemedy getAsset(
    												String Name,
    												String Description){

    	String token = connect(AssetManagementSettings.getURL(), AssetManagementSettings.getUsername(), AssetManagementSettings.getPassword());

    	ASTComputerSystemRemedyResponse pcr = null;
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    	String query = "'Name'= \"" + Name + "\" AND "
    			+ "'Short Description'= \"" + Description + "\"";

    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target(getBaseURI(AssetManagementSettings.getURL()));

    		String res = target
    				.path("/api/arsys/v1/entry/AST:ComputerSystem")
    				.queryParam("q", query)
    				.request()
    				.header(HttpHeaders.AUTHORIZATION, "AR-JWT " + token)
    				.accept(MediaType.APPLICATION_JSON)
    				.get(String.class);

    		try{
    			pcr = mapper.readValue(res, ASTComputerSystemRemedyResponse.class);

    		}
    		catch (JsonParseException e) { e.printStackTrace();}
    		catch (JsonMappingException e) { e.printStackTrace(); }
    		catch (IOException e) { e.printStackTrace(); }

    		return pcr.getEntries(0).getValues();

    }




    private static URI getBaseURI(String URL) {
        return UriBuilder.fromPath(URL).build();
    }
}