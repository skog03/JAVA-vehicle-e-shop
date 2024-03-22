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
	public boolean isHasBaggageDivision() {
		return hasBaggageDivision;
	}
	public void setHasBaggageDivision(boolean hasBaggageDivision) {
		this.hasBaggageDivision = hasBaggageDivision;
	}
	
	
	public Bus() {
		numberOfSeats = 50;
		hasBaggageDivision = true;
	}
	
	public Bus(int numberOfSeats, boolean hasBaggageDivision) {
		setNumberOfSeats(numberOfSeats); 
		setHasBaggageDivision(hasBaggageDivision);
	}

}
