
public class Main {
    public static void main(String[] args)  {
        InterfazGrafica interfaz = new InterfazGrafica();
        interfaz.setVisible(true);
        interfaz.BarrasSeleccion();
        GuardaDatos.crearArchivo();
        GuardaDatos.crearArchivo2();
        GuardaDatos.crearArchivo3();
    }
}