package dev.construkter.forceNRC;

import dev.construkter.forceNRC.commands.*;
import dev.construkter.forceNRC.listeners.JoinListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceNRC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        addCommand("ec", new EcCommand());
        addCommand("anvil", new AnvilCommand());
        addCommand("nrc", new NRCCommand());
        addCommand("me", new MeCommand());
        addCommand("craft", new CraftCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void addCommand(String command, CommandExecutor executor) {
        if (getPlugin(ForceNRC.class).getCommand(command) != null) {
            PluginCommand pluginCommand = getPlugin(ForceNRC.class).getCommand(command);
            if (pluginCommand != null) {
                pluginCommand.setExecutor(executor);
            }
        }
    }
}
