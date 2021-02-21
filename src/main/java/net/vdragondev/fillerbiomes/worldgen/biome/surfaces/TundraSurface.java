package net.vdragondev.fillerbiomes.worldgen.biome.surfaces;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.vdragondev.fillerbiomes.worldgen.biome.FillerSurfaceBuilders;

import java.util.Random;

public class TundraSurface extends SurfaceBuilder<TernarySurfaceConfig> {
    public TundraSurface(Codec<TernarySurfaceConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT
                .generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, FillerSurfaceBuilders.Configs.TUNDRA_CS1);
        } else if (noise > -0.95D){
            SurfaceBuilder.DEFAULT
                .generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, FillerSurfaceBuilders.Configs.TUNDRA_CS2);
        } else {
                SurfaceBuilder.DEFAULT
                    .generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                        defaultFluid, seaLevel, seed, FillerSurfaceBuilders.Configs.TUNDRA_CS3);
        }
    }
}

