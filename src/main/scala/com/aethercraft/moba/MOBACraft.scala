package com.aethercraft.moba

import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class MOBACraft extends JavaPlugin {

	var mobaListener: MOBAListener = _

	override def onEnable {
		mobaListener = new MOBAListener(this)

		getServer.getPluginManager.registerEvents(mobaListener, this)
	}

	override def onDisable {
		HandlerList.unregisterAll(this)
	}
}
