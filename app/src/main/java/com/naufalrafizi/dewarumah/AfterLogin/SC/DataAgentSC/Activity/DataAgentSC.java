package com.naufalrafizi.dewarumah.AfterLogin.SC.DataAgentSC.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.SC.DataAgentSC.Adapter.RecyclerViewAdapterDataAgentSC;
import com.naufalrafizi.dewarumah.R;

public class DataAgentSC extends AppCompatActivity {

    RecyclerViewAdapterDataAgentSC rvAdapterSC;

    String [] namaAgent = {

            "Agus Sutanto",
            "Dara Layla",
            "Zoro Topeng"

    };

    String [] projectAgent = {

            "River Villa",
            "Ayana",
            "Spring"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_agent_sc);

        setUpRecylerView();

    }

    private void setUpRecylerView() {

        RecyclerView rvDataAgentSC = (RecyclerView) findViewById(R.id.rvListDataAgentSC);
        rvDataAgentSC.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterSC = new RecyclerViewAdapterDataAgentSC(getApplication(),namaAgent,projectAgent);
        rvDataAgentSC.setAdapter(rvAdapterSC);


    }

}
