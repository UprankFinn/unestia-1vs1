package net.unestia.onevsone.listener.player;

import net.unestia.api.UnestiaAPI;
import net.unestia.api.game.GameState;
import net.unestia.onevsone.OneVsOne;
import net.unestia.onevsone.game.kit.type.DefaultKit;
import net.unestia.onevsone.utils.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author: Uprank
 * @date: 19.01.2021
 */

public class PlayerJoinListener implements Listener {

    private final OneVsOne oneVsOne;

    public PlayerJoinListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setHealth(20);

        this.oneVsOne.getKitManager().getDefaultKit().getPlayerList().add(event.getPlayer());

        this.oneVsOne.getKillManager().getKills().put(event.getPlayer(), 0);
        this.oneVsOne.getKillManager().getDeaths().put(event.getPlayer(), 0);

        if (this.oneVsOne.getKitManager().getDefaultKit().getPlayerList().contains(event.getPlayer())) {
            event.getPlayer().getInventory().setContents(new DefaultKit().getContent().getContents());
            event.getPlayer().getInventory().setArmorContents(new DefaultKit().getArmorContent());
            event.getPlayer().getInventory().setItemInOffHand(new ItemBuilder(Material.SHIELD, 1, (byte) 0).setUnbreakable().build());
        }
        Bukkit.getOnlinePlayers().forEach(players -> {
            this.oneVsOne.getTabList().setPlayerTabList(players, "\n§b§lUnestia §7§lNetwork\n", "\n§7Website §8» §bunestia.net\n§7Store §8» §bstore.unestia.net\n§7TeamSpeak §8» §bts.unestia.net\n");
        });
        if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY) {
            this.oneVsOne.getStartCountdown().checkCountdown(Bukkit.getOnlinePlayers().size());
        }

        Bukkit.getOnlinePlayers().forEach(players -> {
            this.oneVsOne.getScoreboard().setScoreboard(players);
        });

    }

}
