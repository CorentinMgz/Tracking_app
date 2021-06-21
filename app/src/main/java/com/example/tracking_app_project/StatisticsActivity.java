package com.example.tracking_app_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.tracking_app_project.model.Route;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends ListActivity {

    private List<Route> routeList;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        setActionBar((Toolbar)findViewById(R.id.toolbar));
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        dbAdapter = new DBAdapter(this,DataBaseHelper.Constantes.DB_NAME);
        dbAdapter.open();

        ListView list = (ListView)findViewById(android.R.id.list);

        registerForContextMenu(list);
        dataBind();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            menu.add("Delete All");
            menu.add("Add Route");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            dbAdapter.close();
            this.finish();
        }
        switch (item.getTitle().toString().toUpperCase()){
            case "DELETE ALL":{
                dbAdapter.deleteAll(DataBaseHelper.Constantes.DB_TABLE_ROUTE);
                dataBind();
                break;
            }
            case "ADD ROUTE":{
                routeList = new ArrayList<Route>();

                routeList.add(new Route(1,"Route 1",10,3745,9.612,10));
                routeList.add(new Route(2,"Route 2",2,715,10.044,10));
                routeList.add(new Route(3,"Route 3",22,10327,7.668,10));

                for (Route route: routeList) {
                    dbAdapter.insertItem(route);
                }
                dataBind();
                break;
            }
            default:
                Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void dataBind() {
        try{
            Cursor cursor = dbAdapter.retrieveItemsList(DataBaseHelper.Constantes.DB_TABLE_ROUTE);
            startManagingCursor(cursor);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.minimal_view_statistics,
                    cursor,
                    DataBaseHelper.Constantes.COLUMNS_ROUTE,
                    new int[]{R.id.item_id, R.id.item_name, R.id.item_distance, R.id.item_duration,  R.id.item_average_speed,  R.id.item_waypoints});
            setListAdapter(adapter);
        }catch(Exception e){
            Log.i("[DEBUG]", e.getMessage());
        }

    }
}