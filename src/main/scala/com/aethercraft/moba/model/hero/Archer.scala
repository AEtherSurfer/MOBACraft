package com.aethercraft.moba.model.hero

object Volley extends Ability("Volley", AbilityEnum.Action.TargetPosition, AbilityEnum.Type.EnemyUnits, 100, 100, 10, Array(100,75,50,25), Array(100,75,50,25), false)

object Archer extends Hero("Archer", 17, 22, 17, Array[Ability](Volley, null, null, null))