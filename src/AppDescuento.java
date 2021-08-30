import javax.swing.*;

public class AppDescuento extends JFrame {

    private JPanel VentanaC;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel Clientelabel;
    private JLabel Servidorlabel;

    public AppDescuento(){

        setContentPane(VentanaC);
        setSize(500,400);
        setTitle("Ventana Servidor y Cliente");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){

        AppDescuento myframe = new AppDescuento();

    }

}
