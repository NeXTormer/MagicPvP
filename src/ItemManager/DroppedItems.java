package ItemManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import Main.MagicPvP;

public class DroppedItems implements Listener {

	private MagicPvP plugin;
	public DroppedItems(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		final Player p = e.getPlayer();
		final Item i = e.getItemDrop();
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				if(!(i.isDead())) {
					Bukkit.getServer().getWorld(p.getWorld().getName()).playSound(i.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					Bukkit.getServer().getWorld(p.getWorld().getName()).playEffect(i.getLocation(), Effect.SMOKE, 1);
					i.remove();	
				}
				
			}
			
		}, 10*10L);
	}
}
