package net.benjimadness.oldbase

import com.mojang.logging.LogUtils
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModLoadingContext
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(OldBase.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object OldBase
{
    const val MODID = "oldbase"
    val LOGGER: Logger = LogUtils.getLogger()
    init
    {
        runForDist(clientTarget = { MOD_BUS.addListener(::onClientSetup) }, serverTarget = { MOD_BUS.addListener(::onServerSetup) })
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC)
    }

    @SubscribeEvent
    private fun onCommonSetup(event: FMLCommonSetupEvent)
    {
        LOGGER.info("Oldhead Base in Place, Ace here. Show em the Sign!")
        if (Config.disableVanillaBees)
        {
            LOGGER.info("Disabling vanilla bees, sir! Send her on forward.")
        }
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {}
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {}
}
