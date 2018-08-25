package fr.tsodev.integration.impl;

import java.util.Map;
import java.util.HashMap;
import org.hibernate.validator.constraints.NotBlank;

import fr.tsodev.integration.AssetManagementService;

import com.bmc.arsys.rx.application.common.ServiceLocator;
import com.bmc.arsys.rx.services.RxException;
import com.bmc.arsys.rx.services.action.domain.Action;
import com.bmc.arsys.rx.services.action.domain.ActionParameter;
import com.bmc.arsys.rx.services.association.AssociationService;
import com.bmc.arsys.rx.services.common.DataPage;
import com.bmc.arsys.rx.services.common.DataPageQueryParameters;
import com.bmc.arsys.rx.services.common.QueryPredicate;
import com.bmc.arsys.rx.services.common.domain.Scope;
import com.bmc.arsys.rx.services.record.RecordService;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;
import fr.tsodev.integration.impl.AssetManagementServiceImpl;
import fr.tsodev.connector.remedy.implementation.*;
import fr.tsodev.bundle.Utils.DataREM.ProductCatalogRemedy;
import fr.tsodev.bundle.Utils.DataRX.AssetRecordInstance;
import fr.tsodev.bundle.Utils.DataRX.ContractRecordInstance;
import fr.tsodev.bundle.Utils.DataREM.ASTComputerSystemRemedy;
import fr.tsodev.bundle.Utils.DataREM.ContractBaseRemedy;
import fr.tsodev.bundle.Utils.DataREM.GenericContractRemedy;
import fr.tsodev.bundle.Utils.DataREM.InventoryLocationRemedy;

import fr.tsodev.integration.impl.AssetManagementConstants;


public class AssetManagementServiceImpl implements AssetManagementService {

//	@Override
//	@Action(scope= Scope.PUBLIC)
//	public String connection(
//		@ActionParameter(name = "Connection Name") @NotBlank String ConnectionName
//	) {
//		return null;
//	}

	/* (non-Javadoc)
	 * 
	 */
	@Override
	@Action(scope = Scope.PUBLIC)
	public String createProductCatalogItem(
		@ActionParameter(name = "Asset Type") @NotBlank String AssetClass,
		@ActionParameter(name = "Product Name") @NotBlank String ProductName,
		@ActionParameter(name = "Manufacturer") @NotBlank String Manufacturer,
		@ActionParameter(name = "Categorization Tier 1") @NotBlank String Categorization1,
		@ActionParameter(name = "Categorization Tier 2") @NotBlank String Categorization2,
		@ActionParameter(name = "Categorization Tier 3") @NotBlank String Categorization3
		) {
		
	
		ProductCatalogRemedy CatalogItem = RemedyAPI.createProductCatalogEntry( 
															AssetClass, 
															ProductName, 
															Manufacturer, 
															Categorization1, 
															Categorization2, 
															Categorization3);
		
		// Sync Instance ID in the RX Record
		
//		RecordService recordService = ServiceLocator.getRecordService();
//		ServiceLocator.getLogger().info("Trying to access [MUSICBOX] Artist records with ServiceLocator");
//		DataPageQueryParameters params = BuildParametersForArtist("'379'=" + '"' + ArtistRecordId + '"');
//		DataPage result = recordService.getRecordInstancesByIdDataPage(params);
//		List<?> records = result.getData();
//		if (records.size() != 1) {
//			return null;
//		}
//		// Should only find one , so we focus on records[0]
//		String stringRecords = records.get(0).toString();
//		return sanetize(stringRecords);

		return CatalogItem.getInstanceId();
	}	
	
	@Override
	@Action(scope = Scope.PUBLIC)
	public String createInventoryLocation(
		@ActionParameter(name = "Name") @NotBlank String Name,
		@ActionParameter(name = "Company") @NotBlank String Company,
		@ActionParameter(name = "Region") @NotBlank String Region,
		@ActionParameter(name = "Site") @NotBlank String Site,
		@ActionParameter(name = "Building") @NotBlank String Building,
		@ActionParameter(name = "Room") String Room,
		@ActionParameter(name = "Floor") String Floor) {

			InventoryLocationRemedy InventoryLocation = RemedyAPI.createInventoryLocationEntry(
					Name,
					Company,
					Region,
					Site,
					Building,
					Room,
					Floor
			);
			
		
		return InventoryLocation.getInstanceId();
	}

