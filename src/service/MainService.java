package service;

import model.Bus;

public class MainService {
	
	public static void main(String[] args) {
		Bus Bus1 = new Bus();
		
		try {
			System.out.println(Bus1);
		}
		 catch (Exception e) {
				System.out.println(e);
			}
	
	}
}
