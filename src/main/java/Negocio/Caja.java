package Negocio;
public class Caja {
    private float montoCaja;
    private float totalVendido;
    private float totalRembolsado;
    private float ingresoNeto;
    
    public Caja(){
        this.montoCaja = 5000000F;
        this.totalVendido = 0.0F;
        this.totalRembolsado = 0.0F;
        this.ingresoNeto = 0.0F;
    }

    public float getMontoCaja() {
        return montoCaja;
    }

    public void setMontoCaja(float montoCaja) {
        this.montoCaja = montoCaja;
    }

    public float getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(float totalVendido) {
        this.totalVendido = totalVendido;
    }

    public float getTotalRembolsado() {
        return totalRembolsado;
    }

    public void setTotalRembolsado(float totalRembolsado) {
        this.totalRembolsado = totalRembolsado;
    }

    public float getIngresoNeto() {
        return ingresoNeto;
    }

    public void setIngresoNeto(float ingresoNeto) {
        this.ingresoNeto = ingresoNeto;
    }
    
    
    
}
