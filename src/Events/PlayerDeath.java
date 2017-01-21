package Events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import Main.MagicPvP;

public class PlayerDeath implements Listener {
	
	

	private MagicPvP plugin;
	public PlayerDeath(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if(!(plugin.inLobby.contains(e.getEntity()))) return;
		if(e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity();
			p.sendMessage(plugin.prefix + "Du bist von " + p.getKiller().getName() + " getštet worden!");
			
		}
		plugin.getStats().addDeath(e.getEntity());
		if(e.getEntity().getKiller() instanceof Player) {
			Player killer = e.getEntity().getKiller();
			killer.sendMessage(plugin.prefix + "Du hast " + e.getEntity().getName() + " getštet!");

		}

		
		
	}
}
