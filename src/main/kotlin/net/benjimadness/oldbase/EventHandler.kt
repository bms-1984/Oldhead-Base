package net.benjimadness.oldbase

import net.minecraft.world.entity.animal.Bee
import net.neoforged.bus.api.EventPriority
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent

@Mod.EventBusSubscriber(modid = OldBase.MODID)
object EventHandler
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onEntityJoinLevel(event: EntityJoinLevelEvent) { if (Config.disableVanillaBees && event.entity is Bee) event.isCanceled = true }
}
