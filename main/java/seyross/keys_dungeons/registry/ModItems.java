package seyross.keys_dungeons.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import seyross.keys_dungeons.KeysAndDungeons;

public class ModItems {
    public static final Item KEY = new Item(new Item.Settings().group(ItemGroup.REDSTONE));
	public static final Item BOSS_KEY = new Item(new Item.Settings().group(ItemGroup.REDSTONE));
	public static final Item LIGHT_DOOR_ITEM = new Item(new Item.Settings().group(ItemGroup.REDSTONE));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(KeysAndDungeons.MOD_ID, "key"), KEY);
		Registry.register(Registry.ITEM, new Identifier(KeysAndDungeons.MOD_ID, "boss_key"), BOSS_KEY);
		Registry.register(Registry.ITEM, new Identifier(KeysAndDungeons.MOD_ID, "light_door"), LIGHT_DOOR_ITEM);
    }
}