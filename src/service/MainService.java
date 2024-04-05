package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Bus;
import model.Tractor;
import model.Vehicle;
import model.EnergyType;

public class MainService {
	
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	
	public static void main(String[] args) {
		
		
		Bus Bus1 = new Bus();
		Bus bus2 = new Bus("Mercedes", 100000, 1, EnergyType.petrol, 47, true);
		
		
		Tractor tr1 = new Tractor();
		Tractor tr2 = new Tractor("CAT", 1500000, 2, EnergyType.gas, "Tilling", true);
		
		allVehicles.addAll(Arrays.asList(Bus1, bus2, tr1, tr2));
		
		for(Vehicle tempV : allVehicles) {
			System.out.println(tempV.getClass().getName() + "->" + tempV);
		}
		
		try {
			
		}
		 catch (Exception e) {
				System.out.println(e);
			}
	
	}
}
