package Hausaufgabe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServerMain1 {
	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
	ArrayList<PrintWriter> writers= new ArrayList<>(); //weil mehrere Clients
	ArrayList<ConnectionThread> connections= new ArrayList<>(); // same, brauchen für jeden Client eine eigene Verbindung
	
	public void createServer() {
		int zugelassen=42;
		try {
			ServerSocket socket=new ServerSocket(3445,zugelassen);
			for(int i=0; i<42; i++) {
				connections.add(new ConnectionThread(queue, socket, writers));
				connections.get(i).start();
				System.out.println("Läuft bei uns"+i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static void main(String[] args) {
	    	ServerMain1 server = new ServerMain1();
	    	server.createServer();
	    }
}
