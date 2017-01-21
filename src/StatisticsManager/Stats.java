package StatisticsManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.MagicPvP;

public class Stats implements Listener {

	private MagicPvP plugin;
	public Stats(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	//In arbeit
	

	public File Stats = new File("plugins/MagicPvP", "Stats.yml");
	public FileConfiguration st = YamlConfiguration.loadConfiguration(this.Stats);

	public void addKill(Player p) {
		if(st.contains(p.getName() + ".kills")) {
			int kills = st.getInt(p.getName() + ".kills");
			int newKills = kills + 1;
			st.set(p.getName() + ".kills", newKills);
		} else {
			st.set(p.getName() + ".kills", 1);
		}
		
		try {
			st.save(Stats);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plugin.reloadConfig();
	}
	
	public void addDeath(Player p) {
		if(st.contains(p.getName() + ".deaths")) {
			int kills = st.getInt(p.getName() + ".deaths");
			int newKills = kills + 1;
			st.set(p.getName() + ".deaths", newKills);
		} else {
			st.set(p.getName() + ".deaths", 1);
		}
		
		try {
			st.save(Stats);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plugin.reloadConfig();
	}
	
	public int getKills(Player p) {
		int kills = st.getInt(p.getName() + ".kills");
		return kills;
	}
	
	public int getDeaths(Player p) {
		int deaths = st.getInt(p.getName() + ".deaths");
		return deaths;
	}
	
	public int getKDR(Player p) {
		int deaths = st.getInt(p.getName() + ".deaths");
		int kills = st.getInt(p.getName() + ".kills");
		int KDR = kills/deaths;
		return KDR;
	}
	
	
	
	
	
	
	
	

	
}
