package Negocio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;


public class Copetran {
    private ArrayList<Bus> listaBuses;
    private ArrayList<Ruta> listaRutas;
    private ArrayList<Salida> listaSalidas;
    private ArrayList<Pasaje> listaPasajes;
    private TreeSet<Persona> listaPersonas;
    private Caja cajaCopetran;
    
    
    public Copetran(){
        this.listaBuses = new ArrayList<>();
        this.listaRutas = new ArrayList<>();
        this.listaSalidas = new ArrayList<>();
        this.listaPasajes = new ArrayList<>();
        this.listaPersonas = new TreeSet<>();
        personasCargadosPorCodigo();
        rutasCargadasPorCodigo();
        busesCargadasPorCodigo();
        salidasCargadasPorCodigo();
    }
    //DATOS PRECARGADOS POR CODIGO DE PRUEBA PARA PROBAR RF
    private void personasCargadosPorCodigo(){
        Conductor cond1 = new Conductor("2", "Marlon Correa", "1095612365", "3126458995", "Marlon@gmail.com", 2500000);
        Conductor cond2 = new Conductor("4", "Jose Angarita", "1026459123", "3126458952", "Jose@gmail.com", 2500000);
        Conductor cond3 = new Conductor("3", "Daniel Arias", "1045856231", "3165987426", "Daniel@gmail.com", 2500000);
        Conductor cond4 = new Conductor("5", "Brayan Bayona", "102654895", "3174652978", "Brayan@gmail.com", 2500000);
        this.listaPersonas.add(cond1);
        this.listaPersonas.add(cond2);
        this.listaPersonas.add(cond3);
        this.listaPersonas.add(cond4);
    }
    private void rutasCargadasPorCodigo(){
        Ruta r1 = new Ruta("BUCARAMANGA",80000,4);
        Ruta r2 = new Ruta("BOGOTA",160000,18);
        Ruta r3 = new Ruta("MEDELLIN",180000,15);
        Ruta r4 = new Ruta("CARTAGENA",220000,16);
        this.listaRutas.add(r1);
        this.listaRutas.add(r2);
        this.listaRutas.add(r3);
        this.listaRutas.add(r4);
    }
    private void busesCargadasPorCodigo(){
        Conductor marlon = buscarConductor("Marlon Correa");
        Conductor jose = buscarConductor("Jose Angarita");
        Conductor daniel = buscarConductor("Daniel Arias");
        Conductor brayan = buscarConductor("Brayan Bayona");
        Bus b1 = new Bus("KAA-101", "NORMAL", marlon);
        Bus b2 = new Bus("KBB-202", "EJECUTIVO", jose);
        Bus b3 = new Bus("KCC-303", "NORMAL", daniel);
        Bus b4 = new Bus("KDD-404", "EJECUTIVO", brayan);
        Bus b5 = new Bus("KEE-505", "NORMAL", marlon);
        Bus b6 = new Bus("KFF-606", "NORMAL", jose);
        this.listaBuses.add(b1);
        this.listaBuses.add(b2);
        this.listaBuses.add(b3);
        this.listaBuses.add(b4);
        this.listaBuses.add(b5);
        this.listaBuses.add(b6);
    }
    private void salidasCargadasPorCodigo(){
        Bus b1 = buscarBus("KAA-101");
        Bus b2 = buscarBus("KBB-202");
        Bus b3 = buscarBus("KCC-303");
        Bus b4 = buscarBus("KAA-101");
        Bus b6 = buscarBus("KEE-505");
        Ruta r1 = buscarRuta("BUCARAMANGA");
        Ruta r2 = buscarRuta("BOGOTA");
        Ruta r3 = buscarRuta("MEDELLIN");
        Ruta r4 = buscarRuta("CARTAGENA");
        Date f1 = crearFechaPrueba(2026, 3, 15, 6, 0);
        Date f2 = crearFechaPrueba(2026, 3, 15, 14, 0);
        Date f3 = crearFechaPrueba(2026, 3, 16, 7, 0);
        Date f4 = crearFechaPrueba(2026, 3, 16, 20, 0);
        Date f5 = crearFechaPrueba(2026, 3, 17, 5, 30);
        Date f6 = crearFechaPrueba(2026, 3, 17, 18, 0);
        Date f7 = crearFechaPrueba(2026, 3, 18, 6, 30);
        Date f8 = crearFechaPrueba(2026, 3, 18, 19, 30);
        listaSalidas.add(new Salida(r1,b1,f1));
        listaSalidas.add(new Salida(r1,b2,f2));
        listaSalidas.add(new Salida(r2,b3,f3));
        listaSalidas.add(new Salida(r2,b4,f4));
        listaSalidas.add(new Salida(r3,b6,f5));
        listaSalidas.add(new Salida(r3,b1,f6));
        listaSalidas.add(new Salida(r4,b3,f7));
        listaSalidas.add(new Salida(r4,b2,f8));
    }
    private Date crearFechaPrueba(int año, int mes, int dia, int hora, int minuto) {
        java.util.Calendar formato = java.util.Calendar.getInstance();
        formato.set(año, mes - 1, dia, hora, minuto, 0);
        return formato.getTime();
    }

