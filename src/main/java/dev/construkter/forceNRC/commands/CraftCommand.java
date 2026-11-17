package dev.construkter.forceNRC.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        if (player.getClientBrandName() == null || !player.getClientBrandName().startsWith("nrc")) {
            Component msg = Component.text("Dieser Befehl ist nur für Spieler mit Norisk Client verfügbar!", NamedTextColor.RED);

            player.sendMessage(msg);

            return true;
        }

        Inventory crafting = Bukkit.createInventory(null, InventoryType.WORKBENCH);
        player.openInventory(crafting);

        return true;
    }
}
