package com.Spring;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Airline with maximum 5 flights and 5 passengers
        Airline airline = new Airline(5, 5);

        // Create some flight instances
        Flight flight1 = new Flight("FL001", "New York", "London", "08:00 AM", "08:00 PM", true);
        Flight flight2 = new Flight("FL002", "Los Angeles", "Tokyo", "10:00 AM", "02:00 AM", true);
        Flight flight3 = new Flight("FL003", "San Francisco", "Paris", "01:00 PM", "09:00 AM", true);

        // Add flights to the airline
        airline.addFlight(flight1);
        airline.addFlight(flight2);
        airline.addFlight(flight3);

        // Create some passenger instances
        Passenger passenger1 = new Passenger("John Doe", "P123456", 3);
        Passenger passenger2 = new Passenger("Jane Smith", "P654321", 3);

        // Register passengers with the airline
        airline.registerPassenger(passenger1);
        airline.registerPassenger(passenger2);

        // Book some flights for passengers
        airline.bookFlight("P123456", "FL001");
        airline.bookFlight("P123456", "FL002");
        airline.bookFlight("P654321", "FL003");

        // List available flights
        System.out.println("\nAvailable Flights:");
        airline.listAvailableFlights();

        // List booked flights
        System.out.println("\nBooked Flights:");
        airline.listBookedFlights();

        // Cancel a booking
        airline.cancelBooking("P123456", "FL002");

        // List available flights after cancellation
        System.out.println("\nAvailable Flights after cancellation:");
        airline.listAvailableFlights();

        // List booked flights after cancellation
        System.out.println("\nBooked Flights after cancellation:");
        airline.listBookedFlights();

        // Remove a flight
        airline.removeFlight("FL003");

        // Unregister a passenger
        airline.unregisterPassenger("P654321");

        // Final state of flights and passengers
        System.out.println("\nFinal state:");
        System.out.println("Flights:");
        for (Flight flight : airline.getFlights()) {
            if (flight != null) {
                System.out.println(flight);
            }
        }
        System.out.println("Passengers:");
        for (Passenger passenger : airline.getPassengers()) {
            if (passenger != null) {
                System.out.println(passenger);
            }
        }

        // Test StringUtil class
        System.out.println("\nTesting StringUtil:");
        String str = "hello world";
        System.out.println("Original: " + str);
        System.out.println("Occurrences of 'l': " + StringUtil.countOccurrences(str, 'l'));
        System.out.println("Reversed: " + StringUtil.reverseString(str));
        System.out.println("Is palindrome: " + StringUtil.isPalindrome("madam"));
        System.out.println("Capitalized: " + StringUtil.capitalizeWords(str));

        // Test WrapperUtil class
        System.out.println("\nTesting WrapperUtil:");
        Integer[] intArray = {3, 5, 7, 2, 8};
        Double[] doubleArray = {2.5, 3.5, 4.5, 5.5};
        String binaryString = "1101";
        Boolean[] booleanArray = {true, true, false, true};

        System.out.println("Max value: " + WrapperUtil.findMax(intArray));
        System.out.println("Average: " + WrapperUtil.calculateAverage(doubleArray));
        System.out.println("Binary to Boolean array: " + Arrays.toString(WrapperUtil.convertToBooleanArray(binaryString)));
        System.out.println("Boolean array to binary: " + WrapperUtil.convertToBinaryString(booleanArray));
    }
}

