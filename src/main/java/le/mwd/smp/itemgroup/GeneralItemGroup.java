
package le.mwd.smp.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class GeneralItemGroup extends LeMwdSmpModElements.ModElement {
	public GeneralItemGroup(LeMwdSmpModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgeneral") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.COMMAND_BLOCK);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
