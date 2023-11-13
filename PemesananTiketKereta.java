import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama, next;
        String[][] penumpang = new String[10][4];
        int baris, kolom;
        int[] harga = {20000, 50000};
        int[][] nominalHarga = {
            {36000, 46000},//sby
            {200000, 300000}//jkt
        };
        int a, pilihan, jumlah, jml = 0;
        double bayar, totalharga, kembalian;
        char jawab;

        //memilih tujuan
        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Kemana Tujuan Anda?");
        System.out.println("\nSilahkan Memilih Tujuan Anda?");
        System.out.println("1. Surabaya, KA Jayabaya");
        System.out.println("2. Jakarta, KA Brawijaya");
        System.out.print("Pilihan anda: ");
        pilihan = input.nextInt();

        int kotaTujuan = pilihan - 1;

        //memilih gerbong
        System.out.println("\nSilahkan memilih gerbong kereta: ");
        System.out.println("1. Gerbong Ekonomi");
        System.out.println("2. Gerbong Eksekutif");
        System.out.print("Pilihan anda: ");
        int gerbongKereta = input.nextInt();
 
        //perulangan dan input kursi
        do {
            System.out.print("\nMasukkan nama: ");
            nama = input.next();
            System.out.print("Masukkan baris: ");
            baris = input.nextInt();
            System.out.print("Masukkan kolom: ");
            kolom = input.nextInt();
 
            // Cek apakah kursi sudah terisi
            if (penumpang[baris - 1][kolom - 1] == null) {
                penumpang[baris - 1][kolom - 1] = nama;
                jml++;
                System.out.println("Data penumpang berhasil di input");
            } else {
                System.out.println("Kursi sudah terisi. Silakan pilih kursi lain.");
            }
 
            System.out.print("Apakah anda ingin menambah pelanggan lain (Y/T)? ");
            jawab = input.next().charAt(0);
        } while (jawab == 'y' || jawab == 'Y');
 
        System.out.println("Total Pelanggan adalah : " + jml);
 
        int hargaTiket = nominalHarga[kotaTujuan][gerbongKereta - 1];

        //bersarang / nested if
        if (kotaTujuan == 1) {
            if (jml > 5) {
                //totalharga = (harga[pilihan] * jml) - (harga[pilihan] * jml * 0.05);
                totalharga = (hargaTiket * jml) - (hargaTiket * jml * 0.05);
                System.out.println("Total Harga : " + totalharga);
                System.out.print("Masukkan nominal pembayaran anda : ");
                bayar = input.nextDouble();
                if (bayar > totalharga) {
                    kembalian = bayar - totalharga;
                    System.out.println("Kembalian anda adalah = " + kembalian);
                } else if (bayar == totalharga) {
                    System.out.println("Uang anda pas");
                }
            }
        } else {
            totalharga = hargaTiket * jml;
            System.out.println("Total Harga : " + totalharga);
            System.out.print("Masukkan nominal pembayaran anda : ");
            bayar = input.nextDouble();
            if (bayar > totalharga) {
                kembalian = bayar - totalharga;
                System.out.println("Kembalian anda adalah = " + kembalian);
            } else if (bayar == totalharga) {
                System.out.println("Uang anda pas");
            }
        }

        //menu
        System.out.println("\nMenu:");
        System.out.println("1. Tampilkan data pelanggan beserta kursi yang dipilih");
        System.out.println("2. Keluar");
        System.out.print("Pilihan anda: ");
        int menu = input.nextInt();
 
        if (menu == 1) {
            System.out.println("\nData pelanggan beserta kursi yang dipilih:");
            for (int i = 0; i < penumpang.length; i++) {
                for (int j = 0; j < penumpang[i].length; j++) {
                    if (penumpang[i][j] != null) {
                        System.out.println("Nama: " + penumpang[i][j] + ", Kursi: " + (i+1) + "-" + (j+1));
                    }
                }
            }
        } else {
            System.out.println("Terima kasih!");
        }
    }
}