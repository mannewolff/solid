package de.neusta.solid.timer;

public class Timer {
	
	public class TimerThread implements Runnable {

		private int timeout;
		private TimerClient client;
		
		public TimerThread(int timeout, TimerClient client) {
			super();
			this.timeout = timeout;
			this.client = client;
		}
		
		public void run() {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
			}
			client.timeout();
		}
	}
	
	public void register(int timeout, TimerClient client) {
		TimerThread runnable = new TimerThread(timeout, client);
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
