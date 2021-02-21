package net.vdragondev.fillerbiomes.worldgen.biome;




import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FillerSubBiome {
    public static final List<FillerSubBiome> FILLER_SUB_BIOMES= new ArrayList<>();
    private final Biome biome;

    public static List<SubBiomeData> subBiomeData = new ArrayList<>();


    public FillerSubBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        FILLER_SUB_BIOMES.add(this);
    }

    public FillerSubBiome(Biome.Builder builder) {
        this.biome = builder.build();
        FILLER_SUB_BIOMES.add(this);
    }

    public FillerSubBiome(Biome biome) {
        this.biome = biome;
        FILLER_SUB_BIOMES.add(this);
    }

    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.BEACH);
    }


    public Biome getEdge() {
        return null;
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.RIVER);
    }

    public Object getBiomeDictionary() {
        return null; //{BiomeDictionary.Type.OVERWORLD};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
