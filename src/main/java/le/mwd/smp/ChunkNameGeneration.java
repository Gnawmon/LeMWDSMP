package le.mwd.smp;

public class ChunkNameGeneration{
    private static final String[] syllab = new String[]{"SIE", "LOH", "KII", "HUR", "MIS", "RUU", "VY", "KA", "TAV", "OLE", "PAH", "MUI", "MAT", "JA", "SAU", "NIN", "UD", "MU", "NGI", "BAR", "LUG", "MAH", "GIR", "AK", "USU", "ESE", "IRU", "UUN", "AMTU", "AGAS", "HI", "TOOI", "YORU", "NEN", "PON", "ONNA", "TSU", "YA", "AO", "ONI", "AN", "KO", "SHI", "YUME", "YARI", "TEST"};
    public String GenerateChunkName(double chunkX, double chunkZ) {
		long xchunk_butcooler = (long)(chunkX + 392214);
		long zchunk_butcooler = (long)(chunkZ + 392214);
		long thirdnumber = zchunk_butcooler * 784428L + xchunk_butcooler;

		int i12 = (int)Math.sqrt((double)(chunkX * chunkX + chunkZ * chunkZ));
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
