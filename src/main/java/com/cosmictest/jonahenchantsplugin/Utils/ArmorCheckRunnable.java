package com.cosmictest.jonahenchantsplugin.Utils;

import com.cosmictest.jonahenchantsplugin.JonahEnchantsPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ArmorCheckRunnable extends BukkitRunnable {

    private HashMap<Player, HashMap<String, Integer>> activeEffects = new HashMap<>();

    @Override
    public void run() {
        for (Player player : JonahEnchantsPlugin.getInstance().getServer().getOnlinePlayers()) {
            HashMap<String, Integer> effectsMap = new HashMap<>();

            for (ItemStack armor : player.getInventory().getArmorContents()) {
                if (armor == null || !armor.hasItemMeta() || !armor.getItemMeta().hasLore()) {
                    continue;
                }

                // Parse the lore and check for effects
                for (String lore : armor.getItemMeta().getLore()) {
                    String[] parts = lore.split(" ");
                    if (parts.length >= 2) {
                        String effectName = parts[0];
                        try {
                            int effectLevel = Integer.parseInt(parts[1]);
                            effectsMap.put(effectName, effectLevel);
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }
            }

            activeEffects.put(player, effectsMap);
        }
    }

    public HashMap<Player, HashMap<String, Integer>> getActiveEffects() {
        return activeEffects;
    }
}