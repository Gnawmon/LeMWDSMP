
package le.mwd.smp.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import le.mwd.smp.block.CatCubeYouBlock;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class CatCubeItemGroup extends LeMwdSmpModElements.ModElement {
	public CatCubeItemGroup(LeMwdSmpModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcat_cube") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CatCubeYouBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
