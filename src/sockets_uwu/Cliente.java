package sockets_uwu;

import java.io.*;
import java.net.Socket;


public class Cliente implements Runnable{

    private Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;
    private int puerto = 5000;
    private String host = "localhost";

    public Cliente(){
        try {
            this.cliente = new Socket(this.host,this.puerto); //Creo el cliente
            this.in = new DataInputStream(cliente.getInputStream()); //objeto para recibir datos
            this.out = new DataOutputStream(cliente.getOutputStream()); //objeto para enviar
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true){
            try {
                String msg = in.readUTF();
                String valores[] = msg.split("#");

                if (valores[0].equals("C")) {
                    int valor = Integer.parseInt(valores[1]);
                    int peso = Integer.parseInt(valores[2]);
                    int impuesto = Integer.parseInt(valores[3]);
                    double monto = (valor*(impuesto/100))+(peso*0.15);
                    this.Send("M#"+String.valueOf(monto));
                } else {
                    //Aquí debe ir la llamada al método donde se mostraría el valo en la GUI.
                    System.out.println(valores[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    public void Send(String msg){

        try {
            while (true){

                this.out.writeUTF(msg); //Envio datos --> "5#1#6"
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
