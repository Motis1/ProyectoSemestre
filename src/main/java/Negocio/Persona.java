package Negocio;
public class Persona {
    private String cedula;
    private String nombre;
    private String cel;
    
    private Persona (String cedula,String nombre,String cel){
        this.cedula = cedula;
        this.nombre = nombre;
        this.cel = cel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
}
