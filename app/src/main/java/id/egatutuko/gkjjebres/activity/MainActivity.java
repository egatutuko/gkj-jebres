package id.egatutuko.gkjjebres.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.adapter.RecyclerViewAdapterHome;
import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.model.RecyclerDataHome;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerDataHome> recyclerDataHomeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerHome);

        // created new array list..
        recyclerDataHomeArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Profil Gereja",R.drawable.ic_church));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Warta Jemaat",R.drawable.ic_warta));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Video Ibadah",R.drawable.ic_video));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Renungan",R.drawable.ic_renungan));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Jadwal Ibadah dan Kegiatan",R.drawable.ic_schedule));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Kontak",R.drawable.ic_contact));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran     Baptis",R.drawable.ic_baptis));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Katekisasi",R.drawable.ic_baptis));
        recyclerDataHomeArrayList.add(new RecyclerDataHome("Pendaftaran Pernikahan",R.drawable.ic_nikah));

        // added data from arraylist to adapter class.
        RecyclerViewAdapterHome adapter = new RecyclerViewAdapterHome(recyclerDataHomeArrayList,this);
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
}
