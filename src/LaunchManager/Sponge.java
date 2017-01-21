package LaunchManager;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import Main.MagicPvP;

public class Sponge implements Listener {

	private MagicPvP plugin;
	public Sponge(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	int v1 = 5;
	int v2 = 10;
	int v3 = 15;
	
	
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		Player p = e.getPlayer();
		if(!(p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.SPONGE)) return;
		if(!(p.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() == Material.WALL_SIGN)) return;
		Sign s = (Sign) p.getLocation().subtract(0.0, 2.0, 0.0).getBlock();
		if(s.getLine(1) == "¤4[Sponge!]") {
			String velo = s.getLine(2);
			int v = Integer.valueOf(velo);
			p.setVelocity(p.getVelocity().setY(v));
		}
//		Player p = e.getPlayer();
//		
//		if((p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.SPONGE) && (!(p.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() == Material.SPONGE))) {
//			p.setVelocity(p.getVelocity().setY(v1));
//		}
//		if(((p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.SPONGE) && (p.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() == Material.SPONGE) &&(!(p.getLocation().subtract(0.0, 3.0, 0.0).getBlock().getType() == Material.SPONGE)))) {
//			p.setVelocity(p.getVelocity().setY(v2));
//		}
//		if((((p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.SPONGE) && (p.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() == Material.SPONGE) &&
//				((p.getLocation().subtract(0.0, 3.0, 0.0).getBlock().getType() == Material.SPONGE))) && (!(p.getLocation().subtract(0.0, 4.0, 0.0).getBlock().getType() == Material.SPONGE)))) {
//			p.setVelocity(p.getVelocity().setY(v3));
//		}
		
		
	}
	
	
}
