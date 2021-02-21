package net.vdragondev.fillerbiomes.registries;

import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.vdragondev.fillerbiomes.worldgen.biome.surfaces.TundraSurface;

public class SurfaceBuilderRegistry {

    public static final SurfaceBuilder<TernarySurfaceConfig> TUNDRA = WorldGenRegistrationHelper.createSurfaceBuilder("tundra_surface", new TundraSurface(TernarySurfaceConfig.CODEC));


}
