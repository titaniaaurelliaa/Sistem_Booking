import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama, next, tanggal;
        String[][] penumpang = new String[10][4];
        int baris, kolom;
        int[] harga = {20000, 50000};
        int[][] nominalHarga = {
            {36000, 46000},//sby
            {200000, 300000}//jkt
        };
        int a, pilihan, jumlah, jml = 0, jamkeberangkatan;
        double bayar, totalharga, kembalian, waktuBerangkat;
        char jawab;
        int[] passWord= {2341, 2342};
        String[][] userName= {{"Titan"}, {"Dini"}};
        boolean login= false;

        //login
        do {
            System.out.print("\nMasukkan username: ");
            String namaPengguna = input.nextLine();
            System.out.print("Masukkan PIN anda: ");
            int pin = input.nextInt();
            input.nextLine(); 
        
            login = false; 
            for (int i = 0; i < userName.length; i++) {
                if (userName[i][0].equals(namaPengguna) && passWord[i] == pin) {
                    login = true; 
                    break;
                }
            }
        
            if (login) {
                System.out.println("Login berhasil");
            } else {
                System.out.println("\nUsername dan PIN Salah!");
            }
        } while (!login);
        
        //memilih tujuan
        System.out.println("\n ==========================================");
        System.out.println("| --- Selamat Datang di Stasiun Malang --- |");
        System.out.println(" ==========================================");

        System.out.println("\n ==========================================");
        System.out.println("|      Silahkan Memilih Tujuan Anda        |");
        System.out.println("|                  ---                     |");
        System.out.println("|         1. Surabaya, KA Jayabaya         |");
        System.out.println("|         2. Jakarta, KA Brawijaya         |");
        System.out.println(" ==========================================");
        System.out.print("Pilihan anda: ");
        pilihan = input.nextInt();
        int kotaTujuan = pilihan - 1;

        //memilih gerbong
        System.out.println(" \n==========================================");
        System.out.println("|     Silahkan memilih gerbong kereta      |");
        System.out.println("|                   ---                    |");
        System.out.println("|           1. Gerbong Ekonomi             |");
        System.out.println("|          2. Gerbong Eksekutif            |");
        System.out.println(" ==========================================");
        System.out.print("Pilihan anda: ");
        int gerbongKereta = input.nextInt();

        //memilih tanggal dan jam keberangkatan
        System.out.println("\n==========================================");
        System.out.println("|         --- Data Pengguna ---           |");
        System.out.println("==========================================");

        System.out.print("Masukkan tanggal keberangkatan: ");
        tanggal = input.next(); 
        System.out.println(" \n==========================================");
        System.out.println("| Silahkan memilih jam keberangkatan kereta|");
        System.out.println("|                   ---                    |");
        System.out.println("|              1. 11.00 WIB                |");
        System.out.println("|              2. 14.00 WIB                |");
        System.out.println(" ===========================================");
        System.out.print("Pilihan anda: ");
        jamkeberangkatan = input.nextInt();

        // if(pilihan == 1){
        //     System.out.println(" \n==========================================");
        //     System.out.println("| Silahkan memilih jam keberangkatan kereta|");
        //     System.out.println("|                   ---                    |");
        //     System.out.println("|              1. 11.00 WIB                |");
        //     System.out.println("|              2. 14.00 WIB                |");
        //     System.out.println(" ===========================================");
        //     System.out.print("Pilihan anda: ");
        //     jamkeberangkatan = input.nextInt();
        // } else {
        //     System.out.println(" \n==========================================");
        //     System.out.println("| Silahkan memilih jam keberangkatan kereta|");
        //     System.out.println("|                   ---                    |");
        //     System.out.println("|              1. 12.00 WIB                |");
        //     System.out.println("|              2. 15.00 WIB                |");
        //     System.out.println(" ===========================================");
        //     System.out.print("Pilihan anda: ");
        //     jamkeberangkatan = input.nextInt();
        // } 

        //perulangan dan input kursi
        do {
            System.out.print("\nMasukkan nama       : ");
            nama = input.next();
            System.out.print("Masukkan baris kursi: ");
            baris = input.nextInt();
            System.out.print("Masukkan kolom kursi: ");
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
 
        System.out.println("\n==========================================");
        System.out.println("|          --- Pembayaran ---            |");
        System.out.println("==========================================");
        System.out.println("Total Pelanggan adalah : " + jml);
 
        int hargaTiket = nominalHarga[kotaTujuan][gerbongKereta - 1];

        //bersarang / nested if (untuk pembayaran)
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
                } else if (bayar < totalharga) {
                    System.out.println("Uang anda kurang");
                    
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
            } else if (bayar < totalharga) {
                System.out.println("Uang anda kurang");
                
            }
        }

        //menu
        System.out.println("\nMenu:");
        System.out.println("1. Tampilkan struk pembelian tiket");
        System.out.println("2. Keluar");
        System.out.print("Pilihan anda: ");
        int menu = input.nextInt();
 
        if (menu == 1) {
            System.out.println("\n===========================================");
            System.out.println("|      --- Struk Pembelian Tiket ---      |");
            System.out.println("===========================================");
            for (int i = 0; i < penumpang.length; i++) {
                for (int j = 0; j < penumpang[i].length; j++) {
                    if (penumpang[i][j] != null) {
                        System.out.println("Nama                  : " + penumpang[i][j] + ", Kursi: " + (i+1) + "-" + (j+1));
                        if (kotaTujuan == 1){
                            System.out.println("Kota Tujuan           : Surabaya, KA Jayabaya");
                        } else {
                            System.out.println("Kota Tujuan           : Jakarta, KA Brawijaya");
                        }
                        if (gerbongKereta == 1){
                            System.out.println("Gerbong               : Gerbong Ekonomi");
                        } else {
                            System.out.println("Gerbong               : Gerbong Eksekutif");
                        }
                        System.out.println("Tanggal Keberangkatan : " + tanggal);
                        if (jamkeberangkatan == 1){
                            System.out.println("Jam keberangkatan     : 11.00 WIB");
                        } else {
                            System.out.println("Jam Keberangkatan     : 14.00 WIB");
                        }
                        //System.out.println("Total Harga: " + totalharga);
                    }
                }
            }
        } else {
            System.out.println("Terima kasih!");
        }
    }
}