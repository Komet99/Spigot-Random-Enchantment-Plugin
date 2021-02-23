package org.example.randomench;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Collection;
import java.util.Random;
import java.util.logging.Logger;

public class main extends JavaPlugin {

    CommandStart c = new CommandStart(this);

    @Override
    public void onEnable() {

        Random rnd = new Random();

        getLogger().info("onEnable is called!");
        this.getCommand("start").setExecutor(new CommandStart(this));

    }

    public void main() {

        getServer().broadcastMessage("Started function main");
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                Collection<Player> players = (Collection<Player>) getServer().getOnlinePlayers();

                for (Player p: players) {
                    getLogger().info("Found Player " + p.getName());
                    c.canPlayerReceive(p);
                }

            }
        }, 0L, 200L);

    }


    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }

    @Override
    public Logger getLogger() {
        return super.getLogger();
    }
}
