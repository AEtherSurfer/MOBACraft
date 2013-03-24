package com.aethercraft.moba.model.hero

case class Ability(name: String, action: AbilityEnum.Action, tipe: AbilityEnum.Type, range: Int, radius: Int, castTime: Int, coolDown: Array[Int], manaCost: Array[Int], requiredLevel: Array[Int]) {

//  case class Action() {
//    object TargetPosition extends Action
//    object TargetDualPosition extends Action
//    object TargetEntity extends Action
//    object TargetSelf extends Action
//    object SelfPosition extends Action
//    object Passive extends Action
//  }
//
//  case class Type() {
//    object AllyHeroes extends Type
//    object EnemyHeroes extends Type
//    object AllyUnits extends Type
//    object EnemyUnits extends Type
//    object AllOtherUnits extends Type
//    object AllVisibleUnits extends Type
//    object OrganicEnemyUnits extends Type
//    object Trees extends Type
//    object Nonneutral extends Type
//    object Self extends Type
//  }

  object AttributeBoost extends Ability("AttributeBoost", AbilityEnum.Action.Passive, AbilityEnum.Type.Self, 0, 0, 0, Array(0, 0, 0, 0), Array(0, 0, 0, 0), false)

  def this(name: String, action: AbilityEnum.Action, tipe: AbilityEnum.Type, range: Int, radius: Int, castTime: Int, coolDown: Array[Int], manaCost: Array[Int], ultimate: Boolean) = {
    this(name, action, tipe, range, radius, castTime, coolDown, manaCost, if (ultimate) Array(6, 11, 16) else Array(1, 3, 5, 7))
  }
}
