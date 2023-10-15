package net.unestia.onevsone.countdown;

import lombok.Getter;
import net.unestia.api.game.GameState;
import net.unestia.onevsone.OneVsOne;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;

/**
 * @author: Uprank
 * @date: 23.01.2021
 */

public class StartCountdown {

    private final OneVsOne oneVsOne;

    @Getter
    private Integer countdown = 5;
    @Getter
    private Boolean started = false;
    @Getter
    private Integer startCountdown;

    public StartCountdown(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
    }

    public void checkCountdown(@NotNull Integer onlinePlayers) {
        if (onlinePlayers == 2) {
            started = true;
            startCountdown();
        } else {
            if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.INGAME || this.oneVsOne.getUnestiaAPI().getGameState() == GameState.ENDING) {
                stopCountdown();
                started = false;
            }
            if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY) {
                stopCountdown();
                started = false;
            }
        }
    }

    public void startCountdown() {
        if (this.oneVsOne.getUnestiaAPI().getGameState() == GameState.LOBBY || this.oneVsOne.getUnestiaAPI().getGameState() == GameState.INGAME) {
            this.startCountdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.oneVsOne, () -> {
                if (started) {
                    if (countdown == 5 || countdown == 4 || countdown == 3 || countdown == 2) {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            players.setLevel(countdown);
                            players.sendMessage(MessageFormat.format(this.oneVsOne.getUnestiaAPI().getPlayerManager().getPlayer(players.getUniqueId()).getLanguage().getTranslations().get("lobby_countdown_start_about_one_second"), OneVsOne.PREFIX, countdown));
                        });
                    } else if (countdown == 1) {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            players.setLevel(countdown);
                            players.sendMessage(MessageFormat.format(this.oneVsOne.getUnestiaAPI().getPlayerManager().getPlayer(players.getUniqueId()).getLanguage().getTranslations().get("lobby_countdown_start_in_one_second"), OneVsOne.PREFIX, countdown));
                        });
                    } else if (countdown == 0) {
                        this.oneVsOne.getUnestiaAPI().setGameState(GameState.INGAME);
                        Bukkit.getScheduler().cancelTask(startCountdown);
                        stopCountdown();
                    }
                    countdown--;
                } else {
                    countdown = 5;
                    Bukkit.getScheduler().cancelTask(startCountdown);
                }
            }, 20, 20);
        }
    }

    public void stopCountdown() {
        if (started) {
            Bukkit.getScheduler().cancelTask(startCountdown);
            this.countdown = 5;
        }
    }

}
