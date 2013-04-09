package com.aethercraft.moba.model;

import com.aethercraft.moba.Conf
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Team
import com.aethercraft.statemachine.StateModel
import com.aethercraft.statemachine.State
import com.aethercraft.statemachine.StateMachineException
import scala.collection.JavaConversions._
import org.bukkit.ChatColor
import org.bukkit.scoreboard.DisplaySlot

case class Game() extends StateModel[GameState] {
  var pcs = Map[Player, PlayerCharacter]()
  val mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard()
  def updateScores(player: Player) {
    val pc = pcs(player)
    val oLKD = mainScoreboard.getObjective("LKD")
    val sLKD = oLKD.getScore(player)
    sLKD.setScore(player.getLevel * 1000000 + pc.kills * 1000 + pc.deaths)
    val oLHM = mainScoreboard.getObjective("LHM")
    val sLHM = oLHM.getScore(player)
    sLHM.setScore(player.getLevel * 1000000 + (player.getHealth*5) * 1000 + (player.getFoodLevel*5))
  }
  def joinTeam(party: Party, team: Team) {
    if (team.getSize + party.size > Conf.teamSizeMax) {
      throw new GameStateException("Cannot join team, party size exceeds the number of open team slots")
    } 
    for(p <- party.members) {
      team.addPlayer(p)
      updateScores(p)
    }
  }
  def joinTeam(party: Party, teamName: String) {
    joinTeam(party, mainScoreboard.getTeam(teamName))
  }
  def died(party: Party) {
    
  }
  def resetScoreboard() {
    for(t <- mainScoreboard.getTeams()) {
      t.unregister()
    }
    for(p <- mainScoreboard.getPlayers()) {
      mainScoreboard.resetScores(p)
    }
    for(o <- mainScoreboard.getObjectives()) {
      o.unregister()
    }
    for(t <- List(("Blu", ChatColor.BLUE), ("Red", ChatColor.RED))) {
      val team = mainScoreboard.registerNewTeam(t._1)
      team.setPrefix(t._2.toString())
      team.setSuffix(ChatColor.RESET.toString())
      team.setAllowFriendlyFire(false)
      team.setCanSeeFriendlyInvisibles(true)
    }
    val oLKD = mainScoreboard.registerNewObjective("LKD", "dummy")
    oLKD.setDisplayName("                     Lvl   K   D")
    oLKD.setDisplaySlot(DisplaySlot.SIDEBAR)
    val oLHM = mainScoreboard.registerNewObjective("LHM", "dummy")
    oLKD.setDisplayName("                     Lvl   H   M")
    oLKD.setDisplaySlot(DisplaySlot.BELOW_NAME)
    
//13:02:43 [INFO] XanderFast issued server command: /scoreboard objectives add LKD dummy                      Lvl   K   D
//13:02:49 [INFO] XanderFast issued server command: /scoreboard objectives setdisplay sidebar LKD
//13:02:54 [INFO] XanderFast issued server command: /scoreboard players set XanderFast LKD 25099099
//13:05:44 [INFO] XanderFast issued server command: /scoreboard players set XanderFast LKD 01000000

      
  }
}

abstract class GameState(model: Game) extends State[Game, GameState](model) {
  def joinTeam(party: Party, teamName: String)
  def joinTeam(player: Player, teamName: String) {
    val party = Party.parties(player)
    if (party.leader == player) {
      joinTeam(party, teamName)
    } else {
      throw new GameStateException("Only the party leader may join a team.")
    }
  }
  def setup() {
    exit(Setup(model))
  }
  def start() {
    exit(ActiveGame(model))
  }
  def end() {
    exit(PostGame(model))
  }
  def died(p: Player)
}

case class Setup(model: Game) extends GameState(model) {
  override def enter() {
    exit(PreGame(model))
  }
  
  override def joinTeam(party: Party, teamName: String) {
    throw new GameStateException("Wait for PreGame.")
  }
  
  override def died(p: Player) {
    
  }
}

case class PreGame(model: Game) extends GameState(model) {
  override def enter() {
    model.resetScoreboard()
  }
  override def joinTeam(party: Party, teamName: String) {
    model.joinTeam(party, teamName)
  }
  override def setup() {
    throw new GameStateException("Already in pregame.")
  }
  override def died(p: Player) {
    
  }
}

case class ActiveGame(model: Game) extends GameState(model) {
  override def joinTeam(party: Party, teamName: String) {
    throw new GameStateException("Game already started.")
  }
  override def died(p: Player) {
    
  }
}

case class PostGame(model: Game) extends GameState(model) {
  override def joinTeam(party: Party, teamName: String) {
    throw new GameStateException("Game over.")
  }
  override def died(p: Player) {
    
  }
}

class GameStateException(msg: String) extends StateMachineException(msg)