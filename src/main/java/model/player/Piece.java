package main.java.model.player;

import main.java.model.utility.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Piece {
    private Point location;
    private int player;
    boolean king = false;
    private HashSet<Point> validMoves = new HashSet<>();

    public Piece(int p, int x, int y) {
        location = new Point(x,y);
        player = p;
    }

    public Point getLocation() {
        return location;
    }
    //TODO: probably have to move this to checkersboard
//    private void updateValidMoves(int cells[][]){
//
//        ArrayList<Integer> movements = new ArrayList<Integer>();
//        int enemy = -1;
//
//        if (player.getPlayer() == 1) {
//            enemy = 2;
//            movements.add(1);
//            if (king) {
//                movements.add(-1);
//            }
//        }
//        else {
//            enemy = 1;
//            movements.add(-1);
//            if (king) {
//                movements.add(1);
//            }
//        }
//
//        for (int movement : movements) {
//            int mRow = (int) location.getX() + movement;
//            int mCol = (int) location.getY() + 1;
//            Point mid = new Point(mRow, mCol);
//        /*
//        |_|_|o|_|_|
//	    |_|_|_|m|_|
//	    |_|_|_|_|_|
//        */
//            if (cells[mRow][mCol] == 0) {
//                validMoves.add(mid);
//            } else {
//        /*
//        |_|_|o|_|_|
//	    |_|_|_|m|_|
//	    |_|_|_|_|d|
//        */
//                int dRow = (int) location.getX() + (movement * 2);
//                int dCol = (int) location.getY() + 2;
//                Point dest = new Point(dRow, dCol);
//                if (cells[mRow][mCol] == enemy && cells[dRow][dCol] == 0) {
//                    validMoves.add(dest);
//                }
//            }
//            mRow = (int) location.getX() + movement;
//            mCol = (int) location.getY() - 1;
//            mid = new Point(mRow, mCol);
//        /*
//        |_|_|o|_|_|
//	    |_|m|_|_|_|
//	    |_|_|_|_|_|
//        */
//            if (cells[mRow][mCol] == 0) {
//                validMoves.add(mid);
//            } else {
//        /*
//        |_|_|o|_|_|
//	    |_|m|_|_|_|
//	    |d|_|_|_|_|
//        */
//                int dRow = (int) location.getX() + (movement * 2);
//                int dCol = (int) location.getY() - 2;
//                Point dest = new Point(dRow, dCol);
//                if (cells[mRow][mCol] == enemy && cells[dRow][dCol] == 0) {
//                    validMoves.add(dest);
//                }
//            }
//        }
//        System.out.println(validMoves.toString());
//    }
}
