
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import le.mwd.smp.itemgroup.AlphaverItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class ObsidianPickaxeItem extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:obsidian_pickaxe")
	public static final Item block = null;

	public ObsidianPickaxeItem(LeMwdSmpModElements instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObsidianIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(AlphaverItemGroup.tab)) {
		}.setRegistryName("obsidian_pickaxe"));
	}
}
