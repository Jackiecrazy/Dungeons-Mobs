package com.infamous.dungeons_mobs.interfaces;

import com.infamous.dungeons_mobs.entities.projectiles.CobwebProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public interface IWebShooter extends ITrapsTarget {

    boolean isWebShooting();

    void setWebShooting(boolean webShooting);

    static void shootWeb(MobEntity webShooter, LivingEntity target){
        double xDifference = target.getX() - webShooter.getX();
        double yDifference = target.getY(0.5D) - webShooter.getY(0.5D);
        double zDifference = target.getZ() - webShooter.getZ();
        float euclidDist = MathHelper.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);

        CobwebProjectileEntity cobwebProjectileEntity = new CobwebProjectileEntity(webShooter.level,
                webShooter,
                0,
                0,
                0);
        cobwebProjectileEntity.setPos(cobwebProjectileEntity.getX(),
                webShooter.getY(0.5D),
                cobwebProjectileEntity.getZ());
        cobwebProjectileEntity.shoot(xDifference, yDifference, zDifference, euclidDist, 0.0F);
        webShooter.level.addFreshEntity(cobwebProjectileEntity);
    }
}
