package id.egatutuko.gkjjebres.adapter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.VideoYT;
import id.egatutuko.gkjjebres.utils.ChangeTo;

public class VideoIbadahAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<VideoYT> videoList;

    public VideoIbadahAdapter(Context context, List<VideoYT> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    class VideoHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView title, tanggal;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.imageView_logo);
            title = itemView.findViewById(R.id.textView_title);
            tanggal = itemView.findViewById(R.id.textView_tanggal);
        }

        public void setData(VideoYT data){
            String getJudul = data.getSnippet().getTitle();
            String getTgl = data.getSnippet().getPublishedAt();
            String getThumb = data.getSnippet().getThumbnails().getMedium().getUrl();


            itemView.setOnClickListener(v -> {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+data.getId().getVideoId()));
                context.startActivity(appIntent);
            });

            title.setText(getJudul);
            tanggal.setText("Diupload tanggal : " +ChangeTo.dateFormated(getTgl));
            Picasso.get()
                    .load(getThumb)
                    .placeholder(R.drawable.ic_logo_gkj)
                    .fit()
                    .centerCrop()
                    .into(thumbnail, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d(TAG, "Thumbnail berhasil ditampilkan");
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d(TAG, "Thumbnail error: ", e);
                        }
                    });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_default, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoYT videoYT = videoList.get(position);
        VideoHolder vh = (VideoHolder) holder;
        vh.setData(videoYT);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
