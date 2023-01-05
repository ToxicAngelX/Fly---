package me.illuminatiproductions.illuminatifly;

import me.illuminatiproductions.illuminatifly.commands.Fly;
import org.bukkit.plugin.java.JavaPlugin;

public final class IlluminatiFly extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[IlluminatiFly] Plugin now online.");

        //Register command
        getCommand("fly").setExecutor(new Fly(this));

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}