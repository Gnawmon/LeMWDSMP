
package le.mwd.smp.gui.overlay;

import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

import le.mwd.smp.LeMwdSmpModVariables;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class AlphaverDashOverlayOverlay {

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
					GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {

			
				int dashTimer = (int) (world.getWorldInfo().getDayTime()
						- LeMwdSmpModVariables.MapVariables.get(world).AlphaverDashKeyLastPressTime);
				System.out.println(dashTimer);
				if (dashTimer < 60) {
					GuiUtils.drawGradientRect(event.getMatrixStack().getLast().getMatrix(), 1, w / 2 - 50 - 1,
							h - 90 - 1, w / 2 - 50 + 100 + 1, h - 90 + 5 + 1, -14671840, 0xFF000000);
					GuiUtils.drawGradientRect(event.getMatrixStack().getLast().getMatrix(), 2, w / 2 - 50, h - 90,
							w / 2 - 50 + (int) (100.0F * (1.0F - dashTimer / 60.0F)), h - 90 + 5, -3584, -13893888);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

}
