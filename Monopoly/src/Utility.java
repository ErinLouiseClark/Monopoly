
public class Utility {

	private String utilityName;
	private int utilityPrice;
	private int utilityMortgage;
	private int utilityRent;
	private String utilityOwner;
	
	public Utility(String n, int p, int m, int r, String o){
		utilityName = n;
		utilityOwner = o;
		utilityMortgage = m;
		utilityRent = r;
		utilityPrice = p;
	}
	
	public int getUtilityPrice() {
		return utilityPrice;
	}

	public void setUtilityPrice(int utilityPrice) {
		this.utilityPrice = utilityPrice;
	}

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public String getUtilityOwner() {
		return utilityOwner;
	}

	public void setUtilityOwner(String utilityOwner) {
		this.utilityOwner = utilityOwner;
	}

	public int getUtilityMortgage() {
		return utilityMortgage;
	}

	public void setUtilityMortgage(int utilityMortgage) {
		this.utilityMortgage = utilityMortgage;
	}

	public int getUtilityRent() {
		return utilityRent;
	}

	public void setUtilityRent(int utilityRent) {
		this.utilityRent = utilityRent;
	}

}
