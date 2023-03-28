
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import le.mwd.smp.itemgroup.AlphaverItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class FryshroomItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:fryshroom")
	public static final Item block = null;

	public FryshroomItem(LeMwdSmpModElements instance) {
		super(instance, 155);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AlphaverItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f)

							.build()));
			setRegistryName("fryshroom");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
