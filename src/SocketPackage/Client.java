package SocketPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Client(){
		try {
			InetAddress ip = InetAddress.getLocalHost();
			Socket other = new Socket(ip,22000);
			Scanner scan = new Scanner(System.in);
			DataInputStream otherReadSource = new DataInputStream(other.getInputStream());
			DataOutputStream otherWriteSource = new DataOutputStream(other.getOutputStream());
			String str = "";
			while(true) {
				str = otherReadSource.readUTF();
				System.out.println(str);
				str = scan.nextLine();
				if (str.equals("exit")) {
					otherWriteSource.close();
					otherReadSource.close();
					other.close();
					break;
				}
				otherWriteSource.writeUTF(str);
				System.out.println(str);
				
				
				
			}
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
