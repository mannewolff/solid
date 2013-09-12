package de.neusta.solid.timer;

/**
 * Interface for a timer client. The framework calls the method <code>timeout()</code> after the time is run.
 * 
 * @author mwolff
 *
 */
public interface TimerClient {

	/**
	 * Call back method to inform, that the time out is triggered.
	 * @return 
	 */
	String timeout();
}
