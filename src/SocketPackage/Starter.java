package SocketPackage;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		if(scan.next().equals("server")) {
			//Server Code
			Server s = new Server();
		}else {
			//Client Code
			Client c = new Client();
		}
		
		
	}

}
