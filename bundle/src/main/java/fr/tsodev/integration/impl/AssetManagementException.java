package fr.tsodev.integration.impl;

import com.bmc.arsys.rx.services.RxException;

public class AssetManagementException extends RxException {

	private static final long serialVersionUID = -1801158764215645524L;

	public enum AssetManagementMessage {
		CONTRACT_NOT_FOUND(600_100),
		CONTRACT_INVALID(600_101),
		CONTRACT_CANT_MODIFY(600_102),
		CONTRACT_CANT_READ_ASSOCIATION(600_103),
		
		PRODUCT_CATALOG_NOT_FOUND(600_104),
		PRODUCT_CATALOG_INVALID(600_105),
		PRODUCT_CATALOG_CANT_MODIFY(600_106),
		PRODUCT_CATALOG_CANT_READ_ASSOCIATION(600_107),
		
		INVENTORY_LOCATION_NOT_FOUND(600_108),
		INVENTORY_LOCATION_INVALID(600_109),
		INVENTORY_LOCATION_CANT_MODIFY(600_110),
		INVENTORY_LOCATION_CANT_READ_ASSOCIATION(600_111),
		
		ASSET_NOT_FOUND(600_112),
		ASSET_INVALID(600_113),
		ASSET_CANT_MODIFY(600_114),
		ASSET_CANT_READ_ASSOCIATION(600_115),
		ASSET_CANT_CREATE(600_116),
		ASSET_CANT_CREATE_ASSOCIATION(600_117),

		EXTERNAL_CONNECTION_AUTHENTICATION_ERROR(600_200),
		EXTERNAL_CONNECTION_CANNOT_RETRIEVE_RECORD(600_201);
		
	    private final int intValue;
	    
	    AssetManagementMessage(int intValue) {
	        this.intValue= intValue;
	    }

	    public int intValue() {
	        return intValue;
	    }	    
	}

    public AssetManagementException(AssetManagementMessage errorMessage, String appendedText, RxException e) {
       super(errorMessage.intValue(), AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, appendedText, e);
	}
 
	public AssetManagementException(AssetManagementMessage errorMessage, Exception e) {
	   super(errorMessage.intValue(), AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, e.getLocalizedMessage(), null);
	}
 
	public AssetManagementException(AssetManagementMessage errorMessage, String appendedText) {
	   super(errorMessage.intValue(), AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, appendedText, null);

	}
}
