package ups.poo.audiovisual.modelos;

public class Actor {
    private String nombre;

    // Constructor de la clase Actor que recibe el nombre del actor.
    public Actor(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para el nombre del actor.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // El método toString se sobrescribe para mostrar el nombre del actor cuando se imprima el objeto.
    @Override
    public String toString() {
        return this.nombre;
    }
}
