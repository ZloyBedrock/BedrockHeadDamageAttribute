package ru.bedrockdev.bedrockheaddamageattribute;

import org.bukkit.plugin.java.JavaPlugin;

public final class BedrockHeadDamageAttribute extends JavaPlugin {

    private static BedrockHeadDamageAttribute instance;

    @Override
    public void onEnable() {

        instance = this;
        instance.saveDefaultConfig();
        instance.getConfig().options().copyDefaults(true);
        getServer().getPluginManager().registerEvents(new Listener(), this);

    }

    public static BedrockHeadDamageAttribute getInstance() {
        return instance;
    }

}
