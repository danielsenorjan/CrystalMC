package com.crystalmc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.BanList;

import com.crystalmc.plugin.Main;

public class Ban implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("b")) {
			// WRONG USAGE
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " Usage: /b <user> <reason>");
				return true;
			}
			// GET PLAYERNAME FROM ARG 0
			Player player = Bukkit.getPlayerExact(args[0]);
			// STRINGBUILDER ARG 1++
			StringBuilder sb = new StringBuilder();
	        for(int i = 1; i < args.length; ++i) {
	            sb.append(args[i]).append(" ");
	        }
	        String reason = sb.toString().trim();
	        // NO REASON, WRONG USAGE
			if (reason.length() == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " You need to specify a reason.");
				return true;
			}
			//GET BANLIST, KICK PLAYER AND SEND MESSAGE TO SENDER
	        Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], reason, null, null);
	        if (!(player == null)) {
				player.kickPlayer(ChatColor.RED + "You were banned for: " + reason);
	        }
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GREEN + " " + args[0] +" has been banned for reason: " + reason);
			return true;
			}
		return false;
		}
}