	@Override
	@Action(scope = Scope.PUBLIC)
	public String createContractBase(
		@ActionParameter(name = "ID") @NotBlank String ID,
		@ActionParameter(name = "Description") @NotBlank String Description) {

			ContractBaseRemedy ContractBase = RemedyAPI.createContractBaseEntry(
					ID,
					Description
			);
			
		
		return ContractBase.getInstanceId();
	}

//	@Override
//	@Action(scope = Scope.PUBLIC)
//	public String createGenericContract(
//		@ActionParameter(name = "ID") @NotBlank String ID,
//		@ActionParameter(name = "Description") @NotBlank String Description) {
//
//			GenericContractRemedy Contract = RemedyAPI.createGenericContractEntry(
//					ID,
//					Description
//			);
//			
//		
//		return Contract.getInstanceId();
//	}

	
	
//	@Override
//	@Action(scope = Scope.PUBLIC)
//	public String createAsset(
//			@ActionParameter(name = "Name") @NotBlank String Name,
//			@ActionParameter(name = "Description") @NotBlank String Description,
//			@ActionParameter(name = "Category") @NotBlank String Category,
//			@ActionParameter(name = "Type") @NotBlank String Type,
//			@ActionParameter(name = "Item") @NotBlank String Item,
//			@ActionParameter(name = "Manufacturer") String Manufacturer,
//			@ActionParameter(name = "Model") String Model,
//			@ActionParameter(name = "Region") @NotBlank String Region,
//			@ActionParameter(name = "Site") @NotBlank String Site,
//			@ActionParameter(name = "Building") @NotBlank String Building,
//			@ActionParameter(name = "Room") String Room,
//			@ActionParameter(name = "Floor") String Floor,
//			@ActionParameter(name = "Tag Number") String TagNumber	) {
//		
//		ASTComputerSystemRemedy Asset = RemedyAPI.createAsset(Name, 
//																Description,
//																Category,
//																Type,
//																Item,
//																Manufacturer,
//																Model,
//																Region,
//																Site,
//																Building,
//																Room,
//																Floor,
//																TagNumber
//																);
//
//
//		return Asset.getInstanceId();
//	}	
	
	@Override
	@Action(scope= Scope.PUBLIC)
	public String createExternalAsset(
			@ActionParameter(name = "Asset Record ID") @NotBlank String recordID) {
		
		RecordService recordService = ServiceLocator.getRecordService();
		RecordInstance recordInstance = recordService.getRecordInstance(AssetManagementConstants.ASSETMANAGEMENT_ASSET_RECORD_NAME, recordID);
		
		ASTComputerSystemRemedy RemedyAsset = RemedyAPI.createAsset(
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_NAME_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_DESCRIPTION_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_CATEGORY_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_TYPE_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_ITEM_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_MANUFACTURER_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_MODEL_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_REGION_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_SITE_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_BUILDING_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_ROOM_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_FLOOR_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_TAG_NUMBER_FIELD_ID)
											);		
		
		recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_EXTERNAL_INSTANCE_ID_FIELD_ID_STRING), RemedyAsset.getInstanceId());
		recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_EXTERNAL_RECONCILIATION_ID_FIELD_ID_STRING), RemedyAsset.getReconciliationIdentity());
		
		recordService.updateRecordInstance(recordInstance);
		
		return RemedyAsset.getInstanceId();
	}
	
	
	@Override
	@Action(scope = Scope.PUBLIC)
	public String createExternalGenericContract(
		@ActionParameter(name = "Contract Record ID") @NotBlank  String recordID) {
		
		RecordService recordService = ServiceLocator.getRecordService();
		RecordInstance recordInstance = recordService.getRecordInstance(AssetManagementConstants.ASSETMANAGEMENT_CONTRACT_RECORD_NAME, recordID);
		
		GenericContractRemedy RemedyGenericContract = RemedyAPI.createGenericContractEntry(
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_NAME_FIELD_ID), 
				recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_DESCRIPTION_FIELD_ID)
											);
				
		recordInstance.setFieldValue(AssetManagementConstants.ASSETMANAGEMENT_ASSET_EXTERNAL_INSTANCE_ID_FIELD_ID, RemedyGenericContract.getInstanceId());
		
		recordService.updateRecordInstance(recordInstance);
		
		return RemedyGenericContract.getInstanceId();
	}

	@Override
	@Action(scope = Scope.PUBLIC)
	public String createExternalProductCatalog(
		@ActionParameter(name = "Product Catalog Record ID") @NotBlank  String recordID) {
		
		RecordService recordService = ServiceLocator.getRecordService();
		RecordInstance recordInstance = recordService.getRecordInstance(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_RECORD_NAME, recordID);
		
		ProductCatalogRemedy RemedyProductCatalog = RemedyAPI.createProductCatalogEntry(
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_ASSET_CLASS_FIELD_ID), 
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_PRODUCT_NAME_FIELD_ID), 
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_MANUFACTURER_FIELD_ID), 
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_CATEGORY_1_FIELD_ID), 
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_CATEGORY_2_FIELD_ID), 
						recordInstance.getFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_CATEGORY_3_FIELD_ID)
						);
				
		recordInstance.setFieldValue(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_EXTERNAL_INSTANCE_ID_FIELD_ID, RemedyProductCatalog.getInstanceId());
		
		recordService.updateRecordInstance(recordInstance);
		
		return RemedyProductCatalog.getInstanceId();
	}


	
	@Override
	@Action(scope = Scope.PUBLIC)
	public String getAssetReconciliationId(
			@ActionParameter(name = "Name") @NotBlank String Name,
			@ActionParameter(name = "Description") @NotBlank String Description	) {
		
		ASTComputerSystemRemedy Asset = RemedyAPI.getAsset(Name, Description);


		return Asset.getReconciliationIdentity();
	}	
	
	private static final String CONTRACT_RECORDNAME = "fr.tsodev.assetmgmt:Contract";
	private static final String ASSET_RECORDNAME = "fr.tsodev.assetmgmt:Asset";

	@Override
	@Action(scope = Scope.PUBLIC)
	public String processContractSpecifications(
			@ActionParameter(name = "Contract Id") @NotBlank String ContractId,
			@ActionParameter(name = "Asset Basename") @NotBlank String AssetBaseName) {
		
		RecordService recordService = ServiceLocator.getRecordService();
		RecordInstance contractInstance = recordService.getRecordInstance(CONTRACT_RECORDNAME, ContractId);

	    // Examine the Product Catalog associated to this contract.
	    Map<String, Object> mappedRecord;
	    try {
	        mappedRecord = getAssociatedRecord(
	                AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_IN_CONTRACT_ASSOCIATION, contractInstance.getId(), true);
	    }
	    catch (RxException e) {
	        ServiceLocator.getLogger().error("Problem getting dish information for Order " + contractInstance.getId());
	        throw new AssetManagementException(AssetManagementException.AssetManagementMessage.ASSET_CANT_READ_ASSOCIATION, contractInstance.getId(), e);
	    }
		
	    if (mappedRecord == null) {
	        ServiceLocator.getLogger().error("No Product Catalog associated to: " + contractInstance.getId());
	        return null;
	    }
	    
	    String Cat1 = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_1_FIELD_ID_STRING).toString();
	    String Cat2 = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_2_FIELD_ID_STRING).toString();
	    String Cat3 = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_3_FIELD_ID_STRING).toString();
	    String Manufacturer = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_MANUFACTURER_FIELD_ID_STRING).toString();
	    String Model = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_PRODUCT_CATALOG_MODEL_FIELD_ID_STRING).toString();
	    
	    // Examine the Inventory Location associated to this contract.
