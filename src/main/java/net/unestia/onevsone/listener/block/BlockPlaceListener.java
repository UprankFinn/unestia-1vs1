package net.unestia.onevsone.listener.block;

import net.unestia.api.game.GameState;
import net.unestia.onevsone.OneVsOne;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * @author: Uprank
 * @date: 24.01.2021
 */

public class BlockPlaceListener implements Listener {

    private final OneVsOne oneVsOne;

    public BlockPlaceListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY) {
            event.setCancelled(true);
        } else if (event.getBlock().getType() == Material.COBBLESTONE || event.getBlock().getType() == Material.WATER || event.getBlock().getType() == Material.LAVA) {
            event.setCancelled(false);
            this.oneVsOne.getLocations().add(event.getBlock().getLocation());
        }
    }

}
