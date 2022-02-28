package id.egatutuko.gkjjebres.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import id.egatutuko.gkjjebres.model.LoginData;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID = "id";
    public static final String NO_INDUK = "no_induk";
    public static final String KELOMPOK_GEREJA = "kelompok_gereja";
    public static final String NAMA = "nama";
    public static final String TEMPAT_LAHIR = "tempat_lahir";
    public static final String TANGGAL_LAHIR = "tanggal_lahir";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String NO_HP = "no_hp";
    public static final String ALAMAT = "alamat";
    public static final String PENDIDIKAN = "pendidikan";
    public static final String PEKERJAAN = "pekerjaan";
    public static final String STATUS_NIKAH = "status_nikah";
    public static final String NAMA_PASANGAN = "nama_pasangan";
    public static final String PEKERJAAN_PASANGAN = "pekerjaan_pasangan";
    public static final String NAMA_AYAH = "nama_ayah";
    public static final String NAMA_IBU = "nama_ibu";
    public static final String ALAMAT_ORTU = "alamat_ortu";
    public static final String PEKERJAAN_ORTU = "pekerjaan_ortu";
    public static final String GEREJA_ORTU = "gereja_ortu";
    public static final String KEWARGAAN_GEREJA = "kewargaan_gereja";
    public static final String ALAMAT_GEREJA = "alamat_gereja";
    public static final String TGL_BAPTIS = "tgl_baptis";
    public static final String TEMPAT_BAPTIS = "tempat_baptis";
    public static final String EMAIL = "email";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, user.getId());
        editor.putString(NO_INDUK, user.getNoInduk());
        editor.putString(KELOMPOK_GEREJA, user.getKelompokGereja());
        editor.putString(NAMA, user.getNama());
        editor.putString(TEMPAT_LAHIR, user.getTempatLahir());
        editor.putString(TANGGAL_LAHIR, user.getTanggalLahir());
        editor.putString(JENIS_KELAMIN, user.getJenisKelamin());
        editor.putString(NO_HP, user.getNoHp());
        editor.putString(ALAMAT, user.getAlamat());
        editor.putString(PENDIDIKAN, user.getPendidikan());
        editor.putString(PEKERJAAN, user.getPekerjaan());
        editor.putString(STATUS_NIKAH, user.getStatusNikah());
        editor.putString(NAMA_PASANGAN, user.getNamaPasangan());
        editor.putString(PEKERJAAN_PASANGAN, user.getPekerjaanPasangan());
        editor.putString(NAMA_AYAH, user.getNamaAyah());
        editor.putString(NAMA_IBU, user.getNamaIbu());
        editor.putString(ALAMAT_ORTU, user.getAlamatOrtu());
        editor.putString(PEKERJAAN_ORTU, user.getPekerjaanOrtu());
        editor.putString(GEREJA_ORTU, user.getGerejaOrtu());
        editor.putString(KEWARGAAN_GEREJA, user.getKewargaanGereja());
        editor.putString(ALAMAT_GEREJA, user.getAlamatGereja());
        editor.putString(TGL_BAPTIS, user.getTglBaptis());
        editor.putString(TEMPAT_BAPTIS, user.getTempatBaptis());
        editor.putString(EMAIL, user.getEmail());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID,null));
        user.put(NO_INDUK, sharedPreferences.getString(NO_INDUK,null));
        user.put(KELOMPOK_GEREJA, sharedPreferences.getString(KELOMPOK_GEREJA,null));
        user.put(NAMA, sharedPreferences.getString(NAMA,null));
        user.put(TEMPAT_LAHIR, sharedPreferences.getString(TEMPAT_LAHIR,null));
        user.put(TANGGAL_LAHIR, sharedPreferences.getString(TANGGAL_LAHIR,null));
        user.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN,null));
        user.put(NO_HP, sharedPreferences.getString(NO_HP,null));
        user.put(ALAMAT, sharedPreferences.getString(ALAMAT,null));
        user.put(PENDIDIKAN, sharedPreferences.getString(PENDIDIKAN,null));
        user.put(PEKERJAAN, sharedPreferences.getString(PEKERJAAN,null));
        user.put(STATUS_NIKAH, sharedPreferences.getString(STATUS_NIKAH,null));
        user.put(NAMA_PASANGAN, sharedPreferences.getString(NAMA_PASANGAN,null));
        user.put(PEKERJAAN_PASANGAN, sharedPreferences.getString(PEKERJAAN_PASANGAN,null));
        user.put(NAMA_AYAH, sharedPreferences.getString(NAMA_AYAH,null));
        user.put(NAMA_IBU, sharedPreferences.getString(NAMA_IBU,null));
        user.put(ALAMAT_ORTU, sharedPreferences.getString(ALAMAT_ORTU,null));
        user.put(PEKERJAAN_ORTU, sharedPreferences.getString(PEKERJAAN_ORTU,null));
        user.put(GEREJA_ORTU, sharedPreferences.getString(GEREJA_ORTU,null));
        user.put(KEWARGAAN_GEREJA, sharedPreferences.getString(KEWARGAAN_GEREJA,null));
        user.put(ALAMAT_GEREJA, sharedPreferences.getString(ALAMAT_GEREJA,null));
        user.put(TGL_BAPTIS, sharedPreferences.getString(TGL_BAPTIS,null));
        user.put(TEMPAT_BAPTIS, sharedPreferences.getString(TEMPAT_BAPTIS,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }
}
