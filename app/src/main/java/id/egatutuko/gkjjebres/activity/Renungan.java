package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.adapter.RenunganAdapter;
import id.egatutuko.gkjjebres.adapter.VideoIbadahAdapter;
import id.egatutuko.gkjjebres.model.RecyclerDataRenungan;
import id.egatutuko.gkjjebres.model.RecyclerDataVideoIbadah;

public class Renungan extends AppCompatActivity {

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<RecyclerDataRenungan> dataList = new ArrayList<>();
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));
        dataList.add(new RecyclerDataRenungan(R.drawable.ic_renungan,"Renungan","28 Juli 2021"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RenunganAdapter adapter = new RenunganAdapter(dataList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}