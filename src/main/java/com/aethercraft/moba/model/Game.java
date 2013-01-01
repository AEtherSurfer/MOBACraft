package com.aethercraft.moba.model;

import java.util.ArrayList;
import java.util.List;

import com.aethercraft.moba.Conf;

public class Game {
	public final String name;
	private final List<Player> teamRed = new ArrayList<Player>(Conf.teamSizeMax);
	private final List<Player> teamBlu = new ArrayList<Player>(Conf.teamSizeMax);

	public Game(String name) {
		super();
		this.name = name;
	}

	public void join(Team team, Party party) throws TeamFullException {
		List<Player> teamList = getTeamList(team);
		if (teamList.size() + party.size() > Conf.teamSizeMax) {
			throw new TeamFullException();
		}
		teamList.addAll(party.getMembers());
		party.setGame(this, team);
	}

	public void leave(Party party) {
		if (party.getGame() != this) return;
		List<Player> teamList = getTeamList(party.getTeam());
		teamList.removeAll(party.getMembers());
		party.setGame(null, null);
	}

	private List<Player> getTeamList(Team team) {
		switch (team) {
		case RED:
			return teamRed;
		case BLU:
			return teamBlu;
		default:
			throw new RuntimeException(team + " is an unknown team");
		}
	}

	@SuppressWarnings("serial")
	public static class TeamFullException extends Exception {

	}
}
