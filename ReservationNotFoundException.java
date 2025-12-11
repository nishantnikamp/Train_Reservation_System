package com.wipro.trs.util;

public class ReservationNotFoundException extends Exception {

    private String rid;

    public ReservationNotFoundException(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "ReservationNotFoundException: Reservation ID not found! : " + rid;
    }
}