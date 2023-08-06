package com.cosmictest.jonahenchantsplugin.Enchants.Potion;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Gears {

    public static void enableEffects(Player player, int effectLevel) {
        switch (effectLevel) {
            case 1:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
                break;
            case 3:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2, true, false));
                break;
            default:
                removeEffects(player);
        }
    }

    public static void removeEffects(Player player) {
        player.removePotionEffect(PotionEffectType.SPEED);
    }
}