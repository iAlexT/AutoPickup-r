package me.ialext.dlux.autopickup.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import me.ialext.dlux.autopickup.SimpleCache;
import me.ialext.dlux.autopickup.util.ColorUtil;
import org.bukkit.entity.Player;
import team.unnamed.inject.Inject;
import team.unnamed.inject.name.Named;

import java.util.UUID;

@Command(names = {"ap", "autopickup"}, permission = "dlux.autopickup")
public class AutoPickupCommand implements CommandClass {

    @Inject
    @Named("auto-pickup")
    private SimpleCache<UUID> autoPickupCache;

    @Command(names = "")
    public boolean mainCommand(@Sender Player sender) {
        if(!autoPickupCache.exists(sender.getUniqueId())) {
            autoPickupCache.add(sender.getUniqueId());
            sender.sendMessage(ColorUtil.colorize("&9AutoPickup &aenabled!"));

            return true;
        }

        autoPickupCache.remove(sender.getUniqueId());
        sender.sendMessage(ColorUtil.colorize("&9AutoPickup &cdisabled"));

        return true;
    }
}
