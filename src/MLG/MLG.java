package MLG;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import Main.MagicPvP;

public class MLG implements Listener {

	private MagicPvP plugin;
	public MLG(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	ArrayList<Block> water = new ArrayList<Block>();
	
	
	@EventHandler
	public void onMLG(PlayerBucketEmptyEvent e) {
		final Player p = e.getPlayer();
		if(!(plugin.inLobby.contains(p))) return;
		if(e.getBucket() == Material.WATER_BUCKET) {
			BlockFace bf = e.getBlockFace();
			final Block b = e.getBlockClicked().getRelative(bf);
			water.add(b);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					p.getItemInHand().setType(Material.WATER_BUCKET);
				}
				
			}, 2);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					if(b.getType() == Material.STATIONARY_WATER || b.getType() == Material.WATER) {
						b.setType(Material.AIR);	
						water.remove(b);
					}
					
				}
				
			}, 10);
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(plugin.inLobby.contains(e.getPlayer())) {
			if((e.getPlayer().hasPermission("pvp.mod"))) return;
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(plugin.inLobby.contains(e.getPlayer())) {
			if((e.getPlayer().hasPermission("pvp.mod"))) return;
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onWaterSpread(BlockFromToEvent e) {
		if(water.contains(e.getBlock())) {
			e.setCancelled(true);
		}
	}
	
}
