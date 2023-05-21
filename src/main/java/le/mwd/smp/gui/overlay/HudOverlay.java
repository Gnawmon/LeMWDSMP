
package le.mwd.smp.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber
public class HudOverlay {
	private static final String[] syllab = new String[]{"SIE", "LOH", "KII", "HUR", "MIS", "RUU", "VY", "KA", "TAV", "OLE", "PAH", "MUI", "MAT", "JA", "SAU", "NIN", "UD", "MU", "NGI", "BAR", "LUG", "MAH", "GIR", "AK", "USU", "ESE", "IRU", "UUN", "AMTU", "AGAS", "HI", "TOOI", "YORU", "NEN", "PON", "ONNA", "TSU", "YA", "AO", "ONI", "AN", "KO", "SHI", "YUME", "YARI", "TEST"};

	static String chunkName = "";
	private static int currentXchunk;
	private static int currentZchunk;
	static long areaTimer = 0L;
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				chunkName = GenerateChunkName(x /32, z /32);
				String versionString = "Le MWD SMP Mod:DEVELOPMENT PHASE 1.0.16.05_69 R4";
				Minecraft mc = Minecraft.getInstance();
				
				if(x /32 != currentXchunk || z /32 != currentZchunk) {
					chunkName = GenerateChunkName(x /32, z /32);
				}
				
			


				int shadowOffset = 1;
				
				areaTimer = System.currentTimeMillis();
				int chunkNameColor = (int)(255.0F * Math.max(1.0F - (float)Math.min(System.currentTimeMillis() - areaTimer, 5000L) / 5000.0F, 0.3F));

				mc.fontRenderer.drawString(event.getMatrixStack(), versionString, 2 + shadowOffset, 2 + shadowOffset, 1);
				mc.fontRenderer.drawString(event.getMatrixStack(), versionString, 2, 2, -1);	

				mc.fontRenderer.drawString(event.getMatrixStack(), chunkName, w / 2 + 80 + shadowOffset, 20 + shadowOffset,1);
				mc.fontRenderer.drawString(event.getMatrixStack(), chunkName, w / 2 + 80, 20, 0xFFFFFF + chunkNameColor * 16777216);
				
				
			}
		}
	
	
	}
	
	public static String GenerateChunkName(double d, double e) {
		long xchunk_butcooler = (long)(d + 392214);
		long zchunk_butcooler = (long)(e + 392214);
		long thirdnumber = zchunk_butcooler * 784428L + xchunk_butcooler;

		int i12 = (int)Math.sqrt((double)(d * d + e * e));
		int i13 = 0;
		int i14 = 3;

		for(int i15 = i12; i15 / i14 > 0; i14 *= 4) {
			++i13;
		}

		String thename = "";
		if(i13 > 0) {
			for(int i16 = 0; i16 != i13; ++i16) {
				thename = thename + syllab[(int)(((long)(i12 + i13 + i14) + thirdnumber * (long)(2 + i16)) % 45L)];
			}

			thename = thename + "-";
		}

		thename = thename + syllab[(int)((thirdnumber * 2L + (long)i12) % 45L)];
		thename = thename + syllab[(int)((thirdnumber * 3L + (long)i12) % 45L)];
		thename = thename + syllab[(int)((thirdnumber * 4L + (long)i12) % 45L)];
		return thename;
	}


	
}
