package de.neusta.solid;

import de.neusta.solid.timer.Timer;
import de.neusta.solid.timer.TimerClient;

public class TimedDoor extends DefaultDoor implements TimerClient {

	private boolean alarm;

	@Override
	public void opening() {
		super.opening();
		registerDoor();
	}

	@Override
	public void closing() {
		super.closing();
		alarm = false;
	}

	public void timeout() {
		if (isDoorOpen())
			alarm = true;
	}

	public boolean isAlam() {
		return alarm;
	}

	private void registerDoor() {
		Timer timer = new Timer();
		timer.register(500, this);
	}

}
