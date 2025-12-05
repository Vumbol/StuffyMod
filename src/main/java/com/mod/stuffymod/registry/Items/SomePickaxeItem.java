package com.mod.stuffymod.registry.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SomePickaxeItem extends PickaxeItem {

    public SomePickaxeItem() {
        super(
                Tiers.IRON,
                new Item.Properties()
                        .durability(1500)
                        .stacksTo(1)
                        .fireResistant()
        );
    }

    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    BlockPos extraPos = pos.offset(x, 0, y);

                    if (!extraPos.equals(pos)) {
                        BlockState extraState = level.getBlockState(extraPos);

                        if (extraState.getDestroySpeed(level, extraPos) >= 0) {
                            level.destroyBlock(extraPos, true, entity);
                        }
                    }
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

}
