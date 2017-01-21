package Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import Main.MagicPvP;

public class PvPCommand implements CommandExecutor {

	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	private MagicPvP plugin;
	public PvPCommand(MagicPvP plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("pvp")) {
				if(args.length == 0) {
					plugin.sendHelp(p);
					
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("info")) {
						plugin.sendHelp(p);
					}
					if(args[0].equalsIgnoreCase("leave")) {
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
						p.sendMessage(plugin.prefix + "Du hast die PvP Arena verlassen!");
					} else {
						p.sendMessage(plugin.prefix + "Du bist ein keiner PvP Lobby!");
					}

					}
					
				} else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("setspawn") && args[1].equalsIgnoreCase("lobby")) {
						if(p.hasPermission("pvp.setspawn.lobby")) {
							lcf.set("Locations.lobby.world", p.getLocation().getWorld().getName());
							lcf.set("Locations.lobby.x", p.getLocation().getX());
							lcf.set("Locations.lobby.y", p.getLocation().getY());
							lcf.set("Locations.lobby.z", p.getLocation().getZ());
							lcf.set("Locations.lobby.yaw", p.getLocation().getYaw());
							lcf.set("Locations.lobby.pitch", p.getLocation().getPitch());
							try {
								lcf.save(locations);
								p.sendMessage(plugin.prefix + "LobbySpawn gesetzt!");
							} catch (IOException e) {
								e.printStackTrace();
								p.sendMessage(plugin.prefix + "Fehler: IOException");
							}
							plugin.reloadConfig();
							
						}
					}
					if(args[0].equalsIgnoreCase("setspawn") && args[1].equalsIgnoreCase("gamelobby")) {
						if(p.hasPermission("pvp.setspawn.lobby")) {
							lcf.set("Locations.gamelobby.world", p.getLocation().getWorld().getName());
							lcf.set("Locations.gamelobby.x", p.getLocation().getX());
							lcf.set("Locations.gamelobby.y", p.getLocation().getY());
							lcf.set("Locations.gamelobby.z", p.getLocation().getZ());
							lcf.set("Locations.gamelobby.yaw", p.getLocation().getYaw());
							lcf.set("Locations.gamelobby.pitch", p.getLocation().getPitch());
							try {
								lcf.save(locations);
								p.sendMessage(plugin.prefix + "GamelobbySpawn gesetzt!");
							} catch (IOException e) {
								e.printStackTrace();
								p.sendMessage(plugin.prefix + "Fehler: IOException");
							}
							plugin.reloadConfig();

							
						}
					}
					if(args[0].equalsIgnoreCase("setspawn") && args[1].equalsIgnoreCase("arena")) {
						if(p.hasPermission("pvp.setspawn.arena")) {
							lcf.set("Locations.arena.world", p.getLocation().getWorld().getName());
							lcf.set("Locations.arena.x", p.getLocation().getX());
							lcf.set("Locations.arena.y", p.getLocation().getY());
							lcf.set("Locations.arena.z", p.getLocation().getZ());
							lcf.set("Locations.arena.yaw", p.getLocation().getYaw());
							lcf.set("Locations.arena.pitch", p.getLocation().getPitch());
							try {
								lcf.save(locations);
								p.sendMessage(plugin.prefix + "ArenaSpawn gesetzt!");
							} catch (IOException e) {
								e.printStackTrace();
								p.sendMessage(plugin.prefix + "Fehler: IOException");
							}	
							plugin.reloadConfig();

						}
					}
				}
			}
		} else {
			sender.sendMessage("PvP Befehle von der Konsole noch nicht aktiviert!");
		}

		return true;
	}

}
