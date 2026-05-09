package Negocio;
import java.time.LocalDateTime;
public class Salida {
    private Ruta myRuta;
    private Bus myBus;
    private String estado;
    private LocalDateTime fechaHora;
    
    public Salida (Ruta rutaAsignada,Bus busAsignado,String estado, LocalDateTime fechaHora){
        this.myRuta =  rutaAsignada;
        this.myBus = busAsignado;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }

    public Ruta getMyRuta() {
        return myRuta;
    }

    public Bus getMyBus() {
        return myBus;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    
}
