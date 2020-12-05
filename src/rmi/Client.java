package rmi;

import rmi.InterfaceX;

public class Client {

	public static void main(String[] args) {
		
		InterfaceX obj = MyRegistry.getReference("firstObj"); //proxy -> client stup
		
		obj.m1();
		
	}
	
}
