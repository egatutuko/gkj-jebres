package id.egatutuko.gkjjebres.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.activity.detail.DetailWartaJemaat;
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
