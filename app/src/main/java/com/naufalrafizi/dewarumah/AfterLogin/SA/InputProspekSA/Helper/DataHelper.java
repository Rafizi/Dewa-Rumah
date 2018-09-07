package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Asus on 9/6/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

    /** deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     nama-nama kolom, nama database, dan versi dari database **/
    public static final String TABLE_NAME = "data_sales_agent";
    public static final String COLUMN_ID = "idProspek";
    public static final String COLUMN_NAME = "namaProspek";
    public static final String COLUMN_PROJECT = "projectProspek";
    public static final String COLUMN_EMAIL = "emailProspek";
    public static final String COLUMN_SA = "saProspek";
    public static final String COLUMN_NO_TELP = "telpProspek";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;


    private static final String dB_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_PROJECT+ " varchar(50) not null, "
            + COLUMN_EMAIL+ " varchar(50) not null, "
            + COLUMN_SA+ " varchar(50) not null, "
            + COLUMN_NO_TELP+ " varchar(50) not null);";

    public DataHelper(Context context){
        super(context,db_name,null,db_version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dB_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataHelper.class.getName(),"Upgrading database from version " + oldVersion + " to " + newVersion +", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
