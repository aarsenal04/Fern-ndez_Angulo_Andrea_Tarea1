package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Gui.AppDescuento;

public class selecter extends JFrame{

    private JButton clienteButton;
    private JPanel Canva;
    private JButton servidorButton;

    public selecter() {

        JFrame app = new JFrame("Selección");

        app.setContentPane(Canva);
        app.setSize(500,500);
        app.setTitle("Ventana Servidor y Cliente");
        app.setVisible(true);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                app.dispose();
                AppDescuento app = new AppDescuento(0,"Cliente");
            }
        });
        servidorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                app.dispose();
                AppDescuento app = new AppDescuento(1,"Servidor");;
            }
        });
    }
}
