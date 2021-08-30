package sockets_uwu;

import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;


/**

 * Esta clase se define como  {@link Servidor} con sus respectivos sockets y funcionalidades

 */

public class Servidor implements Runnable{

    private final int PUERTO = 5000; //Puerto para comunicarse con el cliente

    public String msg;
    public ServerSocket ss;
    public Socket socket;
    public DataOutputStream out;
    public DataInputStream in;
    public JTextPane t;

    public Servidor(JTextPane aText){

        t = aText;

        try {
            ss = new ServerSocket(this.PUERTO); //Crea el server socket
            System.out.println("Esperando a que el cliente se conecte");

            this.socket = ss.accept(); //Espera a que un ÚNICO CLIENTE se conecte
            System.out.println("cliente conectado");

            out = new DataOutputStream(this.socket.getOutputStream()); //Para enviar datos
            in = new DataInputStream(this.socket.getInputStream()); // Para recibir datos

        } catch (IOException e) { //por si ocurre algún error
            e.printStackTrace();
        }

    }

    @Override
    public void run() { // C/M#PESO#Valor#impuesto
        try {

            while (true) {

                this.msg = in.readUTF(); //Lee el dato que recibe

                String valores[] = this.msg.split("#"); // para separar los valores por calcular


                if (valores[0].equals("C")) {

                    t.setText(t.getText() + "\n" + "[Client] The value are: " + valores[1] + " " + valores[2] + " " + valores[3]); //quien lo envía y los valores que envía

                    int valor = Integer.parseInt(valores[1]); // el valor que se escribe de primero
                    int peso = Integer.parseInt(valores[2]); // el peso, que se escribe de segundo
                    int impuesto = Integer.parseInt(valores[3]); // el impuesto (tax) que es escribe de tercero
                    double monto = (valor*(impuesto/100))+(peso*0.15); // ecuación que calcula el monto requerido
                    monto = (int)monto; //para que el monto sea entero
                    this.Send("M#"+String.valueOf(monto)); //mensaje que devuelve el monto

                    t.setText(t.getText() + "\n" + "[Server] The value is: " + String.valueOf(monto)); //manera en la que llega el mensaje desde el servidor

                } else {
                    t.setText(t.getText() + "\n" + "[Client] The value is: " + valores[1]);
                    System.out.println(valores[1]);
                }

            }

        } catch (IOException e) { // por si ocurre algún error
            e.printStackTrace();
        }
    }

    public void Send(String msg) throws IOException {

        this.out.writeUTF(msg); //Envio datos --> "5#1#6"

    }

}