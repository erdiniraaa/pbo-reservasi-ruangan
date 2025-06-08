package com.example.room_reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.room_reservation.model.Booking;
import com.example.room_reservation.model.BookingStatus;
import com.example.room_reservation.service.BookingService;

@Controller
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model) {
        // Mengambil daftar booking dengan status PENDING
        List<Booking> pendingBookings = bookingService.getBookingsByStatus(BookingStatus.PENDING);
        model.addAttribute("pendingBookings", pendingBookings);  // Mengirimkan data ke template
        return "adminDashboard";  // Menampilkan halaman admin_dashboard.html
    }

    // Fungsi untuk menerima booking
    @PostMapping("/admin/approveBooking")
    public String approveBooking(@RequestParam("bookingId") Long bookingId) {
        bookingService.acceptBooking(bookingId, null);  // Panggil dengan data yang sesuai
        return "redirect:/admin/dashboard";  // Redirect setelah approval
    }

    // Fungsi untuk menolak booking
    @PostMapping("/admin/rejectBooking")
    public String rejectBooking(@RequestParam("bookingId") Long bookingId) {
        bookingService.rejectBooking(bookingId, null);  // Panggil dengan data yang sesuai
        return "redirect:/admin/dashboard";  // Redirect setelah rejection
    }
}