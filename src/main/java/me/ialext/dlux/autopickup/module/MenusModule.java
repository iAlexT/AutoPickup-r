package me.ialext.dlux.autopickup.module;

import me.ialext.dlux.autopickup.menu.AutoPickupMenu;
import me.ialext.dlux.autopickup.menu.BuildableMenu;
import team.unnamed.inject.bind.AbstractModule;

public class MenusModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BuildableMenu.class).named("auto-pickup-menu").to(AutoPickupMenu.class).singleton();
    }
}
