package p2p;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Usuario {

	public static void main(String[] args) throws IOException {
		Scanner intScanner = new Scanner(System.in);	//
		Scanner strScanner = new Scanner(System.in);	//talvez colocar isso na classe usuario e passar
		System.out.println("Insira o numero da porta"); //como parametro o n da porta e o endereço de destino
		//int port = intScanner.nextInt();				//
		System.out.println("Insira o endereco");
		//String address = strScanner.nextLine();			//
		
		int port = 8000;
		String address = "127.0.0.1";
		
		ServerSocket srvSocket = new ServerSocket(port);//servidor
		Socket socket = new Socket(address, port);//client
		
		Entrada server = new Entrada(socket,srvSocket);//servidor
		
		Saida client = new Saida(socket);// cliente
		
		Thread s = new Thread(server);
		Thread c = new Thread(client);
		
		s.start();
		c.start();
	}

}
