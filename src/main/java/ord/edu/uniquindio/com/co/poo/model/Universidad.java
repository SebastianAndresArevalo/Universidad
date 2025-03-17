package ord.edu.uniquindio.com.co.poo.model;

import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Nota> listaNotas;


    public Universidad(String nombre, String ubicacion) {

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<>();
        this.listaNotas = new ArrayList<>();

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
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

    public String registrarNota(String identificacion, String nombreNota, float valorNota) {

        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);

        if (estudianteEncontrado == null) {
            mensaje = estudianteEncontrado.registrarNota(nombreNota, valorNota);
        } else {
            mensaje = "El estudiante no esta registrado";
        }
        return mensaje;
    }

    public String actualizarNota(String identificacion, String nombreNota, float nuevovalorNota) {
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if (estudianteEncontrado == null) {
            estudianteEncontrado.actualizarNota(nombreNota, nuevovalorNota);
        }

        return mensaje;
    }

    public String registrarEstudiante(String nombre, String identificacion) {

        String mensaje              = "";
        Estudiante encontrado       = null;
        Estudiante nuevoEstudiante  = null;

        encontrado = buscarEstudiante(identificacion);
        if(encontrado != null){// ya existe en el sistema
            mensaje = "El estudiante "+ encontrado.getNombre() +" ya existe en la universidad";
            return mensaje;
        }
        nuevoEstudiante = new Estudiante(nombre,identificacion);
        listaEstudiantes.add(nuevoEstudiante);
        mensaje = "El estudiante fúe registrado exitosamente";
        return mensaje;

    }
}
