package id.egatutuko.gkjjebres.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import id.egatutuko.gkjjebres.API.APIClient;
import id.egatutuko.gkjjebres.API.APIService;
import id.egatutuko.gkjjebres.API.APIUtils;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.LoginData;
import id.egatutuko.gkjjebres.model.LoginModel;
import id.egatutuko.gkjjebres.utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity{

    private TextInputEditText etEmail, etPass;
    private Button btLogin, btRegist;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Binding*/
        etEmail = findViewById(R.id.email);
        etPass = findViewById(R.id.password);
        btLogin = findViewById(R.id.login);
        btRegist = findViewById(R.id.register);

        /**Button*/
        btLogin.setOnClickListener(v -> {
            loginUser();
        });
        btRegist.setOnClickListener(v -> {
            registUser();
        });
    }

    private void loginUser(){
        /**API Call*/
        APIService apiService = APIClient.getClient(APIUtils.getUrl()).create(APIService.class);
        Call<LoginModel> call = apiService.loginUser(etEmail.getText().toString(),etPass.getText().toString());
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    sessionManager = new SessionManager(Login.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);
                    Toast.makeText(Login.this,"Selamat Datang "+response.body().getLoginData().getNama(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this,Home.class);
                    startActivity(intent);
                    finishAndRemoveTask();
                } else {
                    Toast.makeText(Login.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(Login.this,"Jaringan error!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registUser(){
        Intent intent = new Intent(Login.this,Register.class);
        startActivity(intent);
    }
}