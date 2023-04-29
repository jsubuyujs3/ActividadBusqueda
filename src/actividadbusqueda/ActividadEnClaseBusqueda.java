package actividadbusqueda;

import java.util.ArrayList;

public class ActividadEnClaseBusqueda {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        ArrayList<Nodo> ruta = Busqueda.busquedaEnAnchura(laberinto);
        
        if (!ruta.isEmpty()) {
            System.out.println("Ruta encontrada:");
            for (int i = ruta.size() - 1; i >= 0; i--) {
                Nodo nodo = ruta.get(i);
                System.out.println("(" + nodo.getX() + ", " + nodo.getY() + ")");
            }
        } else {
            System.out.println("No se encontró una ruta.");
        }
    }
}