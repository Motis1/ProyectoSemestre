package Negocio;
public class Puesto {
    private int numeroPuestos; 
    private String estado;
    
    public Puesto (int numeroPuestos){
        this.numeroPuestos = numeroPuestos;
        this.estado = "LIBRE";
    }

    public int getNumeroPuestos() {
        return numeroPuestos;
    }
    /*
    El numero de puestos no tiene setter ya que no se van a cambiar la capacidad porque es fija 
    */

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
