
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import le.mwd.smp.itemgroup.GeneralItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class SteelRodItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:steel_rod")
	public static final Item block = null;

	public SteelRodItem(LeMwdSmpModElements instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GeneralItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("steel_rod");
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
