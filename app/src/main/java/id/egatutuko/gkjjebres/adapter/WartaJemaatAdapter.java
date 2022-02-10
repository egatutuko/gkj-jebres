package id.egatutuko.gkjjebres.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.activity.Baptis;
import id.egatutuko.gkjjebres.activity.Info;
import id.egatutuko.gkjjebres.activity.Jadwal;
import id.egatutuko.gkjjebres.activity.Katekisasi;
import id.egatutuko.gkjjebres.activity.Kontak;
import id.egatutuko.gkjjebres.activity.MainActivity;
import id.egatutuko.gkjjebres.activity.Pernikahan;
import id.egatutuko.gkjjebres.activity.Renungan;
import id.egatutuko.gkjjebres.activity.VideoIbadah;
import id.egatutuko.gkjjebres.activity.Warta;
import id.egatutuko.gkjjebres.model.RecyclerDataWartaJemaat;

public class WartaJemaatAdapter extends RecyclerView.Adapter<WartaJemaatAdapter.RecyclerViewHolder> {

    private final ArrayList<RecyclerDataWartaJemaat> dataList;
    private final Context context;

    public WartaJemaatAdapter(ArrayList<RecyclerDataWartaJemaat> recyclerDataArrayList, Context context){
        this.dataList = recyclerDataArrayList;
        this.context = context;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final ImageView logo;
        private final TextView title;
        private final TextView tanggal;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imageView_logo);
            title = itemView.findViewById(R.id.textView_title);
            tanggal = itemView.findViewById(R.id.textView_tanggal);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            Intent intent = new Intent();
            String url1 = "https://drive.google.com/file/d/1hHi9NVycw39HnwU1Hb50MArYeontTcFN/view?usp=sharing";
            String url2 = "https://drive.google.com/file/d/1zBPbhKtNSc7I0Av1Ku8aJCISt3FjHtFP/view?usp=sharing";
            String url3 = "https://drive.google.com/file/d/1QQiCezlJO3JU7pIleE1CIrr2COPK00se/view?usp=sharing";
            String url4 = "https://drive.google.com/file/d/17KRdgN6TOcZ5w7QoaAIUI82tpTmedPTg/view?usp=sharing";
            String url5 = "https://drive.google.com/file/d/1_BwKFY9t75QxhvcdTY8OGrXT4oqOYiEo/view?usp=sharing";
            switch (getBindingAdapterPosition()){
                case 0:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
                    break;
                case 1:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                    break;
                case 2:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
                    break;
                case 4:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                    break;
                default:
                break;
            }
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_warta_jemaat, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerDataWartaJemaat recyclerData = dataList.get(position);
        holder.logo.setImageResource(recyclerData.getLogo());
        holder.title.setText(recyclerData.getTitle());
        holder.tanggal.setText(recyclerData.getTanggal());
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return dataList.size();
    }



}
