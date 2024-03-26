package net.benjimadness.oldbase

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.config.ModConfigEvent
import net.neoforged.neoforge.common.ModConfigSpec

@Mod.EventBusSubscriber(modid = OldBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object Config
{
    private val BUILDER = ModConfigSpec.Builder()
    private val DISABLE_VANIlLA_BEES: ModConfigSpec.BooleanValue = BUILDER
            .comment("Whether or not to disable vanilla bees")
            .define("disableVanillaBees", true)
    var disableVanillaBees: Boolean = true
    val SPEC: ModConfigSpec = BUILDER.build()

    @SubscribeEvent
    fun onLoad(event: ModConfigEvent)
    {
        disableVanillaBees = DISABLE_VANIlLA_BEES.get()
    }
}
