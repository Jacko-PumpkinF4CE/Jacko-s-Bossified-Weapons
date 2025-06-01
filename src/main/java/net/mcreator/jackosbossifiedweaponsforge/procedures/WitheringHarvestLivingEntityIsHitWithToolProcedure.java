package net.mcreator.jackosbossifiedweaponsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModEnchantments;

public class WitheringHarvestLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.SKULL_SHOT.get(), itemstack) != 0) == false
				&& (EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.WITHERING_POTENCY.get(), itemstack) != 0) == false) {
			if ((sourceentity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem())) == false) {
				if ((entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.WITHER)) == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) 11.11);
				} else {
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) 11.11);
				}
			}
		} else if (EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.WITHERING_POTENCY.get(), itemstack) != 0) {
			if ((sourceentity instanceof Player _plrCldCheck15 && _plrCldCheck15.getCooldowns().isOnCooldown(itemstack.getItem())) == false) {
				if ((entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.WITHER)) == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2));
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) 11.11);
				} else {
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) 11.11);
				}
			}
		}
	}
}
