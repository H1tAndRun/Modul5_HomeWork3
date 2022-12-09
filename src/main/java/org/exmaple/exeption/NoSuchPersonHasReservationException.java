package org.exmaple.exeption;

public class NoSuchPersonHasReservationException extends RuntimeException {
    public NoSuchPersonHasReservationException(String message) {
        super(message);
    }
}
