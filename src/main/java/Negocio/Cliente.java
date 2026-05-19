package Negocio;
public class Cliente extends Persona {
    private String añoInscripcion;
    private float totalCompras;

    public Cliente(String añoInscripcion, String nombre, String cedula, String celular, String correo,float totalCompras) {
        super(nombre, cedula, celular, correo);
        this.añoInscripcion = añoInscripcion;
        this.totalCompras = totalCompras;
    }

    public String getAñoInscripcion() {
        return añoInscripcion;
    }

    public void setAñoInscripcion(String añoInscripcion) {
        this.añoInscripcion = añoInscripcion;
    }

    public float getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(float totalCompras) {
        this.totalCompras = totalCompras;
    }

    @Override
    public String toString() {
        return "Datos personales:\n" + super.toString() + 
               "\nAño de inscripcion: " + añoInscripcion + 
               "\nTotal compras: " + totalCompras;
    }
}
