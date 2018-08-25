package fr.tsodev.bundle.Utils.DataREM;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractBaseRemedy {

	
	private String EntryID;
	private String Submitter;
	private String SubmitDate;
	private String AssignedTo;
	private String LastModifiedBy;
	private String LastModifiedDate;
	private String Status;
	private String Description;
	private String InstanceId;
	private String ContractID;
	
	@JsonProperty("Entry-Id") public String getEntryID() {
		return EntryID;
	}
	public void setEntryID(String entryID) {
		EntryID = entryID;
	}
	public String getSubmitter() {
		return Submitter;
	}
	public void setSubmitter(String submitter) {
		Submitter = submitter;
	}
	@JsonProperty("Create-Date") public String getSubmitDate() {
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
	@JsonProperty("Last-Modified-by") public String getLastModifiedBy() {
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
	@JsonProperty("Contract ID+") public void setContractID(String contractID) {
		ContractID = contractID;
	}



}