package me.ialext.dlux.autopickup.loader;

import me.ialext.dlux.autopickup.listener.BlockBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import team.unnamed.gui.MenuListeners;
import team.unnamed.inject.Inject;

public class ListenerLoader implements Loadable {

    @Inject
    private Plugin plugin;

    @Inject
    private BlockBreakListener blockBreakListener;


    @Inject
    private MenuListeners menuListeners;

    @Override
    public void load() {
        registerListeners(
                blockBreakListener,
                menuListeners
        );
    }

    private void registerListeners(Listener... listeners) {
        for(Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
