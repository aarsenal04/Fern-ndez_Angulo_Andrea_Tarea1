package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**

 * La interfaz se realizó con Java Swing.
 * Esta clase se define como {@link selecter} con sus respectivos sockets y funcionalidades.
 * Como se menciona en el Main, el selecter es la primer ventana que aparece.
 * Contiene los botones de Cliente y Servidor

 */

public class selecter extends JFrame{

    private JButton clienteButton;
    private JPanel Canva;
    private JButton servidorButton;

    public selecter() {

        JFrame app = new JFrame("Selección");

        app.setContentPane(Canva);
        app.setSize(500,500); // tamaño de la ventana axh
        app.setTitle("Ventana Servidor y Cliente");
        app.setVisible(true);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // para poder cerrar la ventana

        clienteButton.addActionListener(new ActionListener() { // capta la acción
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                app.dispose();
                AppDescuento app = new AppDescuento(0,"Cliente"); // botón de cliente
            }
        });
        servidorButton.addActionListener(new ActionListener() { // capta la acción
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                app.dispose();
                AppDescuento app = new AppDescuento(1,"Servidor"); // botón de servidor
            }
        });
    }
}
