package com.spreys.musicalstructureapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        findViewById(R.id.activity_main_shuffle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shuffleIntent = new Intent(context, PlayActivity.class);
                startActivity(shuffleIntent);
            }
        });

        findViewById(R.id.activity_main_artists).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(context, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        findViewById(R.id.activity_main_store).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent storeIntent = new Intent(context, StoreActivity.class);
                startActivity(storeIntent);
            }
        });
    }
}
