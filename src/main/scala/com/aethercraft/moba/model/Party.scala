package com.aethercraft.moba.model

import com.aethercraft.moba.Conf

case class Party(var leader: Player) {
	private[this] var _game: GameSetup = _
	private[this] var _team: Team = _
	var members = List(leader)

	def add(newMember:Player) {
		if (members.length >= Conf.teamSizeMax) {
			throw FullException("Cannot add " + newMember + ", party is full.");
		}
		if (newMember.party != this && newMember.party != null) {
		  newMember.party.remove(newMember)
		}
		newMember.party = this
		members = members :+ newMember
	}

	def remove(member:Player) {
		member.party = null
		members = members diff List(member)
		if (member == leader) {
		  leader = members(0)
		}
	}

	def size = {
	  members.length
	}

	def game = _game
	
	def team = _team

	def connect(g:GameSetup, t:Team) {
		_game = g;
		_team = t;
	}

	case class FullException(msg: String) extends Exception(msg)
}
