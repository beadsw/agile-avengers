

import java.util.*;

/**
 * Booth's persistent meeting room resource; reused across many MeetingSessions.
 */
public class VirtualRoom {

	Booth booth;
	Collection<MeetingSession> sessions;
	RoomState state;

	/**
	 * Open the room for access (CLOSED → OPEN).
	 */
	void open() {
		// TODO - implement VirtualRoom.open
		throw new UnsupportedOperationException();
	}

	/**
	 * Close the room (clear occupants; set CLOSED).
	 */
	void close() {
		// TODO - implement VirtualRoom.close
		throw new UnsupportedOperationException();
	}

	/**
	 * Admit a candidate to the room.
	 * @param candidate
	 */
	void enter(Candidate candidate) {
		// TODO - implement VirtualRoom.enter
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a candidate from the room; may change state if empty.
	 * @param candidate
	 */
	void leave(Candidate candidate) {
		// TODO - implement VirtualRoom.leave
		throw new UnsupportedOperationException();
	}

}