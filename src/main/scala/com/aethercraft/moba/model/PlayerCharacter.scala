package com.aethercraft.moba.model

import com.aethercraft.moba.model.hero._
import com.aethercraft.moba.model._
import org.bukkit.scoreboard.Team
import org.bukkit.entity.Player

case class PlayerCharacter(player: Player, hero: Hero, game: Game, team: Team) {
  var gold = 0
  var heroLevel = 0
  var kills = 0
  var deaths = 0
  var creepKills = 0
  var maxHealth = 1
  var mana = 0
  var maxMana = 100
  private[this] val abilityLevel = Array[Int](5);

  def incHeroLevel() = {
    if (heroLevel < 25) heroLevel += 1
    heroLevel
  }

  def incAbilityLevel(idx: AbilityEnum.Index) = {
    val i = idx.ordinal();
    val abilityMaxLevel = getMax(idx, heroLevel)
    if (abilityLevel(i) < abilityMaxLevel) {
      abilityLevel(i) += 1;
    }
    abilityLevel(i)
  }

  def abilityLevel(idx: AbilityEnum.Index): Int = {
    abilityLevel(idx.ordinal())
  }

  private def getMax(idx: AbilityEnum.Index, heroLevel: Int) = {
    0
  }
}
