package com.cosmictest.jonahenchantsplugin;

import com.cosmictest.jonahenchantsplugin.Utils.ArmorCheckRunnable;
import com.cosmictest.jonahenchantsplugin.Utils.EffectApplicationRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public class JonahEnchantsPlugin extends JavaPlugin {

    private static JonahEnchantsPlugin instance;
    private ArmorCheckRunnable armorCheckRunnable;
    private EffectApplicationRunnable effectApplicationRunnable;

    @Override
    public void onEnable() {
        instance = this;
        startRunnables();
    }

    @Override
    public void onDisable() {
        instance = null;
        if (armorCheckRunnable != null) {
            armorCheckRunnable.cancel();
        }
        if (effectApplicationRunnable != null) {
            effectApplicationRunnable.cancel();
        }
    }

    public static JonahEnchantsPlugin getInstance() {
        return instance;
    }

    private void startRunnables() {
        armorCheckRunnable = new ArmorCheckRunnable();
        armorCheckRunnable.runTaskTimer(this, 20, 20); // Run every 20 ticks (1 second) (probably going to be changed to a longer duration)

        effectApplicationRunnable = new EffectApplicationRunnable(armorCheckRunnable.getActiveEffects());
        effectApplicationRunnable.runTaskTimer(this, 20, 20); // Run every 20 ticks (1 second)
    }
}