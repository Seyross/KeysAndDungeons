package seyross.keys_dungeons.registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import seyross.keys_dungeons.blocks.LightDoor;

public class ModBlocks {
	public static final LightDoor LIGHT_DOOR = new LightDoor();

    public static void registerBlock() {
		Registry.register(Registry.BLOCK, new Identifier("keys_dungeons", "light_door"), LIGHT_DOOR);
    }
}