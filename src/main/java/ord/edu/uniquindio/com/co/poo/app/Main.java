package ord.edu.uniquindio.com.co.poo.app;

import ord.edu.uniquindio.com.co.poo.model.Universidad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Universidad universidad = new Universidad("Uniquindio", "Calle 12N");
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();



        byte NumeroEstudiantes;

        NumeroEstudiantes = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuantos estudiantes desea registrar?: "));

        for(int i = 0; i < NumeroEstudiantes; i++) {

            String Nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del estudiante: ");

            universidad.registrarEstudiante(Nombre, identificacion);
        }

        String AgregarNota = JOptionPane.showInputDialog(null, "¿Desea registrar una nota a  algun estudiante?, ingrese S para Si y N para No");
        char Decision = AgregarNota.charAt(0);

        if(Decision == 'S') {

            String identificacion = JOptionPane.showInputDialog("Ingrese la identifiacion del estudiante al que desea agregar la nota: ");

            Byte NumeroNotasRegistrar= Byte.parseByte(JOptionPane.showInputDialog("Ingrese el numero de notas a registrada: "));

            for(int j = 0; j < NumeroNotasRegistrar; j++) {

                String NombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota: ");
                float valor  = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de nota: "));
                universidad.registrarNota(identificacion, NombreNota, valor);

            }

            String Decicision = JOptionPane.showInputDialog(null, "¿Quiere ingresar mas notas?");
            Decision = Decicision.charAt(0);

        }

        String ActualizarNota = JOptionPane.showInputDialog(null, "¿Desea actualizar una nota a algun estudiante?, ingrese S para Si y N para No");
        char Decision2 = AgregarNota.charAt(0);

        if(Decision2 == 'S') {

            String identificacion = JOptionPane.showInputDialog("Ingrese la identifiacion del estudiante al que desea agregar la nota: ");
            String NombreNota = JOptionPane.showInputDialog("Ingrese el nombre de la nota: ");
            float valor  = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de nota: "));
            universidad.actualizarNota(identificacion, NombreNota, valor);

            String Decicision = JOptionPane.showInputDialog(null, "¿Quiere ingresar mas notas?");
            Decision2 = Decicision.charAt(0);

        }

        Estudiante estudiante = new Estudiante("papu","1234");
        ArrayList<Float> listaPromedios = new ArrayList<>();

        for(int i = 0; i < listaEstudiantes.size(); i++) {
            String identificacion = JOptionPane.showInputDialog("Ingrese la identifiacion del estudiante al que desea calcular la definitiva: ");
            float definitiva = estudiante.calcularDefinitva(identificacion);

            JOptionPane.showMessageDialog(null, "La definitiva del estudiante " + identificacion);
            listaPromedios.add(definitiva);
        }

        String Decision3 = JOptionPane.showInputDialog(null, "¿Desea ver la informacion de los estudiantes?, ingrese S para Si y N para No");

        if(Decision3.equals("S")) {
            
            for(int i = 0; i < listaEstudiantes.size(); i++) {
                System.out.println(listaEstudiantes.get(i) + "Definitiva: ");
                System.out.println(listaPromedios.get(i) + "\n");
            }
            


        }



    }
}
}
