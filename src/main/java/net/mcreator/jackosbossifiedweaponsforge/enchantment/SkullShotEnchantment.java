
package net.mcreator.jackosbossifiedweaponsforge.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModItems;
import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModEnchantments;

import java.util.List;

public class SkullShotEnchantment extends Enchantment {
	public SkullShotEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(JackosBossifiedWeaponsForgeModEnchantments.WITHERING_POTENCY.get(), JackosBossifiedWeaponsForgeModEnchantments.WITHERED_SLASHING.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(JackosBossifiedWeaponsForgeModItems.WITHERING_HARVEST.get())).test(itemstack);
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}
