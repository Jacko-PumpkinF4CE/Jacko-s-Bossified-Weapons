package net.mcreator.jackosbossifiedweaponsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

// Import for ExperienceOrb to set the amount.
// While EntityType.EXPERIENCE_ORB.spawn() creates the orb entity,
// you might need to cast it or set its value later if you want to control the amount.
// For now, let's assume it spawns with a default value, or we'll add setting the amount.
import net.minecraft.world.entity.ExperienceOrb; // Added this back for potential future use or if EntityType.spawn returns a generic entity.

import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModItems;
import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModEnchantments;

public class CatalystShearsLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JackosBossifiedWeaponsForgeModItems.CATALYST_SHEARS.get()) {

            // --- AMPLIFY ENCHANTMENT LOGIC ---
            float xpDamage = 0.0f;
            float baseShearsDamage = 5.0f; // As confirmed, Sculk Shears have 5 base damage

            // Calculate magic damage based on player's experience level and Amplify enchantment
            if (sourceentity instanceof Player _plr) {
                // Check if AMPLIFY enchantment is present
                if (EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.AMPLIFY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
                    // With Amplify: Apply the 5 base damage plus a higher scaling from experience level
                    // Example: 5 base damage + (player_level * 0.5)
                    xpDamage = baseShearsDamage + (float) (_plr.experienceLevel * 0.2); // Boosted multiplier for Amplify
                } else {
                    // Without Amplify: Apply the 5 base damage plus standard scaling from experience level
                    // Example: 5 base damage + (player_level * 0.1)
                    xpDamage = baseShearsDamage + (float) (_plr.experienceLevel * 0.1); // Original multiplier
                }
            } else {
                // If the sourceentity is not a Player (e.g., a dispenser, another mod's entity),
                // apply only the base damage for consistency, or adjust as desired.
                xpDamage = baseShearsDamage;
            }

            // Apply the calculated magic damage
            // This 'hurt' call is what makes the magic damage happen.
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), xpDamage);


            // --- SIPHON ENCHANTMENT LOGIC ---
            if (EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.SIPHON.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
                // Check if the world is a ServerLevel to ensure proper entity spawning
                if (world instanceof ServerLevel _level) {
                    // Spawn an ExperienceOrb entity at the hit entity's location
                    // The 'spawn' method here returns the spawned entity.
                    // By default, ExperienceOrb spawned this way usually has 0 value,
                    // so we need to set its value.
                    Entity entityToSpawn = EntityType.EXPERIENCE_ORB.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);

                    if (entityToSpawn instanceof ExperienceOrb xpOrb) { // Check if it's an ExperienceOrb and cast
                        xpOrb.value = 5; // Set the amount of experience points this orb gives
                        xpOrb.setYRot(world.getRandom().nextFloat() * 360F); // Still good for rotation
                    }
                }
            }
        }
    }
}
