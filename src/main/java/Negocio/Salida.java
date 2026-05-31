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
   
    private Puesto obtenerPuestoPorNumero(int numeroPuesto){
        if(numeroPuesto <= this.myBus.getCapacidad()){
            return this.myBus.getMyPuestos()[numeroPuesto-1];
        }
        return null;
    }
   
    public boolean asientoOcupado(int numeroAsiento){
        if(numeroAsiento < asientosOcupados.length){
            asientosOcupados[numeroAsiento] = true;
            Puesto puestoFisico = obtenerPuestoPorNumero(numeroAsiento);
            puestoFisico.setEstado("OCUPADO");
            return true;
        }
        return false;
    }
    
    public String getiD() {
        return iD;
    }
    public boolean puestosVecinos(int puesto1, int puesto2) {
        int filaPuesto1 = (puesto1 - 1) / 4;
        int filaPuesto2 = (puesto2 - 1) / 4;
        if (filaPuesto1 != filaPuesto2) {
            return false;
        }
        int posicion1 = (puesto1 - 1) % 4;
        int posicion2 = (puesto2 - 1) % 4;
        if ((posicion1 == 0 && posicion2 == 1) || (posicion1 == 1 && posicion2 == 0)) {
            return true;
        }
        if ((posicion1 == 2 && posicion2 == 3) || (posicion1 == 3 && posicion2 == 2)) {
        return true;
        }
        return false;
    }
    /*public boolean busHorario(Date fecha, int horasDuracion){
        if(this.estado.equalsIgnoreCase("FINALIZADO")||this.estado.equalsIgnoreCase("CANCELADO")){
            return false;
        }
         java.util.Calendar fechaNueva = java.util.Calendar.getInstance();
         fechaNueva.setTime(fecha);
         Date fechaFinNueva = fechaNueva.getTime();
         
         java.util.Calendar fechaActual = java.util.Calendar.getInstance();
         fechaActual.setTime(this.fechaHora);
         fechaActual.add(java.util.Calendar.HOUR_OF_DAY, this.myRuta.getTiempoDeViaje());
         Date fechaFinActual = fechaActual.getTime();
         
         return this.fechaHora.before(fechaFinNueva) && fechaFinActual.after(fecha);
    }*/

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        String fechaModificada = formatoFecha.format(fechaHora);
        return "ID: " + iD +
               "\nDESTINO:\n" + myRuta.getDestino() + 
               "\nBUS ASIGNADO:" + myBus.getPlacaUnica() + 
               "\nCONDUCTOR: " + myBus.getConductor().getNombre() + 
               "\nCLASE: " + myBus.getTipoServicio()+
               "\nEstado: " + estado + 
               "\nFecha y hora: " + fechaModificada;
    }
}
