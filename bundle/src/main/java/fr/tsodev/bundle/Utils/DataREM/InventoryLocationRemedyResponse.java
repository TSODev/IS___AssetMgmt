package fr.tsodev.bundle.Utils.DataREM;

public class InventoryLocationRemedyResponse {

	private InventoryLocationRemedyValues[] entries ;

	public InventoryLocationRemedyValues[] getEntries() {
		return entries;
	}

	public InventoryLocationRemedyValues getEntries(int index) {
		return entries[index];
	}

	public void setEntries(InventoryLocationRemedyValues[] entries) {
		this.entries = entries;
	}

}
