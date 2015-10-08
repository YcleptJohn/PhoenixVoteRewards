package uk.co.ycleptjohn.phoenixvote.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEventHandler implements Listener {
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clickedperk = e.getCurrentItem();
		Bukkit.broadcastMessage("test");
	}
	
	public void confirmPurchase() {
		
	}
	
	public void handlePurchase() {
		
	}
	
	
	
}
