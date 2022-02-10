package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.activity.detail.Detail_Renungan;
import id.egatutuko.gkjjebres.adapter.RenunganAdapter;
import id.egatutuko.gkjjebres.model.RenunganModel;
import id.egatutuko.gkjjebres.model.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Renungan extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RenunganModel> results = new ArrayList<>();
    private RenunganAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renungan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**RecyclerView*/
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setOnClickListner();
        loadRenungan();
        /**
        RenunganAdapter adapter = new RenunganAdapter(dataList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        ArrayList<RecyclerDataRenungan> dataList = new ArrayList<>();
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","23 Januari 2022"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","22 Januari 2022"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","15 Januari 2022"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","11 Desember 2022"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","8 Januari 2022"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan Pagi","7 Januari 2022"));
        */
    }

    private void loadRenungan(){
        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);
        Call<Value> call = apiService.getDataRenungan();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                //String value = response.body().getValue();
                if (response.body().getValue().equals("1")) {
                    results = response.body().getResult();

                    RenunganAdapter adapter = new RenunganAdapter(Renungan.this, results,listener);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(Renungan.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOnClickListner(){
        listener = (v, position) -> {
            Intent intent = new Intent(getApplicationContext(), Detail_Renungan.class);
            intent.putExtra("judul",results.get(position).getJudul());
            intent.putExtra("tgl",results.get(position).getTgl());
            intent.putExtra("penulis",results.get(position).getPenulis());
            intent.putExtra("deskripsi",results.get(position).getDeskripsi());
            startActivity(intent);
        };
    }

}