
package le.mwd.smp.itemgroup;

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
				return new ItemStack(CatCubeMeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
