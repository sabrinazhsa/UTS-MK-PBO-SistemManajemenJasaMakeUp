/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class LayananValidator {
    public static int inputAngka(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String teks = input.nextLine().trim();
            try {
                return Integer.parseInt(teks);
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka! Coba lagi: ");
            }
        }
    }

    private static final DateTimeFormatter formatTanggal =
            DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static String inputTanggal(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String teks = input.nextLine().trim();
            try {
                LocalDate.parse(teks, formatTanggal);
                return teks;
            } catch (DateTimeParseException e) {
                System.out.print("Format tanggal salah! Gunakan format dd/MM/yyyy. Coba lagi: ");
            }
        }
    }

    public static String inputNomorHp(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String teks = input.nextLine().trim();
            if (teks.matches("\\+?[0-9]{10,15}")) {
                return teks;
            } else {
                System.out.print("Nomor HP tidak valid! Coba lagi: ");
            }
        }
    }
    
    public static String inputTeks(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String teks = input.nextLine().trim();
            if (!teks.isEmpty()) {
                return teks;
            }
            System.out.print("Input tidak boleh kosong! Coba lagi: ");
        }
    }
    
    public static String inputStatusPembayaran(Scanner input, String prompt) {
    System.out.print(prompt);
    while (true) {
        String teks = input.nextLine().trim();
        if (teks.equalsIgnoreCase("Lunas") || teks.equalsIgnoreCase("Pending") || teks.equalsIgnoreCase("DP")) {
            return teks;
        }
        System.out.print("Status tidak valid! Masukkan (Lunas / Pending / DP): ");
    }
}
     
    public static double inputAngkaDesimal(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String teks = input.nextLine().trim();
            try {
                double nilai = Double.parseDouble(teks);
                if (nilai < 0) {
                    System.out.print("Angka tidak boleh negatif! Coba lagi: ");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka! Coba lagi: ");
            }
        }
    }
 
    public static boolean inputYesNo(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            String jawaban = input.nextLine().trim().toLowerCase();
            if (jawaban.equals("ya") || jawaban.equals("y") || jawaban.equals("yes")) {
                return true;
            } else if (jawaban.equals("tidak") || jawaban.equals("t") || jawaban.equals("no") || jawaban.equals("n")) {
                return false;
            } else {
                System.out.print("Pilihan tidak valid! Masukkan Ya/Tidak: ");
            }
        }
    }
    
}