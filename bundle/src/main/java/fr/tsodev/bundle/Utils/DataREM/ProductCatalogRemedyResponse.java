package fr.tsodev.bundle.Utils.DataREM;

import fr.tsodev.bundle.Utils.DataREM.ProductCatalogRemedyValues;;

public class ProductCatalogRemedyResponse {
	
	public ProductCatalogRemedyValues[] getEntries() {
		return entries;
	}

	public ProductCatalogRemedyValues getEntries(int index) {
		return entries[index];
	}

	public void setEntries(ProductCatalogRemedyValues[] entries) {
		this.entries = entries;
	}

	private ProductCatalogRemedyValues[] entries ;


}
