package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.SimpleOnSearchActionListener;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter.RecyclerViewAdapterProspekSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class ProspekActivitySA extends AppCompatActivity {

    //inisialisasi kontroler
    DataHelper dbHelper;

    RecyclerView rvProspek;
    MInputProspek mprospek;
    //inisialisasi arraylist
    List<MInputProspek> mList = new ArrayList<>();
    List<String>sList = new ArrayList<>();
    MInputProspek p;
    TextView emptyTxt;
    MaterialSearchBar sProspek;

    RecyclerViewAdapterProspekSA rvAdapterProspek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospek_sa);
        //inisialisasi widget
        dbHelper = new DataHelper(this);
        p = new MInputProspek();
        emptyTxt = (TextView)findViewById(R.id.empty_notes_view);
        sProspek = (MaterialSearchBar)findViewById(R.id.searchProspek);

        sProspek.setHint("Search");
        sProspek.setCardViewElevation(10);
        loadsuggestlistsearch();
        sProspek.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String search =null;
                if (search != null && !search.isEmpty()){
                    List<String>suggest = new ArrayList<>();
                    for (String ssearch : sList)
                    {
                        if (search.toLowerCase().contains(sProspek.getText().toString()))
                            suggest.add(ssearch);


                    }
                    RecyclerViewAdapterProspekSA adapter = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
                    rvProspek.setAdapter(adapter);
                }
                else {
                    RecyclerViewAdapterProspekSA adapter = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
                    rvProspek.setAdapter(adapter);
                }
            }



            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        sProspek.setOnSearchActionListener(new SimpleOnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled)
                    rvProspek.setAdapter(rvAdapterProspek);
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {
                super.onButtonClicked(buttonCode);
            }
        });



        mList.addAll(dbHelper.getAllProspek());


        toggleEmptyNotes();
        //buka kontroler


        //ambil semua data barang
//        mList= dataSource.getAllProspek();


        rvProspek = (RecyclerView)findViewById(R.id.rvProspek);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvProspek.setLayoutManager(manager);

        rvAdapterProspek = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
        rvProspek.setAdapter(rvAdapterProspek);



    }

    private void startSearch(String text) {
        rvAdapterProspek = new RecyclerViewAdapterProspekSA(this,dbHelper.getSearchByName(text));
        rvProspek.setAdapter(rvAdapterProspek);
    }

    private void loadsuggestlistsearch() {
        sList = dbHelper.getName();
//        sProspek.setLastSuggestions(sList);
    }

    private void toggleEmptyNotes() {
        // you can check notesList.size() > 0

        if (dbHelper.getProjectCount() > 0) {
            emptyTxt.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.VISIBLE);
        }
    }
}
