package comm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	static int port = 6789;
	
	public static void main(String args[]) {
		
		DatagramSocket aSocket = null;
		
		try {
			aSocket = new DatagramSocket(port);
			
			byte[] buffer = new byte[1024];
			
			while(true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length); // formato da requisição
				
				System.out.println("Esperando por datagrama UDP na porta " + port);
				
				aSocket.receive(request); // estado de espera
				
				System.out.print("Datagrama UDP recebido...");
				
				System.out.println(new String(request.getData()));
				
				System.out.println("Endereço: "+request.getAddress());
				
				DatagramPacket reply = new DatagramPacket(request.getData(),
						request.getLength(), request.getAddress(), request.getPort());
				
				System.out.println("Enviando...");
				
				aSocket.send(reply);
				
				System.out.println("Ok");
				
			}
					
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
