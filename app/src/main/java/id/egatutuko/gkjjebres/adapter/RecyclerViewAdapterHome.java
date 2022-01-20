package id.egatutuko.gkjjebres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.activity.Info;
import id.egatutuko.gkjjebres.activity.Baptis;
import id.egatutuko.gkjjebres.activity.Jadwal;
import id.egatutuko.gkjjebres.activity.Katekisasi;
import id.egatutuko.gkjjebres.activity.Kontak;
import id.egatutuko.gkjjebres.activity.MainActivity;
import id.egatutuko.gkjjebres.activity.Pernikahan;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.RecyclerDataHome;
import id.egatutuko.gkjjebres.activity.Renungan;
import id.egatutuko.gkjjebres.activity.VideoIbadah;
import id.egatutuko.gkjjebres.activity.Warta;

public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.RecyclerViewHolder> {

    private final ArrayList<RecyclerDataHome> courseDataArrayList;
    private final Context context;

    //Java Doc
    public RecyclerViewAdapterHome(ArrayList<RecyclerDataHome> recyclerDataArrayList, Context context){

        this.courseDataArrayList = recyclerDataArrayList;
        this.context = context;

    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView text_menu;
        private final ImageView image_menu;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            text_menu = itemView.findViewById(R.id.textView_menu);
            image_menu = itemView.findViewById(R.id.imageView_menu);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            final Intent intent;
            switch (getBindingAdapterPosition()){
                case 0:
                    intent = new Intent(context, Info.class);
                    break;
                case 1:
                    intent = new Intent(context, Warta.class);
                    break;
                case 2:
                    intent = new Intent(context, VideoIbadah.class);
                    break;
                case 3:
                    intent = new Intent(context, Renungan.class);
                    break;
                case 4:
                    intent = new Intent(context, Jadwal.class);
                    break;
                case 5:
                    intent = new Intent(context, Kontak.class);
                    break;
                case 6:
                    intent = new Intent(context, Baptis.class);
                    break;
                case 7:
                    intent = new Intent(context, Katekisasi.class);
                    break;
                case 8:
                    intent = new Intent(context, Pernikahan.class);
                    break;
                default:
                    intent = new Intent(context, MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_home, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerDataHome recyclerData = courseDataArrayList.get(position);
        holder.text_menu.setText(recyclerData.getTitle());
        holder.image_menu.setImageResource(recyclerData.getImgid());
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }



}
