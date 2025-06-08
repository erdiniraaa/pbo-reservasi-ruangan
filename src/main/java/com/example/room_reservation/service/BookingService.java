package com.example.room_reservation.service;

import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingManager;
import com.example.room_reservation.model.BookingStatus;
import com.example.room_reservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Fungsi untuk menerima booking
    public void acceptBooking(Long bookingId, BookingManager bookingManager) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(BookingStatus.APPROVED);
        booking.setBookingManager(bookingManager);
        bookingRepository.save(booking);
    }

    // Fungsi untuk menolak booking
    public void rejectBooking(Long bookingId, BookingManager bookingManager) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(BookingStatus.REJECTED);
        booking.setBookingManager(bookingManager);
        bookingRepository.save(booking);
    }

    // Fungsi untuk mengambil daftar booking berdasarkan status
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }
}
