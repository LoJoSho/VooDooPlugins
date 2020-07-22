package me.lojosho.voodoomasterplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class VooDooMasterPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        BotanicalReplicationRecipes();
        furnaceFurnace();
        getRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onAnimalDeath(EntityDeathEvent event) {
        if (this.getConfig().getBoolean("CutClean")) {
        Entity entity = event.getEntity();
        if (entity.getType() == EntityType.PIG) {
            if (this.getConfig().getBoolean("FromPigs")) {
                int upper = this.getConfig().getInt("pigmax");
                int lower = this.getConfig().getInt("pigmin");
                int XPPigMax = this.getConfig().getInt("pigXPmax");
                int XPPigMin = this.getConfig().getInt("pigXPmin");
                int RandomPig = (int) (Math.random() * (upper - lower + 1)) + lower;
                int RandomPigXP = (int) (Math.random() * (XPPigMax - XPPigMin + 1)) + XPPigMin;
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_PORKCHOP, RandomPig));
                event.setDroppedExp(RandomPigXP);
            }
        }
        if (entity.getType() == EntityType.COW) {
            if (this.getConfig().getBoolean("FromCows")) {
                int upper = this.getConfig().getInt("Cowsmax");
                int lower = this.getConfig().getInt("Cowsmin");
                int XPCowMax = this.getConfig().getInt("CowsXPmax");
                int XPCowMin = this.getConfig().getInt("CowsXPmin");
                int RandomCow = (int) (Math.random() * (upper - lower + 1)) + lower;
                int RandomCowXP = (int) (Math.random() * (XPCowMax - XPCowMin + 1)) + XPCowMin;
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_BEEF, RandomCow));
                event.setDroppedExp(RandomCowXP);
            }
        }
        if (entity.getType() == EntityType.CHICKEN) {
            if (this.getConfig().getBoolean("FromChicken")) {
                int upper = this.getConfig().getInt("Chickenmax");
                int lower = this.getConfig().getInt("Chickenmin");
                int XPMax = this.getConfig().getInt("ChickenXPmax");
                int XPMin = this.getConfig().getInt("ChickenXPmin");
                int RandomAmountDropped = (int) (Math.random() * (upper - lower + 1)) + lower;
                int RandomXP = (int) (Math.random() * (XPMax - XPMin + 1)) + XPMin;
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, RandomAmountDropped));
                event.setDroppedExp(RandomXP);
            }
        }
        if (entity.getType() == EntityType.SHEEP) {
            if (this.getConfig().getBoolean("FromSheep")) {
                int upper = this.getConfig().getInt("Sheepmax");
                int lower = this.getConfig().getInt("Sheepmin");
                int XPMax = this.getConfig().getInt("SheepXPmax");
                int XPMin = this.getConfig().getInt("SheepXPmin");
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
        if (this.getConfig().getBoolean("SmeltedOres")) {
            if (this.getConfig().getBoolean("SmeltedIron")) {
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
        if (this.getConfig().getBoolean("SmeltedOres")) {
            if (this.getConfig().getBoolean("SmeltedGold")) {
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
        if (this.getConfig().getBoolean("GravelAlwaysFlint")) {
        if(event.getBlock().getType() == Material.GRAVEL) {
            Block b = event.getBlock();
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.FLINT, 1));
            event.setCancelled(true);
        }
        }
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
    public void BotanicalReplicationRecipes() {
        if (this.getConfig().getBoolean("Botancial_Replication_Recipes")) {
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "Lillypads"), new ItemStack(Material.LILY_PAD, 3)).addIngredient(Material.LILY_PAD).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Allium"), new ItemStack(Material.ALLIUM, 3)).addIngredient(Material.ALLIUM).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Azure"), new ItemStack(Material.BLUE_ORCHID, 3)).addIngredient(Material.BLUE_ORCHID).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Blue"), new ItemStack(Material.CORNFLOWER, 3)).addIngredient(Material.CORNFLOWER).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Corn"), new ItemStack(Material.DANDELION, 3)).addIngredient(Material.DANDELION).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Dan"), new ItemStack(Material.LILY_OF_THE_VALLEY, 3)).addIngredient(Material.LILY_OF_THE_VALLEY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Lily"), new ItemStack(Material.ORANGE_TULIP, 3)).addIngredient(Material.ORANGE_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3Orange"), new ItemStack(Material.OXEYE_DAISY, 3)).addIngredient(Material.OXEYE_DAISY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3oxeye"), new ItemStack(Material.PINK_TULIP, 3)).addIngredient(Material.PINK_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3pink"), new ItemStack(Material.POPPY, 3)).addIngredient(Material.POPPY).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3poppy"), new ItemStack(Material.RED_TULIP, 3)).addIngredient(Material.RED_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
            Bukkit.addRecipe(new ShapelessRecipe(new NamespacedKey(this, "3red"), new ItemStack(Material.WHITE_TULIP, 3)).addIngredient(Material.WHITE_TULIP).addIngredient(Material.BONE_MEAL).addIngredient(Material.ROTTEN_FLESH));
        }
    }
    private void furnaceFurnace() {
        if (this.getConfig().getBoolean("ZombieLeatherRecipe")) {
            int XP = this.getConfig().getInt("LeatherCookingXP");
            int Time = this.getConfig().getInt("LeatherCookingTime");
            ItemStack result = new ItemStack(Material.LEATHER);
            FurnaceRecipe recipe = new FurnaceRecipe(result, Material.ROTTEN_FLESH);
            recipe.setExperience(XP);
            recipe.setCookingTime(Time);
            getServer().addRecipe(recipe);
        }
    }
    public void getRecipe() {
        if (this.getConfig().getBoolean("SnowLayersToBlocks")) {
            ItemStack SnowBlock = new ItemStack(Material.SNOW_BLOCK);

            NamespacedKey key = new NamespacedKey(this, "SNOW_BLOCK1");
            ShapedRecipe recipe = new ShapedRecipe(key, SnowBlock);

            recipe.shape("AAA", "A A", "AAA");
            recipe.setIngredient('A', Material.SNOW);
            Bukkit.addRecipe(recipe);
        }
    }
}

