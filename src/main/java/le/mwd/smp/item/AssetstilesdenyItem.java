
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import le.mwd.smp.itemgroup.TheBottomOfTheVoidItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class AssetstilesdenyItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:assetstilesdeny")
	public static final Item block = null;

	public AssetstilesdenyItem(LeMwdSmpModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheBottomOfTheVoidItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("assetstilesdeny");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
