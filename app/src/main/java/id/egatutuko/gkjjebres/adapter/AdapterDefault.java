package id.egatutuko.gkjjebres.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class AdapterDefault extends RecyclerView.Adapter<AdapterDefault.RecyclerViewHolder> {

    @NonNull
    @NotNull
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(@NonNull @NotNull AdapterDefault.RecyclerViewHolder holder, int position) {

    }

    public int getItemCount() {
        return 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
