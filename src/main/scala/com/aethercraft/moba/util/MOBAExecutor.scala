package com.aethercraft.moba.util

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import com.aethercraft.moba.MOBACraft
import scala.beans.BeanProperty

class MOBAExecutor(@BeanProperty val plugin: MOBACraft) extends CommandExecutor {

  def onCommand(sender: CommandSender, cmd: Command, label: String, args: Array[String]) = {
    args match {
      case args if args.length > 4 =>
        sender.sendMessage("Too many arguments.  Both sender and cmd are required.")
        false
      case args if args.length < 2 =>
        sender.sendMessage("Not enough arguments.  Both sender and cmd are required.")
        false
      case _ =>
        // implementation
        true
    }
  }
}