package id.egatutuko.gkjjebres.model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("nama_pasangan")
	private String namaPasangan;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("pendidikan")
	private String pendidikan;

	@SerializedName("nama_ibu")
	private String namaIbu;

	@SerializedName("tempat_baptis")
	private String tempatBaptis;

	@SerializedName("pekerjaan_pasangan")
	private String pekerjaanPasangan;

	@SerializedName("gereja_ortu")
	private String gerejaOrtu;

	@SerializedName("pekerjaan_ortu")
	private String pekerjaanOrtu;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("alamat_gereja")
	private Object alamatGereja;

	@SerializedName("kelompok gereja")
	private Object kelompokGereja;

	@SerializedName("kewargaan_gereja")
	private String kewargaanGereja;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tempat_lahir")
	private String tempatLahir;

	@SerializedName("pekerjaan")
	private String pekerjaan;

	@SerializedName("alamat_ortu")
	private String alamatOrtu;

	@SerializedName("tgl_baptis")
	private String tglBaptis;

	@SerializedName("nama_ayah")
	private String namaAyah;

	@SerializedName("id")
	private String id;

	@SerializedName("no_induk")
	private Object noInduk;

	@SerializedName("status_nikah")
	private String statusNikah;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("tanggal_lahir")
	private String tanggalLahir;

	@SerializedName("email")
	private String email;

	public void setNamaPasangan(String namaPasangan){
		this.namaPasangan = namaPasangan;
	}

	public String getNamaPasangan(){
		return namaPasangan;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setPendidikan(String pendidikan){
		this.pendidikan = pendidikan;
	}

	public String getPendidikan(){
		return pendidikan;
	}

	public void setNamaIbu(String namaIbu){
		this.namaIbu = namaIbu;
	}

	public String getNamaIbu(){
		return namaIbu;
	}

	public void setTempatBaptis(String tempatBaptis){
		this.tempatBaptis = tempatBaptis;
	}

	public String getTempatBaptis(){
		return tempatBaptis;
	}

	public void setPekerjaanPasangan(String pekerjaanPasangan){
		this.pekerjaanPasangan = pekerjaanPasangan;
	}

	public String getPekerjaanPasangan(){
		return pekerjaanPasangan;
	}

	public void setGerejaOrtu(String gerejaOrtu){
		this.gerejaOrtu = gerejaOrtu;
	}

	public String getGerejaOrtu(){
		return gerejaOrtu;
	}

	public void setPekerjaanOrtu(String pekerjaanOrtu){
		this.pekerjaanOrtu = pekerjaanOrtu;
	}

	public String getPekerjaanOrtu(){
		return pekerjaanOrtu;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setAlamatGereja(Object alamatGereja){
		this.alamatGereja = alamatGereja;
	}

	public Object getAlamatGereja(){
		return alamatGereja;
	}

	public void setKelompokGereja(Object kelompokGereja){
		this.kelompokGereja = kelompokGereja;
	}

	public Object getKelompokGereja(){
		return kelompokGereja;
	}

	public void setKewargaanGereja(String kewargaanGereja){
		this.kewargaanGereja = kewargaanGereja;
	}

	public String getKewargaanGereja(){
		return kewargaanGereja;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return tempatLahir;
	}

	public void setPekerjaan(String pekerjaan){
		this.pekerjaan = pekerjaan;
	}

	public String getPekerjaan(){
		return pekerjaan;
	}

	public void setAlamatOrtu(String alamatOrtu){
		this.alamatOrtu = alamatOrtu;
	}

	public String getAlamatOrtu(){
		return alamatOrtu;
	}

	public void setTglBaptis(String tglBaptis){
		this.tglBaptis = tglBaptis;
	}

	public String getTglBaptis(){
		return tglBaptis;
	}

	public void setNamaAyah(String namaAyah){
		this.namaAyah = namaAyah;
	}

	public String getNamaAyah(){
		return namaAyah;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNoInduk(Object noInduk){
		this.noInduk = noInduk;
	}

	public Object getNoInduk(){
		return noInduk;
	}

	public void setStatusNikah(String statusNikah){
		this.statusNikah = statusNikah;
	}

	public String getStatusNikah(){
		return statusNikah;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}