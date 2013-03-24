package com.aethercraft.moba.model.hero;

public class AbilityEnum {
	public static enum Action {
		TargetPosition,
		TargetDualPosition,
		TargetEntity,
		TargetSelf,
		SelfPosition,
		Passive
	}

	public static enum Type {
		AllyHeroes,
		EnemyHeroes,
		AllyUnits,
		EnemyUnits,
		AllOtherUnits,
		AllVisibleUnits,
		OrganicEnemyUnits,
		Trees,
		Nonneutral,
		Self
	}

	public static enum Index {
		BOOST(10), FIRST(4), SECOND(4), THIRD(4), ULT(3);

		public final int maxLevel;

		private Index(int maxLevel) {
			this.maxLevel = maxLevel;
		}
	}
}
