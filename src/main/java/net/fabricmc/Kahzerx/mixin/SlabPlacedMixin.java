package net.fabricmc.Kahzerx.mixin;

import net.fabricmc.Kahzerx.slab.Slab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SlabBlock.class)
public class SlabPlacedMixin extends Block {

    public SlabPlacedMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack){
        if (Slab.isSlab(itemStack.getItem()) && itemStack.hasEnchantments()){
            Slab.flipSlab(world, pos, state);
        }
    }
}
