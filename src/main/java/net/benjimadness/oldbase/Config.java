package net.benjimadness.oldbase;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.ModConfigSpec;

@Mod.EventBusSubscriber(modid = OldBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    static final ModConfigSpec SPEC = BUILDER.build();
}
