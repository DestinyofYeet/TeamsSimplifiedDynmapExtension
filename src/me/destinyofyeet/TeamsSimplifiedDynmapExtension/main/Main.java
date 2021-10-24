package me.destinyofyeet.TeamsSimplifiedDynmapExtension.main;

import me.destinyofyeet.TeamsSimplifiedDynmapExtension.dynmapStuff.ThreadManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapAPI;

public class Main extends JavaPlugin {
    public static Main plugin;
    public static DynmapAPI dynmapAPI;
    public static Plugin teamsSimplified;

    private ThreadManager threadManager;

    @Override
    public void onEnable(){
        plugin = this;
        getLogger().info("Loading...");

        DynmapAPI dynmap = (DynmapAPI) Bukkit.getServer().getPluginManager().getPlugin("dynmap");

        Plugin teamsSimplified = Bukkit.getServer().getPluginManager().getPlugin("TeamsSimplified");

        if (dynmap == null){
            getLogger().severe("Dynmap was not found, disabling...!");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if (teamsSimplified == null){
            getLogger().severe("TeamsSimplified was not found, disabling...!");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info("Dynmap found: Version: " + dynmap.getDynmapVersion());
        getLogger().info("TeamsSimplified found");

        dynmapAPI = dynmap;
        Main.teamsSimplified = teamsSimplified;

        threadManager = new ThreadManager();


    }

    @Override
    public void onDisable(){
        getLogger().info("Stopping map-sync...");
        if (threadManager != null)
            threadManager.interrupt();
        getLogger().info("Done");
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static DynmapAPI getDynmapAPI() {
        return dynmapAPI;
    }

    public static Plugin getTeamsSimplified() {
        return teamsSimplified;
    }
}
