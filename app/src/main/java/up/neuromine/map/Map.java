package up.neuromine.map;

import java.util.Arrays;

public class Map {

    private final int TAILLE_MAP;

    private int nbMines;
    private int nbDiscovered;
    private Tile[][] tiles;

    public Map(int taille){
        nbMines = 0;
        nbDiscovered = 0;
        TAILLE_MAP = taille;
        tiles = new Tile[TAILLE_MAP][TAILLE_MAP];
    }

    public int getnbMines(){
        return nbMines;
    }

    public int getnbDiscovered(){
        return nbDiscovered;
    }

    public void addMine(){
        nbMines += 1;
    }

    public void subMine(){
        nbMines -= 1;
    }

    public void addDiscovered(){
        nbDiscovered += 1;
    }

    public void subDiscovered(){
        nbDiscovered -= 1;
    }
}
