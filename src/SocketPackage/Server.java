package SocketPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	Server(){
		String str="";
		try {
			ServerSocket server = new ServerSocket(22000);
			System.out.println("Server is waiting for connection requests...");
			while(true) { //open multiple client connections
				//Listen
				Socket client = server.accept();
				DataInputStream clientReadSource = new DataInputStream(client.getInputStream());
				DataOutputStream clientWriteSource = new DataOutputStream(client.getOutputStream());
				clientWriteSource.writeUTF("Server said: Hello, You are now connected...");
				while(true) {
					try {
						str = clientReadSource.readUTF();
						System.out.println("Client said: " + str);
						if(str.equals("exit")) {
							break;
						}
						clientWriteSource.writeUTF("What next?");
					}catch(EOFException e) {
						System.out.println("Connection closed by client.");
						break;
					}
				}
				clientWriteSource.close();
				clientReadSource.close();
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
