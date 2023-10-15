package net.unestia.onevsone.listener.player;

import net.unestia.api.game.GameState;
import net.unestia.onevsone.OneVsOne;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author: Uprank
 * @date: 19.01.2021
 */

public class PlayerQuitListener implements Listener {

    private final OneVsOne oneVsOne;

    public PlayerQuitListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        if (this.oneVsOne.getKillManager().getKills().containsKey(event.getPlayer()) && this.oneVsOne.getKillManager().getDeaths().containsKey(event.getPlayer())) {
            this.oneVsOne.getKillManager().getKills().remove(event.getPlayer());
            this.oneVsOne.getKillManager().getDeaths().remove(event.getPlayer());
        }
        if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY) {
            this.oneVsOne.getStartCountdown().checkCountdown(Bukkit.getOnlinePlayers().size() - 1);
        }
    }

}
