package id.egatutuko.gkjjebres.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WartaModel implements Serializable {
    /*Integer logo;*/
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("tanggal")
    @Expose
    String tanggal;
    @SerializedName("judul")
    @Expose
    String judul;
    @SerializedName("file")
    @Expose
    String file;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
