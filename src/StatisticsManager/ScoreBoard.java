package StatisticsManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard {
	
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard sb = manager.getNewScoreboard();
	Objective o = sb.registerNewObjective("MagicPVPSB", "dummy");
	
	/*
	 * wie?
	 */
	

	public void setSB(Player p) {
		o.setDisplayName("¤8[¤6PvP¤8]¤7");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score kills = o.getScore(Bukkit.getOfflinePlayer("¤aKills:"));
		Score deaths = o.getScore(Bukkit.getOfflinePlayer("¤aDeaths:"));
		Score KDR = o.getScore(Bukkit.getOfflinePlayer("¤aK/D"));
	}
	
	public void removeSB(Player p) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
