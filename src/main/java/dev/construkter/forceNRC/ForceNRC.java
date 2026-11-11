package dev.construkter.forceNRC;

import dev.construkter.forceNRC.commands.EcCommand;
import dev.construkter.forceNRC.listeners.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceNRC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        getCommand("ec").setExecutor(new EcCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
