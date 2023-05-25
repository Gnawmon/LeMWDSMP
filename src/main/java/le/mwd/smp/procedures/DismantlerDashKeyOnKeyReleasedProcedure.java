package le.mwd.smp.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
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
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency y for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DismantlerDashKeyOnKeyReleased!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double pitch = 0;
		double velocity = 0;
		double yaw = 0;
		double maxValue = 0;
		yaw = (entity.rotationYaw);
		pitch = (entity.rotationPitch);
		velocity = (world.getWorldInfo().getDayTime() - (entity.getCapability(LeMwdSmpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LeMwdSmpModVariables.PlayerVariables())).DismantlerPressStart);
		maxValue = 10;
		if (DismantlerItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()
				|| DismantlerItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
			entity.setMotion(
					(Math.sin((entity.rotationYaw / 180) * Math.PI) * (-1) * Math.cos((entity.rotationPitch / 180) * Math.PI)
							* (Math.abs(entity.getMotion().getX()) + velocity)),
					(Math.sin((entity.rotationPitch / 180) * Math.PI) * (Math.abs(entity.getMotion().getY()) + velocity) * (-1)),
					(Math.cos((entity.rotationYaw / 180) * Math.PI) * Math.cos((entity.rotationPitch / 180) * Math.PI)
							* (Math.abs(entity.getMotion().getZ()) + velocity)));
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("le_mwd_smp:dismantlerdash")),
						SoundCategory.PLAYERS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("le_mwd_smp:dismantlerdash")),
						SoundCategory.PLAYERS, (float) 1, (float) 1, false);
			}
		}
	}
}
