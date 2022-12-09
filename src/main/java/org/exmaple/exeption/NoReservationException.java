package org.exmaple.exeption;

public class NoReservationException extends RuntimeException{
    public NoReservationException(String message) {
        super(message);
    }
}
