package id.egatutuko.gkjjebres.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.egatutuko.gkjjebres.R;
import id.egatutuko.gkjjebres.adapter.MainActivityAdapter;
import id.egatutuko.gkjjebres.model.RecyclerDataMain;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerDataMain> recyclerDataMainArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerHome);
        // created new array list..
        recyclerDataMainArrayList =new ArrayList<>();
        // added data to array list
        recyclerDataMainArrayList.add(new RecyclerDataMain("Profil Gereja",R.drawable.ic_church));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Warta Jemaat",R.drawable.ic_warta));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Video Ibadah",R.drawable.ic_video));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Renungan",R.drawable.ic_renungan));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Jadwal Ibadah dan Kegiatan",R.drawable.ic_schedule));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Kontak",R.drawable.ic_contact));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Pendaftaran     Baptis",R.drawable.ic_baptis));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Pendaftaran Katekisasi",R.drawable.ic_baptis));
        recyclerDataMainArrayList.add(new RecyclerDataMain("Pendaftaran Pernikahan",R.drawable.ic_nikah));

        // added data from arraylist to adapter class.
        MainActivityAdapter adapter = new MainActivityAdapter(recyclerDataMainArrayList,this);
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
    public void onBackPressed() {
        finishAndRemoveTask();
    }
}
