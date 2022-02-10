package id.egatutuko.gkjjebres.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaptisAnak implements Serializable {

    @SerializedName("tgl_daftar")
    private String tgl_daftar;
    @SerializedName("nm_ayah")
    private String nm_ayah;
    @SerializedName("agt_grj_ayah")
    private String agt_grj_ayah;
    @SerializedName("almt_ayah")
    private String almt_ayah;
    @SerializedName("no_induk_ayah")
    private String no_induk_ayah;
    @SerializedName("agt_klp_ayah")
    private String agt_klp_ayah;
    @SerializedName("nm_ibu")
    private String nm_ibu;
    @SerializedName("agt_grj_ibu")
    private String agt_grj_ibu;
    @SerializedName("almt_ibu")
    private String almt_ibu;
    @SerializedName("no_induk_ibu")
    private String no_induk_ibu;
    @SerializedName("agt_klp_ibu")
    private String agt_klp_ibu;
    @SerializedName("nm_anak")
    private String nm_anak;
    @SerializedName("tempat_lahir")
    private String tempat_lahir;
    @SerializedName("no_akta")
    private String no_akta;
    @SerializedName("file_akta")
    private String file_akta;
    @SerializedName("tempat_baptis")
    private String tempat_baptis;
    @SerializedName("waktu_baptis")
    private String waktu_baptis;


    public BaptisAnak(String tgl_daftar, String nm_ayah, String agt_grj_ayah, String almt_ayah, String no_induk_ayah, String agt_klp_ayah, String nm_ibu, String agt_grj_ibu, String almt_ibu, String no_induk_ibu, String agt_klp_ibu, String nm_anak, String tempat_lahir, String no_akta, String tempat_baptis, String waktu_baptis) {
        this.tgl_daftar = tgl_daftar;
        this.nm_ayah = nm_ayah;
        this.agt_grj_ayah = agt_grj_ayah;
        this.almt_ayah = almt_ayah;
        this.no_induk_ayah = no_induk_ayah;
        this.agt_klp_ayah = agt_klp_ayah;
        this.nm_ibu = nm_ibu;
        this.agt_grj_ibu = agt_grj_ibu;
        this.almt_ibu = almt_ibu;
        this.no_induk_ibu = no_induk_ibu;
        this.agt_klp_ibu = agt_klp_ibu;
        this.nm_anak = nm_anak;
        this.tempat_lahir = tempat_lahir;
        this.no_akta = no_akta;
        this.tempat_baptis = tempat_baptis;
        this.waktu_baptis = waktu_baptis;
    }

    public String getFile_akta() {
        return file_akta;
    }

    public void setFile_akta(String file_akta) {
        this.file_akta = file_akta;
    }

    public String getTgl_daftar() {
        return tgl_daftar;
    }

    public void setTgl_daftar(String tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }

    public String getNm_ayah() {
        return nm_ayah;
    }

    public void setNm_ayah(String nm_ayah) {
        this.nm_ayah = nm_ayah;
    }

    public String getAgt_grj_ayah() {
        return agt_grj_ayah;
    }

    public void setAgt_grj_ayah(String agt_grj_ayah) {
        this.agt_grj_ayah = agt_grj_ayah;
    }

    public String getAlmt_ayah() {
        return almt_ayah;
    }

    public void setAlmt_ayah(String almt_ayah) {
        this.almt_ayah = almt_ayah;
    }

    public String getNo_induk_ayah() {
        return no_induk_ayah;
    }

    public void setNo_induk_ayah(String no_induk_ayah) {
        this.no_induk_ayah = no_induk_ayah;
    }

    public String getAgt_klp_ayah() {
        return agt_klp_ayah;
    }

    public void setAgt_klp_ayah(String agt_klp_ayah) {
        this.agt_klp_ayah = agt_klp_ayah;
    }

    public String getNm_ibu() {
        return nm_ibu;
    }

    public void setNm_ibu(String nm_ibu) {
        this.nm_ibu = nm_ibu;
    }

    public String getAgt_grj_ibu() {
        return agt_grj_ibu;
    }

    public void setAgt_grj_ibu(String agt_grj_ibu) {
        this.agt_grj_ibu = agt_grj_ibu;
    }

    public String getAlmt_ibu() {
        return almt_ibu;
    }

    public void setAlmt_ibu(String almt_ibu) {
        this.almt_ibu = almt_ibu;
    }

    public String getNo_induk_ibu() {
        return no_induk_ibu;
    }

    public void setNo_induk_ibu(String no_induk_ibu) {
        this.no_induk_ibu = no_induk_ibu;
    }

    public String getAgt_klp_ibu() {
        return agt_klp_ibu;
    }

    public void setAgt_klp_ibu(String agt_klp_ibu) {
        this.agt_klp_ibu = agt_klp_ibu;
    }

    public String getNm_anak() {
        return nm_anak;
    }

    public void setNm_anak(String nm_anak) {
        this.nm_anak = nm_anak;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getNo_akta() {
        return no_akta;
    }

    public void setNo_akta(String no_akta) {
        this.no_akta = no_akta;
    }

    public String getTempat_baptis() {
        return tempat_baptis;
    }

    public void setTempat_baptis(String tempat_baptis) {
        this.tempat_baptis = tempat_baptis;
    }

    public String getWaktu_baptis() {
        return waktu_baptis;
    }

    public void setWaktu_baptis(String waktu_baptis) {
        this.waktu_baptis = waktu_baptis;
    }
}
