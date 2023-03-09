
package le.mwd.smp.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import le.mwd.smp.itemgroup.CatCubeItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

import java.util.List;
import java.util.Collections;

@LeMwdSmpModElements.ModElement.Tag
public class CatCubeYouBlock extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:cat_cube_you")
	public static final Block block = null;

	public CatCubeYouBlock(LeMwdSmpModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(CatCubeItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOL).sound(SoundType.CLOTH).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));
			setRegistryName("cat_cube_you");
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
