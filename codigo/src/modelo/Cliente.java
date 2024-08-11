package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente /*implements Runnable*/ {

    private int puerto;
    private String[] mensaje;

    public Cliente(){
        
    }

    public Cliente(int puerto, String[] mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    public void Conectar(String[] mensaje){

        try {
            // enviar mensaje
            DatagramSocket socket = new DatagramSocket();
            /*Scanner consola = new Scanner(System.in);
            System.out.print("Ingresar mensaje: ");
            String mensaje = consola.nextLine();*/

            String nuevomensaje = String.join(",",mensaje);
            System.out.println(nuevomensaje);

            byte[] buffer = nuevomensaje.getBytes();
            InetAddress nodo_address = InetAddress.getByName("localhost");
            int nodo_port = this.puerto;
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, nodo_address, nodo_port);
            socket.send(packet);
            System.out.println("Mensaje enviado: " + mensaje);
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setPuerto(int puerto){
        this.puerto=puerto;
    }

    private static byte[][] convertToBytes(String[] strings) {
    byte[][] data = new byte[strings.length][];
    for (int i = 0; i < strings.length; i++) {
        String string = strings[i];
        data[i] = string.getBytes(Charset.defaultCharset()); // you can chose charset
    }
    return data;
}
    
}