package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 9/6/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String db_name = "inventori.db";
    private static final int db_version = 1;


    public DataHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MInputProspek.dB_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + MInputProspek.TABLE_NAME);
        onCreate(db);
    }

    public long createProspek(String nama, String email, String notelp, String sa, String project) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MInputProspek.COLUMN_NAME, nama);
        values.put(MInputProspek.COLUMN_EMAIL, email);
        values.put(MInputProspek.COLUMN_NO_TELP, notelp);
        values.put(MInputProspek.COLUMN_PROJECT, project);
        values.put(MInputProspek.COLUMN_SA, sa);

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = db.insert(MInputProspek.TABLE_NAME, null, values);

        // setelah data dimasukan, memanggil
        // perintah SQL Select menggunakan cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuakan ID = insertID


        // mengubah objek pada cursor pertama tadi
        // ke dalam obejk prospek

        db.close();

        //mengembalikan barang baru
        return insertId;
    }

    public MInputProspek getProspek(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(MInputProspek.TABLE_NAME,
                new String[]{
                        MInputProspek.COLUMN_ID,
                        MInputProspek.COLUMN_NAME,
                        MInputProspek.COLUMN_EMAIL,
                        MInputProspek.COLUMN_NO_TELP,
                        MInputProspek.COLUMN_PROJECT,
                        MInputProspek.COLUMN_SA,},
                MInputProspek.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        MInputProspek note = new MInputProspek(
                cursor.getInt(cursor.getColumnIndex(MInputProspek.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_EMAIL)),
                cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NO_TELP)),
                cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_PROJECT)),
                cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_EMAIL))
        );

        // close the db connection
        cursor.close();

        return note;
    }

//    private MInputProspek cursorToProspek(Cursor cursor) {
//
//        // buat objek baru
//        MInputProspek mInputProspek = new MInputProspek();
//        Log.v("info", "The getLong" + cursor.getLong(0));
//        Log.v("info", "The setLatLng " + cursor.getString(1) + "," + cursor.getString(2));
//
//
//        /* Set atribut pada objek  prospek dengan
//           data kursor yang diambil dari database*/
//
//        mInputProspek.setId(cursor.getLong(0));
//        mInputProspek.setNama_prospek(cursor.getString(0));
//        mInputProspek.setProject_prospek(cursor.getString(2));
//        mInputProspek.setSa_prospek(cursor.getString(1));
//        mInputProspek.setEmail_prospek(cursor.getString(3));
//        mInputProspek.setNotelp_prospek(cursor.getString(4));
//
//        // kembalikan sebagai objek prospek
//        return mInputProspek;
//    }

    public List<MInputProspek> getAllProspek() {
        List<MInputProspek> daftarProspek = new ArrayList<>();

        // select all SQL Query
        String selectQuery = "SELECT  * FROM " + MInputProspek.TABLE_NAME + " ORDER BY "
                + MInputProspek.COLUMN_NAME
                + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MInputProspek note = new MInputProspek();
                note.setId(cursor.getInt(cursor.getColumnIndex(MInputProspek.COLUMN_ID)));
                note.setNama_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NAME)));
                note.setEmail_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_EMAIL)));
                note.setNotelp_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NO_TELP)));
                note.setSa_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_SA)));
                note.setProject_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_PROJECT)));

                daftarProspek.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return daftarProspek;
    }

    public List<String> getName(){
        List<String> daftarProspek = new ArrayList<>();

        // select all SQL Query
        String selectQuery = "SELECT " +MInputProspek.COLUMN_NAME+  " FROM " + MInputProspek.TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                daftarProspek.add(cursor.getString(cursor.getColumnIndex("namaProspek")));
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return daftarProspek;
    }

    public List<MInputProspek>getSearchByName (String name){
        List<MInputProspek> daftarProspek = new ArrayList<>();

        // select all SQL Query
        String sql="SELECT * FROM "+MInputProspek.TABLE_NAME+" WHERE "+MInputProspek.COLUMN_NAME+" LIKE '%"+name+"%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MInputProspek note = new MInputProspek();
                note.setId(cursor.getInt(cursor.getColumnIndex(MInputProspek.COLUMN_ID)));
                note.setNama_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NAME)));
                note.setEmail_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_EMAIL)));
                note.setNotelp_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_NO_TELP)));
                note.setSa_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_SA)));
                note.setProject_prospek(cursor.getString(cursor.getColumnIndex(MInputProspek.COLUMN_PROJECT)));

                daftarProspek.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return daftarProspek;
    }
    public int getProjectCount() {
        String countQuery = "SELECT  * FROM " + MInputProspek.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
    public int update(MInputProspek p) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MInputProspek.COLUMN_NAME, p.getNama_prospek());
        values.put(MInputProspek.COLUMN_EMAIL, p.getEmail_prospek());
        values.put(MInputProspek.COLUMN_NO_TELP, p.getNotelp_prospek());
        values.put(MInputProspek.COLUMN_SA, p.getSa_prospek());
        values.put(MInputProspek.COLUMN_PROJECT, p.getProject_prospek());

        // updating row
        return db.update(MInputProspek.TABLE_NAME, values, MInputProspek.COLUMN_ID + " = ?",
                new String[]{String.valueOf(p.getId())});
    }

    public void delete(MInputProspek id) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MInputProspek.TABLE_NAME, MInputProspek.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id.getId())});
        db.close();

    }
}
