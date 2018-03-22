package com.cooksys.clienthandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {
	public static void main(String[] args) throws IOException, InterruptedException {
		try(ServerSocket server = new ServerSocket(10101)){
			while(true) {
				Socket sock = server.accept();
				System.out.println("New Connection: " + sock);
				
				if(sock.isConnected()) {
					Thread clientHandler = new Thread(new ClientHandler(sock));
					clientHandler.start();
				}
			} 
		}
	}
}
