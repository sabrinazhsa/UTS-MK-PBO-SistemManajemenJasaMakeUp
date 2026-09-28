/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Model.MakeUpPengantin;
import Model.MakeUpWisuda;
import Model.LayananMakeUp;
import controller.LayananValidator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP VICTUS
 */

public class SistemJasaMUA {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<LayananMakeUp> daftarPesanan = new ArrayList<>();
        int pilihanMenu;
 
        do {
            System.out.println("\n=============================================");
            System.out.println("   SISTEM PEMESANAN JASA MAKE UP ARTIST      ");
            System.out.println("=============================================");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Keluar");
            pilihanMenu = LayananValidator.inputAngka(input, "Pilih Menu (1-3): ");
 
            switch (pilihanMenu) {
                case 1:
                    System.out.println("\n--- TAMBAH PESANAN BARU ---");
                    System.out.print("Masukkan Nama Klien          : ");
                    String namaKlien = input.nextLine();
 
                    String noHpKlien = LayananValidator.inputNomorHp(input, "Masukkan Nomor HP Klien  : ");
 
                    String tanggalPelaksanaan = LayananValidator.inputTanggal(input, "Masukkan Tanggal Pengerjaan (dd/mm/yyyy)  : ");
 
                    System.out.println("\nPilih Kategori Make Up:");
                    System.out.println("1. Make Up Wisuda");
                    System.out.println("2. Make Up Pengantin");
                    int kategori = LayananValidator.inputAngka(input, "Pilihan Kategori (1/2): ");
 
                    LayananMakeUp pesanan = null;
 
                    if (kategori == 1) {
                        System.out.println("\nPilih Make Up Look (Wisuda):");
                        System.out.println("1. Natural Glam Look");
                        System.out.println("2. Bold Glam Look");
                        System.out.println("3. Korean Soft Look");
                        int pilihanLook = LayananValidator.inputAngka(input, "Pilihan Look (1-3): ");
 
                        String makeUpLook = "Natural Glam Look";
                        if (pilihanLook == 2) {
                            makeUpLook = "Bold Glam Look";
                        } else if (pilihanLook == 3) {
                            makeUpLook = "Korean Soft Look";
                        }
 
                        int jumlahOrang = LayananValidator.inputAngka(input, "Masukkan Jumlah Orang yang Dirias: ");
                        boolean retouch = LayananValidator.inputYesNo(input, "Tambah Retouch Kit? (Ya/Tidak): ");
 
                        pesanan = new MakeUpWisuda(namaKlien, noHpKlien, tanggalPelaksanaan, makeUpLook, jumlahOrang, retouch);
 
                    } else if (kategori == 2) {
                        System.out.println("\nPilih Make Up Look (Pengantin):");
                        System.out.println("1. Barbie Look");
                        System.out.println("2. Bold Glam Look");
                        System.out.println("3. Korean Soft Look");
                        int pilihanLook = LayananValidator.inputAngka(input, "Pilihan Look (1-3): ");
 
                        String makeUpLook = "Barbie Look";
                        if (pilihanLook == 2) {
                            makeUpLook = "Bold Glam Look";
                        } else if (pilihanLook == 3) {
                            makeUpLook = "Korean Soft Look";
                        }
 
                        int jumlahSesi = LayananValidator.inputAngka(input, "Masukkan Jumlah Sesi Rias (contoh: 1 atau 2): ");
                        boolean sanggul = LayananValidator.inputYesNo(input, "Include Sanggul/Hairdo? (Ya/Tidak): ");
 
                        pesanan = new MakeUpPengantin(namaKlien, noHpKlien, tanggalPelaksanaan, makeUpLook, jumlahSesi, sanggul);
 
                    } else {
                        System.out.println("\nPilihan kategori tidak valid!");
                    }
 
                    if (pesanan != null) {
                        daftarPesanan.add(pesanan);
                        System.out.println("\nPesanan berhasil ditambahkan!");
                    }
                    break;
 
                case 2:
                    System.out.println("\n--- DAFTAR SEMUA PESANAN ---");
                    if (daftarPesanan.isEmpty()) {
                        System.out.println("Belum ada pesanan masuk.");
                    } else {
                        for (int i = 0; i < daftarPesanan.size(); i++) {
                            System.out.println("\nData Pesanan Ke-" + (i + 1));
                            System.out.println("---------------------------------------------");
                            daftarPesanan.get(i).tampilkanDetailPesanan();
                        }
                    }
                    break;
 
                case 3:
                    System.out.println("\nTerima kasih telah menggunakan sistem ini!");
                    break;
 
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
 
        } while (pilihanMenu != 3);
 
        input.close();
    }
}