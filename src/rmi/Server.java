package rmi;

public class Server {

	public static void main(String[] args) {
		
		RemoteObject obj = new RemoteObject();
		
		MyRegistry.setReference(obj, "firstObj");
		
	}
	
}
