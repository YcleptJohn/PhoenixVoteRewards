package uk.co.ycleptjohn.phoenixvote.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.Perk;
import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class cmdShopV2 implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		Plugin plugin = PhoenixVote.getPlugin();
		Player player = (Player) cmdP;
		if (plugin.getConfig().getConfigurationSection("store.perks") != null) {
			int perkKeys = plugin.getConfig().getConfigurationSection("store.perks").getKeys(false).size();
			int shopSlots = perkKeys + (9 - (perkKeys % 9)); // Calculate appropriate shop slots by rounding up the remainder to the nearest multiple of 9
			Inventory shopInv = Bukkit.createInventory(null, shopSlots, ChatColor.DARK_RED + "PhoenixCraft Rewards Shop");
			for (String currentKey : plugin.getConfig().getConfigurationSection("store.perks").getKeys(false)) {
				Perk currentPerk = new Perk(currentKey);
				currentPerk.getItemStack();
			}

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
