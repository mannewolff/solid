import static org.junit.Assert.*;

import org.junit.Test;

import de.neusta.solid.timer.Timer;
import de.neusta.solid.timer.TimerClient;


public class TestTimer {

	public class Client implements TimerClient {
		public boolean timedOut;
		public String timeout() {
			timedOut = true;
			return "Timer is timed out";
		}
	}
	
	@Test
	public void testRegisterTimer1000ms() throws Exception {
		Timer timer = new Timer();
		Client client = new Client();
		timer.register(1000, client);
		Thread.sleep(1100);
		assertTrue(client.timedOut);
	}
	
	@Test
	public void testNotTimedOut() throws Exception {
		Timer timer = new Timer();
		Client client = new Client();
		timer.register(1000, client);
		Thread.sleep(500);
		assertFalse(client.timedOut);
	}
}
