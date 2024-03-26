package net.benjimadness.oldbase

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.animal.Bee
import net.minecraft.world.level.block.Blocks
import net.neoforged.bus.api.EventPriority
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent
import net.neoforged.neoforge.event.level.ChunkEvent

@Mod.EventBusSubscriber(modid = OldBase.MODID)
object EventHandler
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onEntityJoinLevel(event: EntityJoinLevelEvent) { if (Config.disableVanillaBees && event.entity is Bee) event.isCanceled = true }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onChunkLoad(event: ChunkEvent.Load)
    {
        val chunk = event.chunk
        if (Config.disableVanillaBees)
            if (event.isNewChunk)
                for (x in 0..<16)
                    for (z in 0..<16)
                        for (y in 0..<chunk.height)
                        {
                            val pos = BlockPos(x, y, z)
                            if (chunk.getBlockState(pos).block == Blocks.BEE_NEST)
                                chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), true)
                        }
    }
}
