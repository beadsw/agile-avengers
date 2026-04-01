package vcfs;

import java.util.*;

/**
 * A company's presence at the fair; owns recruiters and a single VirtualRoom.
 */
public class Booth {

	Collection<Recruiter> recruiters;
	VirtualRoom room;
	Organization organization;
	String title;

	/**
	 * Assign a recruiter to this booth.
	 * @param recruiter
	 */
	void assignRecruiter(Recruiter recruiter) {
		// TODO - implement Booth.assignRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Unassign a recruiter from this booth.
	 * @param recruiter
	 */
	void removeRecruiter(Recruiter recruiter) {
		// TODO - implement Booth.removeRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the booth's virtual room.
	 */
	VirtualRoom getRoom() {
		return this.room;
	}

}