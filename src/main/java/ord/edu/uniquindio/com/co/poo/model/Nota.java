package ord.edu.uniquindio.com.co.poo.model;

public class Nota {

    public float valor;
    private String nombre;


    public Nota(String nombre, double valor) {

        this.nombre = nombre;
        this.valor = (int) valor;

    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return (int) valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String   toString() {
        return "Nota{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String actualizarNota(Float nuevoValorNota) {
        setValor(nuevoValorNota);
        return "Nora actualizada";
    }
}
