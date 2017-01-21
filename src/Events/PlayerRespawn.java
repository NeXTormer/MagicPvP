package Events;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import Main.MagicPvP;

public class PlayerRespawn implements Listener {

	private MagicPvP plugin;
	public PlayerRespawn(MagicPvP plugin) {
		this.plugin = plugin;
	}

	
	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	private ArrayList<Player> nodrop = new ArrayList<Player>();

	

	@EventHandler
	public void onPlayerRespawn(final PlayerRespawnEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		nodrop.add(e.getPlayer());
		String world = lcf.getString("Locations.lobby.world");
		double x = lcf.getDouble("Locations.lobby.x");
		double y = lcf.getDouble("Locations.lobby.y");
		double z = lcf.getDouble("Locations.lobby.z");
		double yaw = lcf.getDouble("Locations.lobby.yaw");
		double pitch = lcf.getDouble("Locations.lobby.pitch");
		
		final Location lobby = new Location(Bukkit.getWorld(world), x, y, z);
		
		lobby.setPitch((float) pitch);
		lobby.setYaw((float) yaw);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				e.getPlayer().teleport(lobby);
				e.getPlayer().getInventory().setArmorContents(null);
				e.getPlayer().getInventory().clear();
				nodrop.remove(e.getPlayer());
			}
			
		}, 21L);
		
		
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(nodrop.contains(p)) {
			e.setCancelled(true);
			p.sendMessage(plugin.prefix);
		}
	}
	
}
