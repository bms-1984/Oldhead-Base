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
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object TriadItems {
    val TRIAD_ITEMS: DeferredRegister.Items = DeferredRegister.createItems(TriadMod.MODID)

    // block items
    val TIN_ORE: DeferredItem<BlockItem> = TRIAD_ITEMS.registerSimpleBlockItem("tin_ore", TriadBlocks.TIN_ORE)
    val DEEPSLATE_TIN_ORE: DeferredItem<BlockItem> = TRIAD_ITEMS.registerSimpleBlockItem("deepslate_tin_ore", TriadBlocks.DEEPSLATE_TIN_ORE)
    val RAW_TIN_BLOCK: DeferredItem<BlockItem> = TRIAD_ITEMS.registerSimpleBlockItem("raw_tin_block", TriadBlocks.RAW_TIN_BLOCK)
    val TIN_BLOCK: DeferredItem<BlockItem> = TRIAD_ITEMS.registerSimpleBlockItem("tin_block", TriadBlocks.TIN_BLOCK)

    // items
    val TIN_INGOT: DeferredItem<Item> = TRIAD_ITEMS.registerSimpleItem("tin_ingot")
    val RAW_TIN: DeferredItem<Item> = TRIAD_ITEMS.registerSimpleItem("raw_tin")
}