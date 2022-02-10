package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentBaptisAnak;
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentPernikahan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pernikahan_daftar extends AppCompatActivity implements DPFragmentPernikahan.DPFragmentListenerPernikahan {

    ProgressDialog progress;
    FragmentManager fm = getSupportFragmentManager();
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date, tgl_daftar, nama_csuami, tempat_lahir_csuami, tgl_lahir_csuami, agama_csuami, tgl_baptis_csuami,
                   alamat_csuami, nama_ortu_csuami, agt_grj_csuami, klp_csuami, saksi_csuami, nama_cistri, tempat_lahir_cistri,
                   tgl_lahir_cistri, agama_cistri, tgl_baptis_cistri, alamat_cistri, nama_ortu_cistri, agt_grj_cistri, klp_cistri, saksi_cistri,
                   tgl_nikah, jam_nikah, tempat_nikah;
    private TextInputEditText tglcsuami, tglbaptis1, tglcistri, tglbaptis2, tglmenikah,
                              nmcsuami,tmplahircsuami,agamacsuami,
                              alamatcsuami,namaortucsuami,agtgrjcsuami,klpcsuami,saksicsuami,namacistri,tempatlahircistri,
                              agamacistri,alamatcistri,namaortucistri,agtgrjcistri,klpcistri,saksicistri,
                              jamnikah,tempatnikah;
    int DATE_DIALOG = 0;
    private Button btDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pernikahan_daftar);

        /**Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Tgl Daftar*/
        dateTimeDisplay = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat ("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        /**Binding*/
        tglcsuami = findViewById(R.id.tglCsuami);
        tglbaptis1 = findViewById(R.id.tglBaptis1);
        tglcistri = findViewById(R.id.tglCistri);
        tglbaptis2 = findViewById(R.id.tglBaptis2);
        tglmenikah = findViewById(R.id.tglMenikah);
        btDaftar = findViewById(R.id.submit);
        nmcsuami = findViewById(R.id.nama_csuami);
        tmplahircsuami = findViewById(R.id.tempat_lahir);
        agamacsuami = findViewById(R.id.agama);
        alamatcsuami = findViewById(R.id.alamat_csuami);
        namaortucsuami = findViewById(R.id.nama_ortu_csuami);
        agtgrjcsuami = findViewById(R.id.agt_grj_csuami);
        klpcsuami = findViewById(R.id.klp_csuami);
        saksicsuami = findViewById(R.id.saksi_csuami);
        namacistri = findViewById(R.id.nama_cistri);
        tempatlahircistri = findViewById(R.id.tempat_lahir_cistri);
        agamacistri = findViewById(R.id.agama_cistri);
        alamatcistri = findViewById(R.id.alamat_cistri);
        namaortucistri = findViewById(R.id.nama_ortu_cistri);
        agtgrjcistri = findViewById(R.id.agt_grj_cistri);
        klpcistri = findViewById(R.id.klp_cistri);
        saksicistri = findViewById(R.id.saksi_cistri);
        jamnikah = findViewById(R.id.jam_nikah);
        tempatnikah = findViewById(R.id.tempat_nikah);

        /**Click Listener*/
        tglcsuami.setOnClickListener(v -> {
            DATE_DIALOG = 0;
            openDialog();
        });
        tglbaptis1.setOnClickListener(v -> {
            DATE_DIALOG = 1;
            openDialog();
        });
        tglcistri.setOnClickListener(v -> {
            DATE_DIALOG = 2;
            openDialog();
        });
        tglbaptis2.setOnClickListener(v -> {
            DATE_DIALOG = 3;
            openDialog();
        });
        tglmenikah.setOnClickListener(v -> {
            DATE_DIALOG = 4;
            openDialog();
        });
        btDaftar.setOnClickListener(v -> {
            if(nmcsuami.getText().toString().isEmpty() || tmplahircsuami.getText().toString().isEmpty() || tglcsuami.getText().toString().isEmpty()
            || agamacsuami.getText().toString().isEmpty() || namaortucsuami.getText().toString().isEmpty() || saksicsuami.getText().toString().isEmpty()
            || namacistri.getText().toString().isEmpty() || tempatlahircistri.getText().toString().isEmpty() || tglcistri.getText().toString().isEmpty()
            || agamacistri.getText().toString().isEmpty() || namaortucistri.getText().toString().isEmpty() || saksicistri.getText().toString().isEmpty()){
                Toast.makeText(Pernikahan_daftar.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else if(tglmenikah.getText().toString().isEmpty()){
                Toast.makeText(Pernikahan_daftar.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else {
                createPost();
            }
        });

    }

    /**Open calendar*/
    public void openDialog(){
        DPFragmentPernikahan dpDialog = new DPFragmentPernikahan();
        dpDialog.show(fm, "DATE PICK");
    }

    /**Pilih tgl*/
    @Override
    public void onDateSet(int year, int month, int day) {
        switch (DATE_DIALOG) {
            case 0:
                tglcsuami.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 1:
                tglbaptis1.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 2:
                tglcistri.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 3:
                tglbaptis2.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 4:
                tglmenikah.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            default:
        }
    }

    public void createPost(){
        /**Progress dialog*/
        progress = new ProgressDialog(Pernikahan_daftar.this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        /**Ambil data edittext*/
        tgl_daftar = dateTimeDisplay.getText().toString();
        nama_csuami = nmcsuami.getText().toString();
        tempat_lahir_csuami = tmplahircsuami.getText().toString();
        tgl_lahir_csuami = tglcsuami.getText().toString();
        agama_csuami = agamacsuami.getText().toString();
        tgl_baptis_csuami = tglbaptis1.getText().toString();
        alamat_csuami = alamatcsuami.getText().toString();
        nama_ortu_csuami = namaortucsuami.getText().toString();
        agt_grj_csuami = agtgrjcsuami.getText().toString();
        klp_csuami = klpcsuami.getText().toString();
        saksi_csuami = saksicsuami.getText().toString();
        nama_cistri = namacistri.getText().toString();
        tempat_lahir_cistri = tempatlahircistri.getText().toString();
        tgl_lahir_cistri = tglcistri.getText().toString();
        agama_cistri = agamacistri.getText().toString();
        tgl_baptis_cistri = tglbaptis2.getText().toString();
        alamat_cistri = alamatcistri.getText().toString();
        nama_ortu_cistri = namaortucistri.getText().toString();
        agt_grj_cistri = agtgrjcistri.getText().toString();
        klp_cistri = klpcistri.getText().toString();
        saksi_cistri = saksicistri.getText().toString();
        tgl_nikah = tglmenikah.getText().toString();
        jam_nikah = jamnikah.getText().toString();
        tempat_nikah = tempatnikah.getText().toString();

        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);
        Call<Value> call = apiService.daftarPernikahan(tgl_daftar,nama_csuami,tempat_lahir_csuami,tgl_lahir_csuami,agama_csuami,tgl_baptis_csuami,
                alamat_csuami,nama_ortu_csuami,agt_grj_csuami,klp_csuami,saksi_csuami,nama_cistri,tempat_lahir_cistri,
                tgl_lahir_cistri,agama_cistri,tgl_baptis_cistri,alamat_cistri,nama_ortu_cistri,agt_grj_cistri,klp_cistri,saksi_cistri,
                tgl_nikah,jam_nikah,tempat_nikah);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progress.dismiss();
                if(response.body().getValue().equals("1")){
                    Toast.makeText(Pernikahan_daftar.this, "Berhasil daftar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pernikahan_daftar.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(Pernikahan_daftar.this,"Jaringan Error", Toast.LENGTH_SHORT);
            }
        });
    }
}