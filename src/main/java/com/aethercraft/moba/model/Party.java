package com.aethercraft.moba.model;

import java.util.ArrayList;
import java.util.List;

import com.aethercraft.moba.Conf;

public class Party {

	private String name;
	private Player leader;
	List<Player> members = new ArrayList<Player>(Conf.teamSizeMax);
	
	public Party(String name, Player leader) {
		super();
		this.name = name;
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getLeader() {
		return leader;
	}

	public void setLeader(Player leader) {
		this.leader = leader;
	}

	public void add(Player newMember) throws Party.FullException {
		if (members.size() >= Conf.teamSizeMax) {
			throw new Party.FullException();
		}
	}
	
	public void remove(Player member) {
		members.remove(member);
	}

	@SuppressWarnings("serial")
	public static class FullException extends Exception {

	}
}
