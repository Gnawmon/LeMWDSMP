// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelalphaver_giant extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelalphaver_giant() {
		textureWidth = 384;
		textureHeight = 384;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -120.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-24.0F, -48.0F, -24.0F, 48.0F, 48.0F, 48.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -120.0F, 0.0F);
		Body.setTextureOffset(96, 96).addBox(-24.0F, 0.0F, -12.0F, 48.0F, 72.0F, 24.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-30.0F, -108.0F, 0.0F);
		RightArm.setTextureOffset(240, 96).addBox(-18.0F, -12.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(30.0F, -108.0F, 0.0F);
		LeftArm.setTextureOffset(240, 96).addBox(-6.0F, -12.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-11.4F, -48.0F, 0.0F);
		RightLeg.setTextureOffset(0, 96).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(11.4F, -48.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 96).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}