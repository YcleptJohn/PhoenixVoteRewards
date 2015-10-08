package uk.co.ycleptjohn.phoenixvote;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Perk {
	Plugin plugin = PhoenixVote.getPlugin();
	private String name;
	private String nameColours;
	private int cost;
	private Material materialicon;
	private List<String> description;
	
	public Perk(String configkey) {
		
		if (plugin.getConfig().getString("store.perks." + configkey + ".name") != null) {
			name = plugin.getConfig().getString("store.perks." + configkey + ".name");
		} else {
			name = "config error";
		}
		
		if (plugin.getConfig().getString("store.perks." + configkey + ".namecolours") != null) {
			nameColours = plugin.getConfig().getString("store.perks." + configkey + ".namecolours");
		} else {
			nameColours = "&a&l"; // Default Green/bold if null
		}
		
		if (plugin.getConfig().getString("store.perks." + configkey + ".cost") != null) {
			cost = plugin.getConfig().getInt("store.perks." + configkey + ".cost");
		} else {
			cost = 1337;
		}
		
		if (plugin.getConfig().getString("store.perks." + configkey + ".shopIcon") != null) {
			materialicon = Material.getMaterial(plugin.getConfig().getString("store.perks." + configkey + ".shopIcon"));
		} else {
			materialicon = Material.RABBIT_FOOT;
		}
		
		if (plugin.getConfig().getStringList("store.perks." + configkey + ".description") != null) {
			description = plugin.getConfig().getStringList("store.perks." + configkey + ".description");
		} else {
			description.clear();
			description.add("Config returned no desc");
		}
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameColours() {
		return nameColours;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Material getMaterial() {
		return materialicon;
	}
	
	public List<String> getDescription() {
		return description;
	}
	
	public ItemStack getItemStack() {
		ItemStack is = new ItemStack(getMaterial());
		return is;
	}
}












