package ups.poo.audiovisual.ejecucion;
import ups.poo.audiovisual.vista.MenuVista;
import ups.poo.audiovisual.controlador.CatalogoControlador;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        MenuVista vista = new MenuVista();
        CatalogoControlador controlador = new CatalogoControlador(vista);
        controlador.iniciar();
    }
}
