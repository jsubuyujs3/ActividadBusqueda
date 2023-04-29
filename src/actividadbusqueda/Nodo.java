package actividadbusqueda;

import java.util.ArrayList;

public class Nodo {
    private int x;
    private int y;
    private int costo;
    private Nodo padre;
    
    public Nodo(int x, int y, int costo, Nodo padre) {
        this.x = x;
        this.y = y;
        this.costo = costo;
        this.padre = padre;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public Nodo getPadre() {
        return padre;
    }
    
    public ArrayList<Nodo> getSucesores(Laberinto laberinto) {
        ArrayList<Nodo> sucesores = new ArrayList<>();
        
        // Arriba
        if (laberinto.getValor(x, y-1) != laberinto.OBSTACULO) {
            sucesores.add(new Nodo(x, y-1, costo+1, this));
        }
        
        // Abajo
        if (laberinto.getValor(x, y+1) != laberinto.OBSTACULO) {
            sucesores.add(new Nodo(x, y+1, costo+1, this));
        }
        
        // Izquierda
        if (laberinto.getValor(x-1, y) != laberinto.OBSTACULO) {
            sucesores.add(new Nodo(x-1, y, costo+1, this));
        }
        
        // Derecha
        if (laberinto.getValor(x+1, y) != laberinto.OBSTACULO) {
            sucesores.add(new Nodo(x+1, y, costo+1, this));
        }
        
        return sucesores;
    }
}
