package vcfs;

/**
 * Audit trail item recording significant events (phase changes, bookings, cancellations, outcomes).
 */
public class AuditEntry {

	CareerFair fair;
	LocalDateTime timestamp;
	String eventType;

	/**
	 * Format the entry for display/export.
	 */
	String toString() {
		// TODO - implement AuditEntry.toString
		throw new UnsupportedOperationException();
	}

}