package org.example.randomench;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getServer;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        getServer().broadcastMessage("Deine Mutter " + event.getPlayer().getDisplayName() + "!");
    }
}
