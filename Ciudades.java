import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Ciudades {
    private ArrayList<String> ciudades;

    private ArrayList<String> Archivo(String archivoTexto) {
        ArrayList<String> datos = new ArrayList<>();
        File archivo = new File(archivoTexto);

        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                datos.add(linea);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return datos;
    }
    public Ciudades(String archivoTexto) {
        ciudades = Archivo(archivoTexto);
    }

    public ArrayList<String> getCiudades() {
        return ciudades;
    }
    public void eliminarCiudad(String ciudad) {
        ciudades.remove(ciudad);
    }
}
