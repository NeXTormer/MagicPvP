package SoupManager;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Main.MagicPvP;

public class Soup implements Listener {

	private MagicPvP plugin;
	public Soup(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onStewEat(PlayerInteractEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		if(!((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) return;
//		if(!(e.getItem().getType() == Material.MUSHROOM_SOUP)) return;
		if(!(e.getMaterial() == Material.MUSHROOM_SOUP)) return;
		Player p = e.getPlayer();
		
		double health = (((Damageable)p).getHealth());
		if(health == 20.0) return;
		health = health + 7;
        if (health > 20.0) {
          health = 20.0;
        }
		p.setHealth(health);
		
		p.getItemInHand().setType(Material.BOWL);
//        ItemStack i = new ItemStack(Material.BOWL, 1);
//        p.getItemInHand().setItemMeta(i.getItemMeta().clone());
	}
	
}
