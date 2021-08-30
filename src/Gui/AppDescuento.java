package Gui;

import sockets_uwu.Cliente;
import sockets_uwu.Servidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**

 * La interfaz se realizó con Java Swing.
 * Esta clase se define como {@link AppDescuento} con sus respectivos sockets y funcionalidades.
 * Como se menciona en el Main, esta ventana surge de la acción en los botones de cliente y servidor.
 * Contiene las entradas de texto para valor, peso y tax (impuesto).
 * Contiene la entrada del chat por donde se intercambia la información requerida.

 */

public class AppDescuento extends JFrame{

    private JPanel VentanaC;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextPane textPane1;
    private JButton enviarButton;
    private Cliente c;
    private Servidor s;

    public AppDescuento(int i, String title){

        int selecter = i;

        setContentPane(VentanaC);
        setSize(500,500); // tamaño de la ventana
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // para poder cerrar la ventana

        if(i == 0){
            c = new Cliente(textPane1);
            Thread threadCliente = new Thread(c); // hilo del cliente
            threadCliente.start();
        }else{
            s = new Servidor(textPane1);
            Thread threadCliente = new Thread(s); // hilo del servidor
            threadCliente.start();

        }

        enviarButton.addActionListener(new ActionListener() { // capta acciones
            @Override
            public void actionPerformed(ActionEvent e) {

                String msg = "";
                msg = "C#" + textField1.getText() + "#" + textField2.getText() + "#" + textField3.getText();

                if(selecter == 0){
                    textPane1.setText(textPane1.getText() + "\n" + "[Client] The value are: " + textField1.getText() + " " + textField2.getText() + " " + textField3.getText()); // valor enviado por el cliente
                    c.Send(msg);
                }else{
                    try {
                        s.Send(msg);
                        textPane1.setText(textPane1.getText() + "\n" + "[Server] The value are: " + textField1.getText() + " " + textField2.getText() + " " + textField3.getText()); // valor enviado por el servidor
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }


            }
        });
    }


}
