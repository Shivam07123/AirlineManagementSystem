package com.Spring;

import java.util.Arrays;

public class Airline {
    // Attributes
    private Flight[] flights;
    private Passenger[] passengers;
    private int flightCount;
    private int passengerCount;

    // Constructor
    public Airline(int maxFlights, int maxPassengers) {
        this.flights = new Flight[maxFlights];
        this.passengers = new Passenger[maxPassengers];
        this.flightCount = 0;
        this.passengerCount = 0;
    }
    
 // Getter methods in Airline class
    public Flight[] getFlights() {
        return Arrays.copyOf(flights, flightCount);
    }

    public Passenger[] getPassengers() {
        return Arrays.copyOf(passengers, passengerCount);
    }


    // Method to add a new flight
    public void addFlight(Flight flight) {
        if (flightCount < flights.length) {
            flights[flightCount] = flight;
            flightCount++;
            System.out.println("Flight " + flight.getFlightNumber() + " added.");
        } else {
            System.out.println("Cannot add more flights. Maximum limit reached.");
        }
    }

    // Method to remove a flight based on the flight number
    public void removeFlight(String flightNumber) {
        boolean found = false;
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getFlightNumber().equals(flightNumber)) {
                found = true;
                flights[i] = flights[flightCount - 1]; // Replace with the last flight
                flights[flightCount - 1] = null; // Nullify the last flight
                flightCount--;
                System.out.println("Flight " + flightNumber + " removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Flight " + flightNumber + " not found.");
        }
    }

    // Method to register a new passenger
    public void registerPassenger(Passenger passenger) {
        if (passengerCount < passengers.length) {
            passengers[passengerCount] = passenger;
            passengerCount++;
            System.out.println("Passenger " + passenger.getName() + " registered.");
        } else {
            System.out.println("Cannot register more passengers. Maximum limit reached.");
        }
    }

    // Method to unregister a passenger based on passport number
    public void unregisterPassenger(String passportNumber) {
        boolean found = false;
        for (int i = 0; i < passengerCount; i++) {
            if (passengers[i].getPassportNumber().equals(passportNumber)) {
                found = true;
                passengers[i] = passengers[passengerCount - 1]; // Replace with the last passenger
                passengers[passengerCount - 1] = null; // Nullify the last passenger
                passengerCount--;
                System.out.println("Passenger with passport number " + passportNumber + " unregistered.");
                break;
            }
        }
        if (!found) {
            System.out.println("Passenger with passport number " + passportNumber + " not found.");
        }
    }

    // Method to book a flight for a passenger
    public void bookFlight(String passportNumber, String flightNumber) {
        Flight flight = findFlight(flightNumber);
        Passenger passenger = findPassenger(passportNumber);
        if (flight != null && passenger != null) {
            passenger.bookFlight(flight);
        } else {
            if (flight == null) {
                System.out.println("Flight " + flightNumber + " not found.");
            }
            if (passenger == null) {
                System.out.println("Passenger with passport number " + passportNumber + " not found.");
            }
        }
    }

    // Method to cancel a booked flight for a passenger
    public void cancelBooking(String passportNumber, String flightNumber) {
        Flight flight = findFlight(flightNumber);
        Passenger passenger = findPassenger(passportNumber);
        if (flight != null && passenger != null) {
            passenger.cancelBooking(flight);
        } else {
            if (flight == null) {
                System.out.println("Flight " + flightNumber + " not found.");
            }
            if (passenger == null) {
                System.out.println("Passenger with passport number " + passportNumber + " not found.");
            }
        }
    }

    // Method to list all available flights
    public void listAvailableFlights() {
        System.out.println("Available Flights:");
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].isAvailable()) {
                System.out.println(flights[i]);
            }
        }
    }

    // Method to list all booked flights
    public void listBookedFlights() {
        System.out.println("Booked Flights:");
        for (int i = 0; i < flightCount; i++) {
            if (!flights[i].isAvailable()) {
                System.out.println(flights[i]);
            }
        }
    }

    // Helper method to find a flight by flight number
    private Flight findFlight(String flightNumber) {
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getFlightNumber().equals(flightNumber)) {
                return flights[i];
            }
        }
        return null;
    }

    // Helper method to find a passenger by passport number
    private Passenger findPassenger(String passportNumber) {
        for (int i = 0; i < passengerCount; i++) {
            if (passengers[i].getPassportNumber().equals(passportNumber)) {
                return passengers[i];
            }
        }
        return null;
    }


}

