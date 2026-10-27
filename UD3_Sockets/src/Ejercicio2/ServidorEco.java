package Ejercicio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorEco {
	public static void main(String[] args) {
		int puerto = 1234;
		
		Random random = new Random();
		int filDiana = random.nextInt(10);
		int colDiana = random.nextInt(10);
		System.out.println("coordenada del fantasma generada");
		System.out.println("Servidor iniciado, Esperando a jugador...");
		
		try(ServerSocket svs = new ServerSocket(puerto)){
			Socket socketCliente = svs.accept();
			System.out.println("Jugador conectado desde servidor... " + socketCliente.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
