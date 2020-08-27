package com.mika.tutorial.worid.gen;

import com.mika.tutorial.Tutorial;
import com.mika.tutorial.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {
    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) {
                // nether generation

            } else if (biome.getCategory() == Biome.Category.THEEND) {
                // end generation

            } else {
                // overworld generation
                genOre(biome, 13, 10, 5, 65,
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        RegistryHandler.RUBY_ORE.get().getDefaultState(), 20);
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max,
                               OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(feature).withPlacement(config)
        );
    }
}
