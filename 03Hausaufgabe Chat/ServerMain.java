package Hausaufgabe;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

//import sun.jvm.hotspot.tools.SysPropsDumper;

public class ServerMain {

    public void createServer() {

        // wir wollen n Server erstellen, der ne Verbindung aufbaut, was ausgibt und sie
        // wieder lˆst
        try {
            // beim Port immer ¸ber 1600 liegen & -> 1 l‰sst nur 1 Verbindung zu
            ServerSocket serverSocket = new ServerSocket(3445, 1);
            Socket socket = serverSocket.accept();

            // client soll als erstes was senden, deshalb muss Server als erstes lesen
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            // der Scanner liest Nachrichten aus dem Netzwerk ein
            Scanner scanner = new Scanner(socket.getInputStream());

            // das was wir gelesen haben, schreiben wir in die Konsole
            System.out.println(scanner.nextLine());

            // Printwriter schreibt Hallo Client
            printWriter.println("Hallo Client");
            // schickt die Nachricht wirklich ins Netzwerk, vorher bleibt sie immer lokal
            printWriter.flush();

            // alles schlieﬂen nicht vergessen
            printWriter.close();
            scanner.close();
            socket.close();
            serverSocket.close();

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    public static void main(String[] args) {
    	ServerMain server = new ServerMain();
    	server.createServer();
    }

}