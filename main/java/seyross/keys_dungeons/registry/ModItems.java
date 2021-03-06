package seyross.keys_dungeons.registry;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import seyross.keys_dungeons.KeysAndDungeons;

public class ModItems {
    //Items
    public static final Item KEY = new Item(new Item.Settings().group(KeysAndDungeons.ITEM_GROUP));
	public static final Item BOSS_KEY = new Item(new Item.Settings().group(KeysAndDungeons.ITEM_GROUP));
	
    //Bloc Items
    public static final BlockItem LIGHT_DOOR_ITEM = new BlockItem(ModBlocks.LIGHT_DOOR, new Item.Settings().group(KeysAndDungeons.ITEM_GROUP));    

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(KeysAndDungeons.MOD_ID, "key"), KEY);
		Registry.register(Registry.ITEM, new Identifier(KeysAndDungeons.MOD_ID, "boss_key"), BOSS_KEY);
    }
}