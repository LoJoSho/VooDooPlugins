package me.lojosho.voodoomasterplugin;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class BatMembranes extends JavaPlugin implements Listener {
    private Main plugin;
    public BatMembranes(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BatDeathMembranes(EntityDeathEvent event) {
        if (this.getConfig().getBoolean("BatMembranes")) {
            Entity entity = event.getEntity();
            int upper = this.getConfig().getInt("maxMembranes");
            int lower = this.getConfig().getInt("minMembranes");
            if (entity.getType() == EntityType.BAT) {
                int Random = (int) (Math.random() * (upper - lower + 1)) + lower;
                event.getDrops().add(new ItemStack(Material.PHANTOM_MEMBRANE, Random));
            }
        }
    }
}
