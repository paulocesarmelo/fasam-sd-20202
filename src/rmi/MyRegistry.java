package rmi;

import java.util.HashMap;

public abstract class MyRegistry {

	private static HashMap<String, InterfaceX> map;
	
	
	//client
	public static InterfaceX getReference(String name) {
		return map.get(name);
	}
	
	//server
	public static void setReference(InterfaceX obj, String name) {
		map.put(name, obj);
	}
	
}
