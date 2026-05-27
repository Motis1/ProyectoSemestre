package Negocio;
public class Persona implements Comparable<Persona>{
    protected String nombre;
    protected String cedula;
    protected String celular;
    protected String correo;

    public Persona(String nombre, String cedula, String celular, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int compareTo(Persona o) {
        return this.cedula.compareTo(o.getCedula());
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + 
               "\nCedula: " + cedula + 
               "\nCelular: " + celular + 
               "\nCorreo: " + correo;
    }
}
