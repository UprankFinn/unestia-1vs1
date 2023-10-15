package net.unestia.onevsone.listener.block;

import net.unestia.api.game.GameState;
import net.unestia.onevsone.OneVsOne;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * @author: Uprank
 * @date: 24.01.2021
 */

public class BlockBreakListener implements Listener {

    private final OneVsOne oneVsOne;

    public BlockBreakListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY || this.oneVsOne.getUnestiaAPI().getGameState() == GameState.ENDING) {
            event.setCancelled(true);
        } else {
            if (this.oneVsOne.getLocations().contains(event.getBlock().getLocation())) {
                event.setCancelled(false);
                this.oneVsOne.getLocations().remove(event.getBlock().getLocation());
            } else {
                event.setCancelled(true);
            }
        }
    }

}
