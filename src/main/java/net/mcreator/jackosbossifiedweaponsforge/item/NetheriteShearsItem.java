
package net.mcreator.jackosbossifiedweaponsforge.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.InteractionResultHolder; // For interactLivingEntity
import net.minecraft.world.InteractionHand;       // For interactLivingEntity
import net.minecraft.world.InteractionResult;    // For useOn and general interaction
import net.minecraft.world.item.context.UseOnContext; // For useOn (though we'll keep useOn minimal)
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceLocation; // For getting items by ID
import net.minecraft.tags.TagKey;              // For block tags
import net.minecraft.core.registries.Registries; // For accessing registries for tags
import net.minecraft.world.level.block.Block;    // For TagKey<Block>
import net.minecraft.world.level.block.state.BlockState; // For block state
import net.minecraft.world.entity.player.Player; // For accessing the player
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class NetheriteShearsItem extends SwordItem {
	public NetheriteShearsItem() {
		super(new Tier() {
			public int getUses() {
				return 952;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 3, -2.2f, new Item.Properties().fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	// Use this method for right-clicking on entities (like sheep)
    @Override
    public InteractionResult interactLivingEntity(ItemStack itemstack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof Sheep sheep) {
            // Check if the sheep can be sheared (is not already sheared)
            // The isSheared() method checks if the sheep has wool ready for shearing if it returns false.
            if (!sheep.isSheared()) { // Note: hasBredWool() is no longer used
                Level world = player.level(); // Get the world from the player

                if (!world.isClientSide()) { // Server side only
                    // Mark the sheep as sheared
                    sheep.setSheared(true);

                    // Drop wool items (2-4, similar to vanilla shears)
                    RandomSource random = world.getRandom();
                    int woolAmount = 2 + random.nextInt(3);
                    for (int i = 0; i < woolAmount; i++) {
                        if (world instanceof ServerLevel _level) {
                            // Get the correct colored wool item using ForgeRegistries
                            // This is the correct way to get an Item from its ResourceLocation string.
                            Item woolItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", sheep.getColor().getName() + "_wool"));
                            
                            if (woolItem != null) { // Ensure the item was found
                                ItemStack woolToDrop = new ItemStack(woolItem);
                                ItemEntity entityToSpawn = new ItemEntity(_level, sheep.getX(), sheep.getY() + 0.5D, sheep.getZ(), woolToDrop);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity(entityToSpawn);
                            }
                        }
                    }

                    // Play shearing sound
                    world.playSound(null, sheep.getX(), sheep.getY(), sheep.getZ(),
                            SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);

                    // Damage the sword item by 1 durability point
                    itemstack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                    return InteractionResult.SUCCESS; // Indicate success on server side
                } else {
                    return InteractionResult.CONSUME; // Indicate consumption on client side
                }
            }
        }
        // If not a sheep or sheep cannot be sheared, defer to super method for other interactions
        return super.interactLivingEntity(itemstack, player, target, hand);
    }

    // Retain useOn if you wish for potential block interactions (e.g., placing blocks with right-click)
    // For shearing logic, use interactLivingEntity.
    @Override
    public InteractionResult useOn(UseOnContext context) {
        // If you only want to handle block interactions here, you can remove the sheep logic from here.
        // For now, we'll just defer to the super method as interactLivingEntity handles the sheep.
        return super.useOn(context);
    }


    // Determines if this tool is the "correct" tool for a given block, allowing for instant breaks
    // or dropping without needing a specific mining level.
    @Override
    public boolean isCorrectToolForDrops(BlockState blockState) {
        // Check if the block is tagged as mineable by shears.
        // Use TagKey for block tags in modern Forge.
        TagKey<Block> MINEABLE_WITH_SHEARS_TAG = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "mineable/shears"));
        return blockState.is(MINEABLE_WITH_SHEARS_TAG);
    }

    // Determines the mining speed of the tool for a given block.
    @Override
    public float getDestroySpeed(ItemStack itemstack, BlockState blockState) {
        // If the block is mineable with shears, give it a high speed (like vanilla shears)
        TagKey<Block> MINEABLE_WITH_SHEARS_TAG = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "mineable/shears"));
        if (blockState.is(MINEABLE_WITH_SHEARS_TAG)) {
            return 5.0F; // Vanilla shears usually have a speed of 5.0F on their target blocks
        }
        // Otherwise, use the standard sword speed for other blocks
        return super.getDestroySpeed(itemstack, blockState);
    }
	
}
