package Ejercicio2;

import java.net.*;
import java.util.Scanner;
import java.io.*;


public class ClienteEco { 
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Bienvenidos a la caza de Fantasmas");
		System.out.println("Asi Funcionan las reglas del juego: ");
		System.out.println("Cada jugador tendra un tablero de 10x10 con un fantasma oculto");
		System.out.println("las cordenadas seran de la A a la J y del 1 al 10");
		System.out.println("Ejemplo: B2");
		System.out.println("Cada jugador tendra una cordenada para adivinar por turno");
		System.out.println("Quien la encuentre antes gana");
		
		String host = "localhost";
		int puerto = 1234;
		
		try (Socket socket = new Socket(host, puerto)){
			BufferedReader entrsdaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salidaServidor = new PrintWriter(socket.getOutputStream(), true);
			
			boolean partidaTerminada = false;
			
			while(!partidaTerminada) {
				System.out.print("Escribe la coordenada: ");
				String coordenada = in.nextLine();
				
				salidaServidor.print(coordenada);
				
				String respuesta = entrsdaServidor.readLine();
				
				System.out.println("Servidor: " + respuesta);
				
				if(respuesta != null && (respuesta.contains("Fin del juego") || respuesta.contains("derrota"))) {
					partidaTerminada = true;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}