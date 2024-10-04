package net.rgy.lrn.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem {
    public HammerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlockPosToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHitResult = (BlockHitResult) hit;
            Direction side = blockHitResult.getSide();

            // Axis modifiers based on direction
            int[][] modifiers = getModifiersForDirection(side);
            int modX = modifiers[0][0], modY = modifiers[0][1], modZ = modifiers[0][2];
            int axisX = modifiers[1][0], axisY = modifiers[1][1], axisZ = modifiers[1][2];

            for (int x = -range * modX; x <= range * modX; x++) {
                for (int y = -range * modY; y <= range * modY; y++) {
                    for (int z = -range * modZ; z <= range * modZ; z++) {
                        positions.add(new BlockPos(
                                initialBlockPos.getX() + axisX * x,
                                initialBlockPos.getY() + axisY * y,
                                initialBlockPos.getZ() + axisZ * z
                        ));
                    }
                }
            }
        }

        return positions;
    }

    // Helper method to get axis modifiers for different sides
    private static int[][] getModifiersForDirection(Direction side) {
        switch (side) {
            case UP:
            case DOWN:
                return new int[][]{{1, 0, 1}, {1, 0, 1}};  // Modify X and Z, Y is constant
            case NORTH:
            case SOUTH:
                return new int[][]{{1, 1, 0}, {1, 1, 0}};  // Modify X and Y, Z is constant
            case EAST:
            case WEST:
                return new int[][]{{0, 1, 1}, {0, 1, 1}};  // Modify Y and Z, X is constant
            default:
                return new int[][]{{0, 0, 0}, {0, 0, 0}};  // No modification, fallback
        }
    }



}
