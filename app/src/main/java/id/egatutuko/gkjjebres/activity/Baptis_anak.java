package id.egatutuko.gkjjebres.activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.BaptisAnak;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.utils.datepicker.DatePickerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Baptis_anak extends AppCompatActivity implements DatePickerFragment.DatePickerFragmentListener{

    private ProgressDialog progress;
    private TextView dateTimeDisplay;
    private TextInputEditText tglAnak, tglSipil, tglBaptis, nama_ayah, grj_ayah, alamat_ayah, induk_ayah, klp_ayah, nama_ibu, grj_ibu, alamat_ibu, induk_ibu, klp_ibu, nama_anak, tmp_lahir, noAkta, tmp_baptis, jam_baptis;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private Button bt_akta, bt_daftar;
    final int PICK_IMAGE_REQUEST = 234;
    private Uri filePath;
    private ImageView imagePreview;
    FragmentManager fm = getSupportFragmentManager();
    int DATE_DIALOG = 0;
    private RadioButton rbJK, rbSipil;
    RadioGroup rgJK, rgSipil;
    private String nm_ayah, agt_grj_ayah, almt_ayah, no_induk_ayah, agt_klp_ayah,
                   nm_ibu, agt_grj_ibu, almt_ibu, no_induk_ibu, agt_klp_ibu,
                   nm_anak, tempat_lahir, no_akta, tempat_baptis, waktu_baptis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baptis_anak);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        //Display Tgl
        dateTimeDisplay = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat ("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);
        //Binding
        bt_daftar = findViewById(R.id.submit);
        imagePreview = findViewById(R.id.imageView);
        bt_akta = findViewById(R.id.akta_up);
        tglAnak = findViewById(R.id.pilih_tglAnak);
        tglSipil = findViewById(R.id.pilih_tglSipil);
        tglBaptis = findViewById(R.id.pilih_tglBaptis);
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
        tmp_baptis = findViewById(R.id.tmp_baptis);
        jam_baptis = findViewById(R.id.jam_baptis);
        RadioGroup rgJK = (RadioGroup) findViewById(R.id.rg1);
        //RadioGroup rgSipil = (RadioGroup) findViewById(R.id.rg2);

        /**
        rgJK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String value;
                switch (checkedId) {
                    case R.id.laki :
                        value = "L";
                    break;
                    case R.id.perempuan :
                        value = "P";
                    break;
                }
            }
        });*/

        bt_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        tglBaptis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATE_DIALOG = 2;
                openDialog();
            }
        });

        bt_akta.setOnClickListener(v -> showFileChooser());

        }

        public void createPost(){
            //progress dialog
            progress = new ProgressDialog(Baptis_anak.this);
            progress.setCancelable(false);
            progress.setMessage("Loading ...");
            progress.show();

            //ambil data dari edittext
            String tgl_daftar = dateTimeDisplay.getText().toString().trim();
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

            //int selectedIdJK = rgJK.getCheckedRadioButtonId();
            //int selectedSipil = rgSipil.getCheckedRadioButtonId();

            //rbJK = (RadioButton) findViewById(selectedIdJK);
            //String jk = rbJK.getText().toString();
            // rbSipil = (RadioButton) findViewById(selectedSipil);
            //String status_sipil = rbSipil.getText().toString();

            APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);

            BaptisAnak baptisAnak = new BaptisAnak(tgl_daftar, nm_ayah, agt_grj_ayah, almt_ayah, no_induk_ayah, agt_klp_ayah,
                    nm_ibu, agt_grj_ibu, almt_ibu, no_induk_ibu,
                    agt_klp_ibu, nm_anak, tempat_lahir, no_akta, tempat_baptis, waktu_baptis);
            Call<BaptisAnak> call = APIService.daftar(baptisAnak);
            call.enqueue(new Callback<BaptisAnak>() {
                @Override
                public void onResponse(Call<BaptisAnak> call, @NonNull Response<BaptisAnak> response) {
                    //Log.d(TAG, "onResponse: " + response.body().toString());
                    String value = response.body().getValue();
                    String message = response.body().getMessage();
                    progress.dismiss();
                    if (value.equals("1")) {
                        Toast.makeText(Baptis_anak.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Baptis_anak.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BaptisAnak> call, Throwable t) {
                    progress.dismiss();
                    Toast.makeText(Baptis_anak.this, "Jaringan error!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void openDialog(){
            DatePickerFragment dpDialog = new DatePickerFragment();
            dpDialog.show(fm, "DATE PICK");
        }

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
                default:
            }
        }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image To Upload"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagePreview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getImagePath(Uri uri)
    {
        String[] projection={MediaStore.Images.Media.DATA};
        Cursor cursor=getContentResolver().query(uri,projection,null,null,null);
        if(cursor == null){
            return null;
        }
        int columnIndex= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(columnIndex);
        cursor.close();
        return s;
    }


}

