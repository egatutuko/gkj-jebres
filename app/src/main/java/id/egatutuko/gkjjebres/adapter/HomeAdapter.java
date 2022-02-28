package id.egatutuko.gkjjebres.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.activity.Baptis_anak;
import id.egatutuko.gkjjebres.activity.Baptis_dewasa;
import id.egatutuko.gkjjebres.activity.Home;
import id.egatutuko.gkjjebres.activity.Info;
import id.egatutuko.gkjjebres.activity.Jadwal;
import id.egatutuko.gkjjebres.activity.Katekisasi;
import id.egatutuko.gkjjebres.activity.Kontak;
import id.egatutuko.gkjjebres.activity.MainActivity;
import id.egatutuko.gkjjebres.activity.Pernikahan_daftar;
import id.egatutuko.gkjjebres.activity.Pra_nikah;
import id.egatutuko.gkjjebres.activity.Profil;
import id.egatutuko.gkjjebres.activity.Renungan;
import id.egatutuko.gkjjebres.activity.VideoIbadah;
import id.egatutuko.gkjjebres.activity.Warta;
import id.egatutuko.gkjjebres.model.RecyclerDataHome;
import id.egatutuko.gkjjebres.utils.SessionManager;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.RVHolderHome> {

    private final ArrayList<RecyclerDataHome> courseDataArrayList;
    private final Context context;
    private SessionManager sessionManager;
    private Activity activity;

    //Java Doc
    public HomeAdapter(ArrayList<RecyclerDataHome> recyclerDataArrayList, Context context){

        this.courseDataArrayList = recyclerDataArrayList;
        this.context = context;

    }

    // View Holder Class to handle Recycler View.
    public class RVHolderHome extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView text_menu;
        private final ImageView image_menu;
        public RVHolderHome(@NonNull View itemView) {
            super(itemView);
            text_menu = itemView.findViewById(R.id.textView_menu);
            image_menu = itemView.findViewById(R.id.imageView_menu);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            final Intent intent;
            sessionManager = new SessionManager(context.getApplicationContext());
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
                    intent = new Intent(context, Baptis_anak.class);
                    break;
                case 7:
                    intent = new Intent(context, Baptis_dewasa.class);
                    break;
                case 8:
                    intent = new Intent(context, Katekisasi.class);
                    break;
                case 9:
                    intent = new Intent(context, Pernikahan_daftar.class);
                    break;
                case 10:
                    intent = new Intent(context, Pra_nikah.class);
                    break;
                case 11:
                    intent = new Intent(context, Profil.class);
                    break;
                case 12:
                    sessionManager.logoutSession();
                    intent = new Intent(context, MainActivity.class);
                    ((MainActivity)context).finishAndRemoveTask();
                    break;
                default:
                    intent = new Intent(context, Home.class);
                    break;
            }
            context.startActivity(intent);
        }
    }

    public RVHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_home, parent, false);
        return new RVHolderHome(view);
    }


    public void onBindViewHolder(RVHolderHome holder, int position) {
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
