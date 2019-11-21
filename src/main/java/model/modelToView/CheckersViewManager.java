package main.java.model.modelToView;

public class CheckersViewManager implements IViewManager{

	@Override
	public void draw() {
		System.out.println("It's a draw!");
	}

	@Override
	public void win(int player) {
		System.out.println("Player " + player + " wins!");
	}

	@Override
	public void reset() {
		System.out.println("Resetting the game");
	}

}