//	    Map<String, Object> mappedRecord;
	    try {
	        mappedRecord = getAssociatedRecord(
	                AssetManagementConstants.ASSETMANAGEMENT_INVENTORYLOCATION_IN_CONTRACT_ASSOCIATION, contractInstance.getId(), true);
	    }
	    catch (RxException e) {
	        ServiceLocator.getLogger().error("Problem getting dish information for Order " + contractInstance.getId());
	        throw new AssetManagementException(AssetManagementException.AssetManagementMessage.ASSET_CANT_READ_ASSOCIATION, contractInstance.getId(), e);
	    }
		
	    if (mappedRecord == null) {
	        ServiceLocator.getLogger().error("No Inventory Location associated to: " + contractInstance.getId());
	        return null;
	    }
	    
	    String Region = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_INVENTORY_LOCATION_REGION_FIELD_ID_STRING).toString();
	    String Site = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_INVENTORY_LOCATION_SITE_FIELD_ID_STRING).toString();
	    String Building = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_INVENTORY_LOCATION_BUILDING_FIELD_ID_STRING).toString();	    
	    String Room = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_INVENTORY_LOCATION_ROOM_FIELD_ID_STRING).toString();	    
	    String Floor = mappedRecord.get(AssetManagementConstants.ASSETMANAGEMENT_INVENTORY_LOCATION_FLOOR_FIELD_ID_STRING).toString();
	    
		Integer quantity = Integer.parseInt(contractInstance.getFieldValue(ContractRecordInstance.Quantity));
				
	    String recordDefinitionName = ASSET_RECORDNAME;
		
		// Create Quantity Asset records with related information.
		for ( int i=0 ; i<quantity ; i++)
		{
		    String formatted = String.format("%03d", i);
		    String name = AssetBaseName + "-" + formatted;
		    
		    ASTComputerSystemRemedy ExternalAsset = RemedyAPI.createAsset(
		    		name, 
		    		name, 
		    		Cat1, 
		    		Cat2, 
		    		Cat3, 
		    		Manufacturer, 
		    		Model, 
		    		Region, 
		    		Site, 
		    		Building, 
		    		Room, 
		    		Floor, 
		    		name);

		    String ExternalInstanceID = ExternalAsset.getInstanceId();
		    String ExternalReconciliationID = ExternalAsset.getReconciliationIdentity();
		    
		    String relation = RemedyAPI.relateAssetToContract(contractInstance.getId(), ExternalReconciliationID);

		    if (relation == "OK") {
		    	RecordInstance recordInstance = new RecordInstance();
		    	recordInstance.setRecordDefinitionName(recordDefinitionName);

		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_NAME_FIELD_ID_STRING), name);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_DESCRIPTION_FIELD_ID_STRING), name);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_CATEGORY_FIELD_ID_STRING), Cat1);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_TYPE_FIELD_ID_STRING), Cat2);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_ITEM_FIELD_ID_STRING), Cat3);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_REGION_FIELD_ID_STRING), Region);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_SITE_FIELD_ID_STRING), Site);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_BUILDING_FIELD_ID_STRING), Building);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_ROOM_FIELD_ID_STRING), Room);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_FLOOR_FIELD_ID_STRING), Floor);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_MODEL_FIELD_ID_STRING), Model);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_MANUFACTURER_FIELD_ID_STRING), Manufacturer);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_TAG_NUMBER_FIELD_ID_STRING), name);		    
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_EXTERNAL_INSTANCE_ID_FIELD_ID_STRING), ExternalInstanceID);
		    	recordInstance.setFieldValue(Integer.parseInt(AssetManagementConstants.ASSETMANAGEMENT_ASSET_EXTERNAL_RECONCILIATION_ID_FIELD_ID_STRING), ExternalReconciliationID);

		    	try {
		    		recordService.createRecordInstance(recordInstance);		

		    		AssociationService associationService = ServiceLocator.getAssociationService();
		    		associationService.associate(AssetManagementConstants.ASSETMANAGEMENT_ASSETS_IN_CONTRACT_ASSOCIATION, recordInstance.getId(), contractInstance.getId());
		    	}
		    	catch (RxException e) {
		    		ServiceLocator.getLogger().error("Problem creating new Asset record ");
		    		throw new AssetManagementException(AssetManagementException.AssetManagementMessage.ASSET_CANT_CREATE, recordInstance.getId(), e);
		    	}		    	
		    } else {
		    	// We were not able to create the relationship on the External side		    	
//		    	throw new AssetManagementException(AssetManagementException.AssetManagementMessage.ASSET_CANT_READ_ASSOCIATION,contractInstance.getId(), e);
		    }
		    

		    
		   
		}
		
		String result = contractInstance.getFieldValue(ContractRecordInstance.ID);
		
		return result;
	}

	/**
	 * Utility method to fetch one associated record. Particularly useful for the "1" in a "1:1" or "1:Many" association.
	 * @param associationName
	 * @param startingRecordId
	 * @param isFirstRecord
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getAssociatedRecord(
			String associationName, 
			String startingRecordId, 
			boolean isFirstRecord) {


		DataPage result = getAssociatedRecords(associationName, startingRecordId, isFirstRecord, 1);
		if (result == null || result.getData() == null || result.getData().size() != 1) {
			return null;
		}
		return (HashMap<String, Object>)result.getData().get(0);
	}
	


/**
 * Utility method just to make the code look cleaner. Does a query for associated records.
 * @param associationName
 * @param startingRecordId
 * @param isFirstRecord
 * @param maxRecords 
 * @return
*/
	private DataPage getAssociatedRecords(
								String associationName, 
								String startingRecordId, 
								boolean isFirstRecord, 
								int maxRecords) {
			
		AssociationService associationService = ServiceLocator.getAssociationService();		
			
		Map<String, QueryPredicate> queryPredicatesByName = new HashMap<String, QueryPredicate>();
		queryPredicatesByName.put("associationDefinition", new QueryPredicate("associationDefinition", associationName));
		queryPredicatesByName.put("nodeToQuery", new QueryPredicate("nodeToQuery", (isFirstRecord) ? "nodeA" : "nodeB"));
		queryPredicatesByName.put("associatedRecordInstanceId", new QueryPredicate("associatedRecordInstanceId", startingRecordId));		
			
		DataPageQueryParameters params = new DataPageQueryParameters(maxRecords, 0, null, null, queryPredicatesByName);
		return associationService.getAssociationInstancesByIdDataPage(params);		
	}
	
	
