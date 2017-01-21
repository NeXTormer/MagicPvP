package Events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import Main.MagicPvP;

public class SignChange implements Listener {
	
	private MagicPvP plugin;
	public SignChange(MagicPvP plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if(!(p.hasPermission("pvp.createsings"))) return;
		if(!(e.getLine(1).equalsIgnoreCase("[PvP]"))) return;
		if(e.getLine(2).equalsIgnoreCase("Join")) {
			e.setLine(2, "[Join]");
		} else if (e.getLine(2).equalsIgnoreCase("PvP")) {
			e.setLine(2, "[PvP]");
		} else if (e.getLine(2).equalsIgnoreCase("Archer")) {
			e.setLine(2, "[Archer]");
		} else if (e.getLine(2).equalsIgnoreCase("Practice")) {
			e.setLine(2, "[Practice]");
		} else {
			e.setLine(2, "§4Ungültige");
			e.setLine(2, "§4Einbage!");
		}
	}
}
