/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author GAMEMAX
 */
public class telefonia {
public static void main (String[] args){
String nombre;
long celular;
String [] plan = {"Bronce","plata","Oro"};
int [] valor = {100,200,300};
int minuto = 300;

nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su documento de identidad:"));
celular = Long.parseLong(JOptionPane.showInputDialog("Ingrese su celular:"));

String menuatm = "Seleccione su plan:\n";
for (int i = 0; i < plan.length; i++){
    menuatm += (i+1) + "- " + plan[i] + " (" + valor[i] + " minutos)\n ";
} 
int opcionplan = Integer.parseInt(JOptionPane.showInputDialog(menuatm));
if (opcionplan >= 1 && opcionplan <= plan.length){
    int minutosusa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de minutos que ha usado:"));
    int minutosplan = valor[opcionplan -1];
    if (minutosusa <= minutosplan){
        int minutosrest = minutosplan - minutosusa;
        int costo = valor[opcionplan - 1] * minuto;
        double regalo = valor[opcionplan - 1] * 0.1;
        double total = costo + (costo*0.18);
        
        JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"\nPlan: "+plan[opcionplan-1]+"\nUso: "+minutosusa+"\nTe faltan: "+minutosrest+"\nTotal: "+ total + " COP"+ "\nTe regalamos: " + regalo + " minutos"); 
    } else {
       int minutoextra = minutosusa - minutosplan;
       double minutosextra = minutoextra + (minutoextra * (minuto+(minuto*0.15)));
       int costo = valor[opcionplan - 1] * minuto;
       double regalo = valor[opcionplan - 1] * 0.1;
       double total = costo + minutosextra;
       double totall = total + (total*0.18);
       
       JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"\nPlan: "+plan[opcionplan-1]+"\nUso: "+minutosusa+"\nMinutos extra: "+minutoextra+"\nTotal: "+ totall + " COP"+ "\nTe regalamos: " + regalo + " minutos"); 
    }
}else{
    JOptionPane.showMessageDialog(null, "Gracias por confiar en nostros!!!");
}
}  
}
