package net.unestia.onevsone.game.kit.type;

import net.unestia.onevsone.game.kit.Kit;
import net.unestia.onevsone.utils.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author: Uprank
 * @date: 20.01.2021
 */

public class DefaultKit extends Kit {

    public DefaultKit() {
        super("default");
    }

    @Override
    public Inventory getContent() {
        Inventory inventory = Bukkit.createInventory(null, 36);

        inventory.setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, (byte) 0).build());
        inventory.setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, (byte) 0).build());
        inventory.setItem(2, new ItemBuilder(Material.BOW, 1, (byte) 0).build());
        inventory.setItem(3, new ItemBuilder(Material.ARROW, 16, (byte) 0).build());
        inventory.setItem(4, new ItemBuilder(Material.GOLDEN_APPLE, 4, (byte) 0).build());
        inventory.setItem(5, new ItemBuilder(Material.COBBLESTONE, 64, (byte) 0).build());
        inventory.setItem(6, new ItemBuilder(Material.COBBLESTONE, 64, (byte) 0).build());
        inventory.setItem(7, new ItemBuilder(Material.WATER_BUCKET, 1, (byte) 0).build());
        inventory.setItem(8, new ItemBuilder(Material.LAVA_BUCKET, 1, (byte) 0).build());

        return inventory;
    }

    @Override
    public ItemStack[] getArmorContent() {
        return new ItemStack[]{
                new ItemBuilder(Material.IRON_BOOTS, 1, (byte) 0).build(),
                new ItemBuilder(Material.IRON_LEGGINGS, 1, (byte) 0).build(),
                new ItemBuilder(Material.IRON_CHESTPLATE, 1, (byte) 0).build(),
                new ItemBuilder(Material.IRON_HELMET, 1, (byte) 0).build()
        };
    }
}
