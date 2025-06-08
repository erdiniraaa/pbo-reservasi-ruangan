package com.example.room_reservation.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserBase user;  // Pengguna yang mengajukan booking

    @ManyToOne
    private BookingManager bookingManager;  // BookingManager yang mengelola booking ini

    @ManyToOne  // Mengubah menjadi relasi ManyToOne dengan Room
    private Room room;  // Ruangan yang dibooking, menggunakan objek Room

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    // Constructor dengan parameter yang sesuai
    public Booking(UserBase user, Room room, LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.user = user;
        this.room = room;  // Menyimpan objek Room
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = BookingStatus.PENDING;  // Default status is PENDING
    }

    public Booking() {
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBase getUser() {
        return user;
    }

    public void setUser(UserBase user) {
        this.user = user;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public void setBookingManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public Room getRoom() {
        return room;  // Mengembalikan objek Room
    }

    public void setRoom(Room room) {
        this.room = room;  // Menyimpan objek Room
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
