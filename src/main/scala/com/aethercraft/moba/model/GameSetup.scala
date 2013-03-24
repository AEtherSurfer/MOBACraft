package com.aethercraft.moba.model

import com.aethercraft.moba.Conf

case class GameSetup(name: String) {

  var teamRed = List[Player]()
  var teamBlu = List[Player]()

  def join(team: Team, party: Party) {
    party.team match {
      case Team.RED =>
        if (teamRed.length + party.members.length > Conf.teamSizeMax) throw TeamFullException()
        teamRed = teamRed ++ party.members
      case Team.BLU =>
        if (teamBlu.length + party.members.length > Conf.teamSizeMax) throw TeamFullException()
        teamBlu = teamBlu ++ party.members
    }
    party.connect(this, team)
  }

  def leave(party: Party) {
    if (party.game != this) return ;
    party.team match {
      case Team.RED =>
        teamRed = teamRed diff party.members
      case Team.BLU =>
        teamBlu = teamBlu diff party.members
    }
    party.connect(null, null);
  }

  case class TeamFullException() extends Exception
}
