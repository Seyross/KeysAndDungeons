package seyross.keys_dungeons.blocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import seyross.keys_dungeons.registry.ModItems;
import seyross.keys_dungeons.registry.ModSounds;

public class LightDoor extends DoorBlock{
    //--- Parameters
    private int counterOnUse;
    private boolean locked;

    public static final Logger log = LogManager.getLogger("KeysAndDungeons");

    //--- Constructors
    public LightDoor(Settings settings){
        super(settings);
        locked = false;
        counterOnUse = 0;
    }

    public LightDoor(Block block){
        super(FabricBlockSettings.copyOf(block).nonOpaque());
        locked = false;
        counterOnUse = 0;
    }

    //--- Methods
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //if(Block.getBlockFromItem(player.getInventory().getMainHandStack().getItem()). )
        if(counterOnUse++ == 3){
            counterOnUse = 0;
            
            if( keyInHand(player) ){
                if(locked){
                    locked = false;
                    log.info("Door unlocked");
                    world.playSound(null, pos, ModSounds.LIGHT_DOOR_OPENS_EVENT, SoundCategory.BLOCKS, 1f, 1f);
                }else{
                    locked = true;
                    log.info("Door locked");
                    world.playSound(null, pos, ModSounds.LIGHT_DOOR_CLOSES_EVENT, SoundCategory.BLOCKS, 1f, 1f);
                }
            }else{
                if(locked){
                    log.info("Door cant open");
                    playOpenCloseSound(world, pos, isOpen(state));
                }
            }
        }
        if( !keyInHand(player) && !locked){
            return super.onUse(state, world, pos, player, hand, hit);
        }
        else{
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
