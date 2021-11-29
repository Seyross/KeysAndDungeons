package seyross.keys_dungeons.registry;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final Block LIGHT_DOOR = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));

    public static void registerBlock() {
		Registry.register(Registry.BLOCK, new Identifier("keys_dungeons", "light_door"), LIGHT_DOOR);
    }
}