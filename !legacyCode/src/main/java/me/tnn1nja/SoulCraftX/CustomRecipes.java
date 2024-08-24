package me.tnn1nja.SoulCraftX;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class CustomRecipes {
    public static void createRecipe() {
        //ITEM
        ItemStack swiftsneak = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) swiftsneak.getItemMeta();
        meta.addStoredEnchant(Enchantment.SWIFT_SNEAK, 1, false);
        swiftsneak.setItemMeta(meta);

        //RECIPE
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("swiftsneak"), swiftsneak);
        sr.shape("SSS", "SBS", "SSS");
        sr.setIngredient('S', Material.SCULK);
        sr.setIngredient('B', Material.BOOK);
        Bukkit.getServer().addRecipe(sr);

    }
}
