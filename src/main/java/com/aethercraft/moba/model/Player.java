package com.aethercraft.moba.model;

import com.aethercraft.moba.model.hero.Hero;

public class Player {
	public Hero hero;
	public int gold = 0;

	private int heroLevel = 0;
	private int[] abilityLevel = new int[5];
	private Party party = new Party(this);

	public void setParty(Party party) {
		this.party = party == null ? new Party(this) : party;
	}

	public Party getParty() {
		return party;
	}

	public int incHeroLevel() {
		if (heroLevel < 25) heroLevel++;
		return heroLevel;
	}

	public int incAbilityLevel(AbilityIdx idx) {
		int i = idx.ordinal();
		int abilityMaxLevel = getMax(idx, heroLevel);
		if (abilityLevel[i] < abilityMaxLevel) {
			abilityLevel[i]++;
		}
		return abilityLevel[i];
	}

	public int getAbilityLevel(AbilityIdx idx) {
		return abilityLevel[idx.ordinal()];
	}

	private int getMax(AbilityIdx idx, int heroLevel) {
		return 0;
	}

	public enum AbilityIdx {
		BOOST(10),FIRST(4),SECOND(4),THIRD(4),ULT(3);
		public final int maxLevel;

		private AbilityIdx(int maxLevel) {
			this.maxLevel = maxLevel;
		}
	}
}
