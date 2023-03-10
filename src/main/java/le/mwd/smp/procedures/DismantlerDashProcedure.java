package le.mwd.smp.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
 

import le.mwd.smp.item.DismantlerItem;
import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;

public class DismantlerDashProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DismantlerDash!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DismantlerItem.block)) : false) {
			        float yaw = entity.rotationYaw;
        float pitch = entity.rotationPitch;
        float velocity = 10.0F;
        double motionX = -MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * velocity;
        double motionZ = MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * velocity;
        double motionY = -MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * velocity;
        entity.setMotion(motionX, motionY, motionZ);
		}
	}
}
