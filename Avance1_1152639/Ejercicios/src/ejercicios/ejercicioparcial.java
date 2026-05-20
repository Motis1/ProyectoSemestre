
package ejercicios;

import javax.swing.JOptionPane;

public class ejercicioparcial {
public static void main (String [] args){
    
int materias;
double promedio = 0, notas, suma = 0;
materias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantas materias esta cursando: "));
for (int i = 1; i <= materias ; i++){
    notas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + i + ": "));
    suma += notas;
    promedio = (double) suma / materias; 
} System.out.println("Su promedio se encuentra en: " + promedio );
if (promedio >= 4.5)
    System.out.println("Excelente");
if (promedio <= 4.4 && promedio >= 4.0)
    System.out.println("Sobresaliente");
if (promedio <= 3.9 && promedio >= 3.0)
    System.out.println("Aceptable");
if (promedio < 3.0)
    System.out.println("nsuficiente");
}    
}

// es importante inicializar con un = 0 las variables en las cuales se vaya a hacer una operacion matematica 
