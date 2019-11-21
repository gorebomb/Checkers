package main.java;

import java.util.List;

import main.java.model.GameModel;

public class CheckersGame {
	public static void main(String[] args) {
		GameModel game = new GameModel(8, 8);
		List<Object> players = game.getPlayers();
		game.setPlayers(players.get(0), players.get(1));
	}
}
