

import java.util.*;

/**
 * Aggregate root for a single career-fair run: stores timeline and current phase.
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
	void setTimes(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO - implement CareerFair.setTimes
		throw new UnsupportedOperationException();
	}

	/**
	 * True iff currentPhase == phase.
	 * @param phase
	 */
	boolean isInPhase(FairPhase phase) {
		// TODO - implement CareerFair.isInPhase
		throw new UnsupportedOperationException();
	}

	/**
	 * True iff booking actions are permitted at time now.
	 * @param now
	 */
	boolean canBook(LocalDateTime now) {
		// TODO - implement CareerFair.canBook
		throw new UnsupportedOperationException();
	}

	/**
	 * True iff the fair is live at time now.
	 * @param now
	 */
	boolean isLive(LocalDateTime now) {
		// TODO - implement CareerFair.isLive
		throw new UnsupportedOperationException();
	}

}