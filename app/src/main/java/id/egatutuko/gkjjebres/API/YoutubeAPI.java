package id.egatutuko.gkjjebres.API;

import id.egatutuko.gkjjebres.model.ModelVideo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class YoutubeAPI {

    public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public static final String KEY = "key=AIzaSyCX_vvMBcwU5Kndp0jauQi_DY1u_28H9sw";
    public static final String sch = "search?";
    public static final String chid = "&channelId=UCzYomm8mBejYcvQPWLaX72A";
    public static final String max = "&maxResults=10";
    public static final String order = "&order=date";
    public static final String part = "&part=snippet";
    public static final String npt = "&pageToken=";

    public interface VideoIbadahYT {
        @GET
        Call<ModelVideo> getYT(@Url String url);
    }

    private static VideoIbadahYT videoIbadahYT = null;

    public static VideoIbadahYT getVideoIbadahYT(){
        if (videoIbadahYT == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            videoIbadahYT = retrofit.create(VideoIbadahYT.class);
        }
        return videoIbadahYT;
    }
}
