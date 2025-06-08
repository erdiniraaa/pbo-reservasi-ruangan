package com.example.room_reservation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Import service yang benar
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.room_reservation.model.Room;
import com.example.room_reservation.service.BookingManagerService;

@Controller
public class RoomController {

    @Autowired
    private BookingManagerService bookingManagerService;  // Ubah menjadi service, bukan entitas

    @GetMapping("/viewRoom")
    public String lihatRuangan() {
        return "viewRoom";  // Mengarah ke file viewRoom.html di folder templates
    }
    
    @GetMapping("/viewLab")
    public String viewLab(Model model) {
        // Menambahkan daftar lab ke model untuk ditampilkan di halaman
        List<String> labs = Arrays.asList("Lab 1", "Lab 2", "Lab 3"); // Misalnya, Anda dapat mengambil daftar lab dari database
        model.addAttribute("labs", labs);
        return "view-lab";  // Mengarah ke view view-lab.html
    }

    @GetMapping("/reserve/room")
    public String showReserveRoomPage() {
        return "reserveRoom";
    }

    // Tambahkan endpoint untuk admin
    @GetMapping("/admin/rooms/class")
    public String showClassRooms(Model model) {
        model.addAttribute("rooms", bookingManagerService.getRoomsByType("class"));
        return "adminRoomKelas";
    }

    @GetMapping("/admin/rooms/lab")
    public String showLabRooms(Model model) {
        List<Room> labRooms = bookingManagerService.getRoomsByType("lab"); // Ambil ruangan lab dari service
        model.addAttribute("rooms", labRooms); // Kirim ke view
        return "adminRoomLab"; // Ganti dari "roomList" jadi "admin-room-lab"
    }

    @GetMapping("/admin/rooms/aula")
    public String showAulaRooms(Model model) {
        List<Room> aulaRooms = bookingManagerService.getRoomsByType("aula"); // Misalnya, tipe 'aula'
        model.addAttribute("rooms", aulaRooms); // Mengirim data ruangan ke view
        return "adminRoomAula"; // Nama file HTML yang akan ditampilkan
    }

    @GetMapping("/client/room/lab")
    public String viewclientRoomLab(Model model) {
        // Misalnya, menambahkan data lab ke model
        List<String> labs = Arrays.asList("Lab 1", "Lab 2", "Lab 3"); // Contoh data
        model.addAttribute("labs", labs); // Menambahkan data ke model
        return "clientRoomLab";  // Mengarah ke file lab.html di folder templates
    }

    @GetMapping("/client/room/kelas")
    public String viewClientRoomKelas(Model model) {
        // Misalnya, menambahkan data ruang kelas ke model
        List<String> classes = Arrays.asList("Kelas A", "Kelas B", "Kelas C"); // Contoh data
        model.addAttribute("classes", classes); // Menambahkan data ke model
        return "clientRoomKelas";  // Mengarah ke file clientRoomClass.html di folder templates
    }

    @GetMapping("/client/room/aula")
    public String viewClientRoomAula(Model model) {
        // Misalnya, menambahkan data ruang aula ke model
        List<String> aulas = Arrays.asList("Aula Utama", "Aula Serbaguna"); // Contoh data
        model.addAttribute("aulas", aulas); // Menambahkan data ke model
        return "clientRoomAula";  // Mengarah ke file clientRoomAula.html di folder templates
    }


}