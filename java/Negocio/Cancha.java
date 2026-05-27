package Negocio;
public class Cancha {
    private String codigo;
    private String tipo;
    private int valorHora;
    private String estado;

    public Cancha(String codigo, String tipo, int valorHora, String estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valorHora = valorHora;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + 
               "\nTipo:" + tipo + 
               "\nValor (Hora): " + valorHora + 
               "\nEstado: " + estado;
    }
    
}
