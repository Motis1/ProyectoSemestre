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
public class ejercicio4 {
public static void main(String[] args) {
        int numeroC, pinta;
        String nombreCarta = "" , nombrePinta = "";
        int puntos = 0;
        int opcion;

        JOptionPane.showMessageDialog(null, "HOY SE JUEGA 21!!");

        do {
            numeroC = (int) Math.round(Math.random() * 13);
            while (numeroC == 0) {
                numeroC = (int) Math.round(Math.random() * 13);
            }
            switch (numeroC) {
                case 1:
                    nombreCarta = "A";
                    break;
                case 11:
                    nombreCarta = "J";
                    numeroC = 10;
                    break;
                case 12:
                    nombreCarta = "Q";
                    numeroC = 10;
                    break;
                case 13:
                    nombreCarta = "K";
                    numeroC = 10;
                    break;
                default:
                    nombreCarta = String.valueOf(numeroC);
            }
            pinta = (int) Math.round(Math.random() * 4);
            while (pinta == 0) {
                pinta = (int) Math.round(Math.random() * 4);
            }

            switch (pinta) {
                case 1:
                    nombrePinta = "Corazones";
                    break;
                case 2:
                    nombrePinta = "Diamantes";
                    break;
                case 3:
                    nombrePinta = "Picas";
                    break;
                case 4:
                    nombrePinta = "Tréboles";
                    break;
            }
            JOptionPane.showMessageDialog(null, "Tu carta es: " + nombreCarta + " de " + nombrePinta);
            puntos += numeroC;
            JOptionPane.showMessageDialog(null, "Tus puntos son: " + puntos);
            if (puntos == 21) {
                JOptionPane.showMessageDialog(null, "¡Ganador! Hiciste 21");
                break;
            } else if (puntos > 21) {
                JOptionPane.showMessageDialog(null, "Te pasaste de 21. ¡Perdio mi bro!");
                break;
            }
            opcion = JOptionPane.showConfirmDialog(null, "¿Deseas otra carta?", "Continuar", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "Juego terminado. Tus puntos finales fueron: " + puntos);
    }
}   

