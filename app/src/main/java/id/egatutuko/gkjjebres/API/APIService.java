package id.egatutuko.gkjjebres.API;

import id.egatutuko.gkjjebres.model.BaptisAnak;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    /*@FormUrlEncoded
    @POST("/insertBaptisAnak.php")
    Call<BaptisAnak>daftar(@Field("tgl_daftar") String tgl_daftar,
                           @Field("nm_ayah") String nm_ayah,
                           @Field("agt_grj_ayah") String agt_grj_ayah,
                           @Field("almt_ayah") String almt_ayah,
                           @Field("no_induk_ayah") String no_induk_ayah,
                           @Field("agt_klp_ayah") String agt_klp_ayah,
                           @Field("nm_ibu") String nm_ibu,
                           @Field("agt_grj_ibu") String agt_grj_ibu,
                           @Field("almt_ibu") String almt_ibu,
                           @Field("no_induk_ibu") String no_induk_ibu,
                           @Field("agt_klp_ibu") String agt_klp_ibu,
                           @Field("nm_anak") String nm_anak,
                           @Field("tempat_lahir") String tempat_lahir,
                           @Field("no_akta") String no_akta,
                           @Field("tempat_baptis") String tempat_baptis,
                           @Field("jam_baptis") String jam_baptis);
    */


    @POST("/insertBaptisAnak.php")
    Call<BaptisAnak>daftar(@Body BaptisAnak baptisAnak);

}

//@Field("jk") String jk,//@Field("tgl_lahir") String tgl_lahir,//@Field("file_akta") String file_akta,//@Field("status_sipil") String status_sipil,//@Field("tgl_lapor") String tgl_lapor,//@Field("tgl_baptis") String tgl_baptis,
