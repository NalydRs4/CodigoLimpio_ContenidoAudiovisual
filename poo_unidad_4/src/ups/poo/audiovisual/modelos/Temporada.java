package ups.poo.audiovisual.modelos;

public class Temporada {
    private int temporadas;
    private int episodios;

    // Constructor de la clase Temporada que inicializa el número de temporada y la
    // cantidad de episodios.
    public Temporada(int temporadas, int episodios) {
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    // Getters y Setters para número de temporadas y cantidad de episodios.
    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return temporadas + " : " + episodios;
    }
}
