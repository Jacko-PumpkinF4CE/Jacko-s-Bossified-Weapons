
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jackosbossifiedweaponsforge.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.jackosbossifiedweaponsforge.JackosBossifiedWeaponsForgeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JackosBossifiedWeaponsForgeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JackosBossifiedWeaponsForgeMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(JackosBossifiedWeaponsForgeModItems.WITHERING_HARVEST.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.CATALYST_SHEARS.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.GOLDEN_SHEARS.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.DIAMOND_SHEARS.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.NETHERITE_SHEARS.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(JackosBossifiedWeaponsForgeModItems.ENCHANTED_STAR_BOTTLE.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.ENCHANTED_NETHERITE_INGOT.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.BOSS_UPGRADE_TEMP.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.WEATHERED_BONE.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.SCULKED_SHARD.get());
			tabData.accept(JackosBossifiedWeaponsForgeModItems.SHEAR_UPGRADE_TEMPLATE.get());
		}
	}
}
