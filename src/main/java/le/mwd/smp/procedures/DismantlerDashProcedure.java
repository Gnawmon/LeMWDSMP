package le.mwd.smp.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import le.mwd.smp.item.DismantlerItem;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class DismantlerDashProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DismantlerDash!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double yaw = 0;
		double pitch = 0;
		double velocity = 0;
		yaw = (entity.rotationYaw);
		pitch = (entity.rotationPitch);
		velocity = 10;
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DismantlerItem.block)) : false) {
			entity.setMotion((Math.sin((yaw / 180) * Math.PI) * (-1) * Math.cos((pitch / 180) * Math.PI) * velocity),
					(Math.sin((pitch / 180) * Math.PI) * (-1) * velocity),
					(Math.cos((yaw / 180) * Math.PI) * Math.cos((pitch / 180) * Math.PI) * velocity));
		}
	}
}
