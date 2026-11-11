package dev.construkter.forceNRC.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;

public class JoinListener implements Listener {

    private final JavaPlugin plugin;

    public JoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getName().startsWith(".")) return;

        if (player.getClientBrandName() == null || !player.getClientBrandName().startsWith("nrc")) {
            Location loginLocation = player.getLocation();

            player.setInvulnerable(true);

            Component mainTitle = Component.text("STOPP", NamedTextColor.RED);
            Component subtitle = Component.text("Bitte lese die Nachricht im Chat!");

            Title.Times times = Title.Times.times(
                    Duration.ofMillis(0),
                    Duration.ofSeconds(10),
                    Duration.ofMillis(10)
            );

            Title title = Title.title(mainTitle, subtitle, times);

            player.showTitle(title);

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give " + player.getName() + " minecraft:darkness 10 255 true");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give " + player.getName() + "minecraft:instant_health 10 255 true");

            var message = MiniMessage.miniMessage();

            String text = "<dark_gray>[</dark_gray><#00AAAA>Glitzorium</#00AAAA><#FFAA00>X</#FFAA00><dark_gray>]</dark_gray><#FF5555>Unsere Systeme haben erkannt dass du nicht den Norisk Client benutzt.\n</#FF5555>" +
                    "<#FF5555>Dieser Server ist für diesen optimiert und bietet damit das beste Spielerlebnis.\n</#FF5555>" +
                    "<gray>Du kannst ihn <click:open_url:'https://norisk.gg'>" +
                    "<hover:show_text:'<yellow>Lade Norisk Client herunter</yellow>'>" +
                    "<green><bold>[HIER]</bold></green>" +
                    " herunterladen.";

            player.sendMessage(message.deserialize(text));

            new BukkitRunnable() {
                private int ticksElapsed = 0;
                private final int maxTicks = 200;

                @Override
                public void run() {
                    if (!player.isOnline() || ticksElapsed >= maxTicks) {
                        this.cancel();
                        player.setInvulnerable(false);
                        return;
                    }

                    player.teleport(loginLocation);

                    ticksElapsed++;
                }
            }.runTaskTimer(plugin, 0L, 1L);
        }
    }
}
