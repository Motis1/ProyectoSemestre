package Negocio;
import java.util.Date;
public class Salida {
    private String myCodigoRuta;
    private String myPlacaBus;
    private String estado;
    private Date fechaHora;
    
    public Salida (String rutaAsignada,String busAsignado,String estado, Date fechaHora){
        this.myCodigoRuta =  rutaAsignada;
        this.myPlacaBus = busAsignado;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }

    public String getMyCodigoRuta() {
        return myCodigoRuta;
    }

    public void setMyCodigoRuta(String myCodigoRuta) {
        this.myCodigoRuta = myCodigoRuta;
    }

    public String getMyPlacaBus() {
        return myPlacaBus;
    }

    public void setMyPlacaBus(String myPlacaBus) {
        this.myPlacaBus = myPlacaBus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Ruta: " + myCodigoRuta + "\nBus asignado: " + myPlacaBus + "\nEstado:" + estado + "\n Fecha y hora:" + fechaHora;
    }
}
