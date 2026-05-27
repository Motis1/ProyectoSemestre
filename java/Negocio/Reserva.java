package Negocio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private String id;
    private int contadorId = 1;
    private Cliente myCliente;
    private Cancha myCancha;
    private float valorPagar;
    private String estado;
    private int cantidad;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(Cliente myCliente,Cancha myCancha,int cantidad, Date fechaInicio) {
        this.id = "R" + contadorId++;
        this.myCliente = myCliente;
        this.myCancha = myCancha;
        this.valorPagar = 0;
        this.cantidad = cantidad;
        this.estado = "ACTIVA";
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cancha getMyCancha() {
        return myCancha;
    }

    public void setMyCancha(Cancha myCancha) {
        this.myCancha = myCancha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getMyCliente() {
        return myCliente;
    }

    public void setMyCliente(Cliente myCliente) {
        this.myCliente = myCliente;
    }

    public float getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(float valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaInicioMod = fechaFormato.format(fechaInicio);
        String fechaFinMod = fechaFormato.format(fechaFin);
        String textoCancha = myCancha.getCodigo() + " - " + myCancha.getTipo();
        
        return "ID: " + id + 
               "\nCliente: " + myCliente.getNombre() + 
               "\nCancha: " + textoCancha +
               "\nTotal a pagar: " + valorPagar + 
               "\nHoras a jugar: " + cantidad +
               "\nEstado: " + estado +
               "\nInicio: " + fechaInicioMod + 
               "\nFin: " + fechaFinMod;
        
    }
    
    
    
}
