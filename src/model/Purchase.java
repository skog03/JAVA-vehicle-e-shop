package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Purchase {
	/*
	Class Purchase
	a. Variables: String userCardNr, shoppingList - list (containing the vehicles that the
	user will have bought), LocalDateTime dateTime ;
	
	b. Get functions;
	c. Set functions (with validations, see examples in 2.d.);
	d. Default constructor;
	e. A constructor that assigns values to class and parent class variables;
	f. toString function
	*/
	
	private String userCardNr;
	private ArrayList<Vehicle> shoppingList = new ArrayList<Vehicle> ();
	private LocalDateTime dateTime = LocalDateTime.now();
	
	public String getUserCardNr() {
		return userCardNr;
	}
	public void setUserCardNr(String userCardNr) {
		if(userCardNr != null && userCardNr.matches("[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) {
			this.userCardNr = userCardNr;
		}
		else {
			this.userCardNr = "Undefinded";
		}
		
	}
	
	public ArrayList<Vehicle> getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ArrayList<Vehicle> shoppingList) {
		if(shoppingList != null) {
			this.shoppingList = shoppingList;
		}
		else {
			this.shoppingList = new ArrayList<Vehicle>();
		}
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	
	
	//constructors
	public Purchase(String userCardNr, ArrayList<Vehicle> shoppingList, LocalDateTime dateTime) {                          
		this.userCardNr = userCardNr;
		this.shoppingList = shoppingList;
	
	public Purchase() {
		setUserCardNr("1234 5678 1478 1236");
		setShoppingList(new ArrayList<Vehicle>());
	}

	
	@Override
	public String toString() {
		return "Card number: " + userCardNr +"; Shopping list: " + shoppingList + "; Time: " + dateTime;
	}
	
}
