package me.lojosho.voodoomasterplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class BotanicalReplication implements Listener {
    private final Main plugin;
    public BotanicalReplication(Main plugin) {
        this.plugin = plugin;
    }

    public void BotanicalReplicationRecipes() {
        if (plugin.getConfig().getBoolean("Botancial_Replication_Recipes")) {
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "Lillypads"), new ItemStack(Material.LILY_PAD, 3)).addIngredient(Material.LILY_PAD).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Allium"), new ItemStack(Material.ALLIUM, 3)).addIngredient(Material.ALLIUM).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Azure"), new ItemStack(Material.BLUE_ORCHID, 3)).addIngredient(Material.BLUE_ORCHID).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Blue"), new ItemStack(Material.CORNFLOWER, 3)).addIngredient(Material.CORNFLOWER).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Corn"), new ItemStack(Material.DANDELION, 3)).addIngredient(Material.DANDELION).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Dan"), new ItemStack(Material.LILY_OF_THE_VALLEY, 3)).addIngredient(Material.LILY_OF_THE_VALLEY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Lily"), new ItemStack(Material.ORANGE_TULIP, 3)).addIngredient(Material.ORANGE_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3Orange"), new ItemStack(Material.OXEYE_DAISY, 3)).addIngredient(Material.OXEYE_DAISY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3oxeye"), new ItemStack(Material.PINK_TULIP, 3)).addIngredient(Material.PINK_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3pink"), new ItemStack(Material.POPPY, 3)).addIngredient(Material.POPPY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3poppy"), new ItemStack(Material.RED_TULIP, 3)).addIngredient(Material.RED_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(plugin, "3red"), new ItemStack(Material.WHITE_TULIP, 3)).addIngredient(Material.WHITE_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
        }
    }
}
