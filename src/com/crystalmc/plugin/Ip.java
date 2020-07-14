package com.crystalmc.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Ip extends JavaPlugin {
	
	@Override
	public void onEnable() {
		// Startup
		// reloads
		// plugin reloads
	}
	
	@Override
	public void onDisable() {
		//shutdown
		// reloads
		// plugin reloads
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("ip")) {
			if (sender instanceof Player) {
				// player
				Player player = (Player) sender;
				{
					player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "The ip for Crystalmc is:");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "crystalmc.mchost.no");
					return true;
				}
			}
			else {
				// console
				sender.sendMessage("crystalmc.mchost.no");
				return true;
			}
		}
		
		return false;
	}
	
}
