
package le.mwd.smp.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import le.mwd.smp.itemgroup.JohnItemGroup;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class DiscNegative7Item extends LeMwdSmpModElements.ModElement {
	@ObjectHolder("le_mwd_smp:disc_negative_7")
	public static final Item block = null;

	public DiscNegative7Item(LeMwdSmpModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.crimson_forest.additions")),
					new Item.Properties().group(JohnItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("disc_negative_7");
		}
	}
}
