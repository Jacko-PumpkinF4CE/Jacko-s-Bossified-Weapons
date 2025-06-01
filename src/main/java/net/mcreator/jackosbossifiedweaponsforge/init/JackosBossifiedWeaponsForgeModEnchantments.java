
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jackosbossifiedweaponsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.jackosbossifiedweaponsforge.enchantment.WitheringPotencyEnchantment;
import net.mcreator.jackosbossifiedweaponsforge.enchantment.WitheredSlashingEnchantment;
import net.mcreator.jackosbossifiedweaponsforge.enchantment.SkullShotEnchantment;
import net.mcreator.jackosbossifiedweaponsforge.enchantment.SiphonEnchantment;
import net.mcreator.jackosbossifiedweaponsforge.enchantment.AmplifyEnchantment;
import net.mcreator.jackosbossifiedweaponsforge.JackosBossifiedWeaponsForgeMod;

public class JackosBossifiedWeaponsForgeModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JackosBossifiedWeaponsForgeMod.MODID);
	public static final RegistryObject<Enchantment> SKULL_SHOT = REGISTRY.register("skull_shot", () -> new SkullShotEnchantment());
	public static final RegistryObject<Enchantment> WITHERING_POTENCY = REGISTRY.register("withering_potency", () -> new WitheringPotencyEnchantment());
	public static final RegistryObject<Enchantment> SIPHON = REGISTRY.register("siphon", () -> new SiphonEnchantment());
	public static final RegistryObject<Enchantment> AMPLIFY = REGISTRY.register("amplify", () -> new AmplifyEnchantment());
	public static final RegistryObject<Enchantment> WITHERED_SLASHING = REGISTRY.register("withered_slashing", () -> new WitheredSlashingEnchantment());
}
