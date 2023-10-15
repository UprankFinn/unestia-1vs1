package net.unestia.onevsone.listener.block;

import net.unestia.onevsone.OneVsOne;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;

/**
 * @author: Uprank
 * @date: 24.01.2021
 */

public class BlockCanBuildListener implements Listener {

    private final OneVsOne oneVsOne;


    public BlockCanBuildListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
        event.setBuildable(true);
    }

}
