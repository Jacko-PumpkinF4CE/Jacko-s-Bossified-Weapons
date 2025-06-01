
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jackosbossifiedweaponsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.jackosbossifiedweaponsforge.item.WitheringHarvestItem;
import net.mcreator.jackosbossifiedweaponsforge.item.WeatheredBoneItem;
import net.mcreator.jackosbossifiedweaponsforge.item.ShearUpgradeTemplateItem;
import net.mcreator.jackosbossifiedweaponsforge.item.SculkedShardItem;
import net.mcreator.jackosbossifiedweaponsforge.item.NetheriteShearsItem;
import net.mcreator.jackosbossifiedweaponsforge.item.GoldenShearsItem;
import net.mcreator.jackosbossifiedweaponsforge.item.EnchantedStarBottleItem;
import net.mcreator.jackosbossifiedweaponsforge.item.EnchantedNetheriteIngotItem;
import net.mcreator.jackosbossifiedweaponsforge.item.DiamondShearsItem;
import net.mcreator.jackosbossifiedweaponsforge.item.CatalystShearsItem;
import net.mcreator.jackosbossifiedweaponsforge.item.BossUpgradeTempItem;
import net.mcreator.jackosbossifiedweaponsforge.JackosBossifiedWeaponsForgeMod;

public class JackosBossifiedWeaponsForgeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JackosBossifiedWeaponsForgeMod.MODID);
	public static final RegistryObject<Item> WITHERING_HARVEST = REGISTRY.register("withering_harvest", () -> new WitheringHarvestItem());
	public static final RegistryObject<Item> ENCHANTED_STAR_BOTTLE = REGISTRY.register("enchanted_star_bottle", () -> new EnchantedStarBottleItem());
	public static final RegistryObject<Item> ENCHANTED_NETHERITE_INGOT = REGISTRY.register("enchanted_netherite_ingot", () -> new EnchantedNetheriteIngotItem());
	public static final RegistryObject<Item> BOSS_UPGRADE_TEMP = REGISTRY.register("boss_upgrade_temp", () -> new BossUpgradeTempItem());
	public static final RegistryObject<Item> CATALYST_SHEARS = REGISTRY.register("catalyst_shears", () -> new CatalystShearsItem());
	public static final RegistryObject<Item> GOLDEN_SHEARS = REGISTRY.register("golden_shears", () -> new GoldenShearsItem());
	public static final RegistryObject<Item> DIAMOND_SHEARS = REGISTRY.register("diamond_shears", () -> new DiamondShearsItem());
	public static final RegistryObject<Item> NETHERITE_SHEARS = REGISTRY.register("netherite_shears", () -> new NetheriteShearsItem());
	public static final RegistryObject<Item> WEATHERED_BONE = REGISTRY.register("weathered_bone", () -> new WeatheredBoneItem());
	public static final RegistryObject<Item> SCULKED_SHARD = REGISTRY.register("sculked_shard", () -> new SculkedShardItem());
	public static final RegistryObject<Item> SHEAR_UPGRADE_TEMPLATE = REGISTRY.register("shear_upgrade_template", () -> new ShearUpgradeTemplateItem());
}
