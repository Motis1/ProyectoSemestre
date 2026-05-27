package Negocio;
public class Cliente {
    private String cedula;
    private String nombre;
    private String telefono;
    private String tipoCliente;

    public Cliente(String cedula, String nombre, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoCliente = "NORMAL";
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cedula: " + cedula + " - Nombre: " + nombre + " - Cel: " + telefono;
    }
    
    
}
