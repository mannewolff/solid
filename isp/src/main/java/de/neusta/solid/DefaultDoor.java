package de.neusta.solid;

public class DefaultDoor implements Door  {

	private boolean open;
	
	public void opening() {
		open = true;
	}

	public void closing() {
		open = false;
	}

	public boolean isDoorOpen() {
		return open;
	}
}
