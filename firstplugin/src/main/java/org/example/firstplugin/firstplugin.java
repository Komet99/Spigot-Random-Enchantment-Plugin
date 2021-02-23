package org.example.firstplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Collection;
import java.util.Random;
import java.util.logging.Logger;

import static org.bukkit.enchantments.Enchantment.*;

public class firstplugin extends JavaPlugin {

    CommandStart c = new CommandStart(this);

    @Override
    public void onEnable() {

        Random rnd = new Random();

        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new MyListener(), this);
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
