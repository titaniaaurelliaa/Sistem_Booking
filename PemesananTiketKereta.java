import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String []kotaTujuan = {"Surabaya", "Jakarta"};
        int[] harga = {20000, 50000};
        int a, pilihan, jumlah, jml = 0;
        String kelas, nama;
        double bayar, totalharga, kembalian;
        char jawab;

        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Kemana Tujuan Anda?");

        for (a=0; a < harga.length; a++){
             System.out.println(a+ ". " + kotaTujuan[a] + " Harganya " + harga[a]);
             }
        
        // input kota tujuan dan kelas kereta
        System.out.print("Masukkan Pilihan Anda: ");
        pilihan=input.nextInt();
        System.out.println("Kota Tujuan : " + kotaTujuan[pilihan]);
        System.out.println("Harga Tiket : " + harga[pilihan]);

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
        if (kotaTujuan[pilihan].equals("Surabaya")) {
            if (jml > 5) {
                totalharga = (harga[pilihan] * jml) - (harga[pilihan] * jml * 0.05);
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
                totalharga = harga[pilihan] * jml;
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