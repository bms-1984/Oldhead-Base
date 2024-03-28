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

package net.benjimadness.triad

import com.mojang.logging.LogUtils
import net.benjimadness.triad.config.TriadConfig
import net.benjimadness.triad.registry.TriadBlocks
import net.benjimadness.triad.registry.TriadItems
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModLoadingContext
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(TriadMod.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object TriadMod
{
    const val MODID = "triad"
    private val LOGGER: Logger = LogUtils.getLogger()
    private val CREATIVE_TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)
    val TRIAD_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_TABS.register("triad") { ->
        CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.triad"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon { -> TriadItems.TIN_ORE.get().defaultInstance }
                .displayItems { _, output ->
                    run {
                        output.accept(TriadBlocks.TIN_ORE)
                        output.accept(TriadBlocks.DEEPSLATE_TIN_ORE)
                        output.accept(TriadBlocks.RAW_TIN_BLOCK)
                        output.accept(TriadBlocks.TIN_BLOCK)
                        output.accept(TriadItems.RAW_TIN)
                        output.accept(TriadItems.TIN_INGOT)
                    }
                }
                .build()
    }

    init
    {
        runForDist(clientTarget = { MOD_BUS.addListener(::onClientSetup) }, serverTarget = { MOD_BUS.addListener(::onServerSetup) })
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TriadConfig.SPEC)
        TriadBlocks.TRIAD_BLOCKS.register(MOD_BUS)
        TriadItems.TRIAD_ITEMS.register(MOD_BUS)
        CREATIVE_TABS.register(MOD_BUS)
    }

    @SubscribeEvent
    private fun onCommonSetup(event: FMLCommonSetupEvent)
    {
        LOGGER.info("Trying Triad, David, Stephen, Neil, Graham, Joni, YESSIREE!")
        if (TriadConfig.disableVanillaBees)
        {
            LOGGER.info("Disabling vanilla bees, sir! Send her on forward.")
        }
    }

    @SubscribeEvent
    fun onBuildCreativeModeTabContents(event: BuildCreativeModeTabContentsEvent)
    {
        when (event.tabKey) {
            CreativeModeTabs.NATURAL_BLOCKS -> {
                event.accept(TriadBlocks.TIN_ORE)
                event.accept(TriadBlocks.DEEPSLATE_TIN_ORE)
                event.accept(TriadBlocks.RAW_TIN_BLOCK)
            }
            CreativeModeTabs.BUILDING_BLOCKS -> {
                event.accept(TriadBlocks.TIN_BLOCK)
            }
            CreativeModeTabs.INGREDIENTS -> {
                event.accept(TriadItems.TIN_INGOT)
                event.accept(TriadItems.RAW_TIN)
            }
        }
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {}
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {}
}
