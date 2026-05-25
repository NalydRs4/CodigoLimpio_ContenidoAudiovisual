package ups.poo.audiovisual.modelos;

import java.util.ArrayList;

public class Documental extends ContenidoAudiovisual {
    // Subclase Documental que Hereda de ContenidoAudiovisual.
    private String tema;
    private ArrayList<Investigador> investigadores;

    // Constructor de la clase Documental que llama al constructor de la clase padre (ContenidoAudiovisual) utilizando super().
    public Documental(String titulo, int duracionEnMinutos, String genero, String director, String tema) {
        super(titulo, duracionEnMinutos, genero, director);
        this.tema = tema;
        // Inicializamos la lista de investigadores como un ArrayList con una capacidad inicial de 3.
        this.investigadores = new ArrayList<>(3);
    }

    // Getter y Setter para Tema.
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    // Getter y Setter para Investigadores.
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    public boolean agregarInvestigador(Investigador investigador) {
        if (investigadores.size() < 3) {
            investigadores.add(investigador);
            return true; // Investigador agregado exitosamente.
        } else {
            return false; // No se pueden agregar más investigadores, ya que el límite es de 3.
        }
    }
}