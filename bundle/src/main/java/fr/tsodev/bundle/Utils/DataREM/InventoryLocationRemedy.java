package fr.tsodev.bundle.Utils.DataREM;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryLocationRemedy {

	private String RequestID;
	private String Submitter;
	private String SubmitDate;
	private String AssignedTo;
	private String LastModifiedBy;
	private String LastModifiedDate;
	private String AssetLifecycleStatus;
	private String ShortDescription;
	private String InstanceId;
	private String Site;
	private String Region;
	private String Name;
	private String Building;
	private String Floor;
	private String Room;
	private String Location;


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

	@JsonProperty("Create Date")public String getSubmitDate() {
		return SubmitDate;
	}

	public void setSubmitDate(String submitDate) {
		SubmitDate = submitDate;
	}

	@JsonProperty("Assigned To")public String getAssignedTo() {
		return AssignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}

	@JsonProperty("Last Modified By")public String getLastModifiedBy() {
		return LastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}

	@JsonProperty("Last Modified Date")public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

	public String getAssetLifecycleStatus() {
		return AssetLifecycleStatus;
	}

	public void setAssetLifecycleStatus(String assetLifecycleStatus) {
		AssetLifecycleStatus = assetLifecycleStatus;
	}

	@JsonProperty("Short Description")public String getShortDescription() {
		return ShortDescription;
	}

	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}

	@JsonProperty("Instance Id")public String getInstanceId() {
		return InstanceId;
	}

	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBuilding() {
		return Building;
	}

	public void setBuilding(String building) {
		Building = building;
	}

	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	public String getRoom() {
		return Room;
	}

	public void setRoom(String room) {
		Room = room;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}



}