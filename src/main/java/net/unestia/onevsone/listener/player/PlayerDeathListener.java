           (package net.unestia.onevsone.listener.player;

import net.unestia.onevsone.OneVsOne;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


/**
 * @author: Uprank
 * @date: 20.01.2021
 */

public class PlayerDeathListener implements Listener {

    private final OneVsOne oneVsOne;

    public PlayerDeathListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        event.setKeepInventory(true);
        event.setDeathMessage(null);

        Player target = event.getEntity().getPlayer();
        Player killer = event.getEntity().getPlayer().getKiller();

        if (killer == null) {

            this.oneVsOne.getKillManager().getDeaths().put(target, (1));

        } else {
            if (this.oneVsOne.getKillManager().getKills().get(killer) == 0) {
                this.oneVsOne.getKillManager().getKills().put(killer, (1));
            } else {
                this.oneVsOne.getKillManager().getKills().put(killer, (this.oneVsOne.getKillManager().getKills().get(killer) + 1));
            }

            event.getEntity().getPlayer().spigot().respawn();
            this.oneVsOne.getKillManager().getDeaths().put(target, (this.oneVsOne.getKillManager().getDeaths().get(target) + 1));

            this.oneVsOne.getScoreboard().setScoreboard(target.getPlayer());
            this.oneVsOne.getScoreboard().setScoreboard(killer.getPlayer());
        }

        this.oneVsOne.getStartCountdown().startCountdown();

    }

}
