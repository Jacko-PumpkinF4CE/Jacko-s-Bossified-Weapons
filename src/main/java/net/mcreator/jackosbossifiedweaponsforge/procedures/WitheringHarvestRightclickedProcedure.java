package net.mcreator.jackosbossifiedweaponsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.jackosbossifiedweaponsforge.init.JackosBossifiedWeaponsForgeModEnchantments;
import net.mcreator.jackosbossifiedweaponsforge.JackosBossifiedWeaponsForgeMod;


import java.util.Comparator;
import java.util.List;

public class WitheringHarvestRightclickedProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        Player player = null;
        if (entity instanceof Player) {
            player = (Player) entity;
        }

        // --- Skull Shot Ability Code (unchanged) ---
        if (player != null && !player.getCooldowns().isOnCooldown(itemstack.getItem())
                && EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.SKULL_SHOT.get(), itemstack) != 0) {

            {
                Entity _shootFrom = entity;
                Level projectileLevel = _shootFrom.level();
                if (!projectileLevel.isClientSide()) {
                    Projectile _entityToSpawn = new Object() {
                        public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
                            AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
                            entityToSpawn.setOwner(shooter);
                            entityToSpawn.xPower = ax;
                            entityToSpawn.yPower = ay;
                            entityToSpawn.zPower = az;
                            return entityToSpawn;
                        }
                    }.getFireball(projectileLevel, entity, (entity.getLookAngle().x), 0, (entity.getLookAngle().z));
                    _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                    _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                    projectileLevel.addFreshEntity(_entityToSpawn);
                }
            }
            JackosBossifiedWeaponsForgeMod.queueServerWork(10, () -> {
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
                                AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.xPower = ax;
                                entityToSpawn.yPower = ay;
                                entityToSpawn.zPower = az;
                                return entityToSpawn;
                            }
                        }.getFireball(projectileLevel, entity, (entity.getLookAngle().x), 0, (entity.getLookAngle().z));
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            });
            JackosBossifiedWeaponsForgeMod.queueServerWork(20, () -> {
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
                                AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.xPower = ax;
                                entityToSpawn.yPower = ay;
                                entityToSpawn.zPower = az;
                                return entityToSpawn;
                            }
                        }.getFireball(projectileLevel, entity, (entity.getLookAngle().x), 0, (entity.getLookAngle().z));
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            });
            JackosBossifiedWeaponsForgeMod.queueServerWork(30, () -> {
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        WitherSkull actualWitherSkull = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
                        actualWitherSkull.setOwner(_shootFrom);
                        actualWitherSkull.xPower = _shootFrom.getLookAngle().x;
                        actualWitherSkull.yPower = _shootFrom.getLookAngle().y;
                        actualWitherSkull.zPower = _shootFrom.getLookAngle().z;
                        actualWitherSkull.setDangerous(true);
                        Projectile _entityToSpawn = actualWitherSkull;
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            });

            if (player != null) {
                player.getCooldowns().addCooldown(itemstack.getItem(), 100);
                itemstack.hurtAndBreak(5, player, (playerEntity) -> playerEntity.broadcastBreakEvent(playerEntity.getUsedItemHand()));
            }
        }
        // --- NEW: Withered Slashing Ability ---
          else if (player != null && !player.getCooldowns().isOnCooldown(itemstack.getItem())
                && EnchantmentHelper.getItemEnchantmentLevel(JackosBossifiedWeaponsForgeModEnchantments.WITHERED_SLASHING.get(), itemstack) != 0) {

            if (world instanceof ServerLevel _level) { // Ensure on server side
                // Starts at eye level, then moves slightly forward along the player's look direction
                double forwardOffset = 0.5; // Adjust this value (in blocks) as needed for comfort
                Vec3 playerPos = entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getLookAngle().scale(forwardOffset));

                Vec3 lookVec = entity.getLookAngle(); // Player's forward direction (this is the axis of rotation for the tilt)
                double range = 15.0;

                // --- Calculate the initial vector representing the width of the slash ---
                Vec3 initialPerpendicularVec;
                if (Math.abs(lookVec.x) < 0.001 && Math.abs(lookVec.z) < 0.001) {
                    initialPerpendicularVec = lookVec.cross(new Vec3(1, 0, 0)).normalize();
                } else {
                    initialPerpendicularVec = lookVec.cross(new Vec3(0, 1, 0)).normalize();
                }

                // --- CHANGED: Randomly tilt the horizontal line of particles around the look direction (more intense) ---
                // Generates a random angle between -30 and +30 degrees (adjusted '40' to '60')
                double tiltAngle = (Math.random() - 0.5) * 60; // <<< THIS VALUE WAS CHANGED
                double tiltRadians = Math.toRadians(tiltAngle);

                // Apply Rodrigues' Rotation Formula to rotate initialPerpendicularVec around lookVec
                Vec3 perpendicularVec = initialPerpendicularVec
                    .scale(Math.cos(tiltRadians))
                    .add(lookVec.cross(initialPerpendicularVec).scale(Math.sin(tiltRadians)))
                    .add(lookVec.scale(lookVec.dot(initialPerpendicularVec) * (1 - Math.cos(tiltRadians))));

                perpendicularVec = perpendicularVec.normalize();
                // --- End Tilt Logic ---

                double slashWidth = 2.4;
                int numParticlesPerStep = 7;

                // Iterate along the player's look direction
                for (double d = 0; d <= range; d += 0.7) {
                    Vec3 centerOfSlashStep = playerPos.add(lookVec.scale(d));

                    // Iterate to spawn particles across the width of the slash
                    for (int i = 0; i < numParticlesPerStep; i++) {
                        double offset = (i / (double)(numParticlesPerStep - 1)) * slashWidth - (slashWidth / 2.0);
                        Vec3 particleSpawnPos = centerOfSlashStep.add(perpendicularVec.scale(offset));

                        _level.sendParticles(ParticleTypes.SCRAPE,
                                particleSpawnPos.x, particleSpawnPos.y, particleSpawnPos.z, 1,
                                0.0, 0.0, 0.0,
                                0.0);
                    }

                    // Check for entities in a wider box around the current center of the slash step
                    double searchBoxHalfWidth = (slashWidth / 2.0) + 0.5;
                    AABB searchBox = new AABB(
                            centerOfSlashStep.x - searchBoxHalfWidth, centerOfSlashStep.y - searchBoxHalfWidth, centerOfSlashStep.z - searchBoxHalfWidth,
                            centerOfSlashStep.x + searchBoxHalfWidth, centerOfSlashStep.y + searchBoxHalfWidth, centerOfSlashStep.z + searchBoxHalfWidth
                        );

                    List<Entity> entitiesInArea = world.getEntitiesOfClass(Entity.class, searchBox, (e) -> e != entity && e instanceof LivingEntity);

                    for (Entity targetEntity : entitiesInArea) {
                        LivingEntity livingTarget = (LivingEntity) targetEntity;

                        DamageSource slashDamageSource = _level.damageSources().mobAttack(player);
                        livingTarget.hurt(slashDamageSource, 10.0F);

                        if (!livingTarget.hasEffect(MobEffects.WITHER) || (livingTarget.getEffect(MobEffects.WITHER) != null && livingTarget.getEffect(MobEffects.WITHER).getAmplifier() < 1)) {
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 1, false, true));
                        }
                        if (!livingTarget.hasEffect(MobEffects.WEAKNESS) || (livingTarget.getEffect(MobEffects.WEAKNESS) != null && livingTarget.getEffect(MobEffects.WEAKNESS).getAmplifier() < 1)) {
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 1, false, true));
                        }
                    }
                }
                player.getCooldowns().addCooldown(itemstack.getItem(), 80);
                itemstack.hurtAndBreak(3, player, (playerEntity) -> playerEntity.broadcastBreakEvent(playerEntity.getUsedItemHand()));
            }
        }
    }
}