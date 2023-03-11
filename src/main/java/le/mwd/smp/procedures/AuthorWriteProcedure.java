package le.mwd.smp.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandSource;

import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class AuthorWriteProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure AuthorWrite!");
			return;
		}
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency arguments for procedure AuthorWrite!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent((StringArgumentType.getString(arguments, "text"))), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
