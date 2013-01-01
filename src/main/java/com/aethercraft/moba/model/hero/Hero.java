package com.aethercraft.moba.model.hero;

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

	public Hero(String name, int bStr, int bAgi, int bInt) {
		this.name = name;
		this.bStr = bStr;
		this.bAgi = bAgi;
		this.bInt = bInt;
	}
	
}
