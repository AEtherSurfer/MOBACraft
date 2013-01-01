package com.aethercraft.moba.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.aethercraft.moba.Mobacraft;

public class MOBAExecutor implements CommandExecutor {
	
	private Mobacraft plugin;
	
	public Mobacraft getPlugin() {
		return plugin;
	}

	public void setPlugin(Mobacraft plugin) {
		this.plugin = plugin;
	}
	
	public MOBAExecutor (Mobacraft plugin) {
		this.setPlugin(plugin);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// implementation
		return false;

	}


}