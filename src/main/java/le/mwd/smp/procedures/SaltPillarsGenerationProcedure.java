package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import le.mwd.smp.block.SaltBlockBlock;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class SaltPillarsGenerationProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure SaltPillarsGeneration!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure SaltPillarsGeneration!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency y for procedure SaltPillarsGeneration!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure SaltPillarsGeneration!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() > 0.5) {
			world.setBlockState(new BlockPos(x, y + 1, z), SaltBlockBlock.block.getDefaultState(), 3);
			if (Math.random() > 0.5) {
				world.setBlockState(new BlockPos(x, y + 2, z), SaltBlockBlock.block.getDefaultState(), 3);
			}
		}
	}
}
