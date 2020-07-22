package me.lojosho.voodoomasterplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutClean implements Listener {
    private final Main plugin;
    public CutClean(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAnimalDeath(EntityDeathEvent event) {
        if (plugin.getConfig().getBoolean("CutClean")) {
            Entity entity = event.getEntity();
            if (entity.getType() == EntityType.PIG) {
                if (plugin.getConfig().getBoolean("FromPigs")) {
                    int upper = plugin.getConfig().getInt("pigmax");
                    int lower = plugin.getConfig().getInt("pigmin");
                    int XPPigMax = plugin.getConfig().getInt("pigXPmax");
                    int XPPigMin = plugin.getConfig().getInt("pigXPmin");
                    int RandomPig = (int) (Math.random() * (upper - lower + 1)) + lower;
                    int RandomPigXP = (int) (Math.random() * (XPPigMax - XPPigMin + 1)) + XPPigMin;
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Material.COOKED_PORKCHOP, RandomPig));
                    event.setDroppedExp(RandomPigXP);
                }
            }
            if (entity.getType() == EntityType.COW) {
                if (plugin.getConfig().getBoolean("FromCows")) {
                    int upper = plugin.getConfig().getInt("Cowsmax");
                    int lower = plugin.getConfig().getInt("Cowsmin");
                    int XPCowMax = plugin.getConfig().getInt("CowsXPmax");
                    int XPCowMin = plugin.getConfig().getInt("CowsXPmin");
                    int RandomCow = (int) (Math.random() * (upper - lower + 1)) + lower;
                    int RandomCowXP = (int) (Math.random() * (XPCowMax - XPCowMin + 1)) + XPCowMin;
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Material.COOKED_BEEF, RandomCow));
                    event.setDroppedExp(RandomCowXP);
                }
            }
            if (entity.getType() == EntityType.CHICKEN) {
                if (plugin.getConfig().getBoolean("FromChicken")) {
                    int upper = plugin.getConfig().getInt("Chickenmax");
                    int lower = plugin.getConfig().getInt("Chickenmin");
                    int XPMax = plugin.getConfig().getInt("ChickenXPmax");
                    int XPMin = plugin.getConfig().getInt("ChickenXPmin");
                    int RandomAmountDropped = (int) (Math.random() * (upper - lower + 1)) + lower;
                    int RandomXP = (int) (Math.random() * (XPMax - XPMin + 1)) + XPMin;
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, RandomAmountDropped));
                    event.setDroppedExp(RandomXP);
                }
            }
            if (entity.getType() == EntityType.SHEEP) {
                if (plugin.getConfig().getBoolean("FromSheep")) {
                    int upper = plugin.getConfig().getInt("Sheepmax");
                    int lower = plugin.getConfig().getInt("Sheepmin");
                    int XPMax = plugin.getConfig().getInt("SheepXPmax");
                    int XPMin = plugin.getConfig().getInt("SheepXPmin");
                    int RandomAmountDropped = (int) (Math.random() * (upper - lower + 1)) + lower;
                    int RandomXP = (int) (Math.random() * (XPMax - XPMin + 1)) + XPMin;
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Material.COOKED_MUTTON, RandomAmountDropped));
                    event.setDroppedExp(RandomXP);
                }
            }
        }
}
    @EventHandler
    public void onIronBlockBreak(BlockBreakEvent event) {
        if (plugin.getConfig().getBoolean("SmeltedOres")) {
            if (plugin.getConfig().getBoolean("SmeltedIron")) {
                if (event.getBlock().getType() == Material.IRON_ORE) {
                    Block b = event.getBlock();
                    b.setType(Material.AIR);
                    b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_INGOT, 1));
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onGoldBlockBreak(BlockBreakEvent event) {
        if (plugin.getConfig().getBoolean("SmeltedOres")) {
            if (plugin.getConfig().getBoolean("SmeltedGold")) {
                if (event.getBlock().getType() == Material.GOLD_ORE) {
                    Block b = event.getBlock();
                    b.setType(Material.AIR);
                    b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onGravelBlockBreak(BlockBreakEvent event) {
        if (plugin.getConfig().getBoolean("GravelAlwaysFlint")) {
            if (event.getBlock().getType() == Material.GRAVEL) {
                Block b = event.getBlock();
                b.setType(Material.AIR);
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.FLINT, 1));
                event.setCancelled(true);
            }
        }
    }
}
