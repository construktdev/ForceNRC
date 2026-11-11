package dev.construkter.forceNRC.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NRCCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        var message = MiniMessage.miniMessage();

        String text = "<dark_gray>[</dark_gray><#00AAAA>Glitzorium</#00AAAA><#FFAA00>X</#FFAA00><dark_gray>]</dark_gray><#FF5555>Unsere Systeme haben erkannt dass du nicht den Norisk Client benutzt.\n</#FF5555>" +
                "<#FF5555>Dieser Server ist für diesen optimiert und bietet damit das beste Spielerlebnis.\n</#FF5555>" +
                "<gray>Du kannst ihn <click:open_url:'https://norisk.gg'>" +
                "<hover:show_text:'<yellow>Lade Norisk Client herunter</yellow>'>" +
                "<green><bold>[HIER]</bold></green>" +
                " herunterladen.";

        player.sendMessage(message.deserialize(text));

        return true;
    }
}
