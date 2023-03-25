
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import le.mwd.smp.itemgroup.AlphaverItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class ObsidianIngotItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:obsidian_ingot")
	public static final Item block = null;

	public ObsidianIngotItem(LeMwdSmpModElements instance) {
		super(instance, 133);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AlphaverItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("obsidian_ingot");
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
