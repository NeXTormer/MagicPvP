package Join;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Main.MagicPvP;

public class JoinPlayers implements Listener {

	private MagicPvP plugin;
	public JoinPlayers(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	public File locations = new File("plugins/MagicPvP", "Locations.yml");
	public FileConfiguration lcf = YamlConfiguration.loadConfiguration(this.locations);
	
	
	
	@EventHandler
	public void onPlayerInteact(EntityDamageByEntityEvent e) {
		if(!(e.getDamager() instanceof Player)) return;
		if(!(plugin.inLobby.contains(e.getDamager()))) return;
		if(!(e.getEntity() instanceof Player)) return;
		Player p = (Player) e.getDamager();
		Player t = (Player) e.getEntity();
		
		String world = lcf.getString("Locations.arena.world");
		double x = lcf.getDouble("Locations.arena.x");
		double y = lcf.getDouble("Locations.arena.y");
		double z = lcf.getDouble("Locations.arena.z");
		double yaw = lcf.getDouble("Locations.arena.yaw");
		double pitch = lcf.getDouble("Locations.arena.pitch");
		
		Location arena = new Location(Bukkit.getWorld(world), x, y, z);
		arena.setYaw((float) yaw);
		arena.setPitch((float) pitch);
		
		String name = t.getName();
		
		if(name.equalsIgnoreCase("[PvP]")) {
			PvP(p);
			send(p, arena);
		} else if(name.equalsIgnoreCase("[Archer]")) {
			send(p, arena);
			Archer(p);
		} else if(name.equalsIgnoreCase("[Practice]")) {
			Practice(p);
			send(p, arena);

		}
		
		
		
		
	}
	
	
	public void PvP(Player p) {
		Inventory pi = p.getInventory();
		pi.clear();
		
		ItemStack Schwert = new ItemStack(Material.DIAMOND_SWORD);
		Schwert.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		ItemStack Boots = new ItemStack(Material.IRON_BOOTS);
		Boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		ItemStack Leggings = new ItemStack(Material.IRON_LEGGINGS);
		Leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		ItemStack ChestPlate = new ItemStack(Material.IRON_CHESTPLATE);
		ChestPlate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		ItemStack Helmet = new ItemStack(Material.IRON_HELMET);
		Helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		pi.addItem(Schwert);
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.RED_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BROWN_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BOWL, 32));
		for (int i = 0; i < 24; i++) {
			pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
		p.getInventory().setBoots(Boots);
		p.getInventory().setLeggings(Leggings);
		p.getInventory().setChestplate(ChestPlate);
		p.getInventory().setHelmet(Helmet);
		
	}
	
	public void Archer(Player p)  {
		Inventory pi = p.getInventory();
		pi.clear();
		
		ItemStack Schwert = new ItemStack(Material.IRON_SWORD);
		Schwert.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,  1);
		Schwert.addUnsafeEnchantment(Enchantment.KNOCKBACK,  1);
		
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		
		ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
		Boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		Leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		Chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
		Helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		p.getInventory().setHelmet(Helmet);
		p.getInventory().setChestplate(Chestplate);
		p.getInventory().setLeggings(Leggings);
		p.getInventory().setBoots(Boots);
		
		pi.addItem(Schwert);
		pi.addItem(bow);
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		
		pi.addItem(new ItemStack(Material.RED_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BROWN_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BOWL, 32));
		pi.addItem(new ItemStack(Material.ARROW));

		for (int i = 0; i < 24; i++) {
			pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}

	}
	
	public void Practice(Player p) {
		Inventory pi = p.getInventory();
		pi.clear();
		
		ItemStack ChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ChestPlate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		ChestPlate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Schwert = new ItemStack(Material.STONE_SWORD);
		Schwert.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Boots = new ItemStack(Material.IRON_BOOTS);
		Boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Leggings = new ItemStack(Material.IRON_LEGGINGS);
		Leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		ItemStack Helmet = new ItemStack(Material.IRON_HELMET);
		Helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		pi.addItem(Schwert);
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		pi.addItem(new ItemStack(Material.RED_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BROWN_MUSHROOM, 32));
		pi.addItem(new ItemStack(Material.BOWL, 32));
		for (int i = 0; i < 24; i++) {
			pi.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
		p.getInventory().setHelmet(Helmet);
		p.getInventory().setBoots(Boots);
		p.getInventory().setChestplate(ChestPlate);
		p.getInventory().setLeggings(Leggings);
		
	}
	
	public void send(Player p, Location loc) {
		p.sendMessage(plugin.prefix + "Du wurdest in die Arena geportet. Viel GlŸck!");
		p.teleport(loc);
	}
	
}
