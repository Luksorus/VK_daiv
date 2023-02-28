package com.example.vk_it_case.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vk_it_case.R;
import com.example.vk_it_case.recycler.Model;
import com.example.vk_it_case.recycler.recyclerAA;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    ArrayList<Model> models = new ArrayList<>();

    int[] ImageUsers = {R.drawable.erik_warner, R.drawable.ed_snow, R.drawable.nicole_lopez,
                        R.drawable.kayla_cannon,R.drawable.elizabeth_campbell,R.drawable.jessica_cox,
                        R.drawable.pamela_ross,R.drawable.michael_herring,R.drawable.isaac_payne,
                        R.drawable.joseph_williams,R.drawable.jason_tate,R.drawable.terry_brown,
                        R.drawable.jose_owens,R.drawable.stephen_little,R.drawable.rodney_johnson,
                        R.drawable.james_thornton,R.drawable.gerald_reynolds,R.drawable.linda_hall,
                        R.drawable.helen_gardner,R.drawable.lucille_richardson,R.drawable.mary_simpson,
                        R.drawable.joyce_mendoza,R.drawable.james_singleton,R.drawable.linda_hernandez,
                        R.drawable.diane_black};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        RecyclerView recyclerView = findViewById(R.id.recyler_view);

        setModels();

        recyclerAA adapter = new recyclerAA(this, models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setModels(){
        String[] NamesUsers = getResources().getStringArray(R.array.Name_and_surname_for_recycler);
        for (int i =0; i<NamesUsers.length; i++){
            models.add(new Model(NamesUsers[i],ImageUsers[i]));
        }
    }
}
