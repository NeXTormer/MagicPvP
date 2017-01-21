package ItemManager;
//
//import java.util.List;
//
//import net.minecraft.server.v1_7_R1.Material;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Effect;
//import org.bukkit.Sound;
//import org.bukkit.entity.Item;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.entity.PlayerDeathEvent;
//import org.bukkit.inventory.ItemStack;

import org.bukkit.event.Listener;

import Main.MagicPvP;

public class DeathItems implements Listener {

	private MagicPvP plugin;
	public DeathItems(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
//	@EventHandler
//	public void onDeathItemDrop(PlayerDeathEvent e) {
//		if(!(plugin.inLobby.contains(e.getEntity()))) return;
//		final Player p = e.getEntity();
//		final List<ItemStack> items = e.getDrops();
//		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//
//			@Override
//			public void run() {
//				for(ItemStack s : items) {
//					s.setType(null);
//					
//				}
//			}
//			
//		}, 10*20L);
//		
//		
//		
//		
//	}
	
}
