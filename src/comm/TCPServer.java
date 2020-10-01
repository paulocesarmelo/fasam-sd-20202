package comm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	static int serverPort = 7896;
	
	public static void main(String args[]) {
		
		try {
			ServerSocket listenSocket = new ServerSocket(serverPort);
			
			System.out.println("Ouvindo na porta: "+serverPort);
			
			while(true) {
				
				System.out.println("Aguardando conexão ...");
				Socket clientSocket = listenSocket.accept(); //estabeleço conexão
				
				System.out.println("Conexão estabelecida!");
				
				//Parte referente a connexão
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
				
				String data = in.readUTF();
				
				out.writeUTF(data);
				System.out.println("Msg recebida: "+data);
			
				clientSocket.close();
			}
			
		} catch (IOException e) {
			System.out.println("Listen: "+e.getMessage());
		}
		
	}
	
	
}
