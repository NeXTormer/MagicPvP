package LaunchManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Main.MagicPvP;

public class Launchpads implements Listener {
	
	private MagicPvP plugin;
	public Launchpads(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		
		if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE) {
			Vector v = p.getLocation().getDirection().multiply(2.5D).setY(0.7);
			p.setVelocity(v);
			p.playSound(loc, Sound.EXPLODE, 100, 100);
		}
	}
	
	

}
