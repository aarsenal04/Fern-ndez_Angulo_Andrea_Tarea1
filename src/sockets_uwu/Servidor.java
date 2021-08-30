package sockets_uwu;

import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{

    private final int PUERTO = 5000;

    public String msg;
    public ServerSocket ss;
    public Socket socket;
    public DataOutputStream out;
    public DataInputStream in;

    public Servidor(){

        try {
            ss = new ServerSocket(this.PUERTO); //Crea el server socket
            System.out.println("Esperando a que el cliente se conecte");

            this.socket = ss.accept(); //Espera a que un ÚNICO CLIENTE se conecte
            System.out.println("cliente conectado");

            out = new DataOutputStream(this.socket.getOutputStream()); //Para enviar datos
            in = new DataInputStream(this.socket.getInputStream()); // Para recibir datos

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() { // C/M#PESO#Valor#impuesto
        try {

            while (true) {

                this.msg = in.readUTF(); //Lee el dato que recibe

                String valores[] = this.msg.split("#");


                if (valores[0].equals("C")) {
                    System.out.println(valores[0]);
                    int valor = Integer.parseInt(valores[1]);
                    int peso = Integer.parseInt(valores[2]);
                    int impuesto = Integer.parseInt(valores[3]);
                    double monto = (valor*(impuesto/100))+(peso*0.15);
                    this.Send("M#"+String.valueOf(monto));
                } else {
                    //Aquí debe ir la llamada al método donde se mostraría el valo en la GUI.
                    System.out.println(valores[1]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Send(String msg) throws IOException {
        while (true){

            this.out.writeUTF(msg); //Envio datos --> "5#1#6"
        }
    }
}