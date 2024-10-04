package net.rgy.lrn.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rgy.lrn.item.custom.HammerItem;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HammerUsageEvent implements PlayerBlockBreakEvents.Before{

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayerEntity serverPlayer){
            if(HARVESTED_BLOCKS.contains(pos)){
                return true;
            }

            for(BlockPos pos1 : HammerItem.getBlockPosToBeDestroyed(1,pos,serverPlayer)){
                if(pos == pos1 || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(pos1))){
                    continue;
                }

                HARVESTED_BLOCKS.add(pos1);
                serverPlayer.interactionManager.tryBreakBlock(pos1);
                HARVESTED_BLOCKS.remove(pos1);
            }
        }
        return true;
    }
}
