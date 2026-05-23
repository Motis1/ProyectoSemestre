package Negocio;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Salida {
    private int contadorSalidas;
    private String iD;
    private Ruta myRuta;
    private Bus myBus;
    private String estado;
    private Date fechaHora;
    private boolean[] asientosOcupados;
    
    public Salida (Ruta rutaAsignada,Bus busAsignado, Date fechaHora){
        this.iD = "S" + contadorSalidas++;
        this.myRuta =  rutaAsignada;
        this.myBus = busAsignado;
        this.estado = "PROGRAMADA";
        this.fechaHora = fechaHora;
        //this.asientosOcupados = new boolean[Puesto];
    }

    public int getContadorSalidas() {
        return contadorSalidas;
    }

    public void setContadorSalidas(int numero) {
        this.contadorSalidas = contadorSalidas;
    }

    public boolean[] getAsientosOcupados() {
        return asientosOcupados;
    }

    public void setAsientosOcupados(boolean[] asientosOcupados) {
        this.asientosOcupados = asientosOcupados;
    }

    public Ruta getMyRuta() {
        return myRuta;
    }

    public void setMyRuta(Ruta myRuta) {
        this.myRuta = myRuta;
    }

    public Bus getMyBus() {
        return myBus;
    }

    public void setMyBus(Bus myBus) {
        this.myBus = myBus;
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
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        String fechaModificada = formatoFecha.format(fechaHora);
        return "ID: " + iD +
               "\nRUTA:\n" + myRuta + 
               "\nBUS ASIGNADO:\n" + myBus + 
               "\nEstado: " + estado + 
               "\nFecha y hora: " + fechaModificada;
    }
}
