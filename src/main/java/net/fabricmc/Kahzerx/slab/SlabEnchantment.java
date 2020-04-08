package net.fabricmc.Kahzerx.slab;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class SlabEnchantment extends Enchantment {

    public static Enchantment SLAB;

    protected SlabEnchantment(Weight weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    private static Enchantment register(String string, Enchantment enchantment) {
        return (Enchantment) Registry.register(Registry.ENCHANTMENT, string, enchantment);
    }

    static {
        SLAB = register("slab", new SlabEnchantment(Enchantment.Weight.COMMON, EnchantmentTarget.ALL, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    }
}
