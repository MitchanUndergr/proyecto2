import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Asientos {
    private void agregarContenido(ArrayList<String> arrayList1, ArrayList<String> arrayList2) {
        for (String elemento : arrayList1) {
            arrayList2.add(elemento);
        }
    }
    private ArrayList<String> seleccionAsientos = new ArrayList<>(),seleAsientos = new ArrayList<>(),seleccionAsientosdob = new ArrayList<>(),seleAsientosdob = new ArrayList<>();
    private String[] vectorComposiciones = new String[40],vectorComposicionesdob = new String[60];
    private String Origen, Destino, fechas, Hora, Tipoasiento;

    private int precio;
    public Asientos() {
        // Código de inicialización del vectorComposiciones
        int indice = 0;

        for (char letra = 'A'; letra <= 'D'; letra++) {
            // Iterar sobre los números del 1 al 11
            for (int numero = 1; numero <= 10; numero++) {
                // Combinar la letra y el número en una composición
                String composicion = letra + Integer.toString(numero);
                // Agregar la composición al vector
                vectorComposiciones[indice] = composicion;
                indice++;
            }
        }

        int indice2 = 0;

        for (char letra = 'A'; letra <= 'F'; letra++) {
            // Iterar sobre los números del 1 al 11
            for (int numero = 1; numero <= 10; numero++) {
                // Combinar la letra y el número en una composición
                String composicion = letra + Integer.toString(numero);
                // Agregar la composición al vector
                vectorComposicionesdob[indice2] = composicion;
                indice2++;
            }
        }

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

        try {
            FileReader fileReader = new FileReader("src/Archivos/filtro_asientos.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                // Separar los datos utilizando el carácter de coma como delimitador
                String[] datosPasaje = linea.split(",");

                // Comprobar si los datos de Origen, Destino, fechas, Hora y Tipoasiento coinciden
                String origenPasaje = datosPasaje[0].trim();
                String destinoPasaje = datosPasaje[1].trim();
                String fechaPasaje = datosPasaje[2].trim();
                String horaPasaje = datosPasaje[3].trim();
                String tipoAsientoPasaje = datosPasaje[4].trim();
                int precioPasaje = Integer.parseInt(datosPasaje[5].trim());
                ArrayList<String> arrayAsientos = new ArrayList<>();
                for (int i = 6; i < datosPasaje.length; i++) {
                    String[] asientos = datosPasaje[i].trim().split("\\s+"); // Dividir los datos de asientos por espacios
                    for (String asiento : asientos) {
                        if (!arrayAsientos.contains(asiento)) {
                            arrayAsientos.add(asiento); // Agregar los asientos individuales al ArrayList
                        }
                    }
                }

                // Si hay coincidencia, guardar los datos adicionales en el ArrayList correspondiente
                if (origenPasaje.equals(Origen) && destinoPasaje.equals(Destino) && fechaPasaje.equals(fechas) && horaPasaje.equals(Hora) && tipoAsientoPasaje.equals(Tipoasiento)) {
                    if (Tipoasiento.equals("Semi cama")) {
                        HashSet<String> setAsientos = new HashSet<>(seleccionAsientos); // Convertimos seleccionAsientos a un HashSet temporal
                        setAsientos.addAll(arrayAsientos); // Agregamos todos los elementos de arrayAsientos al HashSet temporal

                        seleccionAsientos = new ArrayList<>(setAsientos);
                    } else if (Tipoasiento.equals("Salon cama")) {
                        HashSet<String> setAsientosdob = new HashSet<>(seleccionAsientosdob); // Convertimos seleccionAsientosdob a un HashSet temporal
                        setAsientosdob.addAll(arrayAsientos); // Agregamos todos los elementos de arrayAsientos al HashSet temporal

                        seleccionAsientosdob = new ArrayList<>(setAsientosdob);
                    }
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addAsiento(int indice) {
        String asiento = vectorComposiciones[indice];
        if (!seleccionAsientos.contains(asiento)) {
            seleAsientos.add(asiento);
        }
    }
    public void eraseAsiento(int indice){
        seleAsientos.remove(vectorComposiciones[indice]);
    }
    public void addAsientodob(int indice) {
        String asiento = vectorComposicionesdob[indice];
        if (!seleccionAsientosdob.contains(asiento)) {
            seleAsientosdob.add(asiento);
        }
    }
    public void eraseAsientodob(int indice){
        seleAsientosdob.remove(vectorComposicionesdob[indice]);
    }
    public ArrayList<String> AsientosSeleccionados(){
        agregarContenido(seleAsientos,seleccionAsientos);
        return seleccionAsientos;
    }


    public ArrayList<String> AsientosSeleccionadosDob(){
        agregarContenido(seleAsientosdob,seleccionAsientosdob);
        return seleccionAsientosdob;
    }
    public ArrayList<String> getSeleAsientos() {
        return seleAsientos;
    }
    public ArrayList getSeleasientosdob(){
        return seleAsientosdob;
    }
    public String valor_asiento(int indice){
        String valor=vectorComposiciones[indice];
        return valor;
    }

    public String valor_asientodob(int indice){
        String valor=vectorComposicionesdob[indice];
        return valor;
    }

    public void DatosParaReserva(){
        GuardaDatos.guardarDatosD(Origen,Destino,fechas,Hora,Tipoasiento,precio,seleccionAsientos);
    }

    public void DatosParaReservaDob(){
        GuardaDatos.guardarDatosD(Origen,Destino,fechas,Hora,Tipoasiento,precio,seleccionAsientosdob);
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

    public ArrayList<String> getSeleccionAsientos(){
        return seleccionAsientos;
    }
    public ArrayList<String> getSeleccionAsientosdob(){
        return seleccionAsientosdob;
    }
}
