package io.github.heyrmi.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager() {
    }

    public static Configs configs() {
        return ConfigCache.getOrCreate(Configs.class);
    }
}
