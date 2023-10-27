package entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Biodata {
    private String nama;
    private String nomorHP;
    private String jenisKelamin;
    private String alamat;

    public Biodata(String nama, String nomorHP, String jenisKelamin, String alamat) {
        this.nama = nama;
        this.nomorHP = nomorHP;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    public ArrayList<String> toArrayList() {
        return new ArrayList<>(Arrays.asList(nama, nomorHP, jenisKelamin, alamat));
    }
}
