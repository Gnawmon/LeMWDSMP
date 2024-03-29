package le.mwd.smp.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.CommandSource;

import le.mwd.smp.LeMwdSmpModVariables;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetLaughRoomProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure SetLaughRoom!");
			return;
		}
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency arguments for procedure SetLaughRoom!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure SetLaughRoom!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		LeMwdSmpModVariables.WorldVariables.get(world).LaughRoomPosX = (new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getBlockPos(arguments, "name").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX());
		LeMwdSmpModVariables.WorldVariables.get(world).syncData(world);
		LeMwdSmpModVariables.WorldVariables.get(world).LaughRoomPosY = (new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getBlockPos(arguments, "name").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY());
		LeMwdSmpModVariables.WorldVariables.get(world).syncData(world);
		LeMwdSmpModVariables.WorldVariables.get(world).LaughRoomPosZ = (new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getBlockPos(arguments, "name").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ());
		LeMwdSmpModVariables.WorldVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("Set laughrom to " + new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getBlockPos(arguments, "name").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX() + " " + new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getBlockPos(arguments, "name").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY() + " " + new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getBlockPos(arguments, "name").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ() + ".")), (false));
		}
	}
}
