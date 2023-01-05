package me.illuminatiproductions.illuminatifly;

import me.illuminatiproductions.illuminatifly.commands.Fly;
import org.bukkit.plugin.java.JavaPlugin;

public final class ToxicFly extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic <dont delete it >
        System.out.println("[ToxicFly] Plugin now online.");

        //Register command < dont edit it if you dont know what do you do >
        getCommand("fly").setExecutor(new Fly(this));

        //Config < dont edit it if you dont know what do you do >
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
