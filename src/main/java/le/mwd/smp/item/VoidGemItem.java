
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import le.mwd.smp.itemgroup.TheBottomOfTheVoidItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class VoidGemItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:void_gem")
	public static final Item block = null;

	public VoidGemItem(LeMwdSmpModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheBottomOfTheVoidItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("void_gem");
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
