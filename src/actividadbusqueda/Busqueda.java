package actividadbusqueda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Busqueda {

    public static ArrayList<Nodo> busquedaEnAnchura(Laberinto laberinto) {
        ArrayList<Nodo> ruta = new ArrayList<>();
        Nodo inicial = new Nodo(1, 1, 0, null);
        
        Queue<Nodo> frontera = new LinkedList<>();
        frontera.add(inicial);
        
        boolean[][] explorado = new boolean[laberinto.getLargo() + 2][laberinto.getAlto() + 2];
        
        while (!frontera.isEmpty()) {
            Nodo nodoActual = frontera.remove();
            
            if (laberinto.getValor(nodoActual.getX(), nodoActual.getY()) == laberinto.OBJETIVO) {
                // Encontramos el objetivo, reconstruir ruta
                while (nodoActual != null) {
                    ruta.add(nodoActual);
                    nodoActual = nodoActual.getPadre();
                }
                break;
            }
            
            ArrayList<Nodo> sucesores = nodoActual.getSucesores(laberinto);
            
            for (Nodo sucesor : sucesores) {
                int x = sucesor.getX();
                int y = sucesor.getY();
                
                if (!explorado[x][y]) {
                    explorado[x][y] = true;
                    frontera.add(sucesor);
                }
            }
        }
        
        return ruta;
    }
}
