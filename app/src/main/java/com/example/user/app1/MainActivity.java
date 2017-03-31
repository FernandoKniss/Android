package com.example.user.app1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText valorOrcamento;
    private EditText qnttPessoas;
    private EditText dtChegada;
    private EditText dtPartida;
    private AutoCompleteTextView DigitarDestino;
    private Button button;
    private RadioButton viagemLazer;
    private RadioButton viagemNegocios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.valorOrcamento = (EditText) findViewById(R.id.valorOrcamento);
        this.qnttPessoas = (EditText) findViewById(R.id.qtddPessoas);
        this.dtChegada = (EditText) findViewById(R.id.dtChegada);
        this.dtPartida = (EditText) findViewById(R.id.dtPartida);
        this.DigitarDestino = (AutoCompleteTextView) findViewById(R.id.DigitarDestino);
        this.button = (Button) findViewById(R.id.button);
        this.viagemLazer = (RadioButton) findViewById(R.id.viagemLazer);
        this.viagemNegocios = (RadioButton) findViewById(R.id.viagemNegocios);

        button.setOnClickListener(this);

    }

    public void onClick(View view) {
        Intent it = new Intent(this, Main2Activity.class);

        startActivity(it);
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


    public void onRadioButtonClicked (View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.viagemNegocios:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.viagemLazer:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
