package ups.poo.audiovisual.test;

import ups.poo.audiovisual.datos.GestorArchivos;
import ups.poo.audiovisual.modelos.Pelicula;
import ups.poo.audiovisual.modelos.SerieDeTV;
import ups.poo.audiovisual.modelos.Actor;
import ups.poo.audiovisual.modelos.Documental;
import ups.poo.audiovisual.modelos.Investigador;
// Al clonar de GitHub, es posible que el IDE no reconozca los paquetes importados de pruebas. 
// Ejecutar primero el programa y luego habilitar los test para evitar que sobreescriba los archivos.
// En ese caso, selecionar source actions y Genetate o Enable Tests.
// Luego, ejecutar las pruebas desde el menú de Run, seleccionando la clase PruebasUnitarias.
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PruebasUnitarias {
    @Test
    public void testGuardarYCargarDocumentales() {
        GestorArchivos gestorArchivos = new GestorArchivos();
        List<Documental> documentalesPrueba = new ArrayList<>();
        Documental documental1 = new Documental("Documental", 60, "Historia", "Director 1", "Tema 1");
        documental1.agregarInvestigador(new Investigador("Investigador 1"));
        documentalesPrueba.add(documental1);
        gestorArchivos.guardarDocumentales(documentalesPrueba);
        List<Documental> documentalesCargados = gestorArchivos.cargarDocumentales();
        assertFalse(documentalesCargados.isEmpty());
        Documental documentalCargado = documentalesCargados.get(0);
        assertEquals("Documental", documentalCargado.getTitulo());
        assertEquals(60, documentalCargado.getDuracion());
        assertEquals("Historia", documentalCargado.getGenero());
        assertEquals("Director 1", documentalCargado.getDirector());
        assertEquals("Tema 1", documentalCargado.getTema());
        assertFalse(documentalCargado.getInvestigadores().isEmpty());
        assertEquals("Investigador 1", documentalCargado.getInvestigadores().get(0).getNombre());
    }

    @Test
    public void testCargarPeliculas() {
        GestorArchivos gestorArchivos = new GestorArchivos();
        List<Pelicula> peliculasPrueba = new ArrayList<>();
        Pelicula pelicula1 = new Pelicula("Pelicula", 120, "Accion", "Director 1", "Estudio 1");
        pelicula1.agregarActor(new Actor("Actor 1"));
        peliculasPrueba.add(pelicula1);
        gestorArchivos.guardarPeliculas(peliculasPrueba);
        List<Pelicula> peliculasCargadas = gestorArchivos.cargarPeliculas();
        assertFalse(peliculasCargadas.isEmpty());
        Pelicula peliculaCargada = peliculasCargadas.get(0);
        assertEquals("Pelicula", peliculaCargada.getTitulo());
        assertEquals(120, peliculaCargada.getDuracion());
        assertEquals("Accion", peliculaCargada.getGenero());
        assertEquals("Director 1", peliculaCargada.getDirector());
        assertEquals("Estudio 1", peliculaCargada.getEstudio());
        assertFalse(peliculaCargada.getActores().isEmpty());
        assertEquals("Actor 1", peliculaCargada.getActores().get(0).getNombre());
    }

    @Test
    public void testCargarSeries() {
        GestorArchivos gestorArchivos = new GestorArchivos();
        List<SerieDeTV> seriesPrueba = new ArrayList<>();
        SerieDeTV serie1 = new SerieDeTV("Serie", 45, "Drama", "Director 1", "Canal 1");
        serie1.agregarTemporada(1, 10);
        seriesPrueba.add(serie1);
        gestorArchivos.guardarSeries(seriesPrueba);
        List<SerieDeTV> seriesCargadas = gestorArchivos.cargarSeries();
        assertFalse(seriesCargadas.isEmpty());
        SerieDeTV serieCargada = seriesCargadas.get(0);
        assertEquals("Serie", serieCargada.getTitulo());
        assertEquals(45, serieCargada.getDuracion());
        assertEquals("Drama", serieCargada.getGenero());
        assertEquals("Director 1", serieCargada.getDirector());
        assertEquals("Canal 1", serieCargada.getCanal());
        assertFalse(serieCargada.getListaTemporadas().isEmpty());
        assertEquals(1, serieCargada.getListaTemporadas().get(0).getTemporadas());
        assertEquals(10, serieCargada.getListaTemporadas().get(0).getEpisodios());
    }

}
