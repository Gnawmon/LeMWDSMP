
package le.mwd.smp.block;

import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

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

import le.mwd.smp.itemgroup.TheBottomOfTheVoidItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

import java.util.List;
import java.util.Collections;

@LeMwdSmpModElements.ModElement.Tag
public class BrightnessBlockBlock extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:brightness_block")
	public static final Block block = null;

	public BrightnessBlockBlock(LeMwdSmpModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TheBottomOfTheVoidItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
		public CustomBlock() {
			super(Block.Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.GLASS).hardnessAndResistance(5f, 10f).setLightLevel(s -> 15)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("brightness_block");
		}

		public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
			if (!worldIn.isRemote) {
				boolean flag = state.get(LIT);
				if (flag != worldIn.isBlockPowered(pos)) {
					if (flag) {
						worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
					} else {
						worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
					}
				}

			}
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
