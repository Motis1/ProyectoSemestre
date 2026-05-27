package Negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Se generan correctamente las seis canchas en el constructor. El método
 * listarCanchas() está implementado y la vista lo invoca mediante el botón
 * MOSTRAR CANCHAS. (0.5) 
 * 
 * El método registrarCliente() valida la existencia de la cédula y está
 * conectado a la vista. Sin embargo, en el listener de la vista los campos
 * están incorrectamente asignados: se usa txtDia para capturar la cédula,
 * txtMes para el teléfono y txtHora para el tipo de cliente, en lugar de los
 * campos correspondientes (txtCedula, txtTelefono, txtTipo). (0.3) CORREGIDO
 * 
 * 
 * El método reservar() presenta errores: CORREGIDO
 * 
 * la lógica es inversa, pues solo permite realizar la reserva cuando la cédula NO existe
 * en el sistema (el cliente debe ser nuevo para reservar). CORREGIDO
 * 
 * No existe una clase Reserva ni una colección que almacene las reservas. No se valida el cruce
 * horario, ni la hora de inicio (7:00-22:00), ni el mínimo de 1 hora. No se aplican descuentos.
 * 
 * El método recorre todas las canchas en lugar de buscar una específica.
 * (0.3)
 * 
 * No se implementó la reprogramación de reservas por mantenimiento.
 * 
 * El método getGanancias() retorna únicamente el total de ganancias acumulado y
 * está conectado al botón REPORTE GANANCIAS. No constituye el reporte gerencial
 * solicitado en el documento, el cual debe mostrar por cada cancha sus reservas activas y
 * canceladas, junto con los totales de recaudo y devoluciones. (0.1)
 * 
 * Nota Final 1.2
 */

public class SportCenter {
    private ArrayList <Cliente> myClientes;
    private Cancha[] myCanchas;
    private ArrayList <Reserva> myReservas;
    private float ganancias;
    
    
    
    public SportCenter() {
        this.myClientes = new ArrayList<>();
        this.myReservas = new ArrayList<>();
        this.myCanchas = new Cancha[6];
        this.ganancias = 0.0F;
        crearCanchas();
    }
    
    private void crearCanchas() {
        myCanchas[0] = new Cancha("C1", "Futbol", 80000 , "DISPONIBLE");
        myCanchas[1] = new Cancha("C2", "Futbol", 80000 , "DISPONIBLE");
        myCanchas[2] = new Cancha("C3", "Tenis", 50000 , "DISPONIBLE");
        myCanchas[3] = new Cancha("C4", "Tenis", 50000 , "DISPONIBLE");
        myCanchas[4] = new Cancha("C5", "Baloncesto", 60000 , "DISPONIBLE");
        myCanchas[5] = new Cancha("C6", "Voleibol", 55000 , "DISPONIBLE");
    }
    //CLIENTES
    public String registrarCliente(String cedula, String nombre, String telefono){
        
        if(this.validarCedula(cedula).equalsIgnoreCase("EXISTE")){
            return "CLIENTE YA RESERVADO";
        }
        Cliente nuevo = new Cliente(cedula, nombre, telefono);
        this.myClientes.add(nuevo);
        return "CLIENTE REGISTRADO CON EXITO\n" + nuevo;
    }
    
    public String validarCedula(String cedula){
        for (Cliente c : myClientes) {
            if(c.getCedula().equals(cedula)){
                return "EXISTE";
            }
        }return "NO EXISTE";
    }
    
    public ArrayList<String> getClientes(){
        ArrayList<String> listaClientes = new ArrayList<>();
        for (int i = 0; i < myClientes.size(); i++) {
            String nombre = this.myClientes.get(i).getNombre();
            listaClientes.add(nombre);
        }
        return listaClientes;
    }
    
