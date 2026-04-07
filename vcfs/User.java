package vcfs;
import java.util.*;
/**
 * Abstract base for all users (Candidate and Recruiter).
 * Stores shared user information and notifications
 */
public abstract class User {
    
        ArrayList<Notification> notifications;

	String id;
	String displayName;
	String email;
        
        // Constructor to initialise notification list
        public User(String displayName, String email) {
            this.notifications = new ArrayList<>();
            this.displayName = displayName;
            this.email = email;
        }

	/**
	 * Return the internal user id.
	 */
	String getId() {
		return this.id;
	}

	/**
	 * Return the user's unique email identifier.
	 */
	String getEmail() {
		return this.email;
	}
        
        /**
        * Add a notification to the user's inbox.
        */
        void addNotification(Notification notification) {
            if (notification == null) {
                throw new UnsupportedOperationException("Notification cannot be null");
            }
            notifications.add(notification);
        }

        /**
        * Retrieve all notifications for this user.
        */
        ArrayList<Notification> getNotifications() {
            return notifications;
        }
}