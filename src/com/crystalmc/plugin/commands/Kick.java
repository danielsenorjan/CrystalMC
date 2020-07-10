package com.crystalmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalmc.plugin.Main;

public class Kick implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("k")) {
	        // WRONG USAGE
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " Usage: /k <user> <reason>");
				return true;
			}
			// GET PLAYERNAME FROM ARG 0
			Player player = Bukkit.getPlayerExact(args[0]);
			
			// SEE IF PLAYER IS ONLINE
			if (player == null) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " " + args[0] +" is not online.");
				return true;
			}

			// STRINGBUILDER ARG 1++
			StringBuilder sb = new StringBuilder();
	        for(int i = 1; i < args.length; ++i) {
	            sb.append(args[i]).append(" ");
	        }
	        String reason = sb.toString().trim();
			// NO REASON
			if (reason.length() == 0) {
				// KICK PLAYER WITHOUT REASON
				player.kickPlayer("You were kicked.");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GREEN + " " + player.getName() +" has been kicked without a reason.");
				return true;
			}
			// KICK PLAYER AND SEND MESSAGE TO SENDER
			player.kickPlayer("You were kicked for: " + reason);
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GREEN + " " + player.getName() +" has been kicked for reason: " + reason);
			return true;
			}
		return false;
		}

}
