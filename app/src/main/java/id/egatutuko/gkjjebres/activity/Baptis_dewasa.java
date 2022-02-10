package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.Value;
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentBaptisDewasa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Baptis_dewasa extends AppCompatActivity implements DPFragmentBaptisDewasa.DPFragmentListenerDewasa {

    private ProgressDialog progress;
    private AutoCompleteTextView prosnikah, ketpas;
    private TextInputEditText tglLahir, tglBaptis1, tglBaptis, tglNikah, tglTunangan, nmlengkap, alamat, tmpLahir, tmpBaptis1, pemBaptis,
                              kerja, almtKerja, ketLain, nmAyah, agtGrjAyah, noIndukAyah, nmIbu, agtGrjIbu, noIndukIbu, almtOrtu, nmTunangan, agtGrjTunangan,
                              nmPasangan, agtGrjPasangan, noIndukPasangan, jmlAnak, jmlAsuhan, nmPengajar, lamaKat, tmpKat, tmpBaptis, jamBaptis,
                              noIndukTunangan, almtTunangan, sekolah;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private FragmentManager fm = getSupportFragmentManager();
    int DATE_DIALOG = 0;
    private RadioGroup rgJK, rgAyah, rgIbu, rgTunangan, rgPasangan, rgBaptis;
    private RadioButton rbJK, rbAyah, rbIbu, rbTunangan, rbPasangan, rbBaptis;
    private Button btDaftar;
    private String tgl_daftar, tgl_lahir, tgl_baptis_1, tgl_nikah, tgl_bertunangan, tgl_baptis, nm_lengkap, almt, tmpt_lahir, tempat_baptis_1, pembaptis, pekerjaan, almt_kerja,
                   ket, nm_ayah, agt_grj_ayah, no_induk_ayah, nm_ibu, agt_grj_ibu, no_induk_ibu, almt_ortu, nm_tunangan, agt_grj_tunangan, nm_pasangan, agt_grj_pasangan, no_induk_pasangan,
                   jml_anak, anak_dlm_asuhan, pengajar_katekisasi, lama_katekisasi, tempat_katekisasi, tempat_baptis, jam_baptis, no_induk_tunangan,
                   almt_tunangan, pend, ket_nikah, prosesi_nikah, prosesnikah, ketpasang;
    String[] option = {"Kristen","Katolik","Islam","Hindu","Budha","Adat","Lainnya"};
    String[] option1 = {"Masih","Cerai","Meninggal"};
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baptis_dewasa);

        /**Binding*/
        tglLahir = findViewById(R.id.tanggal_lahir);
        tglBaptis1 = findViewById(R.id.tanggal_baptis1);
        tglNikah = findViewById(R.id.tanggal_nikah);
        tglTunangan = findViewById(R.id.tanggal_tunangan);
        tglBaptis = findViewById(R.id.tanggal_baptis);
        nmlengkap = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        tmpLahir = findViewById(R.id.tempat_lahir);
        tmpBaptis1 = findViewById(R.id.tempat_baptis);
        pemBaptis = findViewById(R.id.pembaptis);
        sekolah = findViewById(R.id.sekolah);
        kerja = findViewById(R.id.pekerjaan);
        almtKerja = findViewById(R.id.alamat_kerja);
        ketLain = findViewById(R.id.keterangan);
        nmAyah = findViewById(R.id.nama_ayah);
        agtGrjAyah = findViewById(R.id.agt_grj_ayah);
        noIndukAyah = findViewById(R.id.no_induk_ayah);
        nmIbu = findViewById(R.id.nama_ibu);
        agtGrjIbu = findViewById(R.id.agt_grj_ibu);
        noIndukIbu = findViewById(R.id.no_induk_ibu);
        almtOrtu = findViewById(R.id.alamat_ortu);
        nmTunangan = findViewById(R.id.nama_tunangan);
        agtGrjTunangan = findViewById(R.id.agt_grj_tunangan);
        noIndukTunangan = findViewById(R.id.no_induk_tunangan);
        almtTunangan = findViewById(R.id.alamat_tunangan);
        nmPasangan = findViewById(R.id.nama_pasangan);
        agtGrjPasangan = findViewById(R.id.agt_grj_pasangan);
        noIndukPasangan = findViewById(R.id.no_induk_pasangan);
        jmlAnak = findViewById(R.id.jml_anak);
        jmlAsuhan = findViewById(R.id.anak_dlm_asuhan);
        nmPengajar = findViewById(R.id.nama_pengajar);
        lamaKat = findViewById(R.id.lama_katekisasi);
        tmpKat = findViewById(R.id.tempat_katekisasi);
        tmpBaptis = findViewById(R.id.tempat_baptis1);
        jamBaptis = findViewById(R.id.jam_baptis);
        btDaftar = findViewById(R.id.submit);
        rgJK = findViewById(R.id.rg1);
        rgAyah = findViewById(R.id.rg2);
        rgIbu = findViewById(R.id.rg3);
        rgTunangan = findViewById(R.id.rg4);
        rgPasangan = findViewById(R.id.rg5);
        rgBaptis = findViewById(R.id.rg6);


        /**Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**AutoCompleteTextView*/
        prosnikah = findViewById(R.id.prosesi_nikah);
        ketpas = findViewById(R.id.keterangan_pasangan);

        /**AutoComplete Prosesi Nikah*/

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item_nikah, option);
        prosnikah.setAdapter(arrayAdapter);

        prosnikah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = parent.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(),"Item : "+option,Toast.LENGTH_SHORT).show();
                //"Kristen","Katolik","Islam","Hindu","Budha","Adat","Lainnya"
                switch (option) {
                    case "Kristen":
                        prosesnikah = "Kristen";
                        break;
                    case "Katolik":
                        prosesnikah = "Katolik";
                        break;
                    case "Islam":
                        prosesnikah = "Islam";
                        break;
                    case "Hindu":
                        prosesnikah = "Hindu";
                        break;
                    case "Budha":
                        prosesnikah = "Budha";
                        break;
                    case "Adat":
                        prosesnikah = "Adat";
                        break;
                    case "Lainnya":
                        prosesnikah = "Lainnya";
                        break;
                    default:
                        prosesnikah = "";
                        break;
                }
            }
        });

        /**AutoComplete Keterangan Pasangan*/

        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.dropdown_item_pasangan, option1);
        ketpas.setAdapter(arrayAdapter1);

        ketpas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option1 = parent.getItemAtPosition(position).toString();
                //"Masih","Cerai","Meninggal"
                switch (option1) {
                    case "Masih":
                        ketpasang = "Masih";
                        break;
                    case "Cerai":
                        ketpasang = "Cerai";
                        break;
                    case "Meninggal":
                        ketpasang = "Meninggal";
                        break;
                    default:
                        ketpasang = "";
                        break;
                }
            }
        });

        /**Setting tanggal daftar (hari ini)*/
        dateTimeDisplay = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        /**clicklistener*/
        tglLahir.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 0;
        });
        tglBaptis1.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 1;
        });
        tglNikah.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 2;
        });
        tglTunangan.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 3;
        });
        tglBaptis.setOnClickListener(v -> {
            openDialog();
            DATE_DIALOG = 4;
        });
        btDaftar.setOnClickListener(v -> {

            int selectedJK = rgJK.getCheckedRadioButtonId();
            rbJK = findViewById(selectedJK);

            int selectedBaptis = rgBaptis.getCheckedRadioButtonId();
            rbBaptis = findViewById(selectedBaptis);

            if(nmlengkap.getText().toString().isEmpty() || rbJK.getText().toString().isEmpty() || alamat.getText().toString().isEmpty()
            || tglLahir.equals("") || tmpLahir.getText().toString().isEmpty()){
                Toast.makeText(Baptis_dewasa.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else if(tglBaptis.equals("")){
                Toast.makeText(Baptis_dewasa.this,"Mohon isi data baptis dengan benar",Toast.LENGTH_SHORT).show();
            } else {
                createPost();
            }
        });


    }
    /**Open calendar*/
    public void openDialog(){
        DPFragmentBaptisDewasa dpDialog = new DPFragmentBaptisDewasa();
        dpDialog.show(fm, "DATE PICK");
    }

    /**Set Text Calendar*/
    @Override
    public void onDateSet(int year, int month, int day) {
        switch (DATE_DIALOG){
            case 0:
            tglLahir.setText(Integer.toString(day) + "/" +
                    Integer.toString(month+1) + "/" +
                    Integer.toString(year));
            break;
            case 1:
            tglBaptis1.setText(Integer.toString(day) + "/" +
                    Integer.toString(month+1) + "/" +
                    Integer.toString(year));
            break;
            case 2:
            tglNikah.setText(Integer.toString(day) + "/" +
                    Integer.toString(month+1) + "/" +
                    Integer.toString(year));
            break;
            case 3:
            tglTunangan.setText(Integer.toString(day) +"/"+
                    Integer.toString(month+1) +"/"+
                    Integer.toString(year));
            break;
            case 4:
            tglBaptis.setText(Integer.toString(day)+"/"+
                    Integer.toString(month+1)+"/"+
                    Integer.toString(year));
            break;
            default:
        }
    }

    public void createPost(){
        /**Progress dialog*/
        progress = new ProgressDialog(Baptis_dewasa.this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        /**Ambil data edit text*/
        tgl_daftar = dateTimeDisplay.getText().toString();
        tgl_lahir = tglLahir.getText().toString();
        tgl_baptis_1 = tglBaptis1.getText().toString();
        tgl_nikah = tglNikah.getText().toString();
        tgl_bertunangan = tglTunangan.getText().toString();
        tgl_baptis = tglBaptis.getText().toString();
        nm_lengkap = nmlengkap.getText().toString();
        almt = alamat.getText().toString();
        tmpt_lahir = tmpLahir.getText().toString();
        tempat_baptis_1 = tmpBaptis1.getText().toString();
        pembaptis = pemBaptis.getText().toString();
        pend = sekolah.getText().toString();
        pekerjaan = kerja.getText().toString();
        almt_kerja = almtKerja.getText().toString();
        ket = ketLain.getText().toString();
        nm_ayah = nmAyah.getText().toString();
        agt_grj_ayah = agtGrjAyah.getText().toString();
        no_induk_ayah = noIndukAyah.getText().toString();
        nm_ibu = nmIbu.getText().toString();
        agt_grj_ibu = agtGrjIbu.getText().toString();
        no_induk_ibu = noIndukIbu.getText().toString();
        almt_ortu = almtOrtu.getText().toString();
        nm_tunangan = nmTunangan.getText().toString();
        agt_grj_tunangan = agtGrjTunangan.getText().toString();
        no_induk_tunangan = noIndukTunangan.getText().toString();
        almt_tunangan = almtTunangan.getText().toString();
        nm_pasangan = nmPasangan.getText().toString();
        agt_grj_pasangan = agtGrjPasangan.getText().toString();
        no_induk_pasangan = noIndukPasangan.getText().toString();
        jml_anak = jmlAnak.getText().toString();
        anak_dlm_asuhan = jmlAsuhan.getText().toString();
        pengajar_katekisasi = nmPengajar.getText().toString();
        lama_katekisasi = lamaKat.getText().toString();
        tempat_katekisasi = tmpKat.getText().toString();
        tempat_baptis = tmpBaptis.getText().toString();
        jam_baptis = jamBaptis.getText().toString();
        prosesi_nikah = prosesnikah;
        ket_nikah = ketpasang;

        /**Ambil data radioButton*/
        /** Radio button jenis kelamin */
        int selectedJK = rgJK.getCheckedRadioButtonId();
        rbJK = findViewById(selectedJK);
        String jk = rbJK.getText().toString();
        /** Radio button status ayah */
        int selectedAyah = rgAyah.getCheckedRadioButtonId();
        rbAyah = findViewById(selectedAyah);
        String status_ayah = rbAyah.getText().toString();
        /** Radio button status ibu */
        int selectedIbu = rgIbu.getCheckedRadioButtonId();
        rbIbu = findViewById(selectedIbu);
        String status_ibu = rbIbu.getText().toString();
        /** Radio button status tunangan */
        int selectedTunangan = rgTunangan.getCheckedRadioButtonId();
        rbTunangan = findViewById(selectedTunangan);
        String status_tunangan = rbTunangan.getText().toString();
        /** Radio button status pasangan */
        int selectedPasangan = rgPasangan.getCheckedRadioButtonId();
        rbPasangan = findViewById(selectedPasangan);
        String status_pasangan = rbPasangan.getText().toString();
        /** Radio button pilih baptis */
        int selectedBaptis = rgBaptis.getCheckedRadioButtonId();
        rbBaptis = findViewById(selectedBaptis);
        String pilih_baptis = rbBaptis.getText().toString();

        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);

        Call<Value> call = apiService.daftarBaptisDewasa(tgl_daftar, nm_lengkap, jk, almt, tgl_lahir, tmpt_lahir, tgl_baptis_1, tempat_baptis_1, pembaptis, tgl_nikah,
                prosesi_nikah, pend, pekerjaan, almt_kerja, ket, nm_ayah, status_ayah, agt_grj_ayah, no_induk_ayah,
                nm_ibu, status_ibu, agt_grj_ibu, no_induk_ibu, almt_ortu, nm_tunangan, status_tunangan, agt_grj_tunangan, no_induk_tunangan,
                almt_tunangan, tgl_bertunangan, nm_pasangan, status_pasangan, agt_grj_pasangan, no_induk_pasangan, ket_nikah, jml_anak, anak_dlm_asuhan,
                pengajar_katekisasi, lama_katekisasi, tempat_katekisasi, pilih_baptis, tgl_baptis, tempat_baptis, jam_baptis);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                progress.dismiss();
                if (response.body().getValue().equals("1")) {
                    Toast.makeText(Baptis_dewasa.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Baptis_dewasa.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(Baptis_dewasa.this, "Jaringan error!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}