    //REGISTROS
    //BUSES
    public String registrarBusesCopetran(String placaUnica,String tipoServicio, String nombreConductor){
        if(validarPlaca(placaUnica)){
            return "BUS YA EXISTENTE";
        }
        Conductor asignado = buscarConductor(nombreConductor);
        Bus nuevo = new Bus(placaUnica,tipoServicio,asignado);
        this.listaBuses.add(nuevo);
        return "BUS REGISTRADO CON EXITO\n\n" + nuevo.toString();
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
        String lista = "LISTADO DE BUSES\n\n";
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
    public String registrarRutasCopetran(String destino, int tarifa,int tiempoDeViaje ){
        if(this.validarRuta(destino)){
            return "RUTA YA EXISTENTE";
        }
        Ruta nueva = new Ruta(destino, tarifa,tiempoDeViaje);
        this.listaRutas.add(nueva);
        return "RUTA REGISTRADA CON EXITO\n\n"+ nueva.toString();
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
        String lista = "LISTADO DE RUTAS\n\n";
        if(listaBuses.isEmpty()){
            return "NO HAY RUTAS REGISTRADAS";
        }
        for (Ruta r : listaRutas) {
            lista+=r.toString() + "\n--------------------------------\n";
        } 
        return lista;
    }
    
    //SALIDAS
    public String registrarSalidasCopetran(String destino,String placa,Date fechaHora){
       Bus busSalida = buscarBus(placa);
       Ruta rutaSalida = buscarRuta(destino);
       
       if(validarSalida(placa, fechaHora)){
           return "SALIDA YA PROGRAMADA";
       }
       
       Salida salidaNueva = new Salida(rutaSalida, busSalida, fechaHora);
       this.listaSalidas.add(salidaNueva);
       return "SALIDA REGISTRADA CON EXITO: \n\n" + salidaNueva.toString();
    }
    // VALIDAR SALIDAS
    private boolean validarSalida(String placa,Date fechaHora){
        boolean existe = false;
        for (Salida s : listaSalidas) {
            if(s.getMyBus().getPlacaUnica().equalsIgnoreCase(placa)&&s.getFechaHora().equals(fechaHora)){
                existe = true;
                break;
            }
        }return existe;
    }
    //LISTAR SALIDAS
    public String salidasListado(){
        String lista = "LISTADO DE SALIDAS\n\n";
        if(listaSalidas.isEmpty()){
            return "NO HAY SALIDAS REGISTRADAS";
        }
        for (Salida s : listaSalidas) {
            lista+=s.toString() + "\n--------------------------------\n";
        } 
        return lista;
    }
    //JCOMBO DE SALIDAS POR DESTINO
    public ArrayList<String> salidasFechaDestino(){
        ArrayList<String> salidas = new ArrayList<>();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        for (int i = 0; i < listaSalidas.size(); i++) {
            String combo = listaSalidas.get(i).getMyRuta().getDestino() + " - " + fecha.format(listaSalidas.get(i).getFechaHora());
            salidas.add(combo);
        }
        return salidas;
    }
    //BUSCAR ESAS SALIDAS
    private Salida buscarSalida(String texto){
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        
        for (Salida s : listaSalidas) {
            String formato = s.getMyRuta().getDestino() + " - " + fecha.format(s.getFechaHora());
            if(formato.equalsIgnoreCase(texto)){
                return s;
            }
        }
        return null;
    }
    //BUSCAR CAPACIDAD DE CADA SALIDA
    public int obtenerCapacidad(String datosSalida){
        Salida s = this.buscarSalida(datosSalida);
        if(s!=null){
            return s.getMyBus().getCapacidad();
        }
        return 0;
    }
    //CONSULTAR ESTADO
    public boolean verificarEstado(String datosSalida, int numeroPuesto){
        Salida s = this.buscarSalida(datosSalida);
        if(s!=null){
            return s.asientoOcupado(numeroPuesto);
        }
        return false;
    }
    
    //REGISTROS DE PERSONAS
    //REGISTROS Y METODOS DE CONDUCTORES
    public String conductorRegistro(String nombre, String cedula, String celular, String correo, String añosExperiencia, int sueldo){
        String registro = "CONDUCTOR REGISTRADO CON EXITO\n\n";
        Conductor conductorNuevo = new Conductor(añosExperiencia, nombre, cedula, celular, correo, sueldo);
        listaPersonas.add(conductorNuevo);
        registro += conductorNuevo.toString();
        return registro;
    }
    //BUSCAR NOMBRE DE CONDUCTOR
    public ArrayList<String> nombresConductores(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if( p instanceof Conductor){
                Conductor c = (Conductor) p;
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
    // BUSCAR CLIENTES
    public Cliente buscarCliente(String nombre){
        for (Persona p : listaPersonas) {
            if(p instanceof Cliente && p.getNombre().equalsIgnoreCase(nombre) )
                return (Cliente) p;
        }
        return null;
    }
    //LISTAR CONDUCTORES
    public String conductoresListado(){
        String lista = "LISTADO DE CONDUCTORES\n\n";
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
    //REGISTRO DE CLIENTES
    public String clienteRegistro(String nombre, String cedula, String celular, String correo){
        String registro = "CLIENTE REGISTRADO CON EXITO\n";
        Cliente clienteNuevo = new Cliente(nombre, cedula, celular, correo);
        listaPersonas.add(clienteNuevo);
        registro += clienteNuevo.toString();
        return registro;
    }
    //LISTA PARA JCOMBOBOX DE CLIENTES
    public ArrayList<String> nombresClientes(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if( p instanceof Cliente){
                Cliente c = (Cliente) p;
                nombres.add(p.getNombre());
            }
        }
        return nombres;
    }
    //VENTAS
    public String ventaPasajeIndividual(String nombre, String textoSalida, int numeroAsiento1, int numeroAsiento2){
        Persona pasajero = buscarCliente(nombre);
        Salida salidaSeleccionada = buscarSalida(textoSalida);
        
        if(numeroAsiento2 > 0){
            if(!salidaSeleccionada.puestosVecinos(numeroAsiento1, numeroAsiento2)){
                return "LOS PUESTOS DEBEN SER VECINOS AL COMPRAR DOS ASIENTOS";
            }
            if(!this.verificarEstado(textoSalida, numeroAsiento1)||!this.verificarEstado(textoSalida, numeroAsiento2)){
                return "UNO O AMBOS PUESTOS YA OCUPADOS";
            }
            Puesto p1 = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento1];
            Puesto p2 = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento2];
            
            Pasaje pasaje1 = new Pasaje(pasajero, salidaSeleccionada, p1, salidaSeleccionada.getMyRuta().getTarifaBase());
            Pasaje pasaje2 = new Pasaje(pasajero, salidaSeleccionada, p2, salidaSeleccionada.getMyRuta().getTarifaBase());
            float valor = salidaSeleccionada.getMyRuta().getTarifaBase() *2;
            this.listaPasajes.add(pasaje1);
            this.listaPasajes.add(pasaje2);
            this.cajaCopetran.setTotalVendido(cajaCopetran.getTotalVendido() + valor);
            
            return "VENTA EXITOSA\n\n" + pasaje1 + "\n\n" + pasaje2;
        }
        else{
            if(!this.verificarEstado(textoSalida, numeroAsiento1)){
                return "PUESTO OCUPADO";
            }
            Puesto seleccionado = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento1];
            Pasaje nuevo = new Pasaje(pasajero, salidaSeleccionada, seleccionado, salidaSeleccionada.getMyRuta().getTarifaBase());
            this.listaPasajes.add(nuevo);
            
            return "VENTA EXITOSA\n\n" + nuevo;
        }
    }
    
