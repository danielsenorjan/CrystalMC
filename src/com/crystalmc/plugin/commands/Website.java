package com.crystalmc.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.crystalmc.plugin.Main;

public class Website implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("website")) {
			// SEND INFOMESSAGE
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GRAY + " Our website address is " + ChatColor.translateAlternateColorCodes('&', Main.config.getString("websiteUrl")));
			return true;
			}
		return false;
		}

}
