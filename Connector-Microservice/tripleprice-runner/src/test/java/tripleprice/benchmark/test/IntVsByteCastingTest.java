package tripleprice.benchmark.test;

import org.junit.Test;

public class IntVsByteCastingTest {

	private static final int MAX_LOOP = 100000000;

	/**
	 * Conclusion : not different time speed
	 */
	@Test
	public void runIntTest() {
		long startTime = System.currentTimeMillis();
		int objectTest = 1;
		for (int a = 0; a < MAX_LOOP; a++) {
			byte casting = (byte) objectTest;
		}
		long durationTime = System.currentTimeMillis() - startTime;
		System.out.println("Finish time :" + durationTime);
	}

	@Test
	public void runByteTest() {
		long startTime = System.currentTimeMillis();
		int objectTest = 1;
		for (int a = 0; a < MAX_LOOP; a++) {
			int casting = objectTest;
		}
		long durationTime = System.currentTimeMillis() - startTime;
		System.out.println("Finish time :" + durationTime);
	}
}
