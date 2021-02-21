package net.vdragondev.fillerbiomes.worldgen.biome.jsongen;

import net.minecraft.util.registry.BuiltinRegistries;
import net.vdragondev.nowhere.worldgen.biome.BiomeData;

import java.util.Comparator;
import java.util.List;

public class BiomeDataListHolder {

    List<BiomeData> biomeData;


    public BiomeDataListHolder(List<BiomeData> biomeData) {
        this.biomeData = biomeData;
    }

    public List<BiomeData> getBiomeData() {
        return biomeData;
    }

    public static void createDefaults() {
        for (net.vdragondev.nowhere.worldgen.biome.FillerBiome nowhereBiome : net.vdragondev.nowhere.worldgen.biome.FillerBiome.NOWHERE_BIOMES) {
            net.vdragondev.nowhere.worldgen.biome.FillerBiome.biomeData.add(new BiomeData(nowhereBiome.getBiome(), nowhereBiome.getWeight(), nowhereBiome.getBiomeType(), nowhereBiome.getHills(), nowhereBiome.getEdge(), nowhereBiome.getBeach(), nowhereBiome.getRiver()));
        }
        net.vdragondev.nowhere.worldgen.biome.FillerBiome.biomeData.sort(
            Comparator.comparing(data -> BuiltinRegistries.BIOME.getId(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (BiomeData biomeData : net.vdragondev.nowhere.worldgen.biome.FillerBiome.biomeData) {
            if (biomeData.getBiomeWeightedList() != null) {
                net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_HILLS_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBiomeWeightedList());
            }
            if (biomeData.getBeachBiome() != null)
                net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_BEACH_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBeachBiome());
            if (biomeData.getEdgeBiome() != null)
                net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_EDGE_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getEdgeBiome());
            if (biomeData.getRiverBiome() != null)
                net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_RIVER_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getRiverBiome());
        }

        net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_EDGE_LIST.remove(-1);
        net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_BEACH_LIST.remove(-1);
        net.vdragondev.nowhere.worldgen.biome.FillerBiome.BIOME_TO_RIVER_LIST.remove(-1);
    }

}
