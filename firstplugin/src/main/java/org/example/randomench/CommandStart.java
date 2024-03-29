package org.example.randomench;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommandStart implements CommandExecutor {

    main f;

    public CommandStart(main f) {
        this.f = f;
    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.getServer().broadcastMessage("Initializing Plugin...");

        sender.getServer().broadcastMessage("Calling main function loop...");

        f.main();
        return true;
    }

    public void canPlayerReceive(Player p) {

        if (!p.getInventory().isEmpty()) {
            generateItem(p);
        }
    }


    public void generateItem(Player player) {


        boolean gendone = false;

        char gentries = 0;

        Random rnd = new Random();

        List<Enchantment> enchantments = Arrays.asList(Enchantment.values());

        int invSlot = rnd.nextInt(27);

        ItemStack item = new ItemStack(Material.AIR, 1); // Don't know if that works

        try {
            item  = new ItemStack(player.getInventory().getItem(invSlot));
            gendone = true;
            player.getServer().getLogger().info("Generated item slot at 1st try");
        }
        catch (Exception x) {
            while (!gendone && gentries < 10) {
                try {
                    player.getInventory().getItem(invSlot);
                    gendone = true;
                    player.getServer().getLogger().info("Generated item slot");
                } catch (Exception e) {
                    gentries += 1;
                    invSlot = rnd.nextInt(27);
                    item = player.getInventory().getItem(invSlot);
                }
            }
        }



        if (gendone) {
            item.addUnsafeEnchantment(enchantments.get(rnd.nextInt(enchantments.size())), rnd.nextInt(31) + 1);
            player.getInventory().setItem(invSlot, item);
            player.sendMessage("Your " + player.getInventory().getItem(invSlot).getType().getKey().getNamespace() + " was enchanted!");
        }

    }
}
