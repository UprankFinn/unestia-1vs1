package net.unestia.onevsone.game.kit;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Uprank
 * @date: 20.01.2021
 */

public abstract class Kit {

    @Getter
    private String name;

    @Getter
    private List<Player> playerList;

    public Kit(@NotNull String name) {
        this.name = name;
        this.playerList = new ArrayList<>();
    }

    public abstract Inventory getContent();
    public abstract ItemStack[] getArmorContent();

}
