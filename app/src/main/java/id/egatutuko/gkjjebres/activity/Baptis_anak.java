package id.egatutuko.gkjjebres.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.Value;
import id.egatutuko.gkjjebres.utils.SessionManager;
import id.egatutuko.gkjjebres.utils.datepicker.DPFragmentBaptisAnak;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Baptis_anak extends AppCompatActivity implements DPFragmentBaptisAnak.DPFragmentListenerAnak {

    private ProgressDialog progress;
    private TextView dateTimeDisplay, tvJK;
    private TextInputEditText tglAnak, tglSipil, tglBaptis, nama_ayah, grj_ayah, alamat_ayah, induk_ayah, klp_ayah,
                              nama_ibu, grj_ibu, alamat_ibu, induk_ibu, klp_ibu, nama_anak, tmp_lahir, noAkta, tmp_baptis, jam_baptis,
                              nohpayah, nohpibu;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String tgl_daftar, date, nm_ayah, agt_grj_ayah, almt_ayah, no_induk_ayah, agt_klp_ayah,
                   nm_ibu, agt_grj_ibu, almt_ibu, no_induk_ibu, agt_klp_ibu,
                   nm_anak, tempat_lahir, no_akta, tempat_baptis, waktu_baptis,
                   tgl_lahir, tgl_lapor, tgl_baptis, nohp_a, nohp_i, jenkel;
    private Button bt_akta, bt_daftar;
    private static final int PICK_IMAGE_REQUEST = 100;
    Bitmap bitmap;
    private Uri filePath;
    private ImageView imagePreview;
    private FragmentManager fm = getSupportFragmentManager();
    int DATE_DIALOG = 0;
    private RadioButton rbJK, rbSipil, rbL, rbP, rbS, rbB;
    private RadioGroup rgJK, rgSipil;
    String dtNow = "";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baptis_anak);
        sessionManager = new SessionManager(Baptis_anak.this);

        /**toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Display Tgl*/
        dateTimeDisplay = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(calendar.getTime());
        dtNow = date;
        dateTimeDisplay.setText(date);

        /**Binding*/
        bt_daftar = findViewById(R.id.submit);
        imagePreview = findViewById(R.id.imageView);
        bt_akta = findViewById(R.id.akta_up);
        tglAnak = findViewById(R.id.pilih_tglAnak);
        tglSipil = findViewById(R.id.pilih_tglSipil);
        //tglBaptis = findViewById(R.id.pilih_tglBaptis);
        nama_ayah = findViewById(R.id.nama_ayah);
        grj_ayah = findViewById(R.id.grj_ayah);
        alamat_ayah = findViewById(R.id.alamat_ayah);
        induk_ayah = findViewById(R.id.induk_ayah);
        klp_ayah = findViewById(R.id.klp_ayah);
        nama_ibu = findViewById(R.id.nama_ibu);
        grj_ibu = findViewById(R.id.grj_ibu);
        alamat_ibu = findViewById(R.id.alamat_ibu);
        induk_ibu = findViewById(R.id.induk_ibu);
        klp_ibu = findViewById(R.id.klp_ibu);
        nama_anak = findViewById(R.id.nama_anak);
        tmp_lahir = findViewById(R.id.tmp_lahir);
        noAkta = findViewById(R.id.noAkta);
        //tmp_baptis = findViewById(R.id.tmp_baptis);
        //jam_baptis = findViewById(R.id.jam_baptis);
        nohpayah = findViewById(R.id.nohpayah);
        nohpibu = findViewById(R.id.nohpibu);
        rgJK = findViewById(R.id.rg1);
        rgSipil = findViewById(R.id.rg2);
        rbL = findViewById(R.id.laki);
        rbP = findViewById(R.id.perempuan);
        rbS = findViewById(R.id.sudah);
        rbB = findViewById(R.id.belum);
        tvJK = findViewById(R.id.jenkel);
        jenkel = sessionManager.getUserDetail().get(SessionManager.JENIS_KELAMIN);
        tvJK.setText(jenkel);

        if(tvJK.getText().equals("L")){
            nama_ayah.setText(sessionManager.getUserDetail().get(SessionManager.NAMA));
            grj_ayah.setText("GKJ Jebres");
            alamat_ayah.setText(sessionManager.getUserDetail().get(SessionManager.ALAMAT));
            nohpayah.setText(sessionManager.getUserDetail().get(SessionManager.NO_HP));
            induk_ayah.setText(sessionManager.getUserDetail().get(SessionManager.NO_INDUK));
            klp_ayah.setText(sessionManager.getUserDetail().get(SessionManager.KELOMPOK_GEREJA));
        } else {
            nama_ibu.setText(sessionManager.getUserDetail().get(SessionManager.NAMA));
            grj_ibu.setText("GKJ Jebres");
            alamat_ibu.setText(sessionManager.getUserDetail().get(SessionManager.ALAMAT));
            nohpibu.setText(sessionManager.getUserDetail().get(SessionManager.NO_HP));
            induk_ibu.setText(sessionManager.getUserDetail().get(SessionManager.NO_INDUK));
            klp_ibu.setText(sessionManager.getUserDetail().get(SessionManager.KELOMPOK_GEREJA));
        }


        /**click listener*/
        bt_daftar.setOnClickListener(v -> {
            if(nama_anak.getText().toString().isEmpty() || tmp_lahir.getText().toString().isEmpty()
            || tglAnak.equals("") || noAkta.getText().toString().isEmpty() || imagePreview.getDrawable() == null){
                Toast.makeText(Baptis_anak.this,"Mohon isi data dengan lengkap",Toast.LENGTH_SHORT).show();
            } else if(tglBaptis.equals("")){
                Toast.makeText(Baptis_anak.this,"Mohon pilih tanggal baptis",Toast.LENGTH_SHORT).show();
            } else {
                createPost();
            }
        });
        tglAnak.setOnClickListener(v -> {
            DATE_DIALOG = 0;
            openDialog();
        });
        tglSipil.setOnClickListener(v -> {
            DATE_DIALOG = 1;
            openDialog();
        });
        /**tglBaptis.setOnClickListener(v -> {
            DATE_DIALOG = 2;
            openDialog();
        });*/
        bt_akta.setOnClickListener(v -> showFileChooser());
        }

        /**Submit data*/
        public void createPost(){
            /**progress dialog*/
            progress = new ProgressDialog(Baptis_anak.this);
            progress.setCancelable(false);
            progress.setMessage("Loading ...");
            progress.show();
            /**ambil data*/
            tgl_daftar = dtNow;
            nm_ayah = nama_ayah.getText().toString().trim();
            agt_grj_ayah = grj_ayah.getText().toString().trim();
            almt_ayah = alamat_ayah.getText().toString().trim();
            no_induk_ayah = induk_ayah.getText().toString().trim();
            agt_klp_ayah = klp_ayah.getText().toString().trim();
            nm_ibu = nama_ibu.getText().toString().trim();
            agt_grj_ibu = grj_ibu.getText().toString().trim();
            almt_ibu = alamat_ibu.getText().toString().trim();
            no_induk_ibu = induk_ibu.getText().toString().trim();
            agt_klp_ibu = klp_ibu.getText().toString().trim();
            nm_anak = nama_anak.getText().toString().trim();
            tempat_lahir = tmp_lahir.getText().toString().trim();
            no_akta = noAkta.getText().toString().trim();
            tempat_baptis = tmp_baptis.getText().toString().trim();
            waktu_baptis = jam_baptis.getText().toString().trim();
            nohp_a = nohpayah.getText().toString().trim();
            nohp_i = nohpibu.getText().toString().trim();
            tgl_lahir = tglAnak.getText().toString();
            tgl_lapor = tglSipil.getText().toString();
            tgl_baptis = tglBaptis.getText().toString();
            /**ambil data radio button*/
            int selectedIdJK = rgJK.getCheckedRadioButtonId();
            rbJK = findViewById(selectedIdJK);
            String jk = rbJK.getText().toString();
            int selectedIdSipil = rgSipil.getCheckedRadioButtonId();
            rbSipil = findViewById(selectedIdSipil);
            String status_sipil = rbSipil.getText().toString();
            String file_akta = convertToString();

            APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);

            /*BaptisAnak baptisAnak = new BaptisAnak(tgl_daftar, nm_ayah, agt_grj_ayah, almt_ayah, no_induk_ayah, agt_klp_ayah,
                    nm_ibu, agt_grj_ibu, almt_ibu, no_induk_ibu,
                    agt_klp_ibu, nm_anak, tempat_lahir, no_akta, tempat_baptis, waktu_baptis);
            Call<BaptisAnak> call = apiService.daftar(baptisAnak);*/
            Call<Value> call = apiService.daftarBaptisAnak(tgl_daftar, nm_ayah, agt_grj_ayah, almt_ayah, nohp_a, no_induk_ayah, agt_klp_ayah,
                                                nm_ibu, agt_grj_ibu, almt_ibu, nohp_i, no_induk_ibu,
                                                agt_klp_ibu, nm_anak, jk, tempat_lahir, tgl_lahir, no_akta, file_akta, status_sipil,
                                                tgl_lapor);
            call.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    //Log.d(TAG, "onResponse: " + response.body().toString());
                    //String value = response.body().getValue();
                    //String message = response.body().getMessage();
                    progress.dismiss();
                    if (response.body().getValue().equals("1")) {
                        Toast.makeText(Baptis_anak.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Baptis_anak.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {
                    progress.dismiss();
                    Toast.makeText(Baptis_anak.this, "Jaringan error!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        /**Open Calendar*/
        public void openDialog(){
            DPFragmentBaptisAnak dpDialog = new DPFragmentBaptisAnak();
            dpDialog.show(fm, "DATE PICK");
        }
        /**SetText calendar*/
        public void onDateSet(int year, int month, int day){
            switch (DATE_DIALOG){
                case 0:
                    tglAnak.setText(Integer.toString(day) + "/" +
                                    Integer.toString(month+1) + "/" +
                                    Integer.toString(year));
                    break;
                case 1:
                    tglSipil.setText(Integer.toString(day) + "/" +
                            Integer.toString(month+1) + "/" +
                            Integer.toString(year));
                    break;
                case 2:
                    tglBaptis.setText(Integer.toString(day) + "/" +
                            Integer.toString(month+1) + "/" +
                            Integer.toString(year));
                    break;
                default:
            }
        }

        /**image chooser*/
        private void showFileChooser() {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        }

        /**display image to imageview*/
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
                filePath = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    imagePreview.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String convertToString(){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            byte[] imgByte = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(imgByte,Base64.DEFAULT);
        }

}

