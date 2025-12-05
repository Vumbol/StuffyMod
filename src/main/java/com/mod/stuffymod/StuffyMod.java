package com.mod.stuffymod;

import com.mod.stuffymod.registry.ModBlocks;
import com.mod.stuffymod.registry.ModCreativeTabs;
import com.mod.stuffymod.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(StuffyMod.MODID)
public class StuffyMod {

    public static final String MODID = "stuffymod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public StuffyMod(IEventBus modEventBus, ModContainer modContainer) {

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlocks.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);

        LOGGER.info("StuffyMod initialized!");
    }
}
