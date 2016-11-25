package uk.co.ycleptjohn.voteshop.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.Perk;
import uk.co.ycleptjohn.voteshop.VoteShop;

public class InventoryClickEventHandler implements Listener {
	Plugin plugin = VoteShop.getPlugin();
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		//Player p = (Player) e.getWhoClicked();
		if (ChatColor.stripColor(e.getInventory().getTitle()).contains("PhoenixCraft") && (e.getCurrentItem().getType() != Material.AIR)) {
			e.setCancelled(true);
			ItemStack clickedPerkItem = e.getCurrentItem();
			handleInitialClick(clickedPerkItem);
		}
	}
	
	public void handleInitialClick(ItemStack clickedPerkItem) {
		if (clickedPerkItem.getItemMeta().getLore().get(1) != null) {
			String clickedConfigKey = convertToVisibleString(clickedPerkItem.getItemMeta().getLore().get(1)); // Pull hidden config key from lore and make it visible
			if (plugin.getConfig().contains("store.perks." + clickedConfigKey)) {
				Perk clickedPerk = new Perk(clickedConfigKey);
				confirmPurchase(clickedPerk);
			}
		}
	}

	public void confirmPurchase(Perk chosenPerk) {
		
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
