package com.infamous.dungeons_mobs.mod;

import com.infamous.dungeons_libraries.mobenchantments.MobEnchantment;
import com.infamous.dungeons_mobs.DungeonsMobs;
import com.infamous.dungeons_mobs.mobenchants.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class ModMobEnchantments {
    public static final DeferredRegister<MobEnchantment> MOB_ENCHANTMENTS_DEFERRED = DeferredRegister.create(MobEnchantment.class, DungeonsMobs.MODID);

    public static final RegistryObject<DoubleDamageMobEnchantment> DOUBLE_DAMAGE = MOB_ENCHANTMENTS_DEFERRED.register("double_damage", () -> new DoubleDamageMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<ProtectionMobEnchantment> PROTECTION = MOB_ENCHANTMENTS_DEFERRED.register("protection", () -> new ProtectionMobEnchantment(MobEnchantment.Rarity.COMMON));
    public static final RegistryObject<QuickMobEnchantment> QUICK = MOB_ENCHANTMENTS_DEFERRED.register("quick", () -> new QuickMobEnchantment(MobEnchantment.Rarity.COMMON));
    public static final RegistryObject<FireTrailMobEnchantment> FIRE_TRAIL = MOB_ENCHANTMENTS_DEFERRED.register("fire_trail", () -> new FireTrailMobEnchantment(MobEnchantment.Rarity.VERY_RARE));
    public static final RegistryObject<ThornsMobEnchantment> THORNS = MOB_ENCHANTMENTS_DEFERRED.register("thorns", () -> new ThornsMobEnchantment(MobEnchantment.Rarity.COMMON));
    public static final RegistryObject<DeflectMobEnchantment> DEFLECT = MOB_ENCHANTMENTS_DEFERRED.register("deflect", () -> new DeflectMobEnchantment(MobEnchantment.Rarity.UNCOMMON));
    public static final RegistryObject<RegenerationMobEnchantment> REGENERATION = MOB_ENCHANTMENTS_DEFERRED.register("regeneration", () -> new RegenerationMobEnchantment(MobEnchantment.Rarity.UNCOMMON));
    public static final RegistryObject<TempoTheftMobEnchantment> TEMPO_THEFT = MOB_ENCHANTMENTS_DEFERRED.register("tempo_theft", () -> new TempoTheftMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<MultishotMobEnchantment> MULTISHOT = MOB_ENCHANTMENTS_DEFERRED.register("multishot", () -> new MultishotMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<EchoMobEnchantment> ECHO = MOB_ENCHANTMENTS_DEFERRED.register("echo", () -> new EchoMobEnchantment(MobEnchantment.Rarity.VERY_RARE));
    public static final RegistryObject<LevitationShotMobEnchantment> LEVITATION_SHOT = MOB_ENCHANTMENTS_DEFERRED.register("levitation_shot", () -> new LevitationShotMobEnchantment(MobEnchantment.Rarity.VERY_RARE));
    public static final RegistryObject<RushMobEnchantment> RUSH = MOB_ENCHANTMENTS_DEFERRED.register("rush", () -> new RushMobEnchantment(MobEnchantment.Rarity.COMMON));
    public static final RegistryObject<BurningMobEnchantment> BURNING = MOB_ENCHANTMENTS_DEFERRED.register("burning", () -> new BurningMobEnchantment(MobEnchantment.Rarity.UNCOMMON));
    public static final RegistryObject<ChillingMobEnchantment> CHILLING = MOB_ENCHANTMENTS_DEFERRED.register("chilling", () -> new ChillingMobEnchantment(MobEnchantment.Rarity.UNCOMMON));
    public static final RegistryObject<GravityPulseMobEnchantment> GRAVITY_PULSE = MOB_ENCHANTMENTS_DEFERRED.register("gravity_pulse", () -> new GravityPulseMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<RadianceMobEnchantment> RADIANCE = MOB_ENCHANTMENTS_DEFERRED.register("radiance", () -> new RadianceMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<HealsAlliesMobEnchantment> HEALS_ALLIES = MOB_ENCHANTMENTS_DEFERRED.register("heals_allies", () -> new HealsAlliesMobEnchantment(MobEnchantment.Rarity.RARE));
    public static final RegistryObject<HugeMobEnchantment> HUGE = MOB_ENCHANTMENTS_DEFERRED.register("huge", () -> new HugeMobEnchantment(MobEnchantment.Rarity.VERY_RARE));
}
