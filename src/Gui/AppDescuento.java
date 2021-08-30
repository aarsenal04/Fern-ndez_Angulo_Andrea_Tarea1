package gui;

import sockets_uwu.Cliente;
import sockets_uwu.Servidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
        setSize(500,500);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(i == 0){
            c = new Cliente(textPane1);
            Thread threadCliente = new Thread(c);
            threadCliente.start();
        }else{
            s = new Servidor(textPane1);
            Thread threadCliente = new Thread(s);
            threadCliente.start();

        }

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String msg = "";
                msg = "C#" + textField1.getText() + "#" + textField2.getText() + "#" + textField3.getText();

                if(selecter == 0){
                    textPane1.setText(textPane1.getText() + "\n" + "[Client] The value are: " + textField1.getText() + " " + textField2.getText() + " " + textField3.getText());
                    c.Send(msg);
                }else{
                    try {
                        s.Send(msg);
                        textPane1.setText(textPane1.getText() + "\n" + "[Server] The value are: " + textField1.getText() + " " + textField2.getText() + " " + textField3.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }


            }
        });
    }


}
