package Negocio;

import java.text.SimpleDateFormat;

public class Pasaje {
    private static int contador = 1;
    private String iD;
    private Persona myPasajero;
    private Salida mySalida;
    private Puesto myPuesto;
    private float valor;
    private String estado;
    
    
    public Pasaje(Persona myPasajero,Salida mySalida,Puesto myPuesto,float valor){
        this.iD = "TQ-"+contador++;
        this.myPasajero = myPasajero;
        this.mySalida = mySalida;
        this.myPuesto = myPuesto;
        this.valor = valor;
        this.estado = "VIGENTE"; 
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public Persona getMyPasajero() {
        return myPasajero;
    }

    public void setMyPasajero(Persona myPasajero) {
        this.myPasajero = myPasajero;
    }

    public Salida getMySalida() {
        return mySalida;
    }

    public void setMySalida(Salida mySalida) {
        this.mySalida = mySalida;
    }

    public Puesto getMyPuesto() {
        return myPuesto;
    }

    public void setMyPuesto(Puesto myPuesto) {
        this.myPuesto = myPuesto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        String fechaModificada = formatoFecha.format(this.mySalida.getFechaHora());
        return "Tiquete: " + iD + 
               "\nPasajero: " + myPasajero.getCedula() + " - " + myPasajero.getNombre() + 
               "\nSalida: " + mySalida.getiD() + "(" + mySalida.getMyRuta().getOrigen() + " - " + mySalida.getMyRuta().getDestino() + ") " + fechaModificada +
               "\nBus: " + mySalida.getMyBus().getPlacaUnica() + "(" +mySalida.getMyBus().getTipoServicio() + ") Capacidad: " + mySalida.getMyBus().getCapacidad() + 
               "\nSilla: " + myPuesto + 
               "\nValor: " + valor + 
               "\nEstado: " + estado;
    }

    
}
