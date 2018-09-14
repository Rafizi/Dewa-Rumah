package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;

import java.util.ArrayList;

/**
 * Created by Asus on 9/6/2018.
 */

public class DBDataSource {

    //inisialisasi SQLite
    private SQLiteDatabase database;

    //inisiaslisasi kelas DBHelper
    private DataHelper dbHelper;

    private String [] allcolumn = {

            DataHelper.COLUMN_NAME,
            DataHelper.COLUMN_PROJECT   ,
            DataHelper.COLUMN_SA,
            DataHelper.COLUMN_EMAIL,
            DataHelper.COLUMN_NO_TELP,

    };

    //DataHelper di instansiasikan pada constructor
    public DBDataSource(Context c) {
        dbHelper = new DataHelper(c);
    }

    public void open() throws SQLException {

        database = dbHelper.getWritableDatabase();

    }

    public void close(){

        dbHelper.close();

    }

    public MInputProspek createProspek(String nama, String email, String notelp, String sa, String project) {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database

        ContentValues values = new ContentValues();
        values.put(DataHelper.COLUMN_NAME, nama);
        values.put(DataHelper.COLUMN_EMAIL, email);
        values.put(DataHelper.COLUMN_NO_TELP, notelp);
        values.put(DataHelper.COLUMN_PROJECT, project);
        values.put(DataHelper.COLUMN_SA, sa);

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DataHelper.TABLE_NAME,null,values);

        // setelah data dimasukan, memanggil
        // perintah SQL Select menggunakan cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuakan ID = insertID

        Cursor cursor = database.query(DataHelper.TABLE_NAME, allcolumn, DataHelper.COLUMN_ID + " = "+insertId,
                null,null,null,null);

        // pindah data ke paling pertama
        cursor.moveToFirst();

        // mengubah objek pada cursor pertama tadi
        // ke dalam obejk prospek

        MInputProspek mInputProspek= cursorToProspek(cursor);

        //close cursor
        cursor.close();

        //mengembalikan barang baru
        return mInputProspek;
    }

    private MInputProspek cursorToProspek(Cursor cursor) {

        // buat objek baru
        MInputProspek mInputProspek = new MInputProspek();
        Log.v("info", "The getLong"+ cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));


        /* Set atribut pada objek  prospek dengan
           data kursor yang diambil dari database*/

        mInputProspek.setId(cursor.getLong(0));
        mInputProspek.setNama_prospek(cursor.getString(0));
        mInputProspek.setProject_prospek(cursor.getString(2));
        mInputProspek.setSa_prospek(cursor.getString(1));
        mInputProspek.setEmail_prospek(cursor.getString(3));
        mInputProspek.setNotelp_prospek(cursor.getString(4));

        // kembalikan sebagai objek prospek
        return mInputProspek;
    }

    public ArrayList<MInputProspek> getAllProspek (){
        ArrayList<MInputProspek>daftarProspek = new ArrayList<>();

        // select all SQL Query
        Cursor cursor = database.query(DataHelper.TABLE_NAME,allcolumn,
                null,null,null,null,null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukan data prospek ke daftar prospek
        while (!cursor.isAfterLast()){
            MInputProspek mInputProspek= cursorToProspek(cursor);
            daftarProspek.add(mInputProspek);
            cursor.moveToNext();
        }
        cursor.close();
        return daftarProspek;
    }

    public void delete(long id){

        String strFilter = "idProspek=" + id;
        database.delete(dbHelper.TABLE_NAME,strFilter,null);

    }

}