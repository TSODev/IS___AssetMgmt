package fr.tsodev.integration.impl;

import java.util.Map;

import com.bmc.arsys.rx.application.common.ServiceLocator;
import com.bmc.arsys.rx.services.admin.domain.AdminHeader;
import com.bmc.arsys.rx.services.admin.domain.AdminSettingData;
import com.bmc.arsys.rx.services.admin.domain.AdminSettingDataContainer;

/**
 * This is a utility class that works with the Settings Service to retrieve configuration information 
 * within the Meal Program library.
 * @author dsulcer
 *
 */
public class AssetManagementSettings {
	
	
	/** 
	* Look up the configured tax rate, which should be a setting definition created.
	*/
	public static String getURL() {	

		String URL = getStringValue(
				AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_COMPONENT_REMEDYSERVER, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_SETTING_URL);		
		return URL;
    }
    
    public static String getUsername() {	

		String Username = getStringValue(
				AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_COMPONENT_REMEDYSERVER, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_SETTING_USERNAME);		
		return Username;
	}

    public static String getPassword() {	

		String Password = getStringValue(
				AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_COMPONENT_REMEDYSERVER, 
				AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_SETTING_PASSWORD);		
		return Password;
	}

    public static String getLoggerFilename() {
    	String FileName = getStringValue(
    			AssetManagementConstants.ASSETMANAGEMENT_PROGRAM_BUNDLE_ID,
    			AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_COMPONENT_LOGGER,
    			AssetManagementConstants.SETTINGS_ASSETMANAGEMENT_SETTING_FILENAME);
    	return FileName;
    }

	/**
	 * Utility method to get some shared setting.
	 * @param setting
	 * @return
	 */
	public static String getStringValue(String bundle, String component, String setting) {	
		
		AdminHeader adminHeader = new AdminHeader();
		adminHeader.setBundleScope(bundle);
		adminHeader.setGlobalSpace(false);
		AdminSettingDataContainer dataHolder = null;
		try {
			 dataHolder = ServiceLocator.getAdminSettingsService().
				getAdminSettingData(component, adminHeader);
		}
		catch (Exception e) {
			ServiceLocator.getLogger().error("Could not access [ Bundle : " + bundle + "]-( Component : " +component + ") component");
		}
		Map<String, AdminSettingData> dataMap = null;
		try {
			dataMap = dataHolder.getAdminSettingDataMap();
		}
		catch (Exception e) {}
		if (dataMap == null) {
			ServiceLocator.getLogger().error("no dataMap found for " + component + " component");	
			return null;
		}
		
		AdminSettingData data = null;
		try {
			data = dataMap.get(setting);
		}
		catch (Exception e) {}
		if (data == null) {
			ServiceLocator.getLogger().error("could not get data for '"  + setting + "'");
			return null;
		}
		ServiceLocator.getLogger().info(data.getSettingId() + "," + data.getSettingName() + ", " + data.getSettingValue()); 
		return data.getSettingValue();
	}
}
