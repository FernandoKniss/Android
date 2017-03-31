package com.example.user.app1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.R.attr.bitmap;
import static com.example.user.app1.R.id.galeria;
import static com.example.user.app1.R.id.spinner;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText valor;
    private EditText data;
    private AutoCompleteTextView descricao;
    private AutoCompleteTextView local;
    private Spinner spinner;
    private Button button2;
    private Button button4;

    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.valor = (EditText) findViewById(R.id.valor);
        this.data = (EditText) findViewById(R.id.data);
        this.descricao = (AutoCompleteTextView) findViewById(R.id.descricao);
        this.local = (AutoCompleteTextView) findViewById(R.id.local);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button4 = (Button) findViewById(R.id.button4);

        button2.setOnClickListener(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void onClick(View view) {
       // finish();

        if (view.getId() == R.id.spinner) {

        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {

            case 0:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Alimentação"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Hotel"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Diversão"));
                break;
        }
        if(intent != null) {
            startActivity(intent);

            }
        }
        if (view.getId() == R.id.button2) {
            finish();
        }
    }

    public void onClickDB(View view){
        Intent intentDB = new Intent(this, MainActivity.class);
        startActivity(intentDB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                camera();
                break;
            case R.id.galeria:
                galeria();
                break;
            case R.id.settings:
                fechar();
                break;
            default:
                break;
        }
        return true;
    }

    public void camera() {
        boolean temCamera = getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if(temCamera){

            File diretorio = Environment
                    .getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES);

            String nomeImagem = diretorio.getPath() + "/" +
                    System.currentTimeMillis() +
                    ".jpg";

            uri = Uri.fromFile(new File(nomeImagem));
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(intent, CAPTURAR_IMAGEM);

            Intent in2 = new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            in2.setData(uri);
            this.sendBroadcast(in2);
        }
    }

    public void fechar() {
        //Metodo para fechar as activity
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    private void galeria(){
        Intent intent = new Intent(getApplicationContext(), ImageGaleriaActivity.class);
        startActivity(intent);
    }



}
