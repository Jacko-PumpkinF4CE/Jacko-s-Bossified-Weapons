
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jackosbossifiedweaponsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.jackosbossifiedweaponsforge.JackosBossifiedWeaponsForgeMod;

public class JackosBossifiedWeaponsForgeModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, JackosBossifiedWeaponsForgeMod.MODID);
	public static final RegistryObject<SimpleParticleType> WITHERING_SKULLS = REGISTRY.register("withering_skulls", () -> new SimpleParticleType(false));
}
