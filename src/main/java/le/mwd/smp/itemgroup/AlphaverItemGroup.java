
package le.mwd.smp.itemgroup;

@LeMwdSmpModElements.ModElement.Tag
public class AlphaverItemGroup extends LeMwdSmpModElements.ModElement {

	public AlphaverItemGroup(LeMwdSmpModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabalphaver") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChainBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
