import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class PasajesGUI extends JFrame {
    private Image imagenfondo1;
    private JPanel panel1;
    private String Origen,Destino,fechas;
    private JButton botonComprar;
    private Filtro_Pasajes filtro;
    private AsientoGUIFactory factory;
    public PasajesGUI() {
        setTitle("Mi compra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setResizable(false);

        imagenfondo1 = new ImageIcon("src/dibujos/autobus.png").getImage();
        imagenfondo1 = imagenfondo1.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        JLabel principal = new JLabel(new ImageIcon(imagenfondo1));
        setContentPane(principal);

        panel1 = new JPanel();
        panel1.setBounds(850, 398, 200, 30);
        panel1.setOpaque(false);

        filtro= new Filtro_Pasajes();
        factory = new AsientoGUIFactory();
    }
    public void mostrarDatos() {
        List<DatosViaje> listaFiltrada= filtro.getListaFiltrada();

        int[] x = {300,550,300,550};
        int[] y = {275, 275, 305,305};
        int buttonX = 900;
        int buttonY = 290;

        JLabel[] labels = new JLabel[4];

        for (DatosViaje datosViaje : listaFiltrada) {
            String destino=datosViaje.getDestino();
            String origen= datosViaje.getOrigen();
            String hora=datosViaje.getSalida();
            String asiento=datosViaje.getTipoAsiento();
            int precio=datosViaje.getPrecio();

            labels[0] = new JLabel("Origen: " + origen);
            labels[1]= new JLabel("Salida: " + hora);
            labels[2]= new JLabel("Destino: " + destino);
            labels[3]= new JLabel("Tipo de Asiento: " + asiento);

            for (int j = 0; j < 4; j++) {
                labels[j].setForeground(new Color(35, 35, 35)); // Color de fuente
                Font font = labels[j].getFont();
                Font fontNueva = font.deriveFont(font.getSize() + 2.0f); // Tamaño de la fuente
                labels[j].setFont(fontNueva);
                labels[j].setBounds(x[j], y[j], 600, 30);
                add(labels[j]);
            }

            for(int i=0;i<4;i++){
                y[i]+=90;
            }

            botonComprar = new JButton("Comprar");
            botonComprar.setFont(botonComprar.getFont().deriveFont(Font.PLAIN)); // Cambiar el estilo de fuente del botón
            botonComprar.setBounds(buttonX, buttonY, 100, 30);
            add(botonComprar);

            if(asiento.equals("Salon cama")){
                botonComprar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        GuardaDatos.guardarDatosT(origen,Destino,fechas,hora,asiento,precio);
                        factory.crearAsientoGUI("Salon cama");
                        factory.UsarAsientoGUI();
                    }
                });
            } else if (asiento.equals("Semi cama")) {
                botonComprar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        GuardaDatos.guardarDatosT(origen,Destino,fechas,hora,asiento,precio);
                        factory.crearAsientoGUI("Semi cama");
                        factory.UsarAsientoGUI();
                    }
                });

            }
            buttonY += 90;
        }
    }
    public void ImplementarFiltro() {
        Origen = filtro.getOrigen();
        Destino = filtro.getDestino();
        fechas = filtro.getFecha();

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
}
