
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import le.mwd.smp.procedures.BreakBedrockProcedure;
import le.mwd.smp.itemgroup.AlphaverItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

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
			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				BreakBedrockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
						new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("obsidian_pickaxe"));
	}
}
