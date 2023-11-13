import java.util.Scanner;

public class PemesananTiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int harga, jumlah, jml=0;
        String kotaTujuan, kelas;
        double bayar, totalharga, kembalian;


        System.out.println("Selamat Datang di Stasiun Malang");
        System.out.println("Kemana Tujuan Anda?");

        System.out.println("Masukkan Pilihan Anda");
        System.out.print("Kota Tujuan : ");
        kotaTujuan = input.next();
        System.out.print("Kelas Kereta : ");
        kelas = input.next();
       
        // bersarang / nested if
        System.out.print("Harga Tiket : ");
        harga = input.nextInt();
        System.out.println("Masukkan Jumlah tiket : ");
        jml = input.nextInt();

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
                  if (bayar > totalharga) {
                kembalian = bayar - totalharga;
                System.out.println("Kembalian anda adalah = " + kembalian);
            } else if (bayar == totalharga) {
                System.out.println("Uang anda pas");
            }
            }  
        
        }
    }
}




