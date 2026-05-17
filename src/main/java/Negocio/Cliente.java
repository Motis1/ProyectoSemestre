package Negocio;
public class Cliente extends Persona {
    private String añoInscripcion;
    private String compras;

    public Cliente(String añoInscripcion, String nombre, String cedula, String celular, String correo,String compras) {
        super(nombre, cedula, celular, correo);
        this.añoInscripcion = añoInscripcion;
        this.compras = compras;
    }

    public String getCompras() {
        return compras;
    }

    public void setCompras(String compras) {
        this.compras = compras;
    }

    public String getAñoInscripcion() {
        return añoInscripcion;
    }

    public void setAñoInscripcion(String añoInscripcion) {
        this.añoInscripcion = añoInscripcion;
    }

    
}
