package me.ialext.dlux.autopickup;

import me.ialext.dlux.autopickup.module.MainModule;
import me.ialext.dlux.autopickup.service.AutoPickupService;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Inject;
import team.unnamed.inject.Injector;
import team.unnamed.inject.InjectorFactory;
import team.unnamed.inject.name.Named;

public final class AutoPickup extends JavaPlugin {

    @Inject
    @Named("auto-pickup-service")
    private AutoPickupService service;

    @Override
    public void onEnable() {
        Injector injector = InjectorFactory.create(new MainModule(this));
        injector.injectMembers(this);

        service.setup();
    }

    @Override
    public void onDisable() {
        service.shutdown();
    }
}
