package Negocio;
import java.util.ArrayList;
import java.util.Date;


public class Copetran {
    private ArrayList<Bus> listaBuses;
    private ArrayList<Ruta> listaRutas;
    private ArrayList<Salida> listaSalidas;
    private ArrayList<Pasaje> listaPasajes;
    private ArrayList<Persona> listaPersonas;
    private Caja cajaCopetran;
    
    
    public Copetran(){
        this.listaBuses = new ArrayList<>();
        this.listaRutas = new ArrayList<>();
        this.listaSalidas = new ArrayList<>();
        this.listaPasajes = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
    }
    
    //BUSES
    public String registrarBusesCopetran(String placaUnica,String tipoServicio, String nombreConductor){
        if(validarPlaca(placaUnica)){
            return "BUS YA EXISTENTE";
        }
        Conductor asignado = buscarConductor(nombreConductor);
        Bus nuevo = new Bus(placaUnica,tipoServicio,asignado);
        this.listaBuses.add(nuevo);
        return "BUS REGISTRADO CON EXITO\n" + nuevo.toString();
    }
    //VALIDACION DE PLACA
    private boolean validarPlaca(String placa){
        boolean existe = false;
        for(Bus c : this.listaBuses){
            if(c.getPlacaUnica().equalsIgnoreCase(placa)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    //BUSCAR BUSES
    public Bus buscarBus(String placa){
         for (Bus b : listaBuses) {
            if(b.getPlacaUnica().equalsIgnoreCase(placa)){
                return b;
            }
        }
         return null;
    }
    // OBTENER LAS PLACAS DE LOS BUSES
    public ArrayList<String> placaBuses(){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < listaBuses.size(); i++) {
            lista.add(this.listaBuses.get(i).getPlacaUnica());
        } 
        return lista;
    }
    public String busesListado(){
        String lista = "LISTADO DE BUSES\n";
        if(listaBuses.isEmpty()){
            return "NO HAY CAMIONES REGISTRADO";
        }
        for (Bus b : listaBuses) {
            lista+=b.toString() + "\n--------------------------------\n";
        } 
        return lista;
    }
    
    // RUTAS
    // REGISTRO DE LAS RUTAS
    public String registrarRutasCopetran(String destino, int tarifa ){
        if(this.validarRuta(destino)){
            return "RUTA YA EXISTENTE";
        }
        Ruta nueva = new Ruta(destino, tarifa);
        this.listaRutas.add(nueva);
        return "RUTA REGISTRADA CON EXITO\n"+ nueva.toString();
    }
    //VALIDACION DE LAS RUTAS
    private boolean validarRuta (String destino){
        boolean existe = false;
        for(Ruta c : this.listaRutas){
            if(c.getDestino().equalsIgnoreCase(destino)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    //BUSCAR RUTAS
    private Ruta buscarRuta (String destino){
        for (Ruta r : listaRutas) {
            if(r.getDestino().equalsIgnoreCase(destino)){
                return r;
            }
        }
         return null;
    }
    public ArrayList<String> destinoRutas(){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < listaRutas.size(); i++) {
            String destino = this.listaRutas.get(i).getDestino();
            lista.add(destino);
        } 
        return lista;
    }
    //LISTAR RUTAS
    public String rutasListado(){
        String lista = "LISTADO DE RUTAS\n";
        if(listaBuses.isEmpty()){
            return "NO HAY RUTAS REGISTRADAS";
        }
        for (Ruta r : listaRutas) {
            lista+=r.toString() + "\n--------------------------------\n";
        } 
        return lista;
    }
    
    //SALIDAS
    public String registrarSalidasCopetran(String destino,String placa,Date fechaHora ){
       Bus busSalida = buscarBus(placa);
       Ruta rutaSalida = buscarRuta(destino);
       
       Salida salidaNueva = new Salida(rutaSalida, busSalida, fechaHora);
       this.listaSalidas.add(salidaNueva);
       return "RUTA REGISTRADA CON EXITO: \n" + salidaNueva.toString();
    }
    //LISTAR SALIDAS
    public String salidasListado(){
        String lista = "LISTADO DE SALIDAS\n";
        if(listaSalidas.isEmpty()){
            return "NO HAY SALIDAS REGISTRADAS";
        }
        for (Salida s : listaSalidas) {
            lista+=s.toString() + "\n--------------------------------\n";
        } 
        return lista;
    }
    
    //REGISTROS DE PERSONAS
    //REGISTROS Y METODOS DE CONDUCTORES
    public String conductorRegistro(String nombre, String cedula, String celular, String correo,String añosExperiencia, int sueldo){
        String registro = "CONDCUTOR REGISTRADO CON EXITO\n";
        if(validarCedula(cedula)){
            return "CONDUCTOR YA REGISTRADO";
        }
        Conductor conductorNuevo = new Conductor(nombre, cedula, celular, correo, añosExperiencia, sueldo);
        listaPersonas.add(conductorNuevo);
        registro += conductorNuevo.toString();
        return registro;
    }
    //BUSCAR NOMBRE DE CONDUCTOR
    public ArrayList<String> nombresConductores(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if( p instanceof Conductor){
                nombres.add(p.getNombre());
            }
        }
        return nombres;
    }
    //BUSCAR CONDUCTORES
    public Conductor buscarConductor(String nombre){
        for (Persona p : listaPersonas) {
            if(p instanceof Conductor && p.getNombre().equalsIgnoreCase(nombre) )
                return (Conductor) p;
        }
        return null;
    }
    //LISTAR CONDUCTORES
    public String conductoresListado(){
        String lista = "LISTADO DE CONDUCTORES\n";
        if(listaPersonas.isEmpty()){
            return "NO HAY CONDUCTORES REGISTRADOS";
        }
        for (Persona p : listaPersonas) {
            if(p instanceof Conductor){
                lista+=p.toString() + "\n--------------------------------\n";
            }
        } 
        return lista;
    }
    //VALIDACION DE CEDULAS CLIENTE Y CONDUCTOR 
    private boolean validarCedula(String cedula){
        boolean existe = false;
        for (Persona p : listaPersonas) {
            if(p.getCedula().equalsIgnoreCase(cedula)){
                existe = true;
                break;
            }
        }
        return existe;
    }
}
