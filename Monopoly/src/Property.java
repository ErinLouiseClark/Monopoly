
public class Property {

	private String propertyName;
	private String color;
	private int price;
	private int houses;
	private int rent; 
	private String propertyOwner;
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	private int r5;
	

	public Property(String n, String c, int p, int h, int m, int r, String o, int r2, int r3, int r4, int r5, int r6){
		propertyName = n;
		color = c;
		price = p;
		houses = h;
		rent = r;
		propertyOwner = o;
		r1 = r2;
		r2 = r3;
		r3 = r4;
		r4 = r5;
		r5 = r6;
			
	}


	public int getR1() {
		return r1;
	}


	public void setR1(int r1) {
		this.r1 = r1;
	}


	public int getR2() {
		return r2;
	}


	public void setR2(int r2) {
		this.r2 = r2;
	}


	public int getR3() {
		return r3;
	}


	public void setR3(int r3) {
		this.r3 = r3;
	}


	public int getR4() {
		return r4;
	}


	public void setR4(int r4) {
		this.r4 = r4;
	}


	public int getR5() {
		return r5;
	}


	public void setR5(int r5) {
		this.r5 = r5;
	}


	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}
	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}
}
