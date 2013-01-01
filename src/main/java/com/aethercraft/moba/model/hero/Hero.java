package com.aethercraft.moba.model.hero;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public abstract class Hero {
	/**
	 * hero's name
	 */
	public final String name;

	/**
	 * hero's base strength
	 */
	public final int bStr;

	/**
	 * hero's base agility
	 */
	public final int bAgi;

	/**
	 * hero's base inteligence
	 */
	public final int bInt;

	public final Map<Ability.Index, Ability> abilities;

	public Hero(String name, int bStr, int bAgi, int bInt, Ability[] abilities) {
		this.name = name;
		this.bStr = bStr;
		this.bAgi = bAgi;
		this.bInt = bInt;
		Map<Ability.Index, Ability> _abilities = new EnumMap<Ability.Index, Ability>(Ability.Index.class);
		_abilities.put(Ability.Index.BOOST, Ability.AttributeBoost);
		_abilities.put(Ability.Index.FIRST, abilities[0]);
		_abilities.put(Ability.Index.SECOND, abilities[1]);
		_abilities.put(Ability.Index.THIRD, abilities[2]);
		_abilities.put(Ability.Index.ULT, abilities[3]);
		this.abilities = Collections.unmodifiableMap(_abilities);
	}
}
