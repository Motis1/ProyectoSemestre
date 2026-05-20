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
public class ejercicios {
     public static void main(String[] args){
     int dia;
     dia = Integer.parseInt(JOptionPane.showInputDialog("digita un numero del 1 - 7 "));
     while(dia < 1 || dia > 7){ 
     dia = Integer.parseInt(JOptionPane.showInputDialog("¿Ese numero q pa? escriba un numero 1 al 7:"));
     }      
      switch (dia) {
            case 1 -> JOptionPane.showMessageDialog(null, "Lunes");
            case 2 -> JOptionPane.showMessageDialog(null, "Martes");
            case 3 -> JOptionPane.showMessageDialog(null, "Miércoles");
            case 4 -> JOptionPane.showMessageDialog(null, "Jueves");
            case 5 -> JOptionPane.showMessageDialog(null, "Viernes");
            case 6 -> JOptionPane.showMessageDialog(null, "Sábado");
            case 7 -> JOptionPane.showMessageDialog(null, "Domingo");               
         }
     } 
}
