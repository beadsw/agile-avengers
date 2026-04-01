package vcfs;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Aggregate root for a single career-fair run: stores timeline and current phase.
 * Responsible for managing timeline and system phase
 */
public class CareerFair {

	Collection<Organization> organizations;
	Collection<AuditEntry> auditTrail;
	CareerFairSystem system;
	String name;
	FairPhase currentPhase;
	LocalDateTime bookingsOpenTime;
	LocalDateTime bookingsCloseTime;
	LocalDateTime startTime;
	LocalDateTime endTime;

	/**
	 * Update the fair timeline. Validate chronological order.
	 * @param openTime
	 * @param closeTime
	 * @param startTime
	 * @param endTime
	 */
        
        /**
        * Set the timeline for the fair.
        * Ensures all times are valid and in correct chronological order.
        */
	void setTimes(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO - implement CareerFair.setTimes
                // Validate inputs
                if(openTime == null || closeTime == null || startTime == null || endTime == null){
                    throw new UnsupportedOperationException("Times cannot be null");
                }
                
                //Validation in chronological order
                if(!(openTime.isBefore(closeTime) && closeTime.isBefore(startTime) && startTime.isBefore(endTime))){
                    throw new UnsupportedOperationException("Invalid time order");
                }
                // Assign values
                this.bookingsOpenTime = openTime;
                this.bookingsCloseTime = closeTime;
                this.startTime = startTime;
                this.endTime = endTime;
                // Update phase initially to match new timeline
                // Update phase based on current system time
                if (system == null || system.timer == null) {
                    throw new UnsupportedOperationException("System timer not initialised");
                }
                //updatePhase(LocalDateTime.now());
                //updatePhase(system.timer.getNow());
                updatePhase(system.getCurrentTime());
	}
        
        /*
        *Update the currentPhase based on the given time
        *Keeps the fair's state consistent
        *@Param now - the current time to check phase against
        */
        // Added method updatePhase
        public void updatePhase(LocalDateTime now){
            if(now == null){
                throw new UnsupportedOperationException("Current time cannot be null");
            }
            if(now.isBefore(bookingsOpenTime)){
                currentPhase = FairPhase.PREPARING;
            } else if(!now.isAfter(bookingsCloseTime)){
                currentPhase = FairPhase.BOOKINGS_OPEN;
            } else if(now.isBefore(startTime)){
                currentPhase = FairPhase.BOOKINGS_CLOSED;
            } else if(!now.isAfter(endTime)){
                currentPhase = FairPhase.FAIR_LIVE;
            } else{
                currentPhase = FairPhase.DORMANT;
            }
        }

	/**
         * Checks if the fair is currently in the given place
	 * True iff currentPhase == phase.
	 * @param phase
	 */
	boolean isInPhase(FairPhase phase) {
            // TODO - implement CareerFair.isInPhase
            if(phase == null){
                throw new UnsupportedOperationException("Phase cannot be null");
            }
            return currentPhase == phase;    
	}

	/**
	 * True if booking actions are permitted at time now.
         * Updates the current phase before checking
	 * @param now
	 */
        // Check if booking is allowed
	boolean canBook(LocalDateTime now) {
            // TODO - implement CareerFair.canBook
            if(now == null){
                throw new UnsupportedOperationException("Current time cannot be null");
            }
            updatePhase(now);
            return currentPhase == FairPhase.BOOKINGS_OPEN;
	}

	/**
	 * True if the fair is live at time now.
         * Updates the current Phase before checking
	 * @param now
	 */
        // Check if fair is currently live
	boolean isLive(LocalDateTime now) {
            // TODO - implement CareerFair.isLive
            if(now == null){
                throw new UnsupportedOperationException("Current time cannot be null");
            }
            updatePhase(now);
            return currentPhase == FairPhase.FAIR_LIVE;
	}
        
        // Return currentPhase
        FairPhase getPhase() {
            return currentPhase;
        }
       
}