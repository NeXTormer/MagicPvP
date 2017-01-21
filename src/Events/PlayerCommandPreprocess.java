package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import Main.MagicPvP;

public class PlayerCommandPreprocess implements Listener {

	
	private MagicPvP plugin;
	public PlayerCommandPreprocess(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
		if(!(plugin.inLobby.contains(e.getPlayer()))) return;
		Player p = e.getPlayer();
		if((p.hasPermission("pvp.commands"))) return;
		String[] cmd = e.getMessage().split(" ");
		
		
		
		
		if(cmd[0].equalsIgnoreCase("/pvp")) return;
		if(cmd[0].equalsIgnoreCase("/msg")) return;
		if(cmd[0].equalsIgnoreCase("/r")) return;
		if(cmd[0].equalsIgnoreCase("/staff")) return;

		
		
		e.setCancelled(true);
		p.sendMessage(plugin.prefix + "Du kannst keine Befehle wŠhrend des Spieles ausfŸhren!");
		p.sendMessage(plugin.prefix + "Wenn du die Arena verlassen willst -> /pvp leave");
		
	}
}
