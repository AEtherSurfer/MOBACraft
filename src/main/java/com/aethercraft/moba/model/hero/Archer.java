package com.aethercraft.moba.model.hero;

public class Archer extends Hero {

	public Archer() {
		super("Archer", 17, 22, 17, new Ability[]{new Volley(), null, null, null});
	}

	public static class Volley extends Ability {
		public Volley() {
			super("Volley", Action.TargetPosition, Type.EnemyUnits, 100, 100, 10, new int[]{100,75,50,25}, new int[]{100,75,50,25}, false);
		}
	}
}
