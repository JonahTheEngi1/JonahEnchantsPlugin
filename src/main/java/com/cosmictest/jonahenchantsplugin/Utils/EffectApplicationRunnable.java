package com.cosmictest.jonahenchantsplugin.Utils;

import com.cosmictest.jonahenchantsplugin.Enchants.Potion.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EffectApplicationRunnable extends BukkitRunnable {

    private HashMap<Player, HashMap<String, Integer>> activeEffects;
    private HashMap<Player, Set<String>> playerActiveEffects = new HashMap<>();

    public EffectApplicationRunnable(HashMap<Player, HashMap<String, Integer>> activeEffects) {
        this.activeEffects = activeEffects;
    }

    @Override
    public void run() {
        for (Map.Entry<Player, HashMap<String, Integer>> entry : activeEffects.entrySet()) {
            Player player = entry.getKey();
            HashMap<String, Integer> effectsMap = entry.getValue();

            applyEffects(player, effectsMap);
        }
    }

    private void applyEffects(Player player, HashMap<String, Integer> effectsMap) {
        Set<String> currentActiveEffects = playerActiveEffects.getOrDefault(player, new HashSet<>());

        // Overload effect
        if (effectsMap.containsKey("Overload")) {
            int overloadLevel = effectsMap.get("Overload");
            applyEffect(player, "Overload", overloadLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Overload", currentActiveEffects);
        }

        // Gears effect
        if (effectsMap.containsKey("Gears")) {
            int gearsLevel = effectsMap.get("Gears");
            applyEffect(player, "Gears", gearsLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Gears", currentActiveEffects);
        }
        // ObsidianShield
        if (effectsMap.containsKey("Obsidianshield")) {
            int obsidianshieldLevel = effectsMap.get("Obsidianshield");
            applyEffect(player, "Obsidianshield", obsidianshieldLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Obsidianshield", currentActiveEffects);
        }
        // AntiGravity
        if (effectsMap.containsKey("Antigravity")) {
            int antigravityLevel = effectsMap.get("Antigravity");
            applyEffect(player, "Antigravity", antigravityLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Antigravity", currentActiveEffects);
        }
        // Springs
        if (effectsMap.containsKey("Springs")) {
            int springsLevel = effectsMap.get("Springs");
            applyEffect(player, "Springs", springsLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Springs", currentActiveEffects);
        }
        // Drunk
        if (effectsMap.containsKey("Drunk")) {
            int drunkLevel = effectsMap.get("Drunk");
            applyEffect(player, "Drunk", drunkLevel, currentActiveEffects);
        } else {
            removeEffect(player, "Drunk", currentActiveEffects);
        }

        playerActiveEffects.put(player, currentActiveEffects);
        System.out.println("Applied effects for " + player.getName() + ": " + effectsMap);
    }

    private void applyEffect(Player player, String effectName, int effectLevel, Set<String> currentActiveEffects) {
        String identifier = effectName + ":" + effectLevel;
        if (!currentActiveEffects.contains(identifier)) {
            switch (effectName) {
                case "Overload":
                    Overload.enableEffects(player, effectLevel);
                    break;
                case "Gears":
                    Gears.enableEffects(player, effectLevel);
                    break;
                case "Obsidianshield":
                    ObsidianShield.enableEffects(player, effectLevel);
                    break;
                case "Antigravity":
                    AntiGravity.enableEffects(player, effectLevel);
                    break;
                case "Springs":
                    Springs.enableEffects(player, effectLevel);
                    break;
                case "Drunk":
                    Drunk.enableEffects(player, effectLevel);
                    break;
                // Add other effects here
                default:
                    break;
            }
            currentActiveEffects.add(identifier);
        }
    }

    private void removeEffect(Player player, String effectName, Set<String> currentActiveEffects) {
        currentActiveEffects.removeIf(effect -> effect.startsWith(effectName + ":"));
        if (currentActiveEffects.isEmpty()) {
            switch (effectName) {
                case "Overload":
                    Overload.removeEffects(player);
                    break;
                case "Gears":
                    Gears.removeEffects(player);
                    break;
                case "Obsidianshield":
                    ObsidianShield.removeEffects(player);
                    break;
                case "Antigravity":
                    AntiGravity.removeEffects(player);
                    break;
                case "Springs":
                    Springs.removeEffects(player);
                    break;
                case "Drunk":
                    Drunk.removeEffects(player);
                    break;
                // Add other effects here
                default:
                    break;
            }
        }
    }
}