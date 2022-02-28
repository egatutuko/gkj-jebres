package id.egatutuko.gkjjebres.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

import id.egatutuko.gkjjebres.R;

public class Detail_Warta extends AppCompatActivity implements OnLoadCompleteListener, OnPageErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_warta);
        final PDFView pdfView= findViewById(R.id.pdfView);
        //UNPACK OUR DATA FROM INTENT
        Intent i=this.getIntent();
        final String path=i.getExtras().getString("PATH");

        FileLoader.with(this)
                .load("http://www.gkjjebres.my.id"+path,false) //2nd parameter is optioal, pass true to force load from network
                .fromDirectory("My_PDFs", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File pdfFile = response.getBody();
                        try {
                            pdfView.fromFile(pdfFile)
                                    .defaultPage(1)
                                    .enableAnnotationRendering(true)
                                    .onLoad(Detail_Warta.this)
                                    .scrollHandle(new DefaultScrollHandle(Detail_Warta.this))
                                    .spacing(10) // in dp
                                    .onPageError(Detail_Warta.this)
                                    .load();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toast.makeText(Detail_Warta.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @Override
    public void loadComplete(int nbPages) {
        Toast.makeText(Detail_Warta.this, String.valueOf(nbPages), Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPageError(int page, Throwable t) {
        Toast.makeText(Detail_Warta.this, t.getMessage(), Toast.LENGTH_LONG).show();
    }
    }
