package id.egatutuko.gkjjebres.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;

public class RenunganModel implements Serializable {
    /*Integer logo;*/
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("judul")
    @Expose
    String judul;
    @SerializedName("tgl")
    @Expose
    String tgl;
    @SerializedName("penulis")
    @Expose
    String penulis;
    @SerializedName("deskripsi")
    @Expose
    String deskripsi;

    public RenunganModel(String id, String judul, String tgl, String penulis, String deskripsi) {
        this.id = id;
        this.judul = judul;
        this.tgl = tgl;
        this.penulis = penulis;
        this.deskripsi = deskripsi;
    }

    /*public Integer getLogo() {
        return logo;
    }*/

    /*public void setLogo(Integer logo) {
        this.logo = logo;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
