package com.jamiyyatulmunawwaroh.recyclearview_fan;

public class DataAnggota {
    //inisialisasi variabel
    int idAnggota; //idMahasiswa didatabase merupakan int (Auto Increment)
    String namaAnggota; //namaMahasiswa didatabase merupakan string
    String jurusan; //nimMahasiswa didatabase merupakan string
    String peminatan; //kelasMahasiswa didatabase merupakan string

    //construktor datamahasiswa
    public DataAnggota(int idAnggota, String namaAnggota, String jurusan, String peminatan) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.jurusan = jurusan;
        this.peminatan = peminatan;
    }

    //getter dan setter

    public int getIdAnggota() {

        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {

        this.idAnggota = idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getNimMahasiswa() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getPeminatan() {
        return peminatan;
    }

    public void setPeminatan(String peminatan) {
        this.peminatan = peminatan;
    }
}
