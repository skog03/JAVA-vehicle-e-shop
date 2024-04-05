package model;

public class Bus extends Vehicle{
	
	private int numberOfSeats;
	private boolean hasBaggageDivision;
	
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		if(numberOfSeats > 0 && numberOfSeats < 300) {
			this.numberOfSeats = numberOfSeats;
		}
		else {
			this.numberOfSeats = 50;
		}
		
	}
	public boolean getHasBaggageDivision() {
		return hasBaggageDivision;
	}
	public void setHasBaggageDivision(boolean hasBaggageDivision) {
		this.hasBaggageDivision = hasBaggageDivision;
	}
	
	
	public Bus() {
		super();
		numberOfSeats = 50;
		hasBaggageDivision = true;
	}
	
	public Bus(String title, float price, int quantity, EnergyType eType, int numberOfSeats, boolean hasBaggageDivision) {
		super(title, price, quantity, eType);
		setNumberOfSeats(numberOfSeats); 
		setHasBaggageDivision(hasBaggageDivision);
	}
	
	@Override
	public String toString() {
		return super.toString() + "   nr of seats:" + numberOfSeats + ", has baggage? " + hasBaggageDivision;
	}

}
