package id.egatutuko.gkjjebres.fragment;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.List;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.adapter.VideoIbadahAdapter;
import id.egatutuko.gkjjebres.model.ModelVideo;
import id.egatutuko.gkjjebres.model.VideoYT;
import id.egatutuko.gkjjebres.API.YoutubeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentVideoIbadah extends Fragment {

    private VideoIbadahAdapter adapter;
    private LinearLayoutManager manager;
    private final List<VideoYT> videoList = new ArrayList<>();
    private boolean isScroll = false;
    private int currentItem, totalItem, scrollOutItem;
    private String nextPageToken = "";

    public FragmentVideoIbadah() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_ibadah, container, false);
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        adapter = new VideoIbadahAdapter(getContext(),videoList);
        manager = new LinearLayoutManager(getContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScroll = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = manager.getChildCount();
                totalItem = manager.getItemCount();
                scrollOutItem = manager.findFirstVisibleItemPosition();
                if (isScroll && (currentItem+scrollOutItem==totalItem)){
                    isScroll = false;
                    getJson();
                }
            }
        });


        if (videoList.size()==0){
            getJson();
        }

        return view;
    }

    private void getJson() {
        String url = YoutubeAPI.BASE_URL + YoutubeAPI.sch + YoutubeAPI.KEY + YoutubeAPI.chid + YoutubeAPI.max + YoutubeAPI.order + YoutubeAPI.part;
        if (nextPageToken != ""){
            url = url + YoutubeAPI.npt + nextPageToken;
        }
        if (nextPageToken == null){
            return;
        }
        Call<ModelVideo> data = YoutubeAPI.getVideoIbadahYT().getYT(url);
        data.enqueue(new Callback<ModelVideo>() {
            @Override
            public void onResponse(Call<ModelVideo> call, Response<ModelVideo> response) {
                if(response.errorBody() != null){
                    Log.v(TAG, "onResponse: " + response.errorBody());
                } else {
                    ModelVideo mv = response.body();
                    videoList.addAll(mv.getItems());
                    adapter.notifyDataSetChanged();
                    if (mv.getNextPageToken() != null){
                        nextPageToken = mv.getNextPageToken();
                    }
                }

            }

            @Override
            public void onFailure(Call<ModelVideo> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);

            }
        });
    }
}