package ups.poo.audiovisual.controlador;

import ups.poo.audiovisual.vista.MenuVista;
import ups.poo.audiovisual.modelos.Actor;
import ups.poo.audiovisual.modelos.Pelicula;
import ups.poo.audiovisual.modelos.Investigador;
import ups.poo.audiovisual.modelos.SerieDeTV;
import ups.poo.audiovisual.modelos.Documental;
import ups.poo.audiovisual.datos.GestorArchivos;
import java.util.ArrayList;
import java.util.List;

public class CatalogoControlador {
    private MenuVista vista;
    private List<Pelicula> listaPeliculas;
    private List<SerieDeTV> listaSeries;
    private List<Documental> listaDocumentales;
    private GestorArchivos gestorArchivos;

    // Clase CatalogoControlador para manejar la lógica de negocio y la interacción entre el modelo y la vista.
    public CatalogoControlador(MenuVista vista) {
        // Inicializamos la vista, el gestor de archivos y las listas de películas,
        // series y documentales cargando los datos desde los archivos.
        this.vista = vista;
        this.gestorArchivos = new GestorArchivos();
        this.listaPeliculas = gestorArchivos.cargarPeliculas();
        this.listaSeries = gestorArchivos.cargarSeries();
        this.listaDocumentales = gestorArchivos.cargarDocumentales();
    }

    // Método para iniciar el controlador y mostrar el menú principal.
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.menuPrincipal();
            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    agregarSerieDeTV();
                    break;
                case 4:
                    mostrarSeriesDeTV();
                    break;
                case 5:
                    agregarDocumental();
                    break;
                case 6:
                    mostrarDocumentales();
                    break;
                case 7:
                    salir = true;
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para agregar una nueva película al catálogo, solicitando los datos al usuario a través de la vista.
    private void agregarPelicula() {
        vista.mostrarMensaje("--- Agregando Nueva Película ---");
        // try catch para manejar posibles errores de formato al ingresar datos.
        try {
            String titulo = vista.pedirTitulo();
            int duracion = vista.pedirDuracionEnMinutos();
            String genero = vista.pedirGenero();
            String director = vista.pedirDirector();
            String estudio = vista.pedirEstudio();
            ArrayList<String> actores = vista.pedirActores();
            Pelicula nuevaPelicula = new Pelicula(titulo, duracion, genero, director, estudio);
            for (String actor : actores) {
                nuevaPelicula.agregarActor(new Actor(actor));
            }
            listaPeliculas.add(nuevaPelicula);
            vista.mostrarMensaje("Película agregada <");
            gestorArchivos.guardarPeliculas(listaPeliculas);
        } catch (NumberFormatException error) {
            vista.mostrarMensaje("Error: Ingrese un formato de número válido de duración.");
            agregarPelicula(); // Volver a intentar agregar la película después de mostrar el mensaje de error.
        }
    }

    // Método para mostrar todas las películas del catálogo.
    private void mostrarPeliculas() {
        if (listaPeliculas.isEmpty()) {
            vista.mostrarMensaje("El catálogo está vacío.");
        } else {
            vista.mostrarMensaje("--- Catálogo de Películas ---");
            for (Pelicula p : listaPeliculas) {
                vista.mostrarMensaje(" ID: " + p.getId() + " - Título: " + p.getTitulo() + " <" + "\n Dirigida por: "
                        + p.getDirector() + "\n Distribuidora: "
                        + p.getEstudio() + "\n Duración: " + p.getDuracion() + " minutos" + "\n Género: "
                        + p.getGenero() + "\n Actores: " + p.getActores());
            }
        }
    }

    private void agregarSerieDeTV() {
        vista.mostrarMensaje("--- Agregando Nueva Serie de TV ---");
        try {
            String titulo = vista.pedirTitulo();
            System.out.println("Nota: La duración se refiere a la duración aproximada de cada episodio en minutos.");
            int duracion = vista.pedirDuracionEnMinutos();
            String genero = vista.pedirGenero();
            String director = vista.pedirDirector();
            String canal = vista.pedirCanal();
            int temporadas = vista.pedirTemporadas();
            int episodios = vista.pedirEpisodios();
            SerieDeTV nuevaSerie = new SerieDeTV(titulo, duracion, genero, director, canal);
            nuevaSerie.agregarTemporada(temporadas, episodios);
            listaSeries.add(nuevaSerie);
            vista.mostrarMensaje("Serie de TV agregada <");
            gestorArchivos.guardarSeries(listaSeries);
        } catch (NumberFormatException error) {
            vista.mostrarMensaje("Error: Ingrese un formato de número válido para duración, temporadas o episodios.");
            agregarSerieDeTV();
        }
    }

    private void mostrarSeriesDeTV() {
        if (listaSeries.isEmpty()) {
            vista.mostrarMensaje("El catálogo de series de TV está vacío.");
        } else {
            vista.mostrarMensaje("--- Catálogo de Series de TV ---");
            for (SerieDeTV s : listaSeries) {
                vista.mostrarMensaje(
                        " ID: " + s.getId() + " - Título: " + s.getTitulo() + "\n Creado por: " + s.getDirector()
                                + "\n Duración por episodio aproximada: " + s.getDuracion() + " minutos" + "\n Género: "
                                + s.getGenero() + "\n Canal: " + s.getCanal() + "\n Temporadas y episodios: "
                                + s.getListaTemporadas());
            }
        }
    }

    private void agregarDocumental() {
        vista.mostrarMensaje("--- Agregando Nuevo Documental ---");
        try {
            String titulo = vista.pedirTitulo();
            int duracion = vista.pedirDuracionEnMinutos();
            String genero = vista.pedirGenero();
            String director = vista.pedirDirector();
            String tema = vista.pedirTema();
            ArrayList<String> investigadores = vista.pedirInvestigadores();
            Documental nuevoDocumental = new Documental(titulo, duracion, genero, director, tema);
            for (String investigador : investigadores) {
                nuevoDocumental.agregarInvestigador(new Investigador(investigador));
            }
            listaDocumentales.add(nuevoDocumental);
            vista.mostrarMensaje("Documental agregado <");
            gestorArchivos.guardarDocumentales(listaDocumentales);
        } catch (NumberFormatException error) {
            vista.mostrarMensaje("Error: Ingrese un formato de número válido para duración.");
            agregarDocumental();
        }
    }

    private void mostrarDocumentales() {
        if (listaDocumentales.isEmpty()) {
            vista.mostrarMensaje("El catálogo de documentales está vacío.");
        } else {
            vista.mostrarMensaje("--- Catálogo de Documentales ---");
            for (Documental d : listaDocumentales) {
                vista.mostrarMensaje(" ID: " + d.getId() + " - Título: " + d.getTitulo() + "\n Dirigido por: "
                        + d.getDirector() + "\n Duración: " + d.getDuracion() + " minutos" + "\n Género: "
                        + d.getGenero() + "\n Tema: " + d.getTema() + "\n Investigadores: " + d.getInvestigadores());
            }
        }
    }
}