package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import javax.print.attribute.standard.DateTimeAtCompleted;

import service.MainService;

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
	
	
	//other functions 
	
	
	/*
	 The function addVehicleToShoppingListByVehicleCode(), which searches for the
vehicle in the shop (or in the Vehicle type list created in 6a) by the given vehicle
code and adds it to the shopper's purchase or shoppingList list. At that point, the
number of this vehicle shall be reduced by 1 in the shop (or Vehicle type list
created in point 6a).
	 */
	
	public void addVehicleToShoppingListByVehicleCode(String inputVehicleCode, int inputQuantity) throws Exception {
		if(inputVehicleCode == null) {
			throw new Exception("Vehicle code is null");
		}
		else {
			for(Vehicle tempV: MainService.allVehicles) {//iterating all vehicles in the shop
				if(tempV.getVehicleCode().equals(inputVehicleCode)) {
					if(tempV.getQuantity() <= 0) {
						throw new Exception("Quantity is less than one");
					}
					else {
						if(tempV instanceof Bus) {
							Bus busFromService = (Bus)tempV;
							Bus boughtBus = new Bus(busFromService.getVehicleCode(), busFromService.getPrice(), inputQuantity, busFromService.geteType(), busFromService.getNumberOfSeats(), busFromService.getHasBaggageDivision());
							shoppingList.add(boughtBus);
						}
						else if(tempV instanceof Tractor) {
							Tractor tractorFromService = (Tractor)tempV;
							Tractor boughtTractor = new Tractor(tractorFromService.getVehicleCode(), tractorFromService.getPrice(), inputQuantity, tractorFromService.geteType(), tractorFromService.getAdditionalTechniques(), tractorFromService.isOnlyLargeTires());
							shoppingList.add(boughtTractor);
						}
						
						tempV.setQuantity(tempV.getQuantity() - inputQuantity);
					}
					return;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
