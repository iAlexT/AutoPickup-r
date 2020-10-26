package me.ialext.dlux.autopickup.service;

import me.ialext.dlux.autopickup.loader.CommandLoader;
import me.ialext.dlux.autopickup.loader.ListenerLoader;
import team.unnamed.inject.Inject;

public class AutoPickupService implements Service {

    @Inject
    private CommandLoader commandLoader;

    @Inject
    private ListenerLoader listenerLoader;

    @Override
    public void setup() {
        commandLoader.load();
        listenerLoader.load();
    }

    @Override
    public void shutdown() {

    }
}
