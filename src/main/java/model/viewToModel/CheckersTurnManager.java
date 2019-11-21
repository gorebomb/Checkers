package main.java.model.viewToModel;

import java.util.Scanner;

import main.java.model.modelToView.IRejectCommand;
import main.java.model.modelToView.RejectCommand;
import main.java.model.player.Piece;

public class CheckersTurnManager implements ITurnManager {
	IRejectCommand rejectCommand;
	static Scanner sc;
	
	public CheckersTurnManager() {
		super();
		rejectCommand = new RejectCommand();
	}

	@Override
	public void takeTurn(IViewRequestor requestor) {
		int row, col;
		Piece piece;
		System.out.println("Player, enter your move in the order row then column: ");

		System.out.println("Player, enter your move in the order row then column: ");
		sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		requestor.setTokenAt(row, col, rejectCommand);
	}

}
