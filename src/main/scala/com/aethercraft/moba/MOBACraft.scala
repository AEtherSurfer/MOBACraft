package com.aethercraft.moba

import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import com.aethercraft.moba.model.Game

class MOBACraft extends JavaPlugin {

	var mobaListener: MOBAListener = _
	var model: Game = _

	override def onEnable {
		mobaListener = new MOBAListener(this)
		model = Game()

		getServer.getPluginManager.registerEvents(mobaListener, this)
	}

	override def onDisable {
		HandlerList.unregisterAll(this)
	}
}
