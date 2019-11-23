package main.java.model.board;

import main.java.gameIO.IGameModel;
import main.java.model.move.IBoardStatusVisitor;
import main.java.model.move.ICheckMoveVisitor;
import main.java.model.move.IUndoMove;
import main.java.model.player.Piece;
import main.java.model.utility.Point;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Making number 1 correspond with Player 0 and number 2 correspond with Player 1
 * since number 0 corresponds with empty location on the board
 * 
 * @author Courtney, Kevin VanHorn
 */
public class CheckersBoard extends ABoardModel {
	private ArrayList<Piece> pieces = new ArrayList<>();
    private HashSet<Point> validMoves = new HashSet<>();

	public CheckersBoard(int n, int n2, IGameModel host) {
		super(n, n2, host);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n2; j++) {
				pieces.add(new Piece(0, i, j));
			}
		}
		this.reset();
	}

	@Override
	public IUndoMove makeMove(int row, int col, int player, ICheckMoveVisitor p3, IBoardStatusVisitor p4) {
		if (isValidMove(player, row, col)) {
			System.out.println("Valid move!");
			p3.validMoveCase();
			cells[row][col] = player+1;
			if (!boardContains(1) && !boardContains(0)) {
				System.out.println("DRAW");
				p4.drawCase(this, this);
				this.reset();
			} else if (!boardContains(1)) {
				System.out.println("0 WON");
				p4.player0WonCase(this, this);
				this.reset();
			} else if (!boardContains(0)) {
				System.out.println("1 WON");
				p4.player1WonCase(this, this);
				this.reset();
			} else {
				System.out.println("NO WINNER");
				p4.noWinnerCase(this, this);
			}
		} else {
			System.out.println("Invalid move!");
			p3.invalidMoveCase();
		}
		displayBoard();
		
		return null;
	}

	@Override
	public boolean isValidMove(int player, int row, int col) {
		//TODO pls do this thanks, need to create the piece objects first

		return true;
	}
	
	private void updateValidMoves(int player){
		for (Piece pie: pieces) {
	        ArrayList<Integer> movements = new ArrayList<Integer>();
	        int enemy = -1;
	
	        if (player == 1) {
	            enemy = 2;
	            movements.add(1);
	            if (pie.isKing()) {
	                movements.add(-1);
	            }
	        }
	        else {
	            enemy = 1;
	            movements.add(-1);
	            if (pie.isKing()) {
	                movements.add(1);
	            }
	        }
	
	        for (int movement : movements) {
	            int mRow = (int) pie.getLocation().getX() + movement;
	            int mCol = (int) pie.getLocation().getY() + 1;
	            Point mid = new Point(mRow, mCol);
	        /*
	        |_|_|o|_|_|
		    |_|_|_|m|_|
		    |_|_|_|_|_|
	        */
	            if (cells[mRow][mCol] == 0) {
	                validMoves.add(mid);
	            } else {
	        /*
	        |_|_|o|_|_|
		    |_|_|_|m|_|
		    |_|_|_|_|d|
	        */
	                int dRow = (int) pie.getLocation().getX() + (movement * 2);
	                int dCol = (int) pie.getLocation().getY() + 2;
	                Point dest = new Point(dRow, dCol);
	                if (cells[mRow][mCol] == enemy && cells[dRow][dCol] == 0) {
	                    validMoves.add(dest);
	                }
	            }
	            mRow = (int) pie.getLocation().getX() + movement;
	            mCol = (int) pie.getLocation().getY() - 1;
	            mid = new Point(mRow, mCol);
	        /*
	        |_|_|o|_|_|
		    |_|m|_|_|_|
		    |_|_|_|_|_|
	        */
	            if (cells[mRow][mCol] == 0) {
	                validMoves.add(mid);
	            } else {
	        /*
	        |_|_|o|_|_|
		    |_|m|_|_|_|
		    |d|_|_|_|_|
	        */
	                int dRow = (int) pie.getLocation().getX() + (movement * 2);
	                int dCol = (int) pie.getLocation().getY() - 2;
	                Point dest = new Point(dRow, dCol);
	                if (cells[mRow][mCol] == enemy && cells[dRow][dCol] == 0) {
	                    validMoves.add(dest);
	                }
	            }
	        }
	        System.out.println(validMoves.toString());
		}
    }
	
	public void displayBoard() {
		System.out.println("   --------------------------------");
		for (int i = 0; i < cells.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < cells.length; j++) {
				System.out.print("|" + digitToSymbol(cells[i][j]));
			}
			System.out.println("|\n   --------------------------------");
		}
	}
	
	
	/**
	 * Converts a digit representing a piece to a symbol to be displayed.
	 * @param digit the piece's numeric code.
	 * 		        -1 = empty, 0 = p0:piece, 1 = p1:piece
	 * @return the displayed symbol.
	 */
	private String digitToSymbol(int digit) {
		if(digit == 0) return "{X}";
		else if(digit == 1) return "%X%";
		else return " - ";
	}
	
	public boolean boardContains(int player) {
		player++;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (cells[i][j] == player) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void reset() {
		super.reset();
		pieces.clear();
		
		// Changing default cells to -1 so player 0 can exist.
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = -1;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < cells.length; j++) {
				if((i+j) % 2 ==1)
					cells[i][j] = 0;
					pieces.add(new Piece(0, i, j));
			}
		}
		
		for (int i = cells.length-3; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if((i+j) % 2 == 1)
					cells[i][j] = 1;
					pieces.add(new Piece(1, i, j));
			}
		}
	}
	
	public boolean isValidObj(Point p, int player)
	{
		for(Piece pie: pieces) {
			if(pie.getPlayer() == player && p.x == pie.getLocation().x && p.y == pie.getLocation().y) {
				return true;
			}
		}
		return false;
		
	}
}
