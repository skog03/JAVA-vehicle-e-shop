package service;

import model.Bus;
import model.Tractor;
import model.energyType;

public class MainService {
	
	public static void main(String[] args) {
		Bus Bus1 = new Bus();
		Bus bus2 = new Bus("Mercedes", 100000, 1, energyType.petrol, 47, true);
		
		Tractor tr1 = new Tractor();
		Tractor tr2 = new Tractor("CAT", 1500000, 2, energyType.gas, "Tilling", true);
		
		
		try {
			System.out.println(Bus1);
			System.out.println(bus2);
			System.out.println(tr1);
			System.out.println(tr2);
		}
		 catch (Exception e) {
				System.out.println(e);
			}
	
	}
}
