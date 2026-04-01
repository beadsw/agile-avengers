package vcfs;

/**
 * Simulated clock device driving phase changes and session timing.
 */
public class SystemTimer {

	LocalDateTime now;

	/**
	 * Return current simulated time.
	 */
	LocalDateTime getNow() {
		return this.now;
	}

	/**
	 * 
	 * @param mins
	 */
	void stepMinutes(int mins) {
		// TODO - implement SystemTimer.stepMinutes
		throw new UnsupportedOperationException();
	}

	/**
	 * Set simulated time directly.
	 * @param time
	 */
	void jumpTo(LocalDateTime time) {
		// TODO - implement SystemTimer.jumpTo
		throw new UnsupportedOperationException();
	}

}