package id.egatutuko.gkjjebres.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentJemaat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements DPFragmentJemaat.DPFragmentListenerJemaat{

    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private FragmentManager fm = getSupportFragmentManager();
    int DATE_DIALOG = 0;
    private String date;
    String[] option = {"Belum Menikah","Menikah","Janda","Duda"};
    ArrayAdapter<String> arrayAdapter;
    private TextInputEditText tglLahir, tglBaptis, nmlengkap, tempat_lahir, alamat, pendidikan, pekerjaan, nama_pasangan, pekerjaan_pasangan, nama_ayah, nama_ibu,
                              alamat_ortu, pekerjaan_ortu, gereja_ortu, gereja_asal, alamat_gereja, etEmail, etPass, no_hp;
    private AutoCompleteTextView status_nikah;
    String statusnikah, tgdaf, nm, tl, tgl, almt, pend, krj, nikah, npsgn, kpsgn, nayah, nibu, almtortu, kortu, grj, agrj, almtgrj, tbaptis, email, pass, nohp;
    String dtNow = "";
    Button btSubmit;
    private RadioGroup rgJK;
    private RadioButton rbJK;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /**toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Display Tgl*/
        dateTimeDisplay = findViewById(R.id.tgl_skrg);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(calendar.getTime());
        dtNow = date;
        dateTimeDisplay.setText(date);

        /**Binding*/
        tglLahir = findViewById(R.id.tgl_lahir);
        tglBaptis = findViewById(R.id.tgl_baptis);
        nmlengkap = findViewById(R.id.nmlengkap);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        alamat = findViewById(R.id.alamat);
        pendidikan = findViewById(R.id.pendidikan);
        pekerjaan = findViewById(R.id.pekerjaan);
        nama_pasangan = findViewById(R.id.nama_pasangan);
        pekerjaan_pasangan = findViewById(R.id.pekerjaan_pasangan);
        nama_ayah = findViewById(R.id.nama_ayah);
        nama_ibu = findViewById(R.id.nama_ibu);
        alamat_ortu = findViewById(R.id.alamat_ortu);
        pekerjaan_ortu = findViewById(R.id.pekerjaan_ortu);
        gereja_ortu = findViewById(R.id.gereja_ortu);
        gereja_asal = findViewById(R.id.gereja_asal);
        alamat_gereja = findViewById(R.id.alamat_gereja);
        etEmail = findViewById(R.id.email);
        etPass = findViewById(R.id.password);
        status_nikah = findViewById(R.id.status_nikah);
        btSubmit = findViewById(R.id.submit);
        rgJK = findViewById(R.id.rg1);
        no_hp = findViewById(R.id.no_hp);

        /**Click Listener*/
        tglLahir.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 0;
        });
        tglBaptis.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 1;
        });
        btSubmit.setOnClickListener(v -> {
            createPost();
        });

        /**AutoComplete Prosesi Nikah*/

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item_status_nikah, option);
        status_nikah.setAdapter(arrayAdapter);

        status_nikah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = parent.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(),"Item : "+option,Toast.LENGTH_SHORT).show();
                //"Kristen","Katolik","Islam","Hindu","Budha","Adat","Lainnya"
                switch (option) {
                    case "Belum Menikah":
                        statusnikah = "Belum Menikah";
                        break;
                    case "Menikah":
                        statusnikah = "Menikah";
                        break;
                    case "Janda":
                        statusnikah = "Janda";
                        break;
                    case "Duda":
                        statusnikah = "Duda";
                        break;
                    default:
                        statusnikah = "";
                        break;
                }
            }
        });
    }

    /**Open calendar*/
    public void openDialog(){
        DPFragmentJemaat dpDialog = new DPFragmentJemaat();
        dpDialog.show(fm, "DATE PICK");
    }

    @Override
    public void onDateSet(int year, int month, int day) {
        switch (DATE_DIALOG){
            case 0:
                tglLahir.setText(Integer.toString(day) + "/" +
                        Integer.toString(month+1) + "/" +
                        Integer.toString(year));
                break;
            case 1:
                tglBaptis.setText(Integer.toString(day) + "/" +
                        Integer.toString(month+1) + "/" +
                        Integer.toString(year));
                break;
        }
    }

    public void createPost(){
        /**Progress dialog*/
        progress = new ProgressDialog(Register.this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        /**Ambil data edit text*/
        /**tgdaf, nm, tl, tgl, jk, almt, pend, krj, nikah, npsgn, kpsgn, nayah, nibu, almtortu, kortu, grj, agrj, almtgrj, tbaptis, email, pass*/
        tgdaf = dtNow;
        nm = nmlengkap.getText().toString();
        tl = tempat_lahir.getText().toString();
        tgl = tglLahir.getText().toString();
        almt = alamat.getText().toString();
        pend = pendidikan.getText().toString();
        krj = pekerjaan.getText().toString();
        nikah = statusnikah;
        npsgn = nama_pasangan.getText().toString();
        kpsgn = pekerjaan_pasangan.getText().toString();
        nayah = nama_ayah.getText().toString();
        nibu = nama_ibu.getText().toString();
        almtortu = alamat_ortu.getText().toString();
        kortu = pekerjaan_ortu.getText().toString();
        grj = gereja_ortu.getText().toString();
        agrj = gereja_asal.getText().toString();
        almtgrj = alamat_gereja.getText().toString();
        tbaptis = tglBaptis.getText().toString();
        email = etEmail.getText().toString();
        pass = etPass.getText().toString();
        nohp = no_hp.getText().toString();

        /**Ambil data radioButton*/
        int selectedJK = rgJK.getCheckedRadioButtonId();
        rbJK = findViewById(selectedJK);
        String jk = rbJK.getText().toString();

        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);

        Call<Value> call = apiService.registUser(tgdaf, nm, tl, tgl, jk, nohp, almt, pend, krj, nikah, npsgn, kpsgn, nayah, nibu, almtortu, kortu, grj, agrj, almtgrj, tbaptis, email, pass);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progress.dismiss();
                if (response.body().getValue().equals("1")) {
                    Toast.makeText(Register.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finishAndRemoveTask();
                } else {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(Register.this, "Jaringan error!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}