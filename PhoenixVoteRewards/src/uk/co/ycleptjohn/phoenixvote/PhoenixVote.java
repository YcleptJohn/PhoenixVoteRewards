package uk.co.ycleptjohn.phoenixvote;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.ycleptjohn.phoenixvote.commands.cmdShop;
import uk.co.ycleptjohn.phoenixvote.commands.cmdVote;
import uk.co.ycleptjohn.phoenixvote.commands.cmdVoteLinks;

public class PhoenixVote extends JavaPlugin implements Listener {
	public PhoenixVote utilPlugin = null;
	
	private static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		registerEvents(this, new PhoenixVoteEvents());
		getCommand("shop").setExecutor(new cmdShop());
		getCommand("vote").setExecutor(new cmdVote());
		getCommand("votelinks").setExecutor(new cmdVoteLinks());
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
