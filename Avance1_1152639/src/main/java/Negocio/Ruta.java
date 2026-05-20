package Negocio;
public class Ruta {
    private int contadorRutas;
    private String codigo;
    private String origen;
    private String destino;
    private int tarifaBase;
    
    public Ruta (String destino, int tarifa){
        this.codigo = "C" + contadorRutas++;
        this.origen = "CUCUTA";
        this.destino = destino;
        this.tarifaBase = tarifa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + 
               "\nOrigen: " + origen + 
               "\nDestino: " + destino + 
               "\nTarifa base: " + tarifaBase;
    }
}
