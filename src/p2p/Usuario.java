package p2p;

import java.io.IOException;
import java.net.BindException;
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
		
		int port = 8001;
		int port2 = 8000;
		String address = "127.0.0.1";
		
		
		try{	
			ServerSocket tmpsocket = new ServerSocket(port2);//define a porta
			String a = strScanner.nextLine();
			Socket socketClient = new Socket(address,port);
			while(true){
				//System.out.println("aguardando cliente");
				Socket socket = tmpsocket.accept();
				Entrada multUser = new Entrada(socket);
				
				Saida s = new Saida(socketClient);
				
				Thread k = new Thread(s);
				
				Thread t = new Thread(multUser);//thread para cada cliente
				t.start();
				k.start();
			}
			
		}catch (BindException e){
			System.out.println("Endereco em uso"); 
		}catch (Exception e){
			System.out.println("erro " + e);
		};
	}

}
