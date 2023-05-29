
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import le.mwd.smp.procedures.BreakBedrockProcedure;
import le.mwd.smp.LeMwdSmpModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@LeMwdSmpModElements.ModElement.Tag
public class EraserItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:eraser")
	public static final Item block = null;

	public EraserItem(LeMwdSmpModElements instance) {
		super(instance, 326);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(1024).rarity(Rarity.COMMON));
			setRegistryName("eraser");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 9999F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}

		@Override
		public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
			boolean retval = super.onEntitySwing(itemstack, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;

			BreakBedrockProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
