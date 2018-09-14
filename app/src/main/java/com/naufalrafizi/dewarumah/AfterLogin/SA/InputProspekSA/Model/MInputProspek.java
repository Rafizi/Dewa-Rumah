package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model;

/**
 * Created by Asus on 9/6/2018.
 */

public class MInputProspek {

    private String sa_prospek,email_prospek,notelp_prospek,nama_prospek,project_prospek;
    private long id;

    public static final String TABLE_NAME = "data_sales_agent";
    public static final String COLUMN_ID = "idProspek";
    public static final String COLUMN_NAME = "namaProspek";
    public static final String COLUMN_PROJECT = "projectProspek";
    public static final String COLUMN_EMAIL = "emailProspek";
    public static final String COLUMN_SA = "saProspek";
    public static final String COLUMN_NO_TELP = "telpProspek";

    public static final String dB_create =
            "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_PROJECT+ " varchar(50) not null, "
            + COLUMN_EMAIL+ " varchar(50) not null, "
            + COLUMN_SA+ " varchar(50) not null, "
            + COLUMN_NO_TELP+ " varchar(50) not null);";



    public MInputProspek(){

    }

    public MInputProspek(int id, String email, String notelp, String sa, String projek, String nama) {
        this.id = id;
        this.nama_prospek = nama;
        this.email_prospek = email;
        this.sa_prospek = sa;
        this.notelp_prospek = notelp;
        this.project_prospek = projek;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_prospek() {
        return nama_prospek;
    }

    public void setNama_prospek(String nama_prospek) {
        this.nama_prospek = nama_prospek;
    }

    public String getProject_prospek() {
        return project_prospek;
    }

    public void setProject_prospek(String project_prospek) {
        this.project_prospek = project_prospek;
    }

    public String getEmail_prospek() {
        return email_prospek;
    }

    public void setEmail_prospek(String email_prospek) {
        this.email_prospek = email_prospek;
    }

    public String getSa_prospek() {
        return sa_prospek;
    }

    public void setSa_prospek(String sa_prospek) {
        this.sa_prospek = sa_prospek;
    }

    public String getNotelp_prospek() {
        return notelp_prospek;
    }

    public void setNotelp_prospek(String notelp_prospek) {
        this.notelp_prospek = notelp_prospek;
    }

}
