package id.egatutuko.gkjjebres.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.utils.SessionManager;

public class Profil extends AppCompatActivity {

    TextInputEditText noind, kgrj, tglLahir, tglBaptis, nmlengkap, tempat_lahir, alamat, pendidikan, pekerjaan, nama_pasangan, pekerjaan_pasangan, nama_ayah, nama_ibu,
            alamat_ortu, pekerjaan_ortu, gereja_ortu, gereja_asal, alamat_gereja, etEmail, status_nikah, jenkel, no_hp;
    String no_ind, kgrja, tgl_Lahir, tgl_Baptis, nm_lengkap, tempatlahir, alamatt, pend, kerja, namapasangan, pekerjaanpasangan, namaayah, namaibu,
           alamatortu, pekerjaanortu, gerejaortu, gerejaasal, alamatgereja, Email, statusnikah, jk, nohp;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sessionManager = new SessionManager(Profil.this);
        /**toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Binding*/
        noind = findViewById(R.id.noinduk);
        kgrj = findViewById(R.id.kgereja);
        tglLahir = findViewById(R.id.tgl_lahir);
        tglBaptis = findViewById(R.id.tgl_baptis);
        nmlengkap = findViewById(R.id.nmlengkap);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        alamat = findViewById(R.id.alamat);
        pendidikan = findViewById(R.id.pendidikan);
        pekerjaan = findViewById(R.id.pekerjaan);
        nama_pasangan = findViewById(R.id.nama_pasangan);
        pekerjaan_pasangan = findViewById(R.id.pekerjaan_pasangan);
        nama_ayah = findViewById(R.id.nama_ayah);
        nama_ibu = findViewById(R.id.nama_ibu);
        alamat_ortu = findViewById(R.id.alamat_ortu);
        pekerjaan_ortu = findViewById(R.id.pekerjaan_ortu);
        gereja_ortu = findViewById(R.id.gereja_ortu);
        gereja_asal = findViewById(R.id.gereja_asal);
        alamat_gereja = findViewById(R.id.alamat_gereja);
        etEmail = findViewById(R.id.email);
        status_nikah = findViewById(R.id.status_nikah);
        jenkel = findViewById(R.id.jeniskelamin);
        no_hp = findViewById(R.id.no_hp);

        /**Ambil data*/
        no_ind = sessionManager.getUserDetail().get(SessionManager.NO_INDUK);
        kgrja = sessionManager.getUserDetail().get(SessionManager.KELOMPOK_GEREJA);
        tgl_Lahir = sessionManager.getUserDetail().get(SessionManager.TANGGAL_LAHIR);
        tgl_Baptis = sessionManager.getUserDetail().get(SessionManager.TGL_BAPTIS);
        nm_lengkap = sessionManager.getUserDetail().get(SessionManager.NAMA);
        tempatlahir = sessionManager.getUserDetail().get(SessionManager.TEMPAT_LAHIR);
        alamatt = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        pend = sessionManager.getUserDetail().get(SessionManager.PENDIDIKAN);
        kerja = sessionManager.getUserDetail().get(SessionManager.PEKERJAAN);
        namapasangan = sessionManager.getUserDetail().get(SessionManager.NAMA_PASANGAN);
        pekerjaanpasangan = sessionManager.getUserDetail().get(SessionManager.PEKERJAAN_PASANGAN);
        namaayah = sessionManager.getUserDetail().get(SessionManager.NAMA_AYAH);
        namaibu = sessionManager.getUserDetail().get(SessionManager.NAMA_IBU);
        alamatortu = sessionManager.getUserDetail().get(SessionManager.ALAMAT_ORTU);
        pekerjaanortu = sessionManager.getUserDetail().get(SessionManager.PEKERJAAN_ORTU);
        gerejaortu = sessionManager.getUserDetail().get(SessionManager.GEREJA_ORTU);
        gerejaasal = sessionManager.getUserDetail().get(SessionManager.KEWARGAAN_GEREJA);
        alamatgereja = sessionManager.getUserDetail().get(SessionManager.ALAMAT_GEREJA);
        Email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        statusnikah = sessionManager.getUserDetail().get(SessionManager.STATUS_NIKAH);
        jk = sessionManager.getUserDetail().get(SessionManager.JENIS_KELAMIN);
        nohp = sessionManager.getUserDetail().get(SessionManager.NO_HP);

        /**Storing data*/
        noind.setText(no_ind);
        kgrj.setText(kgrja);
        tglLahir.setText(tgl_Lahir);
        tglBaptis.setText(tgl_Baptis);
        nmlengkap.setText(nm_lengkap);
        tempat_lahir.setText(tempatlahir);
        alamat.setText(alamatt);
        pendidikan.setText(pend);
        pekerjaan.setText(kerja);
        nama_pasangan.setText(namapasangan);
        pekerjaan_pasangan.setText(pekerjaanpasangan);
        nama_ayah.setText(namaayah);
        nama_ibu.setText(namaibu);
        alamat_ortu.setText(alamatortu);
        pekerjaan_ortu.setText(pekerjaanortu);
        gereja_ortu.setText(gerejaortu);
        gereja_asal.setText(gerejaasal);
        alamat_gereja.setText(alamatgereja);
        etEmail.setText(Email);
        status_nikah.setText(statusnikah);
        jenkel.setText(jk);
        no_hp.setText(nohp);
    }
}