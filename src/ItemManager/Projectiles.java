package ItemManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import Main.MagicPvP;

public class Projectiles implements Listener {

	private MagicPvP plugin;
	public Projectiles(MagicPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		LivingEntity shooter = e.getEntity().getShooter();
		if(shooter instanceof Player) {
			Player p = (Player) shooter;
			if(!(plugin.inLobby.contains(p))) return;
			Projectile proj = e.getEntity();
			if(proj instanceof Arrow) {
				final Arrow a = (Arrow) e.getEntity();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						Bukkit.getServer().getWorld(a.getWorld().getName()).playSound(a.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
						Bukkit.getServer().getWorld(a.getWorld().getName()).playEffect(a.getLocation(), Effect.SMOKE, 1);
						a.remove();
					}
					
				}, 10*10L);
			}
		}
	}
}
