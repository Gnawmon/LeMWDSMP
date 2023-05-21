package le.mwd.smp.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import le.mwd.smp.block.SaltBlockBlock;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class SaltPillarGenerationOnGeneratedProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure SaltPillarGenerationOnGenerated!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure SaltPillarGenerationOnGenerated!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency y for procedure SaltPillarGenerationOnGenerated!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure SaltPillarGenerationOnGenerated!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent((x + " " + y + " " + z)), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (Math.random() < 0.5) {
			world.setBlockState(new BlockPos(x, y + 1, z), SaltBlockBlock.block.getDefaultState(), 3);
			if (Math.random() < 0.5) {
				world.setBlockState(new BlockPos(x, y + 2, z), SaltBlockBlock.block.getDefaultState(), 3);
				if (Math.random() < 0.5) {
					world.setBlockState(new BlockPos(x, y + 3, z), SaltBlockBlock.block.getDefaultState(), 3);
				}
			}
		}
		return false;
	}
}
