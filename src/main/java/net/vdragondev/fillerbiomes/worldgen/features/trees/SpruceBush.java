package net.vdragondev.fillerbiomes.worldgen.features.trees;

import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.List;

public class SpruceBush extends TreeFeatureConfig {


    protected SpruceBush(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider,
        FoliagePlacer foliagePlacer, TrunkPlacer trunkPlacer, FeatureSize minimumSize,
        List<TreeDecorator> decorators, int maxWaterDepth, boolean ignoreVines,
        Heightmap.Type heightmap) {
        super(trunkProvider, leavesProvider, foliagePlacer, trunkPlacer, minimumSize, decorators,
            maxWaterDepth, ignoreVines, heightmap);
    }
}
