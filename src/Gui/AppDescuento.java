package Gui;

import javax.swing.*;

public class AppDescuento extends JFrame {

    private JPanel VentanaC;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextPane textPane1;
    private JButton enviarButton;

    public AppDescuento(){

        setContentPane(VentanaC);
        setSize(500,500);
        setTitle("Ventana Servidor y Cliente");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){

        AppDescuento myframe = new AppDescuento();

    }

}
