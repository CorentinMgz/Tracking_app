package com.example.tracking_app_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

/**
 *  Classe qui permet de créer "physiquement" la bdd SQL Lite
 *  sur le "device" (smartphone, tablette...)
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static class Constantes implements BaseColumns{

        public static final String DB_NAME = "tracking_app";
        public static final int DB_VERSION = 1;
        public static final String DB_TABLE_USER = "USER";
        public static final String DB_TABLE_TEAM = "TEAM";
        public static final String DB_TABLE_ROUTE = "ROUTE";
        public static final String DB_TABLE_WAYPOINT = "WAYPOINT";
        public static final String[] COLUMNS_USER = {
                "_id",
                "pseudo",
                "_id_team",
                "phoneNumber"
        };
        public static final String[] COLUMNS_TEAM = {
                "_id",
                "_id_user"
        };
        public static final String[] COLUMNS_ROUTE = {
                "_id",
                "route_name",
                "distance",
                "duration",
                "average_speed",
                "waypoint_quantity"
        };
        public static final String[] COLUMNS_WAYPOINT = {
                "_id",
                "waypoint_name",
                "longitude",
                "latitude",
                "altitude"
        };

        // Table User
        public static final String COLUMN_USER_ID = "_id";
        public static final String COLUMN_USER_PSEUDO = "pseudo";
        public static final String COLUMN_USER_IDTEAM = "_id_team";
        public static final String COLUMN_USER_PHONE_NUMBER = "phone_number";

        // Table Team
        public static final String COLUMN_TEAM_ID = "_id";
        public static final String COLUMN_TEAM_IDUSER = "_id_user";

        // Table Route
        public static final String COLUMN_ROUTE_ID = "_id";
        public static final String COLUMN_ROUTE_NAME = "route_name";
        public static final String COLUMN_ROUTE_DISTANCE = "distance";
        public static final String COLUMN_ROUTE_DURATION = "duration";
        public static final String COLUMN_ROUTE_AVERAGE_SPEED = "average_speed";
        public static final String COLUMN_ROUTE_WAYPOINT_QUANTITY = "waypoint_quantity";

        // Table Waypoint
        public static final String COLUMN_WAYPOINT_ID = "_id";
        public static final String COLUMN_WAYPOINT_NAME = "waypoint_name";
        public static final String COLUMN_WAYPOINT_LONGITUDE = "longitude";
        public static final String COLUMN_WAYPOINT_LATITUDE = "latitude";
        public static final String COLUMN_WAYPOINT_ALTITUDE = "altitude";
        public static final String COLUMN_WAYPOINT_IDROUTE = "_id_route";
    }


    private Context context;

    public DataBaseHelper(Context context, String databaseName){
        super(context, databaseName, null, Constantes.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User (" + Constantes.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.COLUMN_USER_PSEUDO + " TEXT, " + Constantes.COLUMN_USER_IDTEAM + " INTEGER, " + Constantes.COLUMN_USER_PHONE_NUMBER + " TEXT)");
        System.out.printf("Base User créée");
        db.execSQL("CREATE TABLE Team (" + Constantes.COLUMN_TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.COLUMN_TEAM_IDUSER + " INTEGER)");
        System.out.printf("Base Group créée");
        db.execSQL("CREATE TABLE Route (" + Constantes.COLUMN_ROUTE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.COLUMN_ROUTE_NAME + " TEXT, " + Constantes.COLUMN_ROUTE_DISTANCE + " INTEGER, " + Constantes.COLUMN_ROUTE_DURATION + " INTEGER, " + Constantes.COLUMN_ROUTE_AVERAGE_SPEED + " REAL, " + Constantes.COLUMN_ROUTE_WAYPOINT_QUANTITY +" INTEGER)");
        System.out.printf("Base Route créée");
        db.execSQL("CREATE TABLE Waypoint (" + Constantes.COLUMN_WAYPOINT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.COLUMN_WAYPOINT_NAME + " TEXT, " + Constantes.COLUMN_WAYPOINT_LONGITUDE + " REAL, " + Constantes.COLUMN_WAYPOINT_LATITUDE + " REAL, " + Constantes.COLUMN_WAYPOINT_ALTITUDE + " REAL, " + Constantes.COLUMN_WAYPOINT_IDROUTE + " INTEGER)");
        System.out.printf("Base Waypoint créée");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "Mise à jour de la BDD version" + oldVersion + " vers " + newVersion, Toast.LENGTH_LONG).show();
        db.execSQL("drop table if exists " + Constantes.DB_TABLE_USER + " ");
        db.execSQL("drop table if exists " + Constantes.DB_TABLE_TEAM + " ");
        db.execSQL("drop table if exists " + Constantes.DB_TABLE_ROUTE + " ");
        db.execSQL("drop table if exists " + Constantes.DB_TABLE_WAYPOINT + " ");
        onCreate(db);
    }
}
