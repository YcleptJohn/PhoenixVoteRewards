package uk.co.ycleptjohn.phoenixvote.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.Perk;
import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class cmdShopV2 implements CommandExecutor, Listener {
	Plugin plugin = PhoenixVote.getPlugin();
	
	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		Player player = (Player) cmdP;
		
		if (plugin.getConfig().getConfigurationSection("store.perks") != null) {
			int perkKeysCount = plugin.getConfig().getConfigurationSection("store.perks").getKeys(false).size();
			int shopSlots = perkKeysCount + (9 - (perkKeysCount % 9)); // Calculate appropriate shop slots by rounding up the remainder to the nearest multiple of 9
			Inventory shopInv = Bukkit.createInventory(null, shopSlots, ChatColor.DARK_RED + "PhoenixCraft Rewards Shop");
			
			int i = 0; // Simple count for the inventory placement index
			for (String currentKey : plugin.getConfig().getConfigurationSection("store.perks").getKeys(false)) {
				Perk currentPerk = new Perk(currentKey);
				ItemMeta currentPerkMeta = currentPerk.getItemMeta();
				ItemStack currentPerkItemStack = currentPerk.getItemStack();
				List<String> currentPerkLore = new ArrayList<String>();
				
				currentPerkMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', currentPerk.getNameColours() + currentPerk.getName()));
				currentPerkLore.add("Cost: " + ChatColor.YELLOW + currentPerk.getCost());
				currentPerkLore.add(convertToInvisibleString(currentKey)); // Add invisible 'currentKey' to 2nd lore line (index 1) for config lookups on click events, also adds a line space
				currentPerkLore.addAll(currentPerk.getDescription());
				currentPerkMeta.setLore(currentPerkLore);
				currentPerkItemStack.setItemMeta(currentPerkMeta);
				shopInv.setItem(i, currentPerkItemStack);
				i++;
			}
			player.openInventory(shopInv);

		} else {
			//TODO output no-config
		}

		return true;
	}


	public static String convertToInvisibleString(String s) {
		String hidden = "";
		for (char c : s.toCharArray()) hidden += ChatColor.COLOR_CHAR+""+c;
		return hidden;
	}

}
