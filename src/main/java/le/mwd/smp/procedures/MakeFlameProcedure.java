package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class MakeFlameProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure MakeFlame!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure MakeFlame!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency y for procedure MakeFlame!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure MakeFlame!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		world.setBlockState(new BlockPos(x + 1, y, z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y, z + 1), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y, z + 2), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y, z + 3), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + -1, y, z + 4), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + -1, y, z + 5), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + -1, y, z + 5), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + -1, y, z + 5), Blocks.FIRE.getDefaultState(), 3);
	}
}
