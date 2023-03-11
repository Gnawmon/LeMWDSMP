package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import le.mwd.smp.item.DismantlerItem;
import le.mwd.smp.LeMwdSmpModVariables;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class DismantlerDashKeyOnKeyReleasedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double pitch = 0;
		double velocity = 0;
		double yaw = 0;
		yaw = (entity.rotationYaw);
		pitch = (entity.rotationPitch);
		velocity = (world.getWorldInfo().getDayTime() - (entity.getCapability(LeMwdSmpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LeMwdSmpModVariables.PlayerVariables())).DismantlerPressStart);
		if (DismantlerItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()
				|| DismantlerItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
			entity.setMotion((Math.sin((yaw / 180) * Math.PI) * (-1) * Math.cos((pitch / 180) * Math.PI) * velocity),
					(Math.sin((pitch / 180) * Math.PI) * (-1) * velocity),
					(Math.cos((yaw / 180) * Math.PI) * Math.cos((pitch / 180) * Math.PI) * velocity));
		}
	}
}
