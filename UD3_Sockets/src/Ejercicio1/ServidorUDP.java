//Autor: Alejandro Muela
package Ejercicio1;

import java.io.IOException;
import java.net.*;

public class ServidorUDP {
	private DatagramSocket socketUDP;
	private DatagramPacket recibido;

//Código reutilizado
	public ServidorUDP(int puerto) {
		try {
			socketUDP = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

//Código reutilizado
	public String recibirMsg() {
		DatagramPacket respuesta = null;
		try {
			byte[] bufer = new byte[1000];
			respuesta = new DatagramPacket(bufer, bufer.length);
			socketUDP.receive(respuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(respuesta.getData()).trim();
	}

//Métodos extra para los hilos para conservar IP y puerto
	public InetAddress getClientAddress() {
		return recibido != null ? recibido.getAddress() : null;
	}

	public int getClientPort() {
		return recibido != null ? recibido.getPort() : 0;
	}

	public void enviarMsgA(String msg, InetAddress ip, int puerto) {
		try {
			DatagramPacket respuesta = new DatagramPacket(msg.getBytes(), msg.length(), ip, puerto);
			socketUDP.send(respuesta);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Servidor cerrado");
		}
	}

	// Ejecutable del servidor con Hilos
	class EcoServidor {
		public static void main(String[] args) {
			int puerto = 5555;
			System.out.println("Servidor: Guardián del cementerio escucha por el puerto" + puerto);
			ServidorUDP canal = new ServidorUDP(puerto);
			// El cliente se inicia enviando su nombre
			String nombreEspiritu = canal.recibirMsg();
			System.out.println("El fantasma " + nombreEspiritu + " ha cruzado el velo.");
			//Hilo de escucha
			Thread hiloLectura = new Thread(());
		}
	}
}
