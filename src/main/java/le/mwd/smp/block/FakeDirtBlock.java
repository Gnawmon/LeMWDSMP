
package le.mwd.smp.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@LeMwdSmpModElements.ModElement.Tag
public class FakeDirtBlock extends LeMwdSmpModElements.ModElement {

	@ObjectHolder("le_mwd_smp:fake_dirt")
	public static final Block block = null;

	public FakeDirtBlock(LeMwdSmpModElements instance) {
		super(instance, 17);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(AlphaverItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(1f, 0f).setLightLevel(s -> 0));

			setRegistryName("fake_dirt");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
