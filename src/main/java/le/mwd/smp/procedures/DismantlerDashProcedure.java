package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import le.mwd.smp.LeMwdSmpModVariables;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class DismantlerDashProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure DismantlerDash!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DismantlerDash!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double yaw = 0;
		double pitch = 0;
		double velocity = 0;
		{
			double _setval = (world.getWorldInfo().getDayTime());
			entity.getCapability(LeMwdSmpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DismantlerPressStart = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
