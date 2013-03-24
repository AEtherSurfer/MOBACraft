package com.aethercraft.moba.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.aethercraft.moba.MOBACraft;

public class MOBAExecutor implements CommandExecutor {
	
	private MOBACraft plugin;
	
	public MOBACraft getPlugin() {
		return plugin;
	}

	public void setPlugin(MOBACraft plugin) {
		this.plugin = plugin;
	}
	
	public MOBAExecutor (MOBACraft plugin) {
		this.setPlugin(plugin);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length > 4) {
			sender.sendMessage("Too many arguments.  Both sender and cmd are required.");
			return false;
		}
		if (args.length < 2) {
			sender.sendMessage("Not enough arguments.  Both sender and cmd are required.");
			return false;
		}
		// implementation
		return false;
	}

}