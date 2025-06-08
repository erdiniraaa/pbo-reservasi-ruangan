package com.example.room_reservation.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity // Menambahkan anotasi @Entity di sini, menghapus @Service
public class BookingManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bookingManager")
    private List<Booking> managedBookings;

    @OneToMany
    private List<Room> rooms;  // Daftar ruangan yang dikelola oleh BookingManager

    // Getter dan Setter untuk id, name, managedBookings, dan rooms
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getManagedBookings() {
        return managedBookings;
    }

    public void setManagedBookings(List<Booking> managedBookings) {
        this.managedBookings = managedBookings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Method untuk mendapatkan booking berdasarkan user
    public List<Booking> getBookingsForUser(UserBase user) {
        return managedBookings.stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }

    // Method untuk mendapatkan daftar semua ruangan
    public List<Room> getAllRooms() {
        return rooms;
    }
}
