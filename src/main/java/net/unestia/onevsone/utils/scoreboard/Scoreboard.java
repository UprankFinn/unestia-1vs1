package net.unestia.onevsone.utils.scoreboard;

import net.unestia.onevsone.OneVsOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

/**
 * @author: Uprank
 * @date: 21.01.2021
 */

public class Scoreboard {

    private final OneVsOne oneVsOne;

    public Scoreboard(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
    }

    public void setScoreboard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("aaa", "bbb");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§8× §b1vs1 §8×");

        objective.getScore("     ").setScore(13);
        objective.getScore("§bMap§8:").setScore(12);
        objective.getScore("§8» §e" + this.oneVsOne.getWorld().getName().substring(0, 1).toUpperCase() + this.oneVsOne.getWorld().getName().substring(1)).setScore(11);
        objective.getScore("    ").setScore(10);
        objective.getScore("§bKills§8:").setScore(9);
        objective.getScore("§8» " + ChatColor.YELLOW + "§e" + this.oneVsOne.getKillManager().getKills().get(player)).setScore(8);
        objective.getScore("   ").setScore(7);
        objective.getScore("§bDeaths§8:").setScore(6);
        objective.getScore("§8» " + ChatColor.YELLOW + this.oneVsOne.getKillManager().getDeaths().get(player)).setScore(5);
        objective.getScore("  ").setScore(4);
        objective.getScore("§bGameId§8:").setScore(3);
        objective.getScore("§8» §e" + this.oneVsOne.getUnestiaAPI().getGameId()).setScore(2);
        objective.getScore(" ").setScore(1);
        objective.getScore("§7mc.unestia.net").setScore(0);

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        player.setScoreboard(scoreboard);
    }

}
