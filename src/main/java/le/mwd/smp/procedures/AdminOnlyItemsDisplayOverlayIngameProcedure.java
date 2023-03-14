package le.mwd.smp.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import le.mwd.smp.item.VoidKeyItem;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class AdminOnlyItemsDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure AdminOnlyItemsDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(VoidKeyItem.block)) : false;
	}
}
