package SoupManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Main.MagicPvP;

public class RefillChests implements Listener {

	private MagicPvP plugin;
	public RefillChests(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onRefillchestOpen(PlayerInteractEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(!(e.getClickedBlock().getType() == Material.TRAPPED_CHEST)) return;
		e.setCancelled(true);
		Inventory inv = Bukkit.createInventory(null, 54, "¤6¤lRefill Chest");
		for(int i = 0; i < 54; i++) {
			inv.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
		e.getPlayer().closeInventory();
		e.getPlayer().openInventory(inv);
	}
}
