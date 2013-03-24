package com.aethercraft.moba.model.hero

case class AbilityIdx(val maxValue: Int) {

	object Boost extends AbilityIdx(10)
	object First extends AbilityIdx(4)
	object Second extends AbilityIdx(4)
	object Third extends AbilityIdx(4)
	object Ult extends AbilityIdx(3)
}
