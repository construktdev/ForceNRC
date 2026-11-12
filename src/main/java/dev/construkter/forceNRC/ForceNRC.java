package dev.construkter.forceNRC;

import dev.construkter.forceNRC.commands.AnvilCommand;
import dev.construkter.forceNRC.commands.EcCommand;
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
