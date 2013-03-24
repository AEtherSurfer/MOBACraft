package com.aethercraft.moba.model.hero

object Cleave extends Ability("Cleave", AbilityEnum.Action.TargetPosition, AbilityEnum.Type.EnemyUnits, 5, 20, 10, Array(100,75,50,25), Array(100,75,50,25), false)

object Swordsman extends Hero("Swordsman", 22, 17, 17, Array[Ability](Cleave, null, null, null))