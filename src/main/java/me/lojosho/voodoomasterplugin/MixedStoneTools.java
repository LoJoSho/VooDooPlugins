/*package me.lojosho.voodoomasterplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

class MixedStonesTools extends JavaPlugin {
    private final Main plugin;

    public MixedStonesTools(Main plugin, ArrayList<Material> stone) {
        this.plugin = plugin;
    }

    public void getMixedRecipe() {
        if (plugin.getConfig().getBoolean("MixedStoneTools")) {
            List<String> list=new ArrayList<Stones>();
            list.add("STONE");
            list.add("ANDESITE");
            list.add("DIORITE");
            list.add("GRANITE");
            list.add("COBBLESTONE");

                // Stone Pickaxe
                ItemStack StonePickaxe = new ItemStack(Material.STONE_PICKAXE);

                NamespacedKey keySP = new NamespacedKey(plugin, "MixedPickaxe");
                ShapedRecipe recipeSP = new ShapedRecipe(keySP, StonePickaxe);

                recipeSP.shape("AAA", " I ", " I ");
                recipeSP.setIngredient('A', (RecipeChoice) Stones);
                recipeSP.setIngredient('I', Material.STICK);
                Bukkit.addRecipe(recipeSP);
            // Stone Sword
            ItemStack StoneSword = new ItemStack(Material.STONE_SWORD);

            NamespacedKey keySS = new NamespacedKey(plugin, "MixedSword");
            ShapedRecipe recipeSS = new ShapedRecipe(keySS, StoneSword);

            recipeSS.shape(" A ", " A ", " I ");
            recipeSS.setIngredient('A', (RecipeChoice) Stone);
            recipeSS.setIngredient('I', Material.STICK);
            Bukkit.addRecipe(recipeSS);
// Stone Hoe
            ItemStack StoneHoe = new ItemStack(Material.STONE_HOE);

            NamespacedKey keySH = new NamespacedKey(plugin, "MixedSword");
            ShapedRecipe recipeSH = new ShapedRecipe(keySH, StoneHoe);

            recipeSH.shape("AA ", " I ", " I ");
            recipeSH.setIngredient('A', (RecipeChoice) Stone);
            recipeSH.setIngredient('I', Material.STICK);
            Bukkit.addRecipe(recipeSH);
// Stone Axe
            ItemStack StoneAXE = new ItemStack(Material.STONE_AXE);

            NamespacedKey keySA = new NamespacedKey(plugin, "MixedSword");
            ShapedRecipe recipeSA = new ShapedRecipe(keySA, StoneAXE);

            recipeSA.shape(" AA", " IA", " I ");
            recipeSA.setIngredient('A', (RecipeChoice) Stone);
            recipeSA.setIngredient('I', Material.STICK);
            Bukkit.addRecipe(recipeSA);
// Stone Shovel
            ItemStack StoneShovel = new ItemStack(Material.STONE_AXE);

            NamespacedKey keySSH = new NamespacedKey(plugin, "MixedSword");
            ShapedRecipe recipeSSH = new ShapedRecipe(keySSH, StoneShovel);

            recipeSSH.shape(" A", " I", " I ");
            recipeSSH.setIngredient('A', (RecipeChoice) Stone);
            recipeSSH.setIngredient('I', Material.STICK);
            Bukkit.addRecipe(recipeSSH);
        }
    }
}
 */