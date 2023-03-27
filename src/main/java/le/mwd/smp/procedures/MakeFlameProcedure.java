package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
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
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure MakeFlame!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.ADVENTURE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z))) {
				world.setBlockState(new BlockPos(x + 1, y, z), Blocks.FIRE.getDefaultState(), 3);
			}
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z + 1))) {
				world.setBlockState(new BlockPos(x + 1, y, z + 1), Blocks.FIRE.getDefaultState(), 3);
			}
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z + 2))) {
				world.setBlockState(new BlockPos(x + 1, y, z + 2), Blocks.FIRE.getDefaultState(), 3);
			}
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z + 3))) {
				world.setBlockState(new BlockPos(x + 1, y, z + 3), Blocks.FIRE.getDefaultState(), 3);
			}
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z + 4))) {
				world.setBlockState(new BlockPos(x + 1, y, z + 4), Blocks.FIRE.getDefaultState(), 3);
			}
			if (Blocks.FIRE.getDefaultState().isValidPosition(world, new BlockPos(x + 1, y, z + 5))) {
				world.setBlockState(new BlockPos(x + 1, y, z + 5), Blocks.FIRE.getDefaultState(), 3);
			}
		}
	}
}
