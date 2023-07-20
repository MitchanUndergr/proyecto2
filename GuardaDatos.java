import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardaDatos {

    private static final String PRIMER_ARCHIVO = "src/Archivos/filtro_pasajes.txt";
    private static final String SEGUNDO_ARCHIVO = "src/Archivos/filtro_asientos.txt";
    private static final String TERCER_ARCHIVO = "src/Archivos/DatosPasaje.txt";


    // Variable estática para controlar si el archivo ya ha sido creado
    private static boolean archivoCreado = false;
    private static boolean archivoCreado2 = false;
    private static boolean archivoCreado3 = false;

    // Método para crear el archivo (solo se debe llamar una vez)
    public static void crearArchivo() {
        try {
            File file = new File(PRIMER_ARCHIVO);
            if (file.exists()) {
                // Vaciar el contenido del archivo si ya existe
                FileWriter writer = new FileWriter(PRIMER_ARCHIVO);
                writer.write(""); // Escribe una cadena vacía para borrar el contenido
                writer.close();
                System.out.println("Archivo vaciado exitosamente: " + file.getAbsolutePath());
            } else {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado exitosamente en: " + file.getAbsolutePath());
                    archivoCreado = true;
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void crearArchivo2() {
        try {
            File file = new File(SEGUNDO_ARCHIVO);
            if (file.exists()) {
                // Vaciar el contenido del archivo si ya existe
                FileWriter writer = new FileWriter(SEGUNDO_ARCHIVO);
                writer.write(""); // Escribe una cadena vacía para borrar el contenido
                writer.close();
                System.out.println("Archivo vaciado exitosamente: " + file.getAbsolutePath());
            } else {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado exitosamente en: " + file.getAbsolutePath());
                    archivoCreado2 = true;
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivo3() {
        try {
            File file = new File(TERCER_ARCHIVO);
            if (file.exists()) {
                // Vaciar el contenido del archivo si ya existe
                FileWriter writer = new FileWriter(TERCER_ARCHIVO);
                writer.write(""); // Escribe una cadena vacía para borrar el contenido
                writer.close();
                System.out.println("Archivo vaciado exitosamente: " + file.getAbsolutePath());
            } else {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado exitosamente en: " + file.getAbsolutePath());
                    archivoCreado3 = true;
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para escribir en el primer archivo
    public static void guardarDatosU(String origen, String destino, String fecha) {
        try {
            FileWriter writer = new FileWriter(PRIMER_ARCHIVO, true); // true para escribir al final del archivo
            writer.write(origen + ",");
            writer.write(destino + ",");
            writer.write(fecha + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para escribir en el segundo archivo
    public static void guardarDatosD(String origen, String destino, String fecha, String Hora, String Tasiento, int precio, ArrayList<String> datos) {
        try {
            FileWriter writer = new FileWriter(SEGUNDO_ARCHIVO, true); // true para añadir al final del archivo
            writer.write(origen + ",");
            writer.write(destino + ",");
            writer.write(fecha + ",");
            writer.write(Hora + ",");
            writer.write(Tasiento + ",");
            writer.write(precio + ",");

            // Recorrer los datos
            for (int i = 0; i < datos.size(); i++) {
                String dato = datos.get(i);
                writer.write(dato);

                // Si no es el último dato, escribir un espacio
                // Si es el último dato, escribir un salto de línea
                if (i < datos.size() - 1) {
                    writer.write(" ");
                } else {
                    writer.write("\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosT(String origen, String destino, String fecha, String horario, String Tasiento, int precio) {
        try {
            FileWriter writer = new FileWriter(TERCER_ARCHIVO, true); // true para añadir al final del archivo
            writer.write(origen + ",");
            writer.write(destino + ",");
            writer.write(fecha + ",");
            writer.write(horario + ",");
            writer.write(Tasiento + ",");
            writer.write(precio + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



