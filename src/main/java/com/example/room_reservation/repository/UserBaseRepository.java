package com.example.room_reservation.repository;

import com.example.room_reservation.model.UserBase;
import com.example.room_reservation.model.Role;  // Pastikan enum Role sudah di-import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase, Integer> {

    // Mencari User berdasarkan email
    UserBase findByEmail(String email);

    // Pencarian berdasarkan role
    List<UserBase> findByRole(Role role);  // Menggunakan enum Role
}
