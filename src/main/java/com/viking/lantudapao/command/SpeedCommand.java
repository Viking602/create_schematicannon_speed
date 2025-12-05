package com.viking.lantudapao.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.viking.lantudapao.config.LantuConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class SpeedCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            Commands.literal("lantudapao")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("speed")
                    .then(Commands.argument("multiplier", IntegerArgumentType.integer(1, 10000))
                        .executes(context -> {
                            int multiplier = IntegerArgumentType.getInteger(context, "multiplier");
                            LantuConfig.setRuntimeSpeedMultiplier(multiplier);
                            context.getSource().sendSuccess(
                                () -> Component.literal("[Lantu Dapao] Speed multiplier set to " + multiplier + "x"),
                                true
                            );
                            return multiplier;
                        })
                    )
                    .executes(context -> {
                        int current = LantuConfig.getSpeedMultiplier();
                        context.getSource().sendSuccess(
                            () -> Component.literal("[Lantu Dapao] Current speed multiplier: " + current + "x"),
                            false
                        );
                        return current;
                    })
                )
                .then(Commands.literal("reset")
                    .executes(context -> {
                        LantuConfig.resetRuntimeSpeedMultiplier();
                        int configValue = LantuConfig.getSpeedMultiplier();
                        context.getSource().sendSuccess(
                            () -> Component.literal("[Lantu Dapao] Speed reset to config value: " + configValue + "x"),
                            true
                        );
                        return 1;
                    })
                )
                .then(Commands.literal("info")
                    .executes(context -> {
                        int multiplier = LantuConfig.getSpeedMultiplier();
                        int minDelay = LantuConfig.getMinDelay();
                        context.getSource().sendSuccess(
                            () -> Component.literal("[Lantu Dapao] Schematicannon Speed Modifier\n" +
                                "  Speed Multiplier: " + multiplier + "x\n" +
                                "  Min Delay: " + minDelay + " ticks\n" +
                                "  Original delay: 10 ticks -> Modified: " + Math.max(minDelay, 10 / multiplier) + " ticks"),
                            false
                        );
                        return 1;
                    })
                )
        );
    }
}
