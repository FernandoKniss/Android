package com.example.user.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.button = (Button) findViewById(R.id.button3);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void onClick (View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
