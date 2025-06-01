package net.mcreator.jackosbossifiedweaponsforge.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import net.minecraft.resources.ResourceLocation; // <-- NEW IMPORT
import net.minecraft.core.registries.BuiltInRegistries; // <-- NEW IMPORT

import net.minecraft.world.item.TooltipFlag; // This is for the appendHoverText method
import net.minecraft.network.chat.Component; // This is also for the appendHoverText method

import net.mcreator.jackosbossifiedweaponsforge.procedures.WitheringHarvestRightclickedProcedure;
import net.mcreator.jackosbossifiedweaponsforge.procedures.WitheringHarvestLivingEntityIsHitWithToolProcedure;
import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModItems;

import java.util.List;
import net.minecraft.world.item.enchantment.Enchantments;

public class WitheringHarvestItem extends HoeItem {
	public WitheringHarvestItem() {
		super(new Tier() {
			public int getUses() {
				return 2032;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 7f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JackosBossifiedWeaponsForgeModItems.ENCHANTED_NETHERITE_INGOT.get()));
			}
		}, 0, -2.8f, new Item.Properties().fireResistant());
	}

	@Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        // --- BLACKLIST FIRST (for specific enchantments you NEVER want) ---
        // Now referencing enchantments by their ResourceLocation from BuiltInRegistries
        if (enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "power")) || // Bow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "punch")) || // Bow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "flame")) || // Bow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "infinity")) || // Bow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "protection")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "feather_falling")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "blast_protection")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "projectile_protection")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "respiration")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "aqua_affinity")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "thorns")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "depth_strider")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "frost_walker")) || // Armor
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "soul_speed")) || // Boots
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "impaling")) || // Trident
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "riptide")) || // Trident
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "loyalty")) || // Trident
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "piercing")) || // Crossbow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "multishot")) || // Crossbow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "quick_charge")) || // Crossbow
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "lure")) || // Fishing Rod
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "luck_of_the_sea")) || // Fishing Rod
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "channeling")) || // Trident
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "sweeping_edge")) || // Sword
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "fire_aspect")) || // Sword
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "knockback")) || // Sword
            enchantment == BuiltInRegistries.ENCHANTMENT.get(new ResourceLocation("minecraft", "looting")) // Sword
            // Add any other specific vanilla or modded enchantments you *never* want here
        ) {
            return false; // This enchantment is explicitly disallowed
        }

        // --- WHITELIST BY CATEGORY (for generally allowing axe/hoe-like enchantments) ---
        // Now, allow enchantments if they fall into the desired categories.
        // This will catch most vanilla and modded enchantments that correctly use these categories.
        return enchantment.category.equals(EnchantmentCategory.WEAPON) ||    // Sharpness, Smite, Bane of Arthropods (and some modded weapon enchants)
               enchantment.category.equals(EnchantmentCategory.DIGGER) ||    // Efficiency, Fortune, Silk Touch (and some modded digging enchants)
               enchantment.category.equals(EnchantmentCategory.BREAKABLE);   // Unbreaking, Mending (for all tools/weapons)
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        Enchantment enchantment = net.minecraft.world.item.enchantment.EnchantmentHelper.getEnchantments(book).keySet().stream().findFirst().orElse(null);
        if (enchantment != null) {
            return this.canApplyAtEnchantingTable(stack, enchantment);
        }
        return super.isBookEnchantable(stack, book);
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true; // Enables shield disabling
    }

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		WitheringHarvestLivingEntityIsHitWithToolProcedure.execute(entity, sourceentity, itemstack);
		return retval;
	}

	 @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        // PROBLEM LINE:
        // WitheringHarvestRightclickedProcedure.execute(entity, ar.getObject());
        // FIX: Pass 'world' and ensure 'entity' is treated as an 'Entity'
        WitheringHarvestRightclickedProcedure.execute(world, entity, ar.getObject());
        return ar;
    }

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

}
