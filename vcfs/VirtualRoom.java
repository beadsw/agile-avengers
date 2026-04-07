package vcfs;

import java.util.*;
import static vcfs.RoomState.*;

/**
 * Booth's persistent meeting room resource; reused across many MeetingSessions.
 */
public class VirtualRoom {

	Booth booth;
	Collection<MeetingSession> sessions;
	RoomState state;
        ArrayList<Candidate> occupants;

	/**
	 * Open the room for access (CLOSED → OPEN).
	 */
	void open() {
            if (state != OPEN)
            {state = OPEN;}
            
	}

	/**
	 * Close the room (clear occupants; set CLOSED).
	 */
	void close() {
            if (state != CLOSED)
            {
                occupants.clear();
                state = CLOSED;
            }

	}
        
        public void enter(Candidate cand)
        {
            state = IN_SESSION;
            occupants.add(cand);
        }
        
        public void leave(Candidate cand)
        {
            if (state == IN_SESSION)
            {occupants.remove(cand);}
        }
}
        

