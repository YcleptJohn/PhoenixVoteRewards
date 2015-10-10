package uk.co.ycleptjohn.phoenixvote.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import uk.co.ycleptjohn.phoenixvote.Perk;

public class InventoryClickEventHandler implements Listener {
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		//Player p = (Player) e.getWhoClicked();
		ItemStack clickedperk = e.getCurrentItem();
		
		List<String> clickedLore = clickedperk.getItemMeta().getLore();
		String clickedLoreHiddenLine = clickedLore.get(1);
		Bukkit.broadcastMessage("Hidden:" + clickedLoreHiddenLine);
		Bukkit.broadcastMessage("Unhidden:" + convertToVisibleString(clickedLoreHiddenLine));
		String clickedPerkKey = convertToVisibleString(clickedLoreHiddenLine);
		Perk perk = new Perk(clickedPerkKey);
		Bukkit.broadcastMessage(perk.getNameColours());
		Bukkit.broadcastMessage(perk.getName());
		Bukkit.broadcastMessage(perk.getCost() + "");
		Bukkit.broadcastMessage(perk.getDescription().toString());
		Bukkit.broadcastMessage(perk.getMaterial().name());
	}
	
	public void confirmPurchase() {
		
	}
	
	public void handlePurchase() {
		
	}
	
	public static String convertToInvisibleString(String s) {
		String hidden = "";
		for (char c : s.toCharArray()) hidden += ChatColor.COLOR_CHAR+""+c;
		return hidden;
	}
	
	public static String convertToVisibleString(String s) {
		String unhidden = s.replaceAll("§", "");
		return unhidden;
	}
	
	
	
}
