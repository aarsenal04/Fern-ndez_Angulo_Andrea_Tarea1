import sockets_uwu.Cliente;
import sockets_uwu.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Ya tenemos el "lector"

        System.out.println("S/C");//Se pide un dato al usuario

        String nombre = br.readLine(); //Se lee el nombre con readLine() que retorna un String con el dato

        if(nombre.equals("C")){
            Cliente c = new Cliente();
            Thread threadCliente = new Thread(c);
            threadCliente.start();
            c.Send("");
        }else{
            Servidor s = new Servidor();
            Thread threadServidor = new Thread(s);
            threadServidor.start();
            s.Send("");
        }

    }

}
