package seyross.keys_dungeons;

import net.fabricmc.api.ModInitializer;
import seyross.keys_dungeons.registry.ModBlocks;
import seyross.keys_dungeons.registry.ModItems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeysAndDungeons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("KeysAndDungeons");

	public static final String MOD_ID = "keys_dungeons";	

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlock();
	}
}
