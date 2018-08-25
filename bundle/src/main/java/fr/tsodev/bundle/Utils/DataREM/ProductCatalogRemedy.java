package fr.tsodev.bundle.Utils.DataREM;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCatalogRemedy {
	
	

		 	 private String ProductID;
			 private String Submitter;
			 private String SubmitDate;
			 private String AssignedTo;
			 private String LastModifiedBy;
			 private String LastModifiedDate;
			 private String Status;
			 private String ShortDescription;
			 private String InstanceId;
			 private String ProductCategorizationTier1;
			 private String ProductCategorizationTier2;
			 private String ProductCategorizationTier3;
			 private String ProductName;
			 private String Manufacturer;
			 private String AssetClass;


		 
		 @JsonProperty("Product ID")
		 public String getProductID() {
			return ProductID;
		}

		public void setProductID(String productID) {
			ProductID = productID;
		}
		
		@JsonProperty("Submitter")
		public String getSubmitter() {
			return Submitter;
		}

		public void setSubmitter(String submitter) {
			Submitter = submitter;
		}

		@JsonProperty("Submit Date")
		public String getSubmitDate() {
			return SubmitDate;
		}

		public void setSubmitDate(String submitDate) {
			SubmitDate = submitDate;
		}

		@JsonProperty("Assigned To")
		public String getASsignedTo() {
			return AssignedTo;
		}

		public void setAssignedTo(String AssignedTo) {
			this.AssignedTo = AssignedTo;
		}

		@JsonProperty("Last Modified By")
		public String getLastModifiedBy() {
			return LastModifiedBy;
		}

		public void setLastModifiedBy(String lastModifiedBy) {
			LastModifiedBy = lastModifiedBy;
		}

		@JsonProperty("Last Modified Date")
		public String getLastModifiedDate() {
			return LastModifiedDate;
		}

		public void setLastModifiedDate(String lastModifiedDate) {
			LastModifiedDate = lastModifiedDate;
		}

		@JsonProperty("Short Description")
		public String getShortDescription() {
			return ShortDescription;
		}

		public void setShortDescription(String shortDescription) {
			ShortDescription = shortDescription;
		}


		@JsonProperty("InstanceId")
		public String getInstanceId() {
			return InstanceId;
		}

		public void setInstanceId(String instanceId) {
			InstanceId = instanceId;
		}

		@JsonProperty("Product Categorization Tier 1")
		public String getProductCategorizationTier1() {
			return ProductCategorizationTier1;
		}

		public void setProductCategorizationTier1(String productCategorizationTier1) {
			ProductCategorizationTier1 = productCategorizationTier1;
		}

		@JsonProperty("Product Categorization Tier 2")
		public String getProductCategorizationTier2() {
			return ProductCategorizationTier2;
		}

		public void setProductCategorizationTier2(String productCategorizationTier2) {
			ProductCategorizationTier2 = productCategorizationTier2;
		}

		@JsonProperty("Product Categorization Tier 3")
		public String getProductCategorizationTier3() {
			return ProductCategorizationTier3;
		}

		public void setProductCategorizationTier3(String productCategorizationTier3) {
			ProductCategorizationTier3 = productCategorizationTier3;
		}

		@JsonProperty("Product Name")
		public String getProductName() {
			return ProductName;
		}

		public void setProductName(String productName) {
			ProductName = productName;
		}

		@JsonProperty("Asset Class")
		public String getAssetClass() {
			return AssetClass;
		}

		public void setAssetClass(String assetClass) {
			AssetClass = assetClass;
		}

		@JsonProperty("Status")
		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}
		
		@JsonProperty("Manufacturer")
		public String getManufacturer() {
			return Manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			Manufacturer = manufacturer;
		}


}

