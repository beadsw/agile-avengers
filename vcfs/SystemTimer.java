package vcfs;
import java.time.LocalDateTime;
import static java.time.Month.JANUARY;
/**
 * Simulated clock device driving phase changes and session timing.
 */
public class SystemTimer {

    private CareerFairSystem system;
    //private SystemTimerScreen systemTimerScreen;
    private LocalDateTime sysTime;
    
    
        public SystemTimer(CareerFairSystem system) {
        this.system = system;
        sysTime = sysTime.of(2000, JANUARY, 01, 00, 00, 00);
    }

	/**
	 * Return current simulated time.
	 */
	LocalDateTime getNow() {
		return this.sysTime;
	}

	/**
	 * 
	 * @param mins
	 */
	public void stepMinutes(int mins) {
            // TODO - implement SystemTimer.stepMinutes
            sysTime = sysTime.plusMinutes(mins);
	}

	/**
	 * Set simulated time directly.
	 * @param time
	 */
	public void jumpTo(int year, int month,int day, int hour, int min) {
	// TODO - implement SystemTimer.jumpTo
            //int year = time.getYear();
            //int month = time.getMonthValue();
            //int dayOfMonth = time.getDayOfMonth();
            //int hour = time.getHour();
            //int minute = time.getMinute();
            
            sysTime = sysTime.of(year, month, day, hour, min);
        }

}