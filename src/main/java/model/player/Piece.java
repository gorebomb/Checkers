package main.java.model.player;

import main.java.model.utility.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Piece {
    private Point location;
    private int player;
    boolean king = false;

    public Piece(int p, int x, int y) {
        location = new Point(x,y);
        player = p;
    }

    public Point getLocation() {
        return location;
    }
    
    public int getPlayer() {
    	return player;
    }
    
    public void setKing(boolean b) {
    	king = b;
    }
    
    public boolean isKing() {
    	return king;
    }
}
