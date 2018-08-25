package fr.tsodev.bundle.Utils.DataREM;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericContractRemedy {
	
	private String RequestID;
	private String Submitter;
	private String SubmitDate;
	private String AssignedTo;
	private String LastModifiedBy;
	private String LastModifiedDate;
	private String Status;
	private String Description;
	private String InstanceId;
	private String ContractID;
	private String Type;
	private String ExpirationDate;
	private String NotificationDate;
	
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
	@JsonProperty("Create-date") public String getSubmitDate() {
		return SubmitDate;
	}
	public void setSubmitDate(String submitDate) {
		SubmitDate = submitDate;
	}
	@JsonProperty("Assigned-to") public String getAssignedTo() {
		return AssignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}
	@JsonProperty("Last-modified-by") public String getLastModifiedBy() {
		return LastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}
	@JsonProperty("Modified-date") public String getLastModifiedDate() {
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
	public String getInstanceId() {
		return InstanceId;
	}
	public void setInstanceId(String instanceId) {
		InstanceId = instanceId;
	}
	public String getContractID() {
		return ContractID;
	}
	public void setContractID(String contractID) {
		ContractID = contractID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@JsonProperty("Expiration Date") public String getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}
	@JsonProperty("Notification Date") public String getNotificationDate() {
		return NotificationDate;
	}
	public void setNotificationDate(String notificationDate) {
		NotificationDate = notificationDate;
	}
	

}
