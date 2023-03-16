package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class FlowerAdditionalGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure FlowerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure FlowerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure FlowerAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, 62, z))).getBlock() == Blocks.WATER) {
			if (true) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
}
