package net.unestia.onevsone.listener.player;

import net.unestia.onevsone.OneVsOne;
import net.unestia.onevsone.game.kit.type.DefaultKit;
import net.unestia.onevsone.utils.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author: Uprank
 * @date: 21.01.2021
 */

public class PlayerRespawnListener implements Listener {

    private final OneVsOne oneVsOne;

    public PlayerRespawnListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {

        Bukkit.getOnlinePlayers().forEach(players -> {
            players.getInventory().setContents(new DefaultKit().getContent().getContents());
            players.getInventory().setArmorContents(new DefaultKit().getArmorContent());
            players.setHealth(20);
            players.setFoodLevel(20);
            players.getInventory().setItemInOffHand(new ItemBuilder(Material.SHIELD, 1, (byte) 0).setUnbreakable().build());


            event.getPlayer().getInventory().setContents(new DefaultKit().getContent().getContents());
            event.getPlayer().getInventory().setArmorContents(new DefaultKit().getArmorContent());
            event.getPlayer().setHealth(20);
            event.getPlayer().setFoodLevel(20);
            event.getPlayer().getInventory().setItemInOffHand(new ItemBuilder(Material.SHIELD, 1, (byte) 0).setUnbreakable().build());

        });

    }

}
