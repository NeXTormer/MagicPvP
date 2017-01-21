package Events;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Main.MagicPvP;

public class Disconnect implements Listener {
	
	private MagicPvP plugin;
	public Disconnect(MagicPvP plugin) {
		this.plugin = plugin;
	}
	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(plugin.inLobby.contains(p)) {
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			plugin.inLobby.remove(p);
			String world = lcf.getString("Locations.gamelobby.world");
			double x = lcf.getDouble("Locations.gamelobby.x");
			double y = lcf.getDouble("Locations.gamelobby.y");
			double z = lcf.getDouble("Locations.gamelobby.z");
			double yaw = lcf.getDouble("Locations.gamelobby.yaw");
			double pitch = lcf.getDouble("Locations.gamelobby.pitch");
			
			final Location lobby = new Location(Bukkit.getWorld(world), x, y, z);
			
			lobby.setPitch((float) pitch);
			lobby.setYaw((float) yaw);
			p.teleport(lobby);
		}
	}
}
