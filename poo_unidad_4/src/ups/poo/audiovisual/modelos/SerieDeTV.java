package ups.poo.audiovisual.modelos;

import java.util.ArrayList;

public class SerieDeTV extends ContenidoAudiovisual {
    // Subclase SerieDeTV que HEREDA de ContenidoAudiovisual
    private String canal;
    private ArrayList<Temporada> listaTemporadas;

    // Constructor de la clase SerieDeTV que llama al constructor de la clase padre (ContenidoAudiovisual) utilizando super().
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, String canal, String director) {
        super(titulo, duracionEnMinutos, genero, director);
        this.canal = canal;
        this.listaTemporadas = new ArrayList<>();
    }

    // Getter y Setter para Canal.
    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    // Getter y Setter para ListaTemporadas.
    public ArrayList<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    public void agregarTemporada(int numero, int episodios) {
        Temporada nuevaTemporada = new Temporada(numero, episodios);
        this.listaTemporadas.add(nuevaTemporada);
    }

    public void setListaTemporadas(ArrayList<Temporada> listaTemporadas) {
        this.listaTemporadas = listaTemporadas;
    }

}
