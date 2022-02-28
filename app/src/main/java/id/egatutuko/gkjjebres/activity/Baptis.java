package id.egatutuko.gkjjebres.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import id.egatutuko.gkjjebres.R;

public class Baptis extends AppCompatActivity implements View.OnClickListener {

    private Button button_anak, button_dewasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baptis);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        button_anak = findViewById(R.id.button_anak);
        button_dewasa = findViewById(R.id.button_dewasa);
        button_anak.setOnClickListener(this);
        button_dewasa.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button_anak:
                intent = new Intent(Baptis.this, Baptis_anak.class);
                startActivity(intent);
            break;
            case R.id.button_dewasa:
                intent = new Intent(Baptis.this, Baptis_dewasa.class);
                startActivity(intent);
            break;
        }
    }
}