package com.cosmictest.jonahenchantsplugin.Enchants.Potion;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Springs {

    public static void enableEffects(Player player, int effectLevel) {
        int duration = 20 * 60 * 5; // 5 minutes (20 ticks per second * 60 seconds per minute * 5 minutes)
        switch (effectLevel) {
            case 1:
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, duration, 0, true, false));
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, duration, 1, true, false));
                break;
            case 3:
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, duration, 2, true, false));
                break;
            default:
                removeEffects(player);
        }
    }

    public static void removeEffects(Player player) {
        player.removePotionEffect(PotionEffectType.JUMP);
    }
}