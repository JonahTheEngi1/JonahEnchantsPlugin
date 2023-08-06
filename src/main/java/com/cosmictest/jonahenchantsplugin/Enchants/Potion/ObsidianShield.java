package com.cosmictest.jonahenchantsplugin.Enchants.Potion;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ObsidianShield {

    public static void enableEffects(Player player, int effectLevel) {
        switch (effectLevel) {
            case 1:
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, true, false));
                break;
            default:
                removeEffects(player);
        }
    }

    public static void removeEffects(Player player) {
        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    }
}
