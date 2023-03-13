package le.mwd.smp.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class NormalInfusedFlowerHarmProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure NormalInfusedFlowerHarm!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity)) {
			if (!(entity instanceof ServerPlayerEntity)) {
				entity.attackEntityFrom(DamageSource.IN_FIRE, (float) 4);
			}
		}
	}
}
