package ups.poo.audiovisual.modelos;

public abstract class ContenidoAudiovisual {
    // Clase Padre ContenidoAudiovisual.
    private static int contar = 0;
    private String titulo;
    private int duracion;
    private String genero;
    private int id;
    private String director;

    // Atributos comunes a Peliculas, Series y Documentales.
    public ContenidoAudiovisual(String titulo, int duracion, String genero, String director) {
        this.id = contar++;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
    }

    // Getter y Setter para Titulo.
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para Duracion.
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // Getter y Setter para Genero.
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter para ID.
    public int getId() {
        return id;
    }

    // Getter y Setter para Director.
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}