package dev.construkter.forceNRC.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        if (player.getClientBrandName() == null || !player.getClientBrandName().startsWith("nrc")) {
            Component msg = Component.text("Du nutzt kein Norisk Client. Nutze /nrc um eine Anleitung zu erhalten.", NamedTextColor.RED);
            player.sendMessage(msg);
        } else {
            Component msg = Component.text("Du nutzt bereits den Norisk Client. Viel Spaß!", NamedTextColor.GREEN);
            player.sendMessage(msg);
        }
        return true;
    }
}
