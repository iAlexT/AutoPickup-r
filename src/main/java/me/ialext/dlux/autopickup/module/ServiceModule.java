package me.ialext.dlux.autopickup.module;

import me.ialext.dlux.autopickup.service.AutoPickupService;
import me.ialext.dlux.autopickup.service.Service;
import team.unnamed.inject.bind.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Service.class).named("auto-pickup-service").to(AutoPickupService.class)
                .singleton();
    }
}
