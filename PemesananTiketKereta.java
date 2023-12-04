import java.util.Scanner;
import java.util.Arrays;

public class PemesananTiketKereta {
    //deklarasi var global
    static Scanner input = new Scanner(System.in);
    static boolean login = false;
    static int[] passWord = {2341, 2342};
    static String[] userName = {"Titan", "Dini"};
    static String[][] kota = {
    {"Surabaya", "Jakarta"},
    {"KA jayabaya", "KA Gajayana"}
    };
    static int pilihan;
    static int kotaTujuan;
    static int gerbongKereta;
    static int jamKeberangkatan;
    static String tanggal;
    static int jml;
    static double totalharga;
    static double bayar;
    static String[][] penumpang; 
    static int[][] nominalHarga; 

    //Fungsi main
     public static void main(String[] args) {
        penumpang = new String[10][4]; // inisialisasi penumpang
        nominalHarga = new int[][] {
                {36000, 46000},//sby
                {200000, 300000}//jkt
        };

        // multi level
        System.out.println("Masuk sebagai: ");
        System.out.println("1. Admin (Dini)");
        System.out.println("2. Pengguna (Titan)");
        System.out.print("Masukkan Pilihan: ");
        int level = input.nextInt();
        input.nextLine();

        // memanggil fungsi login
        login();
    }

    // Fungsi login
    static void login() {
        do {
            System.out.print("\nMasukkan username: ");
            String namaPengguna = input.nextLine();
            System.out.print("Masukkan PIN anda: ");
            int pin = input.nextInt();
            input.nextLine();
            login = false;
            for (int i = 0; i < userName.length; i++) {
                if (userName[i].equals(namaPengguna) && passWord[i] == pin) {
                    login = true;
                    if (userName[i].equals("Dini") && passWord[i] == 2342) {
                        admin();
                    }
                    if (userName[i].equals("Titan") && passWord[i] == 2341) {
                        pengguna();
                    }
                    break;
                }
            }
            if (login) {
                System.out.println("Login berhasil");
                admin();
            } else {
                System.out.println("\nUsername dan PIN Salah!");
            }
        } while (!login);
    }

    //fungsi admin
    static void admin(){
            do{
                //menampilkan menu
                System.out.println("Menu: ");
                System.out.println("1. Pesan tiket kereta");
                System.out.println("2. Cek stok ");
                System.out.println("3. Riwayat pemesanan");
                System.out.println("4. Laporan dana"); //admin
                System.out.print("Masukkan pilihan anda: ");
                int menuAwal = input.nextInt();

                if (menuAwal == 1){
                    // memilih tujuan
                    memilihKotaTujuan();

                    // memilih gerbong
                    memilihGerbong();

                    // memilih tanggal dan jam keberangkatan
                    memilihTanggalDanJam();

                    // input kursi
                    inputKursi();

                    // pembayaran
                    pembayaran();

                    // cetak struk
                    //cetakStruk();

                    // menu
                    System.out.println("\nMenu:");
                    System.out.println("1. Tampilkan struk pembelian tiket");
                    System.out.println("2. Keluar");
                    System.out.print("Pilihan anda: ");
                    int menu = input.nextInt();

                    if (menu == 1) {
                        cetakStruk();
                    } else {
                        ucapanTerimakasih();
                    }
                } else if (menuAwal == 2){
                    //cek stok
                    cekKetersediaanKursi();
                }
            } while (true);
    }

    //fungsi pengguna
    static void pengguna(){
            do{
                //menampilkan menu
                System.out.println("Menu: ");
                System.out.println("1. Pesan tiket kereta");
                System.out.println("2. Cek stok ");
                System.out.print("Masukkan pilihan anda: ");
                int menuAwal = input.nextInt();

                if (menuAwal == 1){
                    // memilih tujuan
                    memilihKotaTujuan();

                    // memilih gerbong
                    memilihGerbong();

                    // memilih tanggal dan jam keberangkatan
                    memilihTanggalDanJam();

                    // input kursi
                    inputKursi();

                    // pembayaran
                    pembayaran();

                    // cetak struk
                    //cetakStruk();

                    // menu
                    System.out.println("\nMenu:");
                    System.out.println("1. Tampilkan struk pembelian tiket");
                    System.out.println("2. Keluar");
                    System.out.print("Pilihan anda: ");
                    int menu = input.nextInt();

                    if (menu == 1) {
                        cetakStruk();
                    } else {
                        ucapanTerimakasih();
                    }
                } else if (menuAwal == 2){
                    //cek stok
                    cekKetersediaanKursi();
                }
            } while (true);
    }

    // Fungsi memilih kota tujuan
    static void memilihKotaTujuan() {
        System.out.println("\n ==========================================");
        System.out.println("| --- Selamat Datang di Stasiun Malang --- |");
        System.out.println(" ==========================================");

        System.out.println("\n ==========================================");
        System.out.println("|      Silahkan Memilih Tujuan Anda        |");
        System.out.println("|                  ---                     |");
        System.out.println("|  1. " + kota[0][0] + ", " + kota[1][0] + "|");
        System.out.println("|  2. " + kota[0][1] + ", " + kota[1][1] + "|");
        System.out.println(" ==========================================");
        System.out.print("Pilihan anda: ");
        pilihan = input.nextInt();
        kotaTujuan = pilihan - 1;
    }

