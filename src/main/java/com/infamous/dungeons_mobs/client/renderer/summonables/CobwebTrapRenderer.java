package com.infamous.dungeons_mobs.client.renderer.summonables;

import com.infamous.dungeons_mobs.entities.projectiles.CobwebTrapEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class CobwebTrapRenderer extends EntityRenderer<CobwebTrapEntity> {
   public CobwebTrapRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowRadius = 0.5F;
   }

   public void render(CobwebTrapEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      BlockState blockstate = Blocks.COBWEB.defaultBlockState();
      if (blockstate.getRenderShape() == BlockRenderType.MODEL) {
         World world = entityIn.getCommandSenderWorld();
         if (blockstate != world.getBlockState(entityIn.blockPosition()) && blockstate.getRenderShape() != BlockRenderType.INVISIBLE) {
            matrixStackIn.pushPose();
            BlockPos blockpos = new BlockPos(entityIn.getX(), entityIn.getBoundingBox().maxY, entityIn.getZ());
            matrixStackIn.translate(-0.5D, 0.0D, -0.5D);
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
            for (net.minecraft.client.renderer.RenderType type : net.minecraft.client.renderer.RenderType.chunkBufferLayers()) {
               if (RenderTypeLookup.canRenderInLayer(blockstate, type)) {
                  net.minecraftforge.client.ForgeHooksClient.setRenderLayer(type);
                  blockrendererdispatcher
                          .getModelRenderer()
                          .tesselateBlock(world,
                                  blockrendererdispatcher.getBlockModel(blockstate),
                                  blockstate, blockpos, matrixStackIn, bufferIn.getBuffer(type), false, new Random(), blockstate.getSeed(entityIn.getOrigin()), OverlayTexture.NO_OVERLAY);
               }
            }
            net.minecraftforge.client.ForgeHooksClient.setRenderLayer(null);
            matrixStackIn.popPose();
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
         }
      }
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getTextureLocation(CobwebTrapEntity entity) {
      return AtlasTexture.LOCATION_BLOCKS;
   }
}