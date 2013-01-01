package com.aethercraft.moba.model.hero;

public class Ability {
	public static final Ability AttributeBoost = new AttributeBoost();
	public final String name;
	public final Action action;
	public final Type type;
	public final int range;
	public final int radius;
	public final int castTime;
	public final int[] coolDown;
	public final int[] manaCost;
	public final int[] requiredLevel;

	private Ability(String name, Action action, Type type, int range, int radius, int castTime, int[] coolDown, int[] manaCost, int[] requiredLevel) {
		this.name = name;
		this.action = action;
		this.type = type;
		this.range = range;
		this.radius = radius;
		this.castTime = castTime;
		this.coolDown = coolDown;
		this.manaCost = manaCost;
		this.requiredLevel = requiredLevel;
	}

	public Ability(String name, Action action, Type type, int range, int radius, int castTime, int[] coolDown, int[] manaCost, boolean ultimate) {
		this(name, action, type, range, radius, castTime, coolDown, manaCost, ultimate?new int[]{6,11,16}:new int[]{1,3,5,7});
	}

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

	public static class AttributeBoost extends Ability {
		public AttributeBoost() {
			super("AttributeBoost", Action.Passive, Type.Self, 0, 0, 0, new int[]{0,0,0,0}, new int[]{0,0,0,0}, false);
		}
	}
}