    private Cliente buscarCliente(String nombre){
        for (Cliente c : myClientes) {
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }
    //CANCHAS
    public String listarCanchas(){
        String lista = "__________CANCHAS SPORTCENTER__________";
        for (int i = 0; i < myCanchas.length; i++) {
            lista += "\n" + this.myCanchas[i];
        } 
        return lista;
    }
    
    public ArrayList<String> getCanchas(){
        ArrayList<String> listaNombres =  new ArrayList<>();
        for (int i = 0; i < myCanchas.length; i++) {
            String nombre = this.myCanchas[i].getTipo();
            String codigo = this.myCanchas[i].getCodigo();
            listaNombres.add(codigo + " - " + nombre);
        }
        return listaNombres;
    }
    
    public String cambiarEstadoCancha(String tipo){
        for (Cancha c : myCanchas) {
            if(c.getTipo().equals(tipo)){
                c.setEstado("OCUPADO");
            }
        }
        return "NO ENCONTRAMOS SU CANCHA";
    }
    
    private Cancha buscarCancha(String datosCancha){
        for (Cancha c : myCanchas) {
            String texto = c.getCodigo() + " - " + c.getTipo();
            if(texto.equals(datosCancha)){
                return c;
            }
        } 
        return null;
    }
    private boolean validarCanchas(String datosCancha, Date inicio, Date fin){
        Cancha canchaSeleccionada = buscarCancha(datosCancha);
        for (Reserva r : myReservas) {
            Date inicioNuevo = r.getFechaInicio();
            Date finNuevo = r.getFechaFin();
            
            if(inicioNuevo.before(fin) && finNuevo.after(inicio)){
                return true;
            }
        }
        return false;
    }
    
    private boolean horarioInvalido(Date inicio, Date fin){
        java.util.Calendar inicioNuevo = java.util.Calendar.getInstance();
        java.util.Calendar finNuevo = java.util.Calendar.getInstance();
        inicioNuevo.setTime(inicio);
        finNuevo.setTime(fin);
        
        int horaInicio = inicioNuevo.get(java.util.Calendar.HOUR_OF_DAY);
        int horaFin = inicioNuevo.get(java.util.Calendar.HOUR_OF_DAY);
        int minutosFin = finNuevo.get(java.util.Calendar.MINUTE);
        
        if(horaInicio < 7 || horaInicio <=22){
            return true;
        }
        if(horaFin > 22 || (horaFin == 22 && minutosFin > 0)){
            return true;
        }
        return false;
    }
    
    //RESERVAR
    public String reservar(String datosCancha, String datosCliente,int cantidad, Date inicio){
        java.util.Calendar inicioNuevo = java.util.Calendar.getInstance();
        inicioNuevo.setTime(inicio);
        
        inicioNuevo.add(java.util.Calendar.HOUR_OF_DAY, cantidad);
        Date finCalculado = inicioNuevo.getTime();
        
        
        float total = this.buscarCancha(datosCancha).getValorHora();
        String reporte = "RESERVA REALIZADA CON EXITO\n\n";
        
        if(validarCanchas(datosCancha, inicio, finCalculado)){
            return "CANCHA YA RESERVADA EN ESE HORARIO";
        }
        if(horarioInvalido(inicio, finCalculado)){
            return "HORARIO INVALIDO (7:00 - 22:00)";
        }
        
        Cancha canchaRegistrada = buscarCancha(datosCancha);
        Cliente clienteRegistrado =  buscarCliente(datosCliente);
        
        if(cantidad == 3){
            total = (total*cantidad) * 0.05F;
        }
        
        total = cantidad*total;
        Reserva reservaNueva = new Reserva(clienteRegistrado, canchaRegistrada, cantidad, inicio);
        reservaNueva.setValorPagar(total);
        reservaNueva.setEstado("OCUPADA");
        reservaNueva.setFechaFin(finCalculado);
        this.myReservas.add(reservaNueva);
        return reporte + "=============================\n" + reservaNueva;
    }
}
