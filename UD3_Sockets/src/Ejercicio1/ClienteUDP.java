//Autor: Alejandro Muela
package Ejercicio1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
	private DatagramSocket socketUDP;

	public ClienteUDP() {
		try {
			this.socketUDP = new DatagramSocket();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//Código reutilizado
	public void enviarMsg(String msg, String ip, int puerto) {
		InetAddress hostServidor;
		try {
			hostServidor = InetAddress.getByName(ip);
			byte[] mensaje = msg.getBytes();
			DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
			socketUDP.send(peticion);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void closeClienteUDP() {
		// cierre del socket del cliente original
		socketUDP.close();
		System.out.println("Cliente finalizado.");
	}

//Ejecutable del cliente con hilos
	class Ejecutable {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			ClienteUDP canal = new ClienteUDP();
			String ipServidor = "localhost";
			int puertoServidor = 5555;

			System.out.print("Introcuce tu nombre fantasmal: ");
			String nombreEspiritu = sc.next();
		}
	}
}
