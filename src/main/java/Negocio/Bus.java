package Negocio;
public class Bus {
    private String placaUnica;
    private String tipoServicio;
    private String estado;
    private Puesto[] myPuestos;
    private int capacidad;
    
    public Bus(String placaUnica, String tipoServicio, String estado){
        this.placaUnica = placaUnica;
        this.tipoServicio = tipoServicio;
        this.estado = estado;
        this.crearEspacio();
        this.crearPuesto();
    }
    
    private void crearEspacio(){
        if(tipoServicio.equalsIgnoreCase("Ejecutivo")){
            capacidad = 30;
        }else if(tipoServicio.equalsIgnoreCase("Normal")){
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

    public String getPlacaUnica() {
        return placaUnica;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getEstado() {
        return estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

     //PROFESORA: NO SE OBSERVA METODOS PARA MANIPULAR LAS PARTES... ES TODO PARTE FISICO
    
}
