/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import javax.swing.JOptionPane;
public class ejercicio3 {
public static void main(String[] args) {
int edad,mene = Integer.MAX_VALUE;
int ne;
String nom,nombresmeno = "";
do{
nom = JOptionPane.showInputDialog("digite el nombre del estudiante");
edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad de "+nom+":"));
if(edad<mene){
    mene=edad;
    nombresmeno = nom; 
} else if (edad==mene){
  nombresmeno +=", "+nom;  
}
ne = JOptionPane.showConfirmDialog(null,"¿Desea continuar?","confirmacion", JOptionPane.YES_NO_OPTION);
}while(ne==JOptionPane.YES_OPTION);
JOptionPane.showMessageDialog(null,"la menor edad es "+mene+" / Estudiante(s): "+nombresmeno);
}   
}
