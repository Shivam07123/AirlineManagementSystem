package com.Spring;
//
//1.	Create a Flight class with the following attributes:
//o	String flightNumber: Unique identifier for each flight.
//o	String origin: Departure location of the flight.
//o	String destination: Arrival location of the flight.
//o	String departureTime: Time of departure.
//o	String arrivalTime: Time of arrival.
//o	boolean isAvailable: Indicates whether the flight is available for booking.
//2.	Implement the following methods in the Flight class:
//o	Constructor to initialize the flight details.
//o	Getters and setters for all attributes.
//o	toString() method to provide a string representation of the flight details.
//o	bookFlight(): Sets the isAvailable status to false when booked.
//o	cancelBooking(): Sets the isAvailable status to true when canceled.

public class Flight {
    // Attributes
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private boolean isAvailable;

    // Constructor
    public Flight(String flightNumber, String origin, String destination, String departureTime, String arrivalTime, boolean isAvailable) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // toString method
    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    // Method to book a flight
    public void bookFlight() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Flight " + flightNumber + " successfully booked.");
        } else {
            System.out.println("Flight " + flightNumber + " is already booked.");
        }
    }

    // Method to cancel a booking
    public void cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Booking for flight " + flightNumber + " successfully canceled.");
        } else {
            System.out.println("Flight " + flightNumber + " is not currently booked.");
        }
    }
}
