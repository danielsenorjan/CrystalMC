package com.crystalmc.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.crystalmc.plugin.Main;

public class Rules implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("rules")) {
			// SEND INFOMESSAGE
			sender.sendMessage(ChatColor.GRAY + "====  " + ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GRAY + " Server rules:" + ChatColor.GRAY + "  ====");
			for(String messages : Main.config.getStringList("rules")) {
				sender.sendMessage(ChatColor.GRAY + " • " + ChatColor.translateAlternateColorCodes('&', messages));
				}
			return true;
			}
		return false;
		}
}

