package Main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.PvPCommand;
import Events.Disconnect;
import Events.PlayerCommandPreprocess;
import Events.PlayerDeath;
import Events.PlayerRespawn;
import Events.SignChange;
import ItemManager.DroppedItems;
import ItemManager.Projectiles;
import Join.JoinLobby;
import Join.JoinPlayers;
import Join.JoinSigns;
import LaunchManager.Launchpads;
import LaunchManager.Sponge;
import MLG.MLG;
import SoupManager.RefillChests;
import SoupManager.Soup;
import StatisticsManager.Stats;

public class MagicPvP extends JavaPlugin {

	public boolean event = false;
	public String prefix = "¤8[¤6PvP¤8]¤7 ";

	public File Statsfile = new File("plugins/MagicPvP", "Stats.yml");
	public FileConfiguration st = YamlConfiguration.loadConfiguration(this.Statsfile);
	
	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	public ArrayList<Player> inLobby = new ArrayList<Player>();
	public ArrayList<Player> dc = new ArrayList<Player>();
	private Stats Stats;
	
	
	
	
	
	
	/*
	 * Report Command in Arbeit :D
	 */
	
	public void onDisable() {
		String world = lcf.getString("Locations.gamelobby.world");
		double x = lcf.getDouble("Locations.gamelobby.x");
		double y = lcf.getDouble("Locations.gamelobby.y");
		double z = lcf.getDouble("Locations.gamelobby.z");
		double yaw = lcf.getDouble("Locations.gamelobby.yaw");
		double pitch = lcf.getDouble("Locations.gamelobby.pitch");
		
		final Location lobby = new Location(Bukkit.getWorld(world), x, y, z);
		
		lobby.setPitch((float) pitch);
		lobby.setYaw((float) yaw);
		
		for(Player inlobby : inLobby) {
			inlobby.teleport(lobby);	
		}
	}
	
	public void onEnable() {
		this.event = false;
		getCommand("pvp").setExecutor(new PvPCommand(this));

		Bukkit.getServer().getPluginManager().registerEvents(new JoinLobby(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinPlayers(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DroppedItems(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinSigns(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new MLG(this), this);

//		Bukkit.getServer().getPluginManager().registerEvents(new DeathItems(this), this);

		Bukkit.getServer().getPluginManager().registerEvents(new Projectiles(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new RefillChests(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Soup(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Disconnect(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerCommandPreprocess(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerRespawn(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Launchpads(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sponge(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SignChange(this), this);




		Bukkit.getServer().getPluginManager().registerEvents(new Disconnect(this), this);
	    this.Stats = new Stats(this);

		
	}
	
	
	
	public void sendHelp(Player p) {
		p.sendMessage(prefix + "---------- [MagicPvP] ----------");
		p.sendMessage(prefix + "/pvp leave -> Arena Leften");
	}
	
	public Stats getStats() {
	    return this.Stats;
	}

	
}
