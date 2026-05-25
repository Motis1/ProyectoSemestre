package Negocio;
public class Pasaje {
    private Persona myPasajero;
    private Salida mySalida;
    private Puesto myPuesto;
    private float valor;
    private String estado;
    private int cantidad;
    
    public Pasaje(Persona myPasajero,Salida mySalida,Puesto myPuesto,float valor, int cantidad ){
        this.myPasajero = myPasajero;
        this.mySalida = mySalida;
        this.myPuesto = myPuesto;
        this.valor = valor;
        this.estado = "VIGENTE"; 
        this.cantidad = cantidad;
    }

    public Persona getMyPasasjero() {
        return myPasajero;
    }

    public Salida getMySalida() {
        return mySalida;
    }

    public Puesto getMyPuesto() {
        return myPuesto;
    }

    public float getValor() {
        return valor;
    }

    public String getEstado() {
        return estado;
    }
}
