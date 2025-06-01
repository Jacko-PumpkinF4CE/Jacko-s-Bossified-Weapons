
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jackosbossifiedweaponsforge.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.jackosbossifiedweaponsforge.client.particle.WitheringSkullsParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JackosBossifiedWeaponsForgeModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(JackosBossifiedWeaponsForgeModParticleTypes.WITHERING_SKULLS.get(), WitheringSkullsParticle::provider);
	}
}
