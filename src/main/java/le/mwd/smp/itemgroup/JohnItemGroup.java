
package le.mwd.smp.itemgroup;

@LeMwdSmpModElements.ModElement.Tag
public class JohnItemGroup extends LeMwdSmpModElements.ModElement {

	public JohnItemGroup(LeMwdSmpModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabjohn") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AuthorizerBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