    //VENTA IDA Y VUELTA
    public String idaYvuelta(String nombre, String textoSalida, int numeroAsiento){
        Persona pasajero = buscarCliente(nombre);
        Salida salidaSeleccionada = buscarSalida(textoSalida);
        
        float descuento = (salidaSeleccionada.getMyRuta().getTarifaBase() * 2) * 0.9F;
        
        if(!this.verificarEstado(textoSalida, numeroAsiento)){
            return "PUESTO YA OCUPADO";
        }
        
        Puesto seleccionado = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento];
        Pasaje nuevo = new Pasaje(pasajero, salidaSeleccionada, seleccionado, descuento);
        listaPasajes.add(nuevo);
        
        return "VENTA EXITOSA\n\n" + nuevo;
    }
    
    // HORA DE LA PC
    
    public void actualizarEstadoRealSalidas(){
        Date horaPc = new Date();
        for (Salida s : listaSalidas) {
            if(s.getEstado().equals("CANCELADA")){
                continue;
            }
            Date horaDeViaje = s.getFechaHora();
            
            java.util.Calendar llegada = java.util.Calendar.getInstance();
            llegada.setTime(horaDeViaje);
            llegada.add(java.util.Calendar.HOUR_OF_DAY, s.getMyRuta().getTiempoDeViaje());
            Date horaAproxLlegada = llegada.getTime();
            
            if(horaPc.before(horaDeViaje)){
                s.setEstado("PROGRAMADA");
            }
            else if(horaPc.after(horaDeViaje) && llegada.before(horaAproxLlegada)){
                s.setEstado("EN_VIAJE");
            }
            else{
                s.setEstado("FNALIZADO");
            }
        }
    }
    
}
