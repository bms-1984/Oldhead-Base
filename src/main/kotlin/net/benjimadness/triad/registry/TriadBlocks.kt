/*
 *     Triad, a tech mod for Minecraft
 *     Copyright (C) 2024  Ben M. Sutter
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.benjimadness.triad.registry

import net.benjimadness.triad.TriadMod
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister

object TriadBlocks {
    val block = Blocks.COPPER_ORE
    val TRIAD_BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(TriadMod.MODID)
    val TIN_ORE: DeferredBlock<Block> = TRIAD_BLOCKS.registerSimpleBlock("tin_ore", BlockBehaviour.Properties.of()
            .strength(1.5F, 6F)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops())
    val DEEPSLATE_TIN_ORE: DeferredBlock<Block> = TRIAD_BLOCKS.registerSimpleBlock("deepslate_tin_ore", BlockBehaviour.Properties.of()
            .strength(1.5F, 6F)
            .sound(SoundType.DEEPSLATE)
            .requiresCorrectToolForDrops())
    val RAW_TIN_BLOCK: DeferredBlock<Block> = TRIAD_BLOCKS.registerSimpleBlock("raw_tin_block", BlockBehaviour.Properties.of()
            .strength(1.2F, 6F)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops())
    val TIN_BLOCK: DeferredBlock<Block> = TRIAD_BLOCKS.registerSimpleBlock("tin_block", BlockBehaviour.Properties.of()
            .strength(1.2F, 6F)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops())
}