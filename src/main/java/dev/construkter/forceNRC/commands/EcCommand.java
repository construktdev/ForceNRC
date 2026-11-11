package dev.construkter.forceNRC.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        if (player.getClientBrandName() == null || !player.getClientBrandName().startsWith("nrc")) {
            Component msg = Component.text("Dieser Vefehl ist nur für Spieler mit Norisk Client verfügbar!", NamedTextColor.RED);

            player.sendMessage(msg);

            return true;
        }

        player.openInventory(player.getEnderChest());

        return true;
    }
}
