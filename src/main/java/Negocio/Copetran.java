package Negocio;
import java.time.LocalDateTime;
import java.util.ArrayList;


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
    }
    
    //QUITAR EL PARAMETRO DE ESTADO.. CORREGIR LA VISTA
    public String busesCopetran(String placaUnica,String tipoServicio,String estado){
        //NO SE PUEDE CREAR OBJETOS Y ALMACENARLOS SIN ANTES VALIDAR 
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
    
    public String rutasCopetran(String codigo,String origen, String destino, int tarifa ){
        Ruta rutaNueva = new Ruta(codigo,origen,destino,tarifa);
        this.listaRutas.add(rutaNueva);
        return "CAMION RUTA CON EXITO" + "\n" + rutaNueva.toString();
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
    
    //PILASSSSS NO SE PUEDEN RECIBIR OBJETOS 
     
    public String salidasCopetran(Ruta rutaSeleccioanda,Bus busSeleccionado,String estado,LocalDateTime fechaHora ){
        Salida salidaNueva = new Salida(rutaSeleccioanda,busSeleccionado,estado,fechaHora);
        this.listaSalidas.add(salidaNueva);
        return "CAMION RUTA CON EXITO" + "\n" + salidaNueva.toString();
    }
    
    //  PROFESORA: UN RF NO PUEDE RECIBIR OBJETOS DEL NEGOCIO,ERRADA LA PROGRAMACIÓN
    //PROFESORA:  REVISAR CONCEPTOS..   OJO DEBE ESTAR EL METODO DE REGISTRAR BUSES, ASÍ COMO REGISTRAR NUEVAS RUTAS
    //PROFESORA: Y REGISTRAR NUEVAS SALIDAS..
    
    public boolean venderPasaje(Salida salidaElegida, Puesto puestoElegido, Persona pasajero){
        if(puestoElegido.isOcupado()||!salidaElegida.getEstado().equalsIgnoreCase("PROGRAMADO")){
            return false; // no se puede vender 
        }
        float valor = salidaElegida.getMyRuta().getTarifaBase();
        if(salidaElegida.getMyBus().getTipoServicio().equalsIgnoreCase("Ejecutivo")){
            valor+=(valor*0.2);
        }
        Pasaje myPasaje = new Pasaje(pasajero,salidaElegida,puestoElegido,valor);
        this.listaPasajes.add(myPasaje);
        this.cajaCopetran.setTotalVendido(this.cajaCopetran.getTotalVendido()+ valor);
        return true; // venta existosa
    }
    
}
