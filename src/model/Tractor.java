package model;

public class Tractor extends Vehicle{
	private String additionalTechniques;
	private boolean isOnlyLargeTires;
	
	
	public String getAdditionalTechniques() {
		return additionalTechniques;
	}
	public void setAdditionalTechniques(String additionalTechniques) {
		if(additionalTechniques != null) {
			this.additionalTechniques = additionalTechniques;
		}
		else {
			this.additionalTechniques = "Undefined";
		}
		
	}
	
	
	public boolean isOnlyLargeTires() {
		return isOnlyLargeTires;
	}
	public void setOnlyLargeTires(boolean isOnlyLargeTires) {
		this.isOnlyLargeTires = isOnlyLargeTires;
	}
	
	public Tractor() {
		super();
		setAdditionalTechniques("Undefined");
		setOnlyLargeTires(false);
	}
	
	public Tractor(String title, float price, int quantity, energyType eType, String additionalTechniques, boolean isOnlyLargeTires) {
		super(title, price, quantity, eType);
		setAdditionalTechniques(additionalTechniques);
		setOnlyLargeTires(isOnlyLargeTires);
	}
	
	@Override
	public String toString() {
		return super.toString() + " Technique: " + additionalTechniques + ", only large tires? " + isOnlyLargeTires;
	}
	
}
