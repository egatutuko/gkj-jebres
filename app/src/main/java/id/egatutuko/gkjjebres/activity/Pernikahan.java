package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.egatutuko.gkjjebres.R;

public class Pernikahan extends AppCompatActivity implements View.OnClickListener{

    private Button pra_nikah, pernikahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pernikahan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        pra_nikah = findViewById(R.id.pra_nikah);
        pernikahan = findViewById(R.id.pernikahan);
        pra_nikah.setOnClickListener(this);
        pernikahan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.pra_nikah:
                intent = new Intent(Pernikahan.this, Pra_nikah.class);
                startActivity(intent);
                break;
            case R.id.pernikahan:
                intent = new Intent(Pernikahan.this, Pernikahan_daftar.class);
                startActivity(intent);
                break;
        }
    }
}