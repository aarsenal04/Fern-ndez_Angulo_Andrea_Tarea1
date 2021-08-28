package sockets_uwu;

import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private final int PUERTO = 5000;

    public String msg;
    public ServerSocket ss;
    public Socket socket;
    public DataOutputStream out;
    public DataInputStream in;

    public void Start() throws IOException {
        try {
            ss = new ServerSocket(this.PUERTO); //Crea el server socket
            System.out.println("Esperando a que el cliente se conecte...");

            this.socket = ss.accept(); //Espera a que un ÚNICO CLIENTE se conecte
            System.out.println("cliente conectado :)");

            out = new DataOutputStream(this.socket.getOutputStream()); //Para enviar datos
            in = new DataInputStream(this.socket.getInputStream()); // Para recibir datos

            while (true) {

                this.msg = in.readUTF(); //Lee el dato que recibe

                String[] datos = this.msg.split("#");

                int valor = Integer.parseInt(datos[0]);
                int peso = Integer.parseInt(datos[1]);
                int impuesto = Integer.parseInt(datos[2]);

                double monto = (valor*(impuesto/100))+(peso*0.15);

                out.writeUTF(String.valueOf(monto)); //Envía el mensaje
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}