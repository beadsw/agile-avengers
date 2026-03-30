/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Calum
 */

import java.time.LocalDateTime;

/**
 * Represents a message sent to a user about system events.
 */
public class Notification {

    User recipient;
    String message;
    LocalDateTime timestamp;

    /**
     * Create a notification.
     */
    public Notification(User recipient, String message, LocalDateTime timestamp) {
        if (recipient == null || message == null || timestamp == null) {
            throw new UnsupportedOperationException("Invalid notification data");
        }

        this.recipient = recipient;
        this.message = message;
        this.timestamp = timestamp;
    }

    /**
     * Format notification for display.
     */
    public String toString() {
        return "[" + timestamp + "] " + message;
    }
}