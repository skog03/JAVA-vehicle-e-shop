package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Bus;
import model.Tractor;
import model.Vehicle;
import model.EnergyType;
import model.Purchase;

public class MainService {
	
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	private static ArrayList<Purchase> allPurchases = new ArrayList<Purchase>();
	
	public static void main(String[] args) {
		/*
		b. In the main function, create at least two objects of type Bus and two of type Tractor and insert them in the Vehicle list created in point 
		 6.a. Create three objects of type Purchase and insert them in the Purchase list created in point 6a.
		 */
		
		
		Bus bus1 = new Bus("Volvo", 150000, 5, EnergyType.electric, 50, true);
		Bus bus2 = new Bus("Mercedes", 100000, 1, EnergyType.petrol, 47, true);
		Bus bus3 = new Bus("Yutong", 1200, 9, EnergyType.gas, 49, false);
		
		
		Tractor tr1 = new Tractor("New Holland", 3000, 6, EnergyType.petrol, "Harvest", false);
		Tractor tr2 = new Tractor("CAT", 1500000, 2, EnergyType.gas, "Tilling", true);
		
		allVehicles.addAll(Arrays.asList(bus1, bus2, bus3, tr1, tr2));
		
		for(Vehicle tempV : allVehicles) {
			System.out.println(tempV.getClass().getName() + "->" + tempV);
		}
		System.out.println("-----------------------------------");
		
		Purchase p1 = new Purchase("1234 1234 1234 1234", new ArrayList<Vehicle>(Arrays.asList(bus1)));
		Purchase p2 = new Purchase("00", new ArrayList<Vehicle>(Arrays.asList(bus1, bus2, bus3, tr2)));
		
		allPurchases.addAll(Arrays.asList(p1, p2));
		
		for(Purchase tempP : allPurchases) {
			System.out.println(tempP.getClass().getName() + "->" + tempP);
		}
		System.out.println("-----------------------------------");
		
		try {
			System.out.println("GetbyID: " + getBusByID(2));
			System.out.println("GetbyCode: " + getBusByVehicleCode("1_Mercedes"));
			
			System.out.println("-----------------------------------");
			
			createNewBus("Scania", 600000, 10, EnergyType.diesel, 45, false);
			createNewBus("Volvo", 1500, 2, EnergyType.electric, 50, true);
			
			
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			System.out.println("-----------------------------------");
			System.out.println("Only Buses:");
			getAllBusses();
			System.out.println("-----------------------------------");
			
			System.out.println("Delete bus by ID:");
			
			deleteBusById(1);
			getAllBusses();
			
			System.out.println("-----------------------------------");
			
			System.out.println("Update bus by ID:");
			
			updateBusById(5, 550000, 10, 47);
			getAllBusses();
			
			System.out.println("-----------------------------------");
			System.out.println("Vehicles with price under 10000");
			showVehiclesIfPriceLessThan10000();
			
			
			
			
			
		}
		 catch (Exception e) {
				System.out.println(e);
			}
	
	}
	
	//CRUD
	public static Bus getBusByID(int inputBusID) throws Exception{
		if(inputBusID < 0) throw new Exception("Wrong input");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getId() == inputBusID) {
				return (Bus)tempV;
			}
		}
		throw new Exception("Bus is not found");
	}
	
	public static Bus getBusByVehicleCode(String inputID) throws Exception{
		if(inputID == null) throw new Exception("Wrong input");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getVehicleCode().equals(inputID)) {
				return (Bus)tempV;
			}
		}
		throw new Exception("Bus is not found");
	}
	
	
	
	public static void createNewBus(String title, float price, int quantity, EnergyType eType, int numberOfSeats, boolean hasBaggageDivision) throws Exception {
		//validation
		if(title == null || price < 0 || quantity < 0 || eType == null || numberOfSeats < 0) {
			throw new Exception("Wrong input");
		}
		for (Vehicle tempV : allVehicles) {
			if (tempV instanceof Bus) {
				Bus tempB = (Bus) tempV;

				if (tempB.getTitle().equals(title) && tempB.getPrice() == price && tempB.geteType().equals(eType) && tempB.getNumberOfSeats() == numberOfSeats && tempB.getHasBaggageDivision() == hasBaggageDivision){
					tempB.setQuantity(tempB.getQuantity() + quantity);
					return;
				}
			}
		}
		// if is not: create new bus
		Bus newBus = new Bus(title, price, quantity, eType, numberOfSeats, hasBaggageDivision);
		// store new student in allStudents arrayList
		allVehicles.add(newBus);
		
	}
	
	
	public static void getAllBusses() throws Exception{
		ArrayList<Bus> onlyBuses = new ArrayList<Bus>();
		for(Vehicle tempV : allVehicles) {
			if (tempV instanceof Bus) {
				Bus tempB = (Bus) tempV; 
				onlyBuses.add(tempB);
			}
		}
		
		for(Bus tempB : onlyBuses) {
			System.out.println(tempB.getClass().getName() + "->" + tempB);
		}
	}
	
	public static void deleteBusById(int inputID) throws Exception{
		if(inputID < 0) throw new Exception("Wrong input");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getId() == inputID) {
				allVehicles.remove(tempV);
				return;
			}
		}
		throw new Exception("Bus is not found");
		
	}
	
	public static void updateBusById(int inputID, float price, int quantity, int numberOfSeats) throws Exception{
		if(inputID < 0 || price < 0 || quantity < 0 || numberOfSeats < 0) throw new Exception("Wrong input");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getId() == inputID) {
				Bus tempB = (Bus) tempV; 
				tempB.setPrice(price);
				tempB.setQuantity(quantity);
				tempB.setNumberOfSeats(numberOfSeats);
				return;
			}
		}
		throw new Exception("Bus is not found");
		
	}
	
	/*
	 Create a function showVehiclesIfPriceLessThan10000() that filters and
returns only those vehicles with a price up to 10 000 EUR (not included).
In this case, the detailed information should be returned, regardless of the
vehicle type (Bus or Tractor).
	 */
	public static void showVehiclesIfPriceLessThan10000() {
		for(Vehicle tempV: allVehicles) {
			if(tempV.getPrice() < 10000) {
				System.out.println(tempV);
			}
		}
		return;
	}
	
	/*
	 *Create a function howManyVehiclesAreBought() that calculates and returns
how many vehicles have been bought in the lifetime of the store.
Remember that a customer can buy multiple vehicles in one purchase,
because each Purchase object stores a list of Vehicle objects or purchased
vehicles. 
	 *
	 */
	
	public static void  howManyVehiclesAreBought() {
		for() {
			
		}
	}
	
	

}

