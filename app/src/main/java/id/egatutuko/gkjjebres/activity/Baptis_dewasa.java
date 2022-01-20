package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.egatutuko.gkjjebres.R;

public class Baptis_dewasa extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baptis_dewasa);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        autoCompleteTextView = findViewById(R.id.prosesi_nikah);
        autoCompleteTextView1 = findViewById(R.id.keterangan_pasangan);

        String[]option = {"Kristen","Katolik","Islam","Hindu","Budha","Adat","Lainnya"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_item_nikah, option);
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);
        autoCompleteTextView.setAdapter(arrayAdapter);

        String[] option1 = {"Masih","Cerai","Meninggal"};
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.dropdown_item_pasangan, option1);
        autoCompleteTextView1.setText(arrayAdapter1.getItem(0).toString(), false);
        autoCompleteTextView1.setAdapter(arrayAdapter1);

        dateTimeDisplay = findViewById(R.id.textView);

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        findViewById(R.id.pilih_tanggal).setOnClickListener(v -> showDatePickerDialog());
        findViewById(R.id.pilih_tanggal1).setOnClickListener(v -> showDatePickerDialog());
        findViewById(R.id.pilih_tanggal2).setOnClickListener(v -> showDatePickerDialog());
        findViewById(R.id.pilih_tanggal3).setOnClickListener(v -> showDatePickerDialog());
        findViewById(R.id.pilih_tanggal4).setOnClickListener(v -> showDatePickerDialog());

    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
        datePickerDialog.getDatePicker();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

    public void radioButtonHandler(View view) {
    }
}