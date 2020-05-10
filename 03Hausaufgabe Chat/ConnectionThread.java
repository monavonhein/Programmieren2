package Hausaufgabe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread{
	//soll verbindungen akzeptieren und an den server weiterleiten
	//bildet connection zwischen Reader und Writer
	private BlockingQueue<String> queue;
	private ServerSocket s;
	private ArrayList<PrintWriter> writerlist= new ArrayList<>();
	
	public ConnectionThread(BlockingQueue<String> queue, ServerSocket s, ArrayList<PrintWriter> writerlist) {
		super();
		this.queue = queue;
		this.s = s;
		this.writerlist = writerlist;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("waiting for connection");
			Socket socket= s.accept();  									//heißt er verbindet sich mit dem server durch den serversocket
			System.out.println(socket);										//dadurch gibt er an dass das geklappt hat
			Scanner scanner= new Scanner(socket.getInputStream()); 			//das liest die vom Netzwerk empfangenen nachrichten ein
			ReaderThread rt= new ReaderThread(scanner, queue); 				//Das was wir eingelesen haben geben wir an den Reader weiter, dieser ist für nachrichten von client an server verantwortlich
			rt.start();
			System.out.println("rt check");
			PrintWriter writer= new PrintWriter(socket.getOutputStream());	// der leitet das dann an andere CLients weiter
			writerlist.add(writer);											// das klatscht den inhalt dann nochmal in die array List, weil der writerThread den braucht
			System.out.println("wt check");
			//niemals rt.run() machen!, stattdessen start
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
