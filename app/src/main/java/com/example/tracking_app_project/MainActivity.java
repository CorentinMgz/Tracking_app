package com.example.tracking_app_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnMainMap;
    private Button btnStatistics;
    private Button btnRoute;
    private Button btnAR;
    private TextView pseudo;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Créer l'adapteur pour la BDD
        dbAdapter = new DBAdapter(this,"Tracking_app");

        // Ouvrir la BDD
        dbAdapter.open();
        dbAdapter.deleteAll();
        
        btnMainMap = findViewById(R.id.btnMainMap);
        btnStatistics = findViewById(R.id.btnStatistics);
        btnRoute = findViewById(R.id.btnRoute);
        btnAR = findViewById(R.id.btnAR);

        Intent intentReceived = getIntent();
        String message;
        if(intentReceived.hasExtra("pseudo")){
            message = "Hello " + intentReceived.getStringExtra("pseudo");
        }
        else{
            message = "Hello user";
        }
        pseudo = findViewById(R.id.title1);
        pseudo.setText(message);

        btnMainMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, CurrentLocationMapActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

        btnStatistics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

        btnRoute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, RouteActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

        btnAR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ArActivity.class);
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, PseudoActivity.class);
                startActivityForResult(intent, 1000);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}