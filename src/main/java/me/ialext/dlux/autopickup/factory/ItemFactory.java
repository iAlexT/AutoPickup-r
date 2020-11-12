package me.ialext.dlux.autopickup.factory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import team.unnamed.gui.item.type.ItemBuilder;

import java.util.Arrays;

import static me.ialext.dlux.autopickup.util.ColorUtil.colorize;
import static me.ialext.dlux.autopickup.util.ColorUtil.colorizeList;

public interface ItemFactory {

    static ItemStack getEnableButton() {
        return ItemBuilder.newBuilder(
                Material.EMERALD,
                1
        )
                .name(colorize("&aEnable"))
                .lore(colorizeList(Arrays.asList("&9- &aClick here to enable &9AutoPickup&a!",
                        "&9-", "&9- &bDlux")))
                .build();
    }
}
