package fr.tsodev.bundle.Utils.DataREM;

public class GenericContractRemedyResponse {

	private GenericContractRemedyValues[] entries ;

	public GenericContractRemedyValues[] getEntries() {
		return entries;
	}

	public GenericContractRemedyValues getEntries(int index) {
		return entries[index];
	}

	public void setEntries(GenericContractRemedyValues[] entries) {
		this.entries = entries;
	}

}
