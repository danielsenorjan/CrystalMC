package com.crystalmc.plugin;

import com.crystalmc.plugin.commands.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static FileConfiguration config;
	
    @Override
    public void onEnable() {
    	this.saveDefaultConfig();
        config = getConfig();
        
        // INFO COMMANDS
    	this.getCommand("rules").setExecutor(new Rules());
    	this.getCommand("website").setExecutor(new Website());
    	
    	// PUNISHMENT COMMANDS
    	this.getCommand("k").setExecutor(new Kick());
    	this.getCommand("b").setExecutor(new Ban());
    	this.getCommand("ub").setExecutor(new Unban());
    }
    @Override
    public void onDisable() {
    	
    }
}