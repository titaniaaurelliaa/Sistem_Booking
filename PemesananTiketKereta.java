import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int harga, jml = 0;
        String kotaTujuan, kelas, nama;
        double bayar, totalharga, kembalian;
        char jawab;

        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Kemana Tujuan Anda?");
        
        // input kota tujuan dan kelas kereta
        System.out.println("Masukkan Pilihan Anda");
        System.out.print("Kota Tujuan : ");
        kotaTujuan = input.next();
        System.out.print("Kelas Kereta : ");
        kelas = input.next();

        // perulangan
        do {
            System.out.println("Masukkan nama pelanggan : ");
            nama = input.next();
            jml++;
            System.out.println("Apakah anda ingin menambah pelanggan lain (Y/T)? ");
            jawab = input.next().charAt(0);
        } while (jawab == 'y' || jawab == 'Y');
        System.out.println("Total Pelanggan adalah : " + jml);

        System.out.print("Harga Tiket : ");
        harga = input.nextInt();
       
        // bersarang / nested if
        if (kotaTujuan.equals("sby")) {
            if (jml > 5) {
                totalharga = (harga * jml) - (harga * jml * 0.05);
                System.out.println("Total Harga : " + totalharga);
                System.out.print("Masukkan nominal pembayaran anda : ");
                bayar = input.nextDouble();
                if (bayar > totalharga) {
                kembalian = bayar - totalharga;
                System.out.println("Kembalian anda adalah = " + kembalian);
            } else if (bayar == totalharga) {
                System.out.println("Uang anda pas");
            }
            } else {
                totalharga = harga * jml;
                System.out.println("Total Harga : " + totalharga);
                System.out.print("Masukkan nominal pembayaran anda : ");
                bayar = input.nextDouble();
            }  
        
        }
    }
}
