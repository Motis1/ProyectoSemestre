package Negocio;
public class Bus {
    private String placaUnica;
    private String tipoServicio;
    private String estado;
    private Puesto[] myPuestos;
    private Conductor conductor;
    private int capacidad;
    
    public Bus(String placaUnica, String tipoServicio,Conductor conductor){
        this.placaUnica = placaUnica;
        this.tipoServicio = tipoServicio;
        this.estado = "DISPONIBLE";
        this.conductor = conductor;
        this.crearEspacio();
        this.crearPuesto();
    }
    
    private void crearEspacio(){
        if(tipoServicio.equalsIgnoreCase("NORMAL")){
            capacidad = 30;
        }else if(tipoServicio.equalsIgnoreCase("EJECUTIVO")){
            capacidad = 40;
        }
        this.crearPuesto();
    }
    private void crearPuesto(){
        this.myPuestos = new Puesto[capacidad];
        for(int i=0;i<capacidad;i++){
            this.myPuestos[i] = new Puesto(i+1);
        }
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getPlacaUnica() {
        return placaUnica;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setPlacaUnica(String placaUnica) {
        this.placaUnica = placaUnica;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

     //PROFESORA: NO SE OBSERVA METODOS PARA MANIPULAR LAS PARTES... ES TODO PARTE FISICO

    @Override
    public String toString() {
        return "Placa: " + placaUnica + 
               "\nTipo de servicio: " + tipoServicio + 
               "\nEstado: " + estado +
               "\nCapacidad: " + capacidad + "Puestos" +
               "\nConductor :\n" + conductor;
    }
    
    
    
}
