package com.example.room_reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Menambahkan import UserBase
import org.springframework.ui.Model;  // Pastikan service ini sudah diimport
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.UserBase;
import com.example.room_reservation.service.BookingManagerService;

@Controller
public class BookingController {

    @Autowired
    private BookingManagerService bookingManagerService;  // Menggunakan BookingManagerService

    @GetMapping("/booking/history")
    public String viewBookingHistory(Model model, UserBase user) {
        List<Booking> bookings = bookingManagerService.getBookingsForUser(user);  // Menggunakan service yang benar
        model.addAttribute("bookings", bookings);
        return "bookingHistory";  // Menampilkan riwayat booking
    }

    @PostMapping("/booking/cancel")
    public String cancelBooking(@RequestParam("bookingId") int bookingId, Model model) {
        boolean success = bookingManagerService.cancelBooking(bookingId);  // Menggunakan service yang benar
        if (success) {
            model.addAttribute("message", "Booking berhasil dibatalkan.");
        } else {
            model.addAttribute("error", "Booking ID tidak ditemukan.");
        }
        return "home";  // Redirect ke halaman home setelah pembatalan
    }
}
