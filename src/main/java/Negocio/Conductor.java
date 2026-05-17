package Negocio;
public class Conductor extends Persona {
    private String añosExperiencia;

    public Conductor(String añosExperiencia, String nombre, String cedula, String celular, String correo) {
        super(nombre, cedula, celular, correo);
        this.añosExperiencia = añosExperiencia;
    }

    public String getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(String añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}
