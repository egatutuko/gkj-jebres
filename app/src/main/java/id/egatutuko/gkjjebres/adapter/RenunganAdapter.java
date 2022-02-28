package id.egatutuko.gkjjebres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.RenunganModel;

public class RenunganAdapter extends RecyclerView.Adapter<RenunganAdapter.RecyclerViewHolder> {

    private List<RenunganModel> results;
    private Context context;
    private RecyclerViewClickListener listener;

    public RenunganAdapter(Context context, List<RenunganModel> results, RecyclerViewClickListener listener){
        this.results = results;
        this.context = context;
        this.listener = listener;
    }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout parentLayout;
        private final ImageView logo;
        private final TextView id, judul, tanggal, deskripsi, penulis;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imageView_logo);
            id = itemView.findViewById(R.id.textView_id);
            judul = itemView.findViewById(R.id.textView_title);
            tanggal = itemView.findViewById(R.id.textView_tanggal);
            penulis = itemView.findViewById(R.id.textView_penulis);
            deskripsi = itemView.findViewById(R.id.textView_desc);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
            /**final Intent intent;
            intent = new Intent(context, Detail_Renungan.class);
            context.startActivity(intent);*/
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_renungan,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RenunganModel result = results.get(position);
        //holder.logo.setImageResource(result.getLogo());
        holder.id.setText(result.getId());
        holder.judul.setText(result.getJudul());
        holder.tanggal.setText(result.getTgl());
        holder.penulis.setText("Ditulis oleh : " +result.getPenulis());
        holder.deskripsi.setText(result.getDeskripsi());

        /**
        RecyclerDataRenungan recyclerData = listRenungan.get(position);
        holder.logo.setImageResource(recyclerData.getLogo());
        holder.title.setText(recyclerData.getTitle());
        holder.tanggal.setText(recyclerData.getTanggal());
        */
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return results.size();
    }

    public interface RecyclerViewClickListener{
            void onClick(View v, int position);
    }

    /***
    public interface ClickedItem{
        public void ClickedRenungan (RecyclerDataRenungan recyclerResponse);
    }*/

}
