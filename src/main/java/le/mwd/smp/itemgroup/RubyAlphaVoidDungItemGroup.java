
package le.mwd.smp.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import le.mwd.smp.block.ArgFansBlock;
import le.mwd.smp.LeMwdSmpModElements;

@LeMwdSmpModElements.ModElement.Tag
public class RubyAlphaVoidDungItemGroup extends LeMwdSmpModElements.ModElement {
	public RubyAlphaVoidDungItemGroup(LeMwdSmpModElements instance) {
		super(instance, 204);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabruby_alpha_void_dung") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ArgFansBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
