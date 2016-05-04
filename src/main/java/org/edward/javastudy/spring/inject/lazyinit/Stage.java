package org.edward.javastudy.spring.inject.lazyinit;

import java.util.List;

public class Stage {
	private String name;

	private Player mainPlayer;

	public Player getMainPlayer() {
		return mainPlayer;
	}

	public void setMainPlayer(Player mainPlayer) {
		System.out.println("Setting the main Player.");
		this.mainPlayer = mainPlayer;
	}

	private List<Player> playerList;

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		System.out.println("Setting the player list:" + playerList.size());
		this.playerList = playerList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Stage() {
		System.out.println("Invoking constuctor Stage()");
	}

	public Stage getInstance() {
		return StageHolder.stage;
	}

	public void play() {
		System.out.println("Start the Stage performance");
		System.out.println("============================");
		System.out.println("Main Playier is performing:");
		this.mainPlayer.perform();
	}

	private static class StageHolder {
		public static Stage stage = new Stage();
	}

}
