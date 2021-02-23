package org.example.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.jetbrains.annotations.Nullable;

import static org.bukkit.Bukkit.getServer;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        getServer().broadcastMessage("Deine Mutter " + event.getPlayer().getDisplayName() + "!");
    }
}
