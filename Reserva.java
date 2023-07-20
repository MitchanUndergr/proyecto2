import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reserva {

    private String Origen,Destino,fechas,Hora,Tipoasiento;
    int precio;
    public Reserva(){
        try {
            FileReader fileReader = new FileReader("src/Archivos/DatosPasaje.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            // Variables para almacenar los datos de la última línea
            String ultimoOrigen = null;
            String ultimoDestino = null;
            String ultimaFecha = null;
            String ultimaHora = null;
            String ultimoTasiento = null;
            int ultimoprecio = 0;

            while ((linea = bufferedReader.readLine()) != null) {
                // Separar los datos utilizando el carácter de coma como delimitador
                String[] datos = linea.split(",");

                // Almacenar los datos en variables temporales
                ultimoOrigen = datos[0].trim();
                ultimoDestino = datos[1].trim();
                ultimaFecha = datos[2].trim();
                ultimaHora = datos[3].trim();
                ultimoTasiento = datos[4].trim();
                ultimoprecio = Integer.parseInt(datos[5]);

            }

            // Actualizar las variables de la instancia con los datos de la última línea
            this.Origen = ultimoOrigen;
            this.Destino = ultimoDestino;
            this.fechas = ultimaFecha;
            this.Hora = ultimaHora;
            this.Tipoasiento= ultimoTasiento;
            this.precio= ultimoprecio;

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getOrigen(){
        return Origen;
    }
    public String getDestino(){
        return Destino;
    }
    public String getFechas(){
        return fechas;
    }
    public String getHora(){
        return Hora;
    }
    public String getTipoasiento(){
        return Tipoasiento;
    }
    public int getPrecio(){
        return precio;
    }
}
