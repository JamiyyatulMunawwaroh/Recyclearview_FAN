package com.jamiyyatulmunawwaroh.recyclearview_fan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ViewHolder> {

    private List<DataAnggota> dataAnggota; //inisialisasi List dengan object DataMahasiswa


    //construktor com.jamiyyatulmunawwaroh.recyclearview_fan.ListMahasiswaAdapter
    public ListMahasiswaAdapter(ReadAllActivity readAllActivity, List<DataAnggota> dataAnggota) {
        this.dataAnggota = dataAnggota;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view yang akan digunakan yaitu layout list_mahasiswa_row.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_anggota_row, parent, false);
        ViewHolder holder = new ViewHolder(v); //inisialisasi ViewHolder
        return holder;
    } //fungsi yang dijalankan saat ViewHolder dibuat

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataAnggota data = dataAnggota.get(position); //inisialisasi object DataMahasiwa
        holder.mNama.setText(data.getNamaAnggota()); //menset value view "mNama" sesuai data dari getNamaMahasiswa();
        holder.mPeminatan.setText(data.getPeminatan()); //menset value view "mNim" sesuai data dari getNimMahasiswa();
    }

    @Override
    public int getItemCount() {
        return dataAnggota.size(); //mengambil item sesuai urutan
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView  mNama, mPeminatan; //inisialisasi variabel

        public ViewHolder(View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.textListAnggotaNama); //find layout sesuai dengan yg di list_mahasiswa_row.xml
            mPeminatan = itemView.findViewById(R.id.textListPeminatan); //find layout sesuai dengan yg di list_mahasiswa_row.xml
        }
    }
}
