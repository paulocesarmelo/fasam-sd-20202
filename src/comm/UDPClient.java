package comm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JOptionPane;

public class UDPClient {

	static String server = "localhost";
	static int port = 6789;
	
	public static void main(String args[]) {
		
		DatagramSocket clientSocket = null;
		
		try {
			
			clientSocket = new DatagramSocket();
			
			InetAddress IPAddress = InetAddress.getByName(server);
			
			byte[] message = new byte[1024];
			
			String text = JOptionPane.showInputDialog("Digite o texto a ser enviado ao servidor: ");
			
			message = text.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(message,
					message.length, IPAddress, port);
			
			System.out.println("Enviando pacote UDP para " + server + ":" + port);
			
			clientSocket.send(sendPacket);
			
			byte[] buffer = new byte[1024];
			
			DatagramPacket reply = new DatagramPacket(buffer,
					buffer.length);
			
			clientSocket.receive(reply);
			
			System.out.println("Resposta: "+new String(reply.getData()));
			
			
		}catch(SocketException e) {
			System.out.println("Socket: "+e.getMessage());
		}catch(IOException e) {
			System.out.println("IO: "+e.getMessage());
		}finally {
			clientSocket.close();
			System.out.println("Socket cliente fechado!");
			
		}
		
	}
	
}
