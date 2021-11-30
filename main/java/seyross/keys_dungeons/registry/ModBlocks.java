package seyross.keys_dungeons.registry;
import seyross.keys_dungeons.KeysAndDungeons;
import seyross.keys_dungeons.blocks.LightDoor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
  // All doors objects
  public static DoorBlock LIGHT_DOOR;

  public static void registerBlock() {
    LIGHT_DOOR = new LightDoor(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque());

    Registry.register(Registry.BLOCK, new Identifier("keys_dungeons", "light_door"), LIGHT_DOOR);
    Registry.register(Registry.ITEM, new Identifier("keys_dungeons", "light_door"), new BlockItem(LIGHT_DOOR, new FabricItemSettings().group(KeysAndDungeons.ITEM_GROUP)));
  }
}
