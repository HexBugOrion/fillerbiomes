package net.vdragondev.fillerbiomes.worldgen.biome.biome_list;

import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.vdragondev.fillerbiomes.registries.SurfaceBuilderRegistry;
import net.vdragondev.fillerbiomes.worldgen.WorldGenRegistryHelper;
import net.vdragondev.fillerbiomes.worldgen.biome.surfaces.TundraSurface;

public class TundraBiome extends net.vdragondev.nowhere.worldgen.biome.FillerBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistryHelper.createConfiguredSurfaceBuilder("tundra", new ConfiguredSurfaceBuilder<>(SurfaceBuilderRegistry.TUNDRA, SurfaceBuilder.GRASS_CONFIG));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.SNOW;
    static final Biome.Category CATEGORY = Biome.Category.ICY;
    static final float DEPTH = 1.0F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 0.01F;
    static final float DOWNFALL = 0.1F;
    static final int WATER_COLOR = 3750089;
    static final int WATER_FOG_COLOR = 329011;
    static final int SKY_COLOR = 7907327;
    static final int GRASS_COLOR = 12779501;
    static final int FOLIAGE_COLOR = 11262155;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public TundraBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(16769730).skyColor(SKY_COLOR).grassColor(GRASS_COLOR).foliageColor(FOLIAGE_COLOR).moodSound(
            BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }



    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.SNOWY_TUNDRA), 3);
        return biomeWeightedList;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    @Override
    public OverworldClimate getBiomeType() {
        return OverworldClimate.SNOWY;
    }

    static {
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.VILLAGE_SNOWY);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.ICE_SPIKE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.ICE_PATCH);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_BERRY_BUSH);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ConfiguredFeatures.FREEZE_TOP_LAYER);
    }
}
