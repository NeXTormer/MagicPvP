package Join;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Main.MagicPvP;

public class JoinLobby implements Listener {

	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	private MagicPvP plugin;
	public JoinLobby(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(EntityDamageByEntityEvent e) {		
			Entity ent = e.getDamager();
			Entity damaged = e.getEntity();
			if(!(damaged instanceof Player)) return;			
			Player d = (Player) damaged;
			if(!(ent instanceof Player)) return;
			Player p = (Player) ent;
			
			String name = d.getName();
			
			
			if(name.equalsIgnoreCase("PvP Lobby")) {
				

				String world = lcf.getString("Locations.lobby.world");
				double x = lcf.getDouble("Locations.lobby.x");
				double y = lcf.getDouble("Locations.lobby.y");
				double z = lcf.getDouble("Locations.lobby.z");
				double yaw = lcf.getDouble("Locations.lobby.yaw");
				double pitch = lcf.getDouble("Locations.lobby.pitch");
				
				Location lobby = new Location(Bukkit.getWorld(world), x, y, z);
				
				lobby.setPitch((float) pitch);
				lobby.setYaw((float) yaw);
				
				p.teleport(lobby);
				p.sendMessage(plugin.prefix + "Du wurdest in die PvP - Lobby geportet. Viel Spa§ beim Spielen :)");
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				plugin.inLobby.add(p);
			
				
			}
		
	}
	
	
}
