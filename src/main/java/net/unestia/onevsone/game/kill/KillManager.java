package net.unestia.onevsone.game.kill;

import lombok.Getter;
import net.unestia.onevsone.OneVsOne;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Uprank
 * @date: 21.01.2021
 */

public class KillManager {

    private final OneVsOne oneVsOne;

    @Getter
    private Map<Player, Integer> kills;

    @Getter
    private Map<Player, Integer> deaths;

    public KillManager(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.kills = new HashMap<>();
        this.deaths = new HashMap<>();
    }
}
