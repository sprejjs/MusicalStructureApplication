package com.spreys.musicalstructureapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 30/07/16
 *         Project: MusicalStructureApplication
 *         Contact by: vlad@spreys.com
 */
public class ArtistsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        ArrayList<String> artistsList = new ArrayList<>();
        artistsList.add("Eminem");
        artistsList.add("Marilyn Manson");
        artistsList.add("Madonna");
        artistsList.add("Guf");
        artistsList.add("Other");

        ArtistsAdapter adapter = new ArtistsAdapter(artistsList, this);

        RecyclerView rv = (RecyclerView)findViewById(R.id.acitivty_artists_recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {
        List<String> artists;
        Context context;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView artistsName;

            ViewHolder(View itemView) {
                super(itemView);
                artistsName = (TextView)itemView.findViewById(R.id.artist_item_name);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent playIntent = new Intent(context, PlayActivity.class);
                        context.startActivity(playIntent);
                    }
                });
            }
        }

        ArtistsAdapter(List<String> artists, Context context) {
            this.artists = artists;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewItem = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.artist_item, parent, false);

            return new ViewHolder(viewItem);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.artistsName.setText(artists.get(position));
        }

        @Override
        public int getItemCount() {
            return artists.size();
        }
    }
}
