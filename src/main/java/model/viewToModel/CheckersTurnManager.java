package main.java.model.viewToModel;

import java.util.Scanner;

import main.java.model.modelToView.IRejectCommand;
import main.java.model.modelToView.RejectCommand;
import main.java.model.player.Piece;
import main.java.model.utility.Point;
import main.java.model.board.CheckersBoard;

public class CheckersTurnManager implements ITurnManager {
	IRejectCommand rejectCommand;
	static Scanner sc;
	
	public CheckersTurnManager() {
		super();
		rejectCommand = new RejectCommand();
	}

	@Override
	public void takeTurn(IViewRequestor requestor) {
		int obj_row, obj_col, dest_row, dest_col;
		Piece piece;
		sc = new Scanner(System.in);
		System.out.println("Player, enter your piece to move in the order row then column: ");
		obj_row = sc.nextInt();
		obj_col = sc.nextInt();
		Point obj_point = new Point(obj_row, obj_col);
//		while(!isValidObj(obj_point))
//		{
//			System.out.println("OBJECT DOES NOT EXIST AT THE LOCATION!");
//			System.out.println("Player, enter your piece to move in the order row then column: ");
//			obj_row = sc.nextInt();
//			obj_col = sc.nextInt();
//		}
		System.out.println("Player, enter your destination in the order row then column: ");
		dest_row = sc.nextInt();
		dest_col = sc.nextInt();
		requestor.setTokenAt(dest_row, dest_col, rejectCommand);
//		requestor.clearTokenAt(obj_row, obj_col);
	}

}
