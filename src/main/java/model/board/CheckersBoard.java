package main.java.model.board;

import main.java.gameIO.IGameModel;
import main.java.model.move.IBoardStatusVisitor;
import main.java.model.move.ICheckMoveVisitor;
import main.java.model.move.IUndoMove;

public class CheckersBoard extends ABoardModel {

	public CheckersBoard(int n, int n2, IGameModel host) {
		super(n, n2, host);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IUndoMove makeMove(int p0, int p1, int p2, ICheckMoveVisitor p3, IBoardStatusVisitor p4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove(int p0, int p1, int p2) {
		// TODO Auto-generated method stub
		return false;
	}

}
