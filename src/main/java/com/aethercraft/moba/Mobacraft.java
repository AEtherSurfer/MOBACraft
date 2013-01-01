package com.aethercraft.moba;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Mobacraft extends JavaPlugin {

	private Listener mobaListener;

	@Override
	public void onEnable() {
		this.mobaListener = new MOBAListener(this);

		getServer().getPluginManager().registerEvents(this.mobaListener, this);
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
	}
	
	
}
