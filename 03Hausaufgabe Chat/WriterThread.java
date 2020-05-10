package Hausaufgabe;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread{
	private BlockingQueue<String> queue;
	private boolean isRunning=true;
	private ArrayList<PrintWriter> writerlist= new ArrayList<>();
	
	public WriterThread(BlockingQueue<String> queue, ArrayList<PrintWriter> writerlist) {
		super();
		this.queue = queue;
		this.writerlist = writerlist;
	}
	@Override
	public void run(){
		while(isRunning) {
			try {
				System.out.println("Warte auf Nachricht");
				String message = queue.take();
				System.out.println("Nachricht "+ message + "Writercount"+ writerlist.size());
				for (PrintWriter i : writerlist) {
					i.println(message);
					i.flush();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void stopWT() {
		isRunning= false;
	}
}
