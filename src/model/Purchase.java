package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;

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
	//no need for set functions, is initialized(=)
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
			this.userCardNr = "0000 0000 0000 0000";
		}
		
	}
	
	public ArrayList<Vehicle> getShoppingList() {
		return shoppingList;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setShoppingList(ArrayList<Vehicle> shoppingList){
		if(shoppingList != null) {
			this.shoppingList = shoppingList;
		}
	}
	
	
	
	//constructors
	
	
	public Purchase() {
		setUserCardNr("1234 5678 1478 1236");
	}

	public Purchase(String userCardNr) {                          
		this.userCardNr = userCardNr;
	}
	
	public Purchase(String userCardNr, ArrayList<Vehicle> shoppingList) {                          
		this.userCardNr = userCardNr;
		setShoppingList(shoppingList);
	}
	@Override
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return "Card number: " + userCardNr +"; Shopping list size: " + shoppingList.size() + " [" + dateTime.format(formatter) + "]";
	}
	
}
