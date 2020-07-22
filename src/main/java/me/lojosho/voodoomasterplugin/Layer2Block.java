package me.lojosho.voodoomasterplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Layer2Block {
    private final Main plugin;
    public Layer2Block(Main plugin) {
        this.plugin = plugin;
    }
    public void getSnowBlockRecipe() {
        if (plugin.getConfig().getBoolean("SnowLayersToBlocks")) {
            ItemStack SnowBlock = new ItemStack(Material.SNOW_BLOCK);

            NamespacedKey key = new NamespacedKey(plugin, "SNOW_BLOCK1");
            ShapedRecipe recipe = new ShapedRecipe(key, SnowBlock);

            recipe.shape("AAA", "A A", "AAA");
            recipe.setIngredient('A', Material.SNOW);
            Bukkit.addRecipe(recipe);
        }
    }
}
