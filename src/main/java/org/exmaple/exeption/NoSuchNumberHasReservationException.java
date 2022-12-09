package org.exmaple.exeption;

public class NoSuchNumberHasReservationException extends RuntimeException {
    public NoSuchNumberHasReservationException(String message) {
        super(message);
    }
}
