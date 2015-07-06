package uk.co.ycleptjohn.phoenixvote.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class cmdShop implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		Plugin plugin = PhoenixVote.getPlugin();
		Player player = (Player) cmdP;
		if (plugin.getConfig().getConfigurationSection("store.perks") != null) {
			int perkKeys = plugin.getConfig().getConfigurationSection("store.perks").getKeys(false).size();
			int shopSlots = perkKeys + (9 - (perkKeys % 9)); // Calculate appropriate shop slots by rounding up the remainder to the nearest multiple of 9
			Inventory shopInv = Bukkit.createInventory(null, shopSlots, ChatColor.DARK_RED + "PhoenixCraft Rewards Shop");
			int i = 0;
			for (String currentKey : plugin.getConfig().getConfigurationSection("store.perks").getKeys(false)) {
				
				Material perkMaterial = null;
				ItemStack perk = null;
				if (plugin.getConfig().getString("store.perks." + currentKey + ".shopIcon") != null) {
					perkMaterial = Material.getMaterial(plugin.getConfig().getString("store.perks." + currentKey + ".shopIcon"));
					if (perkMaterial == null) {
						perkMaterial = Material.RABBIT_FOOT;
						perk = new ItemStack(perkMaterial);
					}
				} else {
					perkMaterial = Material.RABBIT_FOOT;
					perk = new ItemStack(perkMaterial);
				}
				
				ItemMeta perkMeta = perk.getItemMeta();
				perkMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("store.perks." + currentKey + ".name")));
				List<String> perkLore = new ArrayList<String>();
				
				if (plugin.getConfig().contains("store.perks." + currentKey + ".cost")) {
					perkLore.add("Cost: " + ChatColor.YELLOW + plugin.getConfig().getString("store.perks." + currentKey + ".cost"));
				} else {
					perkLore.add("Cost: " + ChatColor.RED + "Config error");
				}
				perkLore.addAll(plugin.getConfig().getStringList("store.perks." + currentKey + ".permission"));
				if (plugin.getConfig().contains("store.perks." + currentKey + ".description")) {
					perkLore.addAll(plugin.getConfig().getStringList("store.perks." + currentKey + ".description"));
				} else {
					perkLore.add(ChatColor.RED + "Config error");
				}
				perkMeta.setLore(perkLore);
				perk.setItemMeta(perkMeta);
				shopInv.setItem(i, perk);
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
