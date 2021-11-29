package seyross.keys_dungeons.blocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import seyross.keys_dungeons.registry.ModItems;
import seyross.keys_dungeons.registry.ModSounds;

public class LightDoor extends DoorBlock {
    static int counterOnUse;
    boolean locked;

    public static final Logger log = LogManager.getLogger("KeysAndDungeons");

    public LightDoor() {
        super(FabricBlockSettings.of(Material.WOOD).strength(3f, 3f).sounds(BlockSoundGroup.WOOD).nonOpaque());
        counterOnUse = 0;
        locked = false;
    }

    public LightDoor(Settings settings) {
        super(settings);
        counterOnUse = 0;
        locked = false;
    }

    //@TODO Add audio and/or text feedback to player, to show if door can be open or not. 
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if( !keyInHand(player) && !locked){
            return super.onUse(state, world, pos, player, hand, hit);
        }
        else{
            //onUse is called 4 times (i don't know why), we want it to play sound only once.
            if(counterOnUse == 3){
                counterOnUse=0;

                if( keyInHand(player) ){
                    if(locked){
                        locked = false;
                        log.info("unlocked");
                        world.playSound(null, pos, ModSounds.LIGHT_DOOR_OPENS_EVENT, SoundCategory.BLOCKS, 1f, 1f);
                    }else{
                        locked = true;
                        log.info("locked");
                        world.playSound(null, pos, ModSounds.LIGHT_DOOR_CLOSES_EVENT, SoundCategory.BLOCKS, 1f, 1f);
                    }
                }else{
                    if(locked){
                        log.info("door cant open");
                        playOpenCloseSound(world, pos, isOpen(state));
                    }
                }
            }else{
                counterOnUse++;
            }

            return ActionResult.PASS;
        }
    }

    private void playOpenCloseSound(World world, BlockPos pos, boolean open) {
        world.syncWorldEvent(null, open ? this.getCloseSoundEventId() : this.getOpenSoundEventId(), pos, 0);
    }

    private int getCloseSoundEventId() {
        return this.material == Material.METAL ? WorldEvents.IRON_DOOR_OPENS : WorldEvents.WOODEN_DOOR_OPENS;
    }

    private int getOpenSoundEventId() {
        return this.material == Material.METAL ? WorldEvents.IRON_DOOR_CLOSES : WorldEvents.WOODEN_DOOR_CLOSES;
    }

    private boolean keyInHand(PlayerEntity player){
        return player.getInventory().getMainHandStack().getItem().equals(ModItems.KEY);
    }
}
