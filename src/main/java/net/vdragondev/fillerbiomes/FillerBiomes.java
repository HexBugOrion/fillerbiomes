package net.vdragondev.fillerbiomes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.vdragondev.fillerbiomes.registries.BiomeRegistry;
import net.vdragondev.fillerbiomes.worldgen.biome.jsongen.BiomeDataListHolder;
import net.vdragondev.fillerbiomes.worldgen.biome.jsongen.JsonGenBiomes;
import net.vdragondev.fillerbiomes.worldgen.biome.jsongen.SubBiomeDataListHolder;

import java.io.File;
import java.nio.file.Path;

public class FillerBiomes implements ModInitializer {

	public static Registry<Biome> REGISTRY;
	public static final String MOD_ID = "fillerbiomes";
	public static String FILE_PATH = "boring-biomes";

	public static final Path
		CONFIG_PATH = new File(String.valueOf(FabricLoader.getInstance().getConfigDirectory().toPath().resolve(MOD_ID))).toPath();
	public void onInitialize() {
		File dir = new File(CONFIG_PATH.toString());
		if (!dir.exists())
			dir.mkdir();

		System.out.println("Registering Nowhere...");
		NowhereRegistries.registerStuff();
		NowhereWorldRegistries.registerWorldStuff();
		commonSetup();
		clearRAM();
		}

	private void commonSetup(){
		System.out.println("Setting up Biomes...");
		JsonGenBiomes.handleNowhereBiomeJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-biomes.json"));
		JsonGenBiomes.handleNowhereSubBiomesJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-sub-biomes.json"));
		BiomeRegistry.addBiomeEntries();
		BiomeDataListHolder.fillBiomeLists();
		SubBiomeDataListHolder.fillBiomeLists();
		System.out.println("Biome Setup Complete");
	}

	public static void clearRAM(){
		System.out.println("Clearing MC Ram");
		FILE_PATH = null;
		System.out.println("Cleared ram!");
	}

	public static class NowhereRegistries {

		public static void registerStuff(){

		}
	}
	public static class NowhereWorldRegistries{

		public static void registerWorldStuff(){
			System.out.println("Registering Biomes...");
			System.out.println("Biomes Registered!");
			System.out.println("Registering Biomes...");
			BiomeRegistry.init();
			System.out.println("Biomes Registered!");
		}
	}
}
