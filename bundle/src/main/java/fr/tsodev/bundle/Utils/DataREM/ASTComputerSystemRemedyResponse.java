package fr.tsodev.bundle.Utils.DataREM;

public class ASTComputerSystemRemedyResponse {

	private ASTComputerSystemRemedyValues[] entries ;

	public ASTComputerSystemRemedyValues[] getEntries() {
		return entries;
	}

	public ASTComputerSystemRemedyValues getEntries(int index) {
		return entries[index];
	}

	public void setEntries(ASTComputerSystemRemedyValues[] entries) {
		this.entries = entries;
	}

}
