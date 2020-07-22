package me.lojosho.voodoomasterplugin;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin { //Extending JavaPlugin so that Bukkit knows its the main class...

    private static Plugin plugin;

    public void onEnable() {
        this.saveDefaultConfig();
        plugin = this;
//        new BatMembranes(this);
        registerEvents(this, new BatMembranes(this), new CutClean(this));
//        BatMembranes BM = new BatMembranes(this);
//        BM.BatDeathMembranes();
        Layer2Block L2BObject = new Layer2Block(this);
        L2BObject.getSnowBlockRecipe();
//        new Layer2Block(this);
        ZombieLeather ZL = new ZombieLeather(this);
        ZL.furnaceFurnace();
        BotanicalReplication BR = new BotanicalReplication(this);
        BR.BotanicalReplicationRecipes();
//        CutClean CC = new CutClean(this);
        if (this.getConfig().getBoolean("bstats") == true) {
            int pluginId = 8281; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);
        }

//This is where we register our events/commands
    }

    public void onDisable() {
        plugin = null;//To stop memory leeks

    }

    //Much eaisier then registering events in 10 diffirent methods
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
    //To access the plugin variable from other classes
//    public Plugin getPlugin() {
//        return plugin;
//    }
//}

