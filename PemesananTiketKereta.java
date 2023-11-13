import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] nominalHarga = {
            {36000, 46000}, //sby
            {200000, 300000} //jkt
        };
        int a, pilihan, jumlah, jml = 0;
        String nama;
        //String kelas;
        double bayar, totalharga, kembalian;
        char jawab;

        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Silahkan Memilih Tujuan Anda?");
        //memilih kereta
        System.out.println("1. Surabaya, KA Jayabaya");
        System.out.println("2. Jakarta, KA Brawijaya");
        System.out.print("Pilihan anda: ");
        pilihan=input.nextInt();

        int kotaTujuan = pilihan - 1;

       //memilih gerbong
       System.out.println("Silahkan memilih gerbong kereta: ");
       System.out.println("1. Gerbong Ekonomi");
       System.out.println("2. Gerbong Eksekutif");
    System.out.print("Pilihan anda: ");
       int gerbongKereta = input.nextInt();

        
        // input kota tujuan dan kelas kereta
        // System.out.print("Masukkan Pilihan Anda: ");
        
        // System.out.println("Kota Tujuan : " + kotaTujuan[pilihan]);
        // System.out.println("Harga Tiket : " + harga[pilihan]);

        //harga tiket
        int hargaTiket = nominalHarga[kotaTujuan][gerbongKereta - 1];
        System.out.println("Harga tiket: " + hargaTiket);

        // perulangan
        do {
            System.out.print("Masukkan nama pelanggan : ");
            nama = input.next();
            jml++;
            System.out.print("Apakah anda ingin menambah pelanggan lain (Y/T)? ");
            jawab = input.next().charAt(0);
        } while (jawab == 'y' || jawab == 'Y');
        System.out.println("Total Pelanggan adalah : " + jml);

        // bersarang / nested if
        if (kotaTujuan==1) {
            if (jml > 5) {
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
        
             }else {
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
    }
}