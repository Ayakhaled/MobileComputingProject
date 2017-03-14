package com.example.aya.mobilecomputingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private RecyclerView articlesView;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        articles.add(new Article("Title1", "Abstract1"));
        articles.add(new Article("Title2", "Abstract2"));
        articles.add(new Article("Title3", "Abstract3"));
        articles.add(new Article("Title4", "Abstract4"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            startActivity(new Intent(this, Profile.class));
            return true;
        }
        else if(id == R.id.action_logout){
            startActivity(new Intent(this, Landing.class));
            return true;
        }
        else if(id == R.id.action_home){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
