

/**
 * Abstract base for all users (Candidate and Recruiter).
 */
public abstract class User {

	String id;
	String displayName;
	String email;

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

}