package com.aethercraft.moba.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aethercraft.moba.Conf;
import com.aethercraft.moba.MOBACraftException;

public class Party {
	private Player leader;
	private List<Player> members = new ArrayList<Player>(Conf.teamSizeMax);
	private Game game;
	private Team team;

	public Party(Player leader) {
		this.leader = leader;
		try {
			add(leader);
		} catch (FullException e) {
			throw new MOBACraftException("Is teamSizeMax set to 0?", e);
		}
	}

	public Player getLeader() {
		return leader;
	}

	public void setLeader(Player leader) {
		this.leader = leader;
	}

	/**
	 * 
	 * @param newMember
	 * @return true if added, false if was already a member of this party
	 * @throws Party.FullException
	 */
	public boolean add(Player newMember) throws Party.FullException {
		if (members.size() >= Conf.teamSizeMax) {
			throw new Party.FullException("Cannot add " + newMember + ", party is full.");
		}
		if (newMember.getParty() == this) {
			return members.add(newMember);
		}
		newMember.getParty()._remove(newMember);
		newMember.setParty(this);
		return members.add(newMember);
	}

	public boolean remove(Player member) {
		member.setParty(null);
		return _remove(member);
	}

	public int size() {
		return members.size();
	}

	public List<Player> getMembers() {
		return Collections.unmodifiableList(members);
	}

	public void setGame(Game game, Team team) {
		this.game = game;
		this.team = team;
	}

	public Game getGame() {
		return game;
	}

	public Team getTeam() {
		return team;
	}

	private boolean _remove(Player member) {
		return members.remove(member);
	}

	@SuppressWarnings("serial")
	public static class FullException extends Exception {

		public FullException(String msg) {
			super(msg);
		}

	}
}
