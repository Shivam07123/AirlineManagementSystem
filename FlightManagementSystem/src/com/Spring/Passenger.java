package com.Spring;

import java.util.Arrays;

//1.Create a Passenger class with the following attributes:
//o	String name: Name of the passenger.
//o	String passportNumber: Passport number of the passenger.
//o	Flight[] bookedFlights: Array to store booked flights.
//o	int bookedFlightCount: Number of flights booked by the passenger.
//2.Implement the following methods in the Passenger class:
//o	Constructor to initialize the passenger details.
//o	Getters and setters for all attributes.
//o	toString() method to provide a string representation of the passenger details.
//o	bookFlight(Flight flight): Books a flight for the passenger and updates the booked flights array.
//o	cancelBooking(Flight flight): Cancels a booked flight for the passenger and updates the booked flights array.


public class Passenger {
    // Attributes
    private String name;
    private String passportNumber;
    private Flight[] bookedFlights;
    private int bookedFlightCount;

    // Constructor
    public Passenger(String name, String passportNumber, int maxFlights) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.bookedFlights = new Flight[maxFlights];
        this.bookedFlightCount = 0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Flight[] getBookedFlights() {
        return Arrays.copyOf(bookedFlights, bookedFlightCount);
    }

    public int getBookedFlightCount() {
        return bookedFlightCount;
    }

    // toString method
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", bookedFlights=" + Arrays.toString(getBookedFlights()) +
                ", bookedFlightCount=" + bookedFlightCount +
                '}';
    }

    // Method to book a flight
    public void bookFlight(Flight flight) {
        if (bookedFlightCount < bookedFlights.length) {
            if (flight.isAvailable()) {
                flight.bookFlight();
                bookedFlights[bookedFlightCount] = flight;
                bookedFlightCount++;
                System.out.println("Flight " + flight.getFlightNumber() + " booked for passenger " + name);
            } else {
                System.out.println("Flight " + flight.getFlightNumber() + " is not available for booking.");
            }
        } else {
            System.out.println("Cannot book more flights. Maximum limit reached.");
        }
    }

 
    // Method to cancel a booked flight
    public void cancelBooking(Flight flight) {
        boolean found = false;
        for (int i = 0; i < bookedFlightCount; i++) {
            if (bookedFlights[i].equals(flight)) {
                found = true;
                flight.cancelBooking();
                bookedFlights[i] = bookedFlights[bookedFlightCount - 1]; // Replace with the last flight
                bookedFlights[bookedFlightCount - 1] = null; // Nullify the last flight
                bookedFlightCount--;
                System.out.println("Booking for flight " + flight.getFlightNumber() + " canceled for passenger " + name);
                break;
            }
        }
        if (!found) {
            System.out.println("Flight " + flight.getFlightNumber() + " is not booked by passenger " + name);
        }
    }
}
