package Negocio;
public class Pasaje {
    private Persona myPasajero;
    private Salida mySalida;
    private Puesto myPuesto;
    private float valor;
    private String estado;
    
    public Pasaje(Persona myPasajero,Salida mySalida,Puesto myPuesto,float valor ){
        this.myPasajero = myPasajero;
        this.mySalida = mySalida;
        this.myPuesto = myPuesto;
        this.valor = valor;
        this.estado = "VIGENTE"; 
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
