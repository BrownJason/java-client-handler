package com.cooksys.clienthandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
	Socket client;
	
	public ClientHandler(Socket client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}
	
	public void run() {

		BufferedReader incoming = null;
		try {
			incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Thread.sleep(3000);
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		while(!client.isClosed()) {
			try {
				System.out.println("Message Accepted: " + incoming.readLine() + " from thread " + Thread.currentThread().getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
