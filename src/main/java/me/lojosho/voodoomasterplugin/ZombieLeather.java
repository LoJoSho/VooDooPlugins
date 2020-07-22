package me.lojosho.voodoomasterplugin;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class ZombieLeather {
    private final Main plugin;
    public ZombieLeather(Main plugin) {
        this.plugin = plugin;
    }

    public void furnaceFurnace() {
        if (plugin.getConfig().getBoolean("ZombieLeatherRecipe")) {
            int XP = plugin.getConfig().getInt("LeatherCookingXP");
            int Time = plugin.getConfig().getInt("LeatherCookingTime");
            ItemStack result = new ItemStack(Material.LEATHER);
            FurnaceRecipe recipe = new FurnaceRecipe(result, Material.ROTTEN_FLESH);
            recipe.setExperience(XP);
            recipe.setCookingTime(Time);
            plugin.getServer().addRecipe(recipe);
        }
    }
}
