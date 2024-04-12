package model;

public abstract class Vehicle {
	// Variables:
	private int id;
	private String title;
	private String vehicleCode;
	private float price;
	private int quantity;
	private EnergyType eType;

	private static int counter = 0;

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = counter;
		counter++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && title.matches("[a-zA-Z -]{2,20}")) {
			this.title = title;
		} 
		else {
			this.title = "Undefined";
		}
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode() {
		this.vehicleCode = id + "_" + title;
		// vehicle id>_<vehicle name or title>

	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price > 0 && price < 1000000000) {
			this.price = price;
		}

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0 && quantity < 1000) {
			this.quantity = quantity;
		} 
		else {
			quantity = 1;
		}

	}

	public EnergyType geteType() {
		return eType;
	}

	public void seteType(EnergyType eType) {
		if (eType != null) {
			this.eType = eType;
		} 
		else {
			this.eType = EnergyType.not_specified;
		}

	}


	
	// Constructors
	
	public Vehicle(){
		setId();
		setTitle("title");
		setVehicleCode();
		setPrice(1.00f);
		setQuantity(1);
		seteType(EnergyType.not_specified);
	}
	
	
	public Vehicle(String title, float price, int quantity, EnergyType eType) {
		setId();
		setTitle(title);
		setVehicleCode();
		setPrice(price);
		setQuantity(quantity);
		seteType(eType);
	}
	
	
	//toString
	@Override
	public String toString() {
		//12_mercedes - electric - 20$ q:1
		return vehicleCode + "  [" + price + "$]  quantity:" + quantity +"   - " + eType + " -   ";
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
