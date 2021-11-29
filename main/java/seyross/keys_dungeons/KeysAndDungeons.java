package seyross.keys_dungeons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import seyross.keys_dungeons.registry.ModBlocks;
import seyross.keys_dungeons.registry.ModItems;
import seyross.keys_dungeons.registry.ModSounds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeysAndDungeons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("KeysAndDungeons");

	public static final String MOD_ID = "keys_dungeons";
	
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier(MOD_ID, "general"),
		() -> new ItemStack(ModItems.LIGHT_DOOR_ITEM));

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlock();
		ModSounds.registerSounds();
	}
}
