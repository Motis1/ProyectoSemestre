package Negocio;
public class Conductor extends Persona {
    private String añosExperiencia;
    private int sueldo;

    public Conductor(String añosExperiencia, String nombre, String cedula, String celular, String correo, int sueldo) {
        super(nombre, cedula, celular, correo);
        this.añosExperiencia = añosExperiencia;
        this.sueldo = sueldo;
    }

    public String getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(String añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Datos Personales:\n" + super.toString() + 
               "\nAños de experiencia: " + añosExperiencia + 
               "\nSueldo: " + sueldo;
    }
}
