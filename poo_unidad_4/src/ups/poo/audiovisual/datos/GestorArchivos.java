package ups.poo.audiovisual.datos;

import ups.poo.audiovisual.modelos.Pelicula;
import ups.poo.audiovisual.modelos.SerieDeTV;
import ups.poo.audiovisual.modelos.Actor;
import ups.poo.audiovisual.modelos.Documental;
import ups.poo.audiovisual.modelos.Investigador;
import ups.poo.audiovisual.modelos.Temporada;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    // Clase GestorArchivos para manejar la lectura y escritura de datos en archivos CSV.
    private final String RUTA_ARCHIVO_PELICULAS = "poo_unidad_4/peliculas.csv";
    private final String RUTA_ARCHIVO_SERIES = "poo_unidad_4/series.csv";
    private final String RUTA_ARCHIVO_DOCUMENTALES = "poo_unidad_4/documentales.csv";

    // Métodos para guardar Películas.
    public void guardarPeliculas(List<Pelicula> peliculas) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_PELICULAS))) {
            for (Pelicula p : peliculas) {
                String linea = p.getTitulo() + "," + p.getDuracion() + "," + p.getGenero() + "," + p.getDirector() + "," + p.getEstudio();
                String nombresActores = "";
                ArrayList<Actor> actores = p.getActores();
                // ArrayList de actores se convierte en una cadena de texto con los nombres separados por punto y coma.
                for (int i = 0; i < actores.size(); i++) {
                    nombresActores += actores.get(i).getNombre();
                    if (i < actores.size() - 1) {
                        nombresActores += ";";
                    }
                }
                linea = linea + "," + nombresActores;
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException error) {
            System.out.println("Error al guardar el archivo: " + error.getMessage());
        }
    }

    // Métodos para guardar Series de TV.
    public void guardarSeries(List<SerieDeTV> series) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_SERIES))) {
            for (SerieDeTV s : series) {
                String linea = s.getTitulo() + "," + s.getDuracion() + "," + s.getGenero() + "," + s.getDirector() + "," + s.getCanal();
                String cantidadTemporadas = "";
                ArrayList<Temporada> temporadas = s.getListaTemporadas();
                for (int i = 0; i < temporadas.size(); i++) {
                    Temporada temp = temporadas.get(i);
                    cantidadTemporadas += temp.getTemporadas() + "-" + temp.getEpisodios();
                    if (i < temporadas.size() - 1) {
                        cantidadTemporadas += ";";
                    }
                }
                linea = linea + "," + cantidadTemporadas;
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException error) {
            System.out.println("Error al guardar el archivo: " + error.getMessage());
        }
    }

    // Métodos para guardar Documentales.
    public void guardarDocumentales(List<Documental> documentales) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_DOCUMENTALES))) {
            for (Documental d : documentales) {
                String linea = d.getTitulo() + "," + d.getDuracion() + "," + d.getGenero() + ","
                        + d.getDirector() + "," + d.getTema();
                String nombresInvestigadores = "";
                ArrayList<Investigador> investigadores = d.getInvestigadores();
                for (int i = 0; i < investigadores.size(); i++) {
                    nombresInvestigadores += investigadores.get(i).getNombre();
                    if (i < investigadores.size() - 1) {
                        nombresInvestigadores += ";";
                    }
                }
                linea = linea + "," + nombresInvestigadores;
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException error) {
            System.out.println("Error al guardar el archivo: " + error.getMessage());
        }
    }

    // Método para cargar Películas desde el archivo CSV.
    public List<Pelicula> cargarPeliculas() {
        List<Pelicula> peliculasCargadas = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO_PELICULAS);
        // Verificar si el archivo existe antes de intentar leerlo.
        if (!archivo.exists())
            return peliculasCargadas;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 6) {
                    String titulo = columnas[0];
                    int duracion = Integer.parseInt(columnas[1]);
                    String genero = columnas[2];
                    String director = columnas[3];
                    String estudio = columnas[4];
                    String datosActores = columnas[5];
                    Pelicula p = new Pelicula(titulo, duracion, genero, director, estudio);                  
                    String[] arrayActores = datosActores.split(";");
                    for (String nombreActor : arrayActores){
                        Actor actor = new Actor(nombreActor);
                        p.agregarActor(actor);
                    }
                    peliculasCargadas.add(p);
                }
            }
        } catch (IOException | NumberFormatException error) {
            System.out.println("Error al leer el archivo: " + error.getMessage());
        }
        // Devolver la lista de películas cargadas.
        return peliculasCargadas;
    }

    // Métodos para cargar Series de TV desde el archivo CSV.
    public List<SerieDeTV> cargarSeries() {
        List<SerieDeTV> seriesCargadas = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO_SERIES);

        if (!archivo.exists())
            return seriesCargadas;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 6) {
                    String titulo = columnas[0];
                    int duracion = Integer.parseInt(columnas[1]);
                    String genero = columnas[2];
                    String director = columnas[3];
                    String canal = columnas[4];
                    SerieDeTV s = new SerieDeTV(titulo, duracion, genero, director, canal);
                    if (columnas.length > 5) {
                        String temporadasStr = columnas[5];
                        String[] temporadasArray = temporadasStr.split(";");
                        for (String temporada : temporadasArray) {
                            if (!temporada.trim().isEmpty()) {
                                String[] datosTemporada = temporada.split("-");
                                if (datosTemporada.length == 2) {
                                    int numero = Integer.parseInt(datosTemporada[0].trim());
                                    int episodios = Integer.parseInt(datosTemporada[1].trim());
                                    s.agregarTemporada(numero, episodios);
                                }
                            }
                        }
                    }
                    seriesCargadas.add(s);
                }
            }
        } catch (IOException | NumberFormatException error) {
            System.out.println("Error al leer el archivo: " + error.getMessage());
        }

        return seriesCargadas;
    }

    // Métodos para cargar Documentales desde el archivo CSV.
    public List<Documental> cargarDocumentales() {
        List<Documental> documentalesCargados = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO_DOCUMENTALES);
        // Verificar si el archivo existe antes de intentar leerlo.
        if (!archivo.exists())
            return documentalesCargados;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 6) {
                    String titulo = columnas[0];
                    int duracion = Integer.parseInt(columnas[1]);
                    String genero = columnas[2];
                    String director = columnas[3];
                    String tema = columnas[4];
                    String datosInvestigadores = columnas[5];                   
                    Documental d = new Documental(titulo, duracion, genero, director, tema);
                    String[] arrayInvestigadores = datosInvestigadores.split(";");
                    for (String nombreInvestigador : arrayInvestigadores){
                        Investigador investigador = new Investigador(nombreInvestigador);
                        d.agregarInvestigador(investigador);
                    }
                    documentalesCargados.add(d);
                }
            }
        } catch (IOException | NumberFormatException error) {
            System.out.println("Error al leer el archivo: " + error.getMessage());
        }
        // Devolver la lista de documentales cargados.
        return documentalesCargados;
    }
}
