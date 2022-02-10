package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.adapter.WartaJemaatAdapter;
import id.egatutuko.gkjjebres.model.RecyclerDataWartaJemaat;

public class Warta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warta);

        ArrayList<RecyclerDataWartaJemaat> dataList = new ArrayList<>();
        dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","23 Januari 2022"));
        dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","3 Desember 2021"));
        dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","28 November 2021"));
        dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","31 Oktober 2021"));
        dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","27 Juni 2021"));
        //dataList.add(new RecyclerDataWartaJemaat(R.drawable.ic_logo_gkj,"Warta Jemaat","28 Juli 2021"));

        /**Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**RecyclerView*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WartaJemaatAdapter adapter = new WartaJemaatAdapter(dataList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }
}