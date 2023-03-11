package le.mwd.smp.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import le.mwd.smp.LeMwdSmpMod;

import java.util.Map;
import java.util.HashMap;

public class GiveAdminPowersProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency entity for procedure GiveAdminPowers!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LeMwdSmpMod.LOGGER.warn("Failed to load dependency guistate for procedure GiveAdminPowers!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (("yes").equals((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:letextbar");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).toLowerCase())) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you were supposed to get op but i couldnt figure it out lol"),
						(false));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
	}
}
