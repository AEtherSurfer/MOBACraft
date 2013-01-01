package com.aethercraft.moba.model;

import com.aethercraft.moba.model.hero.Hero;

public class Player {
	private Hero hero;
	private int heroLevel = 0;
	private int[] abilityLevel = new int[5];

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
