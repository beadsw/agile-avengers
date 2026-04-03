package vcfs;
import java.time.LocalDateTime;
/**
 * Simulated clock device driving phase changes and session timing.
 */
public class SystemTimer {

    private CareerFairSystem system;
    //private SystemTimerScreen systemTimerScreen;
    LocalDateTime now;
    
        public SystemTimer(CareerFairSystem system) {
        this.system = system;
    }

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
	public void stepMinutes(int mins) {
            // TODO - implement SystemTimer.stepMinutes
            getNow().plusMinutes(mins);
	}

	/**
	 * Set simulated time directly.
	 * @param time
	 */
	public void jumpTo(LocalDateTime time) {
	// TODO - implement SystemTimer.jumpTo
            int year = time.getYear();
            int month = time.getMonthValue();
            int dayOfMonth = time.getDayOfMonth();
            int hour = time.getHour();
            int minute = time.getMinute();
            getNow().of(year, month, dayOfMonth, hour, minute);
        }

}