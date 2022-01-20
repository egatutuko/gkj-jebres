package id.egatutuko.gkjjebres.model;

public class RecyclerDataVideoIbadah {

    private Integer logo;
    private String title;
    private String tanggal;

    public RecyclerDataVideoIbadah(Integer logo, String title, String tanggal) {
        this.logo = logo;
        this.title = title;
        this.tanggal = tanggal;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "RecyclerDataWartaJemaat{" +
                "logo='" + logo + '\'' +
                ", title='" + title + '\'' +
                ", tanggal='" + tanggal + '\'' +
                '}';
    }
}
