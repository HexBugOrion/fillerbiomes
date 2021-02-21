package net.vdragondev.fillerbiomes.worldgen.biome;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.vdragondev.fillerbiomes.worldgen.WorldGenRegistryHelper;
import net.vdragondev.fillerbiomes.worldgen.biome.surfaces.TundraSurface;

import java.util.ArrayList;
import java.util.List;

public class FillerSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> SOLAR_VALLEY = WorldGenRegistryHelper
        .createSurfaceBuilder("tundra_surface", new TundraSurface(TernarySurfaceConfig.CODEC));

    public static class Configs{

        public static final TernarySurfaceConfig TUNDRA_CS1 = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState());
        public static final TernarySurfaceConfig TUNDRA_CS2 = new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
        public static final TernarySurfaceConfig TUNDRA_CS3 = new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());

    }
}
