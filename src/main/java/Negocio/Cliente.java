package Negocio;

import java.util.ArrayList;

public class Cliente extends Persona {
    
    public Cliente(String nombre, String cedula, String celular, String correo) {
        super(nombre, cedula, celular, correo);
    }
    
    @Override
    public String toString() {
        return "Datos personales:\n" + super.toString();
    }
}
