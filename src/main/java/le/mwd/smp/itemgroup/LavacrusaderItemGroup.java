
package le.mwd.smp.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import le.mwd.smp.block.TheUniverseBlockBlock;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class LavacrusaderItemGroup extends LeMwdSmpModElements.ModElement {
	public LavacrusaderItemGroup(LeMwdSmpModElements instance) {
		super(instance, 117);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablavacrusader") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TheUniverseBlockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
