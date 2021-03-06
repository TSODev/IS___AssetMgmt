package fr.tsodev.integration;

import com.bmc.arsys.rx.services.common.Service;
import org.hibernate.validator.constraints.NotBlank;


public interface AssetManagementService extends Service {
    
    /**
     * 
     * This method returns ALL Entries from the Product Catalog
     * 
     */

//    public String getJWT(@NotBlank String URL,
//                            @NotBlank String Username,
//                            @NotBlank String Password);
                            
//    public String createProductCatalogItem(
//                                            @NotBlank String AssetClass,
//                                            @NotBlank String ProductName,
//                                            @NotBlank String Manufacturer,
//                                            @NotBlank String Categorization1,
//                                            @NotBlank String Categorization2,
//                                            @NotBlank String Categorization3);
//
//    public String createInventoryLocation(
//    										@NotBlank String Name,
//    										@NotBlank String Company,
//    										@NotBlank String Region,
//    										@NotBlank String Site,
//    										@NotBlank String Building,
//    										String Room,
//    										String Floor);
 
    
//    public String createContractBase(
//											@NotBlank String ID,
//											@NotBlank String Description);  

//    public String createGenericContract(
//											@NotBlank String ID,
//											@NotBlank String Description);  
//    
//    public String createAsset(
//    										@NotBlank String Name,
//    										@NotBlank String Description);
    
//    public String createAsset(
//    										@NotBlank String Name,
//    										@NotBlank String Description,
//    										@NotBlank String Category,
//    										@NotBlank String Type,
//    										@NotBlank String Item,
//    										String Manufacturer,
//    										String Model,
//    										@NotBlank String Region,
//    										@NotBlank String Site,
//    										@NotBlank String Building,
//    										String Room,
//    										String Floor,
//    										String TagNumber);
 
    public String getAssetReconciliationId(
											@NotBlank String Name,
											@NotBlank String Description);
    
    public String processContractSpecifications(
    										@NotBlank String ContractId);
    
    public String createExternalAsset(
    										@NotBlank String AssetID
    										);
    
    public String createExternalGenericContract(
											@NotBlank String ContractID
											);

    public String createExternalProductCatalog(
											@NotBlank String ProductCatalogID
											);
    
    public String createExternalInventoryLocation(
    										@NotBlank String InventoryLocationID
    										);
    
    public String getExternalBaseUrl();
    
//    public String createAssetItem(@NotBlank String Class,
//    								@NotBlank String ProductId);
//    
}