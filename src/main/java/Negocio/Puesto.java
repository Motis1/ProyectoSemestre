package Negocio;
public class Puesto {
    private int numeroPuestos; 
    private boolean ocupado;
    
    public Puesto (int numeroPuestos){
        this.numeroPuestos = numeroPuestos;
        this.ocupado = false;
    }

    public int getNumeroPuestos() {
        return numeroPuestos;
    }
    /*
    El numero de puestos no tiene setter ya que no se van a cambiar la capacidad porque es fija 
    */
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
