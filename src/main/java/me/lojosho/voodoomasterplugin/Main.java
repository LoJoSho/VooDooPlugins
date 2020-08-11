package me.lojosho.voodoomasterplugin;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin { //Extending JavaPlugin so that Bukkit knows its the main class...

    public void onEnable() {
        this.saveDefaultConfig();
        registerEvents(this, new BatMembranes(this), new CutClean(this));
        Layer2Block L2BObject = new Layer2Block(this);
        L2BObject.getSnowBlockRecipe();
        ZombieLeather ZL = new ZombieLeather(this);
        ZL.furnaceFurnace();
        BlastedRedstone BL = new BlastedRedstone(this);
        BL.furnaceFurnace();
        BotanicalReplication BR = new BotanicalReplication(this);
        BR.BotanicalReplicationRecipes();
        // not working, fix stone tools
//        MixedStonesTools MST = new MixedStonesTools(this);
//        MST.MixedStonesTools();
        bStats();

//This is where we register our events/commands
    }

    public void onDisable() {

    }

    //Much eaisier then registering events in 10 diffirent methods
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
//    To access the plugin variable from other classes
//    public Plugin getPlugin() {
//        return plugin;
//    }

    public void bStats(){
        if (this.getConfig().getBoolean("bstats")) {
            int pluginId = 8281; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);
        }
    }
}

