package id.egatutuko.gkjjebres.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import id.egatutuko.gkjjebres.R;

public class Info extends AppCompatActivity {

    TextView isisejarah, isiprofil, isivisi, isimisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_32);

        /**Binding*/
        isiprofil = findViewById(R.id.isi_profil);
        isisejarah = findViewById(R.id.isi_sejarah);
        isivisi = findViewById(R.id.isi_visi);
        isimisi = findViewById(R.id.isi_misi);

        isiprofil.setText("GKJ Jebres merupakan gereja yang tergabung dalam klasis Sala. Gereja ini didewasakan dari gereja induk GKJ Margoyudan pada tgl 28 Oktober 2002, beralamatkan di Jl. Pracanda 1 Kandangsapi, Surakarta, dengan satu wilayah pelayanannya kelurahan Jebres");
        isisejarah.setText("Pada tahun 1948-an di daerah Kandangsapi Surakarta tumbuh sebuah komunitas Kristen yang bernaung di GKJ Margoyudan. Komunitas Kristen itu pada 1986 - 1987 beribadah menumpang di rumah keluarga Bapak Suradi RT 02 / RW 32 seorang pensiunan ABRI. Pada tanggal 5 April 1987 Kelompok Kebaktian Jebres diresmikan dalam kebaktian perdana yang dilayankan oleh Pendeta Suwardi, S.Th. Pada Tahun 1988 - 2001 berproses mengajukan diri dari kelompok kebaktian menjadi pepanthan ke GKJ Margoyudan dan pada tanggal 7 Februari 1993 diresmikan menjadi Pepanthan GKJ Jebres didewasakan oleh GKJ Jebres melakukan pemanggilan calon pendeta atas diri Sdr. Suwarto, S.Si dan setelah melewati pemilihan, pembimbingan, Ujian dan Vikariat ditahbiskan dan diteguhkan sebagai pendeta GKJ Jebres pada tanggal 28 Oktober 2006.");
        isivisi.setText("Visi GKJ Jebres adalah \"KESELAMATAN MANUSIA\". Dalam kehidupan bergereja visi tersebut diatas menjadi pedoman dan pandangan yang secara tidak langsung memberi instruksi kepada setiap jemaat untuk menjadi pemimpin dan pembimbing bagi jemaat yang lain untuk mampu memiliki pemahaman dan pengelanan tentang Allah, diri sendiri dan keadaan secara tepat. Kemuliaan Allah dalam hidup dan kehidupan setiap jemaat harus selalu di nomor satukan dan karenanya siapapun yang percaya akan memperoleh karunia keselamatan, hidup dan kehidupan yang selamat.");
        isimisi.setText("Misi GKJ Jebres adalah \"PEMELIHARAAN IMAN DAN PEMBERITAAN KESELAMATAN MANUSIA\". Dalam kehidupan bergereja misi tersebut merupakan pernyataan yang bersifat filosofi sebagai dasar dari inti pelayanan yang dilakukan oleh semua warga jemaat, apapun jabatannya dalam gereja, walaupun dilakukan secara perorangan harus berdampak positif secara intern dan ekstern berkaitan dengan keselamatan manusia");


    }
}