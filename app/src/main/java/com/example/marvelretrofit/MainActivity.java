package com.example.marvelretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marvelretrofit.model.Superhero;
import com.example.marvelretrofit.service.RetrofitClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Superhero> myheroList;
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superListView  = findViewById(R.id.superListView);
        getSuperHeroes();
    }

    private void getSuperHeroes() {

        Call<List<Superhero>> call = RetrofitClient.getInstance().getMyApi().getSembarangan();
        call.enqueue(new Callback<List<Superhero>>() {
            @Override
            public void onResponse(Call<List<Superhero>> call, Response<List<Superhero>> response) {
                myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));

                //Create the listener
                AdapterView.OnItemClickListener itemClickListener =
                        new AdapterView.OnItemClickListener(){
                            public void onItemClick(AdapterView<?> listDrinks,
                                                    View itemView,
                                                    int position,
                                                    long id) {
//Pass the drink the user clicks on to DrinkActivity
                                Intent intent = new Intent(MainActivity.this,
                                        DetailActivity.class);
//                                Superhero paket = new Superhero("Dono","Anu","Tessy","889","Eyang Syubur","999","90","S");
                                intent.putExtra("Superhero", myheroList.get(position));
                                System.out.println("Nama anunya"+myheroList.get(position).getName());
                                startActivity(intent);
                            }
                        };
//Assign the listener to the list view
                superListView.setOnItemClickListener(itemClickListener);
            }

            @Override
            public void onFailure(Call<List<Superhero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

    public void tambahHero(View view) {
        Intent intent = new Intent(this,TambahHeroActivity.class);
        startActivity(intent);
    }
}