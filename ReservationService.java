package com.wipro.trs.service;

import java.util.ArrayList;
import com.wipro.trs.entity.*;
import com.wipro.trs.util.*;

public class ReservationService {

    private ArrayList<Passenger> passengers;
    private ArrayList<Train> trains;
    private ArrayList<Reservation> reservations;
    private int reservationCounter = 5;

    public ReservationService(ArrayList<Passenger> passengers,
                              ArrayList<Train> trains,
                              ArrayList<Reservation> reservations) {
        this.passengers = passengers;
        this.trains = trains;
        this.reservations = reservations;
    }

    public boolean validatePassenger(String passengerId) throws InvalidPassengerException {
        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(passengerId)) return true;
        }
        throw new InvalidPassengerException();
    }

    public Train findTrain(String trainId) throws ReservationOperationException {
        for (Train t : trains) {
            if (t.getTrainId().equals(trainId)) return t;
        }
        throw new ReservationOperationException();
    }

    public double calculateFare(Train train) {
        return train.getBaseFare();
    }

    public Reservation bookTicket(String passengerId, String trainId, String date) throws Exception {
        validatePassenger(passengerId);
        Train train = findTrain(trainId);

        if (train.getAvailableSeats() <= 0)
            throw new TrainFullException();

        double fare = calculateFare(train);
        String reservationId = "R" + (++reservationCounter);

        Reservation r = new Reservation(reservationId, passengerId, trainId, date, fare);
        reservations.add(r);

        train.setAvailableSeats(train.getAvailableSeats() - 1);
        return r;
    }

    public void cancelReservation(String reservationId) throws ReservationNotFoundException {
        Reservation toRemove = null;

        for (Reservation r : reservations) {
            if (r.getReservationId().equalsIgnoreCase(reservationId)) {
                toRemove = r;
                break;
            }
        }

        if (toRemove == null) {
            throw new ReservationNotFoundException(reservationId);
        }

        // Restore seat count
        for (Train t : trains) {
            if (t.getTrainId().equals(toRemove.getTrainId())) {
                t.setAvailableSeats(t.getAvailableSeats() + 1);
                break;
            }
        }

        reservations.remove(toRemove);
    }

    public void printPassengerReservations(String passengerId) {
        System.out.println("Reservations for Passenger: " + passengerId);
        for (Reservation r : reservations) {
            if (r.getPassengerId().equals(passengerId)) {
                System.out.println("Reservation ID: " + r.getReservationId() +
                                   ", Train: " + r.getTrainId() +
                                   ", Date: " + r.getTravelDate() +
                                   ", Fare: " + r.getFare());
            }
        }
    }
}