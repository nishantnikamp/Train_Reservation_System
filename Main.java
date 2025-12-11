package com.wipro.trs.main;
import java.util.ArrayList;
import com.wipro.trs.entity.*;
import com.wipro.trs.service.ReservationService;
import com.wipro.trs.util.*;
public class Main {
 public static void main(String[] args) {
	 ArrayList<Passenger> passengers = new ArrayList<>();
	 passengers.add(new Passenger("P001", "Arun Kumar", "9876543210"));
	 passengers.add(new Passenger("P002", "Priya Nair", "9123456780"));
	 ArrayList<Train> trains = new ArrayList<>();
	 trains.add(new Train("T101", "Rajdhani Express", "Delhi", "Mumbai", 1, 1, 1500.0));
	 trains.add(new Train("T202", "Shatabdi Express", "Chennai", "Bangalore", 10, 10, 900.0));
	 ArrayList<Reservation> reservations = new ArrayList<>();
	 ReservationService service = new ReservationService(passengers, trains, reservations);
	 try {
//	 Reservation r1 = service.bookTicket("P001", "T101", "2025-03-12");
//	 Reservation r1 = service.bookTicket("P003", "T101", "2025-03-12"); //InvalidPassengerException
	 Reservation r1 = service.bookTicket("P001", "T103", "2025-03-12"); //ReservationOperationException
//	 Reservation r2 = service.bookTicket("P002", "T101", "2025-03-12"); //TrainFullException
	 System.out.println("Reservation Successful! ID: " + r1.getReservationId());
	 System.out.println("\n--- Passenger Reservation History (P001) ---");
	 service.printPassengerReservations("P001");
	 System.out.println("\nCancelling reservation...");
	 service.cancelReservation(r1.getReservationId());
	 System.out.println("Reservation Cancelled.");
//	 service.cancelReservation(r1.getReservationId());//ReservationNotFoundException
	 } catch (InvalidPassengerException | TrainFullException | ReservationNotFoundException | ReservationOperationException ex) {
	 System.out.println(ex.toString());
	 } catch (Exception ex) {
	 System.out.println("Unexpected Error: " + ex);
	 }
	 }
 }