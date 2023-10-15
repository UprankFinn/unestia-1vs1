package net.unestia.onevsone.listener.player;

import net.unestia.onevsone.OneVsOne;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author: Uprank
 * @date: 19.01.2021
 */

public class PlayerInteractListener implements Listener {

    private final OneVsOne oneVsOne;

    public PlayerInteractListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (!(event.getItem().hasItemMeta())) return;
        if (event.getItem().getItemMeta().getDisplayName() == null) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;

        event.setCancelled(true);
    }

}
