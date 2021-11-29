package seyross.keys_dungeons.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static final Identifier LIGHT_DOOR_OPENS = new Identifier("keys_dungeons:light_door_opens");
	public static SoundEvent LIGHT_DOOR_OPENS_EVENT = new SoundEvent(LIGHT_DOOR_OPENS);

	public static final Identifier LIGHT_DOOR_CLOSES = new Identifier("keys_dungeons:light_door_closes");
	public static SoundEvent LIGHT_DOOR_CLOSES_EVENT = new SoundEvent(LIGHT_DOOR_CLOSES);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, LIGHT_DOOR_OPENS, LIGHT_DOOR_OPENS_EVENT);
        Registry.register(Registry.SOUND_EVENT, LIGHT_DOOR_CLOSES, LIGHT_DOOR_CLOSES_EVENT);
    }
}
