package Negocio;
public class Pasaje {
    private Persona myPasasjero;
    private Salida mySalida;
    private Puesto myPuesto;
    private float valor;
    private String estado;
    
    public Pasaje(Persona myPasajero,Salida mySalida,Puesto myPuesto,float valor ){
        this.myPasasjero = myPasajero;
        this.mySalida = mySalida;
        this.myPuesto = myPuesto;
        this.valor = valor;
        this.estado = "VIGENTE"; /*todos estan vigentes al principio
        */
        
    }

    public Persona getMyPasasjero() {
        return myPasasjero;
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
