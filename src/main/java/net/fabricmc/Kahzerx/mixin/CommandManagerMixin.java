package net.fabricmc.Kahzerx.mixin;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.Kahzerx.slab.SlabCommand;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public class CommandManagerMixin {
    @Shadow @Final private CommandDispatcher<ServerCommandSource> dispatcher;
    @Inject(at = @At("RETURN"), method = "<init>")
    private void register(boolean boolean_1, CallbackInfo ci){
        SlabCommand.register(this.dispatcher);
    }
}
