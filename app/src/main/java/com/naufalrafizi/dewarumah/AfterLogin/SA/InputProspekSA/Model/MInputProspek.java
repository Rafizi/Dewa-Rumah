package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model;

/**
 * Created by Asus on 9/6/2018.
 */

public class MInputProspek {

    private String sa_prospek,email_prospek,notelp_prospek,nama_prospek,project_prospek;

    private int id;

    public MInputProspek(int id, String nama,String project, String email, String notelp, String sa){

        this.id = id;
        this.nama_prospek = nama;
        this.project_prospek = project;
        this.email_prospek = email;
        this.notelp_prospek = notelp;
        this.sa_prospek= sa;

    }

    public MInputProspek() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
