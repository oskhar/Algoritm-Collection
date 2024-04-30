package Implement.Sorting;

import Implement.Sorting.RandomData.ShuffleArray;

public class AcakData {
    public static void main(String[] args) {
        String[] data = {
                "AGIEL SURYA PRATAMA PUTRA", "RIKO FEBRIAN ", "LUTHFI IKMAL FATIR", "ADAM FARID",
                "ADI GUNAWAN", "MUHAMMAD ALIF RAMADHANI", "JESTINE VALLENDRA DWI PUTRA", "ZEINIAH", "NASHIF RAHMAN",
                "MUHAMAD OSKHAR MUBAROK", "MUHAMMAD FARHAN MAULANA", "ARIF NOVIANTO", "GINA SAGITA",
                "MUHAMAD KHOIRI TAHMID", "SYAFIQ ZAHRAN", "ILMAM ALIF MAULAFATHIN SUNARNO", "MUHAMMAD AGUSRIANSYAH",
                "AHMAD FARHAN", "FARHAN HAQQI", "RAJWA AZZHAFIRAH", "ACHMAD DZIDAN FIRDAUS", "FAIZ FIRDI NAYA PRIA",
                "MAZDA MUHAMMAD FADLUR ROHMAN", "MUHAMMAD BINTANG RAMADHAN ", "MUHAMMAD IRSYAD", "SAIF ALI YUSUF",
                "SELY SALSABILLA"
        };
        ShuffleArray.handle(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
