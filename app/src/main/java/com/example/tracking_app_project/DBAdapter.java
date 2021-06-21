package com.example.tracking_app_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.tracking_app_project.model.User;
import com.example.tracking_app_project.model.Team;
import com.example.tracking_app_project.model.Route;
import com.example.tracking_app_project.model.Waypoint;

import com.example.tracking_app_project.DataBaseHelper.Constantes;

import java.net.ConnectException;
import java.util.List;

/**
 *  Classe permettant d'accéder à la données d'un point de vue
 *  écriture, lecture, mise à jour et suppression de données (CRUD).
 */

public class DBAdapter {

    private DataBaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    private List<Route> routeList;
    private LayoutInflater inflater;

    public DBAdapter(Context context, String databaseName){
        this.context = context;
        dbHelper = new DataBaseHelper(context, databaseName);
    }

    public DBAdapter(Context context, List<Route> list){
        inflater = LayoutInflater.from(context);
        routeList = list;
    }

    public  DBAdapter open() throws SQLiteException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void deleteAll(){
        db.delete(Constantes.DB_TABLE_USER,"1", null);
        db.delete(Constantes.DB_TABLE_TEAM,"1", null);
        db.delete(Constantes.DB_TABLE_ROUTE,"1", null);
        db.delete(Constantes.DB_TABLE_WAYPOINT,"1", null);
    }


    public int deleteAll(String tableName){
         return  db.delete(tableName,"1", null);
    }

    // Les paramètres sont les champs d'un élément à insérer dans la table

    public long insertItem(Object item){

        long insert = 0;

        if(item.getClass().equals(User.class)) {

            ContentValues contentValues = new ContentValues();
            contentValues.put(Constantes.COLUMN_USER_PSEUDO, ((User) item).getPseudo());
            contentValues.put(Constantes.COLUMN_USER_IDTEAM, ((User) item).getTeam());
            contentValues.put(Constantes.COLUMN_USER_PHONE_NUMBER, ((User) item).getPhoneNumber());

            // Créer la requête d'insertion dans la table
            insert = db.insert(Constantes.DB_TABLE_USER, null, contentValues);
        }
        if(item.getClass().equals(Team.class)){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constantes.COLUMN_TEAM_IDUSER, ((Team) item).getTeamLeader());

            // Créer la requête d'insertion dans la table
            insert = db.insert(Constantes.DB_TABLE_TEAM, null, contentValues);
        }
        if(item.getClass().equals(Route.class)){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constantes.COLUMN_ROUTE_NAME, ((Route) item).getRouteName());
            contentValues.put(Constantes.COLUMN_ROUTE_DISTANCE, ((Route) item).getDistance());
            contentValues.put(Constantes.COLUMN_ROUTE_DURATION, ((Route) item).getDuration());
            contentValues.put(Constantes.COLUMN_ROUTE_AVERAGE_SPEED, ((Route) item).getAverageSpeed());
            contentValues.put(Constantes.COLUMN_ROUTE_WAYPOINT_QUANTITY, ((Route) item).getWaypointQuantity());

            // Créer la requête d'insertion dans la table
            insert = db.insert(Constantes.DB_TABLE_ROUTE, null, contentValues);
        }
        if(item.getClass().equals(Team.class)){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constantes.COLUMN_WAYPOINT_NAME, ((Waypoint) item).getWaypointName());
            contentValues.put(Constantes.COLUMN_WAYPOINT_LONGITUDE, ((Waypoint) item).getLongitude());
            contentValues.put(Constantes.COLUMN_WAYPOINT_LATITUDE, ((Waypoint) item).getLatitude());
            contentValues.put(Constantes.COLUMN_WAYPOINT_ALTITUDE, ((Waypoint) item).getAltitude());
            contentValues.put(Constantes.COLUMN_WAYPOINT_IDROUTE, ((Waypoint) item).getRoute());

            // Créer la requête d'insertion dans la table
            insert = db.insert(Constantes.DB_TABLE_WAYPOINT, null, contentValues);
        }
        return insert;
    }

    // L'id est la clé primaire de l'élément à supprimer
    public  boolean deleteItem(long id, String tableName){
        Log.i("DEBUG","DELETE ITEM");

        return db.delete(tableName, " = ?", new String[]{Long.toString(id)})>0;
    }

    // Retourne la liste complète des éléments de la table
    public Cursor retrieveItemsList(String tableName){
        switch(tableName) {
            case "USER":
                return this.db.query(Constantes.DB_TABLE_USER, new String[]{Constantes.COLUMN_USER_ID, Constantes.COLUMN_USER_PSEUDO, Constantes.COLUMN_USER_PHONE_NUMBER, Constantes.COLUMN_USER_IDTEAM}, null, null, null, null, null);
            case "TEAM":
                return this.db.query(Constantes.DB_TABLE_TEAM, new String[]{Constantes.COLUMN_TEAM_ID, Constantes.COLUMN_TEAM_IDUSER}, null, null, null, null, null);
            case "ROUTE":
                return this.db.query(Constantes.DB_TABLE_ROUTE, new String[]{Constantes.COLUMN_ROUTE_ID, Constantes.COLUMN_ROUTE_NAME, Constantes.COLUMN_ROUTE_DISTANCE, Constantes.COLUMN_ROUTE_DURATION, Constantes.COLUMN_ROUTE_AVERAGE_SPEED, Constantes.COLUMN_ROUTE_WAYPOINT_QUANTITY}, null, null, null, null, null);
            case "WAYPOINT":
                return this.db.query(Constantes.DB_TABLE_WAYPOINT, new String[]{Constantes.COLUMN_WAYPOINT_ID, Constantes.COLUMN_WAYPOINT_NAME, Constantes.COLUMN_WAYPOINT_LONGITUDE, Constantes.COLUMN_WAYPOINT_LATITUDE, Constantes.COLUMN_WAYPOINT_ALTITUDE, Constantes.COLUMN_WAYPOINT_IDROUTE}, null, null, null, null, null);
            default:
                return null;
        }
    }

}
