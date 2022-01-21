package com.infamous.dungeons_mobs.data;

import com.infamous.dungeons_libraries.capabilities.enchantable.EnchantableHelper;
import com.infamous.dungeons_libraries.capabilities.enchantable.IEnchantable;
import com.infamous.dungeons_mobs.DungeonsMobs;
import com.infamous.dungeons_mobs.data.util.MergeableCodecDataManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = DungeonsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AncientDataHelper {

    public static final MergeableCodecDataManager<MobAncientData, MobAncientData> MOB_ANCIENT_DATA = new MergeableCodecDataManager<>("ancient/mob_ancient_data", DungeonsMobs.LOGGER, MobAncientData.CODEC, AncientDataHelper::mobMerger);
    public static final MergeableCodecDataManager<MobEnchantmentAncientData, MobEnchantmentAncientData> MOB_ENCHANTMENT_ANCIENT_DATA = new MergeableCodecDataManager<>("ancient/mob_enchantment_ancient_data", DungeonsMobs.LOGGER, MobEnchantmentAncientData.CODEC, AncientDataHelper::mobEnchantmentMerger);

    public static MobAncientData mobMerger(List<MobAncientData> raws){
        List<String> adjectives = new ArrayList<>();
        List<String> nouns = new ArrayList<>();
        List<ResourceLocation> minions = new ArrayList<>();
        List<UniqueAncientData> uniques = new ArrayList<>();
        raws.forEach(raw -> {
            adjectives.addAll(raw.getAdjectives());
            nouns.addAll(raw.getNouns());
            minions.addAll(raw.getMinions());
            uniques.addAll(raw.getUniques());
        });
        return new MobAncientData(adjectives, nouns, minions, uniques);
    }
    public static MobEnchantmentAncientData mobEnchantmentMerger(List<MobEnchantmentAncientData> raws){
        List<String> adjectives = new ArrayList<>();
        List<String> nouns = new ArrayList<>();
        raws.forEach(raw -> {
            adjectives.addAll(raw.getAdjectives());
            nouns.addAll(raw.getNouns());
        });
        return new MobEnchantmentAncientData(adjectives, nouns);
    }

    public static MobAncientData getMobAncientData(ResourceLocation mobResourceLocation){

        return MOB_ANCIENT_DATA.data.getOrDefault(mobResourceLocation, MobAncientData.DEFAULT);
    }

    public static MobEnchantmentAncientData getMobEnchantmentAncientData(ResourceLocation mobEnchantmentResourceLocation){
        return MOB_ENCHANTMENT_ANCIENT_DATA.data.getOrDefault(mobEnchantmentResourceLocation, MobEnchantmentAncientData.DEFAULT);
    }

    public static String getAncientName(LivingEntity entity){
        Set<String> adjectives = new HashSet<>();
        Set<String> nouns = new HashSet<>();
        IEnchantable enchantCap = EnchantableHelper.getEnchantableCapability(entity);
        enchantCap.getEnchantments().forEach(mobEnchantment -> {
            MobEnchantmentAncientData mobEnchantmentAncientData = getMobEnchantmentAncientData(mobEnchantment.getRegistryName());
            adjectives.addAll(mobEnchantmentAncientData.getAdjectives());
            nouns.addAll(mobEnchantmentAncientData.getNouns());
        });
        MobAncientData mobAncientData = getMobAncientData(entity.getType().getRegistryName());
        adjectives.addAll(mobAncientData.getAdjectives());
        nouns.addAll(mobAncientData.getNouns());
//        adjectives.addAll(MobAncientData.DEFAULT.getAdjectives());
//        nouns.addAll(MobAncientData.DEFAULT.getNouns());
        return new ArrayList<>(adjectives).get(entity.getRandom().nextInt(adjectives.size())) + " " + new ArrayList<>(nouns).get(entity.getRandom().nextInt(nouns.size()));
    }

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event)
    {
        event.addListener(MOB_ANCIENT_DATA);
    }
}
