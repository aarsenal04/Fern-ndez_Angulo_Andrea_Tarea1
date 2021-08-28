package sockets_uwu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente {

    private Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;
    private int puerto = 5000;
    private String host = "localhost";

    public void Start(){

        try{

            this.cliente = new Socket(this.host,this.puerto); //Creo el cliente
            this.in = new DataInputStream(cliente.getInputStream()); //objeto para recibir datos
            this.out = new DataOutputStream(cliente.getOutputStream()); //objeto para enviar

            while (true) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Ya tenemos el "lector"

                System.out.println("Digite los valores de la forma: V#P#I");//Se pide un dato al usuario

                String nombre = br.readLine(); //Se lee el nombre con readLine() que retorna un String con el dato

                this.out.writeUTF(nombre); //Envío datos --> "5#1#6"

                String msg = in.readUTF(); //recibo datos

                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}