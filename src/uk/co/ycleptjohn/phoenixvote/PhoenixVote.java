package uk.co.ycleptjohn.phoenixvote;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ycleptjohn.phoenixvote.commands.*;
import uk.co.ycleptjohn.phoenixvote.events.InventoryClickEventHandler;

public class PhoenixVote extends JavaPlugin implements Listener {
	public PhoenixVote utilPlugin = null;
	
	private static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		registerEvents(this, new PhoenixVoteEvents(), new InventoryClickEventHandler());
		getCommand("shop").setExecutor(new cmdShopV2());
		getCommand("vote").setExecutor(new cmdVote());
		getCommand("votelinks").setExecutor(new cmdVoteLinks());
		getCommand("shopreload").setExecutor(new cmdReload());
		getCommand("configGEN").setExecutor(new cmdGENtest());
		getCommand("configSAVE").setExecutor(new cmdSAVEtest());
		
	}
	
	
	public void onDisable() {
		plugin = null;
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
	
	public static void registerEvents(Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
	
}
