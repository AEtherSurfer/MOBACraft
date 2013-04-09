package com.aethercraft.moba

import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerInteractEntityEvent
import java.util.logging.Level
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.block.Block
import org.bukkit.Material
import org.bukkit.DyeColor
import org.bukkit.event.entity.PlayerDeathEvent

class MOBAListener(p: MOBACraft) extends Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	def interact(e: PlayerInteractEvent) {
		p.getLogger.log(Level.INFO, "PlayerInteractEvent: " + e.getClickedBlock()+":"+e.getPlayer().getName())
		e.getClickedBlock() match {
		  case b: Block if b.getType == Material.WOOL && DyeColor.getByWoolData(b.getData) == DyeColor.RED =>
		    p.model.state.joinTeam(e.getPlayer, "Red")
		  case b: Block if b.getType == Material.WOOL && DyeColor.getByWoolData(b.getData) == DyeColor.BLUE =>
		    p.model.state.joinTeam(e.getPlayer, "Blu")
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	def interactEntity(e: PlayerInteractEntityEvent) {
		p.getLogger.log(Level.INFO, "PlayerInteractEntityEvent: " + e.getRightClicked+":"+e.getPlayer.getName)
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	def died(e: PlayerDeathEvent) {
		p.getLogger.log(Level.INFO, "PlayerDeathEvent: " + e.getDeathMessage+":"+e.getEntity.getName)
		p.model.state.died(e.getEntity)
	  
	}
	
  
}
