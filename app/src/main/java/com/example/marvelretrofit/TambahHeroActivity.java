package com.example.marvelretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.marvelretrofit.model.DataMock;
import com.example.marvelretrofit.model.Superhero;
import com.example.marvelretrofit.service.JsonPlaceHolderRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahHeroActivity extends AppCompatActivity {

    EditText editName,editRealName;
    ListView superListView;
//    Button btnTambahNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hero);
        editName = findViewById(R.id.editName);
        editRealName = findViewById(R.id.editRealName);
        superListView = findViewById(R.id.superListView2);
        getDataMock();
    }

    public void getDataMock(){
        Call<List<DataMock>> call = JsonPlaceHolderRetrofitClient.getInstance().getMyApi().getDataMock();
        call.enqueue(new Callback<List<DataMock>>() {
            @Override
            public void onResponse(Call<List<DataMock>> call, Response<List<DataMock>> response) {
                List<DataMock> data = response.body();
                String[] oneHeroes = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {
                    oneHeroes[i] = data.get(i).getTitle();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));

            }

            @Override
            public void onFailure(Call<List<DataMock>> call, Throwable t) {

            }
        });
    }

    public void tambahNow(View view) {

        String name = editName.getText().toString();
        String realName = editRealName.getText().toString();

        Superhero hero = new Superhero();
        hero.setName(name);
        hero.setRealname(realName);

        Call<Superhero> call = JsonPlaceHolderRetrofitClient.getInstance().getMyApi().addSuperHero(hero);
        call.enqueue(new Callback<Superhero>() {
            @Override
            public void onResponse(Call<Superhero> call, Response<Superhero> response) {
                Superhero heroResponse = response.body();
                System.out.println(heroResponse);
            }

            @Override
            public void onFailure(Call<Superhero> call, Throwable t) {

            }
        });


    }
}