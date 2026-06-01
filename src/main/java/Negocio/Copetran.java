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
        this.cajaCopetran = new Caja();
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
        Cliente cli1 = new Cliente("Jesus Ochoa", "1095040316", "3165482945", "Jesus@gmail.com");
        Cliente cli2 = new Cliente("Manuel Marciales", "1004352648", "3125487956", "Manuel@gmail.com");
        Cliente cli3 = new Cliente("Franco Reales", "105487952", "3254987612", "Franco@gmail.com");
        Cliente cli4 = new Cliente("Valerie Chaustre", "154879563", "3284597865", "Valerie@gmail.com");
        Cliente cli5 = new Cliente("Diana Vargas", "100026485", "3023156487", "Diana@gmail.com");
        this.listaPersonas.add(cond1);
        this.listaPersonas.add(cond2);
        this.listaPersonas.add(cond3);
        this.listaPersonas.add(cond4);
        this.listaPersonas.add(cli1);
        this.listaPersonas.add(cli2);
        this.listaPersonas.add(cli3);
        this.listaPersonas.add(cli4);
        this.listaPersonas.add(cli5);
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
    public Salida buscarSalida(String texto){
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
            return s.getAsientosOcupados()[numeroPuesto];
        }
        return false;
    }
    //LISTAR SALIDAS POR ESTADOS
    public ArrayList<String> listarSalidasEstado(){
        ArrayList<String> salidas = new ArrayList<>();
        for (int i = 0; i < listaSalidas.size(); i++) {
            String reporte = "\nID: " + listaSalidas.get(i).getiD() + " - DESTINO: " + listaSalidas.get(i).getMyRuta().getDestino() + " - ESTADO: " + listaSalidas.get(i).getEstado();
            salidas.add(reporte);
        }
        return salidas;
    }
    //JCOMBO PARA REPROGRAMACION
    public ArrayList<String> listarSalidasCliente(String nombre){
        Cliente cliente = buscarCliente(nombre);
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyy HH:mm");
        ArrayList<String> salidas = new ArrayList<>();
        for (Pasaje p : listaPasajes) {
            if(p.getMyPasajero().getNombre().equalsIgnoreCase(cliente.getNombre()) && p.getMySalida().getEstado().equals("PROGRAMADA")){
                String combo = p.getMySalida().getMyRuta().getDestino()+ " - " + fecha.format(p.getMySalida().getFechaHora());
                salidas.add(combo);
            }
        }
        return salidas;
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
    //RF: VENTAS
    public String ventaPasajeIndividual(String nombre, String textoSalida, int numeroAsiento1, int numeroAsiento2){
        Persona pasajero = buscarCliente(nombre);
        Salida salidaSeleccionada = buscarSalida(textoSalida);
        
        if(numeroAsiento2 > 0){
            if(!salidaSeleccionada.puestosVecinos(numeroAsiento1, numeroAsiento2)){
                return "LOS PUESTOS DEBEN SER VECINOS AL COMPRAR DOS ASIENTOS";
            }
            if(salidaSeleccionada.getAsientosOcupados()[numeroAsiento1]||salidaSeleccionada.getAsientosOcupados()[numeroAsiento2]){
                return "PUESTO/S OCUPADOS";
            }
            
            Puesto p1 = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento1];
            Puesto p2 = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento2];
            Pasaje pasaje1 = new Pasaje(pasajero, salidaSeleccionada, p1, salidaSeleccionada.getMyRuta().getTarifaBase());
            Pasaje pasaje2 = new Pasaje(pasajero, salidaSeleccionada, p2, salidaSeleccionada.getMyRuta().getTarifaBase());
            float valor = salidaSeleccionada.getMyRuta().getTarifaBase() *2;
            this.listaPasajes.add(pasaje1);
            this.listaPasajes.add(pasaje2);
            salidaSeleccionada.getAsientosOcupados()[numeroAsiento1] = true;
            salidaSeleccionada.getAsientosOcupados()[numeroAsiento2] = true;
            
            this.cajaCopetran.setTotalVendido(cajaCopetran.getTotalVendido() + valor);
            
            return "VENTA EXITOSA\n\n" + pasaje1 + "\n\n" + pasaje2;
        }
        else{
            if(salidaSeleccionada.getAsientosOcupados()[numeroAsiento1]){
                return "PUESTO OCUPADO";
            }
            Puesto seleccionado = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento1];
            Pasaje nuevo = new Pasaje(pasajero, salidaSeleccionada, seleccionado, salidaSeleccionada.getMyRuta().getTarifaBase());
            this.listaPasajes.add(nuevo);
            salidaSeleccionada.getAsientosOcupados()[numeroAsiento1] = true;
            return "VENTA EXITOSA\n\n" + nuevo;
        }
    }
    
    //RF: VENTA IDA Y VUELTA
    public String idaYvuelta(String nombre, String textoSalida, int numeroAsiento){
        Persona pasajero = buscarCliente(nombre);
        Salida salidaSeleccionada = buscarSalida(textoSalida);
        
        float descuento = (salidaSeleccionada.getMyRuta().getTarifaBase() * 2) * 0.9F;
        salidaSeleccionada.getAsientosOcupados()[numeroAsiento] = true;
        Puesto seleccionado = salidaSeleccionada.getMyBus().getMyPuestos()[numeroAsiento];
        Pasaje nuevo = new Pasaje(pasajero, salidaSeleccionada, seleccionado, descuento);
        listaPasajes.add(nuevo);
        
        return "VENTA EXITOSA\n\n" + nuevo;
    }
    
    // TIEMPOS
    // HORA DE LA PC
    //METODO AUXILIAR PARA MOVER A LOS PASAJEROS 
    private void procesarPuestosPasajeros(String textoSalida){
        Salida salidaCancelada = buscarSalida(textoSalida);
        for (int i = 0; i < listaPasajes.size(); i++) {
            Pasaje pasajeCliente = listaPasajes.get(i);
            if(pasajeCliente.getMySalida().equals(salidaCancelada)){
                Salida planB = buscarSalidaAlternativa(salidaCancelada);
                
                if(planB != null){
                    for (int j = 0; j < planB.getAsientosOcupados().length; j++) {
                        if(!planB.getAsientosOcupados()[j]){
                            planB.getAsientosOcupados()[j] = true;
                            pasajeCliente.setMySalida(planB);
                            pasajeCliente.setMyPuesto(planB.getMyBus().getMyPuestos()[j]);
                            break;
                        }
                    }
                }else{
                    this.cajaCopetran.setMontoCaja(this.cajaCopetran.getMontoCaja() - pasajeCliente.getValor());
                    this.cajaCopetran.setTotalVendido(this.cajaCopetran.getTotalVendido() - pasajeCliente.getValor());
                    this.cajaCopetran.setTotalRembolsado(this.cajaCopetran.getTotalRembolsado() + pasajeCliente.getValor());
                }
            }
        }
    }
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
            
            long tiempoActual = horaPc.getTime();
            long tiempoSalida = horaDeViaje.getTime();
            long tiempoLlegada = horaAproxLlegada.getTime();
            
            if(tiempoActual < tiempoSalida){
                s.setEstado("PROGRAMADA");
            }
            else if(tiempoActual >= tiempoSalida && tiempoActual <= tiempoLlegada){
                if(s.getEstado().equals("PROGRAMADA") || s.getEstado().equals("DISPONIBLE")){
                    int puestosOcupados = 0;
                    for(boolean ocupado : s.getAsientosOcupados()){
                        if (ocupado) puestosOcupados++;
                    }
                    if(puestosOcupados <5){
                        s.setEstado("CANCELADA");
                        for (int i = 0; i < s.getAsientosOcupados().length; i++) {
                            s.getAsientosOcupados()[i] = true;
                        }
                        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String textoIdentificador = s.getMyRuta().getDestino() + " - " + fecha.format(s.getFechaHora());
                        procesarPuestosPasajeros(textoIdentificador);
                        continue;
                    }
                }
                s.setEstado("EN_VIAJE");
            }
            else {
                s.setEstado("FINALIZADO");
                s.getMyBus().setEstado("DISPONIBLE");
            }
        }
    }
    //EVALUAR SI UN BUS ESTA DISPONIBLE SEGUN EL DICTAMEN DE LOS 3 DIAS 
    public boolean busEstadoDisponible(String placa){
        Date horaActual = new Date();
        
        for (Salida s : listaSalidas) {
            if(s.getEstado().equals("CANCELADA")){
                continue;
            }
            if(s.getMyBus().getPlacaUnica().equals(placa)){
                if(s.getEstado().equals("EN_VIAJE")){
                    return false;
                }
                if(s.getEstado().equals("PROGRAMADA")){
                    return false;
                }
                long tiempoActual = horaActual.getTime();
                long tiempoSalida = s.getFechaHora().getTime();
                long diferenciaHoras = (tiempoActual - tiempoSalida)/(1000*60*60);
                
                if(diferenciaHoras >= 0 && diferenciaHoras < 24){
                    return false;
                }
            }
        }return true;
    }
    //EVALUAR SI UN CODNCUTOR ESTA DISPONIBLE 
    public boolean conductorDisponible(String nombre){
        Date horaPc = new Date();
        for (Salida s : listaSalidas) {
            if(s.getEstado().equals("CANCELADA")){
                continue;
            }
            if(s.getMyBus().getConductor().getNombre().equals(nombre)){
                if(s.getEstado().equals("EN_VIAJE")){
                    return false;
                }
                if(s.getEstado().equals("PROGRAMADA")){
                    return false;
                }
                long tiempoActual = horaPc.getTime();
                long tiempoSalida = s.getFechaHora().getTime();
                long diferenciaHoras = (tiempoActual - tiempoSalida)/(1000*60*60);
                
                if(diferenciaHoras >= 0 && diferenciaHoras < 24){
                    return false;
                }
            }
        } return true;
    }
    //METODO AUXILIAR PARA BUSCAR UN BUS ALTERNATIVO 
    private Salida buscarSalidaAlternativa(Salida origen) {
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    for (Salida s : listaSalidas) {
        if (!s.equals(origen) && 
            s.getMyRuta().getDestino().equalsIgnoreCase(origen.getMyRuta().getDestino()) &&
            s.getEstado().equals("PROGRAMADA") &&
            !s.getMyBus().getPlacaUnica().equalsIgnoreCase(origen.getMyBus().getPlacaUnica()) &&
            fmt.format(s.getFechaHora()).equals(fmt.format(origen.getFechaHora()))) {
            
                for (boolean ocu : s.getAsientosOcupados()) {
                    if (!ocu) return s;
                }
            }
        }return null; 
    }
    //REPROGRAMAR POR PETICION DEL CLIENTE 
    public String reprogramarPasajeCliente(String nombreCliente, String textoSalida){
        Salida salidaCancelada = buscarSalida(textoSalida);
        Persona pasajero = buscarCliente(nombreCliente);
        Pasaje pasajeCliente = null;
        for (Pasaje p : listaPasajes) {
            if(p.getMyPasajero().equals(pasajero)&&p.getMySalida().equals(salidaCancelada)){
                pasajeCliente = p;
                break;
            }
        }
        Salida planB = buscarSalidaAlternativa(salidaCancelada);
        if(planB != null){
            for (int i = 0; i < planB.getAsientosOcupados().length; i++) {
                if(!planB.getAsientosOcupados()[i]){
                    for (int j = 0; j < salidaCancelada.getMyBus().getMyPuestos().length; j++) {
                        if(salidaCancelada.getMyBus().getMyPuestos()[j].equals(pasajeCliente.getMyPuesto())){
                            salidaCancelada.getAsientosOcupados()[j] = false;
                            break;
                        }
                    }
                    planB.getAsientosOcupados()[i] = true;
                    pasajeCliente.setMySalida(planB);
                    pasajeCliente.setMyPuesto(planB.getMyBus().getMyPuestos()[i]);
                    
                    return planB.toString();
                }
            }
        }
        for (int i = 0; i < salidaCancelada.getMyBus().getMyPuestos().length; i++) {
            if(salidaCancelada.getMyBus().getMyPuestos()[i].equals(pasajeCliente.getMyPuesto())){
                salidaCancelada.getAsientosOcupados()[i] = false;
                break;
            }
        }
        salidaCancelada.setEstado("CANCELADA");
        this.cajaCopetran.setMontoCaja(this.cajaCopetran.getMontoCaja() - pasajeCliente.getValor());
        this.cajaCopetran.setTotalVendido(this.cajaCopetran.getTotalVendido() - pasajeCliente.getValor());
        this.cajaCopetran.setTotalRembolsado(this.cajaCopetran.getTotalRembolsado() + pasajeCliente.getValor());
        
        return "CANCELADO POR FALTA DE SALIDAS, DINERO REEMBOLSADO";
    }
}
