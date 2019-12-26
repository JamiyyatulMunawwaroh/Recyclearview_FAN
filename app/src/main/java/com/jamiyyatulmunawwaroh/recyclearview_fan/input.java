package com.jamiyyatulmunawwaroh.recyclearview_fan;


import android.content.Intent;
import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.androidnetworking.AndroidNetworking;
        import com.androidnetworking.common.Priority;
        import com.androidnetworking.error.ANError;
        import com.androidnetworking.interfaces.JSONObjectRequestListener;

        import org.json.JSONObject;

public class input extends AppCompatActivity {

    private static final String TAG = "input"; //untuk melihat log
    private EditText etNama, etJurusan, etPeminatan; //pembuatan variabel edittext
    private Button btnTambah, btnLihat; //pembuatan variabel button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Log.d(TAG, "onCreate: inisialisasi"); //untuk log pada oncreate

        etNama = findViewById(R.id.txt_nama); //inisialisasi value etNama
        etJurusan= findViewById(R.id.txt_jurusan);
        etPeminatan = findViewById(R.id.txt_peminatan);

        btnTambah = findViewById(R.id.btn_tambah); //inisialisasi value btnTambah
        btnLihat = findViewById(R.id.btn_liha); //inisialisasi value btnLihat

        AndroidNetworking.initialize(getApplicationContext()); //inisialisasi library FAN
        aksiButton();//memanggil fungsi aksiButton()
    }
    public void aksiButton(){
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString(); //mengambil Value etNim menjadi string
                String jurusan= etJurusan.getText().toString(); //mengambil Value etNim menjadi string
                String peminatan = etPeminatan.getText().toString(); //mengambil Value etNim menjadi string
                if (nama.equals("")||jurusan.equals("")||peminatan.equals("")){
                    Toast.makeText(getApplicationContext(),"Semua data harus diisi" , Toast.LENGTH_SHORT).show();
                    //memunculkan toast saat form masih ada yang kosong
                } else {
                    tambahData(nama,jurusan,peminatan); //memanggil fungsi tambahData()
                    etNama.setText(""); //mengosongkan form setelah data berhasil ditambahkan
                    etJurusan.setText("");
                    etPeminatan.setText("");
                }
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tutorial selanjutnya
                Intent lihat = new Intent(getApplicationContext(), ReadAllActivity.class);
                startActivity(lihat);
            }
        });
    }


    public void tambahData(String nama, String jurusan, String peminatan){
        //koneksi ke file create.php, jika menggunakan localhost gunakan ip sesuai dengan ip kamu
        AndroidNetworking.post("http://192.168.43.151/commit/create.php")
                .addBodyParameter("id_anggota", "") //id bersifat Auto_Increment tidak perlu diisi/(diisi NULL) cek create.php
                .addBodyParameter("nama_anggota",nama) //mengirimkan data nim_mahasiswa yang akan diisi dengan varibel nim
                .addBodyParameter("jurusan", jurusan) //mengirimkan data nama_mahasiswa yang akan diisi dengan varibel nama
                .addBodyParameter("peminatan", peminatan) //mengirimkan data kelas_mahasiswa yang akan diisi dengan varibel kelas
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Handle Response
                        Log.d(TAG, "onResponse: " + response); //untuk log pada onresponse
                        Toast.makeText(getApplicationContext(),"Data berhasil ditambahkan" , Toast.LENGTH_SHORT).show();
                        //memunculkan Toast saat data berhasil ditambahkan

                    }
                    @Override
                    public void onError(ANError error) {
                        //Handle Error
                        Log.d(TAG, "onError: Failed" + error); //untuk log pada onerror
                        Toast.makeText(getApplicationContext(),"Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                        //memunculkan Toast saat data gagal ditambahkan
                    }
                });
    }
}


