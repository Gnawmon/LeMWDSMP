package le.mwd.smp.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import le.mwd.smp.LeMwdSmpModVariables;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class AlphaverDashKeyOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency world for procedure AlphaverDashKeyOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency x for procedure AlphaverDashKeyOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency y for procedure AlphaverDashKeyOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency z for procedure AlphaverDashKeyOnKeyPressed!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure AlphaverDashKeyOnKeyPressed!");
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
		yaw = (entity.rotationYaw);
		pitch = (entity.rotationPitch);
		velocity = 7;
		if ((world.getWorldInfo().getDayTime() <= LeMwdSmpModVariables.MapVariables.get(world).AlphaverDashKeyLastPressTime
				|| world.getWorldInfo().getDayTime() > LeMwdSmpModVariables.MapVariables.get(world).AlphaverDashKeyLastPressTime + 60)
				&& !(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("le_mwd_smp:alphaverdash")),
						SoundCategory.PLAYERS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("le_mwd_smp:alphaverdash")),
						SoundCategory.PLAYERS, (float) 1, (float) 1, false);
			}
			LeMwdSmpModVariables.MapVariables.get(world).AlphaverDashKeyLastPressTime = (world.getWorldInfo().getDayTime());
			LeMwdSmpModVariables.MapVariables.get(world).syncData(world);
			entity.setMotion(
					(Math.sin((yaw / 180) * Math.PI) * (-1) * Math.cos((pitch / 180) * Math.PI) * Math.abs(entity.getMotion().getX()) * velocity),
					(Math.sin((pitch / 180) * Math.PI) * Math.abs(entity.getMotion().getY()) * velocity),
					(Math.cos((yaw / 180) * Math.PI) * Math.cos((pitch / 180) * Math.PI) * Math.abs(entity.getMotion().getZ()) * velocity));
			entity.fallDistance = (float) (0);
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("le_mwd_smp:alphaverdashrecharge")),
								SoundCategory.PLAYERS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("le_mwd_smp:alphaverdashrecharge")),
								SoundCategory.PLAYERS, (float) 1, (float) 1, false);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 60);
		}
	}
}
