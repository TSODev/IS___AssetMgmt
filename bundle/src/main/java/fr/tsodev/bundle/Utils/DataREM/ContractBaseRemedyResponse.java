package fr.tsodev.bundle.Utils.DataREM;

public class ContractBaseRemedyResponse {

	private ContractBaseRemedyValues[] entries ;

	public ContractBaseRemedyValues[] getEntries() {
		return entries;
	}

	public ContractBaseRemedyValues getEntries(int index) {
		return entries[index];
	}

	public void setEntries(ContractBaseRemedyValues[] entries) {
		this.entries = entries;
	}

}
