package com.aethercraft.moba.model;

import com.aethercraft.moba.model.hero.Ability;
import com.aethercraft.moba.model.hero.Hero;

public class Player {
	public Hero hero;
	public int gold = 0;

	private int heroLevel = 0;
	private int[] abilityLevel = new int[Ability.Index.values().length];
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

	public int incAbilityLevel(Ability.Index idx) {
		int i = idx.ordinal();
		int abilityMaxLevel = getMax(idx, heroLevel);
		if (abilityLevel[i] < abilityMaxLevel) {
			abilityLevel[i]++;
		}
		return abilityLevel[i];
	}

	public int getAbilityLevel(Ability.Index idx) {
		return abilityLevel[idx.ordinal()];
	}

	private int getMax(Ability.Index idx, int heroLevel) {
		return 0;
	}
}
