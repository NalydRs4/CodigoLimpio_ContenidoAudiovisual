package ups.poo.audiovisual.modelos;

import java.util.ArrayList;

public class Pelicula extends ContenidoAudiovisual {
    // Subclase Pelicula que HEREDA de ContenidoAudiovisual.
    private String estudio;
    private ArrayList<Actor> actores;

    // Constructor de la clase Pelicula que llama al constructor de la clase padre (ContenidoAudiovisual) utilizando super().
    public Pelicula(String titulo, int duracionEnMinutos, String genero, String director, String estudio) {
        super(titulo, duracionEnMinutos, genero, director);
        this.estudio = estudio;
        // Inicializamos la lista de actores como un ArrayList con una capacidad inicial de 3.
        this.actores = new ArrayList<>(3);
    }

    // Getter y Setter para Estudio.
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    // Getter y Setter para Actores.
    public ArrayList<Actor> getActores() {
        return actores;
    }

    public boolean agregarActor(Actor actor) {
        if (actores.size() < 3) {
            actores.add(actor);
            return true; // Actor agregado exitosamente.
        } else {
            return false; // No se pueden agregar más actores, ya que el límite es de 3.
        }
    }

}