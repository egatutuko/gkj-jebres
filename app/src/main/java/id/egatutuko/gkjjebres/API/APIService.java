package id.egatutuko.gkjjebres.API;

import id.egatutuko.gkjjebres.model.LoginModel;
import id.egatutuko.gkjjebres.model.Value;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/api/insertBaptisAnak.php")
    Call<Value>daftarBaptisAnak
              (@Field("tgl_daftar") String tgl_daftar,
               @Field("nm_ayah") String nm_ayah,
               @Field("agt_grj_ayah") String agt_grj_ayah,
               @Field("almt_ayah") String almt_ayah,
               @Field("nohp_a") String nohp_a,
               @Field("no_induk_ayah") String no_induk_ayah,
               @Field("agt_klp_ayah") String agt_klp_ayah,
               @Field("nm_ibu") String nm_ibu,
               @Field("agt_grj_ibu") String agt_grj_ibu,
               @Field("almt_ibu") String almt_ibu,
               @Field("nohp_i") String nohp_i,
               @Field("no_induk_ibu") String no_induk_ibu,
               @Field("agt_klp_ibu") String agt_klp_ibu,
               @Field("nm_anak") String nm_anak,
               @Field("jk") String jk,
               @Field("tempat_lahir") String tempat_lahir,
               @Field("tgl_lahir") String tgl_lahir,
               @Field("no_akta") String no_akta,
               @Field("file_akta") String file_akta,
               @Field("status_sipil") String status_sipil,
               @Field("tgl_lapor") String tgl_lapor);

    @FormUrlEncoded
    @POST("/api/insertBaptisDewasa.php")
    Call<Value>daftarBaptisDewasa
              (@Field("tgl_daftar") String tgl_daftar,
               @Field("nm_lengkap") String nm_lengkap,
               @Field("jk") String jk,
               @Field("almt") String almt,
               @Field("tgl_lahir") String tgl_lahir,
               @Field("tmpt_lahir") String tmpt_lahir,
               @Field("tgl_baptis_1") String tgl_baptis_1,
               @Field("tempat_baptis_1") String tempat_baptis_1,
               @Field("pembaptis") String pembaptis,
               @Field("tgl_nikah") String tgl_nikah,
               @Field("prosesi_nikah") String prosesi_nikah,
               @Field("pend") String pend,
               @Field("pekerjaan") String pekerjaan,
               @Field("almt_kerja") String almt_kerja,
               @Field("ket") String ket,
               @Field("nm_ayah") String nm_ayah,
               @Field("status_ayah") String status_ayah,
               @Field("agt_grj_ayah") String agt_grj_ayah,
               @Field("no_induk_ayah") String no_induk_ayah,
               @Field("nm_ibu") String nm_ibu,
               @Field("status_ibu") String status_ibu,
               @Field("agt_gereja_ibu") String agt_gereja_ibu,
               @Field("no_induk_ibu") String no_induk_ibu,
               @Field("almt_ortu") String almt_ortu,
               @Field("nm_tunangan") String nm_tunangan,
               @Field("status_tunangan") String status_tunangan,
               @Field("agt_grj_tunangan") String agt_grj_tunangan,
               @Field("no_induk_tunangan") String no_induk_tunangan,
               @Field("almt_tunangan") String almt_tunangan,
               @Field("tgl_bertunangan") String tgl_bertunangan,
               @Field("nm_pasangan") String nm_pasangan,
               @Field("status_pasangan") String status_pasangan,
               @Field("agt_grj_pasangan") String agt_grj_pasangan,
               @Field("no_induk_pasangan") String no_induk_pasangan,
               @Field("ket_nikah") String ket_nikah,
               @Field("jml_anak") String jml_anak,
               @Field("anak_dlm_asuhan") String anak_dlm_asuhan,
               @Field("pengajar_katekisasi") String pengajar_katekisasi,
               @Field("lama_katekisasi") String lama_katekisasi,
               @Field("tempat_katekisasi") String tempat_katekisasi,
               @Field("pilih_baptis") String pilih_baptis,
               @Field("tgl_baptis") String tgl_baptis,
               @Field("tempat_baptis") String tempat_baptis,
               @Field("jam_baptis") String jam_baptis);

    /**tgl_daftar,nm_lengkap,jk,almt,tgl_lahir,tmpt_lahir,
                                        tgl_baptis_1,tempat_baptis_1,pembaptis,tgl_nikah,prosesi_nikah,pend,pekerjaan,
                                        almt_kerja,ket,nm_ayah,status_ayah,agt_grj_ayah,no_induk_ayah,nm_ibu,status_ibu,
                                        agt_gereja_ibu,no_induk_ibu,almt_ortu,nm_tunangan,status_tunangan,agt_grj_tunangan,
                                        no_induk_tunangan,almt_tunangan,tgl_bertunangan,nm_pasangan,status_pasangan,agt_grj_pasangan,
                                        no_induk_pasangan,ket_nikah,jml_anak,anak_dlm_asuhan,pengajar_katekisasi,lama_katekisasi,
                                        tempat_katekisasi,pilih_baptis,tgl_baptis,tempat_baptis,jam_baptis*/
    
    @FormUrlEncoded
    @POST("/api/insertKatekisasi.php")
    Call<Value>daftarKatekisasi
              (@Field("tgl_daftar") String tgl_daftar,
               @Field("nama") String nama,
               @Field("nomor") String nomor,
               @Field("email") String email);

    @FormUrlEncoded
    @POST("/api/insertPernikahan.php")
    Call<Value>daftarPernikahan
              (@Field("tgl_daftar") String tgl_daftar,
               @Field("nama_csuami") String nama_csuami,
               @Field("tempat_lahir_csuami") String tempat_lahir_csuami,
               @Field("tgl_lahir_csuami") String tgl_lahir_csuami,
               @Field("agama_csuami") String agama_csuami,
               @Field("tgl_baptis_csuami") String tgl_baptis_csuami,
               @Field("alamat_csuami") String alamat_csuami,
               @Field("nama_ortu_csuami") String nama_ortu_csuami,
               @Field("agt_grj_csuami") String agt_grj_csuami,
               @Field("klp_csuami") String klp_csuami,
               @Field("saksi_csuami") String saksi_csuami,
               @Field("nama_cistri") String nama_cistri,
               @Field("tempat_lahir_cistri") String tempat_lahir_cistri,
               @Field("tgl_lahir_cistri") String tgl_lahir_cistri,
               @Field("agama_cistri") String agama_cistri,
               @Field("tgl_baptis_cistri") String tgl_baptis_cistri,
               @Field("alamat_cistri") String alamat_cistri,
               @Field("nama_ortu_cistri") String nama_ortu_cistri,
               @Field("agt_grj_cistri") String agt_grj_cistri,
               @Field("klp_cistri") String klp_cistri,
               @Field("saksi_cistri") String saksi_cistri,
               @Field("tgl_nikah") String tgl_nikah,
               @Field("jam_nikah") String jam_nikah,
               @Field("tempat_nikah") String tempat_nikah);

    /**tgl_daftar,nama_csuami,tempat_lahir_csuami,tgl_lahir_csuami,agama_csuami,tgl_baptis_csuami,
     alamat_csuami,nama_ortu_csuami,agt_grj_csuami,klp_csuami,saksi_csuami,nama_cistri,tempat_lahir_cistri,
     tgl_lahir_cistri,agama_cistri,tgl_baptis_cistri,alamat_cistri,nama_ortu_cistri,agt_grj_cistri,klp_cistri,saksi_cistri,
     tgl_nikah,jam_nikah,tempat_nikah*/

    @FormUrlEncoded
    @POST("/api/insertPranikah.php")
    Call<Value>daftarPraNikah
              (@Field("tgl_daftar") String tgl_daftar,
               @Field("nama") String nama,
               @Field("jk") String jk,
               @Field("umur") String umur,
               @Field("alamat") String alamat,
               @Field("tempat_lahir") String tempat_lahir,
               @Field("tgl_lahir") String tgl_lahir,
               @Field("tgl_baptis_1") String tgl_baptis_1,
               @Field("tempat_baptis_1") String tempat_baptis_1,
               @Field("pembaptis") String pembaptis,
               @Field("tgl_sidi") String tgl_sidi,
               @Field("tempat_sidi") String tempat_sidi,
               @Field("pend") String pend,
               @Field("pekerjaan") String pekerjaan,
               @Field("alamat_kerja") String alamat_kerja,
               @Field("ket") String ket,
               @Field("nama_tunangan") String nama_tunangan,
               @Field("status_tunangan") String status_tunangan,
               @Field("agt_grj_tunangan") String agt_grj_tunangan,
               @Field("no_induk_tunangan") String no_induk_tunangan,
               @Field("alamat_tunangan") String alamat_tunangan,
               @Field("tgl_nikah") String tgl_nikah,
               @Field("tempat_nikah") String tempat_nikah,
               @Field("jam_nikah") String jam_nikah);

    /**tgl_daftar,nama,jk,umur,alamat,tempat_lahir,
     tgl_lahir,tgl_baptis_1,tempat_baptis_1,pembaptis,tgl_sidi,tempat_sidi,pend,
     pekerjaan,alamat_kerja,ket,nama_tunangan,status_tunangan,agt_grj_tunangan,no_induk_tunangan,alamat_tunangan,
     tgl_nikah,tempat_nikah,jam_nikah*/

    @FormUrlEncoded
    @POST("/api/register.php")
    Call<Value> registUser(@Field("tg_daftar") String tgdaf,
                           @Field("nm") String nm,
                           @Field("tmp_lahir") String tmp_lahir,
                           @Field("tgl_lahir") String tgl_lahir,
                           @Field("jk") String jk,
                           @Field("nohp") String nohp,
                           @Field("almt") String almt,
                           @Field("pend") String pend,
                           @Field("kerja") String kerja,
                           @Field("nikah") String nikah,
                           @Field("nm_psgn") String nm_psgn,
                           @Field("kerja_psgn") String kerja_psgn,
                           @Field("nm_ayah") String nm_ayah,
                           @Field("nm_ibu") String nm_ibu,
                           @Field("almt_ortu") String almt_ortu,
                           @Field("kerja_ortu") String kerja_ortu,
                           @Field("grj_ortu") String grj_ortu,
                           @Field("grj_asal") String grj_asal,
                           @Field("almt_grj") String almt_grj,
                           @Field("tgl_baptis") String tgl_baptis,
                           @Field("email") String email,
                           @Field("pass") String pass);

    @FormUrlEncoded
    @POST("/api/login.php")
    Call<LoginModel> loginUser(@Field("email") String email,
                               @Field("pass") String pass);

    @GET("/api/getDataRenungan.php")
    Call<Value> getDataRenungan();

    /**@GET("/api/getDataJemaat.php")
    Call<Value> getDataJemaat();*/


    /**@POST("/insertBaptisAnak.php")
    Call<BaptisAnak>daftar(@Body BaptisAnak baptisAnak);
    */

}

//@Field("jk") String jk,//@Field("tgl_lahir") String tgl_lahir,//@Field("file_akta") String file_akta,//@Field("status_sipil") String status_sipil,//@Field("tgl_lapor") String tgl_lapor,//@Field("tgl_baptis") String tgl_baptis,

