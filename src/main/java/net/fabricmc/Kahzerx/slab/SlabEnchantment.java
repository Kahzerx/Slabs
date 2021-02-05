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

    private static Enchantment register(Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, "slab", enchantment);
    }

    static {
        SLAB = register(new SlabEnchantment(Enchantment.Weight.COMMON, EnchantmentTarget.ALL, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    }
}
