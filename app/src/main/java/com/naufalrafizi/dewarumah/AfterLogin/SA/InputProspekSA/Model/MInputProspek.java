package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model;

/**
 * Created by Asus on 9/6/2018.
 */

public class MInputProspek {

    private String sa_prospek,email_prospek,notelp_prospek,nama_prospek,project_prospek;
    private long id;

    public String toString (){
        return "Prospek \n"+"    Nama Prospek : " + nama_prospek +" \nProject Prospek :"+project_prospek+" \nSA Prospek : "+sa_prospek+
                " \nEmail Prospek : " +email_prospek+" \nNoTelp Prospek : "+notelp_prospek+" ";
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
