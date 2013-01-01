package com.aethercraft.moba.model.hero;


public class Swordsman extends Hero {

	public Swordsman() {
		super("Swordsman", 22, 17, 17, new Ability[]{new Cleave(), null, null, null});
	}

	public static class Cleave extends Ability {
		public Cleave() {
			super("Cleave", Action.TargetPosition, Type.EnemyUnits, 5, 20, 10, new int[]{100,75,50,25}, new int[]{100,75,50,25}, false);
		}
	}
}