//	
//	private String getContractByRecordId(String ContractId) {
//		RecordService recordService = ServiceLocator.getRecordService();
//		ServiceLocator.getLogger().info("Trying to access [ASSETMGMT] Contract records with ServiceLocator");
//		DataPageQueryParameters params = BuildParametersForContract("'379'=" + '"' + ContractId + '"');
//		DataPage result = recordService.getRecordInstancesByIdDataPage(params);
//		List<?> records = result.getData();
//		if (records.size() != 1) {
//			return null;
//		}
//		// Should only find one , so we focus on records[0]
//		String stringRecords = records.get(0).toString();
//		return sanetize(stringRecords);
//		
//	}
//	
//
//	private String sanetize(String s){
//		return s.substring(1, s.length()-1);
//	}		//remove enclosing { and } / don't know where they come from
//
//
//	
//	// Creating query parameters
//	private DataPageQueryParameters BuildParametersForContract(String qualification) {
//		Map<String, List<String>> dataPageParams = new HashMap<String, List<String>>();
//		String myQualification = "";
//
//		int FIELD_NAME = 10377002;
//
//		// Type of datapage query to use
//		dataPageParams.put("dataPageType", new ArrayList<String>(Arrays.asList(QUERY_TYPE_NAME)));
//
//		// How many data to retrieve?
//		int nb_records = DataPage.INFINITE_PAGE_SIZE;
//		dataPageParams.put("pageSize", new ArrayList<String>(Arrays.asList(Integer.toString(nb_records))));
//
//		// List of fields to get
//		List<String> propertySelections = new ArrayList<String>();
//		String guidFieldId = String.valueOf(RecordInstance.GUID_FIELD_ID);
//		String RecordFieldId = String.valueOf(RecordInstance.RECORD_ID_FIELD_ID);
//		String artistName = String.valueOf(FIELD_NAME);
//		propertySelections.add(guidFieldId);
//		propertySelections.add(RecordFieldId);
//		propertySelections.add(artistName);
////		propertySelections.add(TASK_AGENTS_LOGINID);
//		dataPageParams.put("propertySelection", new ArrayList<String>(propertySelections));
//
//		// Which record definition to get?
//		dataPageParams.put("recorddefinition", new ArrayList<String>(Arrays.asList(CONTRACT_RECORDNAME)));
//
//		// Where do we start?
//		dataPageParams.put("startIndex", new ArrayList<String>(Arrays.asList("0")));
//
//		// Qualification, we search .... (see qualification paramter)
//		myQualification = qualification;
//		dataPageParams.put("queryExpression", new ArrayList<String>(Arrays.asList(myQualification)));
//
//		return new DataPageQueryParameters(dataPageParams);
//
//	}
	
	/**
	 * Useful general utility for getting any shared setting value.
	 * @param bundleId
	 * @param componentName
	 * @param settingName
	 * @return
	 */
//	@Override
//	@Action(scope = Scope.PUBLIC)	
//	public String settingTextValue(
//			@ActionParameter(name = "bundleId") @NotBlank String bundleId,
//			@ActionParameter(name = "componentName") @NotBlank String componentName, 
//			@ActionParameter(name = "settingName") @NotBlank String settingName) {	
//		return MealOrderSettings.getStringValue(bundleId, componentName, settingName);
//	}
	
	/**
	 * Utility method to make the code look a bit cleaner. Gets the Service using the global Service Locator.
	 * @return
	 */
	public static AssetManagementService getAssetManagementService() {
		return (AssetManagementService) ServiceLocator.getBundleService().getService(AssetManagementServiceImpl.class.getName());
    }	
}
