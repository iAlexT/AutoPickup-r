package me.ialext.dlux.autopickup.module;

import me.ialext.dlux.autopickup.AutoPickup;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.bind.AbstractModule;

public class MainModule extends AbstractModule {

    private final AutoPickup plugin;

    public MainModule(AutoPickup plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(AutoPickup.class).toInstance(plugin);
        bind(Plugin.class).to(AutoPickup.class).singleton();

        install(new CacheModule());
        install(new ServiceModule());
        install(new MenusModule());
    }
}
