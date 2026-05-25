package ups.poo.audiovisual.modelos;
//Paquete -CONTENIDO- audiovisual

public class Investigador {
    private String nombre;

    public Investigador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    // El método toString se sobrescribe para mostrar el nombre del investigador cuando se imprima el objeto.
    @Override 
    public String toString() {
        return this.nombre;
    }
}
