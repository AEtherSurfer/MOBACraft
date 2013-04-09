package com.aethercraft.moba.model

import com.aethercraft.moba.Conf
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Team

case class Party(var leader: Player) {
  var game: Game = _
  var team: Team = _
  var members = List(leader)

  def add(newMember: Player) {
    if (members.length >= Conf.teamSizeMax) {
      throw FullException("Cannot add " + newMember + ", party is full.");
    }
    if (Party.parties(newMember) != this && Party.parties(newMember) != null) {
      Party.parties(newMember).remove(newMember)
    }
    Party.parties = Party.parties + (newMember -> this)
    members = newMember +: members
  }

  def remove(member: Player) {
    Party.parties = Party.parties - member
    members = members diff List(member)
    if (member == leader) {
      leader = members.last
    }
  }

  def size = {
    members.length
  }

  case class FullException(msg: String) extends Exception(msg)
}

object Party {
  var parties = Map[Player, Party]()
}