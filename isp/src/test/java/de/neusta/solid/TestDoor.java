package de.neusta.solid;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import de.neusta.solid.timer.TimerClient;

public class TestDoor {

	private Door door = new DefaultDoor();

	@Test
	public void testDoorOpen() {
		door.opening();
		assertTrue(door.isDoorOpen());
	}
	
	@Test
	public void testDoorClose() throws Exception {
		door.closing();
		assertFalse(door.isDoorOpen());
	}

	@Test
	public void testIsTimerCLient() throws Exception {
		TimedDoor door = new TimedDoor();
		assertThat(door, CoreMatchers.instanceOf(TimerClient.class));
	}
	
	@Test
	public void testAlarmOn() throws Exception {
		TimedDoor door = new TimedDoor();
		door.opening();
		sleeping(600);
		assertTrue(door.isAlam());
	}

	private void sleeping(int timeout) throws InterruptedException {
		Thread.sleep(timeout);
	}

	@Test
	public void TestAlarmOff() throws Exception {
		TimedDoor door = new TimedDoor();
		door.opening();
		sleeping(300);
		assertFalse(door.isAlam());
	}

	@Test
	public void TestAlarmOffDoorShut() throws Exception {
		TimedDoor door = new TimedDoor();
		door.opening();
		door.closing();
		sleeping(600);
		assertFalse(door.isAlam());
	}

}
