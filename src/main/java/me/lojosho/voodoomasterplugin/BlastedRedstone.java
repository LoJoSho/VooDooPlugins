package me.lojosho.voodoomasterplugin;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class BlastedRedstone {
    private final Main plugin;

    public BlastedRedstone(Main plugin) {
        this.plugin = plugin;
    }

    public void furnaceFurnace() {
        if (plugin.getConfig().getBoolean("BlastedRedstone")) {
            int XP = plugin.getConfig().getInt("BlastedRedstoneCookingTime");
            int Time = plugin.getConfig().getInt("BlastedRedstoneCookingXP");
            ItemStack result = new ItemStack(Material.REDSTONE_BLOCK);
            FurnaceRecipe recipe = new FurnaceRecipe(result, Material.REDSTONE_ORE);
            recipe.setExperience(XP);
            recipe.setCookingTime(Time);
            plugin.getServer().addRecipe(recipe);
        }
    }
}