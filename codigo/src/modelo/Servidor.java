package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.Receiver;

public class Servidor  /*implements Runnable*/ {

    private int puerto;

    public Servidor(){
        
    }

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void Conectar(){
        try {
            DatagramSocket socket = new DatagramSocket(this.puerto);
            System.out.println("Receiver is working...");

            // Request
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String mensaje = (new String(buffer)).trim();
            String[] nuevoMensaje = mensaje.split(",");
            System.out.println("Mensaje recibido: " + nuevoMensaje[0]);
            System.out.println("Mensaje recibido: " + nuevoMensaje[1]);
            
            // Response
            /*Scanner consola = new Scanner(System.in);
            System.out.print("Ingresar mensaje: ");
            mensaje = consola.nextLine();

            InetAddress nodo_address = packet.getAddress();
            int nodo_port = packet.getPort();
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, nodo_address, nodo_port);
            socket.send(packet);
            System.out.println("Mensaje enviado: " + mensaje);

            consola.close();*/
            socket.close();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setPuerto(int puerto){
        this.puerto=puerto;
    }
    
}
