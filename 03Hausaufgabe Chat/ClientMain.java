package Hausaufgabe;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	private boolean isRunning = true;

	public void createClient() {

		try {
			// Client braucht IP und Port
			Socket socket = new Socket("127.0.0.1", 3445);

			// writer & Reader
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());

			System.out.println("Please Tell me");
			writeMessage(printWriter);
			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			// wir lesen ne Nachricht �ber die Tastatur ein und schreiben sie als Text weg

			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeMessage(PrintWriter printWriter) {
		new Thread(new Runnable() { // so kann man threads auch deklarieren, gibt aber weniger M�glichkeiten als
									// normal
			@Override
			public void run() {
				Scanner keyboard = new Scanner(System.in);
				while (isRunning) {
					String text = keyboard.next();
					if (text.equalsIgnoreCase("Quit")) {
						isRunning = false;

					} else {
						printWriter.println(text);
						printWriter.flush();
					}

				}
				keyboard.close(); // man beachte hier die Klammersetzung, die geh�rt tats�chlich so
			}
		}).start();
	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}
/*
 * NextLine liest zum n�chsten Zeilenende (Enter) Next liest bis zum n�chsten
 * WhiteSpace
 */