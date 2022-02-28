package id.egatutuko.gkjjebres.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.adapter.HomeAdapter;
import id.egatutuko.gkjjebres.model.RecyclerDataHome;
import id.egatutuko.gkjjebres.utils.SessionManager;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerDataHome> recyclerDataHomeArrayList;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        sessionManager = new SessionManager(Home.this);
        if(!sessionManager.isLoggedIn()){
            moveToHome();
        }
        recyclerView = findViewById(R.id.recyclerHome);

        // created new array list..
        recyclerDataHomeArrayList = new ArrayList<>();

        // added data to array list
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Profil Gereja",R.drawable.ic_church));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Warta Jemaat",R.drawable.ic_warta));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Video Ibadah",R.drawable.ic_video));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Renungan",R.drawable.ic_renungan));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Jadwal Ibadah dan Kegiatan",R.drawable.ic_schedule));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Kontak",R.drawable.ic_contact));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Baptis Anak",R.drawable.ic_baptis));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Baptis Dewasa",R.drawable.ic_baptis));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Katekisasi",R.drawable.ic_baptis));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Pelayanan Pernikahan",R.drawable.ic_nikah));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Pembinaan Pra-nikah",R.drawable.ic_nikah));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Profil Anda",R.drawable.ic_user_profile));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Logout",R.drawable.ic_logout));

        // added data from arraylist to adapter class.
        HomeAdapter adapter = new HomeAdapter(recyclerDataHomeArrayList,this);
        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        /*recycler view home*/

        /*adapter home*/

        /*images dan titles*/

    }

    private void moveToHome(){
        Intent intent = new Intent(Home.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finishAndRemoveTask();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which) {
                        finishAndRemoveTask();
                    }

                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}