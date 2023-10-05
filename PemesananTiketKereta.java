import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int harga, jumlah, totalharga;
        String kotaTujuan, kelas;
        double bayar;

        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Kemana Tujuan Anda?");

        System.out.println("Masukkan Pilihan Anda");
        System.out.print("Kota Tujuan : ");
        kotaTujuan = input.next();
        System.out.print("Kelas Kereta : ");
        kelas = input.next();
        System.out.print("Harga Tiket : ");
        harga = input.nextInt();
        System.out.print("Jumlah Beli : ");
        jumlah = input.nextInt();

        totalharga = harga * jumlah;
        System.out.println("Total Harga : " + totalharga);

        System.out.print("Berikan Uang Anda : ");
        bayar = input.nextDouble();

        System.out.println("Kembalian anda adalah = " + (bayar - totalharga));
    }
}