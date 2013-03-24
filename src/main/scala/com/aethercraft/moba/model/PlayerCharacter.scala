package com.aethercraft.moba.model

import com.aethercraft.moba.model.hero._
import com.aethercraft.moba.model._

case class PlayerCharacter(player:Player, hero: Hero, game: Game, team: Team) {
  var gold = 0
  var heroLevel = 0
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
