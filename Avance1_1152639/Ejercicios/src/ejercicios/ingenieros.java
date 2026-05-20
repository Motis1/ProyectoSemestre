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
public class ingenieros {
public static void main (String[] args){
int ident,icfes;
Long telefono;
String nombre; 

String[] estrato = {"Bajo","Medio bajo","Medio","Alto"};
String[] carrera = {"Ingenieria Sistemas","Ingeniería Electrónica","Ingeniería Civil"};
String [] aprub = {"Aprobado!!","No aprobado"};
int [] nimimo = {60,55,50}; 

int [][] precio = { {150000,200000,250000,450000,450000},{200000,250000,350000,850000,850000},{130000,180000,200000,300000,300000} }; 

nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
ident = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de identidad: "));
telefono = Long.parseLong(JOptionPane.showInputDialog("Ingrese su numero telefonico: "));
icfes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su puntaje del icfes: "));

String menucarrera = "A que carrera desea ingresar?\n ";
for (int i=0; i < carrera.length; i++){
    menucarrera += (i + 1)+ ". " + carrera[i] + "\n";
}
menucarrera += "4. cancelar";
int opcioncarrera = Integer.parseInt(JOptionPane.showInputDialog(menucarrera));

if (opcioncarrera >= 1 && opcioncarrera <= 3){
    String menestrato = "A que estrato perteneces? \n ";
    if (icfes >= nimimo[opcioncarrera - 1]){
        JOptionPane.showMessageDialog(null, "Felicidades!!, "+ aprub[0]);
        
    
    for (int i=0; i < estrato.length; i++){
        menestrato += (i + 1) + ". " + estrato[i] + "\n";
    }
    menestrato += "6. Cancelar";
    int opcionestrato = Integer.parseInt(JOptionPane.showInputDialog(menestrato));
    if (opcionestrato >= 1 && opcioncarrera <=3){
        int valor = precio[opcioncarrera - 1][opcionestrato - 1];
        JOptionPane.showMessageDialog(null, "el precio del semestre se encuentra en $" + valor);
    } else {
        JOptionPane.showMessageDialog(null, "Gracias por visitarnos!!");
    }
    } else {
        JOptionPane.showMessageDialog(null,"Lo sentimos, " + aprub [1] + ", intenta el siguiente semestre" );
    }
    } else {
    JOptionPane.showMessageDialog(null, "Gracias por visitarnos!!");
  }
  
 }
} 



