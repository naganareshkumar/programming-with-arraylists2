package com.lesson.lab.controller;

import com.lesson.lab.model.Seat;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // TODO 1 : this.bookedSeatsList = ?
        this.bookedSeatsList = new ArrayList<>();
    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: check if the seat is already booked and not canceled
        // TODO 3 create a new Seat object for the booking,
        // mark the seat as booked,
        // set the current date as the booking date
        // TODO 4: add the new seat to the bookedSeatsList
        // TODO 5: confirm the booking to the user
        for (Seat bookedSeat : bookedSeatsList) {
            if (!bookedSeatsList.isEmpty() && bookedSeat.getSeatNumber().equals(seatNumber) && bookedSeat.isBooked() && !bookedSeat.isCanceled()) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return; // Exit the method if the seat is already booked
            }
        }
        Seat seat1 = new Seat(seatNumber);
        seat1.setBooked(true);
        seat1.setBookingDate(new Date("03/12/2025"));
        bookedSeatsList.add(seat1);
        System.out.println("Booking confirmed with seat number :"+"\n"+seat1.toString());
    }

    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // TODO 6: iterate through the list of booked seats
        // TODO 7: check if the seat number matches and is not already canceled
        // mark the seat as canceled
        // mark the seat as not booked
        // confirm the cancellation to the user
        // TODO 8: inform the user if no booking was found for the seat number
        boolean found = false;
        for(Seat booked: bookedSeatsList) {
            if (booked.getSeatNumber().equals(seatNumber) && booked.isBooked() && !booked.isCanceled()) {
                booked.setCanceled(true);
                booked.setBooked(false);
                System.out.println("Booking for seat" + seatNumber + "is cancelled ");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("No Booking found for the seat number :"+seatNumber);
        }
    }

    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // TODO 9: iterate through the list of booked seats
        // TODO 10: check if the seat number matches the old seat number and is not canceled
        // TODO 11: update the seat number to the new seat number
        // confirm the update to the user
        // TODO 12: inform the user if no booking was found for the old seat number
        boolean found = false;
        for(Seat booked : bookedSeatsList) {
            if (booked.getSeatNumber().equals(oldSeatNumber) && booked.isBooked() && !booked.isCanceled()) {
                booked.setSeatNumber(newSeatNumber);
                System.out.println("Booking updated with new seat number " + newSeatNumber);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No booking found for the old seat number: " + oldSeatNumber);
        }
        /*bookedSeatsList.forEach(booked -> {
            if(bookedSeatsList.contains(oldSeatNumber)){
                bookedSeatsList.set(bookedSeatsList.indexOf(oldSeatNumber), new Seat(newSeatNumber));
                System.out.println("Booking is updated with new seat Number ");
            }
        });*/
    }
    // Method to display all bookings
    public void displayBookings() {
            if (bookedSeatsList.isEmpty()) {
                System.out.println("No bookings have been made yet.");
                return;
            }
            for (Seat booking : bookedSeatsList) {
                if (booking.isBooked() && !booking.isCanceled()) {
                    System.out.println("Seat Number: " + booking.getSeatNumber() + ", Booking Date: " + booking.getBookingDate());
                }
            }
        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        // TODO 15: display the seat number and booking date

    }
}
