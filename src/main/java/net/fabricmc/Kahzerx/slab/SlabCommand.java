package net.fabricmc.Kahzerx.slab;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.literal;

public class SlabCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("slab")
                .executes(context -> f0(context.getSource())));
    }

    private static int f0(ServerCommandSource src) throws CommandSyntaxException {
        if (Slab.isSlab(src.getPlayer().inventory.getMainHandStack().getItem())){
            if (!src.getPlayer().inventory.getMainHandStack().hasEnchantments()) {
                src.getPlayer().inventory.getMainHandStack().addEnchantment(SlabEnchantment.SLAB, 0);
                src.sendFeedback(new LiteralText("Slab!"), false);
            }
        }
        return 1;
    }
}
