
package le.mwd.smp.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import le.mwd.smp.LeMwdSmpMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AffirmAdminGuiWindow extends ContainerScreen<AffirmAdminGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AffirmAdminGui.guistate;
	TextFieldWidget letextbar;

	public AffirmAdminGuiWindow(AffirmAdminGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 135;
		this.ySize = 124;
	}

	private static final ResourceLocation texture = new ResourceLocation("le_mwd_smp:textures/screens/affirm_admin.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		letextbar.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (letextbar.isFocused())
			return letextbar.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		letextbar.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Affirm?", 44, 6, -5789785);
		this.font.drawString(ms, "\"Yes\" or \"No\" to confirm.", 2, 62, -5789785);
		this.font.drawString(ms, "this doesn't work right now", -4, -17, -52429);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		letextbar = new TextFieldWidget(this.font, this.guiLeft + 7, this.guiTop + 73, 120, 20, new StringTextComponent(""));
		guistate.put("text:letextbar", letextbar);
		letextbar.setMaxStringLength(32767);
		this.children.add(this.letextbar);
		this.addButton(new Button(this.guiLeft + 33, this.guiTop + 96, 61, 20, new StringTextComponent("Confirm"), e -> {
			if (true) {
				LeMwdSmpMod.PACKET_HANDLER.sendToServer(new AffirmAdminGui.ButtonPressedMessage(0, x, y, z));
				AffirmAdminGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
