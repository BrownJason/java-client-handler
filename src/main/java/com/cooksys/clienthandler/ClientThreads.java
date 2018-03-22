package com.cooksys.clienthandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThreads {
	public static void main(String[] args) throws IOException, InterruptedException {
		String ahh = new String("AHHHHH");
		for(int i =0; i < 10; i++) {
			Socket connection = new Socket("localhost", 10101);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			
			Thread thread = new Thread(new ClientHandler(connection));
			thread.start();
			
			writer.write(ahh + i + "WOOOO\n");
			writer.flush();
		}
	}
}
