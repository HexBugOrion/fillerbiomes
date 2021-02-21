package net.vdragondev.fillerbiomes.worldgen.biome.jsongen;

import net.minecraft.util.registry.BuiltinRegistries;
import net.vdragondev.fillerbiomes.worldgen.biome.FillerSubBiome;
import net.vdragondev.fillerbiomes.worldgen.biome.SubBiomeData;

import java.util.Comparator;
import java.util.List;

public class SubBiomeDataListHolder {

    List<SubBiomeData> subBiomeData;


    public SubBiomeDataListHolder(List<SubBiomeData> subBiomeData) {
        this.subBiomeData = subBiomeData;
    }

    public List<SubBiomeData> getSubBiomeData() {
        return subBiomeData;
    }

    public static void createDefaults() {
        for (FillerSubBiome nowhereSubBiome : FillerSubBiome.FILLER_SUB_BIOMES) {
            FillerSubBiome.subBiomeData.add(new SubBiomeData(nowhereSubBiome.getBiome(), nowhereSubBiome.getEdge(), nowhereSubBiome.getBeach(), nowhereSubBiome.getRiver()));
        }
        FillerSubBiome.subBiomeData.sort(
            Comparator.comparing(data -> BuiltinRegistries.BIOME.getId(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (SubBiomeData biomeData : FillerSubBiome.subBiomeData) {
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
