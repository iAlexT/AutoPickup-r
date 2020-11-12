package me.ialext.dlux.autopickup.menu;

import static me.ialext.dlux.autopickup.util.ColorUtil.*;

import me.ialext.dlux.autopickup.SimpleCache;
import me.ialext.dlux.autopickup.factory.ItemFactory;
import me.ialext.dlux.autopickup.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import team.unnamed.gui.item.DefaultItemClickable;
import team.unnamed.gui.item.type.ItemBuilder;
import team.unnamed.gui.menu.MenuBuilder;
import team.unnamed.inject.Inject;
import team.unnamed.inject.name.Named;

import java.util.Arrays;
import java.util.UUID;

public class AutoPickupMenu implements BuildableMenu {

    @Inject
    @Named("auto-pickup")
    private SimpleCache<UUID> autoPickupCache;

    @Override
    public MenuBuilder build(Player player) {

        return MenuBuilder.newBuilder(colorize("&9AutoPickup"), 3)
                .addItem(
                        new DefaultItemClickable(
                                3,
                                ItemFactory.getEnableButton(),
                                inventoryClickEvent -> {
                                    autoPickupCache.add(player.getUniqueId());
                                    player.sendMessage(colorize("&9AutoPickup &aenabled"));

                                    return true;
                                }
                        )
                ).openEvent(event -> {
                    player.sendMessage(ColorUtil.colorize("&cFreddie es gay"));

                    return true;
                }).closeEvent(event -> {
                    player.sendMessage(ColorUtil.colorize("&cFreddie es gay"));

                });

    }
}
