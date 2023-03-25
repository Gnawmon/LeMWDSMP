
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import le.mwd.smp.itemgroup.AlphaverItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class ObsidianHoeItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:obsidian_hoe")
	public static final Item block = null;

	public ObsidianHoeItem(LeMwdSmpModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObsidianIngotItem.block));
			}
		}, 0, -3f, new Item.Properties().group(AlphaverItemGroup.tab)) {
		}.setRegistryName("obsidian_hoe"));
	}
}
