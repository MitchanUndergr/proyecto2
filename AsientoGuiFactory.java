public class AsientoGUIFactory {
    private static final String Semi= "Semi cama";
    private boolean semicama=false;
    private boolean saloncama=false;
    private AsientosGUI Semic,Salonc;
    private static final String Salon= "Salon cama";
    public AsientosGUI crearAsientoGUI(String tipo){
        if (tipo.equalsIgnoreCase(Semi)) {
            semicama=true;
            Semic= new AsientosSemiGUI();
            return Semic;
        } else if (tipo.equalsIgnoreCase(Salon)) {
            saloncama=true;
            Salonc= new AsientosSalonGUI();
            return Salonc;
        } else {
            return null; // En caso de que el tipo no sea válido
        }
    }
    public void UsarAsientoGUI(){
        if(semicama){
            Semic.ElegirAsientos();
            Semic.ImplementarFiltro();
            Semic.setVisible(true);
        } else if (saloncama) {
            Salonc.ElegirAsientos();
            Salonc.ImplementarFiltro();
            Salonc.setVisible(true);
        }
    }
}
