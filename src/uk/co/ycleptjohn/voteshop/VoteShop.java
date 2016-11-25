package uk.co.ycleptjohn.voteshop;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ycleptjohn.voteshop.commands.*;
import uk.co.ycleptjohn.voteshop.events.InventoryClickEventHandler;

public class VoteShop extends JavaPlugin implements Listener {
	public VoteShop utilPlugin = null;
	
	private static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		registerEvents(this, new VoteShopEvents(), new InventoryClickEventHandler());
		getCommand("shop").setExecutor(new cmdShopV2());
		getCommand("vote").setExecutor(new cmdVote());
		getCommand("votelinks").setExecutor(new cmdVoteLinks());
		getCommand("shopreload").setExecutor(new cmdReload());
		getCommand("configGEN").setExecutor(new cmdGENtest());
		
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
