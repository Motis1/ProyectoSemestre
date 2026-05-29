package Negocio;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Salida {
    private static int contadorSalidas = 1;
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
        this.asientosOcupados = new boolean[this.myBus.getCapacidad()+1];
    }

    public int getContadorSalidas() {
        return contadorSalidas;
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
    
    public boolean asientoOcupado(int numeroAsiento){
        if(asientosOcupados != null && numeroAsiento >= 0 && numeroAsiento < asientosOcupados.length){
            return asientosOcupados[numeroAsiento];
        }
        return false;
    }
    
    public String getiD() {
        return iD;
    }
    public boolean ocuparAsientos(int numeroAsiento){
        if(asientosOcupados != null && numeroAsiento >= 0 && numeroAsiento < asientosOcupados.length){
            this.asientosOcupados[numeroAsiento] = true;
        }
        return false;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        String fechaModificada = formatoFecha.format(fechaHora);
        return "ID: " + iD +
               "\nDESTINO:\n" + myRuta.getDestino() + 
               "\nBUS ASIGNADO:" + myBus.getPlacaUnica() + 
               "\nCONDUCTOR: " + myBus.getConductor() + 
               "\nCLASE: " + myBus.getTipoServicio()+
               "\nEstado: " + estado + 
               "\nFecha y hora: " + fechaModificada;
    }
}
