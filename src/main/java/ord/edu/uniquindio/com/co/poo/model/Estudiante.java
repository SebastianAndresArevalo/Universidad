package ord.edu.uniquindio.com.co.poo.model;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Nota> listaNotas;

    public Estudiante(String nombre, String identificacion) {

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.listaEstudiantes = new ArrayList<Estudiante>();
        this.listaNotas = new ArrayList<>();


    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    public String registrarEstudiante(String nombre, String identificacion) {

        String mensaje = "";
        Estudiante encontrado = null;
        Estudiante nuevoEstudiante = null;


        encontrado = buscarEstudiante(identificacion);
        if (encontrado != null) {
            mensaje = "Estudiante Ya registrado con exito";
            return mensaje;
        }
        nuevoEstudiante = new Estudiante(nombre, identificacion);
        listaEstudiantes.add(nuevoEstudiante);
        mensaje = "El estudiante se ha registrado con exito";
        return mensaje;


    }


    private Estudiante buscarEstudiante(String identificacion) {
        Estudiante encontrado = null;

        for (Estudiante estudianteAux : listaEstudiantes) {
            if (estudianteAux.getIdentificacion().equals(identificacion)) {
                return estudianteAux;
            }
        }

        return encontrado;
    }

    public String registrarNota(String nombreNota, double valorNota) {
        int posDisponible = -1;
        posDisponible = buscarPosicion();

        if (posDisponible == -1){
            return "No hay espacio disoinible";
        }else {
            Nota nota = new Nota(nombreNota, valorNota);
            listaNotas.set(posDisponible, nota);
            return "La nota fue registrada con exito";
        }


    }

    public float calcularDefinitva(){
        int sumatoria = 0;
        float definitiva = 0;

        for(Nota notaAux : listaNotas){

            if (notaAux != null) {
                sumatoria += notaAux.getValor();
            }

        }

        definitiva = (float) sumatoria / 5;

        return definitiva;

    }

    private int buscarPosicion(){

        for (int i = 0; i < listaNotas.toArray().length; i++) {
            if (listaNotas.get(i) ==null){
                return i;
            }
        }

        return -1;

    }

    public String actualizarNota(String nombreNota, float nuevovalorNota) {
        String mensaje = "";

        Nota notaEncontrada = buscarNota(nombreNota);
        if (notaEncontrada == null) {
            notaEncontrada.valor = nuevovalorNota;
            return mensaje;
        }else {
            mensaje = "La nota fue actualizada con exito";
        }

        return mensaje;
    }

    public Nota buscarNota(String nombreNota) {

        Nota notaEncontrada = null;

        for (Nota nota : listaNotas) {
            if (nota != null && nota.getNombre().equals(nombreNota)) {
                notaEncontrada = nota;
                break;
            }
        }

        return notaEncontrada;

    }
}
