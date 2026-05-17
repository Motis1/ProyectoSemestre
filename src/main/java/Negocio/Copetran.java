package Negocio;
import java.util.ArrayList;
import java.util.Date;


public class Copetran {
    private ArrayList<Bus> listaBuses;
    private ArrayList<Ruta> listaRutas;
    private ArrayList<Salida> listaSalidas;
    private ArrayList<Pasaje> listaPasajes;
    private Caja cajaCopetran;
    
    
    public Copetran(){
        this.listaBuses = new ArrayList<>();
        this.listaRutas = new ArrayList<>();
        this.listaSalidas = new ArrayList<>();
        this.listaPasajes = new ArrayList<>();
        estadoSalidas();
    }
    
    //BUSES
    public String registrarBusesCopetran(String placaUnica,String tipoServicio,String estado){
        //NO SE PUEDE CREAR OBJETOS Y ALMACENARLOS SIN ANTES VALIDAR 
        if(validarPlaca(placaUnica)){
            return "BUS YA EXISTENTE";
        }
        Bus nuevo = new Bus(placaUnica,tipoServicio,estado);
        this.listaBuses.add(nuevo);
        return "CAMION REGISTRADO CON EXITO" + "\n" + nuevo.toString();
    }
    
    //TODOS LOS METODOS DE BUSQUEDA DE EXISTENCIA DE OBJETOS SE DEBE TRABAJAR private
    public boolean validarPlaca(String placa){
        boolean existe = false;
        for(Bus c : this.listaBuses){
            if(c.getPlacaUnica().equalsIgnoreCase(placa)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public String buscarBus(String placa){
         for (Bus b : listaBuses) {
            if(b.getPlacaUnica().equalsIgnoreCase(placa)){
                return b.getPlacaUnica();
            }
        }
         return "BUS NO ENCONTRADO";
    }
    
    public ArrayList<String> placaBuses(){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < listaBuses.size(); i++) {
            lista.add(this.listaBuses.get(i).getPlacaUnica());
        } 
        return lista;
    }
    
    // RUTAS
    public String registrarRutasCopetran(String codigo,String origen, String destino, int tarifa ){
        if(this.validarRuta(codigo, origen, destino)){
            return "RUTA YA EXISTENTE";
        }
        
        Ruta rutaNueva = new Ruta(codigo,origen,destino,tarifa);
        this.listaRutas.add(rutaNueva);
        return "RUTA REGISTRADA CON EXITO" + "\n" + rutaNueva.toString();
    }
    
    public boolean validarRuta (String codigo,String origen,String destino){
        boolean existe = false;
        for(Ruta c : this.listaRutas){
            if(c.getCodigo().equalsIgnoreCase(codigo)||c.getOrigen().equalsIgnoreCase(origen)&&c.getDestino().equalsIgnoreCase(destino)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public String buscarRuta (String codigo){
        for (Ruta r : listaRutas) {
            if(r.getCodigo().equalsIgnoreCase(codigo)){
                return r.getCodigo();
            }
        }
         return "RUTA NO ENCONTRADA";
    }
    public ArrayList<String> codigoRutas(){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < listaRutas.size(); i++) {
            String codigo = this.listaRutas.get(i).getCodigo();
            String origen = this.listaRutas.get(i).getOrigen();
            String destino = this.listaRutas.get(i).getDestino();
            lista.add(codigo + " / " + origen + " - " + destino);
        } 
        return lista;
    }
    
    // SALIDAS
    private void estadoSalidas(){
        for (int i = 0; i < listaSalidas.size(); i++) {
            this.listaSalidas.get(i).setEstado("PROGRAMADA");
        }
    }
    
    //PILASSSSS NO SE PUEDEN RECIBIR OBJETOS 
     
    public String registrarSalidasCopetran(String rutaSeleccionada,String busSeleccionada,String estado,Date fechaHora ){
       String rutaValidada = this.buscarBus(rutaSeleccionada);
       String busValidado = this.buscarBus(busSeleccionada);
       
       Salida salidaRegistrada = new Salida(rutaValidada, busValidado, estado, fechaHora);
       this.listaSalidas.add(salidaRegistrada);
       return "RUTA REGISTRADA CON EXITO: " + "\n" + salidaRegistrada.toString();
    }
    
    public boolean venderPasaje(Salida salidaElegida, Puesto puestoElegido, Persona pasajero){
        /*if(puestoElegido.isOcupado()||!salidaElegida.getEstado().equalsIgnoreCase("PROGRAMADO")){
            return false; // no se puede vender 
        }
        float valor = salidaElegida.getMyRuta().getTarifaBase();
        if(salidaElegida.getMyBus().getTipoServicio().equalsIgnoreCase("Ejecutivo")){
            valor+=(valor*0.2);
        }
        Pasaje myPasaje = new Pasaje(pasajero,salidaElegida,puestoElegido,valor);
        this.listaPasajes.add(myPasaje);
        this.cajaCopetran.setTotalVendido(this.cajaCopetran.getTotalVendido()+ valor);*/
        return true; // venta existosa
    }
    
}
