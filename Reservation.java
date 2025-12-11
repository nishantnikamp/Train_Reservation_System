package com.wipro.trs.entity;

public class Reservation {

	private String reservationId;
	private String passengerId;
	private String trainId;
	private String travelDate;
	private double fare;
	
	public Reservation(String reservationId, String passengerId, String trainId, String travelDate, double fare) {
		super();
		this.reservationId = reservationId;
		this.passengerId = passengerId;
		this.trainId = trainId;
		this.travelDate = travelDate;
		this.fare = fare;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
}
