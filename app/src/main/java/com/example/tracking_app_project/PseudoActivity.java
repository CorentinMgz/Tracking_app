package com.example.tracking_app_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PseudoActivity extends AppCompatActivity {

    private Button btnSendPseudo;
    private EditText inputPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);

        btnSendPseudo = findViewById(R.id.btnSendPseudo);
        inputPseudo = findViewById(R.id.inputPseudo);

        btnSendPseudo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PseudoActivity.this, MainActivity.class);
                intent.putExtra("pseudo", inputPseudo.getText().toString());
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(PseudoActivity.this, MainActivity.class);
                startActivityForResult(intent, 1000);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}