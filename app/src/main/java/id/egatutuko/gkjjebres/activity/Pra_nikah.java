package id.egatutuko.gkjjebres.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.Value;
import id.egatutuko.gkjjebres.utils.SessionManager;
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentPranikah;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pra_nikah extends AppCompatActivity implements DPFragmentPranikah.DPFragmentListenerPranikah {

    ProgressDialog progress;
    FragmentManager fm = getSupportFragmentManager();
    private TextView dateTimeDisplay,tvJK;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date,tgl_daftar,nama,umur,alamat,tempat_lahir,
            tgl_lahir,tgl_baptis_1,tempat_baptis_1,pembaptis,tgl_sidi,tempat_sidi,pend,
            pekerjaan,alamat_kerja,ket,nama_tunangan,agt_grj_tunangan,no_induk_tunangan,alamat_tunangan,
            tgl_nikah,tempat_nikah,jam_nikah,jenkel;
    private TextInputEditText nm,Umur,almt,tempatlahir,
            tgllahir,tglbaptis1,tempatbaptis1,pemBaptis,tglsidi,tempatsidi,Pend,
            peKerjaan,alamatkerja,Ket,namatunangan,agtgrjtunangan,noinduktunangan,alamattunangan,
            tglnikah,tempatnikah,jamnikah;
    private Button btDaftar;
    int DATE_DIALOG = 0;
    RadioGroup rgJK, rgStatus;
    RadioButton rbJK, rbStatus, rbL, rbP;
    String dtNow = "";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pra_nikah);
        sessionManager = new SessionManager(Pra_nikah.this);

        /**Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Tgl daftar*/
        dateTimeDisplay = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(calendar.getTime());
        dtNow = date;
        dateTimeDisplay.setText(date);

        /**Binding*/
        nm = findViewById(R.id.nama);
        Umur = findViewById(R.id.umur);
        almt = findViewById(R.id.alamat);
        tempatlahir = findViewById(R.id.tempat_lahir);
        tgllahir = findViewById(R.id.tgl_lahir);
        tglbaptis1 = findViewById(R.id.tglBaptis1);
        tempatbaptis1 = findViewById(R.id.tempat_baptis);
        pemBaptis = findViewById(R.id.pembaptis);
        tglsidi = findViewById(R.id.tglSidi);
        tempatsidi = findViewById(R.id.tempat_sidi);
        Pend = findViewById(R.id.pend);
        peKerjaan = findViewById(R.id.pekerjaan);
        alamatkerja = findViewById(R.id.alamat_kerja);
        Ket = findViewById(R.id.ket);
        namatunangan = findViewById(R.id.nama_calon);
        agtgrjtunangan = findViewById(R.id.agt_grj_calon);
        noinduktunangan = findViewById(R.id.no_induk_calon);
        alamattunangan = findViewById(R.id.alamat_calon);
        tglnikah = findViewById(R.id.tglNikah);
        tempatnikah = findViewById(R.id.tempat_nikah);
        jamnikah = findViewById(R.id.jam_nikah);
        btDaftar = findViewById(R.id.submit);
        rgJK = findViewById(R.id.rg1);
        rgStatus = findViewById(R.id.rg2);
        rbL = findViewById(R.id.laki);
        rbP = findViewById(R.id.perempuan);
        tvJK = findViewById(R.id.tvJK);
        jenkel = sessionManager.getUserDetail().get(SessionManager.JENIS_KELAMIN);
        tvJK.setText(jenkel);

        nm.setText(sessionManager.getUserDetail().get(SessionManager.NAMA));
        if(tvJK.getText().equals("L")){
            rbL.setChecked(true);
        } else {
            rbP.setChecked(true);
        }
        almt.setText(sessionManager.getUserDetail().get(SessionManager.ALAMAT));
        tempatlahir.setText(sessionManager.getUserDetail().get(SessionManager.TEMPAT_LAHIR));
        tgllahir.setText(sessionManager.getUserDetail().get(SessionManager.TANGGAL_LAHIR));
        Pend.setText(sessionManager.getUserDetail().get(SessionManager.PENDIDIKAN));
        peKerjaan.setText(sessionManager.getUserDetail().get(SessionManager.PEKERJAAN));


        /**Onclick listener*/
        tgllahir.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 0;
        });
        tglbaptis1.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 1;
        });
        tglsidi.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 2;
        });
        tglnikah.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 3;
        });
        btDaftar.setOnClickListener(v -> {
            if(nm.getText().toString().isEmpty() || Umur.getText().toString().isEmpty() || almt.getText().toString().isEmpty()
            || tempatlahir.getText().toString().isEmpty() || tgllahir.getText().toString().isEmpty() || tempatbaptis1.getText().toString().isEmpty()
            || tglbaptis1.getText().toString().isEmpty() || pemBaptis.getText().toString().isEmpty() || tglsidi.getText().toString().isEmpty()
            || tempatsidi.getText().toString().isEmpty() || namatunangan.getText().toString().isEmpty() || alamattunangan.getText().toString().isEmpty()){
                Toast.makeText(Pra_nikah.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else if(tglnikah.getText().toString().isEmpty()){
                Toast.makeText(Pra_nikah.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else {
                createPost();
            }
        });
    }

    /**Input database*/
    public void createPost() {
        /**Progress dialog*/
        progress = new ProgressDialog(Pra_nikah.this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        /**Ambil data*/
        tgl_daftar = dtNow;
        nama = nm.getText().toString();
        umur = Umur.getText().toString();
        alamat = almt.getText().toString();
        tempat_lahir = tempatlahir.getText().toString();
        tgl_lahir = tgllahir.getText().toString();
        tgl_baptis_1 = tglbaptis1.getText().toString();
        tempat_baptis_1 = tempatbaptis1.getText().toString();
        pembaptis = pemBaptis.getText().toString();
        tgl_sidi = tglsidi.getText().toString();
        tempat_sidi = tempatsidi.getText().toString();
        pend = Pend.getText().toString();
        pekerjaan = peKerjaan.getText().toString();
        alamat_kerja = alamatkerja.getText().toString();
        ket = Ket.getText().toString();
        nama_tunangan = namatunangan.getText().toString();
        agt_grj_tunangan = agtgrjtunangan.getText().toString();
        no_induk_tunangan = noinduktunangan.getText().toString();
        alamat_tunangan = alamattunangan.getText().toString();
        tgl_nikah = tglnikah.getText().toString();
        tempat_nikah = tempatnikah.getText().toString();
        jam_nikah = jamnikah.getText().toString();

        /**Binding + ambil data radioButton*/
        int selectedJK = rgJK.getCheckedRadioButtonId();
        rbJK = findViewById(selectedJK);
        String jk = rbJK.getText().toString();
        int selectedStatus = rgStatus.getCheckedRadioButtonId();
        rbStatus = findViewById(selectedStatus);
        String status = rbStatus.getText().toString();

        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);
        Call<Value> call = apiService.daftarPraNikah(tgl_daftar,nama,jk,umur,alamat,tempat_lahir,
                tgl_lahir,tgl_baptis_1,tempat_baptis_1,pembaptis,tgl_sidi,tempat_sidi,pend,
                pekerjaan,alamat_kerja,ket,nama_tunangan,status,agt_grj_tunangan,no_induk_tunangan,alamat_tunangan,
                tgl_nikah,tempat_nikah,jam_nikah);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progress.dismiss();
                if(response.body().getValue().equals("1")){
                    Toast.makeText(Pra_nikah.this,"Berhasil daftar",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pra_nikah.this,"Gagal daftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(Pra_nikah.this,"Jaringan error",Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**Open calendar*/
    public void openDialog() {
        DPFragmentPranikah dpDialog = new DPFragmentPranikah();
        dpDialog.show(fm, "DATE PICK");
    }

    /**Pilih tgl*/
    @Override
    public void onDateSet(int year, int month, int day) {
        switch (DATE_DIALOG) {
            case 0:
                tgllahir.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 1:
                tglbaptis1.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 2:
                tglsidi.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            case 3:
                tglnikah.setText(Integer.toString(day) + "/" +
                        Integer.toString(month + 1) + "/" +
                        Integer.toString(year));
                break;
            default:
        }
    }
}