package com.viking.lantudapao;

import com.viking.lantudapao.command.SpeedCommand;
import com.viking.lantudapao.config.LantuConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(LantuDapao.MOD_ID)
public class LantuDapao {
    public static final String MOD_ID = "lantudapao";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public LantuDapao(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, LantuConfig.SERVER_SPEC);

        NeoForge.EVENT_BUS.register(this);

        LOGGER.info("Lantu Dapao loaded! Default speed multiplier: {}x", LantuConfig.getSpeedMultiplier());
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        SpeedCommand.register(event.getDispatcher());
    }
}
