package me.ialext.dlux.autopickup.listener;

import me.ialext.dlux.autopickup.SimpleCache;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import team.unnamed.inject.Inject;
import team.unnamed.inject.name.Named;

import java.util.Collection;
import java.util.UUID;

public class BlockBreakListener implements Listener {

    @Inject
    @Named("auto-pickup")
    private SimpleCache<UUID> autoPickupCache;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        Collection<? extends ItemStack> items = event.getBlock().getDrops();

        if(player.getGameMode() != GameMode.SURVIVAL) return;

        if(autoPickupCache.exists(player.getUniqueId())) {
            event.getBlock().setType(Material.AIR);
            items.forEach(itemStack -> player.getInventory().addItem(itemStack));
        }
    }
}
