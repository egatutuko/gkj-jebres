package id.egatutuko.gkjjebres.activity.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import id.egatutuko.gkjjebres.R;

public class Detail_Renungan extends AppCompatActivity {

    private TextView title, tanggal, tulis, desk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_renungan);

        /**Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        String judul = "Judul";
        String tgl = "Tanggal";
        String penulis = "Penulis";
        String deskripsi = "Deskripsi";

        title = findViewById(R.id.title);
        tanggal = findViewById(R.id.tgl);
        tulis = findViewById(R.id.penulis);
        desk = findViewById(R.id.deskripsi);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            judul = extras.getString("judul");
            tgl = extras.getString("tgl");
            penulis = extras.getString("penulis");
            deskripsi = extras.getString("deskripsi");
        }

        title.setText(judul);
        tanggal.setText(tgl);
        tulis.setText("Ditulis oleh: "+penulis);
        desk.setText(deskripsi);

    }
}