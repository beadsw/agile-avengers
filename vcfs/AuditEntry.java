package vcfs;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Audit trail item recording significant events (phase changes, bookings, cancellations, outcomes).whats an outcome?
 */
public class AuditEntry {

	CareerFair fair;
	LocalDateTime timestamp;
	String eventType;

	/**
	 * Format the entry for display/export.
	 */
        @Override
	public String toString() {
            // TODO - implement AuditEntry.toString
            return "[" + timestamp + "] " + eventType;
	}
        
        //write to the auditLog text file
        public void writeToLog() throws IOException{//i dont understand how to call this like is it when changes occur? or called when bookings and stuff are made??
        //record  - textFile star.log equal number of spaces - fixed length fields**
            FileWriter addLog = new FileWriter("AuditLog.txt", true);
            addLog.write("\n" + toString());   
    }
        
        
        

}