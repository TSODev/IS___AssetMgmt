package fr.tsodev.bundle.Utils.DataREM;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ASTComputerSystemRemedy {

	
	private String RequestID;
	private String Submitter;
	private String SubmitDate;
	private String AssignedTo;
	private String LastModifiedBy;
	private String LastModifiedDate;
	private String Status;
	private String Description;
	private String InstanceId;
	private String Category;
	private String Type;
	private String Item;
	private String Site;
	private String Region;
	private String Building;
	private String Room;
	private String Floor;
	private String ModelNumber;
	private String ManufacturerName;
	private String TagNumber;
	private String ReconciliationIdentity;
	
	
	@JsonProperty("Request ID") public String getRequestID() {
		return RequestID;
	}
	public void setRequestID(String requestID) {
		RequestID = requestID;
	}
	public String getSubmitter() {
		return Submitter;
	}
	public void setSubmitter(String submitter) {
		Submitter = submitter;
	}
	@JsonProperty("") public String getSubmitDate() {
		return SubmitDate;
	}
	public void setSubmitDate(String submitDate) {
		SubmitDate = submitDate;
	}
	@JsonProperty("Assign To") public String getAssignedTo() {
		return AssignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}
	@JsonProperty("Last Modified By") public String getLastModifiedBy() {
		return LastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}
	@JsonProperty("Modified Date") public String getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@JsonProperty("Instance Id") public String getInstanceId() {
		return InstanceId;
	}
	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getItem() {
		return Item;
	}
	public void setItem(String item) {
		Item = item;
	}
	public String getSite() {
		return Site;
	}
	public void setSite(String site) {
		Site = site;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getBuilding() {
		return Building;
	}
	public void setBuilding(String building) {
		Building = building;
	}
	public String getRoom() {
		return Room;
	}
	public void setRoom(String room) {
		Room = room;
	}
	public String getFloor() {
		return Floor;
	}
	public void setFloor(String floor) {
		Floor = floor;
	}
	@JsonProperty("Model Number") public String getModelNumber() {
		return ModelNumber;
	}
	public void setModelNumber(String modelNumber) {
		ModelNumber = modelNumber;
	}
	@JsonProperty("Manufacturer Name") public String getManufacturerName() {
		return ManufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		ManufacturerName = manufacturerName;
	}
	@JsonProperty("Tag Number") public String getTagNumber() {
		return TagNumber;
	}
	public void setTagNumber(String tagNumber) {
		TagNumber = tagNumber;
	}
	@JsonProperty("Reconciliation Identity") public String getReconciliationIdentity() {
		return ReconciliationIdentity;
	}
	public void setReconciliationIdentity(String reconciliationIdentity) {
		ReconciliationIdentity = reconciliationIdentity;
	}
	


}