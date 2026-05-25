package ups.poo.audiovisual.vista;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVista {

    private Scanner leer;

    public MenuVista() {
        this.leer = new Scanner(System.in);
    }                                                                                         

    // Clase MenuVista para interactuar con el usuario a través de la consola.
    public int menuPrincipal() {
        System.out.println("========================================");
        System.out.println("---- SISTEMA DE GESTIÓN AUDIOVISUAL ----");
        System.out.println("========================================");
        System.out.println("1. Agregar nueva Película al archivo");
        System.out.println("2. Mostrar todas las Películas (CSV)");
        System.out.println("3. Agregar nueva Serie de TV al archivo");
        System.out.println("4. Mostrar todas las Series de TV (CSV)");
        System.out.println("5. Agregar nuevo Documental al archivo");
        System.out.println("6. Mostrar todos los Documentales (CSV)");
        System.out.println("7. Salir del programa");
        System.out.print("Seleccione una opción: ");
        int opcion = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer del scanner
        return opcion;
    }

    // Método para pedir una lista de actores al usuario, separados por comas.
    public ArrayList<String> pedirActores() {
        System.out.print("Ingrese los 3 actores principales (separados por comas): ");
        String input = leer.nextLine();
        String[] actoresArray = input.split(",");
        ArrayList<String> actoresList = new ArrayList<>();
        for (String actor : actoresArray) {
            actoresList.add(actor.trim());
        }
        return actoresList;
    }

    // Método para pedir el número de temporadas y episodios al usuario.
    public int pedirTemporadas() {
        System.out.print("Ingrese el número de temporadas: ");
        return Integer.parseInt(leer.nextLine());
    }

    public int pedirEpisodios() {
        System.out.print("Ingrese el número de episodios: ");
        return Integer.parseInt(leer.nextLine());
    }

    // Método para pedir una lista de investigadores al usuario, separados por comas.
    public ArrayList<String> pedirInvestigadores() {
        System.out.print("Ingrese los 3 investigadores principales (separados por comas): ");
        String input = leer.nextLine();
        String[] investigadoresArray = input.split(",");
        ArrayList<String> investigadoresList = new ArrayList<>();
        for (String investigador : investigadoresArray) {
            investigadoresList.add(investigador.trim());
        }
        return investigadoresList;
    }

    // Métodos para pedir información al usuario.
    public String pedirTitulo() {
        System.out.print("Ingrese el título: ");
        return leer.nextLine();
    }

    public int pedirDuracionEnMinutos() {
        System.out.print("Ingrese la duración en minutos: ");
        return Integer.parseInt(leer.nextLine());
    }

    public String pedirGenero() {
        System.out.print("Ingrese el género: ");
        return leer.nextLine();
    }

    public String pedirDirector() {
        System.out.print("Ingrese el director: ");
        return leer.nextLine();
    }

    public String pedirEstudio() {
        System.out.print("Ingrese la distribuidora: ");
        return leer.nextLine();
    }

    public String pedirTema() {
        System.out.print("Ingrese una corta descripción del documental: ");
        return leer.nextLine();
    }

    public String pedirCanal() {
        System.out.print("Ingrese el canal de transmisión: ");
        return leer.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("> " + mensaje);
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
    }
}