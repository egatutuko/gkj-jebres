package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Katekisasi extends AppCompatActivity {

    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date, nama, nomor, email, tgl_daftar;
    private TextInputEditText nm, nmr, em;
    private Button btDaftar;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katekisasi);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Tanggal daftar*/
        dateTimeDisplay = findViewById(R.id.tgl_skrg);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        /**Binding*/
        nm = findViewById(R.id.nama);
        nmr = findViewById(R.id.nomor);
        em = findViewById(R.id.email);
        btDaftar = findViewById(R.id.submit);

        btDaftar.setOnClickListener(v -> {
            if (nm.getText().toString().isEmpty() || nmr.getText().toString().isEmpty() || em.getText().toString().isEmpty()){
                Toast.makeText(Katekisasi.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else {
                createPost();
            }
        });
    }

    public void createPost(){
        /**Progress dialog*/
        progress = new ProgressDialog(Katekisasi.this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        /**Ambil data*/
        tgl_daftar = dateTimeDisplay.getText().toString();
        nama = nm.getText().toString().trim();
        nomor = nmr.getText().toString().trim();
        email = em.getText().toString().trim();

        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);

        Call<Value> call = apiService.daftarKatekisasi(tgl_daftar,nama, nomor, email);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progress.dismiss();
                if(response.body().getValue().equals("1")){
                    Toast.makeText(Katekisasi.this,"Berhasil daftar",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Katekisasi.this,"Gagal daftar",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(Katekisasi.this,"Jaringan Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}