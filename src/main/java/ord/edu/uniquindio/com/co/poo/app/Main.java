package ord.edu.uniquindio.com.co.poo.app;

import ord.edu.uniquindio.com.co.poo.model.Universidad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Universidad universidad = new Universidad("Uniquindio", "Calle 12N");

        String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre");
        String identificacion = JOptionPane.showInputDialog(null, "Introduzca el identificacion");
        String mensaje = universidad.registrarEstudiante(nombre, identificacion);
        JOptionPane.showMessageDialog(null, mensaje);

        identificacion = "1904";
        String nombreNota = "Parcial 1";
        float valorNota = 5.0f;

        universidad.registrarNota(identificacion,nombreNota,valorNota);

        float nueoValorNota = 1.0f;
        universidad.actualizarNota(identificacion,nombreNota,nueoValorNota);
    }
}