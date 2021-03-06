package net.vdragondev.nowhere.worldgen.biome;


import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecated")
public class FillerBiome {
    public static final List<net.vdragondev.nowhere.worldgen.biome.FillerBiome> NOWHERE_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<net.vdragondev.nowhere.worldgen.biome.BiomeData>
        biomeData = new ArrayList<net.vdragondev.nowhere.worldgen.biome.BiomeData>();

    public static final Int2ObjectMap<WeightedList<Biome>> BIOME_TO_HILLS_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_BEACH_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_EDGE_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_RIVER_LIST = new Int2ObjectArrayMap<>();

    public FillerBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        NOWHERE_BIOMES.add(this);
    }
    
    public FillerBiome(Biome.Builder builder) {
        this.biome = builder.build();
        NOWHERE_BIOMES.add(this);
    }

    public FillerBiome(Biome biome) {
        this.biome = biome;
        NOWHERE_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.RIVER);
    }


    public WeightedList<Biome> getHills() {
        return null;
    }


    public Biome getEdge() {
        return null;
    }


    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.BEACH);
    }

    public OverworldClimate getBiomeType() {
        return OverworldClimate.TEMPERATE;
    }

    public int getWeight() {
        return 5;
    }


    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
