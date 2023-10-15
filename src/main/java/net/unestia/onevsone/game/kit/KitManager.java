package net.unestia.onevsone.game.kit;

import lombok.Getter;
import net.unestia.onevsone.game.kit.type.DefaultKit;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Uprank
 * @date: 20.01.2021
 */

public class KitManager {

    @Getter
    private Map<String, Kit> kit = new HashMap<>();

    @Getter
    private DefaultKit defaultKit;

    public KitManager() {
        this.defaultKit = new DefaultKit();
    }

    public void registerKits(@NotNull Kit kit) {
        this.kit.put(kit.getName(), kit);
    }

    public void addKit(){
        registerKits(new DefaultKit());
    }

}