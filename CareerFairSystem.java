
import java.time.LocalDateTime;
/**
 * Application façade..  central access point for all system operations
 */
public class CareerFairSystem {

	CareerFair fair;
        SystemTimer timer;

	/**
	 * Admin: validate and set the fair timeline.
	 * @param openTime
	 * @param closeTime
	 * @param startTime
	 * @param endTime
	 */
	void configureTimes(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO - implement CareerFairSystem.configureTimes
		throw new UnsupportedOperationException();
	}

	/**
	 * Admin: clear in-memory fair data for a fresh run.
	 */
	void resetFairData() {
		// TODO - implement CareerFairSystem.resetFairData
		throw new UnsupportedOperationException();
	}

	/**
	 * Admin: create/register a participating organization.
	 * @param name
	 */
	Organization addOrganization(String name) {
		// TODO - implement CareerFairSystem.addOrganization
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param org
	 * @param title
	 */
        
        /**
        * Create a booth for an organisation and attach a virtual room
        */
	Booth addBooth(Organization org, String title) {
            // TODO - implement CareerFairSystem.addBooth
            // Validate input parameters
            if(org == null || title == null){    
                throw new UnsupportedOperationException("Invalid input, cannot be null");
            }
            //Create booth and initialse basic fields
            Booth booth = new Booth();
            booth.organization = org;
            booth.title = title;
            booth.recruiters = new java.util.ArrayList<>();
            
            // Each booth owns one virtual room
            VirtualRoom room = new VirtualRoom();
            room.booth = booth;
            room.state = RoomState.CLOSED;
            room.sessions = new java.util.ArrayList<>();
            
            booth.room = room;
            org.addBooth(booth); // Link booth to organisation
            
            return booth;
	}

	/**
	 * Create recruiter and assign to booth (unique email enforced).
	 * @param displayName
	 * @param email
	 * @param booth
	 */
	Recruiter registerRecruiter(String displayName, String email, Booth booth) {
		// TODO - implement CareerFairSystem.registerRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Create candidate and profile (unique email enforced).
	 * @param displayName
	 * @param email
	 * @param cvSummary
	 * @param interestTags
	 */
	Candidate registerCandidate(String displayName, String email, String cvSummary, String interestTags) {
		// TODO - implement CareerFairSystem.registerCandidate
		throw new UnsupportedOperationException();
	}

	/**
	 * Register a recruiter-owned offer; check phase/policy.
	 * @param recruiter
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	Offer publishOffer(Recruiter recruiter, String title, int durationMins, String topicTags, int capacity) {
		// TODO - implement CareerFairSystem.publishOffer
		throw new UnsupportedOperationException();
	}

	/**
	 * Register a candidate request; check phase/policy.
	 * @param candidate
	 * @param desiredTags
	 * @param preferredOrgs
	 * @param maxAppointments
	 */
	Request createRequest(Candidate candidate, String desiredTags, String preferredOrgs, int maxAppointments) {
		// TODO - implement CareerFairSystem.createRequest
		throw new UnsupportedOperationException();
	}

	/**
	 * Create a CONFIRMED reservation at selected time (availability+validation mechanisms to be designed by groups).
	 * @param candidate
	 * @param offer
	 * @param start
	 */
        
        /**
        * Manually create a confirmed booking for a candidate.
        */
	Reservation manualBook(Candidate candidate, Offer offer, LocalDateTime start) {
            // TODO - implement CareerFairSystem.manualBook
            //  Validate inputs
            if (candidate == null || offer == null || start == null) {
                throw new UnsupportedOperationException("Invalid input");
            }

            // Booking only allowed when bookings are open, during BOOKINGS_OPEN phase
            if (!fair.canBook(start)) {
                throw new UnsupportedOperationException("Bookings are not open");
            }

            // Create reservation object
            Reservation reservation = new Reservation();
            reservation.candidate = candidate;
            reservation.offer = offer;
            reservation.scheduledStart = start;
            reservation.scheduledEnd = start.plusMinutes(offer.getDurationMins());
            reservation.state = ReservationState.CONFIRMED;
            
            //Create associated meeting session
            MeetingSession session = new MeetingSession();
            session.reservation = reservation;
            session.state = MeetingState.WAITING;
            
            reservation.session = session;
            
            // Link objects, reservation to candidate and offer
            candidate.reservations.add(reservation);
            offer.reservations.add(reservation);
            
            LocalDateTime now = timer.getNow();

            // Notify candidate
            Notification candidateNote = new Notification(candidate,"Booking confirmed for offer '" + offer.title + "' at " + start, now);
            candidate.addNotification(candidateNote);

            // Notify recruiter (offer publisher)
            Recruiter recruiter = offer.publisher;

            if (recruiter != null) {
                Notification recruiterNote = new Notification(recruiter, "New booking from " + candidate.displayName + " for offer '" + offer.title + "' at " + start, now);
                recruiter.addNotification(recruiterNote);
            }
            return reservation;
	}

	/**
	 * Automatically find and book a CONFIRMED reservation (matching+availability mechanisms to be designed by groups).
	 * @param candidate
	 * @param request
	 */
        
        /**
        * Automatically find and create a booking based on a request
        * Simplest implementation, first available offer
        */
	Reservation autoBook(Candidate candidate, Request request) {
            // TODO - implement CareerFairSystem.autoBook
            // Validate inputs
            if (candidate == null || request == null) {
                throw new UnsupportedOperationException("Invalid input");
            }

            //finds the first available offer
            // Iterate through all organisations, booths, recruiters and offers
            for(Organization org : fair.organizations){
                for(Booth booth : org.booths){
                    for(Recruiter recruiter : booth.recruiters){
                        for(Offer offer : recruiter.offers){
                            LocalDateTime time = fair.bookingsOpenTime; // Use earliest booking time as a simple strategy
                            // Only book if valid booking phase
                            if(fair.canBook(time)){
                                return manualBook(candidate, offer, time);
                            }
                        }
                    }
                }
            }
            // No valid booking found
            throw new UnsupportedOperationException("No available offers");
	}

	/**
	 * Cancel as recruiter; record audit and publish events.
	 * @param recruiter
	 * @param reservationId
	 * @param reason
	 */
	void cancelAsRecruiter(Recruiter recruiter, String reservationId, String reason) {
		// TODO - implement CareerFairSystem.cancelAsRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Cancel as candidate; record audit and publish events.
	 * @param candidate
	 * @param reservationId
	 */
	void cancelAsCandidate(Candidate candidate, String reservationId) {
		// TODO - implement CareerFairSystem.cancelAsCandidate
		throw new UnsupportedOperationException();
	}

	/**
	 * Join logic: lobby vs room; ensure MeetingSession exists; record attendance.
	 * @param candidate
	 * @param reservationId
	 */
	void joinSession(Candidate candidate, String reservationId) {
		// TODO - implement CareerFairSystem.joinSession
		throw new UnsupportedOperationException();
	}

	/**
	 * Advance time-based behaviour: phase transitions and session start/end.
	 */
        
        /**
        * Advance system behaviour based on simulated time.
        * Updates the fair phase using the SystemTimer.
        */
	void tick() {
            // TODO - implement CareerFairSystem.tick
            if (fair == null || timer == null) {
                throw new UnsupportedOperationException("Fair not initialised");
            }
            
            // Get current simulated time
            LocalDateTime now = timer.getNow();
            // Trigger phase update inside CareerFair
            // Update fair phase based on time
            fair.updatePhase(now);  // this internally calls updatePhase(now)
	}

	/**
	 * Query for UI to display system status.
	 */
        
        /**
        * Return current phase for UI display.
        */
	FairPhase getCurrentPhase() {
            // TODO - implement CareerFairSystem.getCurrentPhase
            if (fair == null) {
                throw new UnsupportedOperationException("Fair not initialized");
            }
            return fair.getPhase();
	}
        
        LocalDateTime getCurrentTime() {
            if (timer == null) {
                throw new UnsupportedOperationException("Timer not initialised");
            }
            return timer.getNow();
        }

}