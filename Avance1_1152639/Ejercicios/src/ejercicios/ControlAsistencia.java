import javax.swing.JOptionPane;

public class ControlAsistencia {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes:"));
        int aprobados = 0, reprobados = 0;

        for (int i = 1; i <= n; i++) {
            String nombre = JOptionPane.showInputDialog("Nombre del estudiante " + i + ":");
            int asistencias = Integer.parseInt(JOptionPane.showInputDialog("Clases asistidas:"));
            int participaciones = Integer.parseInt(JOptionPane.showInputDialog("Participaciones:"));

            double porcentajeAsistencia = (asistencias / 16.0) * 100;

            if (porcentajeAsistencia >= 80 && participaciones > 3) {
                JOptionPane.showMessageDialog(null, nombre + " aprobó");
                aprobados++;
            } else {
                JOptionPane.showMessageDialog(null, nombre + " reprobó");
                reprobados++;
            }
        }

        JOptionPane.showMessageDialog(null, 
            "Total aprobados: " + aprobados + "\nTotal reprobados: " + reprobados);
    }
}

