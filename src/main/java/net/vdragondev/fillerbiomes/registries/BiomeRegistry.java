package net.vdragondev.fillerbiomes.registries;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.vdragondev.fillerbiomes.FillerBiomes;
import net.vdragondev.fillerbiomes.worldgen.biome.biome_list.TundraBiome;
import net.vdragondev.nowhere.worldgen.biome.BiomeData;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BiomeRegistry {

    //actual biomes
    public static Biome TUNDRA = Registry.register(BuiltinRegistries.BIOME, new Identifier(FillerBiomes.MOD_ID, "tundra"), new TundraBiome().getBiome());

    public static void init() {
    }



    public static void addBiomeEntries() {
        for (BiomeData biomeData : net.vdragondev.nowhere.worldgen.biome.FillerBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 100) {
                OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, BuiltinRegistries.BIOME.getId(biomeData.getBiome())), biomeData.getBiomeType(), biomeData.getBiomeWeight());
            }
        }
    }
    public static void addFeatureToBiome(Biome biome, GenerationStep.Feature feature, ConfiguredFeature<?, ?> configuredFeature) {
        convertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }
    private static void convertImmutableFeatures(Biome biome) {
        biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream().map(
            Lists::newArrayList).collect(Collectors.toList());
    }
    public static RegistryKey<Biome> register(String name, Biome biome){
        Identifier id = new Identifier("nowherebiomes", name);
        Registry.register(BuiltinRegistries.BIOME, id, biome);
        return RegistryKey.of(Registry.BIOME_KEY, id);
    }
}
