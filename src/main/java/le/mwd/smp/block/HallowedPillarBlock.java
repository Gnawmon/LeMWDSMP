
package le.mwd.smp.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.EnumProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import le.mwd.smp.itemgroup.RubyAlphaVoidDungItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

import java.util.List;
import java.util.Collections;

@LeMwdSmpModElements.ModElement.Tag
public class HallowedPillarBlock extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:hallowed_pillar")
	public static final Block block = null;

	public HallowedPillarBlock(LeMwdSmpModElements instance) {
		super(instance, 300);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(RubyAlphaVoidDungItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.2f, 17.5f).setLightLevel(s -> 4)
					.harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool());
			this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y));
			setRegistryName("hallowed_pillar");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(AXIS);
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(AXIS, context.getFace().getAxis());
		}

		@Override
		public BlockState rotate(BlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((Direction.Axis) state.get(AXIS) == Direction.Axis.X) {
					return state.with(AXIS, Direction.Axis.Z);
				} else if ((Direction.Axis) state.get(AXIS) == Direction.Axis.Z) {
					return state.with(AXIS, Direction.Axis.X);
				}
			}
			return state;
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
