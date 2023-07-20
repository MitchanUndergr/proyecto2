import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReservaGUI extends JFrame {
    private Image imagenfondo1;
    private int calFinal,precio,cantAsientos;
    private String Asientoreservado, Origen, Destino, fechas,Hora,Tasiento;
    private JPanel panel1;
    private Reserva reserva;
    public ReservaGUI() {

        setTitle("Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setResizable(false);

        imagenfondo1 = new ImageIcon("src/dibujos/compra.png").getImage();
        imagenfondo1 = imagenfondo1.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        JLabel principal = new JLabel(new ImageIcon(imagenfondo1));
        setContentPane(principal);

        reserva= new Reserva();

    }
    public void ImplementarFiltro(){
        Origen = reserva.getOrigen();
        Destino =reserva.getDestino();
        fechas = reserva.getFechas();
        Hora= reserva.getHora();
        Tasiento=reserva.getTipoasiento();
        precio=reserva.getPrecio();

        JLabel origen1 = new JLabel(Origen);
        origen1.setForeground(new Color(35, 35, 35)); // Color de fuente
        Font font = origen1.getFont();
        Font fontNueva = font.deriveFont(font.getSize() + 2.0f); // Tamaño de la fuente
        origen1.setFont(fontNueva);
        origen1.setBounds(95, 110, 100, 30);
        add(origen1);

        JLabel destino = new JLabel(Destino);
        destino.setForeground(new Color(35, 35, 35)); // Color de fuente
        Font font2 = destino.getFont();
        Font fontNueva2 = font2.deriveFont(font.getSize() + 2.0f); // Tamaño de la fuente
        destino.setFont(fontNueva2);
        destino.setBounds(285, 110, 100, 30);
        add(destino);

        JLabel fecha = new JLabel(fechas);
        fecha.setForeground(new Color(35, 35, 35)); // Color de fuente
        Font font3 = fecha.getFont();
        Font fontNueva3 = font3.deriveFont(font.getSize() + 2.0f); // Tamaño de la fuente
        fecha.setFont(fontNueva3);
        fecha.setBounds(470, 110, 100, 30);
        add(fecha);
    }
    public void MuestraReserva(Asientos asientosreservados){
        JLabel[] labels = new JLabel[7];
        ArrayList<String> aux=null;

        if(asientosreservados.getSeleAsientos().size()!=0){
            aux=asientosreservados.getSeleAsientos();
            calFinal= aux.size()*precio;
            Asientoreservado="Semi cama";

        }
        else if(asientosreservados.getSeleasientosdob().size()!=0){
            aux=asientosreservados.getSeleasientosdob();
            calFinal= aux.size()*precio;
            Asientoreservado="Salon cama";
        }

        cantAsientos=aux.size();

        Font fontNueva = new Font("Arial", Font.BOLD, 16);
        labels[1]= new JLabel("DETALLES DE LA COMPRA");
        labels[1].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[1].setFont(fontNueva);
        labels[1].setBounds(300, 350, 600, 30);
        add(labels[1]);

        labels[2]= new JLabel("Tipo de Asiento: " + Asientoreservado);
        labels[2].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[2].setFont(fontNueva);
        labels[2].setBounds(300, 400, 600, 30);
        add(labels[2]);

        labels[3]= new JLabel("Asientos : " + aux);
        labels[3].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[3].setFont(fontNueva);
        labels[3].setBounds(300, 450, 600, 30);
        add(labels[3]);

        labels[4]= new JLabel("Cantidad de asientos: " + cantAsientos + " x " + precio);
        labels[4].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[4].setFont(fontNueva);
        labels[4].setBounds(300, 500, 600, 30);
        add(labels[4]);

        labels[5]= new JLabel("Precio final: " + calFinal);
        labels[5].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[5].setFont(fontNueva);
        labels[5].setBounds(300, 550, 600, 30);
        add(labels[5]);

        labels[6]= new JLabel("Hora de Salida: " + Hora);
        labels[6].setForeground(new Color(35, 35, 35)); // Color de fuente
        labels[6].setFont(fontNueva);
        labels[6].setBounds(300, 600, 600, 30);
        add(labels[6]);

        SwingUtilities.invokeLater(() -> {

            int option = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea realizar una nueva compra?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "Sí"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Abrir una nueva interfaz gráfica
                EventQueue.invokeLater(() -> {
                    dispose();
                    InterfazGrafica nuevaInterfaz = new InterfazGrafica();
                    nuevaInterfaz.setVisible(true);
                    nuevaInterfaz.BarrasSeleccion();
                });
            } else {
                // Cerrar la aplicación
                System.exit(0);
            }
        });
    }
}