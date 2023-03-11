
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
public class AdminspaceConsoleGUIGuiWindow extends ContainerScreen<AdminspaceConsoleGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AdminspaceConsoleGUIGui.guistate;
	TextFieldWidget AdminspacePrompt;

	public AdminspaceConsoleGUIGuiWindow(AdminspaceConsoleGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("le_mwd_smp:textures/screens/adminspace_console_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		AdminspacePrompt.render(ms, mouseX, mouseY, partialTicks);
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("le_mwd_smp:textures/screens/bogulied.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 1, 0, 0, 256, 256, 256, 256);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (AdminspacePrompt.isFocused())
			return AdminspacePrompt.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		AdminspacePrompt.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Adminspace Console", 2, 3, -16777216);
		this.font.drawString(ms, "v2.0.84", 132, 3, -16777216);
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
		AdminspacePrompt = new TextFieldWidget(this.font, this.guiLeft + 26, this.guiTop + 24, 120, 20, new StringTextComponent(""));
		guistate.put("text:AdminspacePrompt", AdminspacePrompt);
		AdminspacePrompt.setMaxStringLength(32767);
		this.children.add(this.AdminspacePrompt);
		this.addButton(new Button(this.guiLeft + 56, this.guiTop + 139, 61, 20, new StringTextComponent("Execute"), e -> {
			if (true) {
				LeMwdSmpMod.PACKET_HANDLER.sendToServer(new AdminspaceConsoleGUIGui.ButtonPressedMessage(0, x, y, z));
				AdminspaceConsoleGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