    // Fungsi memilih gerbong kereta
    static void memilihGerbong() {
        System.out.println(" \n==========================================");
        System.out.println("|     Silahkan memilih gerbong kereta      |");
        System.out.println("|                   ---                    |");
        System.out.println("|           1. Gerbong Ekonomi             |");
        System.out.println("|          2. Gerbong Eksekutif            |");
        System.out.println(" ==========================================");
        System.out.print("Pilihan anda: ");
        gerbongKereta = input.nextInt();
    }

    // Fungsi memilih tanggal dan jam keberangkatan
    static void memilihTanggalDanJam() {
        System.out.println("\n==========================================");
        System.out.println("|         --- Data Pengguna ---           |");
        System.out.println("==========================================");

        System.out.print("Masukkan tanggal keberangkatan (dd-mm-yyyy): ");
        tanggal = input.next();
        System.out.println(" \n==========================================");
        System.out.println("| Silahkan memilih jam keberangkatan kereta|");
        System.out.println("|                   ---                    |");
        System.out.println("|              1. 11.00 WIB                |");
        System.out.println("|              2. 14.00 WIB                |");
        System.out.println(" ===========================================");
        System.out.print("Pilihan anda: ");
        jamKeberangkatan = input.nextInt();
    }

    // Fungsi input kursi
    static void inputKursi() {
        penumpang = new String[10][4]; // inisialisasi penumpang
        char jawab;
        do {
            System.out.print("\nMasukkan nama       : ");
            String nama = input.next();
            System.out.print("Masukkan baris kursi: ");
            int baris = input.nextInt();
            System.out.print("Masukkan kolom kursi: ");
            int kolom = input.nextInt();

            if (baris >= 1 && baris <= 10 && kolom >= 1 && kolom <= 4) {
                if (penumpang[baris - 1][kolom - 1] == null) {
                    penumpang[baris - 1][kolom - 1] = nama;
                    jml++;
                    System.out.println("Data penumpang berhasil di input");
                } else {
                    System.out.println("Kursi sudah terisi. Silakan pilih kursi lain.");
                }
            } else {
                System.out.println("Kursi tidak valid. Silakan pilih kursi antara baris 1-10 dan kolom 1-4.");
            }

            System.out.print("Apakah anda ingin menambah pelanggan lain (Y/T)? ");
            jawab = input.next().charAt(0);
        } while (jawab == 'y' || jawab == 'Y');
    }

    //fungsi cek stok
    static void cekKetersediaanKursi() {
        for (int i = 0; i < penumpang.length; i++) {
            for (int j = 0; j < penumpang[i].length; j++) {
                if (penumpang[i][j] == null) {
                    System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": Kosong");
                } else {
                    System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": Terisi");
                }
            }
        }
    }

    // Fungsi pembayaran
    static void pembayaran() {
        System.out.println("\n==========================================");
        System.out.println("|          --- Pembayaran ---            |");
        System.out.println("==========================================");
        System.out.println("Total Pelanggan adalah : " + jml);

        nominalHarga = new int[][] {
                {36000, 46000},//sby
                {200000, 300000}//jkt
        };

        int hargaTiket = nominalHarga[kotaTujuan][gerbongKereta - 1];

        if (kotaTujuan == 1 && jml > 5) {
            totalharga = (hargaTiket * jml) - (hargaTiket * jml * 0.05);
        } else {
            totalharga = hargaTiket * jml;
        }

        System.out.println("Total Harga : " + totalharga);
        System.out.print("Masukkan nominal pembayaran anda : ");
        bayar = input.nextDouble();

        if (bayar > totalharga) {
            double kembalian = bayar - totalharga;
            System.out.println("Kembalian anda adalah = " + kembalian);
        } else if (bayar == totalharga) {
            System.out.println("Uang anda pas");
        } else {
            System.out.println("Uang anda kurang. Pembayaran gagal.");
        }
    }

    // Fungsi cetak struk pembelian tiket
    static void cetakStruk() {
        System.out.println("\n===========================================");
        System.out.println("|      --- Struk Pembelian Tiket ---      |");
        System.out.println("===========================================");
        for (int i = 0; i < penumpang.length; i++) {
            for (int j = 0; j < penumpang[i].length; j++) {
                if (penumpang[i][j] != null) {
                    System.out.println("Nama                  : " + penumpang[i][j] + ", Kursi: " + (i + 1) + "-" + (j + 1));
                    if (kotaTujuan == 1) {
                        System.out.println("Kota Tujuan           : Surabaya, KA Jayabaya");
                    } else {
                        System.out.println("Kota Tujuan           : Jakarta, KA Brawijaya");
                    }
                    if (gerbongKereta == 1) {
                        System.out.println("Gerbong               : Gerbong Ekonomi");
                    } else {
                        System.out.println("Gerbong               : Gerbong Eksekutif");
                    }
                    System.out.println("Tanggal Keberangkatan : " + tanggal);
                    if (jamKeberangkatan == 1) {
                        System.out.println("Jam keberangkatan     : 11.00 WIB");
                    } else {
                        System.out.println("Jam Keberangkatan     : 14.00 WIB");
                    }
                }
            }
        }
    }

    // Fungsi ucapan terimakasih
    static void ucapanTerimakasih() {
        System.out.println("Terimakasih sudah memakai layanan kami.\n" +
                "Semoga perjalanan anda menyenangkan dan selamat sampai tujuan.");
    }
}