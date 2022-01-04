package com.example.marvelretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marvelretrofit.model.Superhero;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name, realName, team, firstAppearance, createdBy, publisher, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Superhero hero = getIntent().getExtras().getParcelable("Superhero");
        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        realName = findViewById(R.id.realname);
        team = findViewById(R.id.team);
        firstAppearance = findViewById(R.id.firstappearance);
        createdBy = findViewById(R.id.createdby);
        publisher = findViewById(R.id.publisher);
        bio = findViewById(R.id.bio);

        Glide.with(this).load(hero.getImageurl()).into(imageView);
        name.setText(hero.getName());
        realName.setText(hero.getRealName());
        team.setText(hero.getTeam());
        firstAppearance.setText(hero.getFirstappearance());
        createdBy.setText(hero.getCreatedby());
        publisher.setText(hero.getPublisher());
        bio.setText(hero.getBio());
    }
}