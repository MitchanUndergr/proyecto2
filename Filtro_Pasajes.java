import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Filtro_Pasajes {
    private String origen,destino,fecha;

    private List<DatosViaje> listaFiltrada = new ArrayList<>();
    private List<DatosViaje> listaDatos;
    public Filtro_Pasajes(){
        try {
            FileReader fileReader = new FileReader("src/Archivos/filtro_pasajes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            // Variables para almacenar los datos de la última línea
            String ultimoOrigen = null;
            String ultimoDestino = null;
            String ultimaFecha = null;

            while ((linea = bufferedReader.readLine()) != null) {
                // Separar los datos utilizando el carácter de coma como delimitador
                String[] datos = linea.split(",");

                // Almacenar los datos en variables temporales
                ultimoOrigen = datos[0].trim();
                ultimoDestino = datos[1].trim();
                ultimaFecha = datos[2].trim();
            }

            // Actualizar las variables de la instancia con los datos de la última línea
            this.origen = ultimoOrigen;
            this.destino = ultimoDestino;
            this.fecha = ultimaFecha;

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String archivo = "src/Archivos/datos.txt";
        Datos datos = new Datos(archivo);
        listaDatos = datos.leerDatos();
    }

    public List<DatosViaje> getListaFiltrada(){
        for (DatosViaje datosViaje : listaDatos) {
            if (datosViaje.getOrigen().trim().equals(origen.trim()) && datosViaje.getDestino().trim().equals(destino.trim())) {
                listaFiltrada.add(datosViaje);
            }
        }

        return listaFiltrada;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public String getOrigen() {
        return origen;
    }
}
