package com.crystalmc.plugin.commands;

import java.util.logging.Logger;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.crystalmc.plugin.Main;

public class Unban implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("ub")) {
			// WRONG USAGE
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " Usage: /ub <user>");
				return true;
			}
			// CHECK IF PLAYER IS BANNED
			if (Bukkit.getBanList(BanList.Type.NAME).isBanned(args[0]) == false) {
				if (sender instanceof Player) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.RED + " " + args[0] +" isn't banned.");
				}
				else if (sender instanceof ConsoleCommandSender) {
					Logger log = Bukkit.getLogger();
					log.info(args[0] +" isn't banned.");
				}
				return true;
			}
			// GET PLAYERNAME FROM ARG 0
			Player player = Bukkit.getPlayerExact(args[0]);
			//GET BANLIST, KICK PLAYER AND SEND MESSAGE TO SENDER
	        Bukkit.getBanList(BanList.Type.NAME).pardon(args[0]);
			if (sender instanceof Player) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix")) + ChatColor.GREEN + " " + args[0] +" has been ubanned");
			}
			else if (sender instanceof ConsoleCommandSender) {
				Logger log = Bukkit.getLogger();
				log.info(args[0] +" has been ubanned");
			}
			return true;
			}
		return false;
		}

}
