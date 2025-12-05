package com.viking.lantudapao.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class LantuConfig {
    public static final ServerConfig SERVER;
    public static final ModConfigSpec SERVER_SPEC;

    private static int runtimeSpeedMultiplier = -1;

    static {
        Pair<ServerConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ServerConfig::new);
        SERVER = specPair.getLeft();
        SERVER_SPEC = specPair.getRight();
    }

    public static class ServerConfig {
        public final ModConfigSpec.IntValue speedMultiplier;
        public final ModConfigSpec.IntValue minDelay;

        public ServerConfig(ModConfigSpec.Builder builder) {
            builder.comment("Lantu Dapao - Schematicannon Speed Configuration")
                   .push("schematicannon");

            speedMultiplier = builder
                .comment("Speed multiplier for schematicannon (default: 300)",
                         "Higher values = faster printing",
                         "The actual delay = original_delay / speed_multiplier")
                .defineInRange("speedMultiplier", 300, 1, 10000);

            minDelay = builder
                .comment("Minimum delay between shots in ticks (default: 0)",
                         "Set to 1 or higher to prevent potential lag from extremely fast printing")
                .defineInRange("minDelay", 0, 0, 100);

            builder.pop();
        }
    }

    public static int getSpeedMultiplier() {
        if (runtimeSpeedMultiplier > 0) {
            return runtimeSpeedMultiplier;
        }
        try {
            return SERVER.speedMultiplier.get();
        } catch (IllegalStateException e) {
            return 300;
        }
    }

    public static void setRuntimeSpeedMultiplier(int multiplier) {
        runtimeSpeedMultiplier = multiplier;
    }

    public static void resetRuntimeSpeedMultiplier() {
        runtimeSpeedMultiplier = -1;
    }

    public static int getMinDelay() {
        try {
            return SERVER.minDelay.get();
        } catch (IllegalStateException e) {
            return 0;
        }
    }
}
